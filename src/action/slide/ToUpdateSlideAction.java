package action.slide;

import dao.DAOException;
import dao.SlideDao;
import entity.Slide;

public class ToUpdateSlideAction {
	private int id;
	private Slide slide;
	

	public Slide getSlide() {
		return slide;
	}

	public void setSlide(Slide slide) {
		this.slide = slide;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public String execute(){
		SlideDao dao=new SlideDao();
		try {
			slide=dao.findById(id);
		} catch (DAOException e) {
			e.printStackTrace();
			return "error";
		}
		return "success";
	}
}
