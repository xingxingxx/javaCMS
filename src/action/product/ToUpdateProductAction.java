package action.product;

import java.util.List;

import dao.DAOException;
import dao.PcategoryDao;
import dao.ProductDao;
import entity.Pcategory;
import entity.Product;

public class ToUpdateProductAction {
	private int id;
	private Product product;
	private List<Pcategory> list;
	
	public List<Pcategory> getList() {
		return list;
	}
	public void setList(List<Pcategory> list) {
		this.list = list;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public String execute(){
		ProductDao dao=new ProductDao();
		PcategoryDao dao2=new PcategoryDao();
		try {
			product=dao.findById(id);
			list=dao2.findAll();
		} catch (DAOException e) {
			e.printStackTrace();
			return "error";
		}
		return "success";
	}
}
