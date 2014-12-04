package action.coop;

import dao.CoopDao;
import dao.DAOException;
import entity.Coop;

public class FindByIdCoopAction {
	private int id;
	private Coop coop;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Coop getCoop() {
		return coop;
	}

	public void setCoop(Coop coop) {
		this.coop = coop;
	}
	public String execute(){
		CoopDao dao=new CoopDao();
		try {
			coop=dao.findById(id);
		} catch (DAOException e) {
			e.printStackTrace();
			return "error";
		}
		return "success";
	}
	
}
