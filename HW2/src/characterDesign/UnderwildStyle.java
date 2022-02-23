package characterDesign;

public class UnderwildStyle implements Style{
	/**
	 * Keeps Strength Multiplier of Style
	*/
	private double strengthMult;
	/**
	 * Keeps Agility Multiplier of Style
	*/
	private double agilityMult;
	/**
	 * Keeps Health Multiplier of Style
	*/
	private double healthMult;

	
	public UnderwildStyle() {
		strengthMult = 0.8;
		agilityMult = 1.2;
		healthMult = 1.2;
	}

	@Override
	public double getStrengthMultiplier() {
		
		return strengthMult;
	}

	@Override
	public double getAgilityMultiplier() {
		// TODO Auto-generated method stub
		return agilityMult;
	}

	@Override
	public double getHealthMultiplier() {
		// TODO Auto-generated method stub
		return healthMult;
	}
}
