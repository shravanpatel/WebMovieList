
package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="theater")
public @Data class Theater {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="theater_id")
	private int id;
	@Column(name="theater_name")
	private String theaterName;
	
	public Theater() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Theater(int id, String theaterName) {
		super();
		this.id = id;
		this.theaterName = theaterName;
	}
	
	public Theater(String theaterName) {
		super();
		this.theaterName = theaterName;
	}
}
