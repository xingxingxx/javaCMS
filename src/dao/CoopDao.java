package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.DBUtil;
import entity.Coop;

public class CoopDao {
	
	private Coop createCoop(ResultSet rs) 
			throws SQLException {
		Coop c = new Coop();
			c.setCoopId(rs.getInt("coopId"));
			c.setName(rs.getString("name"));
			c.setCountry(rs.getString("country"));
			c.setProvince(rs.getString("province"));
			c.setCity(rs.getString("city"));
			c.setPhone(rs.getString("phone"));
			c.setEmail(rs.getString("email"));
			c.setCompany(rs.getString("company"));
			c.setUrl(rs.getString("url"));
			c.setContent(rs.getString("content"));
			return c;
		}
	public List<Coop> findByPage(int page, int pageSize) throws DAOException {	
		List<Coop> list = new ArrayList<Coop>();
		String sql = "select * from coop limit ?,?";
		Connection con = DBUtil.getConnection();
		try {
			PreparedStatement ps = 
				con.prepareStatement(sql);
			ps.setInt(1, page*pageSize);
			ps.setInt(2, pageSize);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Coop c = createCoop(rs);
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
		String sql = "select count(*) from coop";
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
	
	public void deleteCoop(int id) throws DAOException {
		String sql = "delete from coop where coopId=?";
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
	
	public void addCoop(Coop coop) throws DAOException {
		if(coop == null)
			return;
		String sql = "insert into coop(name,country,province,city,phone,email,company,url,content) " +
				"values(?,?,?,?,?,?,?,?,?)";
		Connection con = DBUtil.getConnection();
		try {
			con.setAutoCommit(false);
			PreparedStatement ps = 
				con.prepareStatement(sql);
			ps.setString(1,coop.getName());
			ps.setString(2,coop.getCountry());
			ps.setString(3,coop.getProvince());
			ps.setString(4,coop.getCity());
			ps.setString(5,coop.getPhone());
			ps.setString(6,coop.getEmail());
			ps.setString(7,coop.getCompany());
			ps.setString(8,coop.getUrl());
			ps.setString(9,coop.getContent());
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
	public Coop findById(Integer id) throws DAOException {
		if(id == null)
			return null;
		
		String sql = "select * from coop where coopId=?";
		Connection con = DBUtil.getConnection();
		try {
			PreparedStatement ps = 
				con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				Coop admin = createCoop(rs);
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
}
