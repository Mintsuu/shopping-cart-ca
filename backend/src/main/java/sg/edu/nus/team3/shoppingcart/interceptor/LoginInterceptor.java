package sg.edu.nus.team3.shoppingcart.interceptor;

import java.io.PrintWriter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import sg.edu.nus.team3.shoppingcart.util.APIResponse;

/**
 * @author diony
 */

@Component
public class LoginInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		// Looks for user id in session attributes. If null, returns 401 Unauthorized.
		// HttpSession session = request.getSession();

		// Integer id = (Integer) session.getAttribute("id");

		// if (id == null) {
		// APIResponse resp = new APIResponse("Please log in to continue");
		// String json = new Gson().toJson(resp);
		// PrintWriter out = response.getWriter();
		// response.setContentType("application/json");
		// response.setCharacterEncoding("utf-8");
		// response.setStatus(401);
		// out.print(json);
		// out.flush();

		// return false;
		// }

		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

		// Looks for email address in session attributes. If null, redirect to login.
		// HttpSession session = request.getSession();

		// String username = (String) session.getAttribute("email");

		// if (username == null) {
		// response.sendRedirect("/login");
		// }
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
	}

}
