package edu.ucsc.gameAI;

import edu.ucsc.gameAI.decisionTrees.binary.IBinaryNode;
import pacman.game.Constants.DM;
import pacman.game.Constants.GHOST;
import pacman.game.Constants.MOVE;
import pacman.game.Game;

public class GoToClosestEdibleGhost implements IAction, IBinaryNode{

	@Override
	public void doAction() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public MOVE getMove() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IAction makeDecision(Game game) {
		// TODO Auto-generated method stub
		int current = game.getPacmanCurrentNodeIndex();
		double closestDistance = 1000;
		GHOST closeGhost = null;
		MOVE myMove;
		
		for(GHOST ghost: GHOST.values()){
			if(game.isGhostEdible(ghost)){
				if(game.getShortestPathDistance(current, game.getGhostCurrentNodeIndex(ghost)) < closestDistance){
					closestDistance = game.getShortestPathDistance(current, game.getGhostCurrentNodeIndex(ghost));
					closeGhost = ghost;
				}
			}
		}
		myMove = game.getNextMoveTowardsTarget(current, game.getGhostCurrentNodeIndex(closeGhost), DM.PATH);

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

}
