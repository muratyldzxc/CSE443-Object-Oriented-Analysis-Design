package characterDesign;

import Util.Type;

public class RedCharacter extends Character{
	CharacterFeaturesFactory charfeaturesFactory;
	
	private double strength = 100.0;
	private double agility = 125.0;
	private double health = 75.0;
	private Style style;
	private Type type;
	
	public RedCharacter(CharacterFeaturesFactory charfeaturesFactory) {
		this.charfeaturesFactory = charfeaturesFactory;
		this.initialize();
	}
	
	@Override
	public void initialize() {
		strength = 125.0;
		agility = 75.0;
		health = 100.0;
		style = charfeaturesFactory.createStyle();
		type = Type.GREEN;
	}

	@Override
	public double getStrength() {
		// TODO Auto-generated method stub
		return strength * style.getStrengthMultiplier();
	}

	@Override
	public double getAgility() {
		// TODO Auto-generated method stub
		return agility * style.getAgilityMultiplier();
	}

	@Override
	public double getHealth() {
		// TODO Auto-generated method stub
		return health * style.getHealthMultiplier();
	}
}
