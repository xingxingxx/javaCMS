package interceptor;

import java.util.Map;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

/**
 *	登陆检查拦截器
 */
public class LoginInterceptor implements Interceptor {

	private static final long serialVersionUID = 1L;

	public void destroy() {
		
	}

	public void init() {
		
	}

	public String intercept(ActionInvocation ai) 
		throws Exception {
		Map<String, Object> session = 
			ai.getInvocationContext().getSession();
		Object admin = session.get("admin");
		if(admin == null) {
			// session中admin为空说明没登陆，踢回登陆页面
			return "login";
		} else {
			// session中admin不为空，说明登陆了，可以访问
			return ai.invoke();
		}
	}

}