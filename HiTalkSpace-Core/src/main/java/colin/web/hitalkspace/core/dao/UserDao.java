package colin.web.hitalkspace.core.dao;

import colin.web.hitalkspace.core.dao.common.CommonDao;
import colin.web.hitalkspace.pojo.User;
import org.beetl.sql.core.db.KeyHolder;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 创建人 LinQiang
 * 创建日期 2016/3/24
 * 项目名称 HiTalkSpace
 * 当前包名 colin.web.hitalkspace.core.dao
 */
@Repository
public class UserDao extends CommonDao {

  /**
   * 註冊用戶信息
   * @param user
   * @return
   */
  public User insertUser(User user){
    KeyHolder keyHolder=new KeyHolder();
    super.getSqlManager().insert(User.class,user,keyHolder);
    user.setId(keyHolder.getInt());
    return user;
  }

  /**
   * 根絕用戶名密碼驗證用戶登錄
   * @param user
   * @return
   */
  public User valdiateUser(User user){
    List<User> userList=super.getSqlManager().select("user.validateLogin",User.class,user);
    if(userList!=null&&!userList.isEmpty()){
      return userList.get(0);
    }else {
      return null;
    }
  }
}