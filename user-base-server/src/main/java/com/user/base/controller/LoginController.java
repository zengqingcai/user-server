package com.user.base.controller;

import com.user.base.comm.CodeMsg;
import com.user.base.comm.RequestBean;
import com.user.base.comm.ResponseBean;
import com.user.base.entity.model.Permission;
import com.user.base.entity.model.Role;
import com.user.base.entity.model.User;
import com.user.base.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;



    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    /**
     *
     * @return
     */
    @RequestMapping(value = "/doLogin", method = RequestMethod.GET)
    public ResponseBean<User> doLogin(@RequestBody RequestBean<User> requestBean) {
        User user = requestBean.getData();
        //添加用户认证信息
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken uToken = new UsernamePasswordToken(user.getUsercode(), user.getPassword());
        uToken.setRememberMe(true);
        try {
            //进行验证，报错返回首页，不报错到达成功页面。
            subject.login(uToken);
        } catch (UnknownAccountException e) {
            return ResponseBean.error(new CodeMsg("1000","用户不存在"),null);
        } catch (IncorrectCredentialsException e) {
            return ResponseBean.error(new CodeMsg("1000","密码错误"),null);
        }
        //将权限信息保存到session中
        List<User> users = userService.queryUserByParams(user);
//        List<Permission> permissions = new ArrayList<>();
//        for (Role role : user.getRoles()) {
//            for (Permission permission : role.getPermissions()) {
//                permissions.add(permission);
//            }
//        }
//        Map<String, ArrayList<Permission>> map = new HashMap<String, ArrayList<Permission>>();
//        for (Permission p : permissions) {
//            String name = p.getPermission_group_name();
//            if (!map.containsKey(name)) {
//                ArrayList<Permission> mList = new ArrayList<Permission>();
//                mList.add(p);
//                map.put(name, mList);
//            } else {
//                ArrayList<Permission> pList = map.get(name);
//                pList.add(p);
//                map.put(name, pList);
//            }
//        }
//        创建session
        Session session = subject.getSession();
//        保存userinfo的基本信息
        //int uid = user.getUid();
        //UserInfo userInfo = sd.queryuserinfo(uid);
        //保存user信息
        session.setAttribute("user", users.get(0));
        //session.setAttribute("rolename", rolename);
        //session.setAttribute("userinfo", userInfo);
        //session.setAttribute("maps", map);
//        保存用户的基本信息
       return ResponseBean.success(CodeMsg.SUCCESS,users.get(0));
    }

}
