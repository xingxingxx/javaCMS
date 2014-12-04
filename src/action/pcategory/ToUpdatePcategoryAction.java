package action.pcategory;

import dao.DAOException;
import dao.PcategoryDao;
import entity.Pcategory;

public class ToUpdatePcategoryAction {
	private int id;
	private Pcategory p;

	public Pcategory getP() {
		return p;
	}

	public void setP(Pcategory p) {
		this.p = p;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String execute(){
		PcategoryDao dao=new PcategoryDao();
		try {
			p=dao.findById(id);
		} catch (DAOException e) {
			e.printStackTrace();
			return "error";
		}
		return "success";
	}
}
