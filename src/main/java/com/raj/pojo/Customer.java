/**
 * 
 */
package com.raj.pojo;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Rajendar Kumar
 *
 */
@XmlRootElement
public class Customer {

	
	private String custNum;
	private String custName;
	private String parentNum;
	private Address address;
	/**
	 * @return the custNum
	 */
	@XmlElement
	public String getCustNum() {
		return custNum;
	}
	/**
	 * @param custNum the custNum to set
	 */
	public void setCustNum(String custNum) {
		this.custNum = custNum;
	}
	/**
	 * @return the custName
	 */
	@XmlElement
	public String getCustName() {
		return custName;
	}
	/**
	 * @param custName the custName to set
	 */
	public void setCustName(String custName) {
		this.custName = custName;
	}
	/**
	 * @return the parentNum
	 */
	@XmlElement
	public String getParentNum() {
		return parentNum;
	}
	/**
	 * @param parentNum the parentNum to set
	 */
	public void setParentNum(String parentNum) {
		this.parentNum = parentNum;
	}
	/**
	 * @return the address
	 */
	@XmlElement
	public Address getAddress() {
		return address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(Address address) {
		this.address = address;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Customer [custNum=" + custNum + ", custName=" + custName + ", parentNum=" + parentNum + ", address="
				+ address + "]";
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((custName == null) ? 0 : custName.hashCode());
		result = prime * result + ((custNum == null) ? 0 : custNum.hashCode());
		result = prime * result + ((parentNum == null) ? 0 : parentNum.hashCode());
		return result;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (custName == null) {
			if (other.custName != null)
				return false;
		} else if (!custName.equals(other.custName))
			return false;
		if (custNum == null) {
			if (other.custNum != null)
				return false;
		} else if (!custNum.equals(other.custNum))
			return false;
		if (parentNum == null) {
			if (other.parentNum != null)
				return false;
		} else if (!parentNum.equals(other.parentNum))
			return false;
		return true;
	}
	
}
