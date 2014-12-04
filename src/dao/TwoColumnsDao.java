package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.DBUtil;
import entity.TwoColumns;

public class TwoColumnsDao {
	private TwoColumns createTwoColumns(ResultSet rs) 
			throws SQLException {
		TwoColumns c = new TwoColumns();
		c.setColumnsId(rs.getInt("columnsId"));
		c.setRelationId(rs.getInt("relationId"));
		c.setColumnName(rs.getString("columnName"));
		c.setColumnClass(rs.getInt("columnClass"));
		c.setColumnPosition(rs.getInt("columnPosition"));
		return c;
		}

	public List<TwoColumns> findAll() throws DAOException {
		List<TwoColumns> list = new ArrayList<TwoColumns>();
		String sql = "select * from two_columns order by columnPosition asc";
		Connection con = DBUtil.getConnection();
		try {
			PreparedStatement ps = 
				con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				TwoColumns c = createTwoColumns(rs);
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

	public List<TwoColumns> findByPage(int page, int pageSize)
			throws DAOException {
		List<TwoColumns> list = new ArrayList<TwoColumns>();
		String sql = "select * from two_columns limit ?,?";
		Connection con = DBUtil.getConnection();
		try {
			PreparedStatement ps = 
				con.prepareStatement(sql);
			ps.setInt(1, page*pageSize);
			ps.setInt(2, pageSize);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				TwoColumns c = createTwoColumns(rs);
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
	
	public List<TwoColumns> findByPage(int page, int pageSize,int id)
			throws DAOException {
		List<TwoColumns> list = new ArrayList<TwoColumns>();
		String sql = "select * from two_columns where relationId=? order by columnPosition asc limit ?,?";
		Connection con = DBUtil.getConnection();
		try {
			PreparedStatement ps = 
				con.prepareStatement(sql);
			ps.setInt(1, id);
			ps.setInt(2, page*pageSize);
			ps.setInt(3, pageSize);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				TwoColumns c = createTwoColumns(rs);
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
		String sql = "select count(*) from two_columns";
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

	public void deleteTwoColumns(int id) throws DAOException {
		String sql = "delete from two_columns where columnsId=?";
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
	
	public List<TwoColumns> findByRelationId(int id)throws DAOException{
		List<TwoColumns> list = new ArrayList<TwoColumns>();
		String sql = "select * from two_columns where relationId=? order by columnPosition asc";
		Connection con = DBUtil.getConnection();
		try {
			PreparedStatement ps = 
				con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				TwoColumns c = createTwoColumns(rs);
				list.add(c);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException(
					"根据父类查询失败", e);
		} finally {
			DBUtil.closeConnection();
		}
		return list;
	}

	public TwoColumns findByName(String name) throws DAOException {
		if(name == null)
			return null;
		
		String sql = "select * from two_columns where columnName=?";
		Connection con = DBUtil.getConnection();
		try {
			PreparedStatement ps = 
				con.prepareStatement(sql);
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				TwoColumns oc = createTwoColumns(rs);
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

	public void addTwoColumns(TwoColumns oc) throws DAOException {
		if(oc == null)
			return;
		String sql = "insert into two_columns(columnName,relationId,columnPosition,columnClass) " +
				"values(?,?,?,?)";
		Connection con = DBUtil.getConnection();
		try {
			con.setAutoCommit(false);
			PreparedStatement ps = 
				con.prepareStatement(sql);
			ps.setString(1, oc.getColumnName());
			ps.setInt(2, oc.getRelationId());
			ps.setInt(3, oc.getColumnPosition());
			ps.setInt(4, oc.getColumnClass());
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

	public TwoColumns findById(Integer id) throws DAOException {
		if(id == null)
			return null;
		
		String sql = "select * from two_columns where columnsId=?";
		Connection con = DBUtil.getConnection();
		try {
			PreparedStatement ps = 
				con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				TwoColumns oc = createTwoColumns(rs);
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

	public void updateTwoColumns(TwoColumns oc) throws DAOException {
		if(oc == null) {
			return;
		}
		String sql = "update two_columns set " +
				"columnName=?,columnPosition=?,columnClass=?" +
				" where columnsId=?";
				
		Connection con = DBUtil.getConnection();
		try {
			con.setAutoCommit(false);
			PreparedStatement ps = 
				con.prepareStatement(sql);
			
			ps.setString(1, oc.getColumnName());
			ps.setInt(2, oc.getColumnPosition());
			ps.setInt(3, oc.getColumnClass());
			ps.setInt(4, oc.getColumnsId());
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
