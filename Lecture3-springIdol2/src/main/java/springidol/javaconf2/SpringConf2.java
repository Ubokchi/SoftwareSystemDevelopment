package springidol.javaconf2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springidol.Performer;
import springidol.SpringIdol;

@Configuration
public class SpringConf2 {
	@Autowired
	private SpringConf1 conf1;			// 다른 설정 클래스 SpringConf3 bean이 자동 주입됨
	
	@Bean
	public SpringIdol springIdol() {
		return null;
	}

}