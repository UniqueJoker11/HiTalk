package colin.web.hitalkspace.pojo;

import org.beetl.sql.core.annotatoin.AutoID;
import org.beetl.sql.core.annotatoin.Table;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 创建人 LinQiang
 * 创建日期 2016/3/10
 * 项目名称 MiniBlog
 * 当前包名 colin.miniblog.core.pojo
 */
@Table(name = "sys_user")
public class User implements Serializable{

  @AutoID
  private int userid;
  private String username;
  private String password;
  private String realname;
  /**
   * 部门/11111/dict
   */
  private int departid;
  /**
   * 类型//select/1,管理员,2,普通用户,3,前台用户,4,第三方用户
   */
  private int usertype;
  private int state;
  private String thirdid;
  private String create_time;
  private String endtime;
  private String email;
  private String tel;
  private String address;
  private String title_url;
  private String remark;
  private String theme;
  /**
   * 后台选择站点ID
   */
  private int back_site_id;
  /**
   * 创建站点ID
   */
  private int create_site_id;
  private int create_id;

  public int getUserid() {
    return userid;
  }

  public void setUserid(int userid) {
    this.userid = userid;
  }

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

  public String getRealname() {
    return realname;
  }

  public void setRealname(String realname) {
    this.realname = realname;
  }

  public int getDepartid() {
    return departid;
  }

  public void setDepartid(int departid) {
    this.departid = departid;
  }

  public int getUsertype() {
    return usertype;
  }

  public void setUsertype(int usertype) {
    this.usertype = usertype;
  }

  public int getState() {
    return state;
  }

  public void setState(int state) {
    this.state = state;
  }

  public String getThirdid() {
    return thirdid;
  }

  public void setThirdid(String thirdid) {
    this.thirdid = thirdid;
  }

  public String getCreate_time() {
    return create_time;
  }

  public void setCreate_time(String create_time) {
    this.create_time = create_time;
  }

  public String getEndtime() {
    return endtime;
  }

  public void setEndtime(String endtime) {
    this.endtime = endtime;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getTel() {
    return tel;
  }

  public void setTel(String tel) {
    this.tel = tel;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getTitle_url() {
    return title_url;
  }

  public void setTitle_url(String title_url) {
    this.title_url = title_url;
  }

  public String getRemark() {
    return remark;
  }

  public void setRemark(String remark) {
    this.remark = remark;
  }

  public String getTheme() {
    return theme;
  }

  public void setTheme(String theme) {
    this.theme = theme;
  }

  public int getBack_site_id() {
    return back_site_id;
  }

  public void setBack_site_id(int back_site_id) {
    this.back_site_id = back_site_id;
  }

  public int getCreate_site_id() {
    return create_site_id;
  }

  public void setCreate_site_id(int create_site_id) {
    this.create_site_id = create_site_id;
  }

  public int getCreate_id() {
    return create_id;
  }

  public void setCreate_id(int create_id) {
    this.create_id = create_id;
  }
}
