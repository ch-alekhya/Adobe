package com.adobe;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import com.adobe.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.*;

@RestController
public class ApplicationController {

	@Autowired
	private IntegerToRoman intRoman;
	   private static final Logger logger = LoggerFactory.getLogger(ApplicationController.class);
	   

	@RequestMapping("/")

	public String index() {
		return "Welcome to the Application that converts Integer to Roman";
	}

	
	@RequestMapping(value ="/romannumeral",params={"query"},method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> givenInteger(@RequestParam String query)
	{
		try {

			int value = Integer.parseInt(query);
			logger.info("Given input query :" + value);

			if (value < 0 || value > 3999)
				return ResponseEntity.status(HttpStatus.BAD_REQUEST)
						.body("Only Integers within range 1-3999 inclusive accepted");
			String result = intRoman.intToRoman(value);
			Map<String, Object> entity = new HashMap<>();
			entity.put("input", query);
			entity.put("output", result);
			logger.info("Output from Component : Roman value " + result);
			return ResponseEntity.status(HttpStatus.OK).body(entity.toString());
		} catch (NumberFormatException e) {
			logger.error("The given input " + query +" is not a number");

			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body("Given input is not integer, Please provide integer value");

		}
		
	}
	
	
	
	@RequestMapping(value = "/romannumeral", method = RequestMethod.GET) //,produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<?> givenIntegerRange(@RequestParam(value="min") String min, @RequestParam(value="max") String max) 
			throws JSONException {
		try { 
			//String min = customQuery.get("min");
			//String max = customQuery.get("max");
			int minvalue = Integer.parseInt(min);
			int maxvalue = Integer.parseInt(max);

			if (minvalue > maxvalue)
				return ResponseEntity.status(HttpStatus.BAD_REQUEST)
						.body("Minvalue must be greater than max value. Plese retry again");

			if ((minvalue < 0 || minvalue > 3999) || (maxvalue < 0 || maxvalue > 3999))
				return ResponseEntity.status(HttpStatus.BAD_REQUEST)
						.body("Only Integers within range 1-3999 inclusive accepted");
			List<JSONObject> entities = new ArrayList<JSONObject>();
			JSONObject results = new JSONObject();
			for (int i = minvalue; i <= maxvalue; i++) {
				String result = intRoman.intToRoman(i);
				JSONObject entity = new JSONObject();
				entity.put("input", i);
				entity.put("output", result);
				entities.add(entity);
			}
			results.put("conversions", entities);
			return ResponseEntity.status(HttpStatus.OK).body(results.toString());

		} catch (NumberFormatException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body("Given input is not integer, Please provide integer value");
		}
	}

}