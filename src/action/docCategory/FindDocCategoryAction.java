package action.docCategory;

import java.util.List;

import dao.DAOException;
import dao.DocCategoryDao;
import entity.DocCategory;

public class FindDocCategoryAction {
	private List<DocCategory> list;
	
	public String execute(){
		DocCategoryDao dao=new DocCategoryDao();
		try {
			list=dao.findAll();
		} catch (DAOException e) {
			e.printStackTrace();
			return "error";
		}
		return "success";
	}

	public List<DocCategory> getList() {
		return list;
	}

	public void setList(List<DocCategory> list) {
		this.list = list;
	}
	
}
