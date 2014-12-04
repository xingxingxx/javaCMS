package action.download;

import java.io.InputStream;

import org.apache.struts2.ServletActionContext;

public class DownLoadProductAction {
	private String fileName;
	
	 public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	/** 文件名 转换编码 防止中文乱码*/
	 public String getDownloadFileName() {
	   /* String fileName=ServletActionContext.getRequest().getParameter("fileName");*/
	    String downloadFileName = fileName;
	    try {
	     downloadFileName = new String(downloadFileName.getBytes(), "ISO8859-1");
	    } catch (Exception e) {
	     e.printStackTrace();
	    }
	    return downloadFileName;
	 }

	 //下载的流
	 public InputStream getInputStream() {
	  /*  String name=this.getDownloadFileName();*/
	    System.out.println(fileName);
	    String realPath="/upload/annex/"+fileName;
	    InputStream in=ServletActionContext.getServletContext().getResourceAsStream(realPath);
	    if(null==in){
	     System.out.println("Can not find a java.io.InputStream with the name [inputStream] in the invocation stack. Check the <param name=\"inputName\"> tag specified for this action.检查action中文件下载路径是否正确.");   
	    }
	    return ServletActionContext.getServletContext().getResourceAsStream(realPath);
	 }
	 public String execute(){
	  return "success";
	 }
}
