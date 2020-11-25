package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import vo.Member;
import static db.JdbcUtil.*;

public class LoginDAO {
	private static LoginDAO loginDAO;
	private Connection con;
	
	
	private LoginDAO() {
	}

	public static LoginDAO getInstance() {
		if(loginDAO == null) {
			loginDAO = new LoginDAO();
		}
		return loginDAO;
	}

	public void setConnection(Connection con) {
		this.con = con;
	}

	public Member selectLoginMember(String id, String passwd) {
		Member loginMember = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = con.prepareStatement("select * from users where id = ? and passwd = ?");
			pstmt.setString(1, id);
			pstmt.setString(2, passwd);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				loginMember = new Member();
				loginMember.setId(rs.getString("id"));
				loginMember.setPasswd(rs.getString("passwd"));
				loginMember.setAddr(rs.getString("addr"));
				loginMember.setAge(rs.getInt("age"));
				loginMember.setEmail(rs.getString("email"));
				loginMember.setGender(rs.getString("gender"));
				loginMember.setName(rs.getString("name"));
				loginMember.setNation(rs.getString("nation"));
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				close(pstmt);
				close(rs);
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		return loginMember;
	}

}