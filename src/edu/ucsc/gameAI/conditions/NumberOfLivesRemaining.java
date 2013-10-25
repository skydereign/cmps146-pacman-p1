package edu.ucsc.gameAI.conditions;

import pacman.game.Game;
import edu.ucsc.gameAI.ICondition;

public class NumberOfLivesRemaining implements ICondition {
	
	int gmin;
	int gmax;
	public NumberOfLivesRemaining (int min, int max) {
		gmin = min;
		gmax = max;
	}
	
	@Override
	public boolean test(Game game) {
		int lives = game.getPacmanNumberOfLivesRemaining();
		return lives >= gmin && lives <= gmax;
	}
}
