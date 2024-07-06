package com.joaoBertholino;

public class TestAudioPlayer {

	public static void main(String[] args) {
		AudioPlayer a1 = new AudioPlayer("SilverFox1", "Latest audio player");
		AudioPlayer a2 = new AudioPlayer("SilverFox1", "Latest audio player");
		a1.play();
		a1.stop();
		System.out.println(a1);
		System.out.println(a2);
	}

}
