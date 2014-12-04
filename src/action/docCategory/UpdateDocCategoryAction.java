package action.docCategory;

import dao.DAOException;
import dao.DocCategoryDao;
import entity.DocCategory;

public class UpdateDocCategoryAction {
	private DocCategory d;
	
	public String execute(){
		DocCategoryDao dao=new DocCategoryDao();
		try {
			dao.updateDocCategory(d);
		} catch (DAOException e) {
			e.printStackTrace();
			return "error";
		}
		return "success";
	}

	public DocCategory getD() {
		return d;
	}

	public void setD(DocCategory d) {
		this.d = d;
	}
	
}
