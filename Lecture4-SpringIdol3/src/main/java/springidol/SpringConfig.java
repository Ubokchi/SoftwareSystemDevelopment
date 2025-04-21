package springidol;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@ComponentScan
@PropertySource({"classpath:app.properties"})
public class SpringConfig {	
	// @Autowired private Environment env;	    

	// bean-scan으로 생성된 bean들을 주입
	@Autowired private Guitar guitar;
	@Autowired private Cymbal cymbal;
	@Autowired private Harmonica harmonica;

	@Bean(name="kenny")					 
	public Instrumentalist instr(Saxophone saxophone) {		// auto-wiring
		Instrumentalist instr = new Instrumentalist();
		instr.setSong("Jingle Bells");			// 외부 설정 property 이용
		instr.setInstrument(saxophone);		
		return instr;
	} 
	
	@Bean
	public PoeticJuggler duke(Poem sonnet29) {		// auto-wiring
		return new PoeticJuggler(sonnet29);
	}
	
	@Bean		
	public OneManBand hank() {
		Map<String, Instrument> instr = new HashMap<String, Instrument>(); 
		instr.put("GUITAR", guitar);
		instr.put("CYMBAL", cymbal);
		instr.put("HARMONICA", harmonica);
		OneManBand omb = new OneManBand();		
		omb.setInstruments(instr);
		return omb;
	}		
	
	@Bean
	public Song someone() {
		Song song = new Song();
		song.setTitle("Someone Like You");	  
		song.setArtist("Adele");			 			
		return song;
	}
		
	private String lena_name = "Lena Park";		// 외부 설정 property 이용
		
	@Bean
	public Singer lena() {		
		return new Singer(lena_name, someone());
	}

	@Bean
	public SpringIdol springIdol(Performer[] perf) {  // 모든 Performer bean들을 자동 주입(auto-wiring)
		SpringIdol si = new SpringIdol();
		si.setPerformers(perf);
		return si;		
	}		
}