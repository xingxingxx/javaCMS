package action.columns;

import java.util.List;

import dao.DAOException;
import dao.OneColumnsDao;
import dao.TwoColumnsDao;
import entity.OneColumns;
import entity.TwoColumns;

public class FindColumnsAction {
	private List<OneColumns> list;
	private List<TwoColumns> listt;
	
	public List<TwoColumns> getListt() {
		return listt;
	}

	public void setListt(List<TwoColumns> listt) {
		this.listt = listt;
	}

	public List<OneColumns> getList() {
		return list;
	}

	public void setList(List<OneColumns> list) {
		this.list = list;
	}

	public String execute(){
		OneColumnsDao dao=new OneColumnsDao();
		TwoColumnsDao dao2=new TwoColumnsDao();
		try {
			list=dao.findAll();
			listt=dao2.findAll();
		} catch (DAOException e) {
			e.printStackTrace();
			return "error";
		}
		return "success";
	}
}
