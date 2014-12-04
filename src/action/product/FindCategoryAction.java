package action.product;

import java.util.List;

import dao.DAOException;
import dao.PcategoryDao;
import entity.Pcategory;

public class FindCategoryAction {
	private List<Pcategory> list;

	public List<Pcategory> getList() {
		return list;
	}

	public void setList(List<Pcategory> list) {
		this.list = list;
	}
	
	public String execute(){
		PcategoryDao dao=new PcategoryDao();
		try {
			list=dao.findAll();
		} catch (DAOException e) {
			e.printStackTrace();
			return "error";
		}
		return "success";
	}
}
