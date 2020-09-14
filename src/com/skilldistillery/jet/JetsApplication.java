package com.skilldistillery.jet;

import java.util.Scanner;

public class JetsApplication {
	AirField airF = new AirField();
	Scanner kb = new Scanner(System.in);

	public static void main(String[] args) {
		JetsApplication jetsApp = new JetsApplication();
		jetsApp.run();
	}

	private void run() {
		int choice = 0;
		while (choice != 9) {
			displaymenu();
			System.out.println("please enter the number of choice you would like to perfom");
			try {
				choice = kb.nextInt();
			} catch (Exception e) {
				System.out.println("please enter a number");
			}
			kb.nextLine();
			if (choice == 1) {
				airF.printList();
			}
			if (choice == 2) {
				airF.flyJets();
			}
			if (choice == 3) {

				airF.showBestSpeed();
			}
			if (choice == 4) {
				airF.showLargestRange();
			}
			if (choice == 5) {
				airF.cargoFunction();
			}
			if (choice == 6) {
				airF.fighterFunction();
			}
			if (choice == 7) {
				System.out.println("please enter jet model: ");
				String model = kb.nextLine();
				System.out.println("please enter jet speed: ");
				double speed = kb.nextDouble();
				System.out.println("please enter jet range: ");
				int range = kb.nextInt();
				System.out.println("please enter jet price: ");
				long price = kb.nextLong();
            Jet newJet = new JetImpl(model, speed, range, price);
			airF.addJet(newJet);
			}
			if(choice == 8) {
				System.out.println("choose the number of jet you would like to remove: ");
				int num = kb.nextInt();
				airF.removeJet(num);
			}
			
		}
	}

	private void displaymenu() {
		System.out.println("welcome to the Jets application");
		System.out.println("What would you like to do?");
		System.out.println("1. List fleet");
		System.out.println("2. Fly all jets");
		System.out.println("3. View fastest jets");
		System.out.println("4. View jet with longest range");
		System.out.println("5. Load all cargo jets");
		System.out.println("6. Fight!");
		System.out.println("7. Add a jet to the fleet");
		System.out.println("8. Remove a jet from the fleet");
		System.out.println("9. quit");
	}

}
