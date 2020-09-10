package cn.smbms.service.role;

import cn.smbms.dao.role.RoleMapper;
import cn.smbms.pojo.Role;
import cn.smbms.tools.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
@Service("roleService")
@Transactional
public class RoleServiceImpl implements RoleService{
@Resource
private RoleMapper roleMapper;
	@Override
	@Transactional(propagation = Propagation.SUPPORTS,readOnly = true,isolation = Isolation.READ_COMMITTED)
	public List<Role> getRoleList() {

		List<Role> roleList = null;
		try {
			roleList = roleMapper.getRoleList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return roleList;
	}
	
}
