package sec01.ex01;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class MemberDAO {
	private static final String driver = "org.mariadb.jdbc.Driver";		//
	private static final String url = "jdbc:mariadb://127.0.0.1:3306/servletex";	// 마리아디비 로컬호스트 그리고 데이터베이스 이름 연동을시켜줘서 연결이된다
	private static final String user = "root";	//디비 아이디이고
	private static final String pwd = "1234";	// 패스워드이고
	private Connection con;					// 연결을 시켜주겠다는것
	private Statement stmt;					// 살짝 속도가 느리다 근데 =>> preparedStatement pstmt; <<= 이건 더 빠름
	
	public List<MemberVO> listMembers() {
		List<MemberVO> list = new ArrayList<MemberVO>();
		try {
			connDB();
			String query = "select * from t_member";
			System.out.println(query);
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()) {
				String id = rs.getString("id");
				String pwd = rs.getString("pwd");
				String name = rs.getString("name");
				String email = rs.getString("email");
				Date joinDate = rs.getDate("joinDate");
				MemberVO vo = new MemberVO();
				vo.setId(id);
				vo.setPwd(pwd);
				vo.setName(name);
				vo.setEmail(email);
				vo.setJoinDate(joinDate);
				list.add(vo);
			}
			rs.close();
			stmt.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
		//실질적인 연결은 여기밑에서 하는거다 위에서는 문자열을 넣은것뿐
	private void connDB() {
		try {
				Class.forName(driver);	//forName 어디있나
				System.out.println("mariadb 드라이버 로딩 성공");
				con = DriverManager.getConnection(url, user, pwd);
				System.out.println("Connection 생성 성공");
				stmt = con.createStatement();		// 이걸 이용해서 연결상태를 계속 유지시켜주는거다 크리에이트 스테이먼트 클로즈 되기전까지 
				System.out.println("Statement 생성 성공");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
