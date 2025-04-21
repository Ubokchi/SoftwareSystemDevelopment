package springidol;

import java.util.Map;

public class OneManBand implements Performer {
	private Map<String, Instrument> instruments;

	public OneManBand() {
	}

	public void setInstruments (Map<String, Instrument> instruments) {
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
