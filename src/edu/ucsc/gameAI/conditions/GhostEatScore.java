package edu.ucsc.gameAI.conditions;

import pacman.game.Game;
import edu.ucsc.gameAI.ICondition;

public class GhostEatScore implements ICondition {
	
	int gmin;
	int gmax;
	public GhostEatScore (int min, int max) {
		gmin = min;
		gmax = max;
	}
	
	@Override
	public boolean test(Game game) {
		int score = game.getGhostCurrentEdibleScore(); 
		return score >= gmin && score <= gmax;
	}
}
