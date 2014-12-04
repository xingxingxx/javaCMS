package action.pcategory;

import dao.DAOException;
import dao.PcategoryDao;
import entity.Pcategory;

public class UpdatePcategoryAction {
   private Pcategory p;

	public Pcategory getP() {
		return p;
	}
	
	public void setP(Pcategory p) {
		this.p = p;
	}
   
	public String execute(){
		PcategoryDao dao=new PcategoryDao();
		try {
			dao.updatePcategory(p);
		} catch (DAOException e) {
			e.printStackTrace();
			return "error";
		}
		return "success";
	}
}
