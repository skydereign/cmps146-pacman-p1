package edu.ucsc.gameAI.conditions;

import pacman.game.Game;
import edu.ucsc.gameAI.ICondition;

public class PacmanInRegion implements ICondition {

	int rx1, rx2, ry1, ry2;
	public PacmanInRegion (int x1, int y1, int x2, int y2) {
		rx1 = x1;
		ry1 = y1;
		rx2 = x2;
		ry2 = y2;
	}

	@Override
	public boolean test(Game game) {
		int pindex = game.getPacmanCurrentNodeIndex();
		int px = game.getNodeXCood(pindex);
		int py = game.getNodeYCood(pindex);
		return (px >= rx1 && px <= rx2 && py >= ry1 && py <= ry2);
	}
}
