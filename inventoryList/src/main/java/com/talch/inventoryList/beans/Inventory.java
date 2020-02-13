package com.talch.inventoryList.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author Talch
 *
 */

@Table(name = "items")
@Entity
public class Inventory {

	private long id;

	private String name;

	private int amount;

	private long inventoryCode;

	public Inventory() {

	}

	public Inventory(long id, String name, int amount, long inventoryCode) {
		setId(id);
		setName(name);
		setAmount(amount);
		setInventoryCode(inventoryCode);
	}

	@Id
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name = "itemName")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "itemAmount")
	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	@Column(name = "itemInventoryCode")
	public long getInventoryCode() {
		return inventoryCode;
	}

	public void setInventoryCode(long inventoryCode) {
		this.inventoryCode = inventoryCode;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + amount;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + (int) (inventoryCode ^ (inventoryCode >>> 32));
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Inventory other = (Inventory) obj;
		if (amount != other.amount)
			return false;
		if (id != other.id)
			return false;
		if (inventoryCode != other.inventoryCode)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Inventory [id=" + id + ", name=" + name + ", amount=" + amount + ", inventoryCode=" + inventoryCode
				+ "]";
	}

}
