package springidol.annotation;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component("hank")
@Order(3)
public class OneManBand implements Performer {
	@Autowired
	@Qualifier("forHank")
	private Map<String, Instrument> instruments; // Map 타입 property

	public OneManBand() {}

	public void setInstruments(Map<String, Instrument> instruments) {
		this.instruments = instruments;
	}

	@Override
	public void perform() throws PerformanceException {
		for (String key : instruments.keySet()) {
			System.out.print(key + ": ");
			Instrument instrument = instruments.get(key);
			instrument.play();
		}
	}
}
