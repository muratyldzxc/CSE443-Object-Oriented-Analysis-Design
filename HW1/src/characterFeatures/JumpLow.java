package characterFeatures;
import java.awt.Rectangle;

public class JumpLow implements JumpBehavior{
	
	
	/**
	 * Manipulates Rectangle's y coordinate by -90
	 */
	@Override
	public void jump(Rectangle r) {
		r.x += 0;
		r.y += -90;
	}

}
