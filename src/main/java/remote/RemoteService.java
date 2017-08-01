package remote;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.JSONArray;
import org.json.JSONObject;

import entity.Exclusion;

public class RemoteService {
	
	public static List<Exclusion> getJsonString(){
		List<Exclusion> exclusions = new ArrayList<Exclusion>();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		
		try {
			HttpClient client = HttpClientBuilder.create().build();
		    HttpGet request = new HttpGet("http://private-1de182-mamtrialrankingadjustments4.apiary-mock.com/exclusions");
		    
		    request.addHeader("accept","application/json");
		    
		    HttpResponse response = client.execute(request);
		    String json = IOUtils.toString(response.getEntity().getContent());
		    JSONArray array = new JSONArray(json);
		    for (int i = 0; i < array.length(); i++) {
		    	JSONObject object = array.getJSONObject(i);
		    	Exclusion exclusion = new Exclusion();
		    	exclusion.setWebsite(object.getString("host"));
		    	exclusion.setFromDate(formatter.parse(object.getString("excludedSince")));
		    	if(object.has("excludedTill")) {
		    		exclusion.setToDate(formatter.parse(object.getString("excludedTill")));
		    	}
		    	
		    	exclusions.add(exclusion);
		    }
		}catch(Exception e) {
			e.printStackTrace();			
		}
		return exclusions;
	}
    
}    