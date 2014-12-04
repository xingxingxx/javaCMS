package action.product;

import dao.DAOException;
import dao.ProductDao;
import entity.Product;

public class MoreProductAction {
	private int id;
	private Product p;
	
	public String execute(){
		ProductDao dao=new ProductDao();
		try {
			p=dao.findById(id);
		} catch (DAOException e) {
			e.printStackTrace();
			return "error";
		}
		return "success";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Product getP() {
		return p;
	}

	public void setP(Product p) {
		this.p = p;
	}
	
	
}
