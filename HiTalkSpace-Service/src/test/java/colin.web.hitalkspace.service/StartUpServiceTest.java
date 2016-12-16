package colin.web.hitalkspace.service;

import colin.web.hitalkspace.common.CommonServiceTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author LinQiang on 2016/12/16.
 * @reviewer
 */
public class StartUpServiceTest extends CommonServiceTest {

    @Autowired
    private ImServerService imServerService;
    @Autowired
    private StartUpService startUpService;


    @Test
    public void testInitStartService(){
        for(int i=1;i<3;i++){
            System.out.println("第"+i+"获取属性内容"+imServerService.getPropsVal("port"));
        }
    }

    @Test
    public void testStartImService(){
        startUpService.initStartService();
    }

}
