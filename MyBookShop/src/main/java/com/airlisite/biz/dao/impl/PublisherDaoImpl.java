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
import com.airlisite.biz.dao.IPublisherDao;
import com.airlisite.biz.entity.Books;
import com.airlisite.exception.BookShopException;
import com.airlisite.exception.BookShopExceptionTypeEnum;
import com.airlisite.biz.entity.Publishers;

@Repository("iPublisherDao")
public class PublisherDaoImpl implements IPublisherDao {
	@Autowired
	@Qualifier("baseDao")
	private DaoBaseI baseDao;
	/*DateBase db;
	public PublisherDaoImpl(){
		db=new DateBase();
	}*/
	
	/**
	 * 获取所有出版社
	 */
	@Override
	public List<Publishers> getPublisher(){
		StringBuffer sbsql = new StringBuffer();
		sbsql.append(" select * from publishers  order by Id desc ");
		try {
			return baseDao.query(sbsql.toString(), Publishers.class);
		} catch (DataAccessException e) {
			//throw new BookShopException(BookShopExceptionTypeEnum.COMMON_SYSTEM_ERROR_CODE.getCode(),BookShopExceptionTypeEnum.COMMON_SYSTEM_ERROR_CODE.getMsg(),e);
			e.printStackTrace();
			return  new ArrayList<Publishers>();
		}
		/*//创建集合
		List<Publishers> plist = new ArrayList<Publishers>();
		//得到连接
		Connection con=db.getConnection();
		String sql="select * from publishers  order by Id desc";
		try {
			//sql语句
			PreparedStatement stmt=con.prepareStatement(sql);
            //ִ执行sql
			ResultSet rs=stmt.executeQuery();
			while (rs.next()) {
				Publishers p = new Publishers();
				p.setId(rs.getInt(1));
				p.setName(rs.getString(2));
				plist.add(p);			
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return plist;*/
	}

	/**
	 * 添加出版社
	 */
	@Override
	public boolean addPublisher(Publishers p) {
		StringBuffer sbsql = new StringBuffer();
	    List paramList = new ArrayList();
		sbsql.append(" insert into publishers(Name) value(?) ");
		paramList.add(p.getName());
		try {
			this.baseDao.executeSQL(sbsql.toString(),paramList.toArray());
			return true;
		} catch (DataAccessException e) {
			//throw new BookShopException(BookShopExceptionTypeEnum.COMMON_SYSTEM_ERROR_CODE.getCode(),BookShopExceptionTypeEnum.COMMON_SYSTEM_ERROR_CODE.getMsg(),e);
			e.printStackTrace();
			return false;
		}
		/*Connection con = db.getConnection();
		String sql = "insert into publishers(Name) value(?)";
		PreparedStatement stmt = null;
		try {
			stmt = con.prepareStatement(sql);
			//设置参数
			stmt.setString(1, p.getName());
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

	/**
	 * 更新出版社
	 * @param p
	 * @return
	 */
	@Override
	public boolean upPublisher(Publishers p) {
		StringBuffer sbsql = new StringBuffer();
	    List paramList = new ArrayList();
		sbsql.append(" update publishers set Name=? where Id=? ");
		paramList.add(p.getName());
		paramList.add(p.getId());
		try {
			this.baseDao.executeSQL(sbsql.toString(),paramList.toArray());
			return true;
		} catch (DataAccessException e) {
			//throw new BookShopException(BookShopExceptionTypeEnum.COMMON_SYSTEM_ERROR_CODE.getCode(),BookShopExceptionTypeEnum.COMMON_SYSTEM_ERROR_CODE.getMsg(),e);
			e.printStackTrace();
			return false;
		}
		/*Connection con = db.getConnection();
		String sql = "update publishers set Name=? where Id=?";
		PreparedStatement stmt = null;
		try {
			stmt = con.prepareStatement(sql);
			//设置参数
			stmt.setString(1, p.getName());
			stmt.setInt(2, p.getId());
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
