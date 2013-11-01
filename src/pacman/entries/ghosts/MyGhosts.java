package pacman.entries.ghosts;

import java.util.Collection;
import java.util.EnumMap;
import java.util.LinkedList;

import pacman.controllers.Controller;
import pacman.game.Constants.DM;
import pacman.game.Constants.GHOST;
import pacman.game.Constants.MOVE;
import pacman.game.Game;
import edu.ucsc.gameAI.conditions.PacmanInRegion;
import edu.ucsc.gameAI.conditions.PacmanNear;
import edu.ucsc.gameAI.decisionTrees.binary.BinaryDecision;
import edu.ucsc.gameAI.decisionTrees.binary.IBinaryNode;
import edu.ucsc.gameAI.fsm.ITransition;
import edu.ucsc.gameAI.fsm.State;
import edu.ucsc.gameAI.fsm.StateMachine;
import edu.ucsc.gameAI.fsm.Transition;
import edu.ucsc.gameAI.*;

/*
 * This is the class you need to modify for your entry. In particular, you need to
 * fill in the getActions() method. Any additional classes you write should either
 * be placed in this package or sub-packages (e.g., game.entries.ghosts.mypackage).
 */
public class MyGhosts extends Controller<EnumMap<GHOST,MOVE>>
{
	private EnumMap<GHOST, MOVE> myMoves=new EnumMap<GHOST, MOVE>(GHOST.class);
	private BinaryDecision root;
	private IBinaryNode root_test;

	public MyGhosts() {
	}

	public EnumMap<GHOST, MOVE> getMove(Game game, long timeDue) {
		for(GHOST ghost : GHOST.values()) {	//for each ghost
			if(game.doesGhostRequireAction(ghost)) { //if ghost requires an action
				if(game.getTimeOfLastGlobalReversal() < 20) {
					switch(game.getPacmanNumberOfLivesRemaining()) {
					case 3:
						root_test = new GoToPacman(ghost);
						break;

					case 2:
						if(ghost == GHOST.INKY) {
							boolean left_available = false;
							int loc = game.getGhostCurrentNodeIndex(ghost);
							MOVE last_dir = game.getGhostLastMoveMade(ghost); 
							MOVE pos_moves[] = game.getPossibleMoves(loc, last_dir);

							for(MOVE move : pos_moves) {
								if(move == MOVE.LEFT) {
									left_available = true;
									break;
								}
							}
							if(left_available) {
								root_test = new GoLeftAction();
							} else {
								root_test = new GoDownAction();
							}
						} else {
							root_test = new GoToPacman(ghost);
						}
						break;

					case 1:
						if(game.getTotalTime()<570) {
							//root_test = new RunFromPacman(ghost);
							root_test = new GoToSafeSpot(ghost);
						} else {
							// if pacman is going towards a pill
							int pacman = game.getPacmanCurrentNodeIndex();
							MOVE pacman_dir = game.getPacmanLastMoveMade();
							int closest_pill = game.getClosestNodeIndexFromNodeIndex(game.getPacmanCurrentNodeIndex(), game.getActivePowerPillsIndices(), DM.PATH);
							if(game.getDistance(pacman, closest_pill, DM.PATH)<30 
									&& pacman_dir == game.getNextMoveTowardsTarget(pacman, closest_pill, DM.PATH)) {
								System.out.println("need to run");
								root_test = new RunFromPacman(ghost);
							} else {

								root_test = new GoToPacman(ghost);
							}
						}
						break;

					default:
						root_test = new GoToPacman(ghost);
						break;
					}

					myMoves.put(ghost, root_test.makeDecision(game).getMove());
				} else { // not according to plan
					if(game.isGhostEdible(ghost)){// ||  (new PacmanNear(ghost, 20)).test(game)) { // ghost is close
						root_test = new RunFromPacman(ghost);
						myMoves.put(ghost, root_test.makeDecision(game).getMove());
					} else {
						root_test = new GoToPacman(ghost);
						myMoves.put(ghost, root_test.makeDecision(game).getMove());
					}
				}
			}
		}
		return myMoves;
	}
}