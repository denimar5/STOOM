package com.stoom.br.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(url = "${google.url}", name = "googleClient")
public interface GoogleClient {

	@GetMapping(path = "/json")
	Results getGeoLocalization(@RequestParam(name = "address") String address);
			
}
