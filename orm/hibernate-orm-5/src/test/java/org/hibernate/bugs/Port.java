package org.hibernate.bugs;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class Port implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private Coordinate coordinate;
	
	private Integer connection_id;
	
	/**
	 * @return the coordinate
	 */
	public Coordinate getCoordinate() {
		return coordinate;
	}
	
	/**
	 * @param coordinate the coordinate to set
	 */
	public void setCoordinate(Coordinate coordinate) {
		this.coordinate = coordinate;
	}

	/**
	 * @return the connection_id
	 */
	public Integer getConnection_id() {
		return connection_id;
	}

	/**
	 * @param connection_id the connection_id to set
	 */
	public void setConnection_id(Integer connection_id) {
		this.connection_id = connection_id;
	}

	@Override
	public String toString() {
		return "Port [coordinate=" + coordinate + ", connection_id=" + connection_id + "]";
	}

	
}
