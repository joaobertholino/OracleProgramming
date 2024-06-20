package application;

import java.util.HashSet;
import model.entities.Coin;

public class App {
	public static void main(String[] args) {
		HashSet<Coin> bagOfCoins = new HashSet<>();

		Coin coin1 = new Coin(1);
		Coin coin2 = new Coin(2);
		Coin coin5 = new Coin(5);
		Coin coin10 = new Coin(10);
		Coin coin20 = new Coin(20);
		Coin coin50 = new Coin(50);
		Coin coin100 = new Coin(100);

		bagOfCoins.add(coin1);
		bagOfCoins.add(coin2);
		bagOfCoins.add(coin5);
		bagOfCoins.add(coin10);
		bagOfCoins.add(coin10);
		bagOfCoins.add(coin20);
		bagOfCoins.add(coin50);

		System.out.println(bagOfCoins);

		System.out.println(bagOfCoins.contains(coin10));

		String result = (findCoin(bagOfCoins, coin10) ? "There is a coin10 in the bag!" : "There is no coin10 in the bag!");
		System.out.println(result);
	}

	public static Boolean findCoin(HashSet<Coin> bag, Coin coin) {
		for (Coin coinL : bag) {
			if (coinL.equals(coin)) {
				return true;
			}
		}
		return false;
	}
}
