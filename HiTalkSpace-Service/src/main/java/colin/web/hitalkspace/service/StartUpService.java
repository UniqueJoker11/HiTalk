package colin.web.hitalkspace.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * @author LinQiang on 2016/12/15.
 * @reviewer
 */
@Service
public class StartUpService {

    @Autowired
    private ImServerService serverService;

    public void initStartService(){
        //启动IMServer
        serverService.startImServer();
    }

}
