package fuel;


public class Fuel{
	private boolean isFull;
	private int Fuel;
	private boolean isEmpty;
	private double FuelLoadingTime;
	
	
	public Fuel(int damage, int reach, double animationSpeed, Particle effects, boolean isAcquired,
			ItemTexture texture, double criticalChance) {
		super(damage, reach, animationSpeed, effects, isAcquired, texture, criticalChance);
	}


	public Fuel(boolean isFull, int Fuel, boolean isEmpty,
			double FuelLoadingTime) {
		this.isFull = isFull;
		this.Fuel = Fuel;
		this.isEmpty = isEmpty;
		this.FuelLoadingTime = FuelLoadingTime;
	}


	public boolean isFull() {
		return isFull;
	}


	public void setLoaded(boolean isFull) {
		this.isFull = isFull;
	}


	public int getFuel() {
		return Fuel;
	}


	public void setFuel(int Fuel) {
		this.Fuel = Fuel;
	}


	public boolean isEmpty() {
		return isEmpty;
	}


	public void setisEmpty(boolean isEmpty) {
		this.isEmpty = isEmpty;
	}


	public double getFuelLoadingTime() {
		return FuelLoadingTime;
	}


	public void setFuelLoadingTime(double FuelLoadingTime) {
		this.FuelLoadingTime = FuelLoadingTime;
	}


	@Override
	public String toString() {
		return "Fuel [isFull=" + isFull + ", Fuel=" + Fuel + ", isEmpty=" + isEmpty
				+ ", FuelLoadingTime=" + FuelLoadingTime + " + "]";
	}
}