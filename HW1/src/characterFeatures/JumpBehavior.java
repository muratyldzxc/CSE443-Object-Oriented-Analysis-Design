package characterFeatures;

import java.awt.Rectangle;

public interface JumpBehavior {
	/**
	 * Manipulates given rectangle
	 * @param r is rectangle that will be manipulated
	 */
	public abstract void jump(Rectangle r);
}
