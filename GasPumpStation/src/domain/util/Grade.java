package domain.util;

public enum Grade { 
	EIGHTYSEVEN (87), 
	EIGHTYNINE (89), 
	NINETYTHREE (93);
	
	private final double quality;

	Grade(double quality) {
        this.quality = quality;
    }

	public double getQuality() {
		return quality;
	}
}
