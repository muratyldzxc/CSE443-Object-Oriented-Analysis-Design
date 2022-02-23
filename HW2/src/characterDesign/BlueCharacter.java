package characterDesign;
import Util.Type;

public class BlueCharacter extends Character{
	CharacterFeaturesFactory charfeaturesFactory;
	
	private double strength;
	private double agility;
	private double health;
	private Style style;
	private Type type;
	
	public BlueCharacter(CharacterFeaturesFactory charfeaturesFactory) {
		this.charfeaturesFactory = charfeaturesFactory;
		this.initialize();
	}
	
	@Override
	public void initialize() {
		strength = 125.0;
		agility = 75.0;
		health = 100.0;
		style = charfeaturesFactory.createStyle();
		type = Type.BLUE;
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
