package blog.surapong.coursespringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class CoursespringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoursespringbootApplication.class, args);
	}

}
