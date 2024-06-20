package model.entities;

public class Cell {
	private String data;

	public String getData() {
		return data;
	}

	public void setValue(String data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "Cell [data=" + data + "]";
	}
}
