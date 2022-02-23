package characterFeatures;
import java.awt.Rectangle;

public class JumpHigh implements JumpBehavior{
	/**
	 * Manipulates Rectangle's y coordinate by -120
	 */
	@Override
	public void jump(Rectangle r) {
		r.x += 0;
		r.y += -120;
	}

}
