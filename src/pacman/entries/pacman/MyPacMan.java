package pacman.entries.pacman;

import edu.ucsc.gameAI.GetAwayFromClosestPowerPill;
import edu.ucsc.gameAI.GoDownAction;
import edu.ucsc.gameAI.GoLeftAction;
import edu.ucsc.gameAI.GoRightAction;
import edu.ucsc.gameAI.GoToClosestEdibleGhost;
import edu.ucsc.gameAI.GoToClosestPill;
import edu.ucsc.gameAI.GoToClosestPowerPill;
import edu.ucsc.gameAI.GoUpAction;
import edu.ucsc.gameAI.RunFromGhost;
import edu.ucsc.gameAI.conditions.AllGhostsInLair;
import edu.ucsc.gameAI.conditions.EdibleGhostsExists;
import edu.ucsc.gameAI.conditions.GhostInPowerProximity;
import edu.ucsc.gameAI.conditions.GhostIsClose;
import edu.ucsc.gameAI.conditions.NonEdibleGhostExists;
import edu.ucsc.gameAI.conditions.PacmanInPowerProximity;
import edu.ucsc.gameAI.conditions.PowerPillExists;
import edu.ucsc.gameAI.decisionTrees.binary.BinaryDecision;
import pacman.controllers.Controller;
import pacman.game.Constants.MOVE;
import pacman.game.Game;

/*
 * This is the class you need to modify for your entry. In particular, you need to
 * fill in the getAction() method. Any additional classes you write should either
 * be placed in this package or sub-packages (e.g., game.entries.pacman.mypackage).
 */
public class MyPacMan extends Controller<MOVE>
{
	
	public MOVE getMove(Game game, long timeDue) 
	{
		//Place your game logic here to play the game as Ms Pac-Man
		
		BinaryDecision root = new BinaryDecision();
		BinaryDecision nearGhost = new BinaryDecision();
		BinaryDecision ghostsInLair = new BinaryDecision();
		BinaryDecision farGhost = new BinaryDecision();
		BinaryDecision powerPill = new BinaryDecision();
		BinaryDecision proxPill = new BinaryDecision();
		BinaryDecision baitGhosts = new BinaryDecision();

		ghostsInLair.setCondition(new AllGhostsInLair(game));
		ghostsInLair.setFalseBranch(root);
		ghostsInLair.setTrueBranch(new GoToClosestPowerPill());
		
		root.setCondition(new NonEdibleGhostExists(game));
		root.setFalseBranch(new GoToClosestEdibleGhost());
		root.setTrueBranch(nearGhost);
		
		nearGhost.setCondition(new GhostIsClose(game));
		nearGhost.setFalseBranch(farGhost);
		nearGhost.setTrueBranch(new RunFromGhost());
		
		farGhost.setCondition(new EdibleGhostsExists(game));
		farGhost.setFalseBranch(powerPill);
		farGhost.setTrueBranch(new GoToClosestEdibleGhost());

		powerPill.setCondition(new PowerPillExists(game));
		powerPill.setFalseBranch(new GoToClosestPill());
		powerPill.setTrueBranch(proxPill);
		
		proxPill.setCondition(new PacmanInPowerProximity(game));
		proxPill.setFalseBranch(new GoToClosestPowerPill());
		proxPill.setTrueBranch(baitGhosts);
		
		baitGhosts.setCondition(new GhostInPowerProximity(game));
		baitGhosts.setFalseBranch(new GetAwayFromClosestPowerPill());
		baitGhosts.setTrueBranch(new GoToClosestPowerPill());
		
		if(root.makeDecision(game).getClass() == GoDownAction.class){
			return MOVE.DOWN;
		}else if(root.makeDecision(game).getClass() == GoUpAction.class){
			return MOVE.UP;
		}else if(root.makeDecision(game).getClass() == GoLeftAction.class){
			return MOVE.LEFT;
		}else if(root.makeDecision(game).getClass() == GoRightAction.class){
			return MOVE.RIGHT;
		}else{
			return MOVE.NEUTRAL;
		}
	}
}