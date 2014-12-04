package action.admin;

import java.util.List;

import dao.AdminDao;
import dao.DAOException;
import entity.Admin;

public class FindAdminAction {
	private List<Admin> list;
	
	public String execute(){
		AdminDao dao=new AdminDao();
		try {
			list=dao.findAll();
		} catch (DAOException e) {
			e.printStackTrace();
			return "error";
		}
		return "success";
	}

	public List<Admin> getList() {
		return list;
	}

	public void setList(List<Admin> list) {
		this.list = list;
	}
	
	
}
