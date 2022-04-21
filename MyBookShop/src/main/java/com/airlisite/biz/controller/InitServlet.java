package com.airlisite.biz.controller;

import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import org.springframework.web.context.support.WebApplicationContextUtils;

import com.airlisite.biz.dao.impl.BookDaoImpl;
import com.airlisite.biz.dao.impl.CategoriesDaoImpl;
import com.airlisite.biz.dao.impl.PublisherDaoImpl;
import com.airlisite.biz.entity.Books;
import com.airlisite.biz.entity.Categories;
import com.airlisite.biz.entity.Publishers;

@WebServlet(name="InitServlet",urlPatterns={"/initServlet"},loadOnStartup=0)
public class InitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public InitServlet() {
        super();
    }

	@Override
	public void init(ServletConfig config) throws ServletException {
		//获取图书分类
		//CategoriesDaoImpl dao = new CategoriesDaoImpl();
		CategoriesDaoImpl dao = (CategoriesDaoImpl)WebApplicationContextUtils.getWebApplicationContext(config.getServletContext()).getBean("iCategoriesDao");
		List<Categories> clist = dao.getCategories();
		config.getServletContext().setAttribute("clist", clist);
		
		PublisherDaoImpl pdao = (PublisherDaoImpl)WebApplicationContextUtils.getWebApplicationContext(config.getServletContext()).getBean("iPublisherDao");
		//获取出版社
	//	PublisherDaoImpl pdao = new PublisherDaoImpl();
		List<Publishers> plist = pdao.getPublisher();
		config.getServletContext().setAttribute("plist", plist);
		
		//获取热门图书
		//BookDaoImpl bDao = new BookDaoImpl();
		BookDaoImpl bDao = (BookDaoImpl)WebApplicationContextUtils.getWebApplicationContext(config.getServletContext()).getBean("iBookDao");
		List<Books> hotBList = bDao.getHotBooksByClicks();
		config.getServletContext().setAttribute("hotBList", hotBList);
		String ctxPath = config.getServletContext().getContextPath();
		config.getServletContext().setAttribute("ctxPath", ctxPath);
		System.out.println("InitServlet初始化完毕！");
	}

    

}
