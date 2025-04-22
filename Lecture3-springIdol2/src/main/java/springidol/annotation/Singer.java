package springidol.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component("lena")
@Order(4)
public class Singer implements Performer {
	private String name;
	private Song song;
	private Instrument instr;

	public Singer() {
	}

	@Autowired//(required=false)
	public Singer(
		@Value("Lena Park")	String name, 
		@Qualifier("someone") Song song) {
		this.name = name;
		this.song = song;
	}
		
	public Singer(String name, Song song, Instrument instr) {
		this.name = name;
		this.song = song;
		this.instr = instr;
	}
	
	public Song getSong() {
		return song;
	}

	@Override
	public void perform() throws PerformanceException {
		System.out.println(name + " is singing a song \"" + song.getTitle() 
								+ "\" by " + song.getArtist());
		if (this.instr != null) {
			System.out.print("while playing " + instr.getClass().getSimpleName() + " ");
			instr.play();
		}
	}
}