package characterDesign;

import Util.Type;

public class UnderwildCharacterStore extends CharacterStore{

	@Override
	protected Character createCharacter(Type type) {
		Character c = null;
		CharacterFeaturesFactory cfFactory = new UnderwildCharacterFeaturesFactory();
		
		if(type.equals(Type.GREEN)) {
			c = new GreenCharacter(cfFactory);
		}
		else if(type.equals(Type.BLUE)) {
			c = new BlueCharacter(cfFactory);
		}
		else if(type.equals(Type.RED)) {
			c = new RedCharacter(cfFactory);
		}
		
		return c;
	}
}
