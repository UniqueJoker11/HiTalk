package colin.test.hitalkspace.dao;

import colin.test.hitalkspace.CommonDaoTest;
import colin.web.hitalkspace.core.dao.RoleMenuDao;
import colin.web.hitalkspace.pojo.Menu;
import com.alibaba.fastjson.JSONObject;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LinQiang on 2016/12/21.
 * @reviewer
 */
public class RoleMenuDaoTest extends CommonDaoTest {
    @Autowired
    private RoleMenuDao roleMenuDao;

    @Test
    public void testSelectUserRoleMenuId() {
        List<Integer> roleIds = new ArrayList<Integer>();
        roleIds.add(1);
        roleIds.add(2);
        roleIds.add(3);
        List<Menu> rolsIdsResult = roleMenuDao.selectUserRoleMenuId(roleIds);
        System.out.println(JSONObject.toJSONString(rolsIdsResult));
    }
}
