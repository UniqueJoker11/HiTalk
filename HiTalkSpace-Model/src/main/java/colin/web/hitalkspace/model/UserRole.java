package colin.web.hitalkspace.model;

/**
 * 创建人 LinQiang
 * 创建日期 2016/3/15
 * 项目名称 MiniBlog
 * 当前包名 colin.miniblog.core.model
 */
public class UserRole {
    private String name;
    private int sort;
    private String remark;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
}
