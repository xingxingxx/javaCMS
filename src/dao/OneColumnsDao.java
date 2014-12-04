package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.DBUtil;
import entity.OneColumns;

public class OneColumnsDao {
	private OneColumns createOneColumns(ResultSet rs) 
			throws SQLException {
		OneColumns c = new OneColumns();
		c.setColumnsId(rs.getInt("columnsId"));
		c.setColumnName(rs.getString("columnName"));
		c.setColumnPosition(rs.getInt("columnPosition"));
		c.setIsDisplay(rs.getInt("isDisplay"));
		return c;
		}

	public List<OneColumns> findAll() throws DAOException {
		List<OneColumns> list = new ArrayList<OneColumns>();
		String sql = "select * from one_columns order by columnPosition asc";
		Connection con = DBUtil.getConnection();
		try {
			PreparedStatement ps = 
				con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				OneColumns c = createOneColumns(rs);
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
	
	public List<OneColumns> findAllDown() throws DAOException {
		List<OneColumns> list = new ArrayList<OneColumns>();
		String sql = "select * from one_columns where isDisplay=1 order by columnPosition desc";
		Connection con = DBUtil.getConnection();
		try {
			PreparedStatement ps = 
				con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				OneColumns c = createOneColumns(rs);
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

	public List<OneColumns> findByPage(int page, int pageSize)
			throws DAOException {
		List<OneColumns> list = new ArrayList<OneColumns>();
		String sql = "select * from one_columns limit ?,?";
		Connection con = DBUtil.getConnection();
		try {
			PreparedStatement ps = 
				con.prepareStatement(sql);
			ps.setInt(1, page*pageSize);
			ps.setInt(2, pageSize);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				OneColumns c = createOneColumns(rs);
				list.add(c);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException(
					"分页查询", e);
		} finally {
			DBUtil.closeConnection();
		}
		return list;
	}

	public int findTotalPage(int pageSize) throws DAOException {
		String sql = "select count(*) from one_columns";
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
					"查找总页数失败", e);
		} finally {
			DBUtil.closeConnection();
		}
		return 0;
	}

	public void deleteOneColumns(int id) throws DAOException {
		String sql = "delete from one_columns where columnsId=?";
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

	public OneColumns findByName(String name) throws DAOException {
		if(name == null)
			return null;
		
		String sql = "select * from one_columns where columnName=?";
		Connection con = DBUtil.getConnection();
		try {
			PreparedStatement ps = 
				con.prepareStatement(sql);
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				OneColumns oc = createOneColumns(rs);
				return oc;
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

	public void addOneColumns(OneColumns oc) throws DAOException {
		if(oc == null)
			return;
		String sql = "insert into one_columns(columnName,columnPosition,isDisplay) " +
				"values(?,?,?)";
		Connection con = DBUtil.getConnection();
		try {
			con.setAutoCommit(false);
			PreparedStatement ps = 
				con.prepareStatement(sql);
			ps.setString(1, oc.getColumnName());
			ps.setInt(2, oc.getColumnPosition());
			ps.setInt(3, oc.getIsDisplay());
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

	public OneColumns findById(Integer id) throws DAOException {
		if(id == null)
			return null;
		
		String sql = "select * from one_columns where columnsId=?";
		Connection con = DBUtil.getConnection();
		try {
			PreparedStatement ps = 
				con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				OneColumns oc = createOneColumns(rs);
				return oc;
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

	public void updateOneColumns(OneColumns oc) throws DAOException {
		if(oc == null) {
			return;
		}
		String sql = "update one_columns set " +
				"columnName=?,columnPosition=?,isDisplay=?" +
				" where columnsId=?";
				
		Connection con = DBUtil.getConnection();
		try {
			con.setAutoCommit(false);
			PreparedStatement ps = 
				con.prepareStatement(sql);
			ps.setInt(4, oc.getColumnsId());
			ps.setString(1, oc.getColumnName());
			ps.setInt(2, oc.getColumnPosition());
			ps.setInt(3, oc.getIsDisplay());
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
