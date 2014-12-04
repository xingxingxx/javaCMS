package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import util.DBUtil;
import entity.Product;


public class ProductDao {
	private Product createProduct(ResultSet rs) 
			throws SQLException {
		Product c = new Product();
			c.setProductId(rs.getInt("productId"));
			c.setMinImage(rs.getString("minImage"));
			c.setImageList(rs.getString("imageList"));
			c.setProductName(rs.getString("productName"));
			c.setCategoryId(rs.getInt("categoryId"));
			c.setSummary(rs.getString("summary"));
			c.setDescription(rs.getString("description"));
			c.setFunction(rs.getString("function"));
			c.setModel(rs.getString("model"));
			c.setDownload(rs.getString("download"));
			return c;
		}
	public List<Product> findAll() throws DAOException {
		List<Product> list = new ArrayList<Product>();
		String sql = "select * from p_product";
		Connection con = DBUtil.getConnection();
		try {
			PreparedStatement ps = 
				con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Product c = createProduct(rs);
				list.add(c);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException(
					"查询所有数据失败", e);
		} finally {
			DBUtil.closeConnection();
		}
		return list;
	}

	public List<Product> findByPage(int page, int pageSize) throws DAOException {
		List<Product> list = new ArrayList<Product>();
		String sql = "select * from p_product order by productId asc limit ?,?";
		Connection con = DBUtil.getConnection();
		try {
			PreparedStatement ps = 
				con.prepareStatement(sql);
			ps.setInt(1, page*pageSize);
			ps.setInt(2, pageSize);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Product c = createProduct(rs);
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
		String sql = "select count(*) from p_product";
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

	public void deleteProduct(int id) throws DAOException {
		String sql = "delete from p_product where productId=?";
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

	public Product findByName(String name) throws DAOException {
		if(name == null)
			return null;
		String sql = "select * from p_product where productName=?";
		Connection con = DBUtil.getConnection();
		try {
			PreparedStatement ps = 
				con.prepareStatement(sql);
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				Product admin = createProduct(rs);
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

	public void addProduct(Product product) throws DAOException {
		if(product == null)
			return;
		String sql = "insert into p_product(minImage,imageList,productName,categoryId,summary,description,function,model,download)" +
				" values(?,?,?,?,?,?,?,?,?)";
		Connection con = DBUtil.getConnection();
		try {
			con.setAutoCommit(false);
			PreparedStatement ps = 
				con.prepareStatement(sql);
			ps.setString(1, product.getMinImage());
			ps.setString(2, product.getImageList());
			ps.setString(3, product.getProductName());
			ps.setInt(4, product.getCategoryId());
			ps.setString(5, product.getSummary());
			ps.setString(6, product.getDescription());
			ps.setString(7, product.getFunction());
			ps.setString(8, product.getModel());
			ps.setString(9, product.getDownload());
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

	public Product findById(Integer id) throws DAOException {
		if(id == null)
			return null;
		
		String sql = "select * from p_product where productId=?";
		Connection con = DBUtil.getConnection();
		try {
			PreparedStatement ps = 
				con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				Product admin = createProduct(rs);
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

	public void updateProduct(Product product) throws DAOException {
		if(product == null) {
			return;
		}
		Connection con = DBUtil.getConnection();
		try {
			con.setAutoCommit(false);
			
			if(product.getMinImage()!=null){
				String sql = "update p_product set minImage=? where productId=?";	
				PreparedStatement ps = 
					con.prepareStatement(sql);
				ps.setString(1, product.getMinImage());
				ps.setInt(2, product.getProductId());
				ps.executeUpdate();
			}
			if(product.getDownload()!=null){
				String sql = "update p_product set download=? where productId=?";	
				PreparedStatement ps = 
					con.prepareStatement(sql);
				ps.setString(1, product.getDownload());
				ps.setInt(2, product.getProductId());
				ps.executeUpdate();
			}
			if(product.getImageList()!=null){
				String sql = "update p_product set imageList=? where productId=?";	
				PreparedStatement ps = 
					con.prepareStatement(sql);
				ps.setString(1, product.getImageList());
				ps.setInt(2, product.getProductId());
				ps.executeUpdate();
			}
			String sql = "update p_product set " +
					"productName=?,categoryId=?,summary=?,description=?," +
					"function=?,model=? where productId=?";				
			
			PreparedStatement ps = 
				con.prepareStatement(sql);
			ps.setString(1, product.getProductName());
			ps.setInt(2, product.getCategoryId());
			ps.setString(3, product.getSummary());
			ps.setString(4, product.getDescription());
			ps.setString(5, product.getFunction());
			ps.setString(6, product.getModel());
			ps.setInt(7, product.getProductId());
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
	public int findByCategoryPage(int id,int pageSize) throws DAOException{
		String sql = "select count(*) from p_product where categoryId=?";
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
	public List<Product> findByCategory(int page, int pageSize, int categoryId)
			throws DAOException {
		List<Product> list = new ArrayList<Product>();
		String sql = "select * from p_product where categoryId=? order by productId asc limit ?,?";
		Connection con = DBUtil.getConnection();
		try {
			PreparedStatement ps = 
				con.prepareStatement(sql);
			ps.setInt(1, categoryId);
			ps.setInt(2, page*pageSize);
			ps.setInt(3, pageSize);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Product c = createProduct(rs);
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
