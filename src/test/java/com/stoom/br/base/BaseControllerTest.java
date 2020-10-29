package com.stoom.br.base;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

public class BaseControllerTest {
private static final MediaType APPLICATION_JSON = MediaType.APPLICATION_JSON;

public Type getParametrizedType() {

final ParameterizedType type = (ParameterizedType) getClass().getGenericSuperclass();

return type.getActualTypeArguments()[0];
}

public MockHttpServletRequestBuilder post(final String endpoint) {
return MockMvcRequestBuilders.post(endpoint).headers(getHeaders()).accept(APPLICATION_JSON);

  }

public MockHttpServletRequestBuilder get(final String endpoint) {
return MockMvcRequestBuilders.get(endpoint).headers(getHeaders()).accept(APPLICATION_JSON);
}

public MockHttpServletRequestBuilder delete(final String endpoint) {
return MockMvcRequestBuilders.delete(endpoint).headers(getHeaders()).accept(APPLICATION_JSON);
}

public MockHttpServletRequestBuilder put(final String endpoint) {
return MockMvcRequestBuilders.put(endpoint).headers(getHeaders()).accept(APPLICATION_JSON);
}


private HttpHeaders getHeaders() {
HttpHeaders headers = new HttpHeaders();
headers.add("Content-Type", APPLICATION_JSON.toString());
headers.add("Origin", "*");
headers.add("User-agent", "test");
return headers;
}
}