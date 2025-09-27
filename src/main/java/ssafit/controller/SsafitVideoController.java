package ssafit.controller;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ssafit.model.dto.Video;
import ssafit.model.service.SsafitVideoService;
import ssafit.model.service.SsafitVideoServiceImpl;

@WebServlet("/video") // "/ssafit"에서 "/video"로 변경
public class SsafitVideoController extends HttpServlet {

	private SsafitVideoService service = SsafitVideoServiceImpl.getInstance();

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String act = request.getParameter("act");

		switch (act) {
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

	private void doDetail(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 파라미터 이름을 "userId" -> "id"로 수정
		String id = request.getParameter("id"); 
		
		// setAttribute의 key값을 "title" -> "video"로 수정
		request.setAttribute("video", service.selectOne(id)); 
		request.getRequestDispatcher("/WEB-INF/ssafit/video_detail.jsp").forward(request, response);
	}

	private void doList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Video> list = service.selectAll();
		request.setAttribute("list", list);
		request.getRequestDispatcher("/WEB-INF/ssafit/video_list.jsp").forward(request, response);
	}

	private void doWrite(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String id = request.getParameter("id");
		String title = request.getParameter("title");
		String part = request.getParameter("part");
		String channelName = request.getParameter("channelName");
		String url = request.getParameter("url");

		Video video = new Video(id, title, part, channelName, url);
		service.insertVideo(video);

		// 서블릿 매핑과 일치하도록 "video?act=list" 사용
		response.sendRedirect("video?act=list");
	}

	private void doWriteForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/ssafit/video_register.jsp").forward(request, response);
	}

	private void doUpdate(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		String title = request.getParameter("title");
		String part = request.getParameter("part");
		String channelName = request.getParameter("channelName");
		String url = request.getParameter("url");

		Video video = new Video(id, title, part, channelName, url);
		service.updateVideo(video);

		response.sendRedirect("video?act=list");
	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		service.deleteVideo(id);

		// "user?act=list" -> "video?act=list"로 수정
		response.sendRedirect("video?act=list"); 
	}
}