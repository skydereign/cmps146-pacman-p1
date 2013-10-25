package edu.ucsc.gameAI.conditions;

import pacman.game.Game;
import edu.ucsc.gameAI.ICondition;

public class TotalTime implements ICondition {
	
	int gmin;
	int gmax;
	public TotalTime (int min, int max) {
		gmin = min;
		gmax = max;
	}
	
	@Override
	public boolean test(Game game) {
		int time = game.getTotalTime();
		return time >= gmin && time <= gmax;
	}
}
