package springidol.annotation;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("forHank")
public class Harmonica implements Instrument {
	public Harmonica() {
	}

	public void play() {
		System.out.println("HUM HUM HUM~~");
	}
}
