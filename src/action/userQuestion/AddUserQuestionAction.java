package action.userQuestion;

import action.BaseAction;
import dao.DAOException;
import dao.UserQuestionDao;
import entity.UserQuestion;

public class AddUserQuestionAction extends BaseAction{
	private UserQuestion uq=new UserQuestion();
	private String name;
	private String email;
	private String content;
	private String code;
	private String errorMsg;
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}


	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public UserQuestion getUq() {
		return uq;
	}

	public void setUq(UserQuestion uq) {
		this.uq = uq;
	}
	public String execute(){
		String imageCode = 
				(String) session.get("imageCode");
			if(imageCode == null
					|| !imageCode.equalsIgnoreCase(code)) {
				errorMsg = "VerificationCodeError";
				return "fail";
			}
			
		UserQuestionDao dao=new UserQuestionDao();
			try {
				uq.setContent(content);
				uq.setEmail(email);
				uq.setUserName(name);
				dao.addUserQuestion(uq);
			} catch (DAOException e) {
				e.printStackTrace();
				
				return "fail";
			}
			errorMsg = "success";
			return "ok";
	}
}
