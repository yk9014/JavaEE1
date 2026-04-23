package taglibs;

import java.io.IOException;
import jakarta.servlet.jsp.JspException;
import jakarta.servlet.jsp.JspWriter;
import jakarta.servlet.jsp.tagext.TagSupport;

public class HelloTag extends TagSupport {

	public int doStartTag() throws JspException {
		
		try {
			pageContext.getOut().println("<p>Hello</p>");
			
			//抽象クラスjakarta.servlet.jsp.JspWriterの
			//サブクラスのインスタンスを取得する
			JspWriter w=pageContext.getOut();
			
			pageContext.getOut().println("クラス名："+w.getClass().getName());
			
		} catch (IOException e) {
			//例外をラップして送出する
			throw new JspException(e);
		}
		
		//タグボディを評価しない
		return SKIP_BODY;
	}
}
