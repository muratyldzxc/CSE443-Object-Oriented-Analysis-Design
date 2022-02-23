package enemyDesign;

public class UnderwildEnemyFeaturesFactory implements EnemyFeaturesFactory{

	@Override
	public Style createStyle() {
		return new UnderwildStyle();
	}
	
}
