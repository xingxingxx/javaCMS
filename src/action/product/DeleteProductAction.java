package action.product;

import dao.DAOException;
import dao.ProductDao;

public class DeleteProductAction {
	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String execute(){
		ProductDao dao=new ProductDao();
		try {
			dao.deleteProduct(id);
		} catch (DAOException e) {
			e.printStackTrace();
			return "error";
		}
		return "success";
	}
}
