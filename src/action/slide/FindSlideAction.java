package action.slide;

import java.util.List;

import dao.DAOException;
import dao.SlideDao;

import entity.Slide;

public class FindSlideAction {
	private List<Slide> list;
	
	public List<Slide> getList() {
		return list;
	}

	public void setList(List<Slide> list) {
		this.list = list;
	}

	public String execute(){
		SlideDao dao=new SlideDao();
		try {
			list=dao.findAll();
		} catch (DAOException e) {
			e.printStackTrace();
			return "error";
		}
		return "success";
	}

	
}
