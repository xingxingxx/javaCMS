package action.login;

import action.BaseAction;

public class LoginOutAction extends BaseAction{
	public String execute(){
		session.put("admin", null);
		return "success";
	}
}
