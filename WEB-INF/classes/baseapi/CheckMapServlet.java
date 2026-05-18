package baseapi;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpServlet;

import java.util.Map;

public class CheckMapServlet extends HttpServlet {
   	public void doGet(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException{
        
        req.setCharacterEncoding("UTF-8");

        Map<String,String[]> map = req.getParameterMap();

        req.setAttribute("map",map);

        RequestDispatcher dispatcher = req.getRequestDispatcher("checkmap.jsp");

        dispatcher.forward(req,res);
	}
}
