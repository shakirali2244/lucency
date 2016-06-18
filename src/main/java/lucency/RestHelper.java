package lucency;

import java.io.IOException;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;

class RestHelper{
	public String get(String url){
		// Create an instance of HttpClient.
	    HttpClient client = new HttpClient();

	    // Create a method instance.
	    GetMethod method = new GetMethod(url);
	    
	 // Execute the method.
	      int statusCode = 0;
		try {
			statusCode = client.executeMethod(method);
		} catch (HttpException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	      if (statusCode != HttpStatus.SC_OK) {
	        System.err.println("Method failed: " + method.getStatusLine());
	      }

	      // Read the response body.
	      byte[] responseBody = null;
		try {
			responseBody = method.getResponseBody();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	      // Deal with the response.
	      // Use caution: ensure correct character encoding and is not binary data
	      return new String(responseBody);
	}
}