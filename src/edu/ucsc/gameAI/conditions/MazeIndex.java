package edu.ucsc.gameAI.conditions;

import pacman.game.Game;
import edu.ucsc.gameAI.ICondition;

public class MazeIndex implements ICondition {
	
	int gindex;
	public MazeIndex (int index) {
		gindex = index;
	}
	
	@Override
	public boolean test(Game game) {
		return gindex == game.getMazeIndex();
	}
}
