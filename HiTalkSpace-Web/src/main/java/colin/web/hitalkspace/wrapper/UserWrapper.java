package colin.web.hitalkspace.wrapper;

/**
 * @author LinQiang on 2016/12/19.
 * @reviewer
 */
public class UserWrapper {
    private String username;
    private String password;
    private String valdiateCode;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getValdiateCode() {
        return valdiateCode;
    }

    public void setValdiateCode(String valdiateCode) {
        this.valdiateCode = valdiateCode;
    }
}
