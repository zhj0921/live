package com.dongwei.kangbao.utils;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FilenameUtils;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient1;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.springframework.core.io.ClassPathResource;


public class FastDFSUtils {

	/**
	 * @throws Exception 
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 * 
	 * @Title: uploadPic
	 * @Description: 附件上传值FastDFS上
	 * @return
	 * @return String
	 * @throws
	 */
	public static String uploadPic(byte[] file_buff, String filename) throws FileNotFoundException, IOException, Exception{
		// 1、加载配置文件
		ClassPathResource  resource = new ClassPathResource("fdfs_client.conf");
		// 2、配置文件初始化
		ClientGlobal.init(resource.getClassLoader().getResource("fdfs_client.conf").getPath());
		// 3、获取跟踪服务器的客户端
		TrackerClient trackerClient = new TrackerClient();
		// 4、通过跟踪服务器客户端获取跟踪服务器
		TrackerServer trackerServer = trackerClient.getConnection();
		// 5、通过跟踪服务器获取存储服务器的客户端
		StorageClient1 storageClient1 = new StorageClient1(trackerServer,null);
		// 6、将附件上传
		String file_ext_name = FilenameUtils.getExtension(filename); // 附件的扩展名
		String path = storageClient1.upload_file1(file_buff, file_ext_name, null); // group1/M00/00/01/......
		return path;
	}
}
