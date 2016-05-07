package com.moma.dawnlove.vo;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.moma.dawnlove.po.MDMenu;
import com.moma.dawnlove.po.MDOrder;

public class MDOrderResultVO {

	private String id;
	private Double meat_weight;
	private Double greens_weight;
	private Double members;
	private String eat_time;
	private String hot;
	private String phone;
	private Date create_time;
	private String processed;
	private Integer order_no; 
	
	private List<MDMenu> hmenuList = new ArrayList<MDMenu>();
	private List<MDMenu> smenuList = new ArrayList<MDMenu>();

	public MDOrderResultVO(MDOrder o, List<MDMenu> ods) {

		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
		
		this.id = o.getId();
		this.meat_weight = o.getMeat_weight();
		this.greens_weight = o.getGreens_weight();
		this.members = o.getMembers();
		this.eat_time = sdf.format(o.getEat_time());
		this.hot = o.getHot();
		this.phone = o.getPhone();
		this.create_time = o.getCreate_time();
		this.processed = o.getProcessed();
		this.order_no = o.getOrder_no();

		if(ods == null)
			return;
		
		for (int i = 0; i < ods.size(); i++) {
			MDMenu m = ods.get(i);

			if ("H".equals(m.getType())) {
				this.hmenuList.add(m);
			} else {
				this.smenuList.add(m);
			}
		}

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

	public String getEat_time() {
		return eat_time;
	}

	public void setEat_time(String eat_time) {
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

	public Date getCreate_time() {
		return create_time;
	}

	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}

	public List<MDMenu> getHmenuList() {
		return hmenuList;
	}

	public void setHmenuList(List<MDMenu> hmenuList) {
		this.hmenuList = hmenuList;
	}

	public List<MDMenu> getSmenuList() {
		return smenuList;
	}

	public void setSmenuList(List<MDMenu> smenuList) {
		this.smenuList = smenuList;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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
