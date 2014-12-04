package action.docCategory;

import dao.DAOException;
import dao.DocCategoryDao;

public class AddDocCategoryAction {
	private String categoryName;
	
	public String execute(){
		DocCategoryDao dao=new DocCategoryDao();
		try {
			dao.addDocCategory(categoryName);
		} catch (DAOException e) {
			e.printStackTrace();
			return "error";
		}
		return "success";
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
}
