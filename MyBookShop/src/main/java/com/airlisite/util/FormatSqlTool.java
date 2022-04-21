package com.airlisite.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FormatSqlTool {
	/**
	 * 格式化sql字符串
	 * @param sql
	 * @param list
	 * @return
	 */
	public static String formatSqlByList(String sql, List list) {
		int i =0 ;
		while (sql.indexOf("?")!=-1) {
			Object obj = list.get(i);
			if (obj instanceof Integer) {
				sql = sql.replaceFirst("\\?", obj.toString());
			}else if (obj instanceof Long) {
				sql = sql.replaceFirst("\\?", obj.toString());
			}else {
				if (obj == null ) {
					obj ="";
				}
				sql = sql.replaceFirst("\\?", "'"+obj.toString()+"'");
			}
			i++;
		}
		return sql;
	}
	
	/**
	 * 不定参数格式化sql字符串
	 * @param sql
	 * @param args
	 * @return
	 */
	public static String formatSql(String sql,Object...args){
		int i =0 ;
		while (sql.indexOf("?")!=-1) {
			Object obj = args[i];
			if (obj instanceof Integer) {
				sql = sql.replaceFirst("\\?", obj.toString());
			}else if (obj instanceof Long) {
				sql = sql.replaceFirst("\\?", obj.toString());
			}else {
				
				if (obj == null ) {
					obj ="";
				}
				sql = sql.replaceFirst("\\?", "'"+obj.toString()+"'");
			}
			i++;
		}
		return sql;
	}
	
	public static void main(String[] args){
		String sql = "select * from a where id=? and cd=? and ii=?";
		List<Object> listParam = new ArrayList<Object>();
		listParam.add(1);
		listParam.add(2);
		listParam.add(3);
		System.out.println(FormatSqlTool.formatSql(sql, listParam.toArray()));
	}
}
