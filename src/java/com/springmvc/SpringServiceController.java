package com.springmvc;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.List;
import javax.persistence.Entity;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

	import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RequestMethod;
	import org.springframework.web.bind.annotation.RestController;
	
	@RestController
	@RequestMapping("/service/locations/")
	public class SpringServiceController {
             ApplicationContext r = new ClassPathXmlApplicationContext("../../WEB-INF/applicationContext.xml");  
        LocationDAO dao =(LocationDAO)r.getBean("d"); 
	 
	 @RequestMapping(value = "/{id}", method = RequestMethod.GET,headers="Accept=application/json")
	 public loc getLocation(@PathVariable int id) {
	 loc loc = dao.getById(id);
	  return loc;
	 }
         
         @RequestMapping(value = "/addLoc", method = RequestMethod.POST,headers="Accept=application/json")
         public ResponseEntity<String> addLoc(@RequestBody loc l){
             
             dao.saveLocation(l);
             
             return new ResponseEntity(HttpStatus.CREATED);
         }

	 @RequestMapping(method = RequestMethod.GET,headers="Accept=application/json")
	 public List<loc> getAllLocations() {
	  List<loc> loc = dao.getLocations();
	  return loc;
	 } 
}
