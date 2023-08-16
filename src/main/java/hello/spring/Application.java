package hello.spring;
// 위 패키지의 하위 디렉토리를 모두 검사해서 스프링 빈으로 등록해준다.

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
