package action.document;

import java.io.File;

import org.apache.struts2.ServletActionContext;

import util.FileUtil;
import dao.DAOException;
import dao.DocumentDao;
import entity.Document;

public class AddDocumentAction {
	private Document d=new Document();
	private int categoryId;
	private String title;
	private String edition="";
	private int flow;
	
	private File download;
	private String downloadFileName;
	private String downloadContentType;
	
	public String execute(){
		
		if(download!=null){
			String path1 = "/home/fike/webapps/ROOT/upload/program/" + downloadFileName;
			/*path1 = ServletActionContext
				.getServletContext().getRealPath(path1);*/
			d.setDownload(downloadFileName);
			FileUtil.copy(download, new File(path1));
		}else{
			d.setDownload("");
		}
		
		d.setCategoryId(categoryId);
		d.setTitle(title);
		d.setEdition(edition);
		d.setFlow(flow);
		
		DocumentDao dao=new DocumentDao();
		try {
			dao.addDocument(d);
		} catch (DAOException e) {
			e.printStackTrace();
			return "error";
		}
		
		return "success";
	}

	public Document getD() {
		return d;
	}

	public void setD(Document d) {
		this.d = d;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getEdition() {
		return edition;
	}

	public void setEdition(String edition) {
		this.edition = edition;
	}

	public int getFlow() {
		return flow;
	}

	public void setFlow(int flow) {
		this.flow = flow;
	}

	public File getDownload() {
		return download;
	}

	public void setDownload(File download) {
		this.download = download;
	}

	public String getDownloadFileName() {
		return downloadFileName;
	}

	public void setDownloadFileName(String downloadFileName) {
		this.downloadFileName = downloadFileName;
	}

	public String getDownloadContentType() {
		return downloadContentType;
	}

	public void setDownloadContentType(String downloadContentType) {
		this.downloadContentType = downloadContentType;
	}
	
}
