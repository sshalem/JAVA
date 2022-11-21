package demo;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class App {

	public static void main(String[] args) {

		try {
			// create ObjectMapper
			ObjectMapper mapper = new ObjectMapper();

			// 1. read JSON file data/sample-lite.json
			// 2. Create new Student Instance
			// 3. map/convert to Java POJO:
			Student student = mapper.readValue(new File("data/sample-full.json"), Student.class);
			System.out.println(student);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
