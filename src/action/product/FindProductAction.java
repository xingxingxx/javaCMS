package action.product;

import java.util.List;

import dao.DAOException;
import dao.PcategoryDao;
import dao.ProductDao;

import entity.Pcategory;
import entity.Product;

public class FindProductAction {
	private int page=1;
	private int rows=10;
	private int total;
	private List<Product> list;
	private List<Pcategory> pc;
	private Integer id;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
	public List<Product> getList() {
		return list;
	}
	public void setList(List<Product> list) {
		this.list = list;
	}
	public List<Pcategory> getPc() {
		return pc;
	}
	public void setPc(List<Pcategory> pc) {
		this.pc = pc;
	}
	
	public String execute(){
		ProductDao dao=new ProductDao();
		PcategoryDao dao2=new PcategoryDao();
		try {
			if(id==null){
				list=dao.findByPage(page-1, rows);
				total=dao.findTotalPage(rows);
			}else{
				list=dao.findByCategory(page-1, rows, id);
				total=dao.findByCategoryPage(id, rows);
			}
			
			pc=dao2.findAll();
		} catch (DAOException e) {
			e.printStackTrace();
			return "error";
		}
		return "success";
	}
	
}
