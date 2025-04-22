package springidol.annotation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Piano implements Instrument {
	 @Value("PLINK PLINK PLINK~~!!")
	 private String sound;
	 
	 public Piano() {}
	 
	 public void play() {
		 System.out.println(sound);
	 }
}
