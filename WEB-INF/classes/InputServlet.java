import java.io.IOException;
import bean.UserBean;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.RequestDispatcher;

public class InputServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("Windows-31J");
		String userName = request.getParameter("name");
		String passWord = request.getParameter("pass");
		UserBean bean = new UserBean();
		bean.setName(userName);
		bean.setPass(passWord);
		request.setAttribute("user",bean);
		RequestDispatcher dis = request.getRequestDispatcher("result");
		dis.forward(request,response);
	}
}


