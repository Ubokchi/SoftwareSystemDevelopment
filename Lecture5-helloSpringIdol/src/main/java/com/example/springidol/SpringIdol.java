package com.example.springidol;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SpringIdol implements TalentCompetition {
	@Autowired
	private Performer[] performers;

	private int stageSize;	
	
	@Autowired
	public void setStageSize(@Value("${springIdol.stage.size}") int size) {
		stageSize = size;
		System.out.println("SpringIdol#setStageSize(): 무대 크기를 " + stageSize + "으로 설정");
	}

	@Autowired
	private Piano piano;
	
	public SpringIdol() {
	}
	
	public Performer[] getPerformers() {
		return performers;
	}

	public void setPerformers(Performer[] performers) {
		this.performers = performers;
	}
	
	@PostConstruct
	public void tunePiano() {
		System.out.println("SpringIdol#tunePiano(): 피아노를 조율함");
		this.piano.tune();
	}
	
	@PreDestroy
	public void cleanPiano() {
		System.out.println("SpringIdol#cleanPiano(): 피아노를 청소함");
		this.piano.clean();
	}
	
	@Override
	public void run() {
		for (int i = 0; i < performers.length; i++) {
			System.out.print("Performance #" + (i+1));
			Performer performer = performers[i];
			System.out.println(" by " + performer.getBeanName());
			performer.perform();
			System.out.println("-----------------------");
		}
	}
}
