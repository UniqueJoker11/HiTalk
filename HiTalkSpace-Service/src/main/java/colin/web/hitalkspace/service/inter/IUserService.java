package colin.web.hitalkspace.service.inter;


import colin.web.hitalkspace.pojo.User;

import java.util.Map;

/**
 * 创建人 LinQiang
 * 创建日期 2016/3/14
 * 项目名称 MiniBlog
 * 当前包名 colin.miniblog.service.impl
 */
public interface IUserService {
  /**
   * 驗證用戶登錄
   * @param username
   * @param password
   * @return
   */
  public User userLoginService(String username, String password);

  /**
   * 用戶註冊
   * @param userInfo
   * @return
   */
  public User userRegisterService(Map<String, Object> userInfo);

  /**
   * 用戶信息更新
   * @return
   */
  public int userUpdateService(Map<String, Object> userInfo);

  /**
   * 根據id刪除用戶
   * @param id
   * @return
   */
  public int userDeleteService(int id);
}
