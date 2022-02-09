package demoMemento;

public class Originator {

	private String content;

	public Originator() {
		super();
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Memento createState() {
		return new Memento(content);
	}

	public void undoState(Memento memento) {
		content = memento.getContent();
	}

}
