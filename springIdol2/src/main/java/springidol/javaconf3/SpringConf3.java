package springidol.javaconf3;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springidol.Instrument;
import springidol.Instrumentalist;
import springidol.OneManBand;
import springidol.Piano;
import springidol.Poem;
import springidol.PoeticJuggler;
import springidol.Saxophone;
import springidol.Sonnet29;

@Configuration
public class SpringConf3 {
	
	@Bean
	public Saxophone saxophone() {	  	// method 이름을 bean의 ID로 사용 ("saxophone") 
		return new Saxophone();			// Saxophone type bean 생성  
	}
	
	@Bean
	public Piano piano() {	    
		return new Piano();		
	}
		
	@Bean
	public Poem sonnet29() {
		return new Sonnet29();
	}
	
	@Bean
	public PoeticJuggler juggler() {
		return new PoeticJuggler(5, sonnet29());
	}
	
	@Bean(name="kenny")				// name 속성을 통해 bean ID 지정 가능 
	public Instrumentalist instr() {
		return null;
	} 
	
	@Bean		
	public OneManBand hank() {
		Map<String, Instrument> instrMap = new HashMap<String, Instrument>();
		instrMap.put("SAXOPHONE", saxophone());
		instrMap.put("PIANO", piano());
		OneManBand omb = new OneManBand();		
		omb.setInstruments(instrMap);
		return omb;
	}	
}