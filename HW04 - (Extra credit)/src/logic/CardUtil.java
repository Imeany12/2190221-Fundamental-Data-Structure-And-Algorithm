package logic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class CardUtil {

	public static boolean isExistsInList(UnitCard card, ArrayList<UnitCard> list) {

		// TODO: Fill Code
		for (UnitCard c : list) {
			if (c.equals(card)) {
				return true;
			}
		}
		return false;

	}

	public static boolean isExistsInList(UnitDeck deck, ArrayList<UnitDeck> list) {

		// TODO: Fill Code
		for (UnitDeck d : list) {
			if (d.equals(deck)) {
				return true;
			}
		}
		return false;

	}

	public static boolean cardExistsInDeckList(ArrayList<UnitDeck> deckList, UnitCard cardToTest) {

		// TODO: Fill Code
		for (UnitDeck c : deckList) {
			if (c.existsInDeck(cardToTest)) {
				return true;
			}
		}
		return false;
	}

	public static ArrayList<UnitCard> getCardsFromFile(String filename) throws FileNotFoundException {

		File fileToRead = new File(filename);
		ArrayList<UnitCard> cardsFromFile = new ArrayList<UnitCard>();

		// TODO: Fill Code
		Scanner sc;
		try {
			sc = new Scanner(fileToRead);
			ArrayList<UnitCard> tempCards = new ArrayList<UnitCard>();
			while (sc.hasNextLine()) {
				String[] parts;
				try {
				parts = sc.nextLine().split(",", 5);
				String cardName = parts[0];
				int bloodCost = Integer.parseInt(parts[1]);
				int power = Integer.parseInt(parts[2]);
				int health = Integer.parseInt(parts[3]);
				String flavorText = parts[4];
				UnitCard newCard = new UnitCard(cardName, bloodCost, power, health, flavorText);
				tempCards.add(newCard);
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("File contains string with incorrect format!");
					sc.close();
					return null;
				}
				for (UnitCard c : tempCards) {
					cardsFromFile.add(c);
				}
				
			}
			sc.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Cannot find file!");
			return null;
		}
		return cardsFromFile;
	}
	

	public static void printCardList(ArrayList<UnitCard> cardList, boolean verbose) {

		for (int i = 0; i < cardList.size(); i++) {
			System.out.println(i + ") " + cardList.get(i));
			if (verbose) {
				System.out.println("Blood Cost: " + cardList.get(i).getBloodCost());
				System.out.println(cardList.get(i).getFlavorText());
				if (i < cardList.size() - 1)
					System.out.println("-----");
			}
		}
	}

	public static void printDeck(UnitDeck ud) {

		if (ud.getCardsInDeck().size() == 0) {
			System.out.println("EMPTY DECK");
		} else {
			for (CardCounter cc : ud.getCardsInDeck()) {
				System.out.println(cc);
			}
		}

		System.out.println("Total Cards: " + ud.cardCount());
	}

	public static void printDeckList(ArrayList<UnitDeck> deckList) {

		for (int i = 0; i < deckList.size(); i++) {
			System.out.println(i + ") " + deckList.get(i).getDeckName());
			printDeck(deckList.get(i));
			if (i < deckList.size() - 1)
				System.out.println("-----");
		}
	}
}
