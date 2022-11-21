package com.json;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class App {

	public static void main(String[] args) {
		
//		// create ObjectMapper
		ObjectMapper mapper = new ObjectMapper();
		
		/************************
		 * Convert JSON to POJO  
		 ************************/
	
		try {

			// 1. open File 'data/simple-object.json'
			// 2. Create new Student Instance
			// 3. read from FIle and apply it on new Instance of Student using the setter methods
			Student student = mapper.readValue(new File("data/nested-objects-array.json"), Student.class);
			
			//Convert object to JSON string and pretty print
			String _student = mapper
				.writerWithDefaultPrettyPrinter()
				.writeValueAsString(student);			
			
			System.out.println(_student);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		/************************
		 * Convert POJO to JSON
		 ************************/
				
		String [] languages = {"hebrew" , "english", "spanish"};
		
		Student newStudent = new Student(101, "shabtay", "shalem", true, new Address(),  languages);
		
		//Convert POJO to JSON  
		try {
			mapper.writeValue(new File("data/create-object.json"), newStudent);
		} catch (IOException e) {
			e.printStackTrace();
		}		

	}
}
