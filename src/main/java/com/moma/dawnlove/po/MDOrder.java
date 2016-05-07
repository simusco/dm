package com.moma.dawnlove.po;

import java.util.Date;

public class MDOrder {

	private String id;
	private Integer order_no;
	private Date create_time;
	private Double meat_weight;
	private Double greens_weight;
	private Double members;
	private Date eat_time;
	private String hot;
	private String phone;
	private String[] menuIds;
	private String processed;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getCreate_time() {
		return create_time;
	}

	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}

	public Double getMeat_weight() {
		return meat_weight;
	}

	public void setMeat_weight(Double meat_weight) {
		this.meat_weight = meat_weight;
	}

	public Double getGreens_weight() {
		return greens_weight;
	}

	public void setGreens_weight(Double greens_weight) {
		this.greens_weight = greens_weight;
	}

	public Double getMembers() {
		return members;
	}

	public void setMembers(Double members) {
		this.members = members;
	}

	public Date getEat_time() {
		return eat_time;
	}

	public void setEat_time(Date eat_time) {
		this.eat_time = eat_time;
	}

	public String getHot() {
		return hot;
	}

	public void setHot(String hot) {
		this.hot = hot;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String[] getMenuIds() {
		return menuIds;
	}

	public void setMenuIds(String[] menuIds) {
		this.menuIds = menuIds;
	}

	public String getProcessed() {
		return processed;
	}

	public void setProcessed(String processed) {
		this.processed = processed;
	}

	public Integer getOrder_no() {
		return order_no;
	}

	public void setOrder_no(Integer order_no) {
		this.order_no = order_no;
	}

}
