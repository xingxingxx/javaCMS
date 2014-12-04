package action.twoColumns;

import dao.DAOException;
import dao.TwoColumnsDao;
import entity.TwoColumns;

public class ToUpdateTwoColumnsAction {
	private int id;
	private TwoColumns tc;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public TwoColumns getTc() {
		return tc;
	}
	public void setTc(TwoColumns tc) {
		this.tc = tc;
	}
	public String execute(){
		TwoColumnsDao dao=new TwoColumnsDao();
		try {
			tc=dao.findById(id);
		} catch (DAOException e) {
			e.printStackTrace();
			return "error";
		}
		return "success";
	}
}
