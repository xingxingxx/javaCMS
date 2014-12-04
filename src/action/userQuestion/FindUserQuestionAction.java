package action.userQuestion;

import java.util.List;

import dao.DAOException;
import dao.UserQuestionDao;
import entity.UserQuestion;

public class FindUserQuestionAction {
	private List<UserQuestion> list;
	private int page=1;
	private int rows=10;
	private int total;
	
	public String execute(){
		UserQuestionDao dao=new UserQuestionDao();
		
		try {
			list=dao.findByPage(page-1, rows);
			total=dao.findTotalPage(rows);
		} catch (DAOException e) {
			e.printStackTrace();
			return "error";
		}
		return "success";
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

	public List<UserQuestion> getList() {
		return list;
	}

	public void setList(List<UserQuestion> list) {
		this.list = list;
	}

}
