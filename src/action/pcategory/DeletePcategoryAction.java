package action.pcategory;

import dao.DAOException;
import dao.PcategoryDao;

public class DeletePcategoryAction {
	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String execute(){
		PcategoryDao dao=new PcategoryDao();
		try {
			dao.deletePcategory(id);
		} catch (DAOException e) {
			e.printStackTrace();
			return "error";
		}
		return "success";
	}
}
