package ssafit.controller;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import ssafit.model.dto.User;
import ssafit.model.service.SsafitUserService;
import ssafit.model.service.SsafitUserServiceImpl;

@WebServlet("/user")
public class SsafitUserController extends HttpServlet {

	private SsafitUserService service = SsafitUserServiceImpl.getInstance();

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String act = request.getParameter("act");
		
		switch(act) {
		case "loginform":
			doLoginForm(request, response);
			break;
		case "login":
			doLogin(request, response);
			break;
		case "logout":
			doLogout(request, response);
			break;
		case "writeform":
			doWriteForm(request, response);
			break;
		case "write":
			doWrite(request, response);
			break;
		case "list":
			doList(request, response);
			break;
		case "detail":
			doDetail(request, response);
			break;
		case "update":
			doUpdate(request, response);
			break;
		case "delete":
			doDelete(request, response);
			break;
		}
	}
	
	private void doLoginForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/ssafit/user_login.jsp").forward(request, response);
		
	}
	
	private void doLogin(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userId = request.getParameter("userId");
		String password = request.getParameter("password");
		
		if (service.login(userId, password)) {
			HttpSession session = request.getSession();
			session.setAttribute("userId", userId);
			response.sendRedirect("index.jsp");
		}
		else {
			request.setAttribute("error", "아이디 또는 비밀번호가 잘못되었습니다!");
			request.getRequestDispatcher("/WEB-INF/ssafit/user_login.jsp").forward(request, response);
		}
	}
	
	private void doLogout(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.invalidate();
		response.sendRedirect("index.jsp");
	}

	private void doDetail(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("userId");

		request.setAttribute("user", service.selectOne(id));
		request.getRequestDispatcher("/WEB-INF/ssafit/user_detail.jsp").forward(request, response);

	}

	private void doList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<User> list = service.selectAll();

		request.setAttribute("list", list);
		request.getRequestDispatcher("/WEB-INF/ssafit/user_list.jsp").forward(request, response);

	}

	private void doWrite(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String userId = request.getParameter("userId");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String email = request.getParameter("email");

		User user = new User(userId, password, name, email);

		service.insertUser(user);

		response.sendRedirect("user?act=list");

	}
	
	private void doWriteForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/ssafit/user_register.jsp").forward(request, response);

	}

	private void doUpdate(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String userId = request.getParameter("userId");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String email = request.getParameter("email");

		User user = new User(userId, password, name, email);

		service.updateUser(user);

		response.sendRedirect("user?act=list");
	}
	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String userId = request.getParameter("userId");
		
		service.deleteUser(userId);
		
		response.sendRedirect("user?act=list");
	}
}
