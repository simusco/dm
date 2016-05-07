package com.moma.dawnlove.service;

import java.util.List;

import com.moma.dawnlove.po.MDMenu;
import com.moma.dawnlove.po.MDOrder;
import com.moma.dawnlove.vo.MDOrderResultVO;

public interface MDBookService {

	List<MDMenu> getMenuList();

	MDOrder saveOrder(MDOrder order);

	List<MDOrderResultVO> getOrderList();

	void make(String orderId);

}
