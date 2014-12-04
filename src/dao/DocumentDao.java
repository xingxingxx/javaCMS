package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.DBUtil;
import entity.Document;

public class DocumentDao {
	private Document createDocument(ResultSet rs) 
			throws SQLException {
		Document c = new Document();
			c.setDocumentId(rs.getInt("documentId"));
			c.setCategoryId(rs.getInt("categoryId"));
			c.setTitle(rs.getString("title"));
			c.setCtime(rs.getString("ctime"));
			c.setEdition(rs.getString("edition"));
			c.setDownload(rs.getString("download"));
			c.setFlow(rs.getInt("flow"));
			return c;
		}
	public List<Document> findAll() throws DAOException {
		List<Document> list = new ArrayList<Document>();
		String sql = "select * from document";
		Connection con = DBUtil.getConnection();
		try {
			PreparedStatement ps = 
				con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Document c = createDocument(rs);
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

	public List<Document> findByPage(int page, int pageSize) throws DAOException {
		List<Document> list = new ArrayList<Document>();
		String sql = "select * from document where flow=1 order by ctime desc limit ?,?";
		Connection con = DBUtil.getConnection();
		try {
			PreparedStatement ps = 
				con.prepareStatement(sql);
			ps.setInt(1, page*pageSize);
			ps.setInt(2, pageSize);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Document c = createDocument(rs);
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
		String sql = "select count(*) from document where categoryId=?";
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
		String sql = "select count(*) from document where categoryId=? and flow=1";
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
		String sql = "select count(*) from document where flow=1";
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

	public void deleteDocument(int id) throws DAOException {
		String sql = "delete from document where documentId=?";
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
	
	public int findTotalPageByName(int pageSize,String name) throws DAOException {
		String sql = "select count(*) from document where title like ? and flow=1 order by ctime desc";
		Connection con = DBUtil.getConnection();
		try {
			PreparedStatement ps = 
				con.prepareStatement(sql);
			ps.setString(1,"%"+name+"%");
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

	public List<Document> findByName(String name,int page,int pageSize) throws DAOException {
		List<Document> list = new ArrayList<Document>();
		String sql = "select * from document where title like ? and flow=1 order by ctime desc limit ?,? ";
		Connection con = DBUtil.getConnection();
		try {
			PreparedStatement ps = 
				con.prepareStatement(sql);
			
			ps.setString(1, "%"+name+"%");
			ps.setInt(2, page*pageSize);
			ps.setInt(3, pageSize);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Document c = createDocument(rs);
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

	public void addDocument(Document doc) throws DAOException {
		if(doc == null)
			return;
		String sql = "insert into document(categoryId,title,edition,download,flow) " +
				"values(?,?,?,?,?)";
		Connection con = DBUtil.getConnection();
		try {
			con.setAutoCommit(false);
			PreparedStatement ps = 
				con.prepareStatement(sql);
			ps.setInt(1, doc.getCategoryId());
			ps.setString(2, doc.getTitle());
			ps.setString(3, doc.getEdition());
			ps.setString(4, doc.getDownload());
			ps.setInt(5, doc.getFlow());
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
	
	public List<Document> findByCategory(Integer id) throws DAOException{
		if(id==null){
			return null;
		}
		List<Document> list = new ArrayList<Document>();
		String sql="select * from document where categoryId=?";
		Connection con = DBUtil.getConnection();
		try {
			PreparedStatement ps = 
				con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Document c = createDocument(rs);
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

	public Document findById(Integer id) throws DAOException {
		if(id == null)
			return null;
		
		String sql = "select * from document where documentId=?";
		Connection con = DBUtil.getConnection();
		try {
			PreparedStatement ps = 
				con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				Document admin = createDocument(rs);
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

	public void updateDocument(Document doc) throws DAOException {
		if(doc == null) {
			return;
		}
		
		Connection con = DBUtil.getConnection();
		try {
			con.setAutoCommit(false);
			
			if(doc.getDownload()!=null){
				String sql = "update document set download=? where documentId=?";
				PreparedStatement ps = 
					con.prepareStatement(sql);
				ps.setString(1, doc.getDownload());
				ps.setInt(2, doc.getDocumentId());
				ps.executeUpdate();
			}
			String sql = "update document set " +
					"categoryId=?,title=?,edition=?," +
					"flow=? where documentId=?";
			PreparedStatement ps = 
				con.prepareStatement(sql);
			ps.setInt(1, doc.getCategoryId());
			ps.setString(2, doc.getTitle());
			ps.setString(3, doc.getEdition());
			ps.setInt(4, doc.getFlow());
			ps.setInt(5, doc.getDocumentId());
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
	public List<Document> findByCategory(int page, int pageSize, int categoryId)
			throws DAOException {
		List<Document> list = new ArrayList<Document>();
		String sql = "select * from document where categoryId=? and flow=1 order by ctime desc limit ?,? ";
		Connection con = DBUtil.getConnection();
		try {
			PreparedStatement ps = 
				con.prepareStatement(sql);
			ps.setInt(1, categoryId);
			ps.setInt(2, page*pageSize);
			ps.setInt(3, pageSize);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Document c = createDocument(rs);
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
	
	public List<Document> findByCategory2(int page, int pageSize, int categoryId)
			throws DAOException {
		List<Document> list = new ArrayList<Document>();
		String sql = "select * from document where categoryId=? order by ctime desc limit ?,? ";
		Connection con = DBUtil.getConnection();
		try {
			PreparedStatement ps = 
				con.prepareStatement(sql);
			ps.setInt(1, categoryId);
			ps.setInt(2, page*pageSize);
			ps.setInt(3, pageSize);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Document c = createDocument(rs);
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
