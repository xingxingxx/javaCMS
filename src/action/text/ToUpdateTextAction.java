package action.text;

import dao.DAOException;
import dao.TextDao;
import entity.Text;

public class ToUpdateTextAction {
	private int id;
	private Text text;
	
	public String execute(){
		TextDao dao=new TextDao();
		try {
			text=dao.findById(id);
		} catch (DAOException e) {
			e.printStackTrace();
			return "error";
		}
		return "success";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Text getText() {
		return text;
	}

	public void setText(Text text) {
		this.text = text;
	}
	
	
}
