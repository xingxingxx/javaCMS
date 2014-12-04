package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import util.DBUtil;
import entity.Text;

public class TextDao {
	private Text createText(ResultSet rs) 
			throws SQLException {
		Text c = new Text();
			c.setTextId(rs.getInt("textId"));
			c.setCategoryId(rs.getInt("categoryId"));
			c.setMinImage(rs.getString("minImage"));
			c.setTitle(rs.getString("title"));
			c.setCtime(rs.getString("ctime"));
			c.setEdition(rs.getString("edition"));
			c.setDownload(rs.getString("download"));
			c.setSummary(rs.getString("summary"));
			c.setFlow(rs.getInt("flow"));
			c.setContent(rs.getString("content"));
			return c;
		}
	public List<Text> findAll() throws DAOException {
		List<Text> list = new ArrayList<Text>();
		String sql = "select * from t_text";
		Connection con = DBUtil.getConnection();
		try {
			PreparedStatement ps = 
				con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Text c = createText(rs);
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

	public List<Text> findByPage(int page, int pageSize) throws DAOException {
		List<Text> list = new ArrayList<Text>();
		String sql = "select * from t_text limit ?,?";
		Connection con = DBUtil.getConnection();
		try {
			PreparedStatement ps = 
				con.prepareStatement(sql);
			ps.setInt(1, page*pageSize);
			ps.setInt(2, pageSize);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Text c = createText(rs);
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
	
	public int findTotalPageByCategory2(int pageSize,int id)throws DAOException {
		String sql = "select count(*) from t_text where categoryId=?";
		Connection con = DBUtil.getConnection();
		try {
			PreparedStatement ps = 
				con.prepareStatement(sql);
			ps.setInt(1, id);
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
	
	public int findTotalPageByCategory(int pageSize,int id)throws DAOException {
		String sql = "select count(*) from t_text where categoryId=? and flow=1";
		Connection con = DBUtil.getConnection();
		try {
			PreparedStatement ps = 
				con.prepareStatement(sql);
			ps.setInt(1, id);
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

	public int findTotalPage(int pageSize) throws DAOException {
		String sql = "select count(*) from t_text";
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

	public void deleteText(int id) throws DAOException {
		String sql = "delete from t_text where textId=?";
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
	
	public int findTotalPageByName(String name,int pageSize,int id) throws DAOException {
		String sql = "select count(*) from t_text where title like ? and categoryId=? and flow=1";
		Connection con = DBUtil.getConnection();
		try {
			PreparedStatement ps = 
				con.prepareStatement(sql);
			ps.setString(1, "%"+name+"%");
			ps.setInt(2, id);
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

	public List<Text> findByName(String name,int page,int pageSize,int id) throws DAOException {
		List<Text> list = new ArrayList<Text>();
		String sql = "select * from t_text where title like ? and categoryId=? and flow=1 order by ctime desc limit ?,? ";
		Connection con = DBUtil.getConnection();
		try {
			PreparedStatement ps = 
				con.prepareStatement(sql);
			ps.setString(1, "%"+name+"%");
			ps.setInt(2, id);
			ps.setInt(3, page*pageSize);
			ps.setInt(4, pageSize);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Text c = createText(rs);
				list.add(c);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException(
					"根据名称模糊查询失败", e);
		} finally {
			DBUtil.closeConnection();
		}
		return list;
	}

	public void addText(Text text) throws DAOException {
		if(text == null)
			return;
		String sql = "insert into t_text(categoryId,minImage,title,edition,download,summary,content) " +
				"values(?,?,?,?,?,?,?)";
		Connection con = DBUtil.getConnection();
		try {
			con.setAutoCommit(false);
			PreparedStatement ps = 
				con.prepareStatement(sql);
			ps.setInt(1, text.getCategoryId());
			ps.setString(2, text.getMinImage());
			ps.setString(3, text.getTitle());
			ps.setString(4, text.getEdition());
			ps.setString(5, text.getDownload());
			ps.setString(6, text.getSummary());
			ps.setString(7, text.getContent());
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
	
	public List<Text> findByCategory(Integer id) throws DAOException{
		if(id==null){
			return null;
		}
		List<Text> list = new ArrayList<Text>();
		String sql="select * from t_text where categoryId=?";
		Connection con = DBUtil.getConnection();
		try {
			PreparedStatement ps = 
				con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Text c = createText(rs);
				list.add(c);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException(
					"根据categoryId查找失败",e);
		} finally {
			DBUtil.closeConnection();
		}
		
		return list;
	}

	public Text findById(Integer id) throws DAOException {
		if(id == null)
			return null;
		
		String sql = "select * from t_text where textId=?";
		Connection con = DBUtil.getConnection();
		try {
			PreparedStatement ps = 
				con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				Text admin = createText(rs);
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

	public void updateText(Text text) throws DAOException {
		if(text == null) {
			return;
		}
		
		Connection con = DBUtil.getConnection();
		try {
			con.setAutoCommit(false);
			if(text.getMinImage()!=null){
				String sql = "update t_text set minImage=? where textId=?";
				PreparedStatement ps = 
					con.prepareStatement(sql);
				ps.setString(1, text.getMinImage());
				ps.setInt(2, text.getTextId());
				ps.executeUpdate();
			}
			if(text.getDownload()!=null){
				String sql = "update t_text set download=? where textId=?";
				PreparedStatement ps = 
					con.prepareStatement(sql);
				ps.setString(1, text.getDownload());
				ps.setInt(2, text.getTextId());
				ps.executeUpdate();
			}
			String sql = "update t_text set " +
					"categoryId=?,title=?,edition=?,summary=?," +
					"content=?,flow=? where textId=?";
			PreparedStatement ps = 
				con.prepareStatement(sql);
			ps.setInt(1, text.getCategoryId());
			ps.setString(2, text.getTitle());
			ps.setString(3, text.getEdition());
			ps.setString(4, text.getSummary());
			ps.setString(5,text.getContent());
			ps.setInt(6, text.getFlow());
			ps.setInt(7, text.getTextId());
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
	public List<Text> findByCategory(int page, int pageSize, int categoryId)
			throws DAOException {
		List<Text> list = new ArrayList<Text>();
		String sql = "select * from t_text where categoryId=? and flow=1 order by ctime desc limit ?,? ";
		Connection con = DBUtil.getConnection();
		try {
			PreparedStatement ps = 
				con.prepareStatement(sql);
			ps.setInt(1, categoryId);
			ps.setInt(2, page*pageSize);
			ps.setInt(3, pageSize);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Text c = createText(rs);
				list.add(c);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException(
					"根据类别查找失败", e);
		} finally {
			DBUtil.closeConnection();
		}
		return list;
	}
	
	public List<Text> findByCategory2(int page, int pageSize, int categoryId)
			throws DAOException {
		List<Text> list = new ArrayList<Text>();
		String sql = "select * from t_text where categoryId=? order by ctime desc limit ?,? ";
		Connection con = DBUtil.getConnection();
		try {
			PreparedStatement ps = 
				con.prepareStatement(sql);
			ps.setInt(1, categoryId);
			ps.setInt(2, page*pageSize);
			ps.setInt(3, pageSize);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Text c = createText(rs);
				list.add(c);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException(
					"根据类别查找失败", e);
		} finally {
			DBUtil.closeConnection();
		}
		return list;
	}

}
