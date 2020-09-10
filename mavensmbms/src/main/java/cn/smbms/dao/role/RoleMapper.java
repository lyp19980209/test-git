package cn.smbms.dao.role;

import cn.smbms.pojo.Role;

import java.sql.Connection;
import java.util.List;

public interface RoleMapper {

    List<Role> getRoleList();

}
