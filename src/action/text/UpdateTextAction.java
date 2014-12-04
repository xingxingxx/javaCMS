package action.text;

import java.io.File;

import org.apache.struts2.ServletActionContext;

import util.FileUtil;
import dao.DAOException;
import dao.TextDao;
import entity.Text;

public class UpdateTextAction {
	private Text text=new Text();
	private int textId;
	private int categoryId;
	private String title;
	private File minImage;
	private String minImageFileName;
	private String minImageContentType;
	
	private String edition="";
	private int flow;
	
	private File download;
	private String downloadFileName;
	private String downloadContentType;
	
	private String summary="";
	private String content="";
	
	public String execute(){
		if(minImage!=null){
			String path1 = "/home/fike/webapps/ROOT/upload/textImage/" + minImageFileName;
			// 根据相对路径找到其完整路径
			/*path1 = ServletActionContext
				.getServletContext().getRealPath(path1);*/
			text.setMinImage(minImageFileName);
			FileUtil.copy(minImage, new File(path1));
		}
		
		if(download!=null){
			String path1 = "/home/fike/webapps/ROOT/upload/program/" + downloadFileName;
			// 根据相对路径找到其完整路径
			/*path1 = ServletActionContext
				.getServletContext().getRealPath(path1);*/
			text.setDownload(downloadFileName);
			FileUtil.copy(download, new File(path1));
		}
		
		text.setTextId(textId);
		text.setCategoryId(categoryId);
		text.setTitle(title);
		text.setEdition(edition);
		text.setFlow(flow);
		System.out.println(flow);
		text.setSummary(summary);
		text.setContent(content);
		
		TextDao dao=new TextDao();
		try {
			dao.updateText(text);
		} catch (DAOException e) {
			e.printStackTrace();
			return "error";
		}
		
		return "success";
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

	public File getMinImage() {
		return minImage;
	}

	public void setMinImage(File minImage) {
		this.minImage = minImage;
	}

	public String getMinImageFileName() {
		return minImageFileName;
	}

	public void setMinImageFileName(String minImageFileName) {
		this.minImageFileName = minImageFileName;
	}

	public String getMinImageContentType() {
		return minImageContentType;
	}

	public void setMinImageContentType(String minImageContentType) {
		this.minImageContentType = minImageContentType;
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

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getTextId() {
		return textId;
	}

	public void setTextId(int textId) {
		this.textId = textId;
	}
	
}
