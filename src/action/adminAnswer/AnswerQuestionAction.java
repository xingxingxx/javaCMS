package action.adminAnswer;

import action.BaseAction;
import dao.AdminAnswerDao;
import dao.DAOException;
import entity.Admin;
import entity.AdminAnswer;

public class AnswerQuestionAction extends BaseAction{
	private AdminAnswer aa=new AdminAnswer();
	private int questionId;
	private String content;
	
	
	public String execute(){
		AdminAnswerDao dao=new AdminAnswerDao();
		Admin admin=(Admin) session.get("admin");
		
		aa.setAdminName(admin.getAdminName());
		aa.setContent(content);
		aa.setQuestionId(questionId);
		
		try {
			dao.addAdminAnswer(aa);
		} catch (DAOException e) {
			e.printStackTrace();
			return "error";
		}
		return "success";
	}


	public AdminAnswer getAa() {
		return aa;
	}


	public void setAa(AdminAnswer aa) {
		this.aa = aa;
	}


	public int getQuestionId() {
		return questionId;
	}


	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}
	
}
