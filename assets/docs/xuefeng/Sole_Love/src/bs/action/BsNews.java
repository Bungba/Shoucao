package bs.action;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import bs.service.BsNewsService;

import com.model.Html;
import com.opensymphony.xwork2.ActionContext;

@Controller
@Scope("prototype")
public class BsNews {
	@Resource
	BsNewsService bsNewsService;
	
	HttpServletRequest request=ServletActionContext.getRequest();
	
	List<Html> list=new ArrayList<Html>();
	
	public String findHTMLCode(){
		list=bsNewsService.findHTMLCode(); 
		return "success";
	}
	int id;
	Html html=new Html();
	public String findHTMLContent(){
		html=bsNewsService.findHTMLCode(id);
		return "success";
	}
	
	boolean result;
	
	String title;
	String content;
	
	public String addHTMLCode(){
		Html h=new Html();
		h.setTitle(title);
		h.setContent(content);
		if (bsNewsService.addHTMLCode(h)) {
			result=true;
		}else{
			result=false;
		}
		return "success";
	}
	
	public String updateHTML(){
		System.out.println(id+"   "+title+"   "+content);
		Html h=new Html();
		h.setId(id);
		h.setTitle(title);
		h.setContent(content);
		result=bsNewsService.updateHTML(h);
		return "success";
	}
	String imgurl;
	public String imgDelete(){
		String a=this.getClass().getResource("/").getPath();
		String b[]=a.split("WEB-INF/classes/");
		StringBuffer sb= new StringBuffer();
        for (int i = 0; i < b.length; i++) {
              sb.append(b[i]);
          }
        
		String c=sb.substring(1).replaceAll("%20", " ").replace("/", "\\");
		String path=c+"attached\\image\\"+imgurl;
		File file=new File(path);
		if (!file.exists()) {
			result=false;
		}else{
			file.delete();
			result=true;
		}
		return "success";
	}
	
	
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public BsNewsService getBsNewsService() {
		return bsNewsService;
	}

	public void setBsNewsService(BsNewsService bsNewsService) {
		this.bsNewsService = bsNewsService;
	}

	public boolean isResult() {
		return result;
	}

	public void setResult(boolean result) {
		this.result = result;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<Html> getList() {
		return list;
	}

	public void setList(List<Html> list) {
		this.list = list;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Html getHtml() {
		return html;
	}

	public void setHtml(Html html) {
		this.html = html;
	}

	public String getImgurl() {
		return imgurl;
	}

	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}

	
}
