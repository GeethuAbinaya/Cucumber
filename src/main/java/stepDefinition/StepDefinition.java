package stepDefinition;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
//import org.testng.Assert;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonAppend.Prop;

import restClient.RestClient;
import com.qa.data.Cost;
import com.qa.data.Users;

import base.TestBase;
import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.runtime.junit.Assertions;


public class StepDefinition {
	
	
	@Given("^First im getting service URL$")
	public String first_im_getting_service_URI(String URL,String Service_Url) throws Throwable 
	{
	   TestBase tb = new TestBase();
	   String a=tb.prop.getProperty(URL);
	   String b= tb.prop.getProperty(Service_Url);
	   String c= a+b;
	   tb.prop.setProperty("URI", c);
	   return c;
	  
	}

	@Then("^I am getting headers to be added$")
	public HashMap<String, String> check_more_outcomes(String Header1,String Header2) throws Throwable {
		TestBase tb = new TestBase();
		 HashMap<String,String>headerMap =new  HashMap<String,String>();
		 headerMap.put(Header1, tb.prop.getProperty(Header1));
		 headerMap.put(Header2, tb.prop.getProperty(Header2));	
		
		return headerMap;	    
	}

	@Then("^I want to send \"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"ab(\\d+)\\*&(\\d+)$")
	public String i_want_to_send_ab(String name, String industry, String level, String description, int duration, int value) throws Throwable {
			
		Cost c= new Cost(level,value);
		List<Object> bal= new ArrayList<Object>();	
		bal.add(c);
		Users u = new Users(industry,name,description,duration,bal);
		//jackson api -convert java to json (marshling)
		ObjectMapper mapper= new ObjectMapper();
				
				//java object to json conversion
				
			mapper.writeValue(new File("C://Users//ELCOT//Desktop//Automation//POST_cucumber//src//main//java//com//qa//data//user.json"), u);
			
			//java Object to json in String
			String userstring = mapper.writeValueAsString(u);
			System.out.println(userstring);				
	  return userstring;
	}
	

	@Then("^I am posting an api with end point URI \"([^\"]*)\",\"([^\"]*)\",header\"([^\"]*)\",\"([^\"]*)\",payload \"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"ab(\\d+)\\*&(\\d+)$")
	public void i_am_posting_an_api_with_end_point_URI_header_payload_ab(String URL, String Service_Url, String Header1, String Header2, String name, String industry, String level, String description, int duration, int value,int Expected_statusCode) throws Throwable {
		TestBase tb =new TestBase();
		restClient.RestClient restclient = new restClient.RestClient();
		String url=first_im_getting_service_URI( URL, Service_Url);
		HashMap<String, String> headerMap=check_more_outcomes(Header1,Header2);
		String US=i_want_to_send_ab(name,industry,level,description,duration,value);
		CloseableHttpResponse closeableHttpResponse = restclient.post(url, US, headerMap);
		Cost c= new Cost(level,value);
		List<Object> bal= new ArrayList<Object>();	
		bal.add(c);
		Users u = new Users(industry,name,description,duration,bal);
		
		//return closeableHttpResponse;
		
		int statuscode=closeableHttpResponse.getStatusLine().getStatusCode();
		org.junit.Assert.assertEquals(Expected_statusCode, statuscode);
		
		
		//2.jsonString
		String responseString =EntityUtils.toString(closeableHttpResponse.getEntity(),"UTF-8");
		JSONObject responsejson = new JSONObject(responseString);
		System.out.println("Response JSON from API ---"+responsejson);
		ObjectMapper mapper= new ObjectMapper();
	
		
	mapper.writeValue(new File("C://Users//ELCOT//Desktop//Automation//POST_cucumber//src//main//java//com//qa//data//user.json"), u);
		
		Users userobj =mapper.readValue(responseString, Users.class);//actual user object
		System.out.println(userobj);
		
		org.junit.Assert.assertTrue(u.getName().equals(userobj.getName()));
		org.junit.Assert.assertTrue(u.getDesc().equals(userobj.getDesc()));		
		org.junit.Assert.assertTrue(u.getIndustry().equals(userobj.getIndustry()));
		org.junit.Assert.assertTrue(u.getCost().equals(userobj.getCost()));
		org.junit.Assert.assertTrue(u.getDuration()==(userobj.getDuration()));
			  
	}

}