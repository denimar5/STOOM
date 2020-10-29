package com.stoom.br.base;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
public class EnderecoConttollerTest extends BaseControllerTest {
	private static final String ENDPOINT = "/api/endereco/";


	@Autowired
	@Qualifier("mockMvcIT")
	private MockMvc mockMvc;
	
	@Test
	@Ignore
    public void shouldInsertAddressSuccess() throws Exception {
        String content = "{\r\n" + 
        		"  \"endereco\": {\r\n" +         		
        		"    \"streetName\": \"rua jose dos reis\",\r\n" + 
        		"    \"number\": \"1352\",\r\n" + 
        		"    \"complement\": \"casa\",\r\n" + 
        		"    \"neighbourhood\": \"Pilares\",\r\n" + 
        		"    \"city\": \"Rio de Janeiro\",\r\n" + 
        		"    \"state\": \"RJ\",\r\n" + 
        		"    \"country\": \"BR\",\r\n" + 
        		"    \"zipcode\": \"20770061\",\r\n" + 
        		"    \"latitude\": \"-22.8842952\",\r\n" + 
        		"    \"longitude\": \"-43.290248\"\r\n" + 
        		"  }\r\n" + 
        		"}";
        mockMvc.perform(
                post(ENDPOINT)
                        .content(content)
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk());
    }

	@Test
	@Ignore
    public void shouldUpdateAddressSuccess() throws Exception {
        String content = "{\r\n" + 
        		"  \"endereco\": {\r\n" + 
        		"    \"id\": \"1\",\r\n" + 
        		"    \"streetName\": \"rua jose dos reis\",\r\n" + 
        		"    \"number\": \"1352\",\r\n" + 
        		"    \"complement\": \"casa\",\r\n" + 
        		"    \"neighbourhood\": \"Pilares\",\r\n" + 
        		"    \"city\": \"Rio de Janeiro\",\r\n" + 
        		"    \"state\": \"RJ\",\r\n" + 
        		"    \"country\": \"BR\",\r\n" + 
        		"    \"zipcode\": \"20770061\",\r\n" + 
        		"    \"latitude\": \"-22.8842952\",\r\n" + 
        		"    \"longitude\": \"-43.290248\"\r\n" + 
        		"  }\r\n" + 
        		"}";
        mockMvc.perform(
                put(ENDPOINT)
                        .content(content)
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk());
    }
	
	@Test
	@Ignore
    public void shouldReturn_BAD_REQUEST_Update_OR_Insert_Address() throws Exception {
        String content = "{\r\n" + 
        		"  \"endereco\": {\r\n" + 
        		"    \"number\": \"1352\",\r\n" + 
        		"    \"complement\": \"casa\",\r\n" + 
        		"    \"neighbourhood\": \"Pilares\",\r\n" + 
        		"    \"zipcode\": \"20770061\",\r\n" + 
        		"    \"latitude\": \"-22.8842952\",\r\n" + 
        		"    \"longitude\": \"-43.290248\"\r\n" + 
        		"  }\r\n" + 
        		"}";
        mockMvc.perform(
                put(ENDPOINT)
                        .content(content)
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isBadRequest());
    }

	@Test
	@Ignore
    public void shouldFindAll() throws Exception {
        this.mockMvc.perform(
                get(ENDPOINT))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.itens.length()", greaterThan(0)));
    }
	
	@Test
	@Ignore
    public void shouldFindById() throws Exception {
        this.mockMvc.perform(
                get(ENDPOINT+"/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.itens.length()", greaterThan(0)));
    }
	
	@Test
	@Ignore
    public void shouldDeleteById() throws Exception {
        this.mockMvc.perform(
                delete(ENDPOINT+"/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.itens.length()", greaterThan(0)));
    }
	
	@Test
	@Ignore
    public void shouldNotFindById() throws Exception {
        this.mockMvc.perform(
                get(ENDPOINT+"/0"))
                .andExpect(status().isNotFound());
                
    }
	
	
}
