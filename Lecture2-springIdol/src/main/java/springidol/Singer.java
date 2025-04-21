package springidol;

public class Singer implements Performer {
	public String name;
	public Song song;
	public Instrument instrument;
	
	public Singer() {}
	
	public Singer(String name, Song song) {
		this.name = name;
		this.song = song;
	}
	
	public Singer(String name, Song song, Instrument instrument) {
		this.name = name;
		this.song = song;
		this.instrument = instrument;
	}

	@Override
	public void perform() throws PerformanceException {
		System.out.println(name + "is singing a song \"" + song.getTitle() + "\" by " + song.getArtist());
		
		if (instrument != null) {
			System.out.println("while playing" + instrument.getClass().getSimpleName());
			instrument.play();
		}
	}
	
}
