package edu.web.jsp02.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.web.jsp02.domain.Post;
import edu.web.jsp02.service.PostService;
import edu.web.jsp02.service.PostServiceImpl;
import lombok.extern.slf4j.Slf4j;

/**
 * Servlet implementation class PostModifyController
 */
@Slf4j
@WebServlet(name = "postModifyController", urlPatterns = { "/post/modify" })
public class PostModifyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private PostService postService;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostModifyController() {
        postService = PostServiceImpl.getInstance();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
	        throws ServletException, IOException {
		log.info("doGet()");
		
		// 요청 파라미터 id(포스트 번호) 찾기.
		Integer id = Integer.valueOf(request.getParameter("id"));
		log.info("id = {}", id);
		
		// id(포스트 번호)로 레코드 찾기.
		Post post = postService.read(id);
		
		// 뷰에 전달
		request.setAttribute("post", post);
		request.getRequestDispatcher("/WEB-INF/post/modify.jsp")
		    .forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
	        throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
