package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.DBUtil;
import entity.DocCategory;

public class DocCategoryDao {
	private DocCategory createDocCategory(ResultSet rs) 
			throws SQLException {
		DocCategory c = new DocCategory();
			c.setCategoryId(rs.getInt("categoryId"));
			c.setCategoryName(rs.getString("categoryName"));
			return c;
		}

	public List<DocCategory> findAll() throws DAOException {
		List<DocCategory> list = new ArrayList<DocCategory>();
		String sql = "select * from doc_category order by categoryId asc";
		Connection con = DBUtil.getConnection();
		try {
			PreparedStatement ps = 
				con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				DocCategory c = createDocCategory(rs);
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
	
	public List<DocCategory> findByPage(int page, int pageSize)
			throws DAOException {
		List<DocCategory> list = new ArrayList<DocCategory>();
		String sql = "select * from doc_category limit ?,?";
		Connection con = DBUtil.getConnection();
		try {
			PreparedStatement ps = 
				con.prepareStatement(sql);
			ps.setInt(1, page*pageSize);
			ps.setInt(2, pageSize);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				DocCategory c = createDocCategory(rs);
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


	

	public void deleteDocCategory(int id) throws DAOException {
		String sql = "delete from doc_category where categoryId=?";
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

	public DocCategory findByName(String name) throws DAOException {
		if(name == null)
			return null;
		
		String sql = "select * from doc_category where categoryName=?";
		Connection con = DBUtil.getConnection();
		try {
			PreparedStatement ps = 
				con.prepareStatement(sql);
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				DocCategory admin = createDocCategory(rs);
				return admin;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException(
					"根据名称查询失败",e);
		} finally {
			DBUtil.closeConnection();
		}
		
		return null;
	}

	public void addDocCategory(String name) throws DAOException {
		if(name == null)
			return;
		String sql = "insert into doc_category(categoryName) " +
				"values(?)";
		Connection con = DBUtil.getConnection();
		try {
			con.setAutoCommit(false);
			PreparedStatement ps = 
				con.prepareStatement(sql);
			ps.setString(1, name);
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

	public DocCategory findById(Integer id) throws DAOException {
		if(id == null)
			return null;
		
		String sql = "select * from doc_category where categoryId=?";
		Connection con = DBUtil.getConnection();
		try {
			PreparedStatement ps = 
				con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				DocCategory admin = createDocCategory(rs);
				return admin;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException(
					"根据Id查询失败",e);
		} finally {
			DBUtil.closeConnection();
		}
		return null;
	}

	public void updateDocCategory(DocCategory pc) throws DAOException {
		if(pc == null) {
			return;
		}
		String sql = "update doc_category set " +
				"categoryName=? where categoryId=?";
		Connection con = DBUtil.getConnection();
		try {
			con.setAutoCommit(false);
			PreparedStatement ps = 
				con.prepareStatement(sql);
			ps.setInt(2, pc.getCategoryId());
			ps.setString(1, pc.getCategoryName());
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
