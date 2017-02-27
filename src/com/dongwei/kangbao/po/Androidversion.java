package com.dongwei.kangbao.po;

import java.io.Serializable;

public class Androidversion implements Serializable{

	private static final long serialVersionUID = -1890209413061886640L;
	
	private Integer id;		//id
	private String path;	//安装包上传的路径
	private String version;	//版本号
	private String describe;//版本描述
	private Integer identify;//状态
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getDescribe() {
		return describe;
	}
	public void setDescribe(String describe) {
		this.describe = describe;
	}
	public Integer getIdentify() {
		return identify;
	}
	public void setIdentify(Integer identify) {
		this.identify = identify;
	}
	@Override
	public String toString() {
		return "Androidversion [id=" + id + ", path=" + path + ", version=" + version + ", describe=" + describe
				+ ", identify=" + identify + "]";
	}
	
}
