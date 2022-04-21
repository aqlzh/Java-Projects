package com.airlisite.biz.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.airlisite.base.DaoBaseI;
import com.airlisite.biz.dao.ICategoriesDao;
import com.airlisite.biz.entity.Categories;
import com.airlisite.exception.BookShopException;
import com.airlisite.exception.BookShopExceptionTypeEnum;
import com.airlisite.util.ValidateTool;

@Repository("iCategoriesDao")
public class CategoriesDaoImpl implements ICategoriesDao {

	@Autowired
	@Qualifier("baseDao")
	private DaoBaseI baseDao;
/*	DateBase db;
	public CategoriesDaoImpl(){
		db=new DateBase();
	}*/
	
	//获取出版社
	@Override
	public List<Categories> getCategories(){
		StringBuffer sbsql = new StringBuffer();
		sbsql.append(" select * from categories order by Id desc ");
		try {
			return baseDao.query(sbsql.toString(), Categories.class);
		} catch (DataAccessException e) {
			//throw new BookShopException(BookShopExceptionTypeEnum.COMMON_SYSTEM_ERROR_CODE.getCode(),BookShopExceptionTypeEnum.COMMON_SYSTEM_ERROR_CODE.getMsg(),e);
			e.printStackTrace();
			return new ArrayList<Categories>();
		}
		/*//创建集合
		List<Categories> clist = new ArrayList<Categories>();
		//得到连接
		Connection con=db.getConnection();
		String sql="select * from categories order by Id desc";
		try {
			//sql语句
			PreparedStatement stmt=con.prepareStatement(sql);
            //ִ执行sql
			ResultSet rs=stmt.executeQuery();
			while (rs.next()) {
				Categories c = new Categories();
				c.setId(rs.getInt(1));
				c.setName(rs.getString(2));
				clist.add(c);			
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return clist;*/
	}

	
	//添加分类
	@Override
	public boolean addCategory(Categories c) {
		StringBuffer sbsql = new StringBuffer();
	    List paramList = new ArrayList();
		sbsql.append("insert into categories(Name) value(?)");
	
		paramList.add(c.getName());

		try {
			this.baseDao.executeSQL(sbsql.toString(),paramList.toArray());
			return true;
		} catch (DataAccessException e) {
//			throw new BookShopException(BookShopExceptionTypeEnum.COMMON_SYSTEM_ERROR_CODE.getCode(),BookShopExceptionTypeEnum.COMMON_SYSTEM_ERROR_CODE.getMsg(),e);
			e.printStackTrace();
			return false;
		}
		/*Connection con = db.getConnection();
		String sql = "insert into categories(Name) value(?)";
		PreparedStatement stmt = null;
		try {
			stmt = con.prepareStatement(sql);
			//设置参数
			stmt.setString(1, c.getName());
			//ִ执行
			int rs = stmt.executeUpdate();
			if(rs>0){
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;*/
	}

	
	//更新分类
	@Override
	public boolean updateCategory(Categories c) {
		StringBuffer sbsql = new StringBuffer();
	    List paramList = new ArrayList();
		sbsql.append("update categories set Name=? where Id=? ");
	
		paramList.add(c.getName());
		paramList.add(c.getId());
		try {
			this.baseDao.executeSQL(sbsql.toString(),paramList.toArray());
			return true;
		} catch (DataAccessException e) {
			//throw new BookShopException(BookShopExceptionTypeEnum.COMMON_SYSTEM_ERROR_CODE.getCode(),BookShopExceptionTypeEnum.COMMON_SYSTEM_ERROR_CODE.getMsg(),e);
			e.printStackTrace();
			return false;
		}
		/*Connection con = db.getConnection();
		String sql = "update categories set Name=? where Id=?";
		PreparedStatement stmt = null;
		try {
			stmt = con.prepareStatement(sql);
			//设置参数
			stmt.setString(1, c.getName());
			stmt.setInt(2, c.getId());
			//ִ执行
			int rs = stmt.executeUpdate();
			if(rs>0){
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;*/
	}

}
