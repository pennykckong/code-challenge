package service;

import java.util.Date;
import java.util.List;

import entity.Website;

public interface WebsiteService extends BaseService<Website> {
	public List<Website> getTopWebsiteInDate(String date, Integer noOfRecords);

}
