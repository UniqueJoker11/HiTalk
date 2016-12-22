package colin.web.hitalkspace.core.dao;

import colin.web.hitalkspace.core.dao.common.CommonDao;
import colin.web.hitalkspace.pojo.Menu;
import colin.web.hitalkspace.pojo.Role;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author LinQiang on 2016/12/21.
 * @reviewer
 */
@Repository
public class RoleMenuDao extends CommonDao{

    public List<Menu> selectUserRoleMenuId(List<Integer> roleIds){
        if (null==roleIds||roleIds.isEmpty()){
            return null;
        }
        Map<String,Object> roleMap=new HashMap<String,Object>();
        roleMap.put("roleIds",roleIds);
        List<Menu> roleIdsList=super.getSqlManager().select("rolemenu.selectUserRoleMenuIds",Menu.class,roleMap);
        return roleIdsList;
    }
}
