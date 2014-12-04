package action.coop;

import java.util.List;

import dao.CoopDao;
import dao.DAOException;
import entity.Coop;

public class FindCoopAction {
	private List<Coop> list;
	private int page=1;
	private int rows=15;
	private int total;
	
	public String execute(){
		CoopDao dao=new CoopDao();
		try {
			list=dao.findByPage(page-1, rows);
			total=dao.findTotalPage(rows);
		} catch (DAOException e) {
			e.printStackTrace();
			return "error";
		}
		return "success";
	}

	public List<Coop> getList() {
		return list;
	}

	public void setList(List<Coop> list) {
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
