package com.pratik.BO_Domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="productdata")
public class prod {
	private int pid;
	private String pname;
	private float price;
	private int quantity;
		
	public prod() {
		super();
	}
	@Id
	@Column(name="PROD_ID")
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	@Column(name="PROD_NAME")
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	@Column(name="PROD_COST")
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	@Column(name="PROD_QUANTITY")
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "prod [pid=" + pid + ", pname=" + pname + ", price=" + price + ", quantity=" + quantity + "]";
	}
	
	

}
