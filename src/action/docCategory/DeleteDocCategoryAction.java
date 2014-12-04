package action.docCategory;

import dao.DAOException;
import dao.DocCategoryDao;

public class DeleteDocCategoryAction {
	private int id;
	public String execute(){
		DocCategoryDao dao=new DocCategoryDao();
		try {
			dao.deleteDocCategory(id);
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
	
}
