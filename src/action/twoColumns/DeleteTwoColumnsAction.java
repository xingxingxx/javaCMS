package action.twoColumns;

import java.util.List;

import dao.DAOException;
import dao.TextDao;
import dao.TwoColumnsDao;
import entity.Text;

public class DeleteTwoColumnsAction {
	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public String execute(){
		TwoColumnsDao dao=new TwoColumnsDao();
		TextDao dao2=new TextDao();
		try {
			List<Text> list=dao2.findByCategory(id);
			if(list.size()>0){
				return "cannot";
			}else{
				dao.deleteTwoColumns(id);
			}
		} catch (DAOException e) {
			e.printStackTrace();
			return "error";
		}
		return "success";
	}
}
