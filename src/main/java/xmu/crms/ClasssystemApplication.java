package xmu.crms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ClasssystemApplication {
public static void main(String[] args)
{
	SpringApplication.run(ClasssystemApplication.class, args);
}
}
