package baseapi;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpServlet;

public class RequestTestServlet extends HttpServlet{
	public void doGet(HttpServletRequest req,HttpServletResponse res)
		throws IOException,ServletException{
		
		//Classオブジェクトを取得する
		Class<?> myClass=req.getClass();
		//Classオブジェクトの名前を取得する
		String className=myClass.getName();
		
		//出力するコンテンツのタイプと文字コードを指定する
		res.setContentType("text/html; charset=UTF-8");

		//HttpResponseオブジェクトからPrintWriterを取得する
		PrintWriter out=res.getWriter();

		//以下文字列を出力する
		out.println("<html><head>");
		out.println("<title>要求テスト</title>");
		out.println("</head><body>");
		out.println("<h1>要求テスト</h1>");
		
		out.println("●reqに格納されたインスタンスのクラス名---<br>");
		out.println("reqのクラス名="+className+"<br><br>");
		out.println("●ServletRequestのメソッド---------<br>");
        out.println("メッセージボディのタイプ           ="+req.getContentType()+"<br>");
		out.println("メッセージボディのサイズ="+req.getContentLength()+"<br>");
		out.println("プロトコル="+req.getProtocol()+"<br>");
		out.println("クライアントのIP="+req.getRemoteAddr()+"<br>");
		out.println("クライアントのホスト名="+req.getRemoteHost()+"<br><br>");

		out.println("●HttpServletRequestのメソッド-----<br>");
		out.println("ブラウザの情報="+req.getHeader("user-agent")+"<br>");
		out.println("リファラ="+req.getHeader("referer")+"<br>");
		out.println("メソッド名="+req.getMethod()+"<br>");
		
		out.println("コンテキストパス="+req.getContextPath()+"<br>");
		out.println("サーブレットパス="+req.getServletPath()+"<br>");
		out.println("パス情報="+req.getPathInfo()+"<br>");
		
    out.println("リクエスト行に含まれる    URI="+req.getRequestURI()+"<br>");
		out.println("URL全体="+req.getRequestURL()+"<br>");
		
		out.println("</body></html>");
	}
}

