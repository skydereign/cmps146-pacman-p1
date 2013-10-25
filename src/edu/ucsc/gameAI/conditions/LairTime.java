package edu.ucsc.gameAI.conditions;

import edu.ucsc.gameAI.ICondition;
import pacman.game.Constants.GHOST;
import pacman.game.Game;

public class LairTime implements ICondition {

	GHOST gghost;
	int gmin;
	int gmax;
	public LairTime (GHOST ghost, int min, int max) {
		gghost = ghost;
		gmin = min;
		gmax = max;
	}
	
	@Override
	public boolean test(Game game) {
		int time = game.getGhostLairTime(gghost);
		return time >= gmin && time <= gmax;
	}

}
