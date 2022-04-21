/**
 * 
 */
package com.airlisite.base;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.CallableStatementCallback;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
/**
 * @author Administrator
 *
 */
@Repository("baseDao")
public class DaoBaseImpl implements DaoBaseI {

	private static final Logger logger = LoggerFactory.getLogger(DaoBaseImpl.class);
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	/* (non-Javadoc)
	 * @see com.airlisite.base.DaoBaseI#executeSQL(java.lang.String, java.lang.Object[])
	 */
	public int executeSQL(String sql, Object... args) throws DataAccessException {
		return jdbcTemplate.update(sql, args);
	}

	/* (non-Javadoc)
	 * @see com.airlisite.base.DaoBaseI#batchExecuteSQL(java.lang.String, java.util.List)
	 */
	public int[] batchExecuteSQL(String sql, List<List<Object>> paramValues) throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.airlisite.base.DaoBaseI#batchExecuteSQL(java.lang.String[])
	 */
	public int[] batchExecuteSQL(String[] sql) throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.airlisite.base.DaoBaseI#queryForObject(java.lang.String, java.lang.Class, java.lang.Object[])
	 */
	public <T> T queryForObject(String sql, Class<T> returnClass, Object... args) throws DataAccessException {
		try {
			 long start = System.currentTimeMillis();
		     BeanPropertyRowMapper<T> beanPropertyRowMapper = new BeanPropertyRowMapper<T>();   
		     beanPropertyRowMapper.setMappedClass(returnClass); 
			 T obj = jdbcTemplate.queryForObject(sql, beanPropertyRowMapper,args);
			 logger.info( "dao获取数据时间:".concat((System.currentTimeMillis() - start)+""));
			 return obj;
		} catch (DataAccessException e) {
			if ((e instanceof IncorrectResultSizeDataAccessException)
					&&((IncorrectResultSizeDataAccessException)e).getActualSize()==0) {
				logger.debug("SQL语句["+sql+"] 返回结果集为空");
				return null;
			}
			throw e;
		}
	}

	/* (non-Javadoc)
	 * @see com.airlisite.base.DaoBaseI#queryForLong(java.lang.String, java.lang.Object[])
	 */
	public Long queryForLong(String sql, Object... args) throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.airlisite.base.DaoBaseI#queryForString(java.lang.String, java.lang.Object[])
	 */
	public String queryForString(String sql, Object... args) throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.airlisite.base.DaoBaseI#query(java.lang.String, java.lang.Class, java.lang.Object[])
	 */
	public <T> List<T> query(String sql, Class<T> returnClass, Object... args) throws DataAccessException {
		try {
			 long start = System.currentTimeMillis();
		     BeanPropertyRowMapper<T> beanPropertyRowMapper = new BeanPropertyRowMapper<T>();   
		     beanPropertyRowMapper.setMappedClass(returnClass); 
			 List<T> obj = jdbcTemplate.query(sql, beanPropertyRowMapper, args);
			 logger.info( "dao获取数据时间:".concat((System.currentTimeMillis() - start)+""));
			 return obj;
		} catch (DataAccessException e) {
			if ((e instanceof IncorrectResultSizeDataAccessException)
					&&((IncorrectResultSizeDataAccessException)e).getActualSize()==0) {
				logger.debug("SQL语句["+sql+"] 返回结果集为空");
				return null;
			}
			throw e;
		}
	}

	/* (non-Javadoc)
	 * @see com.airlisite.base.DaoBaseI#queryForMap(java.lang.String, java.lang.Object[])
	 */
	public List<Map> queryForMap(String sql, Object... args) throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.airlisite.base.DaoBaseI#getConnection(int)
	 */
	public Connection getConnection() throws SQLException {
		Connection conn = this.jdbcTemplate.getDataSource().getConnection();
		return conn;
	}

	/* (non-Javadoc)
	 * @see com.airlisite.base.DaoBaseI#executeCall(java.lang.String, org.springframework.jdbc.core.CallableStatementCallback)
	 */
	public <T> T executeCall(String callString, CallableStatementCallback<T> action)
			throws SQLException, DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

}
