import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;

public class MultiFormServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("Windows-31J");
        Map map = request.getParameterMap();
        Set keySet = map.keySet();
        Iterator it = keySet.iterator();

        

        PrintWriter out = response.getWriter();
        response.setContentType("text/html; charset=Shift_JIS");
        out.println("<html><body><h1>");
        while(it.hasNext()){
            String name = (String)it.next();
            out.println(name +"<br>");
            System.out.println(name);
            String[] sArray = (String[])map.get(name);
            for (int i = 0;i<sArray.length;i++) {
                out.println(sArray[i]+"<br>");
                System.out.println(sArray[i]);

            } 
        }
        out.println("</h1></body</html>");





	}
}


