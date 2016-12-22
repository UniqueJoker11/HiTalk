selectUserRoleId
===
*查询出来用户的roleid
select distinct(id) from sys_role where status=1 and id in( select distinct(sur.roleid) from sys_user_role as sur left join sys_user as su on sur.userid= su.userid and su.username=#username#