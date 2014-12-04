package action.document;

import java.util.List;

import dao.DAOException;
import dao.DocCategoryDao;
import dao.DocumentDao;
import dao.OneColumnsDao;
import dao.PcategoryDao;
import dao.TwoColumnsDao;
import entity.DocCategory;
import entity.Document;
import entity.OneColumns;
import entity.Pcategory;
import entity.TwoColumns;

public class FindListDocumentAction {
	private int relationId;
	private int id;
	private List<Document> list;
	private int page=1;
	private int rows=5;
	private int total;
	private List<OneColumns> listOne;
	private List<TwoColumns> listt;
	private List<Pcategory> pc;
	private List<TwoColumns> tc;
	private Integer categoryId;
	private List<DocCategory> listDoc;
	private String categoryName;
	
	public String execute(){
		DocumentDao dao=new DocumentDao();
		OneColumnsDao dao1=new OneColumnsDao();
		TwoColumnsDao dao2=new TwoColumnsDao();
		PcategoryDao dao3=new PcategoryDao();
		DocCategoryDao dao4=new DocCategoryDao();
		try {
			listOne=dao1.findAllDown();
			listt=dao2.findAll();
			pc=dao3.findAll();
			tc=dao2.findByRelationId(relationId);
			if(categoryName!=null){
				list=dao.findByName(categoryName, page-1, rows);
				total=dao.findTotalPageByName(rows, categoryName);
			}
			else if(categoryId!=null){
				list=dao.findByCategory(page-1, rows, categoryId);
				total=dao.findTotalPageByCategory(rows, categoryId);
			}else{
				list=dao.findByPage(page-1, rows);
				total=dao.findTotalPage(rows);
			}
			listDoc=dao4.findAll();
		
			
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

	public List<DocCategory> getListDoc() {
		return listDoc;
	}

	public void setListDoc(List<DocCategory> listDoc) {
		this.listDoc = listDoc;
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

	public List<Document> getList() {
		return list;
	}

	public void setList(List<Document> list) {
		this.list = list;
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

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
	
}
