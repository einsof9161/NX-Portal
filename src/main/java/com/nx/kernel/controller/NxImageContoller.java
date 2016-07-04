package com.nx.kernel.controller;

import java.io.File;
import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.hibernate.Hibernate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.nx.kernel.model.NxImageFile;
import com.nx.kernel.service.NxImageFileService;



/**
 * @author edward
 *
 */
@Controller
public class NxImageContoller{
	
	private static final Logger logger = LoggerFactory.getLogger(NxImageContoller.class);
	
	
	@Autowired
	NxImageFileService<NxImageFile> imageServices;
	
	NxImageFile ufile;
	public NxImageContoller(){
		System.out.println("init RestController");
		ufile = new NxImageFile();
	}
	
	@RequestMapping("/getImage/{id}")
	public void getImage(@PathVariable int id, HttpServletResponse response) throws SQLException, IOException {
    
		NxImageFile image = imageServices.findById(id);
		response.setContentType(image.getContentType());  
		int blobLength = (int) image.getContent().length();
		byte[] blobAsBytes = image.getContent().getBytes(1, blobLength);
		image.getContent().free();
		
		if(image!=null){
			response.getOutputStream().write(blobAsBytes);
	    	response.getOutputStream().close();
		}
		
	}

	@RequestMapping(value = "/imageUploadController", method = RequestMethod.POST)
	public @ResponseBody String upload2(MultipartHttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
		
		List<MultipartFile> fileList  = request.getMultiFileMap().get("file");
		MultipartFile mpf = fileList.get(0);
		System.out.println(mpf.getOriginalFilename() +" uploaded!");
		
		// Creating the directory to store file
		String rootPath = System.getProperty("catalina.home");
		File dir = new File(rootPath + File.separator + "tmp/pic");
		if (!dir.exists()) dir.mkdirs();
		
		// Create the file on server
		File serverFile = new File(dir.getAbsolutePath()+ File.separator + Calendar.getInstance().getTimeInMillis()+mpf.getOriginalFilename());
		FileUtils.copyInputStreamToFile(mpf.getInputStream(),serverFile);
		
		Blob blob = imageServices.getBlob(mpf.getInputStream(), mpf.getSize());
		
		ufile.setFilename(mpf.getOriginalFilename());
		ufile.setContent(blob);
		ufile.setContentType(mpf.getContentType());
		imageServices.save(ufile);
		
		System.out.println(ufile.getId());
		
		if(blob!=null)blob.free();
		logger.info("Server File Location="+ serverFile.getAbsolutePath());
		System.out.println("Server File Location="+ serverFile.getAbsolutePath());
		System.out.println(request.getContextPath());
		return "<img src='./getImage/"+ufile.getId()+"' id='"+ufile.getId()+"' width='160px' height='160px' class='img-circle' />";
	}
	
}
