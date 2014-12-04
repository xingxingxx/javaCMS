package action.oneColumns;

import java.util.List;

import dao.DAOException;
import dao.DocumentDao;
import dao.OneColumnsDao;
import dao.PartnersDao;
import dao.PcategoryDao;
import dao.SlideDao;
import dao.TextDao;
import dao.TwoColumnsDao;
import entity.Document;
import entity.OneColumns;
import entity.Partners;
import entity.Pcategory;
import entity.Slide;
import entity.Text;
import entity.TwoColumns;

public class FindAllColumnsAction{
	private List<OneColumns> listOne;
	private List<TwoColumns> listt;
	private List<TwoColumns> listJ;
	private List<Pcategory> pc;
	private List<Slide> slideList;
	private List<Partners> partnersList;
	private List<Text> textList2;
	private List<Document> listDoc;
	private int newId;
	private int docId;
	
	
	
	public List<Document> getListDoc() {
		return listDoc;
	}
	public void setListDoc(List<Document> listDoc) {
		this.listDoc = listDoc;
	}
	public List<TwoColumns> getListJ() {
		return listJ;
	}
	public void setListJ(List<TwoColumns> listJ) {
		this.listJ = listJ;
	}
	
	public List<Partners> getPartnersList() {
		return partnersList;
	}
	public void setPartnersList(List<Partners> partnersList) {
		this.partnersList = partnersList;
	}
	public int getNewId() {
		return newId;
	}
	public void setNewId(int newId) {
		this.newId = newId;
	}

	public int getDocId() {
		return docId;
	}

	public void setDocId(int docId) {
		this.docId = docId;
	}

	public List<Text> getTextList2() {
		return textList2;
	}

	public void setTextList2(List<Text> textList2) {
		this.textList2 = textList2;
	}

	

	public List<Slide> getSlideList() {
		return slideList;
	}

	public void setSlideList(List<Slide> slideList) {
		this.slideList = slideList;
	}

	public List<Pcategory> getPc() {
		return pc;
	}

	public void setPc(List<Pcategory> pc) {
		this.pc = pc;
	}

	public List<TwoColumns> getListt() {
		return listt;
	}

	public void setListt(List<TwoColumns> listt) {
		this.listt = listt;
	}

	public List<OneColumns> getListOne() {
		return listOne;
	}

	public void setListOne(List<OneColumns> listOne) {
		this.listOne = listOne;
	}

	public String execute(){
		OneColumnsDao dao=new OneColumnsDao();
		TwoColumnsDao dao2=new TwoColumnsDao();
		PcategoryDao dao3=new PcategoryDao();
		SlideDao dao4=new SlideDao();
		TextDao dao5=new TextDao();
		PartnersDao dao6=new PartnersDao();
		DocumentDao dao7=new DocumentDao();
		try {
			TwoColumns twocol;
			
			twocol=dao2.findByName("新闻中心");
			if(twocol!=null){
				textList2=dao5.findByCategory(0,4,twocol.getColumnsId());
				newId=twocol.getRelationId();
			}
			listDoc=dao7.findByPage(0, 4);
			
			OneColumns one;
			one=dao.findByName("解决方案");
			listJ=dao2.findByPage(0,4,one.getColumnsId());
			
			listOne=dao.findAllDown();
			listt=dao2.findAll();
			pc=dao3.findAll();
			slideList=dao4.findAll();
			partnersList=dao6.findAll2();
		} catch (DAOException e) {
			e.printStackTrace();
			return "error";
		}
		return "success";
	}
}
