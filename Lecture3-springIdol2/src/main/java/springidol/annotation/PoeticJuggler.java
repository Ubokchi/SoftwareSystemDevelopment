package springidol.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component("duke")
@Order(1)
public class PoeticJuggler extends Juggler {
	private Poem poem;

	@Autowired(required=false) 
	public PoeticJuggler(Poem poem) {
		super();
		this.poem = poem;
	}

	@Autowired(required=false)
	public PoeticJuggler(int beanBags, Poem poem) {
		super(beanBags);
		this.poem = poem;
	}

	@Override
	public void perform() throws PerformanceException {
		super.perform();
		System.out.println("While reciting...");
		poem.recite();
	}
}
