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
@Table(name = "EXCLUSION")
public class Exclusion implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6170550053598303679L;
	private Long id;
	private String website;
	private Date fromDate;
	private Date toDate;
	
	public Exclusion() {
		
	}
	
	public Exclusion(String website, Date fromDate, Date toDate) {
		this.website = website;
		this.fromDate = fromDate;
		this.toDate = toDate;
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
	
	@Column (name = "WEBSITE", nullable = false)
	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}
	
	@Column (name = "FROMDATE", nullable = false)
	public Date getFromDate() {
		return fromDate;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	@Column (name = "TODATE", nullable = false)
	public Date getToDate() {
		return toDate;
	}

	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}
	
	
	
}
