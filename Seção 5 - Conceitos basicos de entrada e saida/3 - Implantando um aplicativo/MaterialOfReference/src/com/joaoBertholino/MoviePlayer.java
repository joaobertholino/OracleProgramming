package com.joaoBertholino;

public class MoviePlayer extends Product implements MultimediaControl {
	private Screen screen;

	private MonitorType monitortype;

	public MoviePlayer(String name, Screen screen, MonitorType monitor) {
		super(name);
		this.screen = screen;
		this.monitortype = monitor;
	}

	public Screen getScreen() {
		return screen;
	}

	public MonitorType getMonitor() {
		return monitortype;
	}

	@Override
	public void play() {
		System.out.println("Playing");

	}

	@Override
	public void stop() {
		System.out.println("Stopped");

	}

	@Override
	public void previous() {
		System.out.println("Moving to previous video");
	}

	@Override
	public void next() {
		System.out.println("Moving to next video");

	}

	@Override
	public String toString() {
		return super.toString() + "Monitor       : " + monitortype + "\n" + screen;

	}

}
