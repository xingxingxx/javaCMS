package interceptor;

import java.io.IOException;    
import javax.servlet.FilterChain;    
import javax.servlet.ServletException;    
import javax.servlet.ServletRequest;    
import javax.servlet.ServletResponse;    
import javax.servlet.http.HttpServletRequest;    
  
import org.apache.struts2.dispatcher.ng.filter.StrutsPrepareAndExecuteFilter;  
  
public class UeditorStrutsFilter extends StrutsPrepareAndExecuteFilter {  
public void doFilter(ServletRequest req, ServletResponse res,FilterChain chain)   
throws IOException, ServletException {    
       HttpServletRequest request = (HttpServletRequest) req;    
       String url = request.getRequestURI();  
       url=url.substring(url.lastIndexOf("/"));
       if ("/imageUp.jsp".equals(url)||"/fileUp.jsp".equals(url)) {    
        //System.out.println("使用自定义的过滤器"+url);    
           chain.doFilter(req, res);    
       }else{    
           super.doFilter(req, res, chain);    
       }    
   }    
}  
