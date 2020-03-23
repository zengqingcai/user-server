//package com.user.app.filter;
//
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.util.HashMap;
//import java.util.Map;
//import javax.servlet.Filter;
//import javax.servlet.FilterChain;
//import javax.servlet.FilterConfig;
//import javax.servlet.ServletException;
//import javax.servlet.ServletRequest;
//import javax.servlet.ServletResponse;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import net.sf.json.JSONObject;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import redis.clients.jedis.JedisCluster;
//
///**
// * H5 token登录拦截
// * @author 曾庆财
// *
// */
//@WebFilter(filterName = "HttpServletRequestFilter", urlPatterns = {"/aliance/*"})
//@Service
//public class HttpServletRequestFilter implements Filter {
//
//    private Logger logger = LoggerFactory.getLogger(HttpServletRequestFilter.class);
//
//    @Autowired
//    private JedisCluster jedisCluster;
//
//    @Autowired
//    private Cycling2bAlianceLoginRecordService cycling2bAlianceLoginRecordService;
//
//    @Autowired
//    private CyclingAlianceService cyclingAlianceService;
//
//    @Autowired
//    private RedisComponent redisComponent;
//
//    @Override
//    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
//            throws IOException, ServletException {
//
//        HttpServletRequest request = (HttpServletRequest)servletRequest;
//        HttpServletResponse response = (HttpServletResponse) servletResponse;
//        response.setHeader("Access-Control-Allow-Origin", "*");
//        response.setHeader("Access-Control-Allow-Credentials", "true");
//        response.setHeader("Access-Control-Allow-Methods", "*");
//        response.setHeader("Access-Control-Allow-Headers", "Content-Type,Access-Token");
//        response.setHeader("Access-Control-Expose-Headers", "*");
//        response.setContentType("application/json;charset=UTF-8");
//
//        if("OPTIONS".equalsIgnoreCase(request.getMethod())) {
//            filterChain.doFilter(request, response);
//            return;
//        }
//
//        if (!(request instanceof HttpServletRequest)) {
//            filterChain.doFilter(request, response);
//            return;
//        }
//
//        //不需要拦截加盟商模块的url
//        String servletUrl = ((HttpServletRequest) request).getServletPath();
//        logger.info("==================加盟商H5拦截请求路径:"+servletUrl+"=============");
//        String[] urlList = ignoreUrlList();
//        for(String urlStr:urlList) {
//            if(servletUrl.indexOf(urlStr)>-1) {
//                logger.info("==================当前请求免拦截:"+servletUrl+"=============");
//                filterChain.doFilter(request, response);
//                return;
//            }
//        }
//        //处理post请求
//        BodyHttpServletRequestWrapper requestWrapper= new BodyHttpServletRequestWrapper(request);
//        String bodyString=getBodyString(requestWrapper.getReader());
//        RqHead rqHead=new RqHead();
//        RqBody rqBody=new RqBody();
//        if(!bodyString.isEmpty()){
//            JSONObject jsonObject=JSONObject.fromObject(bodyString);
//            rqHead= (RqHead) JSONObject.toBean(JSONObject.fromObject(jsonObject.get("requestHead")), RqHead.class);
//            JSONObject object=JSONObject.fromObject(jsonObject.get("requestBody"));
//            Map<String,String> bodyMap= (Map<String, String>) object.get("data");
//            //token为空
//            String token = rqHead.getToken();
//            if(!StringUtils.isEmpty(token)) {
//                String userAccountJson =jedisCluster.get(H5Constants.H5LOGINTOKEN + token);
//                if(StringUtils.isEmpty(userAccountJson)) {
//                    Map<String,Object> params = new HashMap<>();
//                    params.put("token", token);
//                    Cycling2bAlianceLoginRecordDO record = cycling2bAlianceLoginRecordService.selectByParams(params);
//
//                    //从数据库中查询，再放在redis中
//                    if(record!=null) {
//                        Cycling2bAlianceDO aliance = this.cyclingAlianceService.queryByPhone(record.getPhone());
//                        String json =JSONObject.fromObject(aliance).toString();
//                        jedisCluster.setex(H5Constants.H5LOGINTOKEN + token, 604800, json);
//                        //正常的业务跳转跳转
//                        filterChain.doFilter(requestWrapper, response);
//                        return;
//                    }
//                    if(bodyMap!=null) {
//                        String openId = bodyMap.get("openId");
//                        if (openId != null) {
//                            jedisCluster.del(AredisContants.LOGIN_TOKEN + openId);
//                        }
//                    }
//
//                    this.loginForbidden((HttpServletResponse) response,token);
//                    return;
//                }
//
//                //刷新token过期时间
//                jedisCluster.setex(H5Constants.H5LOGINTOKEN + token, 604800, userAccountJson);
//            }else {
//                logger.info("=======token为空，请重新登录============");
//                this.loginForbidden((HttpServletResponse) response,token);
//                return;
//            }
//        }
//        //正常的业务跳转
//        filterChain.doFilter(requestWrapper, response);
//    }
//
//    public String getBodyString(BufferedReader bf) throws IOException {
//        String inputLine;
//        String str="";
//        try {
//            while ((inputLine=bf.readLine())!=null) {
//                str+=inputLine;
//            }
//        }catch (Exception e){
//            logger.info("####LoginFilter获取请求信息失败{}",e.getMessage());
//        }finally {
//            bf.close();
//
//        }
//        return str;
//    }
//
//
//    /**
//     * 返回用户未登录
//     * @param response
//     */
//    private void loginForbidden(HttpServletResponse response,String token) {
//
//        RsHead rsHead = new RsHead();
//        RsBody rsBody = new RsBody<>();
//        rsBody.setCode(Status.LOGIN.getName());
//        rsBody.setMessage("您的账号在其他手机登录，请重新登录");
//        ResponseBean responseBean = new ResponseBean(rsHead, rsBody);
//
//        response.setCharacterEncoding("UTF-8");
//        response.setContentType("application/json; charset=utf-8");
//        response.setHeader("Access-Control-Allow-Origin", "*");
//        PrintWriter printWriter = null;
//        try {
//            printWriter = response.getWriter();
//            printWriter.write(JSONObject.fromObject(responseBean).toString());
//            printWriter.flush();
//
//        } catch (IOException e) {
//            logger.info("----返回异常----");
//            e.printStackTrace();
//
//        } finally {
//            if (printWriter != null) {
//                printWriter.close();
//            }
//        }
//
//        String openId=redisComponent.get(token);
//        redisComponent.delete(token+openId);
//    }
//
//    @Override
//    public void destroy() {
//        //预留
//    }
//
//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException {
//        //预留
//    }
//
//    /**
//     * 指定不需要拦截的请求url路径
//     * @return
//     */
//    private String[] ignoreUrlList(){
//        String[] array = {"/aliance-to-login",
//                "/aliance-get-sms",
//                "/aliance-login",
//                "/aliance-logout",
//                "/aliance-authUrlPage",
//                "/aliance-userAuthPageCallback",
//                "/aliance-userAuthPageRefresh",
//                "/aliance-apply",
//                "/query-opendId"};
//        return array;
//    }
//
//}
