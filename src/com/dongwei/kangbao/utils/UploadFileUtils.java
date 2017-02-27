package com.dongwei.kangbao.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;


public class UploadFileUtils {


	public static void uploadPic(MultipartFile pic,HttpServletResponse response,byte[] file_buff, String filename) throws FileNotFoundException, IOException, Exception{
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy/MM/dd/HH");
		/** 构建图片保存的目录 **/
		String logoPathDir = "/apache-tomcat-7.0.53/webapps/files/" + dateformat.format(new Date());
		/** 得到图片保存目录的真实路径 **/
		//String logoRealPathDir = request.getSession().getServletContext().getRealPath(logoPathDir);
		/** 根据真实路径创建目录 **/
		File logoSaveFile = new File(logoPathDir);
		if (!logoSaveFile.exists())
			logoSaveFile.mkdirs();
		/** 页面控件的文件流 **/
		//MultipartFile multipartFile = multipartRequest.getFile("file");
		/** 获取文件的后缀 **/
		String suffix = pic.getOriginalFilename().substring
		(pic.getOriginalFilename().lastIndexOf("."));
		/** 使用UUID生成文件名称 **/
		String logImageName = UUID.randomUUID().toString() + suffix;
		// 构建文件名称
		//String logImageName = multipartFile.getOriginalFilename();
		/** 拼成完整的文件保存路径加文件 **/
		//String fileName = logoPathDir+File.separator + logImageName;
		String fileName = logoPathDir+logImageName;
		File file = new File(fileName);
			pic.transferTo(file);
		// 构建jsonobject
		JSONObject jsonObject = new JSONObject();
		//jsonObject.put("allImgUrl", fileName);
		jsonObject.put("imgUrl", fileName);
		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().write(jsonObject.toString());
	}
	
	/**
	 * 
	 * @Title: uploadFile
	 * @Description: 单文件上传
	 * @param file
	 * @param request
	 * @return
	 * @throws Exception
	 * @return String
	 * @throws
	 */
	@SuppressWarnings("unused")
	public static String uploadFile(MultipartFile file, HttpServletRequest request)throws Exception  {
		if(null == file){
			return null;
		}
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy/MM/dd/HH");
		/** 构建图片保存的目录 **/
		String logoPathDir = "/usr/java/back/apache-tomcat-7.0.72/webapps/files/" + dateformat.format(new Date());
		/** 得到图片保存目录的真实路径 **/
		//String logoRealPathDir = request.getSession().getServletContext().getRealPath(logoPathDir);
		/** 根据真实路径创建目录 **/
		File logoSaveFile = new File(logoPathDir);
		if (!logoSaveFile.exists())
			logoSaveFile.mkdirs();
		/** 页面控件的文件流 **/
		//MultipartFile multipartFile = multipartRequest.getFile("file");
		/** 获取文件的后缀 **/
		String suffix = file.getOriginalFilename().substring
		(file.getOriginalFilename().lastIndexOf("."));
		/** 使用UUID生成文件名称 **/
		String logImageName = UUID.randomUUID().toString() + suffix;
		// 构建文件名称
		//String logImageName = multipartFile.getOriginalFilename();
		/** 拼成完整的文件保存路径加文件 **/
		//String fileName = logoPathDir+File.separator + logImageName;
		String requestURI = request.getRequestURI();
		StringBuffer requestURL1 = request.getRequestURL();
		String requestURL = requestURL1.toString();
		 requestURL = requestURL.replace(requestURI, "");
		 String fileName = logoPathDir+logImageName;
		 
		 System.out.println("图片地址：" + fileName);
		 
		File file1 = new File(fileName);
		file.transferTo(file1);
		fileName = fileName.substring(43);
		System.out.println("fileName :" + fileName);
		fileName = requestURL+fileName;
		System.out.println("fileName2 :" + fileName);
		return fileName;
		}
	
	/**
	 * 
	 * @Title: uploadFile
	 * @Description: 单文件上传
	 * @param file
	 * @param request
	 * @return
	 * @throws Exception
	 * @return String
	 * @throws
	 */
	@SuppressWarnings("unused")
	public static String uploadFileAPK(MultipartFile file, HttpServletRequest request)throws Exception  {
		if(null == file){
			return null;
		}
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy/MM/dd/");
		String format = dateformat.format(new Date());
		String substring = format.substring(5, 11);
		/** 构建图片保存的目录 **/
		String logoPathDir = "/etc/apache-tomcat/webapps/files/" + substring;
		/** 得到图片保存目录的真实路径 **/
		//String logoRealPathDir = request.getSession().getServletContext().getRealPath(logoPathDir);
		/** 根据真实路径创建目录 **/
		File logoSaveFile = new File(logoPathDir);
		if (!logoSaveFile.exists())
			logoSaveFile.mkdirs();
		/** 页面控件的文件流 **/
		//MultipartFile multipartFile = multipartRequest.getFile("file");
		/** 获取文件的后缀 **/
		String suffix = file.getOriginalFilename().substring
				(file.getOriginalFilename().lastIndexOf("."));
		/** 使用UUID生成文件名称 **/
		String logImageName = UUID.randomUUID().toString()+ suffix ;
		logImageName = logImageName.substring(logImageName.length()-11, logImageName.length());
		// 构建文件名称
		//String logImageName = multipartFile.getOriginalFilename();
		/** 拼成完整的文件保存路径加文件 **/
		//String fileName = logoPathDir+File.separator + logImageName;
		String requestURI = request.getRequestURI();
		StringBuffer requestURL1 = request.getRequestURL();
		String requestURL = requestURL1.toString();
		requestURL = requestURL.replace(requestURI, "");
		String fileName = logoPathDir+logImageName;
		
		File file1 = new File(fileName);
		file.transferTo(file1);
		fileName = fileName.substring(26, fileName.length());
		fileName = requestURL+fileName;
		return fileName;
	}
	
	
	
	
	
}
