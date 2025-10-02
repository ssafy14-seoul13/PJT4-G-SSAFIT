package ssafit.model.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ssafit.model.dto.User;
import ssafit.util.DBUtil;

public class SsafitUserRepositoryImpl implements SsafitUserRepository {

//	private List<User> list = new ArrayList<>();

	private DBUtil util = DBUtil.getInstance();
	
	private static SsafitUserRepository repo = new SsafitUserRepositoryImpl();

	private SsafitUserRepositoryImpl() {

	}

	public static SsafitUserRepository getInstance() {
		return repo;
	}
	
	@Override
	public boolean login(String userId, String password) {
		if (repo.selectOne(userId).getPassword().equals(password))
			return true;
		
		return false;
	}

	@Override
	public List<User> selectAll() {
//		return list;
		
		List<User> list = new ArrayList<>();
		String sql = "SELECT * FROM user";
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			conn = util.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				User user = new User(); 
				user.setUserId(rs.getString("user_id"));
				user.setPassword(rs.getString("password"));
				user.setName(rs.getString("name"));
				user.setEmail(rs.getString("email"));
				list.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			util.close(rs, stmt, conn);
		}
		return list;
	}

	@Override
	public User selectOne(String userId) {
//		for (User user : list) {
//			if (user.getUserId().equals(userId))
//				return user;
//		}
//		return null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM user WHERE user_id=?";
		User user = null; 
		try {
			conn = util.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				user = new User();
				user.setUserId(rs.getString(1));
				user.setPassword(rs.getString(2));
				user.setName(rs.getString(3));
				user.setEmail(rs.getString(4));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			util.close(rs, pstmt, conn);
		}

		return user;
		
	}

	@Override
	public void insertUser(User user) {
//		list.add(user); 
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO user (user_id, password, name, email) VALUES(?,?,?,?)";

		try {
			conn = util.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, user.getUserId());
			pstmt.setString(2, user.getPassword());
			pstmt.setString(3, user.getName());
			pstmt.setString(4, user.getEmail());

			int result = pstmt.executeUpdate();

			System.out.println(result);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			util.close(pstmt, conn);
		}
	}

	@Override
	public void updateUser(User user) {
//		for (User userOrigin : list) {
//			if (user.getUserId().equals(userOrigin.getUserId())) {
//				list.remove(userOrigin);
//				list.add(user);
//				break;
//			}
//		}
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE user SET user_id=?, password=?, name=?, email=? WHERE user_id=?";
		try {
			conn = util.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, user.getUserId());
			pstmt.setString(2, user.getPassword());
			pstmt.setString(3, user.getName());
			pstmt.setString(4, user.getEmail());
			pstmt.setString(5, user.getUserId());

			int result = pstmt.executeUpdate();

			System.out.println(result);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			util.close(pstmt, conn);
		}

	}

	@Override
	public void deleteUser(String userId) {
//		for (User user : list) {
//			if (user.getUserId().equals(userId)) {
//				list.remove(user);
//				break;
//			}
//		}
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM user WHERE user_id=?";
		try {
			conn = util.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);

			int result = pstmt.executeUpdate();

			System.out.println(result);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			util.close(pstmt, conn);
		}
	}


}
