package springidol.javaconf3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springidol.Instrumentalist;
import springidol.OneManBand;
import springidol.Performer;
import springidol.PoeticJuggler;
import springidol.SpringIdol;

@Configuration
public class SpringConf4 {
	@Autowired
	private PoeticJuggler duke;			// PoeticJuggler 타입 객체가 자동 주입됨
	@Autowired
	private Instrumentalist instr;		// Instrumentalist 타입 객체가 자동 주입됨
	@Autowired
	private OneManBand hank;			// OneManBand 타입 객체가 자동 주입됨
	
	@Bean
	public SpringIdol springIdol() {
		return null;
	}
	
}