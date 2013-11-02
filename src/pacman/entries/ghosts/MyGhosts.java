package pacman.entries.ghosts;

import java.util.Collection;
import java.util.EnumMap;
import java.util.LinkedList;

import pacman.controllers.Controller;
import pacman.game.Constants.DM;
import pacman.game.Constants.GHOST;
import pacman.game.Constants.MOVE;
import pacman.game.Game;
import edu.ucsc.gameAI.conditions.AccordingToPlanGhosts;
import edu.ucsc.gameAI.conditions.IsEdible;
import edu.ucsc.gameAI.conditions.LeftLegal;
import edu.ucsc.gameAI.conditions.NumberOfLivesRemaining;
import edu.ucsc.gameAI.conditions.PacmanInRegion;
import edu.ucsc.gameAI.conditions.PacmanNear;
import edu.ucsc.gameAI.conditions.SafeToChase;
import edu.ucsc.gameAI.conditions.TotalTime;
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
	private BinaryDecision blinky_root;
	private BinaryDecision pinky_root;
	private BinaryDecision inky_root;
	private BinaryDecision sue_root;
	private IBinaryNode root_test;

	public MyGhosts() {
		{ // setup blinky
			GHOST cur_ghost = GHOST.BLINKY;
			BinaryDecision lives23 = new BinaryDecision();
			BinaryDecision time = new BinaryDecision();
			BinaryDecision edible = new BinaryDecision();
			BinaryDecision safechase = new BinaryDecision();
			IBinaryNode chase = new GoToPacman(cur_ghost);
			IBinaryNode run = new RunFromPacman(cur_ghost);
			IBinaryNode gotosafe = new GoToSafeSpot(cur_ghost);
			IBinaryNode chasefront = new GoToPacmanFront(cur_ghost);


			blinky_root = new BinaryDecision();
			lives23.setCondition(new NumberOfLivesRemaining(2, 3));
			time.setCondition(new TotalTime(0, 570));
			edible.setCondition(new IsEdible(cur_ghost));
			safechase.setCondition(new SafeToChase(cur_ghost, 50));

			blinky_root.setCondition(new AccordingToPlanGhosts());
			blinky_root.setTrueBranch(lives23);
			lives23.setTrueBranch(chase);
			lives23.setFalseBranch(time);
			time.setTrueBranch(gotosafe);
			time.setFalseBranch(chase);

			blinky_root.setFalseBranch(edible);
			edible.setTrueBranch(run);
			edible.setFalseBranch(safechase);
			safechase.setTrueBranch(chasefront);
			safechase.setFalseBranch(run);
		}
		
		{ // setup pinky
			GHOST cur_ghost = GHOST.PINKY;
			BinaryDecision lives23 = new BinaryDecision();
			BinaryDecision time = new BinaryDecision();
			BinaryDecision edible = new BinaryDecision();
			BinaryDecision safechase = new BinaryDecision();
			IBinaryNode chase = new GoToPacman(cur_ghost);
			IBinaryNode run = new RunFromPacman(cur_ghost);
			IBinaryNode gotosafe = new GoToSafeSpot(cur_ghost);


			pinky_root = new BinaryDecision();
			lives23.setCondition(new NumberOfLivesRemaining(2, 3));
			time.setCondition(new TotalTime(0, 570));
			edible.setCondition(new IsEdible(cur_ghost));
			safechase.setCondition(new SafeToChase(cur_ghost, 50));

			pinky_root.setCondition(new AccordingToPlanGhosts());
			pinky_root.setTrueBranch(lives23);
			lives23.setTrueBranch(chase);
			lives23.setFalseBranch(time);
			time.setTrueBranch(gotosafe);
			time.setFalseBranch(chase);

			pinky_root.setFalseBranch(edible);
			edible.setTrueBranch(run);
			edible.setFalseBranch(safechase);
			safechase.setTrueBranch(chase);
			safechase.setFalseBranch(run);
		}
		
		{ // setup inky
			GHOST cur_ghost = GHOST.INKY;
			BinaryDecision lives3 = new BinaryDecision();
			BinaryDecision lives2 = new BinaryDecision();
			BinaryDecision left = new BinaryDecision();
			BinaryDecision time = new BinaryDecision();
			BinaryDecision edible = new BinaryDecision();
			BinaryDecision safechase = new BinaryDecision();
			IBinaryNode chase = new GoToPacman(cur_ghost);
			IBinaryNode run = new RunFromPacman(cur_ghost);
			IBinaryNode moveleft = new GoLeftAction();
			IBinaryNode movedown = new GoDownAction();
			IBinaryNode gotosafe = new GoToSafeSpot(cur_ghost);


			inky_root = new BinaryDecision();
			lives3.setCondition(new NumberOfLivesRemaining(3, 3));
			lives2.setCondition(new NumberOfLivesRemaining(2, 2));
			left.setCondition(new LeftLegal(cur_ghost));
			time.setCondition(new TotalTime(0, 570));
			edible.setCondition(new IsEdible(cur_ghost));
			safechase.setCondition(new SafeToChase(cur_ghost, 50));

			inky_root.setCondition(new AccordingToPlanGhosts());
			inky_root.setTrueBranch(lives3);
			lives3.setTrueBranch(chase);
			lives3.setFalseBranch(lives2);
			lives2.setTrueBranch(left);
			left.setTrueBranch(moveleft);
			left.setFalseBranch(movedown);
			
			lives2.setFalseBranch(time);
			time.setTrueBranch(gotosafe);
			time.setFalseBranch(chase);

			inky_root.setFalseBranch(edible);
			edible.setTrueBranch(run);
			edible.setFalseBranch(safechase);
			safechase.setTrueBranch(chase);
			safechase.setFalseBranch(run);
		}
		
		{ // setup sue (same as pinky)
			GHOST cur_ghost = GHOST.SUE;
			BinaryDecision lives23 = new BinaryDecision();
			BinaryDecision time = new BinaryDecision();
			BinaryDecision edible = new BinaryDecision();
			BinaryDecision safechase = new BinaryDecision();
			IBinaryNode chase = new GoToPacman(cur_ghost);
			IBinaryNode run = new RunFromPacman(cur_ghost);
			IBinaryNode gotosafe = new GoToSafeSpot(cur_ghost);


			sue_root = new BinaryDecision();
			lives23.setCondition(new NumberOfLivesRemaining(2, 3));
			time.setCondition(new TotalTime(0, 570));
			edible.setCondition(new IsEdible(cur_ghost));
			safechase.setCondition(new SafeToChase(cur_ghost, 50));
	
			sue_root.setCondition(new AccordingToPlanGhosts());
			sue_root.setTrueBranch(lives23);
			lives23.setTrueBranch(chase);
			lives23.setFalseBranch(time);
			time.setTrueBranch(gotosafe);
			time.setFalseBranch(chase);

			sue_root.setFalseBranch(edible);
			edible.setTrueBranch(run);
			edible.setFalseBranch(safechase);
			safechase.setTrueBranch(chase);
			safechase.setFalseBranch(run);
		}
	}

	public EnumMap<GHOST, MOVE> getMove(Game game, long timeDue) {
		for(GHOST ghost : GHOST.values()) {	//for each ghost
			if(game.doesGhostRequireAction(ghost)) { //if ghost requires an action
				switch(ghost){
				case BLINKY:
					myMoves.put(ghost, blinky_root.makeDecision(game).getMove());
					break;
				
				case PINKY:
					myMoves.put(ghost, pinky_root.makeDecision(game).getMove());
					break;
				
				case INKY:
					myMoves.put(ghost, inky_root.makeDecision(game).getMove());
					break;
				
				case SUE:
					myMoves.put(ghost, sue_root.makeDecision(game).getMove());
					break;
				
				default:
					break;
				}
				
				
				
				/*
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
							root_test = new GoToSafeSpot(ghost);
						} else {

							root_test = new GoToPacman(ghost);

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
						// if pacman is going towards a pill
						int pacman = game.getPacmanCurrentNodeIndex();
						MOVE pacman_dir = game.getPacmanLastMoveMade();
						int closest_pill = game.getClosestNodeIndexFromNodeIndex(game.getPacmanCurrentNodeIndex(), game.getActivePowerPillsIndices(), DM.PATH);
						if(closest_pill >= 0 && game.getDistance(pacman, closest_pill, DM.PATH)<50
								&& pacman_dir == game.getNextMoveTowardsTarget(pacman, closest_pill, DM.PATH)) {
							root_test = new RunFromPacman(ghost);
						} else {
							if(ghost != GHOST.BLINKY) {
								root_test = new GoToPacman(ghost);
							} else {
								root_test = new GoToPacmanFront(ghost);
							}

						}

						//root_test = new GoToPacman(ghost);
						myMoves.put(ghost, root_test.makeDecision(game).getMove());
					}
				}*/
			}
		}
		return myMoves;
	}
}