package Serilization_Places;

public class Location {

	private double lat;
	private double lng;

	// empty constructor helps in retriving data or Dserilization
	public Location() {

	}

	public Location(double lat, double lng) {
		this.lat = lat;
		this.lng = lng;
	}

	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	public double getLng() {
		return lng;
	}

	public void setLng(double lng) {
		this.lng = lng;
	}

}
