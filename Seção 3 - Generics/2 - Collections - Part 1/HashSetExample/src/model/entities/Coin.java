package model.entities;

public class Coin {
	private Integer denomination;

	public Coin() {
	}

	public Coin(Integer denomination) {
		this.denomination = denomination;
	}

	public Integer getDenomination() {
		return denomination;
	}

	public void setDenomination(Integer denomination) {
		this.denomination = denomination;
	}

	@Override
	public String toString() {
		return "Coin [denomination=" + denomination + "]";
	}
}
