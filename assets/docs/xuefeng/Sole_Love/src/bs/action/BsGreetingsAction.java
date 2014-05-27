package bs.action;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.model.Greetings;
import com.service.GreetingsService;

import bs.service.BsGreetingsService;

@Controller
@Scope("prototype")
public class BsGreetingsAction {
	
	HttpServletRequest request=ServletActionContext.getRequest();
	
	@Resource
	BsGreetingsService bsGreetingsService;
	@Resource
	GreetingsService greetingsService;


	public String findGreeting() {
		request.setAttribute("list", bsGreetingsService.findGreeting());
		return "success";
	}
	
	
	boolean result;

	private File[] upload;
	private String[] uploadFileName;
	private String[] uploadContentType;
	private String savePath;
	private String code;

	public String upLoad() {
		String realPath = ServletActionContext.getServletContext().getRealPath(
				savePath);
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
		String[] greeting=new String[3];
		for (int i = 0; i < upload.length; i++) {
			String fileExt = uploadFileName[i].substring(
					uploadFileName[i].lastIndexOf(".") + 1).toLowerCase();
			String newImgName = df.format(new Date()) + "_"
					+ new Random().nextInt(1000) + "." + fileExt;
			File distFile = new File(realPath + "//" + newImgName);
			greeting[i]=newImgName;
			try {
				
				FileUtils.copyFile(upload[i], distFile);
				result = true;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		boolean flg=greetingsService.addGreetingInfo(greeting[0], greeting[1], greeting[2], code);
		if (!flg) {
			return "input";
		}
		return "success";
	}
	
	public String updateGreeting() {
		String realPath = ServletActionContext.getServletContext().getRealPath(
				savePath);
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
		String[] greeting=new String[3];
		for (int i = 0; i < upload.length; i++) {
			String fileExt = uploadFileName[i].substring(
					uploadFileName[i].lastIndexOf(".") + 1).toLowerCase();
			String newImgName = df.format(new Date()) + "_"
					+ new Random().nextInt(1000) + "." + fileExt;
			File distFile = new File(realPath + "//" + newImgName);
			greeting[i]=newImgName;
			try {
				
				FileUtils.copyFile(upload[i], distFile);
				result = true;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		boolean flg=greetingsService.updateGreeting(id,greeting[0], greeting[1], greeting[2], code);
		if (!flg) {
			return "input";
		}
		return "success";
	}
	
	
	int id;
	List<Greetings> glist=new  ArrayList<Greetings>();
	public String findGreetingInfo(){
		glist.add(greetingsService.findGreetingInfo(id));
		return "success";
	}
	
	public BsGreetingsService getBsGreetingsService() {
		return bsGreetingsService;
	}

	public void setBsGreetingsService(BsGreetingsService bsGreetingsService) {
		this.bsGreetingsService = bsGreetingsService;
	}


	public boolean isResult() {
		return result;
	}

	public void setResult(boolean result) {
		this.result = result;
	}

	public File[] getUpload() {
		return upload;
	}

	public void setUpload(File[] upload) {
		this.upload = upload;
	}

	public String[] getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(String[] uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public String[] getUploadContentType() {
		return uploadContentType;
	}

	public void setUploadContentType(String[] uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

	public String getSavePath() {
		return savePath;
	}

	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Greetings> getGlist() {
		return glist;
	}

	public void setGlist(List<Greetings> glist) {
		this.glist = glist;
	}

}
