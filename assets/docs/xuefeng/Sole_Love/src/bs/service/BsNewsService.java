package bs.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.model.Html;

import bs.dao.BsNewsDao;

@Service
public class BsNewsService {
	@Resource
	BsNewsDao bsNewsDao;

	public List<Html> findHTMLCode() {
		return bsNewsDao.findHTMLCode();
	}

	public Html findHTMLCode(int id) {
		return bsNewsDao.findHTMLCode(id);
	}

	public boolean addHTMLCode(Html html) {
		return bsNewsDao.addHTMLCode(html);
	}
	public boolean updateHTML(Html html){
		return bsNewsDao.updateHTML(html);
	}
}
