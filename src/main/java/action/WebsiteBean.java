package action;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import entity.Website;
import service.WebsiteService;
import service.impl.WebsiteServiceImpl;

@ManagedBean(name="websiteBean")
@SessionScoped
public class WebsiteBean {
		
	private WebsiteService websiteService;
	
	private List<Website> webSiteList;
	private String searchDate;
	
	private static int NO_OF_DAYS = 5;
	
	public WebsiteBean() {
		websiteService = new WebsiteServiceImpl();
		webSiteList = new ArrayList<Website>();
	}
	
	public void listTopFiveWebSiteInSelectedDate() {
		
		webSiteList = websiteService.getTopWebsiteInDate(searchDate, NO_OF_DAYS);
	}

	public List<Website> getWebSiteList() {
		return webSiteList;
	}

	public void setWebSiteList(List<Website> webSiteList) {
		this.webSiteList = webSiteList;
	}

	public String getSearchDate() {
		return searchDate;
	}

	public void setSearchDate(String searchDate) {
		this.searchDate = searchDate;
	}
	
	
}
