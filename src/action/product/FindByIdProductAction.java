package action.product;

import java.util.List;

import dao.DAOException;
import dao.OneColumnsDao;
import dao.PcategoryDao;
import dao.ProductDao;
import dao.TwoColumnsDao;
import entity.OneColumns;
import entity.Pcategory;
import entity.Product;
import entity.TwoColumns;

public class FindByIdProductAction {
	private int id;
	private Product product;
	private List<OneColumns> listOne;
	private List<TwoColumns> listt;
	private List<Pcategory> pc;
	
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
	
	
	public List<OneColumns> getListOne() {
		return listOne;
	}
	public void setListOne(List<OneColumns> listOne) {
		this.listOne = listOne;
	}
	public List<TwoColumns> getListt() {
		return listt;
	}
	public void setListt(List<TwoColumns> listt) {
		this.listt = listt;
	}
	public List<Pcategory> getPc() {
		return pc;
	}
	public void setPc(List<Pcategory> pc) {
		this.pc = pc;
	}
	public String execute(){
		ProductDao dao=new ProductDao();
		OneColumnsDao dao1=new OneColumnsDao();
		TwoColumnsDao dao2=new TwoColumnsDao();
		PcategoryDao dao3=new PcategoryDao();
		try {
			listOne=dao1.findAllDown();
			listt=dao2.findAll();
			pc=dao3.findAll();
			product=dao.findById(id);	
		} catch (DAOException e) {
			e.printStackTrace();
			return "error";
		}
		return "success";
	}
}
