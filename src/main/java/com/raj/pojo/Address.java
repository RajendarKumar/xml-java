/**
 * 
 */
package com.raj.pojo;

import javax.xml.bind.annotation.XmlElement;

/**
 * @author Rajendar Kumar
 *
 */
public class Address {

	private String pNum;
	private String cityName;
	private String cityCode;
	/**
	 * @return the pNum
	 */
	@XmlElement
	public String getpNum() {
		return pNum;
	}
	/**
	 * @param pNum the pNum to set
	 */
	public void setpNum(String pNum) {
		this.pNum = pNum;
	}
	/**
	 * @return the cityName
	 */
	@XmlElement
	public String getCityName() {
		return cityName;
	}
	/**
	 * @param cityName the cityName to set
	 */
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	/**
	 * @return the cityCode
	 */
	@XmlElement
	public String getCityCode() {
		return cityCode;
	}
	/**
	 * @param cityCode the cityCode to set
	 */
	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Address [pNum=" + pNum + ", cityName=" + cityName + ", cityCode=" + cityCode + "]";
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cityCode == null) ? 0 : cityCode.hashCode());
		result = prime * result + ((cityName == null) ? 0 : cityName.hashCode());
		result = prime * result + ((pNum == null) ? 0 : pNum.hashCode());
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
		Address other = (Address) obj;
		if (cityCode == null) {
			if (other.cityCode != null)
				return false;
		} else if (!cityCode.equals(other.cityCode))
			return false;
		if (cityName == null) {
			if (other.cityName != null)
				return false;
		} else if (!cityName.equals(other.cityName))
			return false;
		if (pNum == null) {
			if (other.pNum != null)
				return false;
		} else if (!pNum.equals(other.pNum))
			return false;
		return true;
	}
	
}
