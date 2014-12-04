package action.columns;

import dao.DAOException;
import dao.OneColumnsDao;
import entity.OneColumns;

public class AddColumnsAction {
	private OneColumns oc;
	
	public OneColumns getOc() {
		return oc;
	}
	public void setOc(OneColumns oc) {
		this.oc = oc;
	}


	public String execute(){
		OneColumnsDao dao=new OneColumnsDao();
		try {
			dao.addOneColumns(oc);
		} catch (DAOException e) {
			e.printStackTrace();
			return "error";
		}
		return "success";
	}
}
