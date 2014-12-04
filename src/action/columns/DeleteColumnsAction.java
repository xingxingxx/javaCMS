package action.columns;

import dao.DAOException;
import dao.OneColumnsDao;

public class DeleteColumnsAction {
	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String execute(){
		OneColumnsDao dao=new OneColumnsDao();
		try {
			dao.deleteOneColumns(id);
		} catch (DAOException e) {
			e.printStackTrace();
			return "error";
		}
		return "success";
	}
}
