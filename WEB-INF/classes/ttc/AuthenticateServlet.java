package ttc;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class AuthenticateServlet extends HttpServlet {
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");

		// ユーザー名を取得する
		String name = req.getParameter("name");
		// パスワードを取得する
		String pass = req.getParameter("pass");

		// ユーザー名とパスワードのチェックを行う
		if(name.equals("ica") && pass.equals("tera")){
			// 承認された場合は、認証トークンをセットする
			// つまり、セッション情報としてフラグをたてる。
			HttpSession session = req.getSession();
			session.setAttribute("token", "OK");
		}

		// 転送する
		RequestDispatcher disp = req.getRequestDispatcher("/productinput");
		disp.forward(req, res);
	}
}

