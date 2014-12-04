package util;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 * @author lwq 自定义分页标签
 */
public class PageTag extends SimpleTagSupport {
	private int page;
	private int totalPage;
	private String href;
	private String class_name;
	private String f;

	public void setHref(String href) {
		this.href = href;
	}

	public void setClass_name(String className) {
		class_name = className;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	@Override
	public void doTag() throws JspException, IOException {
		PageContext context = (PageContext) getJspContext();
		JspWriter out = context.getOut();
		
		if(href.indexOf("?")!=-1){
			f="&";
		}else{
			f="?";
		}
		
		if (totalPage == 0) {
			out
					.println("<a style='color:gray;' onclick='return false;' href=''>首页</a>");
			out
					.println("<a style='color:gray;' onclick='return false;' href=''>上一页</a>");
			out
					.println("<a style='color:gray;' onclick='return false;' href=''>无记录</a>");
			out
					.println("<a style='color:gray;' onclick='return false;' href=''>下一页</a>");
			out
					.println("<a style='color:gray;' onclick='return false;' href=''>尾页</a>");
		} else {

			/**
			 * 判断是否为第一页，如果不是第一页则显示可黑色，可点击"首页" 如果是第一页则灰色，不可点击"首页"
			 */
			if (!(page == 1)) {
				out.println("<a href='" + href + f + "page=" + 1 + "'>首页</a>");
			} else {
				out
						.println("<a style='color:gray;' onclick='return false;' href='"
								+ href + f + "page=" + 1 + "'>首页</a>");
			}

			/** 显示上一页 如果是第一页则 灰色 不可点击 */
			if (!(page == 1)) {
				out.println("<a href='" + href + f + "page=" + (page - 1)
						+ "'>上一页</a>");
			} else {
				out
						.println("<a style='color:gray;' onclick='return false;' href='"
								+ href + f + "page=" + page + "'>上一页</a>");
			}

			/** 循环总页数 控制显示总页数为 3 */
			// 显示的最前面的页码
			int curr_page = 0;
			// 显示的最后面的页码
			int after_page = 0;

			if (totalPage > 4) {
				curr_page = page - 1;
				if (curr_page <= 0) {
					curr_page = page;
					after_page = page + 3;
				} else {
					after_page = page + 2;
					if (after_page == totalPage + 1) {
						after_page = totalPage + 1;
						curr_page = page - 1;
					} else if (after_page > totalPage + 1) {
						after_page = totalPage + 1;
						curr_page = page - 2;
					}
				}
			}else{
				curr_page = 1;
				after_page = totalPage+1;
			}
			
			for (int i = curr_page; i < after_page; i++) {

				if (class_name != null && page == i) {
					out.println("<a class='" + class_name + "' href='" + href + f
							+ "page=" + i + "'>" + i + "</a>");
				} else {
					out.println("<a href='" + href + f + "page=" + i + "'>" + i
							+ "</a>");
				}

			}

			/** 显示下一页 如果是最后一页则 灰色 不可点击 */
			if (!(page == totalPage)) {
				out.println("<a href='" + href + f + "page=" + (page + 1)
						+ "'>下一页</a>");
			} else {
				out
						.println("<a style='color:gray;' onclick='return false;' href='"
								+ href + f + "page=" + page + "'>下一页</a>");
			}

			/** 判断是否为尾页，如果不是最后页则显示尾页 */
			if (!(page == totalPage)) {
				out.println("<a href='" + href + f + "page=" + totalPage
						+ "'>尾页</a>");
			} else {
				out
						.println("<a style='color:gray;' onclick='return false;' href='"
								+ href + f + "page=" + totalPage + "'>尾页</a>");
			}
		}
	}
}
