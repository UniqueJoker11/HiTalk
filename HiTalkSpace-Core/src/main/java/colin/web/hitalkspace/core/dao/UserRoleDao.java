package colin.web.hitalkspace.core.dao;

import colin.web.hitalkspace.core.dao.common.CommonDao;
import colin.web.hitalkspace.pojo.Role;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author LinQiang on 2016/12/21.
 * @reviewer
 */
@Repository
public class UserRoleDao extends CommonDao {

    /**
     * 获取用户的roleIds
     * @param username
     * @return
     */
    public List<Integer> selectUserRoleId(String username) {
        if (StringUtils.isEmpty(username)) {
            return null;
        }
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("username", username);
        List<Integer> roleIds = super.getSqlManager().select("userrole.selectUserRoleId", Integer.class, params);
        return roleIds;
    }

    /**
     * 获取用户的角色信息
     * @param username
     * @return
     */
    public List<Role> selectUserRolesInfo(String username) {
        if (StringUtils.isEmpty(username)) {
            return null;
        }
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("username", username);
        List<Role> roleIds = super.getSqlManager().select("userrole.selectUserRolesInfo", Role.class, params);
        return roleIds;
    }
}
