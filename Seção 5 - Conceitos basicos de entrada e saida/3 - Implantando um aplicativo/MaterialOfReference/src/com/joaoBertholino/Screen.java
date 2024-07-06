package com.joaoBertholino;

public class Screen implements ScreenSpec {
	private String resolution;
	private int refreshrate;
	private int responsetime;

	public Screen(String resolution, int refresh, int response) {
		this.resolution = resolution;
		this.refreshrate = refresh;
		this.responsetime = response;
	}

	@Override
	public String getResolution() {
		return resolution;
	}

	@Override
	public int getRefreshRate() {
		return refreshrate;
	}

	@Override
	public int getResponseTime() {
		return responsetime;
	}

	@Override
	public String toString() {
		return "Resolution    : " + resolution + "\n" + "Refresh       : " + refreshrate + "\n" + "Response      : "
				+ responsetime + "\n";
	}

}
