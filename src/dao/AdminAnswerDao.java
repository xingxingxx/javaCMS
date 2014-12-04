package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import util.DBUtil;
import entity.AdminAnswer;


public class AdminAnswerDao {
	private AdminAnswer createAdminAnswer(ResultSet rs) 
			throws SQLException {
		AdminAnswer c = new AdminAnswer();
		c.setAnswerId(rs.getInt("answerId"));
		c.setAdminName(rs.getString("adminName"));
		c.setQuestionId(rs.getInt("questionId"));
		c.setCtime(rs.getString("ctime"));
		c.setContent(rs.getString("content"));
		return c;
		}

	public List<AdminAnswer> findAll() throws DAOException {
		List<AdminAnswer> list = new ArrayList<AdminAnswer>();
		String sql = "select * from admin_answer";
		Connection con = DBUtil.getConnection();
		try {
			PreparedStatement ps = 
				con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				AdminAnswer c = createAdminAnswer(rs);
				list.add(c);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException(
					"查询数据失败！", e);
		} finally {
			DBUtil.closeConnection();
		}
		return list;
	}

	public List<AdminAnswer> findByPage(int page, int pageSize)
			throws DAOException {
		List<AdminAnswer> list = new ArrayList<AdminAnswer>();
		String sql = "select * from admin_answer limit ?,?";
		Connection con = DBUtil.getConnection();
		try {
			PreparedStatement ps = 
				con.prepareStatement(sql);
			ps.setInt(1, page*pageSize);
			ps.setInt(2, pageSize);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				AdminAnswer c = createAdminAnswer(rs);
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
		String sql = "select count(*) from admin_answer";
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

	public void deleteAdminAnswer(int id) throws DAOException {
		String sql = "delete from admin_answer where answerId=?";
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
	
	public void deleteAdminAnswer2(int id) throws DAOException {
		String sql = "delete from admin_answer where questionId=?";
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

	public AdminAnswer findByName(String name) throws DAOException {
		if(name == null)
			return null;
		
		String sql = "select * from admin_answer where adminName=?";
		Connection con = DBUtil.getConnection();
		try {
			PreparedStatement ps = 
				con.prepareStatement(sql);
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				AdminAnswer admin = createAdminAnswer(rs);
				return admin;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException(
					"根据名称查找失败",e);
		} finally {
			DBUtil.closeConnection();
		}
		
		return null;
	}

	public void addAdminAnswer(AdminAnswer aa) throws DAOException {
		if(aa == null)
			return;
		String sql = "insert into admin_answer(adminName,questionId,content) " +
				"values(?,?,?)";
		Connection con = DBUtil.getConnection();
		try {
			con.setAutoCommit(false);
			PreparedStatement ps = 
				con.prepareStatement(sql);
			ps.setString(1, aa.getAdminName());
			ps.setInt(2, aa.getQuestionId());
			ps.setString(3, aa.getContent());
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

	public AdminAnswer findById(Integer id) throws DAOException {
		if(id == null)
			return null;
		
		String sql = "select * from admin_answer where answerId=?";
		Connection con = DBUtil.getConnection();
		try {
			PreparedStatement ps = 
				con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				AdminAnswer admin = createAdminAnswer(rs);
				return admin;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException(
					"根据Id查找失败",e);
		} finally {
			DBUtil.closeConnection();
		}
		
		return null;
	}
	

	public void updateAdminAnswer(AdminAnswer aa) throws DAOException {
		if(aa == null) {
			return;
		}
		String sql = "update admin_answer set " +
				"adminName=?,questionId=?,ctime=?,content=?" +
				"where answerId=?";
				
		Connection con = DBUtil.getConnection();
		try {
			con.setAutoCommit(false);
			PreparedStatement ps = 
				con.prepareStatement(sql);
			ps.setInt(5, aa.getAnswerId());
			ps.setString(1, aa.getAdminName());
			ps.setInt(2, aa.getQuestionId());
			ps.setString(3, aa.getCtime());
			ps.setString(4, aa.getContent());
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
