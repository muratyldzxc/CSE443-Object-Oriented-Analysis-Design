package characterDesign;

import Util.Type;

public abstract class Character {
	/**
	 * Style of the Character (Atlantis, Valhalla etc)
	 */
	Style style;
	
	/**
	 * Color of the Enemy (red, blue etc)
	 */
	Type color;
	
	/**
	 * Strength of the Enemy to damage
	 */
	double strength;
	
	/**
	 * Agility of the Enemy to defense
	 */
	double agility;
	
	/**
	 * Health of Enemy
	 */
	double health;
	
	/**
	 * Initialize Enemy's style, strength, agility, health
	 */
	public abstract void initialize();
	
	/**
	 * Returns Character Multiplied Strength
	 */
	public abstract double getStrength();
	/**
	 * Returns Character Multiplied Agility
	 */
	public abstract double getAgility();
	/**
	 * Returns Character Multiplied Health
	 */
	public abstract double getHealth();
}
