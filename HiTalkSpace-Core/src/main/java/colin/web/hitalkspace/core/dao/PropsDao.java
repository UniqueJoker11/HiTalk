package colin.web.hitalkspace.core.dao;

import colin.web.hitalkspace.core.dao.common.CommonDao;
import colin.web.hitalkspace.utils.LoggerUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author LinQiang on 2016/12/15.
 * @reviewer
 */
@Repository
public class PropsDao extends CommonDao {

    @Autowired
    private LoggerUtils loggerUtils;

    /**
     * 获取属性值
     *
     * @param propsName
     */
    @Cacheable(value="propsCache",key="#propsName")
    public String getPropsVal(String propsName) {
        System.out.println("我被执行了");
        Map<String, Object> propsParams = new HashMap<String, Object>();
        propsParams.put("name", propsName);
        List<String> result = super.getSqlManager().select("props.queryPropsVal", String.class, propsParams);
        if (null==result||result.isEmpty()){
            loggerUtils.warn("【查询属性Dao】查询属性值"+propsName+"结果数量为空！",PropsDao.class);
            return null;
        }
        if (result.size()==1){
            return result.get(0);
        }else{
            loggerUtils.warn("【查询属性Dao】查询属性值"+propsName+"出现主键冲突！",PropsDao.class);
            return null;
        }
    }
}
