package game;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class HitAndBlowServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
    
        // セッションから既存のゲームインスタンスを取得、なければ新規作成
        HitAndBlowGame game = (HitAndBlowGame) session.getAttribute("game");

        if (game == null || request.getParameter("restart") != null) {
            game = new HitAndBlowGame();
            session.setAttribute("game", game);
        }

        //セッションから表示用メッセージを取得。なければnull
        String outputMessage = "";
        String sessionMessage = (String)session.getAttribute("outputMessage"); 
        if(sessionMessage!=null){
            outputMessage = sessionMessage;
        }

        // 画面からの入力を受け取る
        String userInput = request.getParameter("playerinput");
        
        // コアロジックを呼び出す（コマンドラインの時と全く同じメソッドが使える）
        String resultMessage = game.guess(userInput);
        System.out.println("resultMessage"+resultMessage);

        //nullでなければ、表示結果を既存のメッセージに上書き

        outputMessage += "<br>"+ userInput + "：" + resultMessage;

        // 上書き済みのメッセージをセット
        session.setAttribute("outputMessage", outputMessage);
        System.out.println("outputMessage"+outputMessage);
        
        if (resultMessage.contains("勝ち") || resultMessage.contains("負け")) {
            session.removeAttribute("game"); // ゲーム終了ならセッションクリア

            //フロー確認用
            System.out.println("セッションクリア");
        }
        
        //JSPへフォワード
        //RequestDispatcherインターフェイスを実装するクラスの
        //インスタンスを取得する
        //引数は転送先のURL
        RequestDispatcher dispatcher=
            request.getRequestDispatcher("hitandblow.jsp");
        
        //転送先に要求を転送する
        dispatcher.forward(request,response);
    }
}

