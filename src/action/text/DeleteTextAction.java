package action.text;

import dao.DAOException;
import dao.TextDao;
import entity.Text;

public class DeleteTextAction {
	private int id;
	private int categoryId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String execute(){
		TextDao dao=new TextDao();
		try {
			Text t=dao.findById(id);
			categoryId=t.getCategoryId();
			dao.deleteText(id);
		} catch (DAOException e) {
			e.printStackTrace();
			return "error";
		}
		return "success";
	}
}
