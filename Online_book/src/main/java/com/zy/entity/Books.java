package com.zy.entity;

public class Books {
	private Integer bid;
	private String bookname;
	private String bPrice;
	private String image;
	private String stock;
	public Integer getBid() {
		return bid;
	}
	public void setBid(Integer bid) {
		this.bid = bid;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	
	public String getbPrice() {
		return bPrice;
	}
	public void setbPrice(String bPrice) {
		this.bPrice = bPrice;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getStock() {
		return stock;
	}
	public void setStock(String stock) {
		this.stock = stock;
	}
	
}
