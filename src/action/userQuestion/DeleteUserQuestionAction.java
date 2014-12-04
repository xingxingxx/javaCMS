package action.userQuestion;

import dao.AdminAnswerDao;
import dao.DAOException;
import dao.UserQuestionDao;

public class DeleteUserQuestionAction {
	private int id;
	
	public String execute(){
		UserQuestionDao dao=new UserQuestionDao();
		AdminAnswerDao dao2=new AdminAnswerDao();
		try {
			dao2.deleteAdminAnswer2(id);
			dao.deleteUserQuestion(id);
		} catch (DAOException e) {
			e.printStackTrace();
			return "error";
		}
		return "success";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	

}
