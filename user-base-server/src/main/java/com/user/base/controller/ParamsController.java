package com.user.base.controller;

import com.github.pagehelper.PageInfo;
import com.user.base.comm.CodeMsg;
import com.user.base.comm.CommonPage;
import com.user.base.entity.model.Params;
import com.user.base.service.ParamsService;
import com.user.common.utils.moth.BigDecimalUtils;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

/**
 * @Authod:zeng
 * @Date: 2020/2/26 13:58
 * @Version: 0.0.1
 * 系统参数
 */
@Controller
@RequestMapping("/params")
@Api(value = "角色管理", description = "角色管理接口")
public class ParamsController {

    @Autowired
    private ParamsService paramsService;

    @RequestMapping(value = "/paramsList")
    public String paramsList(Params params, ModelMap modelMap,HttpServletRequest request)throws Exception{
        PageInfo<Params> pageInfo = paramsService.findPage(params);
        List<Params> list = pageInfo.getList();
        CommonPage page = CommonPage.setPageModel(pageInfo);
        modelMap.put("selectModel",params);
        modelMap.put("paramsList",list);
        modelMap.put("page",page);

        return "system/params_list";
    }

    private String getRequestBody(HttpServletRequest request)throws Exception{
        try (BufferedInputStream bis = new BufferedInputStream(request.getInputStream());
             ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            byte[] buffer = new byte[1024];
            int len;
            while ((len = bis.read(buffer)) > 0) {
                baos.write(buffer, 0, len);
            }
            byte[] bytes = baos.toByteArray();
            String body = new String(bytes);
            return body;
        } catch (IOException ex) {
            throw ex;
        }
    }

    //
    @RequestMapping(value = "/toAddPage")
    public String toAddPage(HttpServletRequest request, ModelMap modelMap){
        if(request.getParameter("id")!=null && !request.getParameter("id").equals("")) {
            Integer id = Integer.parseInt(request.getParameter("id"));
            modelMap.put("params",paramsService.selectById(id));
        }else {
            modelMap.put("params",new Params());
        }
        return "system/params_edit";
    }

    @RequestMapping(value = "/doSaveParams")
    @ResponseBody
    public CodeMsg doSaveParams(@RequestBody Params params){
        if(params == null)
            return null;
        //添加
        return paramsService.saveParams(params);
    }

    @RequestMapping(value = "/doUpdateParams")
    @ResponseBody
    public CodeMsg doUpdateParams(@RequestBody Params params){
        if(params == null)
            return null;
        //添加
        return paramsService.updateParams(params);
    }


}
