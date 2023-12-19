package lab5;

public abstract class Building implements Comparable<Building>{
	//class variables
	private String address;
	private double price;
	protected int squareMeters;
	
	protected static int selection = 1;
	
	public Building(String arg1, double arg2, int arg3) {
		address = arg1;
		price = arg2;
		squareMeters = arg3;
	}
	
	public abstract double maintenance();
	
	public int compareTo(Building arg) {
		if (selection == 1) {
			if (price > arg.price) {
				return 1;
			} else if (price == arg.price) {
				return 0;
			} else {
				return -1;
			}	
		}else {
			if (squareMeters > arg.squareMeters) {
				return 1;
			} else if (squareMeters == arg.squareMeters) {
				return 0;
			} else {
				return -1;
			}
		}
		
	}

	
	public String toString() {
		String s = String.format("Address: %16s, Living area: %4d, Price: %10.2f, Maintenance (per month): %7.2f"
				, address, squareMeters, price, this.maintenance());
		
		if (this instanceof CityProperty) {
			CityProperty cast = (CityProperty)this;
			s += String.format("\nProperty tax: %.1f", cast.computePropertyTax());
		}else {
			s += "\n";
		}
		s += "\n";
		
		return s;
	}
}
