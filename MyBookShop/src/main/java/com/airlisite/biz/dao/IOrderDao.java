package com.airlisite.biz.dao;

import java.util.List;

import com.airlisite.biz.entity.OrderBook;
import com.airlisite.biz.entity.OrderBookCustom;
import com.airlisite.biz.entity.Orders;
import com.airlisite.exception.BookShopException;

/**
 * 订单操接口类
 * @author Ctony
 *
 */
public interface IOrderDao {
	/**
	 * 添加订单
	 * @param order
	 * @return 订单Id
	 */
	public int addOrder(Orders order);
	/**
	 * 添加详细订单
	 * @param orderBook
	 * @return boolean
	 */
	public boolean addOrderBook(OrderBook orderBook);
	
	/**
	 * 根据当前登录用户Id获取对应的订单
	 * @param userId
	 * @return
	 */
	public List<OrderBookCustom> getOrder(int userId);
	
}
