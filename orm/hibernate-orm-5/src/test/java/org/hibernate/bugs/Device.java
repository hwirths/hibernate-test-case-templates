package org.hibernate.bugs;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Device implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private Integer device_id;
	
	@OneToOne
	@JoinColumn(name = "connection_id", referencedColumnName = "connection_id")
	private Port port;
	
	/**
	 * @return the device_id
	 */
	public Integer getDevice_id() {
		return device_id;
	}
	
	/**
	 * @param device_id the device_id to set
	 */
	public void setDevice_id(Integer device_id) {
		this.device_id = device_id;
	}
	
	/**
	 * @return the port
	 */
	public Port getPort() {
		return port;
	}
	
	/**
	 * @param port the port to set
	 */
	public void setPort(Port port) {
		this.port = port;
	}
	
	@Override
	public String toString() {
		return "Device [device_id=" + device_id + ", port=" + port + "]";
	}
	
}
