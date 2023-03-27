package boad;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;



public class StudDAO {
	private static Connection con; // 커넥션 참조변수 생성
	private static PreparedStatement pstmt; //쿼리문을 매개변수로 받는 참조변수 생성
	private static DataSource dataFactory;
	
	
	public StudDAO() {
		try {
			Context ctx = new InitialContext(); //Connection Pool에서 데이타소스 (커넥션)을 사용하기위한 jndi 서버 객체 생성후 전달 ctx에게
			
			Context envContext = (Context) ctx.lookup("java:/comp/env");
			dataFactory = (DataSource) envContext.lookup("jdbc/protest");	//db 이름			
		} catch (Exception e) {
			
				e.printStackTrace();
		}
	
	}
	
	public StudDAO(String id, String username, String univ, String email, String birth) {
		// TODO Auto-generated constructor stub
	}

	public static List listMembers() {
		List membersList = new ArrayList();
		try {
			con = dataFactory.getConnection();
			String query = "select * from boad order by id";
			System.out.println(query);
			pstmt = con.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				String id = rs.getString("id");
				String username = rs.getString("username");
				String univ = rs.getString("univ");
				String birth = rs.getString("birth");
				String email = rs.getString("email");
				
				StudDAO memberVO = new StudDAO(id, username, univ, email, birth);
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
	
	
	
	public void addMember(StudVO m) {		//m 은 vo의 멤버 주소를 갖고있어서 값도있음
		try {
			con = dataFactory.getConnection();
			conDB();
			String id = m.getId();
			String username = m.getPwd();
			String univ = m.getName();
			String birth = m.getEmail();
			String email = m.getName1();
			String query = "INSERT INTO boad(id, username, univ, birth, email)" +" VALUES(?,?,?,?,?)";
			System.out.println(query);	
			pstmt = con.prepareStatement(query); 	//이걸로 쿼리구문이 집어넣어지는데 쪼개진다 ? ? ? ? 이부분
			pstmt.setString(1, id);		//? 의 첫번째 id 쓴데로 들감
			pstmt.setString(2, username);
			pstmt.setString(3, univ);
			pstmt.setString(4, birth);
			pstmt.setString(5, email);
			pstmt.executeUpdate();			//이걸로 실행
			pstmt.close();	
			con.close();
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
	}

	private void conDB() {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
}
