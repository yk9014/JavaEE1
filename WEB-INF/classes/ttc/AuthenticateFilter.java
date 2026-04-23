package ttc;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

public class AuthenticateFilter implements Filter {

	public void init(FilterConfig config) throws ServletException {
	}
	public void destroy() {
	}

	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {

		// セッションを取得する
		// ServletRequestをキャストする必要がある。
		HttpSession session = ((HttpServletRequest) req).getSession();
		
		//認証トークンを取得する
		String flag = (String) session.getAttribute("token");

		// 認証トークンがセットされているかどうか判定する
		if(flag == null){
			//認証トークンがない場合は、ログイン画面へ転送する
			RequestDispatcher disp = req.getRequestDispatcher("/orderlogin");
			disp.forward(req, res);
		}else{
			//本来のURL（productinput）へ転送する
			chain.doFilter(req, res);
		}
	}
}
