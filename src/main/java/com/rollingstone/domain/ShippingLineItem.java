package com.rollingstone.domain;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class ShippingLineItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne
	@JoinColumn(name="PRODUCT_ID")
	private Product product;
	
	@Column(name="quantity_shipped", nullable=false)
	String quantity;
	
	@Column(name="unit_price", nullable=false)
	Double unitPrice;
	
	@Column(name="uom", nullable=false)
	String unitOfMeasurement;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SHIPPING_ID", nullable = false)
	@JsonIgnore
	Shipping shippment;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public Double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public String getUnitOfMeasurement() {
		return unitOfMeasurement;
	}

	public void setUnitOfMeasurement(String unitOfMeasurement) {
		this.unitOfMeasurement = unitOfMeasurement;
	}

	public Shipping getShippment() {
		return shippment;
	}

	public void setShippment(Shipping shippment) {
		this.shippment = shippment;
	}

	public ShippingLineItem(Long id, Product product, String quantity, Double unitPrice, String unitOfMeasurement,
			Shipping shippment) {
		super();
		this.id = id;
		this.product = product;
		this.quantity = quantity;
		this.unitPrice = unitPrice;
		this.unitOfMeasurement = unitOfMeasurement;
		this.shippment = shippment;
	}

	public ShippingLineItem() {
		super();
	}

	@Override
	public String toString() {
		return "ShippingLineItem [id=" + id + ", product=" + product + ", quantity=" + quantity + ", unitPrice="
				+ unitPrice + ", unitOfMeasurement=" + unitOfMeasurement + ", shippment=" + shippment + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((product == null) ? 0 : product.hashCode());
		result = prime * result + ((quantity == null) ? 0 : quantity.hashCode());
		result = prime * result + ((shippment == null) ? 0 : shippment.hashCode());
		result = prime * result + ((unitOfMeasurement == null) ? 0 : unitOfMeasurement.hashCode());
		result = prime * result + ((unitPrice == null) ? 0 : unitPrice.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ShippingLineItem other = (ShippingLineItem) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (product == null) {
			if (other.product != null)
				return false;
		} else if (!product.equals(other.product))
			return false;
		if (quantity == null) {
			if (other.quantity != null)
				return false;
		} else if (!quantity.equals(other.quantity))
			return false;
		if (shippment == null) {
			if (other.shippment != null)
				return false;
		} else if (!shippment.equals(other.shippment))
			return false;
		if (unitOfMeasurement == null) {
			if (other.unitOfMeasurement != null)
				return false;
		} else if (!unitOfMeasurement.equals(other.unitOfMeasurement))
			return false;
		if (unitPrice == null) {
			if (other.unitPrice != null)
				return false;
		} else if (!unitPrice.equals(other.unitPrice))
			return false;
		return true;
	}
	
	
}
