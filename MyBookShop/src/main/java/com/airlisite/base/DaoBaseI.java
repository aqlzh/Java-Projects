package com.airlisite.base;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.CallableStatementCallback;


/**
 * 
 * 基础数据库操作类
 * 
 */
public interface DaoBaseI {
	/**
	 * 执行SQL语句
	 * 
	 * @param sql 
	 * @param args 
	 * @return 执行条数
	 */
	public int executeSQL(String sql,Object...args) throws DataAccessException;
	/**
	 * 批量执行SQL语句
	 * 
	 * @param sql 
	 * @param paramValues 
	 * @return 执行条数数组
	 */
	public int[] batchExecuteSQL(String sql,final List<List<Object>> paramValues)throws DataAccessException;
	/**
	 * 批量执行sql语句
	 * 
	 * @param sql数组
	 * @return 成功条数数组
	 */
	public int[] batchExecuteSQL(String[] sql)throws DataAccessException;
	/**
	 * 查找单个对象
	 * 
	 * @param sql
	 * @param rowMapper
	 * @param args
	 * @return T
	 */
	public<T> T queryForObject (String sql,Class<T> returnClass,Object...args)throws DataAccessException ;
	/**
	 * 返回Long
	 * 
	 * @param sql
	 * @param args
	 * @return Long
	 */
	public Long queryForLong (String sql, Object...args) throws DataAccessException;
	/**
	 * 返回String
	 * 
	 * @param sql
	 * @param args
	 * @return String
	 */	
	public String queryForString (String sql, Object...args) throws DataAccessException;
	/**
	 * 查找对象集合
	 * 
	 * @param sql
	 * @param rowMapper
	 * @param args
	 * @return List<T>
	 */
	public<T> List<T> query(String sql,Class<T> returnClass,Object...args)throws DataAccessException;
	
	public List<Map>  queryForMap(String sql, Object...args) throws DataAccessException;
	
	/**
	 * 获取dataSource
	 * @return
	 * @throws Exception
	 */
	public Connection getConnection() throws SQLException;
	
	/**
	 * 执行存储过程
	 * @param <T>
	 * @param callString
	 * @param action
	 * @return
	 * @throws SQLException
	 */
	public <T> T executeCall(String callString,CallableStatementCallback<T> action) throws SQLException,DataAccessException;

}

