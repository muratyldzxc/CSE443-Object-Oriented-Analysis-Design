package characterDesign;

public class AtlantisCharacterFeaturesFactory implements CharacterFeaturesFactory{

	@Override
	public Style createStyle() {
		return new AtlantisStyle();
	}
}
