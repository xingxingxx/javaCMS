package action.admin;

import dao.AdminDao;
import dao.DAOException;

public class DeleteAdminAction {
	private int id;
	public String execute(){
		AdminDao dao=new AdminDao();
		try {
			dao.deleteAdmin(id);
		} catch (DAOException e) {
			e.printStackTrace();
			return "error";
		}
		return "success";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
}
