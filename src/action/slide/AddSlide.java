package action.slide;

import java.io.File;

import org.apache.struts2.ServletActionContext;

import util.FileUtil;
import dao.DAOException;
import dao.SlideDao;
import entity.Slide;

public class AddSlide {
	private Slide slide=new Slide();
	private String description;
	private File imageUrl;
	private String imageUrlFileName;
	private String imageUrlContentType;
	private String url;
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public File getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(File imageUrl) {
		this.imageUrl = imageUrl;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getImageUrlFileName() {
		return imageUrlFileName;
	}
	public void setImageUrlFileName(String imageUrlFileName) {
		this.imageUrlFileName = imageUrlFileName;
	}
	public String getImageUrlContentType() {
		return imageUrlContentType;
	}
	public void setImageUrlContentType(String imageUrlContentType) {
		this.imageUrlContentType = imageUrlContentType;
	}
	
	
	public String execute(){
		if(imageUrl == null)
			return "error";
		String path = "/home/fike/webapps/ROOT/upload/slide/" + imageUrlFileName;
		// 根据相对路径找到其完整路径
		/*path = ServletActionContext
			.getServletContext().getRealPath(path);*/
		slide.setDescription(description);
		slide.setImageUrl(imageUrlFileName);
		slide.setUrl(url);
		
		SlideDao dao=new SlideDao();
		try {
			dao.addSlide(slide);
		} catch (DAOException e) {
			e.printStackTrace();
			return "error";
		}
		
		FileUtil.copy(imageUrl, new File(path));
		return "success";
	}
	
}
