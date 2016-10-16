
public class UnitConverter {
	
	public static final int MILES_IN_ONE_LEAGUE = 3;
	
	public UnitConverter(){
	}
	
	public double convert(String unitConvertFrom, String unitConvertTo, double amountToConvert){
		
		double lengthInInches = convertToInches(unitConvertFrom, amountToConvert);
		double convertedLength = convertFromInches(unitConvertTo, lengthInInches);
		
		return convertedLength;
	}
	
	private double convertToInches(String unit, double amount) {

		double lengthInInches;

		switch (unit) {
		case "feet":
			lengthInInches = amount * 12;
			break;
		case "yards":
			lengthInInches = amount * 12 * 3;
			break;
		case "miles":
			lengthInInches = amount * 12 * 3 * 1760;
			break;
		case "leagues":
			lengthInInches = amount * 12 * 3 * 1760 * MILES_IN_ONE_LEAGUE;
			break;
		default:
			lengthInInches = amount;
		}

		return lengthInInches;
	}

	private double convertFromInches(String unit, double amount) {

		double convertedLength;

		switch (unit) {
		case "feet":
			convertedLength = amount / 12;
			break;
		case "yards":
			convertedLength = amount / 12 / 3;
			break;
		case "miles":
			convertedLength = amount / 12 / 3 / 1760;
			break;
		case "leagues":
			convertedLength = amount / 12 / 3 / 1760 / MILES_IN_ONE_LEAGUE;
			break;
		default:
			convertedLength = amount;
		}

		return convertedLength;
	}

}
