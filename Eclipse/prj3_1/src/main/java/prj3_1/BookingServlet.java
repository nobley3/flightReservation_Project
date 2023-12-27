package prj3_1;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONArray;
@WebServlet("/booking.do")
public class BookingServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		
		HttpSession session  = req.getSession();
		
		String seatnum = req.getParameter("fromData");
		session.setAttribute("seatnum",seatnum);
		String id = (String)session.getAttribute("id");
		String fcode= (String)session.getAttribute("selectFlight");
		
		AirlineService as = new AirlineService();
		Flight sc = as.getflight(fcode);
		session.setAttribute("fightInfo",sc);
		L_joinService ps = new L_joinService();
		L_Customer c = ps.selectByid(id);
		session.setAttribute("userinfo", c);
		System.out.println(c);
		req.getRequestDispatcher("WEB-INF/views/bookingCheck.jsp").forward(req, resp);
		

	}

}
