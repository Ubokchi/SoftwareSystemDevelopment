package springidol.javaconf4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import springidol.Instrumentalist;
import springidol.OneManBand;
import springidol.Performer;
import springidol.PoeticJuggler;
import springidol.SpringIdol;

@Configuration
// @Import(SpringConfSub.class)			// SpringConfSub 클래스에 설정된 bean들을 import
public class SpringConfMain {
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