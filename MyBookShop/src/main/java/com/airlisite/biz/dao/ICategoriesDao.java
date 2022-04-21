package com.airlisite.biz.dao;

import java.util.List;

import com.airlisite.biz.entity.Categories;
import com.airlisite.exception.BookShopException;


public interface ICategoriesDao {
	//获取分类
	public List<Categories> getCategories();
	//添加分类
	public boolean addCategory(Categories c);
	//更新分类
	public boolean updateCategory(Categories c);
}
