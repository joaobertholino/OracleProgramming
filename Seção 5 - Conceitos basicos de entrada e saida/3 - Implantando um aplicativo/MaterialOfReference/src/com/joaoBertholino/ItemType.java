package com.joaoBertholino;

public enum ItemType {
	Audio("MM"), Visual("VI"), AudioMobile("AM"), VisualMobile("VM");

	private String code;

	private ItemType(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}

}
