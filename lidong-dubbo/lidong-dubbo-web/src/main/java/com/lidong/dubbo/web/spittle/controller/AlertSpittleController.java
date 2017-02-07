package com.lidong.dubbo.web.spittle.controller;


import com.lidong.dubbo.api.spittle.service.IAlertService;
import com.lidong.dubbo.api.spittle.service.IMessageProducer;
import com.lidong.dubbo.api.workflow.service.IWorkFlowservice;
import com.lidong.dubbo.model.user.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @项目名称:lidong-dubbo
 * @类名:AlertSpittleServiceImp
 * @类的描述:
 * @作者:lidong
 * @创建时间:2017/1/27 下午1:25
 * @公司:chni
 * @QQ:1561281670
 * @邮箱:lidong1665@163.com
 */
@Controller
@RequestMapping("/spittle")
public class AlertSpittleController{


    @Autowired
    private IAlertService iAlertService;

    @Autowired
    private IMessageProducer iMessageProducer;

    @Autowired
    private IWorkFlowservice iWorkFlowservice;
    private Logger logger = LoggerFactory.getLogger(AlertSpittleController.class);


    @RequestMapping("/sendMessage")
    @ResponseBody
    public  void  sendMessage(){
        logger.info("--------------------");
        User user = new User();
        user.setName("lidong");
        user.setAge(25);
        user.setPassword("123456");
        user.setId(12);
        iAlertService.sendSpittleAlert(user);
    }


    @RequestMapping("/sendRabbitMessage")
    @ResponseBody
    public  void  sendRabbitMessage(){
        logger.info("--------------------");
        User user = new User();
        user.setName("lidong");
        user.setAge(25);
        user.setPassword("123456");
        user.setId(12);
        iMessageProducer.sendMessage(user);
    }

    @RequestMapping("/testEvent")
    @ResponseBody
    public  void  testEvent(){
        logger.info("--------------------");
        try {
            iWorkFlowservice.testEvent();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
