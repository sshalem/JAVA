package demoMemento;

public class MainMemento {

	public static void main(String[] args) {

		Originator originator = new Originator();
		CareTaker careTaker = new CareTaker();

		originator.setContent("shabtay");
		Memento createState = originator.createState();
		careTaker.push(createState);

		originator.setContent("karin");
		Memento createState2 = originator.createState();
		careTaker.push(createState2);

		originator.setContent("avigail");
		Memento createState3 = originator.createState();
		careTaker.push(createState3);

		Memento pop = careTaker.pop();
		Memento pop1 = careTaker.pop();
		Memento pop2 = careTaker.pop();

		System.out.println(pop.getContent());
		System.out.println(pop1.getContent());
		System.out.println(pop2.getContent());

	}

}
