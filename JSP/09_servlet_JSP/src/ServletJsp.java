import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.http.*;

//컨트롤러는 서블릿으로 만든다
public class ServletJsp extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		response.setCharacterEncoding("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter(); //out객체 생성
		
		String user = "아이유";
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", "iu");
		map.put("name", "아이유");
		map.put("addr", "서울시 구로구");
		
		request.setAttribute("user", user);
		request.setAttribute("map", map);
		
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/jsp/test.jsp");
		
		rd.forward(request, response); //JSP
	}//doGet()-end
}
