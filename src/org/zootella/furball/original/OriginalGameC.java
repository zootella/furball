package org.zootella.furball.original;
	
public class OriginalGameC {
	
	/**********************************************************/
	/*                                                        */
	/*        F U R B A L L ’ S    A D V E N T U R E S        */
	/*                                                        */
	/**********************************************************/
	
	/**********************************************************/
	/* file game.c                                            */
	/**********************************************************/
	
	/* 
	 * This file is one of five files that make up the source code 
	 * to Furball’s Adventures, a multimedia puzzle game for 
	 * Windows 95 and Windows NT.  The five files including this 
	 * one are levels.h, furball.h, furball.c, game.h, and game.c.  
	 * These files compile into the Windows executable file 
	 * Furball.exe.
	 * 
	 * This file contains functions that relate to the logic and 
	 * workings of the game, and do not make any direct calls to 
	 * the Windows API.  The functions here deal with setting up 
	 * the board, processing requested moves, and making calls to 
	 * functions in furball.h to in turn request services from 
	 * Windows.
	 * 
	 * The functions in this file need the definitions and 
	 * functions in two external h files.  The file windows.h must 
	 * be included in all Windows programs.  The file resource.h is 
	 * prepared by Microsoft Developer Studio and contains the 
	 * resource bitmaps, dialogs, menu, icons, and wave audio files 
	 * that are compiled into the executable.  None of the 
	 * functions in this file make Windows API calls directly, but 
	 * they still do need these two header files.  For instance, 
	 * windows defines the data type BOOL, which is used by 
	 * functions in this file.
	 * 
	 * The three h files that are part of the source code of this 
	 * file, levels.h, furball.h, and game.h, are also included.
	 * 
	 * This file uses a small number of global variables.  Please 
	 * see the design document for Furball’s Adventures for a 
	 * compelling argument as to why these global variables are 
	 * absolutely necessary.
	 * 
	 * The global array board of type tile is used to hold the 
	 * current state of the board throughout the play of the game.  
	 * The array prevboard is used to hold the information that was 
	 * most recently in board, before the most recent move.  The 
	 * integer currentlevel is the level that game play is 
	 * currently in.  This number starts with zero representing the 
	 * first level, although to the user it appears that the first 
	 * level is level 1.  The integer lives is used to hold the 
	 * number of lives remaining, not including the life of the 
	 * Furball currently in play.
	 */
	
	// EXTERNAL INCLUDE STATEMENTS */
	
	/*
	#include <windows.h>
	#include "resource.h"
	
	// INTERNAL INCLUDE STATEMENTS */
	
	/*
	#include "levels.h"
	#include "furball.h"
	#include "game.h"
	
	// GAME GLOBAL VARIABLES */
	
	Tile board[][];
	Tile prevboard[][];
	int currentlevel, lives;
	
	/********************************************/
	/* INITIALIZE                               */
	/********************************************/
	
	/* 
	 * This function has the job of setting up a level and starting 
	 * the game.  Its single argument is the level that the game 
	 * should be started at.  There is no return value.
	 * 
	 * The function works by first setting the global variable 
	 * currentlevel to the newly specified starting level.  The 
	 * global variable lives is also initilized, and set equal to 
	 * the defined constant LIVESATSTART.  The function loadlevel 
	 * is called to setup the array of the board, and saveboard is 
	 * called to setup the prevboard array.  The call drawwindow 
	 * then draws the entire board and the status bar, and 
	 * jukebox(PLAY) starts the music.  Control then returns to the 
	 * calling function, which is usually WinMain or 
	 * MainWindowProcedure.
	 */
	
	void initialize(int startinglevel) {
		
		// SET THE STARTING LEVEL AND INITIAL LIVES */
	
		currentlevel = startinglevel;
		lives = Define.LIVESATSTART;
	
		// SETUP THE BOARD AND PREVIOUSBOARD ARRAYS */
	
		loadlevel(currentlevel);
		saveboard();
	
		// DRAW THE WINDOW AND START THE MUSIC */
	
		drawwindow();
		jukebox(MusicCommand.PLAY);
	}
	
	/********************************************/
	/* LOAD LEVEL                               */
	/********************************************/
	
	/* 
	 * This function has the job of getting the information about 
	 * how a level should be set up before game play on it begins 
	 * from the levelbank static array, and moving this 
	 * information into the board array.  The argument level is 
	 * the numbered level to load, starting with the first level as 
	 * 0.  There is no return value.
	 * 
	 * The integer variables row and col are index variables used 
	 * to move across the board as each cell in the array is 
	 * loaded.
	 * 
	 * This function works by using a doubly nested for loop to 
	 * load each cell in the levelth page of the levelbank array of 
	 * levels into the corresponding location in the board array.  
	 * This relatively simple operation coupled with the definition 
	 * of the static 3-D array levelbank allows Furball’s 
	 * Adventures to have multiple levels.
	 */
	
	void loadlevel(int level)
	{
		int row, col;
	
		for (row = 0; row <= (Define.BOARDROWS - 1); row++)
			for (col = 0; col <= (Define.BOARDCOLS - 1); col++)
				board[row][col] = levelbank[level][row][col];
	}
	
	/********************************************/
	/* SAVE BOARD                               */
	/********************************************/
	
	/* 
	 * This function has the job of copying all of the information 
	 * from the board array into the prevboard array.  There are no 
	 * arguments or a return value.
	 * 
	 * The integer variables row and col are index variables used 
	 * to move across the board.
	 * 
	 * This function works by using a double nested for loop to 
	 * copy each value in the board array into the same location in 
	 * the prevboard array.  When the function is called, all 
	 * information in the prevboard array is lost.
	 */
	
	void saveboard()
	{
		int row, col;
	
		for (row = 0; row <= (Define.BOARDROWS - 1); row++)
			for (col = 0; col <= (Define.BOARDCOLS - 1); col++)
				prevboard[row][col] = board[row][col];
	}
	
	/********************************************/
	/* MOVE FURBALL                             */
	/********************************************/
	
	/* 
	 * This function is the heart of the game logic of Furball’s 
	 * Adventures.  When the user presses an arrow key, Windows 
	 * send a message to MainWindowProcedure stating that a key was 
	 * pressed, and what key it was.  Code in that function decodes 
	 * this message into a call to this function, with the sole 
	 * argument as UP, DOWN, LEFT, or RIGHT.  The function has no 
	 * return value.
	 * 
	 * The variables in this function use the letters A, B, and C 
	 * to mark the three squares on the board that are important 
	 * when the Furball is trying to move.  Square A is where the 
	 * furball presently stands.  Square B is the square the 
	 * Furball has requested to move into.  Square C is the square 
	 * immediately beyond B; if the Furball is pushing a block, it 
	 * will want to move from B to C.
	 * 
	 * Thus, the integers arow, acol, brow, bcol, crow, and ccol 
	 * are the row and column coordinates of squares A, B, and C, 
	 * respectively.  The variables of type tile named atile, 
	 * btile, and ctile are the tiles located at A, B, and C.  The 
	 * variables atype, btype, and ctype hold information about the 
	 * three tiles useful in sorting the kind of move the Furball 
	 * is trying to make.
	 * 
	 * This function works by first calling daystate to check if 
	 * the current day state needs to be changed.  The daystate is 
	 * only checked before each move.  The addresses of the 
	 * variables arow and acol are then passed to the function 
	 * findfurball, where they will be filled with the Furball’s 
	 * present row and column position.  Now that we know the 
	 * position of the Furball as well as the direction he is 
	 * trying to move, we have enough information to find the row 
	 * and column positions of squares B and C as well.  These 
	 * calculations are made.  Finally, three calls to whatsat and 
	 * three calls to gettype fill the tile and type variables for 
	 * the three squares.
	 * 
	 * Note that it is important to call whatsat instead of simply 
	 * looking at the game array because the values in the row and 
	 * col variables are not necessarily valid array indices.  If 
	 * the Furball is at an edge of the board and trying to move 
	 * off it, A will be a square on the edge, while B and C will 
	 * be off the board entirely.  Accordingly, some of the 
	 * coordinates of brow, bcol, and so on may be larger than 
	 * BOARDROWS, or even negative.  This is not a problem, and is 
	 * designed into the way the logic of the game works.
	 * 
	 * At first, composing an algorithm to process a Furball move 
	 * seemed like a daunting task.  Square A can be of type 
	 * FBONGRASS or FBONSINK, while squares B and C can be any of 
	 * the remaining 11 possible tiles.  This yields 242 different 
	 * cases that need to be accounted for.  Through careful 
	 * sorting, this function and its helper functions successfully 
	 * sort and take care of all of these cases.
	 * 
	 * The algorithm used is this:  First, determine what the 
	 * nature of the square is that he Furball is trying to move on 
	 * to.  This will break the problem into several parts, each of 
	 * which can be dealt with individually, and broken down 
	 * further if necessary.  There are 242 different cases, but 
	 * huge chunks of them have exactly the same outcome.  It is 
	 * the goal of the sorting method to group together as many 
	 * similar ending cases as possible as early as possible, and 
	 * then take care of them all as once.
	 * 
	 * The crucial first pass sort looks at the nature of tile B.  
	 * It is either BLOCKING, PASSING, FINISHING, or PUSHABLE.  If 
	 * it is blocking, the Furball can’t move, and nothing more 
	 * needs to be done.  Control simply returns to the calling 
	 * function, which is always MainWindowProcedure.
	 * 
	 * If tile B is of type PASSING, then we know that the move 
	 * will be able to happen.  A call is first made to saveboard 
	 * to record the present state of the board before it is 
	 * changed.  If the passing B tile is a heart, this move will 
	 * collect it, and so a sound effect is played.  The Furball is 
	 * then actually moved.  If the Furball was standing on grass, 
	 * the board cell at the Furball’s position is changed to 
	 * grass, otherwise the Furball must have been standing on a 
	 * sink, and the location is changed to SINK.  Similarly, a 
	 * possible sink at location B is preserved by changing that 
	 * grid location to FBONSINK if appropriate.  The C square can 
	 * be totally left alone in this case.  With the move over, the 
	 * function runchecks is called to check if the Furball is safe 
	 * in its new location as well as if the door should be opened 
	 * or closed, and the function updateboard is called to draw 
	 * the tiles that have just changed on the screen.  The return 
	 * then gives control back to MainWindowProcedure, where the 
	 * next message is processed.
	 * 
	 * If tile B is of type FINSHING, the Furball is about to move 
	 * into an open door.  We know that the move is possible and 
	 * will finish the level.  The function saveboard is called to 
	 * backup the current board configuration, and the Furball is 
	 * moved into the open door and off of the screen.  This time 
	 * the functions updateboard and finishedlevel are called 
	 * before returning control to MainWindowProcedure.  The first 
	 * call draws the winning board on the screen, and the moves 
	 * game play to the next level.
	 * 
	 * If tile B is of type PUSHABLE, the Furball is trying to push 
	 * a box around.  Now tile C becomes important, and there are 
	 * even more situations to consider.  If tile C is not a 
	 * passing tile, the Furball is trying to push a box into a 
	 * rock, enemy, wall, or other solid tile, and the move is not 
	 * possible.  Control in this case simply returns to 
	 * MainWindowProcedure to get the next message.  Otherwise the 
	 * move will be possible, and saveboard is called to backup the 
	 * information on the board before the move is made.  If the 
	 * Furball will push the box into a heart, the heart will be 
	 * collected, and a sound effect is played.  If the Furball 
	 * will push the box into a sink, the sink will be filled, and 
	 * a different sound effect is played.  The move is made by 
	 * changing all three positions in the board array.  If the 
	 * Furball was standing on a grassy square, the a square is 
	 * changed to grass, otherwise it must have been, and now be, a 
	 * sink.  The second if else statement preserves a sink if a 
	 * box is being pushed off of it, and the third preserves a 
	 * sink that a box is moving on to.  The functions runchecks 
	 * and updateboard are called, and control returns to 
	 * MainWindowProcedure to get the next message.
	 */
	
	void movefurball(Direction givendir)
	{
		int arow, acol, brow, bcol, crow, ccol;
		Tile atile, btile, ctile;
		TileType atype, btype, ctype;
	
		// CHECK THE DAY STATE BEFORE EACH MOVE */
	
		checkdaystate();
	
		// LOAD THE CURRENT POSITION OF THE FURBALL INTO AROW AND ACOL */
	
		findfurball(&arow, &acol);
	
		// COMPUTE THE COORDINATES OF B AND C FROM THE GIVEN DIRECTION */
	
		switch (givendir) {
	
			case UP:
				brow = arow - 1;
				crow = arow - 2;
				bcol = acol;
				ccol = acol;
				break;
	
			case DOWN:
				brow = arow + 1;
				crow = arow + 2;
				bcol = acol;
				ccol = acol;
				break;
	
			case LEFT:
				brow = arow;
				crow = arow;
				bcol = acol - 1;
				ccol = acol - 2;
				break;
	
			case RIGHT:
				brow = arow;
				crow = arow;
				bcol = acol + 1;
				ccol = acol + 2;
				break;
	
		}
	
		// FIND THE THREE TILES AND TYPES */
	
		atile = whatsat(arow, acol);
		btile = whatsat(brow, bcol);
		ctile = whatsat(crow, ccol);
	
		atype = gettype(atile);
		btype = gettype(btile);
		ctype = gettype(ctile);
	
		// CASE 1: THE DESTINATION TILE IS BLOCKING */
	
		if (btype == TileType.BLOCKING) {
	
			// THE FURBALL CANNOT PASS, DO NOTHING */
	
			return;
	
		}
	
		// CASE 2: THE DESTINATION TILE IS PASSING */
	
		if (btype == TileType.PASSING) {
	
			// BACKUP THE BOARD BEFORE CHANGING IT */
	
			saveboard();
	
			// PLAY A SOUND EFFECT IF APPROPRIATE */
	
			if (btile == Tile.HEART)
				soundeffect(SoundTitle.GETHEART);
	
			// MAKE THE MOVE */
	
			if (atile == Tile.FBONGRASS)
				board[arow][acol] = Tile.GRASS;
			else
				board[arow][acol] = Tile.SINK;
	
			if (btile == Tile.SINK)
				board[brow][bcol] = Tile.FBONSINK;
			else
				board[brow][bcol] = Tile.FBONGRASS; // MOVED ONTO GRASS OR HEART
	
			// UPDATE THE SCREEN AND RUN CHECKS ON THE NEW BOARD */
	
			runchecks();
			updateboard();
			return;
	
		}
	
		// CASE 3: THE FURBALL WILL MOVE INTO THE OPEN DOOR */
	
		if (btype == TileType.FINISHING) {
	
			// BACKUP THE BOARD BEFORE CHANGING IT */
	
			saveboard();
	
			// MAKE THE MOVE */
	
			if (atile == Tile.FBONGRASS)
				board[arow][acol] = Tile.GRASS;
	
			if (atile == Tile.FBONSINK)
				board[arow][acol] = Tile.SINK;
	
			board[brow][bcol] = Tile.DOOROPEN;
	
			// UPDATE THE SCREEN AND COMPLETE THE LEVEL */
	
			updateboard();
			finishedlevel();
			return;
	
		}
	
		// CASE 4: THE DESTINATION TILE IS PUSHABLE */
	
		if (btype == TileType.PUSHABLE) {
	
			// MAKE SURE THE SPACE BEHIND THE BOX IS CLEAR */
	
			if (ctype != TileType.PASSING)
				return;  // THE MOVE IS NOT POSSIBLE, DO NOTHING
	
			// BACKUP THE BOARD BEFORE CHANGING IT */
	
			saveboard();
			
			// PLAY A SOUND EFFECT IF APPROPRIATE */
	
			if (ctile == Tile.HEART)
				soundeffect(SoundTitle.GETHEART);
			
			if (ctile == Tile.SINK)
				soundeffect(SoundTitle.BOXSINK);
	
			// MAKE THE MOVE */
	
			if (atile == Tile.FBONGRASS)
				board[arow][acol] = Tile.GRASS;
			else
				board[arow][acol] = Tile.SINK;
	
			if (btile == Tile.BOXONGRASS)
				board[brow][bcol] = Tile.FBONGRASS;
			else
				board[brow][bcol] = Tile.FBONSINK;
	
			if (ctile == Tile.SINK)
				board[crow][ccol] = Tile.BOXONSINK;
			else
				board[crow][ccol] = Tile.BOXONGRASS;
	
			// UPDATE THE SCREEN AND RUN CHECKS ON THE NEW BOARD */
	
			runchecks();
			updateboard();
			return;
		}
	}
	
	/********************************************/
	/* RUN CHECKS                               */
	/********************************************/
	
	/* 
	 * This function is called right after the Furball has moved, 
	 * and before the Furball can move again.  It analyses the 
	 * present board, determines if the Furball has moved into a 
	 * square that will prove lethal, and checks if the level exit 
	 * door should be opened or closed.  There are no arguments or 
	 * return values.
	 * 
	 * The integers opendoor, hertsleft, and uncoveredsinks are 
	 * counts of how many open doors, hearts, and uncovered sinks 
	 * are in the board.  The integers row and col are used to scan 
	 * across the board.  The coordinates doorrow and doorcol are 
	 * those of the door, the coordinates fbrow and fbcol locate 
	 * the Furball, and the indices searchrow and searchcol specify 
	 * the location in the grid that is presently being looked at 
	 * by the safety algorithm.  The variable found of type 
	 * tiledanger holds the results of an analysis of the tile 
	 * located at searchrow and searchcol.
	 * 
	 * This function performs two checks.  The first checks to see 
	 * if the door should be opened or closed.  The counts 
	 * opendoor, heartsleft, and uncoveredsinks are first 
	 * initialized to zero.  The board array is then looked through 
	 * square by square.  When the door is located, its coordinates 
	 * are copied into doorrow and doorcol.  The presence of a 
	 * heart increments the heartsleft count.  Finding either a 
	 * tile of type SINK or FBONSINK causes the uncoveredsinks 
	 * count to go up one notch.  Two cases are then looked for and 
	 * deal with.  If the door is closed, there are no hearts, and 
	 * all sinks have been covered, the door is opened, and a sound 
	 * effect happens.  If the door is open yet there is now a 
	 * heart or an uncovered sink, the door is shut.
	 * 
	 * The second check sees if the Furball will be killed in its 
	 * new location.  The function findfurball is first called to 
	 * locate the Furball on the board.  Danger is then looked for 
	 * in each direction.  To search for danger from above, the 
	 * coordinates searchrow and searchcol are first set to the 
	 * Furball’s present position.  An infinite loop begins that 
	 * first moves the search coordinates one square up.  There the 
	 * variable found is set to the danger posed by the tile at the 
	 * search coordinates.  If this threat is SAFE, the Furball is 
	 * being protected by a rock or box, and cannot be killed by an 
	 * attack from this direction.  The loop exits.  If the threat 
	 * is ATTACK, an enemy was found, and the Furball will be 
	 * killed.  The function killfurball is called to take care of 
	 * this, and then this function returns control to its caller, 
	 * which in most cases will filter control directly back to 
	 * MainWindowProcedure.  If the search tile is neither SAFE nor 
	 * ATTACK, the Furball’s safety is still undetermined, and the 
	 * loop repeats, this time looking at a square one unit further 
	 * away.  The loop cannot continue forever, because as soon as 
	 * the search coordinates go off the board, whatsat will report 
	 * OUTSIDE and getdanger will report SAFE.  If control safely 
	 * passes out of all 4 while loops, the Furball was found to be 
	 * safe in each direction, and the function ends
	 */
	
	void runchecks()
	{
		int opendoor, heartsleft, uncoveredsinks;
		int row, col;
		int doorrow, doorcol, fbrow, fbcol, searchrow, searchcol;
		TileDanger found;
	
		// CHECK 1: OPEN OR CLOSE THE DOOR IF NECESSARY */
	
		// GATHER INFORMATION ABOUT THE BOARD */
	
		opendoor = 0;
		heartsleft = 0;
		uncoveredsinks = 0;
	
		for (row = 0; row <= (Define.BOARDROWS - 1); row++) {
			for (col = 0; col <= (Define.BOARDCOLS - 1); col++) {
	
				if (board[row][col] == Tile.DOORCLOSED) {
					doorrow = row;
					doorcol = col;
				}
				if (board[row][col] == Tile.DOOROPEN) {
					doorrow = row;
					doorcol = col;
					opendoor++;
				}
				if (board[row][col] == Tile.HEART) {
					heartsleft++;
				}
				if (board[row][col] == Tile.SINK) {
					uncoveredsinks++;
				}
				if (board[row][col] == Tile.FBONSINK) {
					uncoveredsinks++;
				}
				
			}
		}
	
		// THE DOOR IS LOCKED AND SHOULD BE OPENED */
	
		if (opendoor == 0 && heartsleft == 0 && uncoveredsinks == 0) {
	
			board[doorrow][doorcol] = Tile.DOOROPEN;
			soundeffect(SoundTitle.DOOROPENS);
	
		}
	
		// THE DOOR IS OPEN AND SHOULD BE SHUT */
	
		if (opendoor != 0 && (heartsleft != 0 || uncoveredsinks != 0)) {
	
			board[doorrow][doorcol] = Tile.DOORCLOSED;
	
		}
	
		// CHECK 2: SEE IF THE FURBALL'S PRESENT LOCATION IS SAFE */
	
		// LOCATE THE FURBALL */
	
		findfurball(&fbrow, &fbcol);
	
		// SEARCH FOR DANGER IN EACH DIRECTION */
	
		searchrow = fbrow;
		searchcol = fbcol;
	
		while (true) {
			searchrow++;
			found = getdanger(whatsat(searchrow, searchcol));
			if (found == SAFE) {
				break;
			}
			if (found == ATTACK) {
				killfurball();
				return;
			}
		}
	
		searchrow = fbrow;
		searchcol = fbcol;
	
		while (1) {
			searchcol++;
			found = getdanger(whatsat(searchrow, searchcol));
			if (found == SAFE) {
				break;
			}
			if (found == ATTACK) {
				killfurball();
				return;
			}
		}
	
		searchrow = fbrow;
		searchcol = fbcol;
	
		while (1) {
			searchrow--;
			found = getdanger(whatsat(searchrow, searchcol));
			if (found == SAFE) {
				break;
			}
			if (found == ATTACK) {
				killfurball();
				return;
			}
		}
	
		searchrow = fbrow;
		searchcol = fbcol;
	
		while (1) {
			searchcol--;
			found = getdanger(whatsat(searchrow, searchcol));
			if (found == SAFE) {
				break;
			}
			if (found == ATTACK) {
				killfurball();
				return;
			}
		}
	}
	
	/********************************************/
	/* FIND FURBALL                             */
	/********************************************/
	
	/* 
	 * This function has the job of looking at the current state of 
	 * the board, and finding the location of the Furball.  There 
	 * are two arguments, the pointers to the integers row and col 
	 * that should be given the coordinates of the Furball.  There 
	 * is no return value.
	 * 
	 * The variables srow and scol are the index coordinates of the 
	 * square currently being searched for the Furball.
	 * 
	 * This function works by using a double nested for loop to 
	 * search each square in the board array for FBONGRASS or 
	 * FBONSINK.  Once either are found, the two argument pointers 
	 * are dereferenced and given the answer coordinates, and the 
	 * function returns.
	 * 
	 * I designed the data structures in this program such that the 
	 * entire state of a single game with one life can be explained 
	 * only with the data in the board array.  There is no attached 
	 * structure with the coordinates of the Furball, or the 
	 * coordinates of the moving boxes, rather everything is stored 
	 * right in the array.  This makes many of the game logic 
	 * functions a great deal simpler, but requires that the 
	 * Furball first be found before its location can be known.  
	 * This function carries out this rather simple and frequently 
	 * used task.
	 * 
	 * Every legal starting board contains exactly one instance of 
	 * FBONGRASS or FBONSINK, and no function removes or multiplies 
	 * the Furball.  If a level is loaded without the Furball, the 
	 * two integers may go undeclared, and the program may crash.  
	 * This can only occur when an error in level development has 
	 * occurred; once the program has been compiled with a set of 
	 * valid levels, there is no way the user can crash the 
	 * program.  For this reason, error checking like dealing with 
	 * the case when no or multiple Furballs were located is not 
	 * dealt with in this function.
	 */
	
	void findfurball(int *row, int *col)
	{
		int srow, scol;
	
		for (srow = 0; srow <= (BOARDROWS - 1); srow++)
			for (scol = 0; scol <= (BOARDCOLS - 1); scol++)
				if ((board[srow][scol] == FBONGRASS)
					||(board[srow][scol] == FBONSINK)) {
	
					*row = srow;
					*col = scol;
					return;
	
				}
	}
	
	/********************************************/
	/* WHAT'S AT                                */
	/********************************************/
	
	/* 
	 * This function has the job of taking two board coordinates, 
	 * and returning what tile is present on that part of the 
	 * board.  The arguments row and col are the given coordinates, 
	 * and the return value of type tile is the located tile.
	 * 
	 * The variable foundinvalid is a Boolean flag that is set to 
	 * TRUE if a given coordinate is found to point to a row or 
	 * column not on the board.
	 * 
	 * This function works by first assuming that the given 
	 * coordinates are valid.  Whether the coordinates are within 
	 * the four boundaries of the square board is then checked, and 
	 * foundinvalid is set to TRUE if any of the tests report a 
	 * breech of the board.  If the coordinates were found to be 
	 * invalid, the function returns OUTSIDE, the defined type of a 
	 * the infinite number of black space tiles off of the board.
	 * 
	 * Otherwise, the coordinates must be valid, and the board 
	 * array can simply be read to find the name of the tile to 
	 * return.
	 * 
	 * At a first look, it may not be clear why whatsat is even 
	 * necessary.  Instead of saying mytile = whatsat(row, col), 
	 * couldn’t it just be mytile = board[row][col]?  The 
	 * difference between these two happens when row and col are 
	 * not valid coordinates on the board.  The function whatsat 
	 * will set mytile to OFFBOARD, while just using the actual 
	 * boar array will cause a General Protection Fault.  The tile 
	 * name OFFBOARD is more than a placeholder for an error in 
	 * given coordinates.  Rather, it is used extensively by the 
	 * logic of the game functions to freely analyze the board 
	 * within and outside its margins.
	 */
	
	tile whatsat(int row, int col)
	{
		BOOL foundinvalid;
	
		// IF THE GIVEN ROW OR COL IS INVALID, RETURN OUTSIDE */
	
		foundinvalid = FALSE;
	
		if (row < 0            ) foundinvalid = TRUE;
		if (col < 0            ) foundinvalid = TRUE;
		if (row > BOARDROWS - 1) foundinvalid = TRUE;
		if (col > BOARDCOLS - 1) foundinvalid = TRUE;
	
		if (foundinvalid)
			return (OUTSIDE);
	
		// THE COORDINATES ARE VALID, RETURN THE TILE */
	
		return (board[row][col]);
	}
	
	/********************************************/
	/* GET TYPE                                 */
	/********************************************/
	
	/* 
	 * This function classifies a tile into one of several groups 
	 * to help the analysis of a move the Furball is trying to 
	 * make.  The argument tile is a tile name to look up, and the 
	 * function returns a piece of data of type tiletype.
	 * 
	 * This function works by using a switch statement with more 
	 * case commands then return commands to sort groups of tiles 
	 * into various tile types.  Rocks, walls, enemies, the door 
	 * when it is closed, and tiles outside the board are all 
	 * immobile, blocking objects.  Grass squares, just plain or 
	 * with a sink or a heart, can be walked over and have things 
	 * pushed over.  The open door has a special type, FINISHING.  
	 * The two types of boxes are both PUSHABLE, and the two types 
	 * of Furball are both of type FURBALL.
	 * 
	 * The function movefurball calls this function to classify a 
	 * tile to be able to analyze a move.
	 */
	
	tiletype gettype(tile giventile)
	{
		switch (giventile) {
	
			case ROCK:
			case WALL:
			case ENEMY:
			case DOORCLOSED:
			case OUTSIDE:
				return (BLOCKING);
	
			case GRASS:
			case SINK:
			case HEART:
				return (PASSING);
	
			case DOOROPEN:
				return (FINISHING);
	
			case BOXONGRASS:
			case BOXONSINK:
				return (PUSHABLE);
	
			case FBONGRASS:
			case FBONSINK:
				return (FURBALL);
	
		}
	}
	
	/********************************************/
	/* GET DANGER                               */
	/********************************************/
	
	/* 
	 * This function classifies a tile into one of several groups 
	 * to help the analysis of a the Furball’s safety.  The 
	 * argument tile is a tile name to look up, and the function 
	 * returns a piece of data of type tiledanger.
	 * 
	 * This function works by using a switch statement with more 
	 * case commands then return commands to sort groups of tiles 
	 * into various tile types.  Grass, sink, and heart squares do 
	 * not ensure the safety nor the death of the Furball, and are 
	 * reported as OPEN.  Rocks, walls, and a large number of solid 
	 * blocking objects on the board in addition to the dark tile 
	 * OTUSIDE will protect the Furball, and are classified as 
	 * SAFE.  An enemy will kill the Furball, and has the danger 
	 * rating ATTACK.  This function should never need to be used 
	 * to analyze the Furball himself, although for error checking 
	 * purposes doing so results in a return value of SELF.
	 * 
	 * The function runchecks calls this function to classify a 
	 * tile to check to see if the Furball is safe in its present 
	 * location.
	 */
	
	tiledanger getdanger(tile giventile)
	{
		switch (giventile) {
	
			case GRASS:
			case SINK:
			case HEART:
				return (OPEN);
	
			case ROCK:
			case WALL:
			case DOORCLOSED:
			case DOOROPEN:
			case BOXONGRASS:
			case BOXONSINK:
			case OUTSIDE:
				return (SAFE);
	
			case ENEMY:
				return (ATTACK);
	
			case FBONGRASS:
			case FBONSINK:
				return (SELF);
	
		}
	}
	
	/********************************************/
	/* KILL FURBALL                             */
	/********************************************/
	
	/* 
	 * This function has the job of killing the Furball once it has 
	 * been determined that he stepped in front of an enemy.  There 
	 * are no arguments or a return variable.
	 * 
	 * This function works by first showing the user the board that 
	 * killed the Furball by calling updateboard.  A sound effect 
	 * to alert the user to the kill is played, and the program 
	 * pauses for a moment to let the user see what happened.  If 
	 * no lives are left, control is passed to gameover to end not 
	 * just this Furball, but now the entire game.  Otherwise, the 
	 * global game variable lives is decremented, the current level 
	 * is reloaded, the current level is saved, the window is 
	 * redisplayed, and the music restarted.  Control then filters 
	 * back to the calling function, and eventually reaches 
	 * MainWindowProcedure where the next message is processed.
	 */
	
	void killfurball()
	{
		// DISPLAY THE LETHAL BOARD */
	
		updateboard();
	
		// PLAY A SOUND EFFECT */
	
		soundeffect(KILL);
	
		// HAVE THE PROGRAM PAUSE FOR A MOMENT */
	
		Sleep(SLEEPMILLI);
	
		// IF NO LIVES REMAIN, END THE GAME */
	
		if (lives == 0)
			gameover();
	
		// OTHERWISE, DECRIMENT THE NUMBER OF LIVES */
	
		lives--;
	
		// RESET AND RESTART THE CURRENT LEVEL */
	
		loadlevel(currentlevel);
		saveboard();
	
		// DRAW THE WINDOW AND START THE MUSIC */
	
		drawwindow();
		jukebox(PLAY);
	}
	
	/********************************************/
	/* FINISHED LEVEL                           */
	/********************************************/
	
	/* 
	 * This function has the job of cleaning up the current, 
	 * completed level, setting up the next one, and starting game 
	 * play there.  There are no arguments or a return value.
	 * 
	 * This function works by first calling soundeffect to play a 
	 * sound effect to mark the successful completion of the level.  
	 * The program pauses for a moment to let the user look at the 
	 * ending board.  The function then checks to make sure that 
	 * the level that was just completed is not the last level in 
	 * the game.  If it is, control is passed to gamewon, and then 
	 * filters back through this function and back to 
	 * MainWindowProcedure.  Otherwise, the global game variable 
	 * currentlevel is incrimented, the new current level is 
	 * loaded, the board is saved in prevboard, the window is 
	 * redrawn, and the music is restarted.
	 */
	
	void finishedlevel()
	{
		// PLAY A SOUND EFFECT */
	
		soundeffect(LEVELDONE);
	
		// HAVE THE PROGRAM PAUSE FOR A MOMENT */
	
		Sleep(SLEEPMILLI);
	
		// IF THIS IS THE LAST LEVEL, THE GAME HAS BEEN WON */
	
		if (currentlevel == NUMLEVELS - 1) {
			gamewon();
			return;
		}
	
		// OTHERWISE, MOVE ON TO THE NEXT LEVEL */
	
		currentlevel++;
	
		// SETUP THE NEXT LEVEL */
		
		loadlevel(currentlevel);
		saveboard();
	
		// DRAW THE WINDOW AND START THE MUSIC */
	
		drawwindow();
		jukebox(PLAY);
	}
	
	/********************************************/
	/* DRAW BOARD                               */
	/********************************************/
	
	/* 
	 * This function has the job of drawing the entire board to the 
	 * screen.  There are no arguments or return values.
	 * 
	 * The variables row and col are used to page through each cell 
	 * in the board array.
	 * 
	 * This function works by using a doubly-nested for lop to make 
	 * a call to the Furball function drawtile for each cell in the 
	 * board array.
	 */
	
	void drawboard()
	{
		int row, col;
	
		for (row = 0; row <= (BOARDROWS - 1); row++)
			for (col = 0; col <= (BOARDCOLS - 1); col++)
				drawtile(board[row][col], col, row);
	}
	
	/********************************************/
	/* DRAW WINDOW                              */
	/********************************************/
	
	/* 
	 * This function has the job of drawing the entire window; both 
	 * the board and the status bar.  There are no arguments or 
	 * return value.
	 * 
	 * This function works by making two calls to other functions.  
	 * The global variables in this file currentlevel and lives are 
	 * passed to the Furball function statusbar, which redraws the 
	 * status bar with this information.  The function drawboard is 
	 * then called to draw the entire board on the screen.
	 */
	
	void drawwindow()
	{
		statusbar(currentlevel, lives);
		drawboard();
	}
	
	/********************************************/
	/* UPDATE BOARD                             */
	/********************************************/
	
	/* 
	 * This function has the job of drawing on the screen the tiles 
	 * on the board that have changed in the most recent move.  
	 * There are no arguments or return value.
	 * 
	 * The integer indices row and col are used to page through the 
	 * board and prevboard arrays.
	 * 
	 * This function works by using a doubly-nested for loop to 
	 * individual look at each square in the board and prevboard 
	 * arrays.  The tile in each square in the board array is 
	 * compared with the tile in the same location in the prevboard 
	 * array.  If the two tiles are not the same, this part of the 
	 * board must be updated, and a call to drawtile makes this so.
	 * 
	 * This function is the reason why the others have defined an 
	 * kept up prevboard.  With this function in place, each time 
	 * the Furball moves, the entire board is not redrawn.  Only 
	 * those squares that need to be drawn are.  This usually 
	 * includes just the square the Furball was standing on and the 
	 * square he moved into, although it can also include the 
	 * square beyond these two if the Furball pushed a block, and 
	 * the door if it opened or closed.  This method of updating 
	 * the screen keeps it from blinking in a total redraw each 
	 * time the Furball moves.
	 */
	
	void updateboard()
	{
		int row, col;
	
		for (row = 0; row <= (BOARDROWS - 1); row++)
			for (col = 0; col <= (BOARDCOLS - 1); col++)
				if (board[row][col] != prevboard[row][col])
					drawtile(board[row][col], col, row);
	}
	
	/**********************************************************/
	/* end of file game.c                                     */
	/**********************************************************/
}
