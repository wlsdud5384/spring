package sec02.ex01;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;



public class CalcDAO2 {
	private static final String driver = "org.mariadb.jdbc.Driver";
	private static final String url = "jdbc:mariadb://localhost:3306/calc";
	private static final String user = "root";
	private static final String pwd = "1234";
	private Connection con;
	private PreparedStatement pstmt;
	
	public List listMembers() {
		List list = new ArrayList();
		try {
			connDB();
			String query = "select * from calc_a";
			System.out.println("prepareStatememt: " + query);
			pstmt = con.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				int n1 = rs.getInt("n1");
				String nn = rs.getString("nn");
				int n2 = rs.getInt("n2");
				long result = rs.getLong("result");
				
				CalcBean vo = new CalcBean();
				vo.setN1(n1);
				vo.setN2(n2);
				vo.setNn(nn);
				vo.setResult(result);
				list.add(vo);
			}
			rs.close();
			pstmt.close();
			con.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public void addMember(CalcBean calcBean) {
		try {
			connDB();
			int n1 = calcBean.getN1();
			String nn = calcBean.getNn();
			int n2 = calcBean.getN2();
			long result = calcBean.getSum();
			
			String query = "insert into calc_a";
			query += " (n1,nn,n2,result)";
			query += "values(?,?,?,?)";
			System.out.println("prepareStatememt: " + query);
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, n1);
			pstmt.setString(2, nn);
			pstmt.setInt(3, n2);
			pstmt.setLong(4, result);
			pstmt.executeUpdate();
			pstmt.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private void connDB() {
			try {
				Class.forName(driver);
				System.out.println("Oracle 드라이버 로딩 성공");
				con = DriverManager.getConnection(url, user, pwd);
				System.out.println("Connection 생성 성공");
			} catch(Exception e) {
				e.printStackTrace();
			}
	}
	
}