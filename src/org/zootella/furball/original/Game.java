package org.zootella.furball.original;

import org.zootella.furball.FurballActivity;
import org.zootella.furball.kind.Danger;
import org.zootella.furball.kind.Direction;
import org.zootella.furball.kind.Location;
import org.zootella.furball.kind.Reaction;
import org.zootella.furball.kind.Sound;
import org.zootella.furball.kind.Tile;
	
public class Game {
	
	// Settings
	public static boolean soundEffectsOn;
	public static boolean startupHelp;
	
	public static void gameMain() {
		
		initialize(Define.initialStartingLevel); // START AT LEVEL 0
	}
	
	public static void drawTile(Tile tilename, int xgrid, int ygrid) {
		
	}
	
	public static void soundEffect(Sound sound) {
	}
	
	public static void menuNewGame() {
		
		initialize(Define.initialStartingLevel);
	}
	
	public static void menuGiveUp() {
		
		killFurball();
	}
	
	public static void menuEnterLevelCode() {
	}
	
	public static int lookupLevelCode(String inputstring) {
		
		int levelscan;
	
		for (levelscan = 0; levelscan <= (Define.numLevels - 1); levelscan++) {
	
			// COMPARE THE INPUT STRING WITH THE TABLE OF CODES
			if (inputstring == Levels.levelcode[levelscan]) {
	
				// MATCH FOUND, GO TO THE DESIRED LEVEL, REPORT SUCCESS
				initialize(levelscan);
				return (1);
			}
		}
	
		// THE ENTERED STRING COULD NOT BE MATCHED TO A CODE
		return 0;
	}
	
	/* 
	 * This function is called when the Furball has been killed and 
	 * no replacement Furball’s remain.  It has the task of 
	 * stopping the music, telling the user the bad news, and then 
	 * starting the game from the first level.  There are no 
	 * arguments or a return value.
	 */
	public static void gameOver() {

		// RESTART THE GAME FROM THE FIRST LEVEL
		initialize(Define.initialStartingLevel);
	}
	
	/* 
	 * This function is called when the final level has been 
	 * completed.  It has the task of playing a MIDI file, 
	 * displaying a congratulatory dialog box, and then starting 
	 * the game from the first level.  There are no arguments or a 
	 * return value.
	 */
	public static void gameWon() {
	
		// RESTART THE GAME FROM THE FIRST LEVEL
		initialize(Define.initialStartingLevel);
	}
	
	public static Tile board[][] = new Tile[Define.boardRows][Define.boardCols];
	public static Tile prevBoard[][] = new Tile[Define.boardRows][Define.boardCols];
	public static int currentLevel, lives;
	
	public static void initialize(int startinglevel) {
		
		// SET THE STARTING LEVEL AND INITIAL LIVES */
		currentLevel = startinglevel;
		lives = Define.livesAtStart;
	
		// SETUP THE BOARD AND PREVIOUSBOARD ARRAYS */
		loadLevel(currentLevel);
		saveBoard();
	
		// DRAW THE WINDOW AND START THE MUSIC */
		drawWindow();
	}
	
	public static void loadLevel(int level) {
		
		int row, col;
	
		for (row = 0; row <= (Define.boardRows - 1); row++)
			for (col = 0; col <= (Define.boardCols - 1); col++)
				board[row][col] = Levels.levelbank[level][row][col];
	}
	
	/* 
	 * This function has the job of copying all of the information 
	 * from the board array into the prevboard array.  There are no 
	 * arguments or a return value.
	 */
	public static void saveBoard() {
		
		int row, col;
	
		for (row = 0; row <= (Define.boardRows - 1); row++)
			for (col = 0; col <= (Define.boardCols - 1); col++)
				prevBoard[row][col] = board[row][col];
	}
	
	public static void moveFurball(Direction givendir) {
		
		int /*arow, acol,*/ brow = 0, bcol = 0, crow = 0, ccol = 0;
		Tile atile, btile, ctile;
		Reaction /*atype,*/ btype, ctype;
	
		// LOAD THE CURRENT POSITION OF THE FURBALL INTO AROW AND ACOL */
		Location a = findFurball();
	
		// COMPUTE THE COORDINATES OF B AND C FROM THE GIVEN DIRECTION */
		switch (givendir) {
	
			case up:
				brow = a.row - 1;
				crow = a.row - 2;
				bcol = a.col;
				ccol = a.col;
				break;
	
			case down:
				brow = a.row + 1;
				crow = a.row + 2;
				bcol = a.col;
				ccol = a.col;
				break;
	
			case left:
				brow = a.row;
				crow = a.row;
				bcol = a.col - 1;
				ccol = a.col - 2;
				break;
	
			case right:
				brow = a.row;
				crow = a.row;
				bcol = a.col + 1;
				ccol = a.col + 2;
				break;
	
		}
	
		// FIND THE THREE TILES AND TYPES */
		atile = whatsAt(a.row, a.col);
		btile = whatsAt(brow, bcol);
		ctile = whatsAt(crow, ccol);
	
		btype = getType(btile);
		ctype = getType(ctile);
	
		// CASE 1: THE DESTINATION TILE IS BLOCKING */
		if (btype == Reaction.blocking) {
	
			// THE FURBALL CANNOT PASS, DO NOTHING */
			return;
		}
	
		// CASE 2: THE DESTINATION TILE IS PASSING */
		if (btype == Reaction.passing) {
	
			// BACKUP THE BOARD BEFORE CHANGING IT */
			saveBoard();
	
			// PLAY A SOUND EFFECT IF APPROPRIATE */
			if (btile == Tile.hr)
				soundEffect(Sound.getHeart);
	
			// MAKE THE MOVE */
			if (atile == Tile.fg)
				board[a.row][a.col] = Tile.gs;
			else
				board[a.row][a.col] = Tile.sk;
	
			if (btile == Tile.sk)
				board[brow][bcol] = Tile.fs;
			else
				board[brow][bcol] = Tile.fg; // MOVED ONTO GRASS OR HEART
	
			// UPDATE THE SCREEN AND RUN CHECKS ON THE NEW BOARD */
			runChecks();
			updateBoard();
			return;
	
		}
	
		// CASE 3: THE FURBALL WILL MOVE INTO THE OPEN DOOR */
		if (btype == Reaction.finishing) {
	
			// BACKUP THE BOARD BEFORE CHANGING IT */
			saveBoard();
	
			// MAKE THE MOVE */
			if (atile == Tile.fg)
				board[a.row][a.col] = Tile.gs;
	
			if (atile == Tile.fs)
				board[a.row][a.col] = Tile.sk;
	
			board[brow][bcol] = Tile.dp;
	
			// UPDATE THE SCREEN AND COMPLETE THE LEVEL */
			updateBoard();
			finishedLevel();
			return;
		}
	
		// CASE 4: THE DESTINATION TILE IS PUSHABLE */
		if (btype == Reaction.pushable) {
	
			// MAKE SURE THE SPACE BEHIND THE BOX IS CLEAR */
			if (ctype != Reaction.passing)
				return;  // THE MOVE IS NOT POSSIBLE, DO NOTHING
	
			// BACKUP THE BOARD BEFORE CHANGING IT */
			saveBoard();
			
			// PLAY A SOUND EFFECT IF APPROPRIATE */
			if (ctile == Tile.hr)
				soundEffect(Sound.getHeart);
			
			if (ctile == Tile.sk)
				soundEffect(Sound.boxSink);
	
			// MAKE THE MOVE */
			if (atile == Tile.fg)
				board[a.row][a.col] = Tile.gs;
			else
				board[a.row][a.col] = Tile.sk;
	
			if (btile == Tile.bg)
				board[brow][bcol] = Tile.fg;
			else
				board[brow][bcol] = Tile.fs;
	
			if (ctile == Tile.sk)
				board[crow][ccol] = Tile.bs;
			else
				board[crow][ccol] = Tile.bg;
	
			// UPDATE THE SCREEN AND RUN CHECKS ON THE NEW BOARD */
			runChecks();
			updateBoard();
			return;
		}
	}
	
	public static void runChecks() {
		
		int opendoor, heartsleft, uncoveredsinks;
		int row, col;
		int doorrow = 0, doorcol = 0, /*fbrow, fbcol,*/ searchrow, searchcol;
		Danger found;
	
		// CHECK 1: OPEN OR CLOSE THE DOOR IF NECESSARY */
	
		// GATHER INFORMATION ABOUT THE BOARD */
		opendoor = 0;
		heartsleft = 0;
		uncoveredsinks = 0;
	
		for (row = 0; row <= (Define.boardRows - 1); row++) {
			for (col = 0; col <= (Define.boardCols - 1); col++) {
	
				if (board[row][col] == Tile.dc) {
					doorrow = row;
					doorcol = col;
				}
				if (board[row][col] == Tile.dp) {
					doorrow = row;
					doorcol = col;
					opendoor++;
				}
				if (board[row][col] == Tile.hr) {
					heartsleft++;
				}
				if (board[row][col] == Tile.sk) {
					uncoveredsinks++;
				}
				if (board[row][col] == Tile.fs) {
					uncoveredsinks++;
				}
			}
		}
	
		// THE DOOR IS LOCKED AND SHOULD BE OPENED */
		if (opendoor == 0 && heartsleft == 0 && uncoveredsinks == 0) {
	
			board[doorrow][doorcol] = Tile.dp;
			soundEffect(Sound.doorOpens);
		}
	
		// THE DOOR IS OPEN AND SHOULD BE SHUT */
		if (opendoor != 0 && (heartsleft != 0 || uncoveredsinks != 0)) {
	
			board[doorrow][doorcol] = Tile.dc;
		}
	
		// CHECK 2: SEE IF THE FURBALL'S PRESENT LOCATION IS SAFE */
	
		// LOCATE THE FURBALL */
		Location fb = findFurball();
	
		// SEARCH FOR DANGER IN EACH DIRECTION */
		searchrow = fb.row;
		searchcol = fb.col;
	
		while (true) {
			searchrow++;
			found = getDanger(whatsAt(searchrow, searchcol));
			if (found == Danger.safe) {
				break;
			}
			if (found == Danger.attack) {
				killFurball();
				return;
			}
		}
	
		searchrow = fb.row;
		searchcol = fb.col;
	
		while (true) {
			searchcol++;
			found = getDanger(whatsAt(searchrow, searchcol));
			if (found == Danger.safe) {
				break;
			}
			if (found == Danger.attack) {
				killFurball();
				return;
			}
		}
	
		searchrow = fb.row;
		searchcol = fb.col;
	
		while (true) {
			searchrow--;
			found = getDanger(whatsAt(searchrow, searchcol));
			if (found == Danger.safe) {
				break;
			}
			if (found == Danger.attack) {
				killFurball();
				return;
			}
		}
	
		searchrow = fb.row;
		searchcol = fb.col;
	
		while (true) {
			searchcol--;
			found = getDanger(whatsAt(searchrow, searchcol));
			if (found == Danger.safe) {
				break;
			}
			if (found == Danger.attack) {
				killFurball();
				return;
			}
		}
	}
	
	public static Location findFurball() {
		
		int srow, scol;
	
		for (srow = 0; srow <= (Define.boardRows - 1); srow++) {
			for (scol = 0; scol <= (Define.boardCols - 1); scol++) {
				if ((board[srow][scol] == Tile.fg) || (board[srow][scol] == Tile.fs)) {
	
					return new Location(srow, scol);
				}
			}
		}
		
		return new Location(-1, -1);
	}
	
	public static Tile whatsAt(int row, int col) {
		
		boolean foundinvalid;
	
		// IF THE GIVEN ROW OR COL IS INVALID, RETURN OUTSIDE */
		foundinvalid = false;
	
		if (row < 0            ) foundinvalid = true;
		if (col < 0            ) foundinvalid = true;
		if (row > Define.boardRows - 1) foundinvalid = true;
		if (col > Define.boardCols - 1) foundinvalid = true;
	
		if (foundinvalid)
			return (Tile.os);
	
		// THE COORDINATES ARE VALID, RETURN THE TILE */
		return (board[row][col]);
	}
	
	public static Reaction getType(Tile giventile) {
		
		switch (giventile) {
	
			case rk:
			case wl:
			case en:
			case dc:
			case os:
				return Reaction.blocking;
	
			case gs:
			case sk:
			case hr:
				return Reaction.passing;
	
			case dp:
				return Reaction.finishing;
	
			case bg:
			case bs:
				return Reaction.pushable;
	
			case fg:
			case fs:
				return Reaction.furball;
				
			default:
				return Reaction.blocking;
		}
	}
	
	public static Danger getDanger(Tile giventile) {
		
		switch (giventile) {
	
			case gs:
			case sk:
			case hr:
				return Danger.open;
	
			case rk:
			case wl:
			case dc:
			case dp:
			case bg:
			case bs:
			case os:
				return Danger.safe;
	
			case en:
				return Danger.attack;
	
			case fg:
			case fs:
				return Danger.self;
				
			default:
				return Danger.safe;
		}
	}
	
	public static void killFurball() {
		
		// DISPLAY THE LETHAL BOARD */
		updateBoard();
	
		// PLAY A SOUND EFFECT */
		soundEffect(Sound.kill);
	
		// HAVE THE PROGRAM PAUSE FOR A MOMENT */
	
		// IF NO LIVES REMAIN, END THE GAME */
		if (lives == 0)
			gameOver();
	
		// OTHERWISE, DECRIMENT THE NUMBER OF LIVES */
		lives--;
	
		// RESET AND RESTART THE CURRENT LEVEL */
		loadLevel(currentLevel);
		saveBoard();
	
		// DRAW THE WINDOW AND START THE MUSIC */
		drawWindow();
	}
	
	public static void finishedLevel() {
		
		// PLAY A SOUND EFFECT */
		soundEffect(Sound.levelDone);
	
		// HAVE THE PROGRAM PAUSE FOR A MOMENT */
	
		// IF THIS IS THE LAST LEVEL, THE GAME HAS BEEN WON */
		if (currentLevel == Define.numLevels - 1) {
			gameWon();
			return;
		}
	
		// OTHERWISE, MOVE ON TO THE NEXT LEVEL */
		currentLevel++;
	
		// SETUP THE NEXT LEVEL */
		loadLevel(currentLevel);
		saveBoard();
	
		// DRAW THE WINDOW AND START THE MUSIC */
		drawWindow();
	}
	
	public static void drawBoard() {
		
		int row, col;
		for (row = 0; row <= (Define.boardRows - 1); row++)
			for (col = 0; col <= (Define.boardCols - 1); col++)
				drawTile(board[row][col], col, row);
	}
	
	public static void drawWindow() {
		
		drawBoard();
	}
	
	public static void updateBoard() {
		
		FurballActivity.instance().updateBoard();
		
		/*
		
		int row, col;
	
		for (row = 0; row <= (Define.boardRows - 1); row++)
			for (col = 0; col <= (Define.boardCols - 1); col++)
				if (board[row][col] != prevBoard[row][col])
					drawTile(board[row][col], col, row);
					*/
	}
}
