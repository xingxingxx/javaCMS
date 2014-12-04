package action.text;

import java.util.List;

import dao.DAOException;
import dao.OneColumnsDao;
import dao.TextDao;
import dao.TwoColumnsDao;
import entity.OneColumns;
import entity.Text;
import entity.TwoColumns;

public class FindTextAction {
	private List<Text> list;
	private int page=1;
	private int rows=15;
	private int total;
	private List<TwoColumns> listt;
	private Integer categoryId;
	private List<OneColumns> listOne;
	
	
	
	public String execute(){
		TextDao dao=new TextDao();
		TwoColumnsDao dao2=new TwoColumnsDao();
		OneColumnsDao dao3=new OneColumnsDao();
		try {
			if(categoryId==null){
				list=dao.findByPage(page-1, rows);
				total=dao.findTotalPage(rows);
			}else{
				list=dao.findByCategory2(page-1, rows, categoryId);
				total=dao.findTotalPageByCategory2(rows,categoryId);
			}
			
			listt=dao2.findAll();
			listOne=dao3.findAll();
			
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



	


	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public List<TwoColumns> getListt() {
		return listt;
	}



	public void setListt(List<TwoColumns> listt) {
		this.listt = listt;
	}



	public List<Text> getList() {
		return list;
	}



	public void setList(List<Text> list) {
		this.list = list;
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

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}
	
	
}
