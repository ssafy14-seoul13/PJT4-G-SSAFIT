package ssafit.model.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ssafit.model.dto.Video;
import ssafit.util.DBUtil;

public class SsafitVideoRepositoryImpl implements SsafitVideoRepository {

	private DBUtil util = DBUtil.getInstance();
	private static SsafitVideoRepository repo = new SsafitVideoRepositoryImpl();

	private SsafitVideoRepositoryImpl() {

	}

	public static SsafitVideoRepository getInstance() {
		return repo;
	}

	@Override
	public List<Video> selectAll() {
		List<Video> list = new ArrayList<>();
		String sql = "SELECT * FROM video";
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			conn = util.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Video video = new Video(); // 바구니
				video.setId(rs.getString("id"));
				video.setTitle(rs.getString("title"));
				video.setPart(rs.getString("part"));
				video.setChannelName(rs.getString("channel_Name"));
				video.setUrl(rs.getString("url"));
				list.add(video);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			util.close(rs, stmt, conn);
		}
		return list;
	}

	@Override
	public Video selectOne(String id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
//		String sql = "SELECT * FROM board WHERE id="+id;
		String sql = "SELECT * FROM video WHERE id=?";
		Video video = null; // 바구니
		try {
			conn = util.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				video = new Video();
				video.setId(rs.getString("id"));
				video.setTitle(rs.getString("title"));
				video.setPart(rs.getString("part"));
				video.setChannelName(rs.getString("channel_name"));
				video.setUrl(rs.getString("url"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			util.close(rs, pstmt, conn);
		}

		return video;
	}

	@Override
	public void insertVideo(Video video) {
		Connection conn = null;
		PreparedStatement pstmt = null;
//		String sql = "INSERT INTO board (title, writer, content) VALUES('"+board.getTitle()"',"+'"+\")";
		String sql = "INSERT INTO video (id, title, part, channel_name, url) VALUES(?,?,?,?,?)";

		try {
			conn = util.getConnection();

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, video.getId());
			pstmt.setString(2, video.getTitle());
			pstmt.setString(3, video.getPart());
			pstmt.setString(4, video.getChannelName());
			pstmt.setString(5, video.getUrl());
			
			int result = pstmt.executeUpdate();

			System.out.println(result);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			util.close(pstmt, conn);
		}
	}

	@Override
	public void updateVideo(Video video) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE video SET id=?, title=?, part=?, channel_name=?, url=?";
		try {
			conn = util.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, video.getId());
			pstmt.setString(2, video.getTitle());
			pstmt.setString(3, video.getPart());
			pstmt.setString(4, video.getChannelName());
			pstmt.setString(5, video.getUrl());
			

			int result = pstmt.executeUpdate();

			System.out.println(result);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			util.close(pstmt, conn);
		}

	}

	@Override
	public void deleteVideo(String id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM video WHERE id=?";
		try {
			conn = util.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);

			int result = pstmt.executeUpdate();

			System.out.println(result);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			util.close(pstmt, conn);
		}

	}
}
