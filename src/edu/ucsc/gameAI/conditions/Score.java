package edu.ucsc.gameAI.conditions;

import pacman.game.Game;
import edu.ucsc.gameAI.ICondition;

public class Score implements ICondition {
	
	int gmin;
	int gmax;
	public Score (int min, int max) {
		gmin = min;
		gmax = max;
	}
	
	@Override
	public boolean test(Game game) {
		int score = game.getScore();
		return score >= gmin && score <= gmax;
	}
}
