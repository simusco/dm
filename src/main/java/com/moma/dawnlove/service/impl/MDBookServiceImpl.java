package com.moma.dawnlove.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.time.DateUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.moma.dawnlove.ErrorCode;
import com.moma.dawnlove.exception.ServiceException;
import com.moma.dawnlove.mapper.MDBookMapper;
import com.moma.dawnlove.po.MDMenu;
import com.moma.dawnlove.po.MDOrder;
import com.moma.dawnlove.po.MDOrderDetail;
import com.moma.dawnlove.service.MDBookService;
import com.moma.dawnlove.util.UUIDUtils;
import com.moma.dawnlove.vo.MDOrderResultVO;

@Service
public class MDBookServiceImpl implements MDBookService {

	@Resource
	private MDBookMapper bookMapper;
	
	@Override
	public List<MDMenu> getMenuList() {
		return bookMapper.getMenuList();
	}

	@Transactional(propagation=Propagation.REQUIRED)
	@Override
	public MDOrder saveOrder(MDOrder order) {
		
		try{
			Integer maxOrderNo = bookMapper.getMaxOrderNo(new Date());
			maxOrderNo = (maxOrderNo == null || maxOrderNo == 0) ? 0 : maxOrderNo;
			
			Calendar temp = Calendar.getInstance();
			temp.setTime(order.getEat_time());
			temp.set(Calendar.YEAR, Calendar.getInstance().get(Calendar.YEAR));
			temp.set(Calendar.MONTH, Calendar.getInstance().get(Calendar.MONTH));
			temp.set(Calendar.DATE, Calendar.getInstance().get(Calendar.DATE));
			
			order.setId(UUIDUtils.getUUID());
			order.setCreate_time(new Date());
			order.setProcessed("N");
			order.setOrder_no(maxOrderNo + 1);
			order.setEat_time(temp.getTime());
			bookMapper.saveOrder(order);
			
			String[] menuIds = order.getMenuIds();
			for(int i=0;i<menuIds.length;i++){
				String menu_id = menuIds[i];
				
				MDOrderDetail od = new MDOrderDetail();
				od.setId(UUIDUtils.getUUID());
				od.setMenu_id(menu_id);
				od.setOrder_id(order.getId());
				od.setWeight(0d);
				
				bookMapper.saveOrderDetail(od);
			}
		}catch(Exception e){
			e.printStackTrace();
			throw new ServiceException(ErrorCode.SERVER_ERROR.code, ErrorCode.SERVER_ERROR.msg);
		}
		
		return order;
		
	}

	@Override
	public List<MDOrderResultVO> getOrderList() {

		List<MDOrderResultVO>  results = new ArrayList<MDOrderResultVO>();
		
		Date date = new Date();
		date = DateUtils.addDays(date, -2);
		
		List<MDOrder> orders = bookMapper.getOrderList(date);
		if(orders != null){
			for(int i=0;i<orders.size();i++){
				List<MDOrderDetail> ods = bookMapper.getOrderDetailByOrderId(orders.get(i).getId());
				
				List<MDMenu> ms = new ArrayList<MDMenu>();
				for(int j=0;j<ods.size();j++){
					MDOrderDetail od = ods.get(j);
					ms.add(bookMapper.getMenuById(od.getMenu_id()));
				}
				
				results.add(new MDOrderResultVO(orders.get(i), ms));
			}
		}
		
		return results;
	}

	@Transactional(propagation=Propagation.REQUIRED)
	@Override
	public void make(String orderId) {
		bookMapper.make(orderId);
	}

}
