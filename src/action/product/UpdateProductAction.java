package action.product;

import java.io.File;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import util.FileUtil;
import dao.DAOException;
import dao.ProductDao;
import entity.Product;

public class UpdateProductAction {
	private Product product=new Product();
	private int productId;
	private String productName;
	private int categoryId;
	private File download;
	private String downloadFileName;
	private String downloadContentType;
	
	
	private File minImage;
	private String minImageFileName;
	private String minImageContentType;
	
	private List<File> imageList;
	private List<String> imageListFileName;
	private List<String> imageListContentType;
	
	private String summary;
	private String description="";
	private String function="";
	private String model="";
	
	public String execute(){
		if(download != null){
			String path1 = "/home/fike/webapps/ROOT/upload/annex/" + downloadFileName;
			// 根据相对路径找到其完整路径
			/*path1 = ServletActionContext
				.getServletContext().getRealPath(path1);*/
			product.setDownload(downloadFileName);
			FileUtil.copy(download, new File(path1));
		}
		if(minImage!=null){
			String path2 = "/home/fike/webapps/ROOT/upload/minImage/" + minImageFileName;
			// 根据相对路径找到其完整路径
			/*path2 = ServletActionContext
				.getServletContext().getRealPath(path2);*/
			product.setMinImage(minImageFileName);
			FileUtil.copy(minImage, new File(path2));
		}
		if(imageList!=null){
			String path3;
			String str="";
			for(int i=0;i<imageList.size();i++){
				 path3= "/home/fike/webapps/ROOT/upload/imageList/" + imageListFileName.get(i);
				// 根据相对路径找到其完整路径
				/*path3 = ServletActionContext
					.getServletContext().getRealPath(path3);*/
				str=str+","+imageListFileName.get(i);
				FileUtil.copy(imageList.get(i), new File(path3));
			}
			product.setImageList(str);
		}
		product.setProductId(productId);
		product.setCategoryId(categoryId);
		product.setProductName(productName);
		product.setSummary(summary);
		product.setDescription(description);
		product.setFunction(function);
		product.setModel(model);
		
		ProductDao dao=new ProductDao();
		try {
			dao.updateProduct(product);
		} catch (DAOException e) {
			e.printStackTrace();
			return "error";
		}
		return "success";
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
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

	public List<File> getImageList() {
		return imageList;
	}

	public void setImageList(List<File> imageList) {
		this.imageList = imageList;
	}

	public List<String> getImageListFileName() {
		return imageListFileName;
	}

	public void setImageListFileName(List<String> imageListFileName) {
		this.imageListFileName = imageListFileName;
	}

	public List<String> getImageListContentType() {
		return imageListContentType;
	}

	public void setImageListContentType(List<String> imageListContentType) {
		this.imageListContentType = imageListContentType;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getFunction() {
		return function;
	}

	public void setFunction(String function) {
		this.function = function;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	
}
