package com.beans;

public class Goods {
	private int g_id;
	private int u_id;
	private String name;
	private String quality;	//成色
	private String img;		//图片
	private String inf;		//简介
	private String review;
	private String state;
	public Goods(int u_id, String name, String quality, String img, String inf) {
		super();
		this.u_id = u_id;
		this.name = name;
		this.quality = quality;
		this.img = img;
		this.inf = inf;
	}
	public Goods() {
		super();
	}
	public int getG_id() {
		return g_id;
	}
	public void setG_id(int g_id) {
		this.g_id = g_id;
	}
	public int getU_id() {
		return u_id;
	}
	public void setU_id(int u_id) {
		this.u_id = u_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getQuality() {
		return quality;
	}
	public void setQuality(String quality) {
		this.quality = quality;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getInf() {
		return inf;
	}
	public void setInf(String inf) {
		this.inf = inf;
	}
	public String getReview() {
		return review;
	}
	public void setReview(String review) {
		this.review = review;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	

}
