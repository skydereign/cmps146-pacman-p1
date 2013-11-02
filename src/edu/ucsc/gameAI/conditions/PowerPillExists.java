package edu.ucsc.gameAI.conditions;

import pacman.game.Game;
import edu.ucsc.gameAI.ICondition;

public class PowerPillExists implements ICondition {
	
	boolean pillExists = false;
	public PowerPillExists (Game game) {
			pillExists = game.getNumberOfActivePowerPills() >= 1;
	}
	
	@Override
	public boolean test(Game game) {
		return pillExists;
	}
}
