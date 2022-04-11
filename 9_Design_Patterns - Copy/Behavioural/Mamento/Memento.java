package demoMemento;

public class Memento {

	private String content;
	private String name;

	public Memento(String content, String name) {
		super();
		this.content = content;
		this.name = name;
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

}
