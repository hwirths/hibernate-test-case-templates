package org.hibernate.bugs;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;

@Embeddable
public class Coordinate implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Integer slot_number;
	private Integer port_number;
	/**
	 * @return the slot_number
	 */
	public Integer getSlot_number() {
		return slot_number;
	}
	/**
	 * @param slot_number the slot_number to set
	 */
	public void setSlot_number(Integer slot_number) {
		this.slot_number = slot_number;
	}
	/**
	 * @return the port_number
	 */
	public Integer getPort_number() {
		return port_number;
	}
	/**
	 * @param port_number the port_number to set
	 */
	public void setPort_number(Integer port_number) {
		this.port_number = port_number;
	}
	@Override
	public String toString() {
		return "Coordinate [slot_number=" + slot_number + ", port_number=" + port_number + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(port_number, slot_number);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Coordinate)) {
			return false;
		}
		Coordinate other = (Coordinate) obj;
		return Objects.equals(port_number, other.port_number) && Objects.equals(slot_number, other.slot_number);
	}

	
	
	
}
