package main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import lecture.LectureController;

@SpringBootApplication
@ComponentScan(basePackageClasses = LectureController.class)
public class Main {
	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}
}
