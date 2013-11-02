package edu.ucsc.gameAI;

import pacman.game.Constants.DM;
import pacman.game.Constants.GHOST;
import pacman.game.Constants.MOVE;
import pacman.game.Game;
import edu.ucsc.gameAI.decisionTrees.binary.IBinaryNode;

public class GoToPacmanFront implements IBinaryNode {
	GHOST ghost;
	
	public GoToPacmanFront(GHOST ghost) {
		this.ghost = ghost;
	}

	@Override
	public IAction makeDecision(Game game) {
		int pacman = game.getPacmanCurrentNodeIndex();
		MOVE pmove = game.getPacmanLastMoveMade();
		int target = game.getNeighbour(pacman, pmove);
		MOVE dir = game.getNextMoveTowardsTarget(game.getGhostCurrentNodeIndex(ghost), target, DM.PATH);
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

