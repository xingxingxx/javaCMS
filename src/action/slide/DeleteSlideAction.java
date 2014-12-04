package action.slide;

import dao.DAOException;
import dao.SlideDao;

public class DeleteSlideAction {
	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String execute(){
		SlideDao dao=new SlideDao();
		try {
			dao.deleteSlide(id);
		} catch (DAOException e) {
			e.printStackTrace();
			return "error";
		}
		return "success";
	}
}
