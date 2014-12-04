package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.DBUtil;
import entity.UserQuestion;
public class UserQuestionDao {
	private UserQuestion createUserQuestion(ResultSet rs) 
			throws SQLException {
		UserQuestion c = new UserQuestion();
			c.setQuestionId(rs.getInt("questionId"));
			c.setUserName(rs.getString("userName"));
			c.setCtime(rs.getString("ctime"));
			c.setEmail(rs.getString("email"));
			c.setContent(rs.getString("content"));
			return c;
		}
	public List<UserQuestion> findAll() throws DAOException {
		List<UserQuestion> list = new ArrayList<UserQuestion>();
		String sql = "select * from user_question";
		Connection con = DBUtil.getConnection();
		try {
			PreparedStatement ps = 
				con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				UserQuestion c = createUserQuestion(rs);
				list.add(c);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException(
					"查询数据失败", e);
		} finally {
			DBUtil.closeConnection();
		}
		return list;
	}

	public List<UserQuestion> findByPage(int page, int pageSize)
			throws DAOException {
		List<UserQuestion> list = new ArrayList<UserQuestion>();
		String sql = "select * from user_question limit ?,?";
		Connection con = DBUtil.getConnection();
		try {
			PreparedStatement ps = 
				con.prepareStatement(sql);
			ps.setInt(1, page*pageSize);
			ps.setInt(2, pageSize);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				UserQuestion c = createUserQuestion(rs);
				list.add(c);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException(
					"分页查询失败", e);
		} finally {
			DBUtil.closeConnection();
		}
		return list;
	}

	public int findTotalPage(int pageSize) throws DAOException {
		String sql = "select count(*) from user_question";
		Connection con = DBUtil.getConnection();
		try {
			PreparedStatement ps = 
				con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				int rows = rs.getInt(1);
				if(rows % pageSize == 0) {
					return rows/pageSize;
				} else {
					return rows/pageSize+1;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException(
					"查询总页数失败", e);
		} finally {
			DBUtil.closeConnection();
		}
		return 0;
	}

	public void deleteUserQuestion(int id) throws DAOException {
		String sql = "delete from user_question where questionId=?";
		Connection con = DBUtil.getConnection();
		try {
			con.setAutoCommit(false);
			PreparedStatement ps = 
				con.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
			con.commit();
		} catch (SQLException e) {
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
			throw new DAOException(
					"删除失败",e);
		} finally {
			DBUtil.closeConnection();
		}
		
	}

	public UserQuestion findByName(String name) throws DAOException {
		if(name == null)
			return null;
		
		String sql = "select * from user_question where userName=?";
		Connection con = DBUtil.getConnection();
		try {
			PreparedStatement ps = 
				con.prepareStatement(sql);
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				UserQuestion admin = createUserQuestion(rs);
				return admin;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException(
					"根据名称查找",e);
		} finally {
			DBUtil.closeConnection();
		}
		
		return null;
	}

	public void addUserQuestion(UserQuestion up) throws DAOException {
		if(up == null)
			return;
		String sql = "insert into user_question(userName,email,content)" +
				"values(?,?,?)";
		Connection con = DBUtil.getConnection();
		try {
			con.setAutoCommit(false);
			PreparedStatement ps = 
				con.prepareStatement(sql);
			ps.setString(1, up.getUserName());
			ps.setString(2, up.getEmail());
			ps.setString(3, up.getContent());
			ps.executeUpdate();
			con.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			throw new DAOException(
					"新增失败",e);
		} finally {
			DBUtil.closeConnection();
		}
		
	}

	public UserQuestion findById(Integer id) throws DAOException {
		if(id == null)
			return null;
		
		String sql = "select * from user_question where questionId=?";
		Connection con = DBUtil.getConnection();
		try {
			PreparedStatement ps = 
				con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				UserQuestion admin = createUserQuestion(rs);
				return admin;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException(
					"根据Id查找",e);
		} finally {
			DBUtil.closeConnection();
		}
		
		return null;
	}

	public void updateUserQuestion(UserQuestion up) throws DAOException {
		if(up == null) {
			return;
		}
		String sql = "update user_question set " +
				"userName=?,ctime=?" +
				"email=?,content=? where questionId=?";
				
		Connection con = DBUtil.getConnection();
		try {
			con.setAutoCommit(false);
			PreparedStatement ps = 
				con.prepareStatement(sql);
			ps.setInt(5,up.getQuestionId());
			ps.setString(1, up.getUserName());
			ps.setString(2, up.getCtime());
			ps.setString(3, up.getEmail());
			ps.setString(4, up.getContent());
			ps.executeUpdate();
			con.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			throw new DAOException(
					"更新失败",e);
		} finally {
			DBUtil.closeConnection();
		}
		
	}
}
