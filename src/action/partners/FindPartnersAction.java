package action.partners;

import java.util.List;

import dao.DAOException;
import dao.PartnersDao;
import entity.Partners;

public class FindPartnersAction {
	private List<Partners> list;

	public List<Partners> getList() {
		return list;
	}

	public void setList(List<Partners> list) {
		this.list = list;
	}
	public String execute(){
		PartnersDao dao=new PartnersDao();
		try {
			list=dao.findAll();
		} catch (DAOException e) {
			e.printStackTrace();
			return "error";
		}
		return "success";
	}
}
