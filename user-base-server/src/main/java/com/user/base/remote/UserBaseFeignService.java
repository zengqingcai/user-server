package com.user.base.remote;

import com.github.pagehelper.PageInfo;
import com.user.base.common.RequestBean;
import com.user.base.common.ResponseBean;
import com.user.base.remote.entity.baseUser.response.UserInfoQueryRes;
import com.user.common.exception.BusinessException;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * @Authod:zeng
 * @Date: 2020/6/15 17:55
 * @Version: 0.0.1
 * 普通用户
 */
@Profile("!mock")
@FeignClient(name = "user-general",fallback = UserBaseFallback.class)
public interface UserBaseFeignService {

    @RequestMapping(value = "/userBase/queryUserInfoByParams",method = RequestMethod.POST)
    @ResponseBody
    PageInfo<UserInfoQueryRes> queryUserInfoByParams(Map<String,Object> requestBean);

}
