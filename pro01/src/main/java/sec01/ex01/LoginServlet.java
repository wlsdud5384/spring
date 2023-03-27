package sec01.ex01;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {

   public void init(ServletConfig config) throws ServletException {
      
      System.out.println("init 메서드 호출");
      
   }

   /**
    * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

      request.setCharacterEncoding("utf-8");
      String user_id = request.getParameter("user_id");
      String user_pw = request.getParameter("user_pw");
      System.out.println("아이디 : " + user_id);
      System.out.println("비밀번호 : " + user_pw);
   }
   
   /**
    * @see Servlet#destroy()
    */
   public void destroy() {
      
      System.out.println("destroy 메서드 호출");
      
   }


}