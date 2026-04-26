package session;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class SessionEndServlet extends jakarta.servlet.http.HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {

		// jakarta.servlet.http.HttpSessionインターフェイスの
		// 実装クラスのインスタンスを取得する
		// まだ、セッションが開始されていない場合は、
		// 同時にこれがセッションの開始になる
		// セッションが開始されていれば既存のセッションが取得される
		HttpSession session = req.getSession();

		// セッションを終了する
		session.invalidate();

		// RequestDispatcherを取得する
		RequestDispatcher dispatcher = req.getRequestDispatcher("sessionshow");

		// 転送先に要求を転送する
		dispatcher.forward(req, res);

	}
}

