package com.user.account.remote;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@FeignClient(name = "${user.base-pre:14}user-base")
@RequestMapping(value = "/permission")
public interface AreaFeignService {

    @RequestMapping(value = "/doTest14",method = RequestMethod.POST)
    @ResponseBody
    CodeMsg doUploadPermission14(@RequestBody Permission permission);
}
