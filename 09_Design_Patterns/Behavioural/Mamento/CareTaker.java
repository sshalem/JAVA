package demoMemento;

import java.util.ArrayList;
import java.util.List;

public class CareTaker {

	private List<Memento> states = new ArrayList<>();

	public void push(Memento memento) {
		this.states.add(memento);
	}

	public Memento pop() {
		int lastIndex = this.states.size() - 1;
		Memento popLastState = this.states.get(lastIndex);
		this.states.remove(popLastState);
		return popLastState;
	}
}
