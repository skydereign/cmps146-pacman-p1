package edu.ucsc.gameAI.conditions;

import pacman.game.Game;
import edu.ucsc.gameAI.ICondition;

public class PillInRegion implements ICondition {
	
	int gx1, gx2, gy1, gy2;
	public PillInRegion (int x1, int y1, int x2, int y2) {
		gx1 = x1;
		gy1 = y1;
		gx2 = x2;
		gy2 = y2;
	}
	
	@Override
	public boolean test(Game game) {
		int px, py;
		for (int pill : game.getActivePillsIndices()) {
			px = game.getNodeXCood(pill);
			py = game.getNodeYCood(pill);
			if(px >= gx1 && px <= gx2 && py >= gy1 && py <= gy2) {
				return true;
			}
		}
		return false;
	}
}
