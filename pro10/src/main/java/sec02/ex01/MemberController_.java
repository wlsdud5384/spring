package sec02.ex01;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



				//폼의 1차매핑이 연결됨
@WebServlet("/member151/*")
public class MemberController_ extends HttpServlet {
	
	MemberDAO memberDAO;
	
	
	public void init(ServletConfig config) throws ServletException {
		memberDAO = new MemberDAO();
	}

	
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doHandle(request, response);
	}
	
	private void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nextPage = null;	//변수다 일단은 널 넣음 
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/htmlcharset=utf-8");
		String action = request.getPathInfo();	//겟 패스인포 액션값을 갖고온다 매핑 가장 하위매핑 애드멤버가된다  
		System.out.println("action:" + action);	//여기에 애드멤버. 두 이렇게 출력된다
		
		if(action == null || action.equals("/listMembers.do")) {
			List<MemberVO> membersList = memberDAO.listMembers();
				request.setAttribute("membersList", membersList);
				nextPage = "/test04/listMembers.jsp";
		} else if(action.equals("/addMember.do")) {	 //여기에 애드멤버.두
			String id = request.getParameter("id");
			String pwd = request.getParameter("pwd");
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			MemberVO memberVO = new MemberVO(id, pwd, name, email);		// 멤버vo 생성해주면서 값을 각각 전달해준다
			memberDAO.addMember(memberVO);		//이 안에는 아이디 패드워드 네임 등 있음
			nextPage = "/member151/listMembers.do";	
		} else if(action.equals("/memberForm.do")) {
			nextPage = "/test04/memberForm.jsp";
		}else {
			List<MemberVO> membersList = memberDAO.listMembers();
			request.setAttribute("membersList", membersList);
			nextPage = "/test04/listMembers.jsp";
		}
		RequestDispatcher dispatch = request.getRequestDispatcher(nextPage);
		dispatch.forward(request, response);
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doHandle(request, response);
	}

}
