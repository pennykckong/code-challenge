package service.impl;

import java.util.List;

import entity.Website;
import service.WebsiteService;

public class WebsiteServiceImpl extends BaseServiceImpl<Website> implements WebsiteService {
	
	public WebsiteServiceImpl() {
		
	}

	@Override
	public List<Website> getTopWebsiteInDate(String date, Integer noOfRecords) {
		String query = "from Website where date = to_date(?,'YYYY-MM-DD') order by visit desc";
		List<Website> websiteList = this.getByHQL(query, date);
		
		if (null != websiteList && websiteList.size()>5) {
			websiteList = websiteList.subList(0, noOfRecords);
		}
		
		return websiteList;
	}
	
	
}
