package enemyDesign;

import Util.Type;

public class AtlantisEnemyStore extends EnemyStore{

	@Override
	protected Enemy createCharacter(Type type) {
		Enemy c = null;
		EnemyFeaturesFactory cfFactory = new AtlantisEnemyFeaturesFactory();
		
		if(type.equals(Type.GREEN)) {
			c = new GreenEnemy(cfFactory);
		}
		else if(type.equals(Type.BLUE)) {
			c = new BlueEnemy(cfFactory);
		}
		else if(type.equals(Type.RED)) {
			c = new RedEnemy(cfFactory);
		}
		
		return c;
	}

}
