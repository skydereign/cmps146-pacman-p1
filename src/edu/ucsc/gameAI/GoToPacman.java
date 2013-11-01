package edu.ucsc.gameAI;

import pacman.game.Constants.DM;
import pacman.game.Constants.GHOST;
import pacman.game.Constants.MOVE;
import pacman.game.Game;
import edu.ucsc.gameAI.decisionTrees.binary.IBinaryNode;

public class GoToPacman implements IBinaryNode {
	GHOST ghost;
	
	public GoToPacman(GHOST ghost) {
		this.ghost = ghost;
	}

	@Override
	public IAction makeDecision(Game game) {
		MOVE dir = game.getNextMoveTowardsTarget(game.getGhostCurrentNodeIndex(ghost), game.getPacmanCurrentNodeIndex(), DM.PATH);
		switch(dir) {
		case DOWN:
			return new GoDownAction();
			
		case UP:
			return new GoUpAction();

		case RIGHT:
			return new GoRightAction();

		case LEFT:
			return new GoLeftAction();

		default:
			break;
		}
		return null;

	}
}
