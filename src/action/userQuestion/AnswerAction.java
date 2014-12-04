package action.userQuestion;

import java.util.List;

import dao.AdminAnswerDao;
import dao.DAOException;
import dao.UserQuestionDao;
import entity.AdminAnswer;
import entity.UserQuestion;

public class AnswerAction {
	private int id;
	private UserQuestion uq;
	private List<AdminAnswer> list;
	
	public String execute(){
		UserQuestionDao dao=new UserQuestionDao();
		AdminAnswerDao dao5=new AdminAnswerDao();
		try {
			uq=dao.findById(id);
			list=dao5.findAll();
		} catch (DAOException e) {
			e.printStackTrace();
			return "error";
		}
		return "success";
	}

	public List<AdminAnswer> getList() {
		return list;
	}

	public void setList(List<AdminAnswer> list) {
		this.list = list;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public UserQuestion getUq() {
		return uq;
	}

	public void setUq(UserQuestion uq) {
		this.uq = uq;
	}
	
	
}
