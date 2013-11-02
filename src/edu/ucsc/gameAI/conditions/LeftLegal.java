package edu.ucsc.gameAI.conditions;

import edu.ucsc.gameAI.ICondition;
import pacman.game.Constants.GHOST;
import pacman.game.Constants.MOVE;
import pacman.game.Game;

public class LeftLegal implements ICondition {
	GHOST gghost;
	public LeftLegal(GHOST ghost)
	{
		gghost=ghost;
	}
	
	public boolean test(Game game) 
	{
		boolean left_available = false;
		int loc = game.getGhostCurrentNodeIndex(gghost);
		MOVE last_dir = game.getGhostLastMoveMade(gghost); 
		MOVE pos_moves[] = game.getPossibleMoves(loc, last_dir);

		for(MOVE move : pos_moves) {
			if(move == MOVE.LEFT) {
				left_available = true;
				break;
			}
		}
		return left_available;
	}
}
