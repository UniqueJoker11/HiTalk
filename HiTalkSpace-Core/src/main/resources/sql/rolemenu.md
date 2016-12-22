selectUserRoleMenuIds
====
*查询用户的角色菜单
select * from sys_menu where status=1 and id in(select distinct(srm.menuid) from sys_menu as sm left join sys_role_menu as srm on(sm.id=srm.roleid) where srm.roleid in(
@if(!isEmpty(roleIds)){
@for(roleId in roleIds){
#roleId#  #text(roleIdLP.last?"":"," )#
@}
@}
))