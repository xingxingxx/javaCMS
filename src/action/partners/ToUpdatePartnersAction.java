package action.partners;

import dao.DAOException;
import dao.PartnersDao;
import entity.Partners;

public class ToUpdatePartnersAction {
	private int id;
	private Partners p;
	
	public String execute(){
		PartnersDao dao=new PartnersDao();
		try {
			p=dao.findById(id);
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

	public Partners getP() {
		return p;
	}

	public void setP(Partners p) {
		this.p = p;
	}
	
	
}
