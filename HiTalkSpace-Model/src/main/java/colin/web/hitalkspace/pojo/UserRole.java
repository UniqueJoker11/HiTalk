package colin.web.hitalkspace.pojo;

import org.beetl.sql.core.annotatoin.AutoID;
import org.beetl.sql.core.annotatoin.Table;

/**
 * @author LinQiang on 2016/12/21.
 * @reviewer
 */
@Table(name = "sys_user_role")
public class UserRole {

    @AutoID
    private int id;
    private int userid;
    private int roleid;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getRoleid() {
        return roleid;
    }

    public void setRoleid(int roleid) {
        this.roleid = roleid;
    }
}
