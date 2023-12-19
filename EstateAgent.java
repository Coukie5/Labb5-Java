package lab5;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JOptionPane;

public class EstateAgent {
	public static final int ALLBUILDINGS = 1;
	public static final int CITYBUILDINGS = 2;
	public static final int COTTAGES = 3;
	
	public final String NAME;
	private ArrayList<Building> theBuildings = new ArrayList<Building>();
	private ArrayList<CityProperty> theCityBuildings = new ArrayList<CityProperty>();
	private ArrayList<Cottage> theCottages = new ArrayList<Cottage>();
	
	public EstateAgent(String arg) {
		NAME = arg;
	}
	
	public String addBuilding(Building arg) {
		theBuildings.add(arg);
		if (arg instanceof CityProperty) {
			theCityBuildings.add((CityProperty)arg);
			return "Added City building";
		} else if (arg instanceof Cottage) {
			theCottages.add((Cottage)arg);
			return "Added Cottage";
		}
		return "Wrong";
	}
	
	public String sort(int arg) {
		String input = JOptionPane.showInputDialog("Sorting by price (1) or area (2)?");
		if (input.compareTo("1") == 0 || input.compareTo("2") == 0) {
			Building.selection = Integer.parseInt(input);
		}
		if (arg == ALLBUILDINGS) {
			Collections.sort(theBuildings);
			updateLists();
		} 
		else if (arg == COTTAGES) {
			Collections.sort(theCottages);
			updateLists(COTTAGES);
			}
		else if (arg == CITYBUILDINGS) {
			ArrayList<Building> temp = new ArrayList<Building>();
			for (CityProperty c : theCityBuildings) {
				temp.add((Building)c);
			}
			Collections.sort(temp);
			for (int i = 0; i < temp.size(); i++) {
				theCityBuildings.set(i, (CityProperty)temp.get(i));
			}
			updateLists(CITYBUILDINGS);
		}
		if (Integer.parseInt(input) == 1) {
			return "Sorted by price";
		} 
		else if (Integer.parseInt(input) == 2) {
			return "Sorted by area";
		}
		else {
			return "Not sorted";
		}
	}
	
	public void updateLists() {
		theCityBuildings.clear();
		theCottages.clear();
		for (int i = 0; i < theBuildings.size(); i++) {
			if (theBuildings.get(i) instanceof CityProperty) {
				theCityBuildings.add((CityProperty)theBuildings.get(i));
				
			}else if (theBuildings.get(i) instanceof Cottage) {
				theCottages.add((Cottage)theBuildings.get(i));
			}
		}
	}
	
	public void updateLists(int arg) {
		int CityCounter = 0;
		int CottageCounter = 0;
		for (int i = 0; i < theBuildings.size(); i++) {
			if (theBuildings.get(i) instanceof CityProperty) {
				theBuildings.set(i, (Building)theCityBuildings.get(CityCounter));
				CityCounter++;
			}else if (theBuildings.get(i) instanceof Cottage) {
				theBuildings.set(i, theCottages.get(CottageCounter));
				CottageCounter++;
			}
		}
	}
	
	public String toString() {
		String s = "Estate agent: " + NAME + "\n";
		s += "All buildings \n";
		for (Building b : theBuildings) {
			s += b.toString();
		}
		s += "Cottages \n";
		for (Cottage c : theCottages) {
			s += c.toString();
		}
		s += "Villas and apartments \n";
		for (CityProperty p : theCityBuildings) {
			s += p.toString();
		}
		
		return s;
	}
	
	
}
