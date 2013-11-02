package edu.ucsc.gameAI;

import pacman.game.Constants.DM;
import pacman.game.Constants.GHOST;
import pacman.game.Constants.MOVE;
import pacman.game.Game;
import edu.ucsc.gameAI.decisionTrees.binary.IBinaryNode;

public class RunFromGhost implements IAction, IBinaryNode{

	@Override
	public IAction makeDecision(Game game) {

		int current = game.getPacmanCurrentNodeIndex();
		double closestDistance = 5;
		MOVE myMove = MOVE.NEUTRAL;
		
		for(GHOST ghost: GHOST.values()){
			if(!game.isGhostEdible(ghost) && game.getGhostLairTime(ghost) <= 0){
				if(game.getShortestPathDistance(current, game.getGhostCurrentNodeIndex(ghost)) <= closestDistance){
					myMove = game.getNextMoveAwayFromTarget(current, game.getGhostCurrentNodeIndex(ghost), DM.PATH);
					break;
				}
			}
		}
		// TODO Auto-generated method stub
		switch(myMove){
		case LEFT:
			return new GoLeftAction();
		case RIGHT:
			return new GoRightAction();
		case UP:
			return new GoUpAction();
		case DOWN:
			return new GoDownAction();
		default:
			return new NeutralAction();
		}

	}

	@Override
	public void doAction() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public MOVE getMove() {
		// TODO Auto-generated method stub
		return null;
	}

}
