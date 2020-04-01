package restClient;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class RestClient {
	public CloseableHttpResponse post(String url,String entityString,HashMap<String,String>headerMap) throws Exception, IOException
	{
		CloseableHttpClient httpClient =HttpClients.createDefault();
HttpPost httppost=new HttpPost(url);
httppost.getURI();
System.out.println("URI"+httppost.getURI());
httppost.setEntity(new StringEntity(entityString));
for(Map.Entry<String, String>entry:headerMap.entrySet())
{
	httppost.addHeader(entry.getKey(),entry.getValue());
}

CloseableHttpResponse closeableHttpResponse =httpClient.execute(httppost);

return closeableHttpResponse;


	}

}
