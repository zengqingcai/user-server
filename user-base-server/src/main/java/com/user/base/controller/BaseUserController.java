package com.user.base.controller;

import com.github.pagehelper.PageInfo;
import com.user.base.common.CommonPage;
import com.user.base.common.RequestBean;
import com.user.base.common.ResponseBean;
import com.user.base.config.RedisUtil;
import com.user.base.entity.model.User;
import com.user.base.remote.UserBaseFeignService;
import com.user.base.remote.entity.baseUser.response.UserInfoQueryRes;
import com.user.common.exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Authod:zeng
 * @Date: 2020/6/16 9:24
 * @Version: 0.0.1
 */
@Controller
@RequestMapping("/base/user")
public class BaseUserController {

    @Autowired
    private UserBaseFeignService userBaseFeignService;

    @RequestMapping(value = "/userList")
    @ResponseBody
    public Object baseUserList(User user, ModelMap modelMap) {
        try {
            Map<String,Object> map = new HashMap<>();
            map.put("currentPage",1);
            map.put("pageSize",10);
            PageInfo<UserInfoQueryRes> responseBean = userBaseFeignService.queryUserInfoByParams(map);
            if(responseBean == null)
                throw new BusinessException("-1","网络异常");
            PageInfo<UserInfoQueryRes> pageInfo = responseBean;
            List<UserInfoQueryRes> list = pageInfo.getList();
            CommonPage page = CommonPage.setPageModel(pageInfo);
            modelMap.put("userList",list);
            modelMap.put("page",page);
            return null;
        } catch (BusinessException e){
            e.printStackTrace();
            return "BusinessException";
        } catch (Exception e){
            e.printStackTrace();
            return "error:Exception";
        }
    }
}
