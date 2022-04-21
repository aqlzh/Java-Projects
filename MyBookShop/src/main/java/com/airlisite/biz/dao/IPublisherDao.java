package com.airlisite.biz.dao;

import java.util.List;

import com.airlisite.biz.entity.Publishers;
import com.airlisite.exception.BookShopException;



public interface IPublisherDao {
	//获取出版社
	public List<Publishers> getPublisher() ;
	//添加出版社
	public boolean addPublisher(Publishers p) ;
	//更新出版社
	public boolean upPublisher(Publishers p);
}
