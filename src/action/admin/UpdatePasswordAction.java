package action.admin;

import dao.AdminDao;
import dao.DAOException;
import action.BaseAction;
import entity.Admin;

public class UpdatePasswordAction extends BaseAction{
	private String oldPassword;
	private String newPassword;
	private String msg;
	
	public String execute(){
		Admin admin=(Admin) session.get("admin");
		if(!admin.getAdminPassword().equals(oldPassword)){
			msg="原始密码错误！";
			return "fail";
		}else{
			AdminDao dao=new AdminDao();
			admin.setAdminPassword(newPassword);
			try {
				dao.updateAdmin(admin);
			} catch (DAOException e) {
				e.printStackTrace();
				return "error";
			}
		}
	
		return "ok";
	}

	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	
}
