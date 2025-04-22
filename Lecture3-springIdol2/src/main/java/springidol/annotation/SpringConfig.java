package springidol.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages="springidol.annotation")
public class SpringConfig {
	
	@Bean				 
	public Song love() {
		Song song = new Song();		
		song.setTitle("Love of My Life");
		song.setArtist("Queen");		
		return song;
	} 
	
	@Autowired
	@Qualifier("lena")			
	private Singer lena;		
	
	@Autowired 
	private Piano piano;	
	
	@Bean
	public Singer hynn() {
		return new Singer("Hyewon Park", lena.getSong(), piano); 
	} 
	
	@Bean
	public Singer marc(Guitar guitar) {	
		return new Singer("Marc Martel", love(), guitar);
	}
}