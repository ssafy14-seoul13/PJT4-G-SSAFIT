package ssafit.controller;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import ssafit.model.dto.Review;
import ssafit.model.service.SsafitReviewService;
import ssafit.model.service.SsafitReviewServiceImpl;

@WebServlet("/review")
public class SsafitReviewController extends HttpServlet {

    private SsafitReviewService service = SsafitReviewServiceImpl.getInstance();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String act = request.getParameter("act");
        
        String videoId = request.getParameter("videoId");
        String forwardUrl = "/video?act=detail&id=" + videoId;

        switch (act) {
            case "list":
                doList(request, response);
                break;
            case "write":
                doWrite(request, response);
                String writeVideoId = request.getParameter("videoId");
                String writeForwardUrl = "/video?act=detail&id=" + writeVideoId;
                response.sendRedirect(request.getContextPath() + writeForwardUrl);
                break;
            case "update":
                doUpdate(request, response);
                response.sendRedirect(request.getContextPath() + forwardUrl);
                break;
            case "delete":
                doDelete(request, response);
                response.sendRedirect(request.getContextPath() + forwardUrl);
                break;
        }
    }

    protected void doList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String videoId = request.getParameter("videoId");
        List<Review> list = service.getReviewList(videoId);
        request.setAttribute("reviewList", list);
        request.getRequestDispatcher("/WEB-INF/ssafit/video_detail.jsp").forward(request, response);
    }

    protected void doWrite(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String videoId = request.getParameter("videoId");
        String content = request.getParameter("content");
        
        HttpSession session = request.getSession();
        String userId = (String) session.getAttribute("userId");

        Review review = new Review(videoId, userId, content);
        service.createReview(review);
    }

    protected void doUpdate(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int reviewId = Integer.parseInt(request.getParameter("reviewId"));
        String content = request.getParameter("content");

        Review review = service.getReview(reviewId);
        if (review != null) {
            review.setContent(content);
            service.modifyReview(review);
        }
    }

    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int reviewId = Integer.parseInt(request.getParameter("reviewId"));
        service.removeReview(reviewId);
    }
}
