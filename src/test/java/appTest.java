
import java.util.ArrayList;
import java.util.List;

import entity.Exclusion;
import entity.Website;
import junit.framework.TestCase;
import remote.RemoteService;
import service.SysUserService;
import service.WebsiteService;
import service.impl.SysUserServiceImpl;
import service.impl.WebsiteServiceImpl;

/**
 * Unit test
 */
public class appTest extends TestCase {
 
	public void testApp() {
		
		/*SysUserService sysUserService = new SysUserServiceImpl();
		sysUserService.addSysUser("test1", "test1");*/
		
		/*WebsiteService websiteService = new WebsiteServiceImpl();
		List<Website> webSiteList = new ArrayList<Website>();
		
		webSiteList = websiteService.getTopWebsiteInDate("2017-07-31", 5);
		
		for(Website site : webSiteList) {
			System.out.println(site.getWebsite());
			System.out.println(site.getVisit());			
		}*/
		
		List<Exclusion> ex = RemoteService.getJsonString();
		for(Exclusion exclusion : ex) {
			System.out.println(exclusion.getWebsite());
			System.out.println(exclusion.getFromDate());			
		}
	}
}
