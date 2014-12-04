package action.text;

import java.util.List;

import dao.DAOException;
import dao.OneColumnsDao;
import dao.PcategoryDao;
import dao.TextDao;
import dao.TwoColumnsDao;
import entity.OneColumns;
import entity.Pcategory;
import entity.Text;
import entity.TwoColumns;

public class FindByIdTextAction {
	private int id;
	private int relationId;
	private Text text;
	private List<OneColumns> listOne;
	private List<TwoColumns> listt;
	private List<Pcategory> pc;
	private List<TwoColumns> tc;
	
	public String execute(){
		TextDao dao=new TextDao();
		OneColumnsDao dao1=new OneColumnsDao();
		TwoColumnsDao dao2=new TwoColumnsDao();
		PcategoryDao dao3=new PcategoryDao();
		try {
			listOne=dao1.findAllDown();
			listt=dao2.findAll();
			pc=dao3.findAll();
			tc=dao2.findByRelationId(relationId);
			text=dao.findById(id);
		} catch (DAOException e) {
			e.printStackTrace();
			return "error";
		}
		return "success";
	}

	public List<TwoColumns> getTc() {
		return tc;
	}

	public void setTc(List<TwoColumns> tc) {
		this.tc = tc;
	}

	public List<OneColumns> getListOne() {
		return listOne;
	}

	public void setListOne(List<OneColumns> listOne) {
		this.listOne = listOne;
	}

	public List<TwoColumns> getListt() {
		return listt;
	}

	public void setListt(List<TwoColumns> listt) {
		this.listt = listt;
	}

	public List<Pcategory> getPc() {
		return pc;
	}

	public void setPc(List<Pcategory> pc) {
		this.pc = pc;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRelationId() {
		return relationId;
	}

	public void setRelationId(int relationId) {
		this.relationId = relationId;
	}


	public Text getText() {
		return text;
	}

	public void setText(Text text) {
		this.text = text;
	}
	
	
	
}
