package session;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.ServletContext;

public class SessionStartServlet extends jakarta.servlet.http.HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {

		// jakarta.servlet.http.HttpSessionインターフェイスの
		// 実装クラスのインスタンスを取得する
		// まだ、セッションが開始されていない場合は、
		// 同時にこれがセッションの開始になる
		// セッションが開始されていれば既存のセッションが取得される
		HttpSession session = req.getSession();
		
		ServletContext context = getServletContext();
		String s = context.getInitParameter("name");

		// データを登録する
		session.setAttribute("name", "ashi");
		session.setAttribute("pass", "tera");
		session.setAttribute("param",s);

		// RequestDispatcherを取得する
		RequestDispatcher dispatcher = req.getRequestDispatcher("sessionshow");

		// 転送先に要求を転送する
		dispatcher.forward(req, res);
	}
}
