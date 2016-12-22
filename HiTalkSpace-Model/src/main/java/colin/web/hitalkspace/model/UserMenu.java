package colin.web.hitalkspace.model;

import java.util.List;

/**
 * @author LinQiang on 2016/12/21.
 * @reviewer
 */
public class UserMenu {
    private String name;
    private String urlkey;
    private String url;
    private int type;
    private int sort;
    private int level;
    private List<UserMenu> subUserMenu;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrlkey() {
        return urlkey;
    }

    public void setUrlkey(String urlkey) {
        this.urlkey = urlkey;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public List<UserMenu> getSubUserMenu() {
        return subUserMenu;
    }

    public void setSubUserMenu(List<UserMenu> subUserMenu) {
        this.subUserMenu = subUserMenu;
    }
}
