
import org.activiti.engine.*;
import org.activiti.engine.history.HistoricProcessInstance;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.activiti.spring.ProcessEngineFactoryBean;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @项目名称:lidong-dubbo
 * @类名:WorkFlowTest
 * @类的描述:
 * @作者:lidong
 * @创建时间:2017/2/5 上午11:08
 * @公司:chni
 * @QQ:1561281670
 * @邮箱:lidong1665@163.com
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class WorkFlowTest {


    @Autowired
    ProcessEngineFactoryBean processEngine;

    @Autowired
    private RepositoryService repositoryService;

    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    private TaskService taskService;

    @Autowired
    private HistoryService historyService;

    @Autowired
    private IdentityService identityService;

    @Test
    public void testEvent() throws InterruptedException {


    }
}
