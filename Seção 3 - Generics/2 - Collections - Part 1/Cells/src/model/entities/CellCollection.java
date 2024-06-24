package model.entities;

public class CellCollection {
	private Cell[] cells;
	private int index = 0;

	public CellCollection(int size) {
		cells = new Cell[size];
	}

	public void add(Cell c) {
		cells[index] = c;
		index++;
	}

	public Cell get(int i) {
		return cells[i];
	}
}
