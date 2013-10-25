package edu.ucsc.gameAI.conditions;

import pacman.game.Game;
import edu.ucsc.gameAI.ICondition;

public class LevelCount implements ICondition {
	
	int glevel;
	public LevelCount (int level) {
		glevel = level;
	}
	
	@Override
	public boolean test(Game game) {
		return glevel == game.getCurrentLevel();
	}
}
