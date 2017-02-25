package com.lidong.dubbo.core.workflow.service;

import com.lidong.dubbo.api.workflow.service.IWorkFlowservice;
import org.activiti.engine.*;
import org.activiti.engine.history.HistoricProcessInstance;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.activiti.spring.ProcessEngineFactoryBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lidong on 2017/2/5.
 */
@Service
public class WorkFlowserviceImp implements IWorkFlowservice {

//    Logger logger = LoggerFactory.getLogger(WorkFlowserviceImp.class);
//
//    @Autowired
//    ProcessEngineFactoryBean processEngine;
//
//    @Autowired
//    private RepositoryService repositoryService;
//
//    @Autowired
//    private RuntimeService runtimeService;
//
//    @Autowired
//    private TaskService taskService;
//
//    @Autowired
//    private HistoryService historyService;
//
//    @Autowired
//    private IdentityService identityService;
//
//
    @Override
    public void testEvent() throws InterruptedException {
//        logger.info("-----------开始------------");
//        /**
//         * 1、部署流程文件
//         */
//        Deployment deploy = repositoryService.createDeployment()
//                .addClasspathResource("process/leave.bpmn")
//                .deploy();
//        logger.info("Number of process definitions: " + repositoryService.createProcessDefinitionQuery().count());
//        logger.info("部署ID     " +deploy.getId());
//
//        identityService.setAuthenticatedUserId("Jeff Dean");
//        /**
//         * 2、启动流程
//         */
//        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("leave");
//        logger.info("流程实例ID       " +processInstance.getId());
//        logger.info("流程定义的ID     "+processInstance.getProcessDefinitionId());
//        logger.info(processInstance.getProcessDefinitionKey());
//        /**
//         * 3、查询第一个任务
//         */
//        List<Task> tasks = taskService.createTaskQuery().taskCandidateGroup("部门经理").list();//个人任务的查询
//        logger.info("    任务总数： "+tasks.size());
//        for (Task task : tasks) {
//            logger.info(task.getName() + " : " + task.getAssignee());
//            logger.info("     任务ID： "+task.getId());
//            logger.info("     任务的办理人： "+task.getAssignee());
//            logger.info("     任务名称： "+task.getName());
//            logger.info("     任务的创建时间： "+task.getCreateTime());
//            logger.info("     流程实例ID：  "+task.getProcessInstanceId());
//            logger.info("#######################################");
//        }
//        /**
//         * 4、流程结束
//         */
//        HistoricProcessInstance hpInstance =
//                historyService.createHistoricProcessInstanceQuery()
//                        .processInstanceId(processInstance.getId()).singleResult();
//        logger.info("end time: " + hpInstance.getEndTime());
////        taskService//
////                .complete(taskId);
//        logger.info("-----------结束------------");
    }
}
