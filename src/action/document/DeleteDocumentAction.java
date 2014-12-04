package action.document;

import dao.DAOException;
import dao.DocumentDao;
import entity.Document;

public class DeleteDocumentAction {
	private int id;
	private int categoryId;
	
	public String execute(){
		DocumentDao dao=new DocumentDao();
		try {
			Document d=dao.findById(id);
			categoryId=d.getCategoryId();
			dao.deleteDocument(id);
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
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	
}
