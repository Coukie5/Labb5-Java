package lab5;

public class Villa extends Building implements CityProperty{
	private double electricity;
	private double heating;
	private int bedrooms;
	
	public Villa(String arg1, double arg2, int arg3, double arg4, double arg5, int arg6) {
		super(arg1, arg2, arg3);
		electricity = arg4;
		heating = arg5;
		bedrooms = arg6;
	}
	
	public int getBedrooms() {
		return bedrooms;
	}
	
	public double computePropertyTax() {
		return (20 * squareMeters + 100 * bedrooms);
	}
	
	public double maintenance() {
		return (electricity + heating);
	}
}
