package action.pcategory;

import dao.DAOException;
import dao.PcategoryDao;

public class AddPcategoryAction {
	private String categoryName;

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String execute(){
		PcategoryDao dao=new PcategoryDao();
		try {
			dao.addPcategory(categoryName);
		} catch (DAOException e) {
			e.printStackTrace();
			return "error";
		}
		return "success";
	}
}
