package sec02.ex01;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;



public class MemberDAO {
	private Connection con; // 커넥션 참조변수 생성
	private PreparedStatement pstmt; //쿼리문을 매개변수로 받는 참조변수 생성
	private DataSource dataFactory; //Connection Pool 에서 Connection 을 사용할 수 있도록 해주는 DataSource 참조변수 생성
	
	public MemberDAO() {
		try {
			Context ctx = new InitialContext(); //Connection Pool에서 데이타소스 (커넥션)을 사용하기위한 jndi 서버 객체 생성후 전달 ctx에게
			
			Context envContext = (Context) ctx.lookup("java:/comp/env");
			dataFactory = (DataSource) envContext.lookup("jdbc/servletex");	//db 이름			
		} catch (Exception e) {
			
				e.printStackTrace();
		}
	
	}
	
	public List listMembers() {
		List membersList = new ArrayList();
		try {
			con = dataFactory.getConnection();
			String query = "select * from t_member order by joinDate desc";
			System.out.println(query);
			pstmt = con.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				String id = rs.getString("id");
				String pwd = rs.getString("pwd");
				String name = rs.getString("name");
				String email = rs.getString("email");
				Date joinDate = rs.getDate("joinDate");
				MemberVO memberVO = new MemberVO(id, pwd, name, email, joinDate);
				membersList.add(memberVO);
			}
			rs.close();
			pstmt.close();
			con.close();
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return membersList;
	}
	
	public void addMember(MemberVO m) {		//m 은 vo의 멤버 주소를 갖고있어서 값도있음
		try {
			con = dataFactory.getConnection();
			String id = m.getId();
			String pwd = m.getPwd();
			String name = m.getName();
			String email = m.getEmail();
			String query = "INSERT INTO t_member(id, pwd, name, email)" +" VALUES(?,?,?,?)";
			System.out.println(query);	
			pstmt = con.prepareStatement(query); 	//이걸로 쿼리구문이 집어넣어지는데 쪼개진다 ? ? ? ? 이부분
			pstmt.setString(1, id);		//? 의 첫번째 id 쓴데로 들감
			pstmt.setString(2, pwd);
			pstmt.setString(3, name);
			pstmt.setString(4, email);
			pstmt.executeUpdate();			//이걸로 실행
			pstmt.close();	
			con.close();
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
	}

}
