package action.twoColumns;

import dao.DAOException;
import dao.TwoColumnsDao;
import entity.TwoColumns;

public class UpdateTwoColumnsAction {
	private TwoColumns tc;

	public TwoColumns getTc() {
		return tc;
	}

	public void setTc(TwoColumns tc) {
		this.tc = tc;
	}
	public String execute(){
		TwoColumnsDao dao=new TwoColumnsDao();
		try {
			dao.updateTwoColumns(tc);
		} catch (DAOException e) {
			e.printStackTrace();
			return "error";
		}
		return "success";
	}
}
