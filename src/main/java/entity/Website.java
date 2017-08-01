package entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "WEBSITE")
public class Website implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5237070096575874968L;
	
	private Long id;
	private Date date;
	private String website;
	private Long visit;
	
	public Website() {
		
	}
	
	public Website(Date date, String website, Long visit) {
		this.date = date;
		this.website = website;
		this.visit = visit;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name = "ID", unique = true, nullable = false)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	@Column (name = "DATE", nullable = false)
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	@Column (name = "WEBSITE", nullable = false)
	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	@Column (name = "VISIT", nullable = false)
	public Long getVisit() {
		return visit;
	}

	public void setVisit(Long visit) {
		this.visit = visit;
	}
	
	
	
}
