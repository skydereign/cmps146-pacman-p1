package edu.ucsc.gameAI.conditions;

import pacman.game.Game;
import edu.ucsc.gameAI.ICondition;

public class IsPowerPillStillAvailable implements ICondition {
	
	int gpillindex;
	public IsPowerPillStillAvailable (int pillindex) {
		gpillindex = pillindex;
	}
	
	@Override
	public boolean test(Game game) {
		return game.isPillStillAvailable(gpillindex);
	}
}
