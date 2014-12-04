package action.partners;

import java.io.File;

import util.FileUtil;
import dao.DAOException;
import dao.PartnersDao;
import entity.Partners;

public class UpdatePartnersAction {
	private Partners p=new Partners();
	private int partnersId;
	private String description;
	private File imageUrl;
	private String imageUrlFileName;
	private String imageUrlContentType;
	private String url;
	private int num;
	
	public String execute(){
		if(imageUrl != null){
			String path = "/home/fike/webapps/ROOT/upload/partners/" + imageUrlFileName;
			
			/*path = ServletActionContext
					.getServletContext().getRealPath(path);*/
			System.out.println("完整路径为："+path);
			FileUtil.copy(imageUrl, new File(path));
			p.setImageUrl(imageUrlFileName);
		}
		p.setDescription(description);
		p.setUrl(url);
		p.setPartnersId(partnersId);
		p.setDispalyNum(num);
		PartnersDao dao=new PartnersDao();
		try {
			dao.updatePartners(p);
		} catch (DAOException e) {
			e.printStackTrace();
			return "error";
		}
		return "success";
	}

	public Partners getP() {
		return p;
	}

	public void setP(Partners p) {
		this.p = p;
	}

	public int getPartnersId() {
		return partnersId;
	}

	public void setPartnersId(int partnersId) {
		this.partnersId = partnersId;
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

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}
	
	
}
