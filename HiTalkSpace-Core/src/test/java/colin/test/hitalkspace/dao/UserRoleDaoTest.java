package colin.test.hitalkspace.dao;

import colin.test.hitalkspace.CommonDaoTest;
import colin.web.hitalkspace.core.dao.UserRoleDao;
import com.alibaba.fastjson.JSONObject;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author LinQiang on 2016/12/21.
 * @reviewer
 */
public class UserRoleDaoTest extends CommonDaoTest {
    @Autowired
    private UserRoleDao userRoleDao;

    @Test
    public void testSelectUserRoleId() {
        String username = "admin";
        System.out.println(JSONObject.toJSONString(userRoleDao.selectUserRoleId(username)));
    }
}
