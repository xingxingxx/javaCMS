package action.admin;

import dao.AdminDao;
import dao.DAOException;
import entity.Admin;

public class AddAdminAction {
	private Admin a;
	
	public String execute(){
		AdminDao dao=new AdminDao();
		try {
			dao.addAdmin(a);
		} catch (DAOException e) {
			e.printStackTrace();
			return "error";
		}
		return "success";
	}

	public Admin getA() {
		return a;
	}

	public void setA(Admin a) {
		this.a = a;
	}
	
	
}
