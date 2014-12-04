package action.partners;

import dao.DAOException;
import dao.PartnersDao;

public class DeletePartnersAction {
	private int id;
	
	public String execute(){
		PartnersDao dao=new PartnersDao();
		try {
			dao.deletePartners(id);
		} catch (DAOException e) {
			e.printStackTrace();
			return "error";
		};
		return "success";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
}
