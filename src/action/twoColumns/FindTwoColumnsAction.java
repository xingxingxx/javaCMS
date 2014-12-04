package action.twoColumns;

import java.util.List;

import dao.DAOException;
import dao.TwoColumnsDao;
import entity.TwoColumns;

public class FindTwoColumnsAction{
	private List<TwoColumns> list;
	private int id;
	public List<TwoColumns> getList() {
		return list;
	}
	public void setList(List<TwoColumns> list) {
		this.list = list;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String execute(){
		TwoColumnsDao dao=new TwoColumnsDao();
		try {
			list=dao.findByRelationId(id);
		} catch (DAOException e) {
			e.printStackTrace();
			return "error";
		}
		return "success";
	}
	
}
