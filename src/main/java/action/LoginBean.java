package action;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;


import service.SysUserService;
import service.impl.SysUserServiceImpl;
import utils.SessionUtils;

@ManagedBean(name="loginBean")
@SessionScoped
public class LoginBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8309296777495795640L;
	
	private SysUserService sysUserService;
	
	private String username;
	private String password;
	
	public LoginBean() {
		sysUserService = new SysUserServiceImpl();
	}
	
	public String validateUsernamePassword() {
		boolean valid = sysUserService.verifyUser(username, password);
		if (valid) {
			HttpSession session = SessionUtils.getSession();
			session.setAttribute("username", username);
			return "/main.xhtml";
		} else {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_WARN,
							"Incorrect Username or Password",
							"Please enter correct username and Password"));
			return "/login.xhtml";
		}
	}
	
	
	//logout event, invalidate session
	public String logout() {
		HttpSession session = SessionUtils.getSession();
		session.invalidate();
		return "/login.xhtml";
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
	
}
