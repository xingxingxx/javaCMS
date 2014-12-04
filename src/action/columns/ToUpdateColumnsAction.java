package action.columns;

import dao.DAOException;
import dao.OneColumnsDao;
import entity.OneColumns;

public class ToUpdateColumnsAction {
	private int id;
	private OneColumns oc;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public OneColumns getOc() {
		return oc;
	}
	public void setOc(OneColumns oc) {
		this.oc = oc;
	}
	public String execute(){
		OneColumnsDao dao=new OneColumnsDao();
		try {
			oc=dao.findById(id);
		} catch (DAOException e) {
			e.printStackTrace();
			return "error";
		}
		return "success";
	}
}
