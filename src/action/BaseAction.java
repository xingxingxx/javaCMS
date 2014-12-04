package action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

/**
 *	这是所有Action的一个父类，
 *	用于封装通用的逻辑。
 */
public class BaseAction implements SessionAware {

	protected Map<String,Object> session;
	
	public void setSession(
			Map<String, Object> arg0) {
		session = arg0;
		
	}

}
