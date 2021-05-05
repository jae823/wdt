package co.kr.wdt.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Component("fileUtils") 
public class FileUtils { 
	

	private static final String filePath = "C:\\Users\\MyComputer\\eclipse-workspace-1week\\MovieWeb\\MovieReview\\src\\main\\webapp\\assets\\upload\\"; 


	public List<Map<String,Object>> parseInsertFileInfo(Map<String,Object> map, HttpServletRequest request) throws Exception{ 

		String uuid = UUID.randomUUID().toString().replaceAll("-", "");

		MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest)request; 
		Iterator<String> iterator = multipartHttpServletRequest.getFileNames(); 
		MultipartFile multipartFile = null; 
		String originalFileName = null;
		String originalFileExtension = null;
		String originalFileNameExcludedExtension = null;
		String storedFileName = null;
		String movieName = null;
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>(); 
		Map<String, Object> listMap = null; 
		String movieIdx = (String)map.get("IDX"); 
		File file = new File(filePath); 
		if(file.exists() == false){ 
			file.mkdirs(); 
		} 

		while(iterator.hasNext()){ 
			multipartFile = multipartHttpServletRequest.getFile(iterator.next()); 
			if(multipartFile.isEmpty() == false){ 
				originalFileName = multipartFile.getOriginalFilename(); 
				originalFileExtension = originalFileName.substring(originalFileName.lastIndexOf(".")); 
				originalFileNameExcludedExtension = originalFileName.substring(0, originalFileName.lastIndexOf("."));
				storedFileName = uuid + originalFileExtension; 
				file = new File(filePath + storedFileName); 
				multipartFile.transferTo(file); 
				listMap = new HashMap<String,Object>(); 
				listMap.put("mv_Idx", movieIdx); 
				listMap.put("movieName", originalFileNameExcludedExtension);
				listMap.put("original_File_Name", originalFileName); 
				listMap.put("stored_File_Name", storedFileName); 
				listMap.put("file_Size", multipartFile.getSize()); 
				list.add(listMap); 
			} 
		} 

		return list; 
	} 

}

























