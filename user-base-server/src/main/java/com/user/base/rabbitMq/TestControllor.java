package com.user.base.rabbitMq;


import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

//@Controller
public class TestControllor {

    @Autowired
    private MQSender mqSender;


    @RequestMapping(value = "rabbit-test",method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "rabbit测试")
    public String receiveUserInfo(@RequestBody String st)throws Exception{

        mqSender.send(""+st);
        return null;
    }



    @RequestMapping(value = "rabbit-topic-test",method = RequestMethod.POST)
    @ApiOperation(value = "rabbit测试")
    public String rabbittopictest(@RequestBody String st)throws Exception{

        mqSender.sendTopic(""+st);
        return null;
    }

    @RequestMapping(value = "rabbit-fanout-test",method = RequestMethod.POST)
    @ApiOperation(value = "rabbit测试")
    public String rabbitgg(@RequestBody(required = false) String st)throws Exception{

        mqSender.sendFanout(""+st);
        return null;
    }

    @RequestMapping(value = "rabbit-head-test",method = RequestMethod.POST)
    @ApiOperation(value = "rabbit测试")
    public String rabbithead(@RequestBody String st)throws Exception{

        mqSender.sendHeader(""+st);
        return null;
    }
}
