package com.moma.dawnlove.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.moma.dawnlove.ErrorCode;
import com.moma.dawnlove.exception.ServiceException;
import com.moma.dawnlove.exception.WebException;
import com.moma.dawnlove.po.MDMenu;
import com.moma.dawnlove.po.MDOrder;
import com.moma.dawnlove.service.MDBookService;
import com.moma.dawnlove.vo.MDOrderResultVO;
import com.moma.dawnlove.web.WebResult;
import com.moma.dawnlove.web.springmvc.RestfulController;

@Scope(value = "prototype")
@RequestMapping("/book")
@Controller("MDBookController")
public class MDBookController extends RestfulController {

	@Resource
	private MDBookService bookService;
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public WebResult book() throws Exception {
		try{
			List<MDMenu> list = bookService.getMenuList();
			
			// 获取msg列表
			return new WebResult(list,ErrorCode.SUCCESS.code, ErrorCode.SUCCESS.msg);
		}catch(ServiceException e){
			return new WebResult(null, e.getCode(), e.getMessage());
		}catch (WebException e) {
			return e.toWebResult();
		}catch (Exception e) {
			return new WebResult(null, ErrorCode.PARAM_NOT_PARSE.code, "EXCEl不能解析!");
		}
	}
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public WebResult book(@RequestBody MDOrder order) throws Exception {
		try{
			System.out.println(order);
			
			order = bookService.saveOrder(order);
			
			// 获取msg列表
			return new WebResult(new MDOrderResultVO(order, null),ErrorCode.SUCCESS.code, ErrorCode.SUCCESS.msg);
		}catch(ServiceException e){
			return new WebResult(null, e.getCode(), e.getMessage());
		}catch (WebException e) {
			return e.toWebResult();
		}catch (Exception e) {
			return new WebResult(null, ErrorCode.PARAM_NOT_PARSE.code, "EXCEl不能解析!");
		}
	}
	
	@RequestMapping(value="/console",method = RequestMethod.GET)
	@ResponseBody
	public WebResult console() throws Exception {
		try{
			List<MDOrderResultVO> list = bookService.getOrderList();
			
			// 获取msg列表
			return new WebResult(list,ErrorCode.SUCCESS.code, ErrorCode.SUCCESS.msg);
		}catch(ServiceException e){
			return new WebResult(null, e.getCode(), e.getMessage());
		}catch (WebException e) {
			return e.toWebResult();
		}catch (Exception e) {
			return new WebResult(null, ErrorCode.PARAM_NOT_PARSE.code, "EXCEl不能解析!");
		}
	}
	
	@RequestMapping(value="/make/{orderId}",method = RequestMethod.POST)
	@ResponseBody
	public WebResult make(@PathVariable String orderId) throws Exception {
		try{
			bookService.make(orderId);
			// 获取msg列表
			return new WebResult(true,ErrorCode.SUCCESS.code, ErrorCode.SUCCESS.msg);
		}catch(ServiceException e){
			return new WebResult(null, e.getCode(), e.getMessage());
		}catch (WebException e) {
			return e.toWebResult();
		}catch (Exception e) {
			return new WebResult(null, ErrorCode.PARAM_NOT_PARSE.code, "EXCEl不能解析!");
		}
	}
	
}
