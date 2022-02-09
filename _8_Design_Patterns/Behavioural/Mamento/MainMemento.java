package demoMemento;

public class MainMemento {

	public static void main(String[] args) {

		Originator originator = new Originator();
		CareTaker careTaker = new CareTaker();

		originator.setContent("shabtay");
		originator.setName("shalem");
		Memento createState = originator.createState();
		careTaker.push(createState);

		originator.setContent("karin");
		originator.setName("shalem");
		Memento createState2 = originator.createState();
		careTaker.push(createState2);

		originator.setContent("avigail");
		originator.setName("shalem");
		Memento createState3 = originator.createState();
		careTaker.push(createState3);

		originator.undoState(careTaker.pop());
		System.out.println(originator.getContent() + " " + originator.getName());
		
		originator.undoState(careTaker.pop());
		System.out.println(originator.getContent() + " " + originator.getName());
		
		originator.undoState(careTaker.pop());
		System.out.println(originator.getContent() + " " + originator.getName());

	}

}
