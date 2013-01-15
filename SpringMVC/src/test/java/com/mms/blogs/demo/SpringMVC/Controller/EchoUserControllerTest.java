package com.mms.blogs.demo.SpringMVC.Controller;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@WebAppConfiguration(value="src/main/webapp")
@ContextConfiguration(locations={"classpath:SpringMVC-context.xml"})
public class EchoUserControllerTest extends AbstractJUnit4SpringContextTests {

	@Autowired
	private WebApplicationContext webapp;
	
	private MockMvc mockMvc;
	
	@Before
	public void setup(){
		this.mockMvc = MockMvcBuilders.webAppContextSetup(webapp).build();
	}
	
	@Test
	public void testAuthenticate() throws Exception{
		this.mockMvc.perform(MockMvcRequestBuilders.post("/login/authenticate")
								.param("userid", "MMS1"))
								.andExpect(MockMvcResultMatchers.status().isOk())
								.andExpect(MockMvcResultMatchers.model().attributeExists("user"))
								.andDo(MockMvcResultHandlers.print());
	}
	
	@Test
	public void testGetUser1() throws Exception{
		
		this.mockMvc.perform(MockMvcRequestBuilders.post("/echo/getuser")).
			andExpect(MockMvcResultMatchers.jsonPath("$.userid").value("mms"));
	}
	
	@Test
	public void testGetUser2() throws Exception{
	
		ResultActions auth =this.mockMvc.perform(MockMvcRequestBuilders.post("/login/authenticate")
												.param("userid", "MMS1"));
		
		MvcResult result = auth.andReturn();
		
		MockHttpSession session = (MockHttpSession)result.getRequest().getSession();
		
		RequestBuilder echoUserReq = MockMvcRequestBuilders.post("/echo/getuser").session(session);
		
		this.mockMvc.perform(echoUserReq)
				.andDo(MockMvcResultHandlers.print()).
			andExpect(MockMvcResultMatchers.jsonPath("$.userid").value("MMS1"));
	}
	
	
	
	
	
}
