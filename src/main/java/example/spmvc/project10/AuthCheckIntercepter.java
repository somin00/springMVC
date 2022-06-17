package example.spmvc.project10;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;

public class AuthCheckIntercepter implements HandlerInterceptor{

	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse response, Object handler) throws Exception{
		HttpSession session=req.getSession(); 
		if(session!=null) {
			
			Object authInfo=session.getAttribute("authInfo"); 
			if(authInfo!=null) {
				return true; 
			}
		}
		response.sendRedirect(req.getContextPath()+"/");
		return false; 
		
	}
}
