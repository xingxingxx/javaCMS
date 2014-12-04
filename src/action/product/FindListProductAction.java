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

public class FindListProductAction {
	private int rows=8;
	private int page=1;
	private int total;
	private int id;
	private List<Product> list;
	private List<OneColumns> listOne;
	private List<TwoColumns> listt;
	private List<Pcategory> pc;
	
	public String execute(){
		ProductDao dao=new ProductDao();
		OneColumnsDao dao1=new OneColumnsDao();
		TwoColumnsDao dao2=new TwoColumnsDao();
		PcategoryDao dao3=new PcategoryDao();
		try {
			listOne=dao1.findAllDown();
			listt=dao2.findAll();
			pc=dao3.findAll();
			list=dao.findByCategory(page-1, rows,id);
			total=dao.findByCategoryPage(id, rows);
		} catch (DAOException e) {
			e.printStackTrace();
			return "error";
		}
		return "success";
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



	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Product> getList() {
		return list;
	}

	public void setList(List<Product> list) {
		this.list = list;
	}
	
}
