package powerups;

public abstract class PowerUp {
	String description;
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String desc) {
		description = desc;
	}
	
	
	/**
	 * Returns multiplier of PowerUp
	 * @return multiplier of PowerUp
	 */
	public abstract int getMultiplier();
}
