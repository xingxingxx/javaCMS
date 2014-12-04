package action.document;

import dao.DAOException;
import dao.DocumentDao;
import entity.Document;

public class ToUpdateDocumentAction {
	private int id;
	private Document d;
	
	public String execute(){
		DocumentDao dao=new DocumentDao();
		try {
			d=dao.findById(id);
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

	public Document getD() {
		return d;
	}

	public void setD(Document d) {
		this.d = d;
	}
	
}	
