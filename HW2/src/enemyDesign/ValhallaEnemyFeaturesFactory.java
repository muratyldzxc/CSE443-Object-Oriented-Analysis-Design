package enemyDesign;

public class ValhallaEnemyFeaturesFactory implements EnemyFeaturesFactory{

	@Override
	public Style createStyle() {
		return new ValhallaStyle();
	}
}
