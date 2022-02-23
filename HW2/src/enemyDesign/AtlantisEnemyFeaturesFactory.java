package enemyDesign;

public class AtlantisEnemyFeaturesFactory implements EnemyFeaturesFactory{

	@Override
	public Style createStyle() {
		return new AtlantisStyle();
	}
}
