package com.dongwei.kangbao.utils.page;

import java.util.ArrayList;
import java.util.List;

/**
 * 列表分页。包含list属性。
 */
public class Pagination extends SimplePage{

	private static final long serialVersionUID = -2801195455913234475L;
	
	private Double  TotalSales;	//总销售额
	private Double ySales;	//已消费额
	private Double wSales;	//未消费额
	
	public Double getTotalSales() {
		return TotalSales;
	}

	public void setTotalSales(Double totalSales) {
		TotalSales = totalSales;
	}
	
	public Double getySales() {
		return ySales;
	}

	public void setySales(Double ySales) {
		this.ySales = ySales;
	}

	public Double getwSales() {
		return wSales;
	}

	public void setwSales(Double wSales) {
		this.wSales = wSales;
	}

	
	
	
	
	public Pagination() {
	}

	/**
	 * 构造器
	 * 
	 * @param pageNo
	 *            页码
	 * @param pageSize
	 *            每页几条数据
	 * @param totalCount
	 *            总共几条数据
	 */
	public Pagination(int pageNo, int pageSize, int totalCount) {
		super(pageNo, pageSize, totalCount);
		
	}

	/**
	 * 构造器
	 * 
	 * @param pageNo
	 *            页码
	 * @param pageSize
	 *            每页几条数据
	 * @param totalCount
	 *            总共几条数据
	 * @param list
	 *            分页内容
	 */
	public Pagination(int pageNo, int pageSize, int totalCount, List<?> list) {
		super(pageNo, pageSize, totalCount);
		this.list = list;
	}

	/**
	 * 第一条数据位置
	 * 
	 * @return
	 */
	public int getFirstResult() {
		return (pageNo - 1) * pageSize;
	}

	/**
	 * 当前页的数据
	 */
	private List<?> list;
	
	/**
	 * 当前页的分页样式
	 */
	private List<String> pageView;

	/**
	 * 获得分页内容
	 * 
	 * @return
	 */
	public List<?> getList() {
		return list;
	}

	/**
	 * 设置分页内容
	 * 
	 * @param list
	 */
	
	@SuppressWarnings("rawtypes")
	public void setList(List list) {
		this.list = list;
	}
	/**
	 * 获得分页样式
	 * 
	 * @return
	 */
	public List<String> getPageView() {
		return pageView;
	}
	/**
	 * 设置分页样式
	 * 
	 * @param list
	 */
	public void setPageView(List<String> pageView) {
		this.pageView = pageView;
	}


	/**
	 * 分页显示样示部分
	 */
	public void pageView(String url,String params){
		
	 	pageView = new ArrayList<String>();
	 		
        if(this.pageNo != 1){
            pageView.add("<li><a href=\"javascript:void(0);\" onclick=\"javascript:window.location.href='" + url + "?" + params + "&pageNo=1'\">首页</a></li>");
            pageView.add("<li><a href=\"javascript:void(0);\" onclick=\"javascript:window.location.href='" + url + "?" + params + "&pageNo="+(this.pageNo-1)+"'\">上一页</a></li>");
        }else{
        	pageView.add("<li><a>首页</a></li>");
        	pageView.add("<li><a>上一页</a></li>");
        }
    
        if(this.getTotalPage() <= 10){
            for (int i = 0; i < this.getTotalPage(); i++) {
                if((i+1)==this.pageNo){
                    pageView.add("<li class='active'><a>"+this.pageNo+"</a></li>");
                    i = i+1;
                    if(this.pageNo==this.getTotalPage())break;
                }
                pageView.add("<li><a href=\"javascript:void(0);\" onclick=\"javascript:window.location.href='" + url + "?" + params + "&pageNo="+(i+1)+"'\">"+(i+1)+"</a></li>");
            }
        }else if(this.getTotalPage() <= 20){
            //没有把...加上
            int l = 0;
            int r = 0;
            if(this.pageNo<5){
                l=this.pageNo-1;
                r=10-l-1;
            }else if(this.getTotalPage()-this.pageNo<5){
                r=this.getTotalPage()-this.pageNo;
                l=10-1-r;
            }else{
                l=4;
                r=5;
            }
            int tmp =  this.pageNo-l;
            for (int i = tmp; i < tmp+10; i++) {
                if(i==this.pageNo){
                    pageView.add("<li class='active'><a>"+this.pageNo+"</a></li>");
                    i = i+1;
                    if(this.pageNo==this.getTotalPage()) break;
                }
                pageView.add("<li><a href=\"javascript:void(0);\" onclick=\"javascript:window.location.href='" + url + "?" + params + "&pageNo="+(i)+"'\">"+(i)+"</a></li>");
            }
                
        }else if(this.pageNo<7){
            for (int i = 0; i < 8; i++) {
                if(i+1==this.pageNo){
                    pageView.add("<li class='active'><a>"+this.pageNo+"</a></li>");
                    i = i+1;
                }
                pageView.add("<li><a href=\"javascript:void(0);\" onclick=\"javascript:window.location.href='" + url + "?" + params + "&pageNo="+(i+1)+"'\">"+(i+1)+"</a></li>");
            }
            pageView.add("...");
            pageView.add("<li><a href=\"javascript:void(0);\" onclick=\"javascript:window.location.href='" + url + "?" + params + "&pageNo="+(this.getTotalPage()-1)+"'\">"+(this.getTotalPage()-1)+"</a></li>");
            pageView.add("<li><a href=\"javascript:void(0);\" onclick=\"javascript:window.location.href='" + url + "?" + params + "&pageNo="+(this.getTotalPage())+"'\">"+(this.getTotalPage())+"</a></li>");
        }else if(this.pageNo>this.getTotalPage()-6){
            pageView.add("<li><a href=\"javascript:void(0);\" onclick=\"javascript:window.location.href='" + url + "?" + params + "&pageNo="+(1)+"'\">"+(1)+"</a></li>");
            pageView.add("<li><a href=\"javascript:void(0);\" onclick=\"javascript:window.location.href='" + url + "?" + params + "&pageNo="+(2)+"'\">"+(2)+"</a></li>");
            pageView.add("...");
            for (int i = this.getTotalPage()-8; i <this.getTotalPage() ; i++) {
                if(i+1==this.pageNo){
                    pageView.add("<li class='active'><a>"+this.pageNo+"</a></li>");
                    i = i+1;
                    if(this.pageNo==this.getTotalPage()) break;
                }
                pageView.add("<li><a href=\"javascript:void(0);\" onclick=\"javascript:window.location.href='" + url + "?" + params + "&pageNo="+(i+1)+"'\">"+(i+1)+"</a></li>");
            }
        }else{
            pageView.add("<li><a href=\"javascript:void(0);\" onclick=\"javascript:window.location.href='" + url + "?" + params + "&pageNo="+(1)+"'\">"+(1)+"</a></li>");
            pageView.add("<li><a href=\"javascript:void(0);\" onclick=\"javascript:window.location.href='" + url + "?" + params + "&pageNo="+(2)+"'\">"+(2)+"</a></li>");
            pageView.add("...");
            
            pageView.add("<li><a href=\"javascript:void(0);\" onclick=\"javascript:window.location.href='" + url + "?" + params + "&pageNo="+(this.pageNo-2)+"'\">"+(this.pageNo-2)+"</a></li>");
            pageView.add("<li><a href=\"javascript:void(0);\" onclick=\"javascript:window.location.href='" + url + "?" + params + "&pageNo="+(this.pageNo-1)+"'\">"+(this.pageNo-1)+"</a></li>");
            pageView.add("<li class='active'><a>"+this.pageNo+"</a></li>");
            pageView.add("<li><a href=\"javascript:void(0);\" onclick=\"javascript:window.location.href='" + url + "?" + params + "&pageNo="+(this.pageNo+1)+"'\">"+(this.pageNo+1)+"</a></li>");
            pageView.add("<li><a href=\"javascript:void(0);\" onclick=\"javascript:window.location.href='" + url + "?" + params + "&pageNo="+(this.pageNo+2)+"'\">"+(this.pageNo+2)+"</a></li>");
            
            pageView.add("...");
            pageView.add("<li><a href=\"javascript:void(0);\" onclick=\"javascript:window.location.href='" + url + "?" + params + "&pageNo="+(this.getTotalPage()-1)+"'\">"+(this.getTotalPage()-1)+"</a></li>");
            pageView.add("<li><a href=\"javascript:void(0);\" onclick=\"javascript:window.location.href='" + url + "?" + params + "&pageNo="+(this.getTotalPage())+"'\">"+(this.getTotalPage())+"</a></li>");
        }    
        if(this.pageNo != this.getTotalPage()){
            pageView.add("<li><a href=\"javascript:void(0);\" onclick=\"javascript:window.location.href='" + url + "?" + params + "&pageNo="+(this.pageNo+1)+"'\">下一页</a></li>");
            pageView.add("<li><a href=\"javascript:void(0);\" onclick=\"javascript:window.location.href='" + url + "?" + params + "&pageNo="+this.getTotalPage()+"'\">尾页</a></li>");
        } else{
        	pageView.add("<li><a>下一页</a></li>");
        	pageView.add("<li><a>尾页<a></li>");
        }
        //pageView.add("<li><a>共" + getTotalPage() + "页<a></li> ");
	}

	
	
}
