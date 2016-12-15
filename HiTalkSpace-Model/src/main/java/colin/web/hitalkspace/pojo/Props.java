package colin.web.hitalkspace.pojo;

import org.beetl.sql.core.annotatoin.Table;

/**
 * @author LinQiang on 2016/12/15.
 * @reviewer
 */
@Table(name = "props")
public class Props {
    private String name;
    private String value;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
