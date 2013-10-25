package edu.ucsc.gameAI.conditions;

import pacman.game.Game;
import edu.ucsc.gameAI.ICondition;

public class IsPillStillAvailable implements ICondition {
	
	int gpillindex;
	public IsPillStillAvailable (int pillindex) {
		gpillindex = pillindex;
	}
	
	@Override
	public boolean test(Game game) {
		return game.isPillStillAvailable(gpillindex);
	}
}
