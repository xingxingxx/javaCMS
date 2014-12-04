package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.DBUtil;
import entity.Partners;

public class PartnersDao {
	private Partners createPartners(ResultSet rs) 
			throws SQLException {
		Partners c = new Partners();
			c.setPartnersId(rs.getInt("partnersId"));
			c.setDescription(rs.getString("description"));
			c.setImageUrl(rs.getString("imageUrl"));
			c.setUrl(rs.getString("url"));
			c.setDispalyNum(rs.getInt("dispalyNum"));
			return c;
		}
	
	public List<Partners> findAll() throws DAOException {
		List<Partners> list = new ArrayList<Partners>();
		String sql = "select * from partners";
		Connection con = DBUtil.getConnection();
		try {
			PreparedStatement ps = 
				con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Partners c = createPartners(rs);
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
	
	public List<Partners> findAll2() throws DAOException {
		List<Partners> list = new ArrayList<Partners>();
		String sql = "select * from partners where dispalyNum>0 order by dispalyNum asc";
		Connection con = DBUtil.getConnection();
		try {
			PreparedStatement ps = 
				con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Partners c = createPartners(rs);
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

	public List<Partners> findByPage(int page, int pageSize) throws DAOException {	
		List<Partners> list = new ArrayList<Partners>();
		String sql = "select * from partners limit ?,?";
		Connection con = DBUtil.getConnection();
		try {
			PreparedStatement ps = 
				con.prepareStatement(sql);
			ps.setInt(1, page*pageSize);
			ps.setInt(2, pageSize);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Partners c = createPartners(rs);
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
		String sql = "select count(*) from partners";
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

	public void deletePartners(int id) throws DAOException {
		String sql = "delete from partners where partnersId=?";
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


	public void addPartners(Partners p) throws DAOException {
		if(p == null)
			return;
		String sql = "insert into partners(description,imageUrl,url,dispalyNum) " +
				"values(?,?,?,?)";
		Connection con = DBUtil.getConnection();
		try {
			con.setAutoCommit(false);
			PreparedStatement ps = 
				con.prepareStatement(sql);
			ps.setString(1, p.getDescription());
			ps.setString(2, p.getImageUrl());
			ps.setString(3, p.getUrl());
			ps.setInt(4, p.getDispalyNum());
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

	public Partners findById(Integer id) throws DAOException {
		if(id == null)
			return null;
		String sql = "select * from partners where partnersId=?";
		Connection con = DBUtil.getConnection();
		try {
			PreparedStatement ps = 
				con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				Partners slide = createPartners(rs);
				return slide;
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

	public void updatePartners(Partners p) throws DAOException {
		if(p == null) {
			return;
		}
		Connection con = DBUtil.getConnection();
		try {
			con.setAutoCommit(false);
			
		if(p.getImageUrl()!=null){
			String sql = "update partners set " +
				"imageUrl=? where partnersId=?";
			PreparedStatement ps = 
					con.prepareStatement(sql);
			ps.setString(1, p.getImageUrl());
			ps.setInt(2, p.getPartnersId());
			ps.executeUpdate();
		}
		String sql = "update partners set " +
				"description=?,url=?,dispalyNum=? where partnersId=?";
			PreparedStatement ps = 
				con.prepareStatement(sql);
			ps.setString(1, p.getDescription());
			ps.setString(2, p.getUrl());
			ps.setInt(3, p.getDispalyNum());
			ps.setInt(4, p.getPartnersId());
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
