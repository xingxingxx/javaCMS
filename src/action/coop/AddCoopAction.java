package action.coop;

import dao.CoopDao;
import dao.DAOException;
import entity.Coop;

public class AddCoopAction {
	private Coop coop;
	private String errorMsg;
	

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public Coop getCoop() {
		return coop;
	}

	public void setCoop(Coop coop) {
		this.coop = coop;
	}
	
	public String execute(){
		CoopDao dao=new CoopDao();
		try {
			dao.addCoop(coop);
		} catch (DAOException e) {
			e.printStackTrace();
			return "fail";
		}
		errorMsg = "success";
		return "ok";
	}
}
