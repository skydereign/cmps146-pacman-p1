package edu.ucsc.gameAI.conditions;

import pacman.game.Game;
import edu.ucsc.gameAI.ICondition;

public class CurrentLevelTime implements ICondition {
	
	int gmin;
	int gmax;
	public CurrentLevelTime (int min, int max) {
		gmin = min;
		gmax = max;
	}
	
	@Override
	public boolean test(Game game) {
		int time = game.getCurrentLevelTime();
		return time >= gmin && time <= gmax;
	}
}
