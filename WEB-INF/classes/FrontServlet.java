import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class FrontServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		
		//リクエストスコープでデータを格納する
		req.setAttribute("test1", new String("データ１"));
		
		//セッションスコープでデータを格納する
		HttpSession session=req.getSession();
		session.setAttribute("test2", new String("データ２"));
		
		//アプリケーションスコープでデータを格納する
		ServletContext context=getServletContext();
		context.setAttribute("test3", new String("データ３"));
		
		RequestDispatcher disp=req.getRequestDispatcher("/jspobject.jsp");
		disp.forward(req, res);
	}
}
