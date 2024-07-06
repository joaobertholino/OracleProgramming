package com.joaoBertholino;

public class TestMoviePlayer {

	public static void main(String[] args) {
		MoviePlayer m1 = new MoviePlayer("SilverFoxTV1", new Screen("600x400", 40, 22), MonitorType.LED);
		MoviePlayer m2 = new MoviePlayer("SilverFoxTV1", new Screen("600x400", 40, 22), MonitorType.LED);
		System.out.println(m1);
		System.out.println(m2);
	}
}
