package a.b.c.com.common;

import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.oreilly.servlet.MultipartRequest;

public class FileUploadUtil {
	
	private String imgfilePaths;
	private int imgfileSize;
	private String encodeType;
	private MultipartRequest mr;
	
	Logger log = LogManager.getLogger(FileUploadUtil.class);
	
	public FileUploadUtil(String imgfilePaths, int imgfileSize, String encodeType) {

		this.imgfilePaths = imgfilePaths;
		this.imgfileSize = imgfileSize;
		this.encodeType = encodeType;
	}

	public boolean imgfileUpload(HttpServletRequest req) {
		
		boolean bool = imgfileUpload(req,imgfilePaths);
		log.info(" >>>> :" + bool);
		log.info(">>>> " + req);
		log.info(">>>> " + imgfilePaths);
		return bool;
	}

	private boolean imgfileUpload(HttpServletRequest req, String filepath) {
		boolean bool = false;
		log.info(">>>> " + req);
		log.info(">>>> " + req.getParameter("mname"));
		log.info(">>>> " + filepath);
		log.info(">>>> " + imgfileSize);
		log.info(">>>> " + encodeType);		
		
		try {
			
			mr = new MultipartRequest(req, filepath, imgfileSize, encodeType, new FileRename());
			bool = true;
			log.info(">>>> " + bool);
			log.info(">>>> " + mr);
		} catch (Exception e) {
			// TODO: handle exception
			log.info(" >>>> :" + e);
			
		}
		log.info(" >>>> :" + bool);

		
		return bool;
	}
	
	public String getParameter(String s) {
		return mr.getParameter(s);
	}
	
	public String[] getParameterValues(String s) {
		return mr.getParameterValues(s);
	}
	
	public String getFileName(String f) {
		return mr.getFilesystemName(f);
	}
	
	public ArrayList<String> getFileNames(){
		
		@SuppressWarnings("unchecked")
		Enumeration<String> en = mr.getFileNames();
		ArrayList<String> a = new ArrayList<String>();
		
		while (en.hasMoreElements()) {
			String f = en.nextElement().toString();
			a.add(mr.getFilesystemName(f));
			}
		
		
		return a;
	}
}
