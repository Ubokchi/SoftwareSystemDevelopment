package springidol.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//import jakarta.inject.Inject;
//import jakarta.inject.Named;
//import jakarta.annotation.Resource;

@Component("kenny")
//또는 @Named("kenny")
public class Instrumentalist implements Performer {
	
	@Value("Jingle Bells")
	private String song;
	
	@Autowired
	// @Autowired @Qualifier("guitar")
	// 또는 @Resource(name="guitar") 
	// 또는 @Inject @Named("guitar")    
	private Instrument instrument;

	public Instrumentalist() {
	}
	
	public void setSong(String song) {
		this.song = song;
	}

	public void setInstrument(Instrument instrument) {
		this.instrument = instrument;
	}

	@Override
	public void perform() throws PerformanceException {
		System.out.print("Playing " + song + " : ");
		instrument.play();
	}
}
