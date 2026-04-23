import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import tera.UserBean;

public class AddUserServlet extends HttpServlet {
	
	//ArrayListを使用
	private ArrayList<UserBean> users = new ArrayList<UserBean>();
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		//POST要求によって送信された文字列をクライアントで
		//エンコードしたときの文字コードを指定する
		//これを指定しないと文字化けする可能性がある
		req.setCharacterEncoding("UTF-8");
		
		//POST要求によって送信されたパラメータを取得する
		String n=req.getParameter("name");
		String p=req.getParameter("pass");
		
		//UserBeanをインスタンス化し、データをセットする
		UserBean user=new UserBean();
		user.setName(n);
		user.setPassWord(p);
		
		//リストに追加する
		users.add(user);

		//HttpServletRequestの実装クラスのインスタンスに
		//usersという名前でデータを登録する
		req.setAttribute("users",users);
		
		//RequestDispatcherインターフェイスを実装するクラスの
		//インスタンスを取得する
		//引数は転送先のURL
		RequestDispatcher dispatcher=
			req.getRequestDispatcher("userslist");
		
		//転送先に要求を転送する
		dispatcher.forward(req,res);
	}
}
