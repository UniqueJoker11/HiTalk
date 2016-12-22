package colin.web.hitalkspace.pojo;

import org.beetl.sql.core.annotatoin.AutoID;
import org.beetl.sql.core.annotatoin.Table;

/**
 * @author LinQiang on 2016/12/21.
 * @reviewer
 */
@Table(name = "sys_role_menu")
public class RoleMenu {

    @AutoID
    private int id;
    private int roleid;
    private int menuid;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRoleid() {
        return roleid;
    }

    public void setRoleid(int roleid) {
        this.roleid = roleid;
    }

    public int getMenuid() {
        return menuid;
    }

    public void setMenuid(int menuid) {
        this.menuid = menuid;
    }
}
