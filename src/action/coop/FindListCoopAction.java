package action.coop;

import java.util.List;

import dao.DAOException;
import dao.OneColumnsDao;
import dao.PcategoryDao;
import dao.TwoColumnsDao;
import entity.OneColumns;
import entity.Pcategory;
import entity.TwoColumns;

public class FindListCoopAction {
	private int relationId;
	private int id;
	private int page=1;
	private int rows=5;
	private int total;
	private List<OneColumns> listOne;
	private List<TwoColumns> listt;
	private List<Pcategory> pc;
	private List<TwoColumns> tc;
	
	
	public String execute(){
		OneColumnsDao dao1=new OneColumnsDao();
		TwoColumnsDao dao2=new TwoColumnsDao();
		PcategoryDao dao3=new PcategoryDao();
		try {
			listOne=dao1.findAllDown();
			listt=dao2.findAll();
			pc=dao3.findAll();
			tc=dao2.findByRelationId(relationId);
			
		
		} catch (DAOException e) {
			e.printStackTrace();
			return "error";
		}
		
		return "success";
	}


	public int getRelationId() {
		return relationId;
	}


	public void setRelationId(int relationId) {
		this.relationId = relationId;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getPage() {
		return page;
	}


	public void setPage(int page) {
		this.page = page;
	}


	public int getRows() {
		return rows;
	}


	public void setRows(int rows) {
		this.rows = rows;
	}


	public int getTotal() {
		return total;
	}


	public void setTotal(int total) {
		this.total = total;
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


	public List<TwoColumns> getTc() {
		return tc;
	}


	public void setTc(List<TwoColumns> tc) {
		this.tc = tc;
	}
	
}
