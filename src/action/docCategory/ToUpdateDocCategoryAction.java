package action.docCategory;

import dao.DAOException;
import dao.DocCategoryDao;
import entity.DocCategory;

public class ToUpdateDocCategoryAction {
	private int id;
	private DocCategory d;
	
	public String execute(){
		DocCategoryDao dao=new DocCategoryDao();
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

	public DocCategory getD() {
		return d;
	}

	public void setD(DocCategory d) {
		this.d = d;
	}
	
}
