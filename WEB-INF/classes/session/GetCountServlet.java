package session;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class GetCountServlet extends jakarta.servlet.http.HttpServlet {
	
	protected void doGet(HttpServletRequest req,
			HttpServletResponse res) throws ServletException, IOException {
		
		//ServletContextの実装クラスのインスタンスを取得する
		ServletContext context=getServletContext();
		
		//counterという名前で登録されたIntegerのインスタンスを取得する
		Integer value=(Integer)context.getAttribute("counter");
		
		
		//まだ登録されていないかどうか判定する
		if(value==null){
			//登録されていなかった場合
			value=Integer.valueOf(1);
			//初めて登録する
			context.setAttribute("counter", value);
		}else{
			
			//すでに登録されていた場合
			//Integerからint型の値を取得する
			int count=value.intValue();
			
			//インクリメントする
			count++;
			
			//Integerのインスタンスを作り直す
			Integer newValue=Integer.valueOf(count);
			
			//ServletContextインターフェイスの実装クラスの
			//インスタンスに同じ名前で再登録する
			context.setAttribute("counter",newValue);
			
		}

		//RequestDispatcherを取得する
		RequestDispatcher dispatcher=
			req.getRequestDispatcher("countshow");
		
		//転送先に要求を転送する
		dispatcher.forward(req,res);

	}
}

