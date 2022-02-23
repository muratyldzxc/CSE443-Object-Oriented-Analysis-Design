package characterDesign;

public class ValhallaCharacterFeaturesFactory implements CharacterFeaturesFactory{

	@Override
	public Style createStyle() {
		return new ValhallaStyle();
	}
}
