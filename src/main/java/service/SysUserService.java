package service;

import entity.SysUser;

public interface SysUserService extends BaseService<SysUser> {
	
	public void addSysUser(String username, String password);
	
	public boolean verifyUser(String username, String password);
}

