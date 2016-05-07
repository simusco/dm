package com.moma.dawnlove.mapper;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.moma.dawnlove.po.MDMenu;
import com.moma.dawnlove.po.MDOrder;
import com.moma.dawnlove.po.MDOrderDetail;

@Repository
public interface MDBookMapper {

	public List<MDMenu> getMenuList();

	public void saveOrder(MDOrder order);

	public MDMenu getMenuById(String menu_id);

	public void saveOrderDetail(MDOrderDetail od);

	public List<MDOrder> getOrderList(Date start);

	public List<MDOrderDetail> getOrderDetailByOrderId(String id);

	public void make(String orderId);

	public Integer getMaxOrderNo(Date date);

}
