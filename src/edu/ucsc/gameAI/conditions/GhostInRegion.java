package edu.ucsc.gameAI.conditions;

import pacman.game.Game;
import pacman.game.Constants.GHOST;
import edu.ucsc.gameAI.ICondition;

public class GhostInRegion implements ICondition {
	
	int rx1, rx2, ry1, ry2;
	public GhostInRegion (int x1, int y1, int x2, int y2) {
		rx1 = x1;
		ry1 = y1;
		rx2 = x2;
		ry2 = y2;
	}
	
	@Override
	public boolean test(Game game) {
		int px, py;
		for (GHOST ghost : GHOST.values()) {
			int gindex = game.getGhostCurrentNodeIndex(ghost);
			px = game.getNodeXCood(gindex);
			py = game.getNodeYCood(gindex);
			if(px >= rx1 && px <= rx2 && py >= ry1 && py <= ry2) {
				return true;
			}
		}
		return false;
	}
}
