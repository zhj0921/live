package com.dongwei.kangbao.controller.system;

import java.io.UnsupportedEncodingException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.dongwei.kangbao.po.Androidversion;
import com.dongwei.kangbao.service.SysService;
import com.dongwei.kangbao.utils.UploadFileUtils;
import com.dongwei.kangbao.utils.page.Pagination;

/**
 * 
 * @ClassName: AndroidController
 * @Company: http://www.it.cn/
 * @Description: 
 * @author zhj
 * @date 2016年10月13日 下午11:33:44
 */
@Controller
@RequestMapping("/system")
public class SystemController {
	
	
	@Resource
	private SysService sysService;
	
	/**
	 * @throws UnsupportedEncodingException 
	 * 
	 * @Title: list
	 * @Description: 列表查询
	 */
	@RequestMapping("/list.do")
	public String list(Integer pageNo, Model model) throws UnsupportedEncodingException{
		//调用service执行查询
		Pagination pagination = sysService.queryAndroidByAndroidQuery(pageNo);
		
	    model.addAttribute("pageNo", pageNo);
		//将数据放入list中
	    model.addAttribute("pagination", pagination);
		
		return "/system/update";
	}
	
	/**
	 * 
	 * @Title: add
	 * @Description: 添加成功
	 */
	@RequestMapping("/addAndroid.do")
	public String add(MultipartFile file,Model model,  HttpServletRequest request,String version,String describe)throws Exception{
		if (file.getSize()<=0) {
			model.addAttribute("error", "请选择上传的安装包！！");
			return "/system/add";
		}
		String path = UploadFileUtils.uploadFileAPK(file, request);
		Androidversion androidversion = new Androidversion();
		androidversion.setPath(path);
		androidversion.setVersion(version);
		androidversion.setDescribe(describe);
		androidversion.setIdentify(1);
		
		sysService.addAndroid(androidversion);
		

		
		return "redirect:/system/list.do";
	}
	
	
	
	/**
	 * 
	 * @Title: delete
	 * @Description: 删除操作
	 * @param 
	 * @return
	 * @return String
	 * @throws
	 */
	@RequestMapping("/deleteAndroid.do")
	@ResponseBody
	public String deleteAndroid(Integer id ,HttpServletRequest request){
		sysService.deleteAndroidById(id);
		
		return "ok";
	}

}
