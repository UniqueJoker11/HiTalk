package colin.web.hitalkspace.pojo;

import org.beetl.sql.core.annotatoin.AutoID;
import org.beetl.sql.core.annotatoin.Table;

/**
 * @author LinQiang on 2016/12/21.
 * @reviewer
 */
@Table(name = "sys_role")
public class Role {

    @AutoID
    private int id;
    private String name;
    private int status;
    private int sort;
    private String remark;
    private String create_time;
    private int create_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public int getCreate_id() {
        return create_id;
    }

    public void setCreate_id(int create_id) {
        this.create_id = create_id;
    }
}
