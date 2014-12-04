package action.slide;

import java.io.File;

import org.apache.struts2.ServletActionContext;

import util.FileUtil;
import dao.DAOException;
import dao.SlideDao;

import entity.Slide;

public class UpdateSlideAction {
	private Slide slide=new Slide();
	private int slideId;
	private String description;
	private File imageUrl;
	private String imageUrlFileName;
	private String imageUrlContentType;
	private String url;
	public int getSlideId() {
		return slideId;
	}
	public void setSlideId(int slideId) {
		this.slideId = slideId;
	}
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
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	

	public String execute(){
		if(imageUrl != null){
			String path = "/home/fike/webapps/ROOT/upload/slide/" + imageUrlFileName;
			// 根据相对路径找到其完整路径
			/*path = ServletActionContext
				.getServletContext().getRealPath(path);*/
			FileUtil.copy(imageUrl, new File(path));
			slide.setImageUrl(imageUrlFileName);
		}
		
		slide.setDescription(description);
		
		slide.setUrl(url);
		slide.setSlideId(slideId);
		
		SlideDao dao=new SlideDao();
		try {
			dao.updateSlide(slide);
		} catch (DAOException e) {
			e.printStackTrace();
			return "error";
		}
		
		
		return "success";
	}
}
