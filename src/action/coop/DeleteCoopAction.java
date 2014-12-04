package action.coop;

import dao.CoopDao;
import dao.DAOException;

public class DeleteCoopAction {
	private int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String execute(){
		CoopDao dao=new CoopDao();
		try {
			dao.deleteCoop(id);
		} catch (DAOException e) {
			e.printStackTrace();
			return "error";
		}
		return "success";
	}
}
