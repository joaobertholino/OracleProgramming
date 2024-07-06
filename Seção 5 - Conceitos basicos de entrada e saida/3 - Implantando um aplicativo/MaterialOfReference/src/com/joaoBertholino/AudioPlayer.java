package com.joaoBertholino;

public class AudioPlayer extends Product implements Item, MultimediaControl {
	private String audioSpecification;
	private ItemType mediaType;

	public AudioPlayer(String name, String audioSpecification) {
		super(name);
		this.audioSpecification = audioSpecification;
		mediaType = ItemType.AudioMobile;
	}

	public String getAudioSpecification() {
		return audioSpecification;
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
		System.out.println("Moving to previous track");

	}

	@Override
	public void next() {
		System.out.println("Moving to next track");

	}

	@Override
	public String toString() {
		return super.toString() + "Audio Spec    : " + audioSpecification + "\n" + "Type          : " + mediaType + "\n";

	}

}
