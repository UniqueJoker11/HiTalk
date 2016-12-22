selectUserRoleId
===
*查询出来用户的RoleId
select distinct(sur.roleid) from sys_user_role as sur left join sys_user as su on sur.userid= su.userid and su.username=#username#

selectUserRolesInfo
===
*查询用户的角色信息
select * from sys_role where status=1 and id in(select distinct(sur.roleid) from sys_user_role as sur left join sys_user as su on sur.userid= su.userid and su.username=#username#)