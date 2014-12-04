package action.userQuestion;

import java.util.List;

import dao.AdminAnswerDao;
import dao.DAOException;
import dao.OneColumnsDao;
import dao.PcategoryDao;
import dao.TwoColumnsDao;
import dao.UserQuestionDao;
import entity.AdminAnswer;
import entity.OneColumns;
import entity.Pcategory;
import entity.TwoColumns;
import entity.UserQuestion;

public class UserQuestionAction {
	private List<OneColumns> listOne;
	private List<TwoColumns> listt;
	private List<Pcategory> pc;
	private List<TwoColumns> tc;
	private int relationId;
	private int id;
	
	private int page=1;
	private int rows=8;
	private int total;
	
	private List<UserQuestion> uq;
	private List<AdminAnswer> list;
	
	
	
	public String execute(){
		OneColumnsDao dao1=new OneColumnsDao();
		TwoColumnsDao dao2=new TwoColumnsDao();
		PcategoryDao dao3=new PcategoryDao();
		UserQuestionDao dao4=new UserQuestionDao();
		AdminAnswerDao dao5=new AdminAnswerDao();
		try {
			listOne=dao1.findAllDown();
			listt=dao2.findAll();
			pc=dao3.findAll();
			tc=dao2.findByRelationId(relationId);
			
			uq=dao4.findByPage(page-1, rows);
			total=dao4.findTotalPage(rows);
			
			list=dao5.findAll();
		} catch (DAOException e) {
			e.printStackTrace();
			return "error";
		}
		
		return "success";
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



	public List<UserQuestion> getUq() {
		return uq;
	}



	public void setUq(List<UserQuestion> uq) {
		this.uq = uq;
	}



	public List<AdminAnswer> getList() {
		return list;
	}



	public void setList(List<AdminAnswer> list) {
		this.list = list;
	}
	
	
	
}	
