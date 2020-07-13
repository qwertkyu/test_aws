/**
 * 
 */
/**
 * @author kmhwang
 *
 */
package com.example.webservice.web;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class WebRestController {
	@GetMapping("/hello")
	public String hello() {
		return "HelloWorld";
	}
}