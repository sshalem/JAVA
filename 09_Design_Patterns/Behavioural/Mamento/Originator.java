package demoMemento;

public class Originator {

	private String content;
	private String name;

	public Originator() {
		super();
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Memento createState() {
		return new Memento(content, name);
	}

	public void undoState(Memento memento) {
		content = memento.getContent();
	}

}
