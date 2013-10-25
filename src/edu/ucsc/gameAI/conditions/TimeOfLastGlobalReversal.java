package edu.ucsc.gameAI.conditions;

import pacman.game.Game;
import edu.ucsc.gameAI.ICondition;

public class TimeOfLastGlobalReversal implements ICondition {
	
	int gmin;
	int gmax;
	public TimeOfLastGlobalReversal (int min, int max) {
		gmin = min;
		gmax = max;
	}
	
	@Override
	public boolean test(Game game) {
		int time = game.getTimeOfLastGlobalReversal();
		return time >= gmin && time <= gmax;
	}
}
