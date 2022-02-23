package characterDesign;

public class UnderwildCharacterFeaturesFactory implements CharacterFeaturesFactory{

	@Override
	public Style createStyle() {
		return new UnderwildStyle();
	}
	
}
