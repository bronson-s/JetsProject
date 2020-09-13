package com.skilldistillery.jet;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class AirField {
	ArrayList<Jet> jets = new ArrayList<>();

	public AirField() {
		loadJets();

	}

private void loadJets() {
try {
	FileReader fr = new FileReader("Jets");
	BufferedReader br = new BufferedReader(fr);
	String line;
	while((line = br.readLine()) != null) {
		String[] splitLine = line.split(",");
		if(splitLine[0].contains("C")) {
			String model = splitLine[0];
			double speed = Double.parseDouble(splitLine[1]);
			int range = Integer.parseInt(splitLine[2]);
			Long price = Long.parseLong(splitLine[3]);
			Jet newCargoPlane = new CargoPlane(model, speed, range, price);
			jets.add(newCargoPlane);
		}
		else if(splitLine[0].contains("F")) {
			String model = splitLine[0];
			double speed = Double.parseDouble(splitLine[1]);
			int range = Integer.parseInt(splitLine[2]);
			Long price = Long.parseLong(splitLine[3]);
			Jet newFighter = new FighterJet(model, speed, range, price);
			jets.add(newFighter);
		}
		else  {
			String model = splitLine[0];
			double speed = Double.parseDouble(splitLine[1]);
			int range = Integer.parseInt(splitLine[2]);
			Long price = Long.parseLong(splitLine[3]);
			Jet normalPlane = new JetImpl(model, speed, range, price);
			jets.add(normalPlane);
		}
		
		
	}
	
}catch(Exception e) {
	
}
	
}
public void printList() {
	for (int i = 0; i < jets.size(); i++ ) {
		System.out.println(jets.get(i).toString() );
		
	}
}
public void flyJets() {
	for (int i = 0; i < jets.size(); i++ ) {
System.out.println(jets.get(i).toString()) ;
		jets.get(i).fly();
	}
}
public void showLargestRange() {
	int largest = jets.get(0).getRange();
	int highest = 0;

	for (int i = 0; i < jets.size(); i++) {
	
		if (jets.get(i).getRange() > largest) {
			largest = jets.get(i).getRange();
			highest = i;

		}
}
System.out.println("Jet with longest range: " + jets.get(highest).toString());
}
public void showBestSpeed() {
	double largest = jets.get(0).getSpeed();
	int highest = 0;
	
	for (int i = 0; i < jets.size(); i++) {
		
		if (jets.get(i).getRange() > largest) {
			largest = jets.get(i).getSpeed();
			highest = i;
			
		}
	}
	System.out.println("Jet with the best speed: " + jets.get(highest).toString());
}
public void cargoFunction() {
	for (int i = 0; i < jets.size(); i++ ) {
		if(jets.get(i) instanceof CargoCarrier) {
			System.out.println(jets.get(i).toString());
			((CargoPlane) jets.get(i)).loadCargo();
			System.out.println();
		}
	}
}
public void fighterFunction() {
	for (int i = 0; i < jets.size(); i++ ) {
		if(jets.get(i) instanceof FighterJet) {
			System.out.println(jets.get(i).toString());
			((FighterJet) jets.get(i)).fight();
			System.out.println();
		}
	}
}
public void addJet(Jet jet) {
	jets.add(0, jet);
}
public void removeJet(int num) {
	jets.remove(num);
}
}