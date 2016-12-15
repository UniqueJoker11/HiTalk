package colin.web.hitalkspace.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author LinQiang on 2016/12/15.
 * @reviewer
 */
@Component
public class LoggerUtils {

    private ThreadLocal<Logger> loggerThreadLocal=new ThreadLocal<Logger>();

    public void debug(String msg,Class<?> clazz){
       getCurrentLogger(clazz);
        loggerThreadLocal.get().debug(msg);
    }
    public void info(String msg,Class<?> clazz){
        getCurrentLogger(clazz);
        loggerThreadLocal.get().info(msg);
    }
    public void warn(String msg,Class<?> clazz){
        getCurrentLogger(clazz);
        loggerThreadLocal.get().warn(msg);
    }
    public void error(String msg,Class<?> clazz){
        getCurrentLogger(clazz);
        loggerThreadLocal.get().error(msg);
    }
    private Logger getCurrentLogger(Class<?> clazz){
        Logger logger=LoggerFactory.getLogger(clazz);
        loggerThreadLocal.set(logger);
        return logger;
    }
}
