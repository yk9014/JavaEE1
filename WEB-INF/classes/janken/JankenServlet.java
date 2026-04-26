package janken;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class JankenServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		
		//HTMLからのhandパラメーターを取得。intに変換して格納
		int hand=Integer.parseInt(req.getParameter("hand"));
		String result = janken.Janken.janken(hand);		
		req.setAttribute("result",result);
		req.getRequestDispatcher("janken/jankenresult.jsp").forward(req,res);
	}
}
