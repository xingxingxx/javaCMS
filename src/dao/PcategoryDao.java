package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.DBUtil;
import entity.Pcategory;

public class PcategoryDao {
	private Pcategory createPcategory(ResultSet rs) 
			throws SQLException {
		Pcategory c = new Pcategory();
			c.setCategoryId(rs.getInt("categoryId"));
			c.setCategoryName(rs.getString("categoryName"));
			return c;
		}

	public List<Pcategory> findAll() throws DAOException {
		List<Pcategory> list = new ArrayList<Pcategory>();
		String sql = "select * from p_category order by categoryId asc";
		Connection con = DBUtil.getConnection();
		try {
			PreparedStatement ps = 
				con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Pcategory c = createPcategory(rs);
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

	public List<Pcategory> findByPage(int page, int pageSize)
			throws DAOException {
		List<Pcategory> list = new ArrayList<Pcategory>();
		String sql = "select * from p_category limit ?,?";
		Connection con = DBUtil.getConnection();
		try {
			PreparedStatement ps = 
				con.prepareStatement(sql);
			ps.setInt(1, page*pageSize);
			ps.setInt(2, pageSize);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Pcategory c = createPcategory(rs);
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
		String sql = "select count(*) from p_category";
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

	public void deletePcategory(int id) throws DAOException {
		String sql = "delete from p_category where categoryId=?";
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

	public Pcategory findByName(String name) throws DAOException {
		if(name == null)
			return null;
		
		String sql = "select * from p_category where categoryName=?";
		Connection con = DBUtil.getConnection();
		try {
			PreparedStatement ps = 
				con.prepareStatement(sql);
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				Pcategory admin = createPcategory(rs);
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

	public void addPcategory(String name) throws DAOException {
		if(name == null)
			return;
		String sql = "insert into p_category(categoryName) " +
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

	public Pcategory findById(Integer id) throws DAOException {
		if(id == null)
			return null;
		
		String sql = "select * from p_category where categoryId=?";
		Connection con = DBUtil.getConnection();
		try {
			PreparedStatement ps = 
				con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				Pcategory admin = createPcategory(rs);
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

	public void updatePcategory(Pcategory pc) throws DAOException {
		if(pc == null) {
			return;
		}
		String sql = "update p_category set " +
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
