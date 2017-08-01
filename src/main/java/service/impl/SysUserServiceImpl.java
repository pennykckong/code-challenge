package service.impl;

import java.util.List;

import dao.SysUserDao;
import dao.impl.SysUserDaoImpl;
import entity.SysUser;
import service.SysUserService;

public class SysUserServiceImpl extends BaseServiceImpl<SysUser> implements SysUserService {
			
	public SysUserServiceImpl() {
	}
	
	@Override
	public void addSysUser(String username, String password) {
		SysUser sysUser = new SysUser(username,password);
		this.save(sysUser);
		//sysUserDao.save(sysUser);
	}
	
	@Override
	public boolean verifyUser(String username, String password) {
		String query = "from SysUser where username = ? and password = ?";
		List<SysUser> authUser= this.getByHQL(query, username, password);
		
		if(authUser.size() > 0) {
			return true;
		}
		
		return false;
	}

}
