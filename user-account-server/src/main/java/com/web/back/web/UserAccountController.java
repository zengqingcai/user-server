package com.web.back.web;

import com.user.account.remote.AreaFeignService;
import com.user.account.remote.CodeMsg;
import com.user.account.remote.Permission;
import com.web.back.comm.ResponseBean;
import com.web.back.remote.AreaFeignService;
import com.web.back.remote.CodeMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.user.account.comm.RequestBean;
import com.user.account.comm.ResponseBean;
import com.user.account.entity.model.UserAccount;
import com.user.account.service.UserAccountService;

import io.swagger.annotations.ApiOperation;

import org.apache.log4j.Logger;

@RestController
@RequestMapping("/user/account")
public class UserAccountController {
	
	private Logger logger = Logger.getLogger(UserAccountController.class);
	
    @Autowired
    private UserAccountService userAccountService;

    @ApiOperation(value = "测试用户账户")
    @RequestMapping(value = "/findById", method = RequestMethod.POST)
    @ResponseBody
    public ResponseBean<UserAccount> findById(@RequestBody RequestBean<Integer> requestBean) {
    	UserAccount userAccount = userAccountService.findById(1);

		userAccountService.findPage(userAccount);
    	ResponseBean<UserAccount> responseBean = new ResponseBean<>();
    	responseBean.setItem(userAccount);
    	responseBean.setCode(1);
    	responseBean.setMessage("success");
    	logger.info("-=============被远程用户微服务调用测试日志====================");
    	return responseBean;
    }


    @Autowired
    private AreaFeignService areaFeignService;

	@ApiOperation(value = "测试用户账户doUploadPermission14")
	@RequestMapping(value = "/dotest", method = RequestMethod.POST)
	@ResponseBody
	public CodeMsg doUploadPermission14(@RequestBody Permission permission){
		return areaFeignService.doUploadPermission14(permission);
	}
}