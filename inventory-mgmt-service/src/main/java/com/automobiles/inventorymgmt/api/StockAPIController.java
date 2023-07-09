package com.automobiles.inventorymgmt.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.automobiles.inventorymgmt.dto.StockDto;
import com.automobiles.inventorymgmt.service.ManageStockService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/stock")
public class StockAPIController {

	@Autowired
	ManageStockService service;
	
	@GetMapping(value = "/{stockName}/available",produces = {MediaType.APPLICATION_JSON_VALUE})
	public List<StockDto> getStocks(@PathVariable("stockName") String stockName){
		return service.getStocks(stockName);
	}
	
	@GetMapping(value = "/transport", produces = MediaType.APPLICATION_JSON_VALUE)
	public String getTransportInfo() throws JsonProcessingException {
		Map<String, Object> dataMap = null;
		ObjectMapper objectMapper = null;
		String jsonResponse = null;
		dataMap = new HashMap<String,Object>();
		dataMap.put("transportType", service.getTransportType());
		dataMap.put("slaDays", service.getSlaDays());
		objectMapper = new ObjectMapper();
		jsonResponse = objectMapper.writeValueAsString(dataMap);
		return  jsonResponse;
	}
}
