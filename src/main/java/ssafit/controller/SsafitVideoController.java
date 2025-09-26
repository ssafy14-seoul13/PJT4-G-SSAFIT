package ssafit.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ssafit.model.service.SsafitVideoService;
import ssafit.model.service.SsafitVideoServiceImpl;

@WebServlet("/ssafit")
public class SsafitVideoController extends HttpServlet {

	private SsafitVideoService service = SsafitVideoServiceImpl.getInstance();
	
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String act = req.getParameter("act");
		
		switch(act) {
		case "selectAll":
			
		}
	}
	
}
