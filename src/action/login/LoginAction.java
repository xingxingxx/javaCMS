package action.login;

import action.BaseAction;
import dao.AdminDao;
import dao.DAOException;
import entity.Admin;

public class LoginAction extends BaseAction{
	private String name;
	private String password;
	private String code;
	private String msg;
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String execute() {
		// session中记录的验证码
		String imageCode = 
			(String) session.get("imageCode");
		if(imageCode == null
				|| !imageCode.equalsIgnoreCase(code)) {
			msg = "请输入正确的验证码！";
			return "fail";
		}
		AdminDao dao=new AdminDao();
		Admin admin = null;
		try {
			admin = dao.findByName(name);
		} catch (DAOException e) {
			e.printStackTrace();
			msg = "系统发生异常，请联系系统管理员！";
			return "fail";
		}
		
		if(admin == null) {
			msg = "账号不存在，请重新输入.";
			return "fail";
		} else if (!admin.getAdminPassword().equals(password)) {
			msg = "密码不正确，请重新输入.";
			return "fail";
		} else {
			// 成功时，将管理员信息记录到session
			session.put("admin", admin);
			return "ok";
		}
		
	}
}
