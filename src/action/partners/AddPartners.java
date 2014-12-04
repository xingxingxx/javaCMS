package action.partners;

import java.io.File;

import org.apache.struts2.ServletActionContext;

import util.FileUtil;
import dao.DAOException;
import dao.PartnersDao;
import entity.Partners;

public class AddPartners {
	private Partners p=new Partners();
	private String description;
	private File imageUrl;
	private String imageUrlFileName;
	private String imageUrlContentType;
	private String url;
	private Integer num;
	
	public String execute(){
		if(imageUrl == null)
			return "error";
		String path = "/home/fike/webapps/ROOT/upload/partners/" + imageUrlFileName;
		// 根据相对路径找到其完整路径
	/*	path = ServletActionContext
			.getServletContext().getRealPath(path);*/
		p.setDescription(description);
		p.setImageUrl(imageUrlFileName);
		p.setUrl(url);
		p.setDispalyNum(num);
		
		PartnersDao dao=new PartnersDao();
		try {
			dao.addPartners(p);
		} catch (DAOException e) {
			e.printStackTrace();
			return "error";
		}
		
		FileUtil.copy(imageUrl, new File(path));
		return "success";
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

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}
	
}
