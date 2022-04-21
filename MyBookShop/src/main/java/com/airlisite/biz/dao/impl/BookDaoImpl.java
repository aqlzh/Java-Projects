package com.airlisite.biz.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.airlisite.base.DaoBaseI;
import com.airlisite.biz.dao.IBookDao;
import com.airlisite.biz.entity.Books;
import com.airlisite.exception.BookShopException;
import com.airlisite.exception.BookShopExceptionTypeEnum;
import com.airlisite.util.ValidateTool;


@Repository("iBookDao")
public class BookDaoImpl implements IBookDao {

	@Autowired
	@Qualifier("baseDao")
	private DaoBaseI baseDao;
	
	@Override
	public List<Books> getBooksByTitle(String title){
		//List<Books> blist=new ArrayList<Books>();
		
		StringBuffer sbsql = new StringBuffer();
		sbsql.append(" select *  from books  where title like ? ");
		try {
			return baseDao.query(sbsql.toString(), Books.class, title);
		} catch (DataAccessException e) {
			//throw new BookShopException(BookShopExceptionTypeEnum.COMMON_SYSTEM_ERROR_CODE.getCode(),BookShopExceptionTypeEnum.COMMON_SYSTEM_ERROR_CODE.getMsg(),e);
			e.printStackTrace();
			return new ArrayList<Books>();
		}
		/*//1.得到连接
		Connection con=db.getConnection();
		String sql="select *"+
		" from books"+
		" where title like '%"+title+"%'";
		try {
			//2.创建sql语句
			PreparedStatement stmt=con.prepareStatement(sql);
            //3.ִ执行sql语句
			ResultSet rs=stmt.executeQuery();
			while (rs.next()) {
				Books b = getBookByResultSet(rs);
				blist.add(b);			
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return blist;*/
	}

	@Override
	public List<Books> getBooksByCategoryId(int categoryId){
		StringBuffer sbsql = new StringBuffer();
		sbsql.append(" select *  from books  where categoryId=? ");
		try {
			return baseDao.query(sbsql.toString(), Books.class, categoryId);
		} catch (DataAccessException e) {
			//throw new BookShopException(BookShopExceptionTypeEnum.COMMON_SYSTEM_ERROR_CODE.getCode(),BookShopExceptionTypeEnum.COMMON_SYSTEM_ERROR_CODE.getMsg(),e);
			return new ArrayList<Books>();
		}
		/*List<Books> blist=new ArrayList<Books>();
		//得到数据连接对象
		Connection con=db.getConnection();
		String sql="select *"+
		" from books"+
		" where categoryId=?";
		try {
			//创建sql语句
			PreparedStatement stmt=con.prepareStatement(sql);
			stmt.setInt(1, categoryId);
            //执行sql
			ResultSet rs=stmt.executeQuery();
			while (rs.next()) {
				Books b = getBookByResultSet(rs);
				blist.add(b);			
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return blist;*/
	}

	@Override
	public Books getBooksByIsbn(String isbn){
		StringBuffer sbsql = new StringBuffer();
		sbsql.append(" select *  from books  where isbn = ? ");
		try {
			return baseDao.queryForObject(sbsql.toString(), Books.class,isbn);
		} catch (DataAccessException e) {
			//throw new BookShopException(BookShopExceptionTypeEnum.COMMON_SYSTEM_ERROR_CODE.getCode(),BookShopExceptionTypeEnum.COMMON_SYSTEM_ERROR_CODE.getMsg(),e);
			return null;
		}
		/*//得到数据连接对象
		Connection con=db.getConnection();
		String sql="select *"+
		" from books"+
		" where isbn = '"+isbn+"'";
		Books b=null;
		try {
			//创建sql语句
			PreparedStatement stmt=con.prepareStatement(sql);
            //执行sql
			ResultSet rs=stmt.executeQuery();
			if(rs.next()) {
				b = getBookByResultSet(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return b;*/
	}

	@Override
	public List<Books> getHotBooksByClicks(){
		StringBuffer sbsql = new StringBuffer();
		sbsql.append(" select Id id,Title  title,Author author,PublisherId publisherId,PublishDate publishDate");
		sbsql.append(",ISBN isbn,WordsCount wordsCount,UnitPrice unitPrice,ContentDescription contentDescription");
		sbsql.append(",AuthorDescription authorDescription,EditorComment editorComment,TOC toc,CategoryId categoryId");
		sbsql.append(",Clicks clicks,Pic pic from books order by Clicks desc ");
		try {
			return baseDao.query(sbsql.toString(), Books.class,new Object[]{});
		} catch (DataAccessException e) {
			//throw new BookShopException(BookShopExceptionTypeEnum.COMMON_SYSTEM_ERROR_CODE.getCode(),BookShopExceptionTypeEnum.COMMON_SYSTEM_ERROR_CODE.getMsg(),e);
			return new ArrayList<Books>();
		}
		/*List<Books> blist=new ArrayList<Books>();
		//得到数据连接对象
		Connection con=db.getConnection();
		String sql="select * from books order by Clicks desc";
		try {
			//创建sql语句
			PreparedStatement stmt=con.prepareStatement(sql);
            //3.执行sql
			ResultSet rs=stmt.executeQuery();
			while (rs.next()) {
				Books b = getBookByResultSet(rs);
				blist.add(b);			
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return blist;*/
	}

	@Override
	public Books getBooksById(int id){
		StringBuffer sbsql = new StringBuffer();
		sbsql.append(" select * from books  where id = ? ");
		try {
			return baseDao.queryForObject(sbsql.toString(), Books.class,id);
		} catch (DataAccessException e) {
			//throw new BookShopException(BookShopExceptionTypeEnum.COMMON_SYSTEM_ERROR_CODE.getCode(),BookShopExceptionTypeEnum.COMMON_SYSTEM_ERROR_CODE.getMsg(),e);
			return null;
		}
		/*//得到数据连接对象
		Connection con=db.getConnection();
		String sql="select *"+
		" from books"+
		" where id=?";
		Books b=null;
		try {
			//创建sql语句
			PreparedStatement stmt=con.prepareStatement(sql);
			stmt.setInt(1, id);
            //执行sql
			ResultSet rs=stmt.executeQuery();
			if(rs.next()) {
				b = getBookByResultSet(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return b;*/
	}
	
	/**
	 * 根据出版社名称查询
	 */
	@Override
	public List<Books> getBooksByPublishName(String name){
		StringBuffer sbsql = new StringBuffer();
		sbsql.append(" SELECT books.* FROM books,publishers where books.PublisherId=publishers.Id AND publishers.`Name` LIKE ? ");
		try {
			return baseDao.query(sbsql.toString(), Books.class, "");
		} catch (DataAccessException e) {
			e.printStackTrace();
			//throw new BookShopException(BookShopExceptionTypeEnum.COMMON_SYSTEM_ERROR_CODE.getCode(),BookShopExceptionTypeEnum.COMMON_SYSTEM_ERROR_CODE.getMsg(),e);
			return new ArrayList<Books>();
		}
		/*List<Books> blist=new ArrayList<Books>();
		//得到数据连接对象
		Connection con=db.getConnection();
		String sql="SELECT books.* FROM books,publishers where books.PublisherId=publishers.Id AND publishers.`Name` LIKE '%"+name+"%'";
		try {
			//创建sql语句
			PreparedStatement stmt=con.prepareStatement(sql);
            //执行sql
			ResultSet rs=stmt.executeQuery();
			while (rs.next()) {
				Books b = getBookByResultSet(rs);
				blist.add(b);			
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return blist;*/
	}
	
	
	//封装结果集
	private Books getBookByResultSet(ResultSet rs) throws SQLException{
		Books b = new Books();
		b.setId(rs.getInt(1));
		b.setTitle(rs.getString(2));
		b.setAuthor(rs.getString(3));
		b.setPublisherId(rs.getInt(4));
		b.setPublishDate(rs.getString(5));
		b.setIsbn(rs.getString(6));
		b.setWordsCount(rs.getInt(7));
		b.setUnitPrice(rs.getDouble(8));
		b.setContentDescription(rs.getString(9));
		b.setAuthorDescription(rs.getString(10));
		b.setEditorComment(rs.getString(11));
		b.setToc(rs.getString(12));
		b.setCategoryId(rs.getInt(13));
		b.setClicks(rs.getInt(14));
		b.setPic(rs.getString(15));
		return b;
	}

	@Override
	public List<Books> getBooksByCategoryName(String name){
		StringBuffer sbsql = new StringBuffer();
		sbsql.append(" SELECT books.* FROM books,categories where books.CategoryId=categories.Id AND categories.`Name` LIKE ? ");
		try {
			return baseDao.query(sbsql.toString(), Books.class, "");
		} catch (DataAccessException e) {
			//throw new BookShopException(BookShopExceptionTypeEnum.COMMON_SYSTEM_ERROR_CODE.getCode(),BookShopExceptionTypeEnum.COMMON_SYSTEM_ERROR_CODE.getMsg(),e);
			return new ArrayList<Books>();
		}
		/*List<Books> blist=new ArrayList<Books>();
		//得到数据连接对象
		Connection con=db.getConnection();
		String sql="SELECT books.* FROM books,categories where books.CategoryId=categories.Id AND categories.`Name` LIKE '%"+name+"%'";
		try {
			//创建sql语句
			PreparedStatement stmt=con.prepareStatement(sql);
            //执行sql
			ResultSet rs=stmt.executeQuery();
			while (rs.next()) {
				Books b = getBookByResultSet(rs);
				blist.add(b);			
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return blist;*/
	}

	/**
	 * 获取所有图书
	 */
	@Override
	public List<Books> getBookList() {
		StringBuffer sbsql = new StringBuffer();
		sbsql.append(" SELECT * FROM books ORDER BY Id DESC ");
		try {
			return baseDao.query(sbsql.toString(), Books.class, new Object[]{});
		} catch (DataAccessException e) {
			//throw new BookShopException(BookShopExceptionTypeEnum.COMMON_SYSTEM_ERROR_CODE.getCode(),BookShopExceptionTypeEnum.COMMON_SYSTEM_ERROR_CODE.getMsg(),e);
			return new ArrayList<Books>();
		}
		/*List<Books> blist=new ArrayList<Books>();
		//得到数据连接对象
		Connection con=db.getConnection();
		String sql="SELECT * FROM books ORDER BY Id DESC;";
		try {
			//创建sql语句
			PreparedStatement stmt=con.prepareStatement(sql);
            //执行sql
			ResultSet rs=stmt.executeQuery();
			while (rs.next()) {
				Books b = getBookByResultSet(rs);
				blist.add(b);			
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return blist;*/
	}

	/**
	 * 删除图书
	 */
	@Override
	public boolean delBookBookId(int bookId) {
		StringBuffer sbsql = new StringBuffer();
	    List paramList = new ArrayList();
		sbsql.append(" DELETE FROM books WHERE Id=? ");
		paramList.add(bookId);
		try {
			this.baseDao.executeSQL(sbsql.toString(),paramList.toArray());
			return true;
		} catch (DataAccessException e) {
			//throw new BookShopException(BookShopExceptionTypeEnum.COMMON_SYSTEM_ERROR_CODE.getCode(),BookShopExceptionTypeEnum.COMMON_SYSTEM_ERROR_CODE.getMsg(),e);
			return false;
		}
		/*Connection con=db.getConnection();
		String sql = "DELETE FROM books WHERE Id="+bookId;
		PreparedStatement stmt = null;
		try {
			stmt = con.prepareStatement(sql);
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
	 * 更新图书信息
	 */
	@Override
	public boolean upBook(Books b) {
		StringBuffer sbsql = new StringBuffer();
	    List paramList = new ArrayList();
		sbsql.append("UPDATE books SET Title=?,unitPrice=?,author=?,categoryId=?,");
		sbsql.append("publisherId=?,publishDate=?,ISBN=?,wordsCount=?,contentDescription=?,");
		sbsql.append("authorDescription=?  WHERE Id=? ");
		paramList.add(b.getTitle());
		paramList.add(b.getUnitPrice());
		paramList.add(b.getAuthor());
		paramList.add(b.getCategoryId());
		paramList.add(b.getPublisherId());
		paramList.add(b.getPublishDate());
		paramList.add(b.getIsbn());
		paramList.add(b.getWordsCount());
		paramList.add(b.getContentDescription());
		paramList.add(b.getAuthorDescription());
		paramList.add(b.getId());
		try {
			this.baseDao.executeSQL(sbsql.toString(),paramList.toArray());
			return true;
		} catch (DataAccessException e) {
			//throw new BookShopException(BookShopExceptionTypeEnum.COMMON_SYSTEM_ERROR_CODE.getCode(),BookShopExceptionTypeEnum.COMMON_SYSTEM_ERROR_CODE.getMsg(),e);
			return false;
		}
		/*Connection con = db.getConnection();
		String sql = "UPDATE books SET Title=?,unitPrice=?,author=?,categoryId=?,publisherId=?,publishDate=?,ISBN=?,wordsCount=?,contentDescription=? ,authorDescription=?  WHERE Id=?";
		PreparedStatement stmt = null;
		try {
			stmt = con.prepareStatement(sql);
			//设置参数值
			stmt.setString(1,b.getTitle());
			stmt.setDouble(2,b.getUnitPrice());
			stmt.setString(3,b.getAuthor());
			stmt.setInt(4,b.getCategoryId());
			stmt.setInt(5,b.getPublisherId());
			stmt.setString(6,b.getPublishDate());
			stmt.setString(7,b.getIsbn());
			stmt.setInt(8,b.getWordsCount());
			stmt.setString(9,b.getContentDescription());
			stmt.setString(10,b.getAuthorDescription());
			stmt.setInt(11,b.getId());
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
	 * 添加图书
	 */
	@Override
	public boolean addBook(Books b) {
		StringBuffer sbsql = new StringBuffer();
	    List paramList = new ArrayList();
		sbsql.append("insert into books(Title,unitPrice,author,categoryId,publisherId,publishDate,ISBN,wordsCount,contentDescription,authorDescription) value(?,?,?,?,?,?,?,?,?,?)");
	
		paramList.add(b.getTitle());
		paramList.add(b.getUnitPrice());
		paramList.add(b.getAuthor());
		paramList.add(b.getCategoryId());
		paramList.add(b.getPublisherId());
		paramList.add(b.getPublishDate());
		paramList.add(b.getIsbn());
		paramList.add(b.getWordsCount());
		paramList.add(b.getContentDescription());
		paramList.add(b.getAuthorDescription());
		try {
			this.baseDao.executeSQL(sbsql.toString(),paramList.toArray());
			return true;
		} catch (DataAccessException e) {
			e.printStackTrace();
			return false;
			//throw new BookShopException(BookShopExceptionTypeEnum.COMMON_SYSTEM_ERROR_CODE.getCode(),BookShopExceptionTypeEnum.COMMON_SYSTEM_ERROR_CODE.getMsg(),e);
		}
		/*Connection con = db.getConnection();
		//sql语句
		String sql= "insert into books(Title,unitPrice,author,categoryId,publisherId,publishDate,ISBN,wordsCount,contentDescription,authorDescription) value(?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement stmt = null;
		try {
			stmt = con.prepareStatement(sql);
			//设置参数
			stmt.setString(1, b.getTitle());
			stmt.setDouble(2, b.getUnitPrice());
			stmt.setString(3,b.getAuthor());
			stmt.setInt(4, b.getCategoryId());
			stmt.setInt(5, b.getPublisherId());
			stmt.setString(6,b.getPublishDate());
			stmt.setString(7,b.getIsbn());
			stmt.setInt(8,b.getWordsCount());
			stmt.setString(9,b.getContentDescription());
			stmt.setString(10,b.getAuthorDescription());
			//执行sql语句
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
