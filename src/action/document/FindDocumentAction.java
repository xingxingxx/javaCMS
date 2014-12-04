package action.document;

import java.util.List;

import dao.DAOException;
import dao.DocCategoryDao;
import dao.DocumentDao;
import entity.DocCategory;
import entity.Document;

public class FindDocumentAction {
	private List<Document> list;
	private int page=1;
	private int rows=15;
	private int total;
	private Integer id;
	private List<DocCategory> listDoc;
	
	public String execute(){
		DocumentDao dao=new DocumentDao();
		DocCategoryDao dao2=new DocCategoryDao();
		try {
			if(id==null){
				list=dao.findByPage(page-1, rows);
				total=dao.findTotalPage(rows);
			}else{
				list=dao.findByCategory2(page-1, rows, id);
				total=dao.findTotalPageByCategory2(rows, id);
			}
			
			listDoc=dao2.findAll();
			
		} catch (DAOException e) {
			e.printStackTrace();
			return "error";
		}
		return "success";
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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<DocCategory> getListDoc() {
		return listDoc;
	}

	public void setListDoc(List<DocCategory> listDoc) {
		this.listDoc = listDoc;
	}
	
	
}
