package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.DBUtil;
import entity.Slide;

public class SlideDao {
	private Slide createSlide(ResultSet rs) 
			throws SQLException {
		Slide c = new Slide();
			c.setSlideId(rs.getInt("slideId"));
			c.setDescription(rs.getString("description"));
			c.setImageUrl(rs.getString("imageUrl"));
			c.setUrl(rs.getString("url"));
			return c;
		}
	
	public List<Slide> findAll() throws DAOException {
		List<Slide> list = new ArrayList<Slide>();
		String sql = "select * from slide";
		Connection con = DBUtil.getConnection();
		try {
			PreparedStatement ps = 
				con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Slide c = createSlide(rs);
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

	public List<Slide> findByPage(int page, int pageSize) throws DAOException {	
		List<Slide> list = new ArrayList<Slide>();
		String sql = "select * from slide limit ?,?";
		Connection con = DBUtil.getConnection();
		try {
			PreparedStatement ps = 
				con.prepareStatement(sql);
			ps.setInt(1, page*pageSize);
			ps.setInt(2, pageSize);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Slide c = createSlide(rs);
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
		String sql = "select count(*) from slide";
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

	public void deleteSlide(int id) throws DAOException {
		String sql = "delete from slide where slideId=?";
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

	public Slide findByName(String name) throws DAOException {
		
		return null;
	}

	public void addSlide(Slide slide) throws DAOException {
		if(slide == null)
			return;
		String sql = "insert into slide(description,imageUrl,url) " +
				"values(?,?,?)";
		Connection con = DBUtil.getConnection();
		try {
			con.setAutoCommit(false);
			PreparedStatement ps = 
				con.prepareStatement(sql);
			ps.setString(1, slide.getDescription());
			ps.setString(2, slide.getImageUrl());
			ps.setString(3, slide.getUrl());
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

	public Slide findById(Integer id) throws DAOException {
		if(id == null)
			return null;
		String sql = "select * from slide where slideId=?";
		Connection con = DBUtil.getConnection();
		try {
			PreparedStatement ps = 
				con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				Slide slide = createSlide(rs);
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

	public void updateSlide(Slide slide) throws DAOException {
		if(slide == null) {
			return;
		}
		Connection con = DBUtil.getConnection();
		try {
			con.setAutoCommit(false);
			
		if(slide.getImageUrl()!=null){
			String sql = "update slide set " +
				"imageUrl=? where slideId=?";
			PreparedStatement ps = 
					con.prepareStatement(sql);
			ps.setString(1, slide.getImageUrl());
			ps.setInt(2, slide.getSlideId());
			ps.executeUpdate();
		}
		String sql = "update slide set " +
				"description=?,url=? where slideId=?";
			PreparedStatement ps = 
				con.prepareStatement(sql);
			ps.setString(1, slide.getDescription());
			ps.setString(2, slide.getUrl());
			ps.setInt(3, slide.getSlideId());
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
