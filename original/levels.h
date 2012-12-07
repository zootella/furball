
/**********************************************************/
/*                                                        */
/*        F U R B A L L ’ S    A D V E N T U R E S        */
/*                                                        */
/**********************************************************/

/**********************************************************/
/* file levels.h                                          */
/**********************************************************/

/* 
 * This file is one of five files that make up the source code 
 * to Furball’s Adventures, a multimedia puzzle game for 
 * Windows 95 and Windows NT.  The five files including this 
 * one are levels.h, furball.h, furball.c, game.h, and game.c.  
 * These files compile into the Windows executable file 
 * Furball.exe.
 * 
 * This file contains data definitions for the program, 
 * enumeration types, and two large static matrices that hold 
 * information about the levels in the game.
 */

/********************************************/
/* DEFINITIONS                              */
/********************************************/

/* 
 * This file starts with a long list of constant definitions.  
 * First is a group of constants that deal with the size of 
 * graphics in the game and the size of the board on which the 
 * game is played.  TILESIZE, with default value 30, is the 
 * pixel size of the tiled bitmaps that make up the board.  The 
 * board had BOARDCOLS columns and BOARDROWS rows, with the 
 * default dimensions of 11 and 12, respectively.  The pixel 
 * dimensions of the board, 330 and 360, are calculated from 
 * this data.  Windows uses up 2 pixels on each side of the 
 * client area displaying a inner sunken three-dimensional 
 * boarder, and this pixel width is defined with the label 
 * TDBORDER.
 * 
 * The next group of definitions deal with constants used 
 * mostly by the windows-related functions in the file 
 * furball.c.  Two strings, APPNAME and APPNAMELONG, are 
 * defined.  The short name is used to register the window and 
 * application with the system, and the long name is used as 
 * the title in error message boxes.  At various points in the 
 * program it is necessary to define a unknown array of 
 * characters to make up a string, and the array size is kept 
 * by MAXSTRINGLENGTH.  When the Furball dies or when the level 
 * is completed, the program pauses for a moment to let the 
 * user see what happened before resetting the level or moving 
 * on.  The time of this pause is defined by SLEEPMILLI, and by 
 * default is set to 1.5 seconds.
 * 
 * The next group of constants deals with the play of the game 
 * itself.  NUMLEVELS is the number of levels currently loaded.  
 * INITIALSTARTINGLEVEL, which should be set to 0, is the level 
 * that the game starts on.  LIVESATSTART, with default value 
 * 2, is the number of extra Furballs the user has at the start 
 * of each new game.  The integer hour values of 6 and 20 for 
 * DAWN and DUSK are used in the night and day feature of the 
 * program to make dawn happen at 6:00 AM as determined by the 
 * local time on the user’s computer clock, and dusk happen at 
 * 8:00 PM.  The constants DAYSONGS and NIGHTSONGS tell how 
 * many day and night MIDI files have been implemented.
 * 
 * All the message boxes that do not relate to error-reporting 
 * have their text defined in the next section of statements.  
 * This allows the text in these boxes to be easily edited and 
 * reviewed from this one location.
 * 
 * The first 4 values in the section of definitions that relate 
 * to the system registry should never be changed, and are 
 * listed here only to eliminate them as magic numbers.  The 
 * last three are the default values that will be loaded into 
 * the registry the very first time the program is run on a 
 * computer.  The factory defaults of 1, 1, and 1 make the 
 * sound on, quick help displayed, and the music automatically 
 * cycle for each level and the current day state.
 * 
 * The last set of definitions will decode the two letter tile 
 * codes like "FG" into the valid enum data "FBONGRASS" in the 
 * static levelbank array.  It is much easier to edit and read 
 * the code in this array with the two letter abbreviations.
 */

/* BOARD AND WINDOW DIMENSIONS */

#define TILESIZE 30
#define BOARDCOLS 11
#define BOARDROWS 12
#define BCOLPIX (TILESIZE * BOARDCOLS) // 330
#define BROWPIX (TILESIZE * BOARDROWS) // 360
#define TDBORDER 2

/* WINDOWS CONSTANTS */

#define APPNAME "Furball"
#define APPNAMELONG "Furball's Adventures"
#define MAXSTRINGLENGTH 200
#define SLEEPMILLI 1500 // 1.5 SECONDS

/* GAME PLAY CONSTANTS */

#define NUMLEVELS 50
#define INITIALSTARTINGLEVEL 0
#define LIVESATSTART 2
#define DAWN 6  // DAWN WILL HAPPEN AT 6:00 AM
#define DUSK 20 // DUSK WILL HAPPEN AT 8:00 PM
#define DAYSONGS 10
#define NIGHTSONGS 6

/* MESSAGE BOX TEXT */

#define NEWGAMETEXT     "This will restart the game from the first level."
#define GAMEOVERTEXT    "No more Furballs remain. Game over."
#define INVALIDCODETEXT "The level code that you typed is not correct. Try typing it again."
#define DAWNTEXT        "That man who does not believe that each day contains an earlier, more sacred, and auroral hour than he has yet profaned, has despaired of life, and is pursuing a descending and darkening way.\n\n-Henry David Thoreau"
#define DUSKTEXT        "Night, the beloved. Night, when words fade and things come alive. When the destructive analysis of day is done, and all that is truly important becomes whole and sound again. When man reassembles his fragmentary self and grows with the calm of a tree.\n\n-Antoine de Saint-Exupéry"

/* REGISTRY CONSTANTS */

#define DOUBLEWORDDATA 1
#define DOUBLEWORDSIZE 4
#define DOUBLEWORDTYPE 0
#define BYTESINDWORD 4
#define DEFAULTSOUNDINT 1 // SOUND EFFECTS ON
#define DEFAULTHELPINT  1 // QUICK HELP DISPLAYED
#define DEFAULTMUSICINT 1 // CYCLE MUSIC SELECTED

/* LEVEL BANK SHORTHAND REPLACEMENTS */

#define FG FBONGRASS
#define FS FBONSINK
#define BG BOXONGRASS
#define BS BOXONSINK
#define RK ROCK
#define WL WALL
#define EN ENEMY
#define GS GRASS
#define SK SINK
#define HR HEART
#define DC DOORCLOSED
#define DO DOOROPEN

/********************************************/
/* ENUMERATION TYPES                        */
/********************************************/

/* 
 * This program defines and uses numerous enumeration data 
 * types.  The first, tile, is the data type of all the arrays 
 * which contain data about the board.  The enum types tiletype 
 * and tiledanger are used to classify the tiles for easy 
 * analysis by the functions in game.c.  The type direction is 
 * used to explain how the user has requested the Furball to 
 * move.  Each of the sound effects in the game is represented 
 * by a data value in the type soundtitle, and these names are 
 * then used to play these sounds to mark various events in the 
 * game.  Each MIDI file that the program can play has a label 
 * in the enum type music.  Data of type musiccommand is given 
 * to the function jukebox to play music based on a the current 
 * music option, or on a game event if the entire game has been 
 * finished.  Finally, the enum type daystate is used to 
 * describe whether it is day or night.
 */

/* DATA TYPES */

typedef enum {
	GRASS,		// LISTED FIRST TO HAVE THE VALUE 0
	FBONGRASS,
	FBONSINK,
	BOXONGRASS,
	BOXONSINK,
	ROCK,
	WALL,
	ENEMY,
	SINK,
	HEART,
	DOORCLOSED,
	DOOROPEN,
	OUTSIDE		// USED TO DESCRIBE A POSITION OFF THE BOARD
} tile;

typedef enum {
	BLOCKING,
	PASSING,
	FINISHING,
	PUSHABLE,
	FURBALL
} tiletype;

typedef enum {
	OPEN,
	SAFE,
	ATTACK,
	SELF
} tiledanger;

typedef enum {
	UP,
	DOWN,
	LEFT,
	RIGHT
} direction;

typedef enum {
	GETHEART,
	BOXSINK,
	DOOROPENS,
	LEVELDONE,
	KILL,
	GAMEOVER
} soundtitle;

typedef enum {

	/* OPTIONS SPECIFIED FROM THE MENU AND STORED IN THE REGISTRY */
	
	NOMUSIC     =  0,
	CYCLEMUSIC  =  1,
	ODYSSEY     =  2,
	AXLE        =  3,
	BOND        =  4,
	ISTANBUL    =  5,
	MERIDIAN    =  6,
	MISSION     =  7,
	PARADISE    =  8,
	PEANUTS     =  9,
	POPCORN     = 10,
	WIPEOUT     = 11,
	BOHEMIAN    = 12,
	CANNON      = 13,
	CHILDREN    = 14,
	DEMON       = 15,
	LION        = 16,
	MAD         = 17,

	/* ADDITIONAL SONG NAME NOT FOR USE AS A MUSIC OPTION */

	THRONE

} music;

typedef enum {
	STOP,
	PLAY,
	WON
} musiccommand;

typedef enum {
	DAY,
	NIGHT
} daystate;

/********************************************/
/* LEVEL DATA                               */
/********************************************/

/* 
 * This program uses a three-dimensional static array called 
 * levelbank to hold all the levels.  This array holds data of 
 * type tile, as defined above.  The first index tabs through 
 * the individual levels; 0 is the first level, 1 is the 
 * following level, and so on.  The second and third indices 
 * locate one specific location in the level.  The levelbank 
 * array can be thought of as an array of levels, as each level 
 * is represented by a subordinate 2-D array.
 * 
 * At the end of the file is a one-dimensional static array of 
 * strings called levelcode.  This array holds the random but 
 * unchanging three-letter level codes for each level.  At 
 * index 0 is the code for the first level, at index 1 the code 
 * for the second, and so on.
 */

/* LEVELS */

static tile levelbank[NUMLEVELS][BOARDROWS][BOARDCOLS] =
{

	// 1, SPECIAL, FIRST

	{
		{WL, WL, WL, WL, WL, DC, WL, WL, WL, WL, WL},
		{GS, GS, RK, RK, GS, GS, GS, RK, RK, GS, GS},
		{GS, GS, RK, RK, GS, GS, GS, RK, RK, GS, GS},
		{GS, GS, RK, GS, GS, GS, GS, GS, RK, GS, GS},
		{GS, GS, GS, GS, GS, HR, GS, GS, GS, GS, GS},
		{EN, GS, RK, GS, GS, GS, GS, GS, RK, GS, EN},
		{GS, GS, GS, GS, GS, HR, GS, GS, GS, GS, GS},
		{EN, GS, RK, GS, GS, GS, GS, GS, RK, GS, EN},
		{GS, GS, GS, GS, GS, HR, GS, GS, GS, GS, GS},
		{GS, GS, RK, GS, GS, GS, GS, GS, RK, GS, GS},
		{GS, GS, RK, RK, GS, GS, GS, RK, RK, GS, GS},
		{GS, GS, RK, RK, GS, FG, GS, RK, RK, GS, GS}
	},

	// 2, TUTORIAL, MAZE

	{
		{WL, WL, WL, WL, WL, WL, WL, WL, WL, DC, WL},
		{RK, RK, RK, RK, RK, RK, RK, RK, RK, GS, RK},
		{RK, HR, GS, GS, GS, GS, RK, GS, GS, GS, RK},
		{RK, RK, RK, RK, RK, GS, RK, GS, RK, RK, RK},
		{RK, GS, GS, GS, GS, GS, GS, GS, RK, HR, RK},
		{RK, GS, RK, RK, RK, RK, RK, GS, RK, GS, RK},
		{RK, GS, RK, GS, GS, GS, RK, GS, RK, GS, RK},
		{RK, GS, RK, GS, RK, GS, RK, GS, RK, GS, RK},
		{RK, GS, GS, GS, RK, GS, RK, GS, RK, GS, RK},
		{RK, RK, RK, RK, RK, GS, RK, GS, RK, GS, RK},
		{FG, GS, GS, GS, GS, GS, RK, GS, GS, GS, RK},
		{RK, RK, RK, RK, RK, RK, RK, RK, RK, RK, RK}
	},

	// 3, TUTORIAL, COLLECT HEARTS

	{
		{DC, WL, WL, WL, WL, WL, WL, WL, WL, WL, WL},
		{FG, GS, GS, GS, GS, GS, GS, GS, GS, GS, GS},
		{RK, RK, RK, RK, RK, RK, RK, RK, RK, GS, RK},
		{RK, RK, RK, RK, GS, GS, GS, RK, RK, GS, RK},
		{RK, RK, RK, RK, GS, RK, GS, GS, GS, GS, RK},
		{RK, RK, RK, RK, GS, RK, RK, RK, RK, RK, RK},
		{RK, RK, RK, RK, GS, GS, GS, RK, RK, RK, RK},
		{RK, RK, RK, RK, RK, RK, GS, RK, RK, RK, RK},
		{RK, RK, GS, GS, GS, GS, GS, RK, HR, HR, RK},
		{RK, RK, GS, RK, RK, RK, RK, RK, HR, HR, RK},
		{RK, RK, GS, GS, GS, GS, GS, GS, HR, HR, RK},
		{RK, RK, RK, RK, RK, RK, RK, RK, RK, RK, RK}
	},

	// 4, TUTORIAL, AVOID ENEMY

	{
		{WL, WL, WL, WL, WL, DC, WL, WL, WL, WL, WL},
		{GS, GS, GS, RK, GS, GS, GS, GS, GS, GS, GS},
		{GS, GS, GS, GS, GS, GS, GS, GS, GS, GS, GS},
		{GS, GS, GS, GS, GS, GS, GS, GS, GS, GS, GS},
		{RK, GS, GS, EN, GS, GS, GS, RK, GS, GS, GS},
		{GS, GS, GS, BG, GS, GS, GS, GS, GS, GS, GS},
		{GS, GS, GS, GS, GS, HR, GS, GS, GS, GS, GS},
		{GS, GS, GS, GS, GS, GS, GS, BG, GS, GS, GS},
		{GS, GS, GS, RK, GS, GS, GS, EN, GS, GS, RK},
		{GS, GS, GS, GS, GS, GS, GS, GS, GS, GS, GS},
		{GS, GS, GS, GS, GS, GS, GS, GS, GS, GS, GS},
		{GS, GS, GS, GS, GS, FG, GS, RK, GS, GS, GS}
	},

	// 5, TUTORIAL, PUSH BOX INTO SINK

	{
		{WL, WL, WL, WL, WL, DC, WL, WL, WL, WL, WL},
		{GS, GS, GS, GS, GS, GS, GS, GS, GS, GS, GS},
		{GS, GS, GS, GS, GS, GS, GS, GS, GS, GS, GS},
		{GS, GS, GS, GS, GS, GS, GS, GS, GS, GS, GS},
		{GS, BG, GS, BG, GS, GS, GS, GS, GS, GS, GS},
		{GS, GS, GS, GS, GS, GS, GS, SK, SK, GS, GS},
		{GS, BG, GS, BG, GS, GS, GS, SK, SK, GS, GS},
		{GS, GS, GS, GS, GS, GS, GS, SK, SK, GS, GS},
		{GS, BG, GS, BG, GS, GS, GS, GS, GS, GS, GS},
		{GS, GS, GS, GS, GS, GS, GS, GS, GS, GS, GS},
		{GS, GS, GS, GS, GS, GS, GS, GS, GS, GS, GS},
		{GS, GS, GS, GS, GS, FG, GS, GS, GS, GS, GS}
	},

	// 6, TUTORIAL, MOVE BOX TO GET OUT

	{
		{WL, WL, WL, WL, WL, DC, WL, WL, WL, WL, WL},
		{GS, GS, GS, GS, GS, GS, GS, GS, GS, GS, GS},
		{GS, GS, GS, GS, GS, GS, GS, GS, GS, GS, GS},
		{GS, GS, GS, GS, GS, GS, GS, GS, GS, GS, GS},
		{GS, GS, GS, GS, RK, GS, RK, GS, GS, GS, GS},
		{GS, RK, RK, RK, RK, SK, RK, RK, RK, RK, GS},
		{GS, RK, GS, GS, RK, GS, RK, GS, GS, RK, GS},
		{GS, RK, GS, GS, GS, GS, GS, GS, GS, RK, GS},
		{GS, RK, GS, FG, GS, GS, GS, BG, GS, RK, GS},
		{GS, RK, GS, GS, GS, GS, GS, GS, GS, RK, GS},
		{GS, RK, RK, RK, RK, RK, RK, RK, RK, RK, GS},
		{GS, GS, GS, GS, GS, GS, GS, GS, GS, GS, GS}
	},

	// 7, TUTORIAL, USE BOX TO BLOCK ENEMY

	{
		{WL, WL, WL, WL, WL, DC, WL, WL, WL, WL, WL},
		{GS, GS, GS, GS, GS, GS, GS, GS, GS, GS, GS},
		{GS, GS, GS, GS, GS, GS, GS, GS, GS, GS, GS},
		{GS, GS, GS, GS, GS, GS, GS, GS, GS, GS, GS},
		{RK, RK, GS, GS, GS, GS, GS, GS, GS, GS, GS},
		{RK, RK, RK, RK, RK, RK, GS, GS, GS, RK, RK},
		{RK, RK, RK, RK, RK, EN, GS, GS, GS, HR, RK},
		{RK, RK, RK, RK, RK, RK, GS, GS, GS, RK, RK},
		{RK, RK, GS, GS, GS, GS, GS, GS, GS, GS, GS},
		{GS, GS, GS, GS, GS, GS, GS, GS, GS, GS, GS},
		{GS, GS, GS, FG, GS, BG, GS, GS, GS, GS, GS},
		{GS, GS, GS, GS, GS, GS, GS, GS, GS, GS, GS}
	},

	// 8, TUTORIAL, COLLECT HEART BY PUSING OVER BOX

	{
		{WL, WL, WL, WL, WL, WL, WL, WL, WL, WL, DC},
		{GS, GS, GS, GS, GS, GS, GS, GS, GS, GS, GS},
		{GS, GS, GS, GS, GS, GS, GS, GS, GS, GS, GS},
		{GS, GS, GS, RK, RK, GS, RK, GS, RK, SK, RK},
		{GS, BG, GS, RK, RK, GS, RK, SK, RK, HR, RK},
		{GS, BG, GS, RK, RK, SK, RK, HR, RK, EN, RK},
		{GS, BG, GS, RK, RK, HR, RK, EN, RK, RK, RK},
		{GS, FG, GS, RK, RK, EN, RK, RK, RK, RK, RK},
		{GS, BG, GS, RK, RK, RK, RK, RK, RK, RK, RK},
		{GS, BG, GS, RK, RK, RK, RK, RK, RK, RK, RK},
		{GS, BG, GS, RK, RK, RK, RK, RK, RK, RK, RK},
		{GS, GS, GS, RK, RK, RK, RK, RK, RK, RK, RK}
	},

	// 9, TUTORIAL, SIMPLE LOGIC WALKAROUND

	{
		{WL, WL, WL, WL, WL, WL, WL, WL, WL, WL, DC},
		{GS, GS, GS, GS, GS, GS, GS, GS, GS, GS, GS},
		{GS, GS, GS, GS, GS, GS, GS, GS, GS, GS, GS},
		{GS, GS, GS, GS, GS, GS, HR, GS, BG, GS, GS},
		{GS, GS, GS, GS, GS, GS, GS, GS, GS, GS, GS},
		{RK, GS, GS, GS, RK, RK, GS, GS, GS, GS, RK},
		{RK, GS, GS, GS, EN, RK, RK, RK, RK, RK, RK},
		{RK, GS, GS, GS, RK, RK, GS, GS, GS, GS, RK},
		{GS, GS, GS, GS, GS, GS, GS, GS, GS, GS, GS},
		{GS, GS, GS, GS, GS, GS, SK, GS, BG, GS, GS},
		{GS, GS, GS, GS, GS, GS, GS, GS, GS, GS, GS},
		{GS, GS, GS, GS, GS, GS, GS, GS, GS, GS, FG}
	},

	// 10, A, MEADOW

	{
		{WL, WL, DC, WL, WL, WL, WL, WL, WL, WL, WL},
		{GS, GS, GS, RK, GS, GS, HR, RK, GS, GS, EN},
		{GS, HR, GS, GS, GS, GS, GS, GS, GS, GS, GS},
		{EN, GS, GS, GS, RK, GS, RK, GS, BG, GS, GS},
		{RK, GS, GS, RK, RK, EN, RK, RK, GS, GS, RK},
		{EN, GS, RK, RK, GS, GS, GS, RK, RK, GS, HR},
		{GS, GS, GS, GS, GS, GS, GS, GS, GS, GS, HR},
		{GS, GS, RK, RK, BG, GS, GS, RK, RK, GS, HR},
		{GS, GS, GS, RK, RK, GS, RK, RK, EN, GS, HR},
		{GS, GS, BG, GS, RK, GS, RK, EN, GS, GS, GS},
		{GS, FG, GS, BG, GS, GS, GS, GS, GS, RK, GS},
		{EN, GS, GS, RK, GS, GS, RK, GS, GS, GS, EN}
	},

	// 11, A, BUILDING

	{
		{WL, WL, WL, WL, WL, WL, WL, WL, WL, WL, DC},
		{GS, GS, GS, SK, GS, GS, GS, GS, GS, GS, GS},
		{GS, GS, GS, GS, GS, RK, RK, RK, RK, RK, RK},
		{GS, GS, RK, RK, RK, RK, HR, HR, HR, HR, RK},
		{GS, GS, RK, BG, BG, BG, HR, HR, HR, HR, RK},
		{GS, GS, RK, BG, GS, BG, BG, BG, BG, BG, RK},
		{GS, GS, RK, BG, GS, BG, GS, GS, GS, BG, RK},
		{GS, GS, HR, BG, BG, BG, BG, BG, BG, BG, RK},
		{GS, FG, GS, GS, BG, GS, BG, GS, GS, GS, RK},
		{GS, GS, BG, BG, BG, BG, BG, GS, RK, RK, RK},
		{GS, GS, RK, RK, RK, RK, RK, RK, RK, EN, EN},
		{GS, GS, GS, GS, GS, GS, GS, GS, GS, EN, EN}
	},

	// 12, A, PYRIMID

	{
		{WL, WL, WL, WL, WL, WL, WL, WL, WL, WL, DC},
		{GS, GS, GS, GS, GS, HR, GS, HR, GS, HR, GS},
		{GS, RK, GS, GS, GS, HR, HR, HR, HR, HR, GS},
		{RK, RK, RK, GS, GS, HR, HR, GS, HR, GS, GS},
		{RK, RK, RK, BG, GS, HR, GS, GS, GS, GS, GS},
		{RK, RK, GS, GS, BG, HR, GS, GS, GS, GS, GS},
		{RK, GS, GS, GS, FG, RK, GS, GS, GS, GS, GS},
		{GS, GS, GS, GS, RK, RK, RK, GS, GS, GS, GS},
		{GS, GS, GS, RK, RK, RK, RK, RK, GS, GS, GS},
		{GS, GS, RK, RK, RK, RK, RK, RK, RK, GS, GS},
		{GS, SK, SK, RK, RK, RK, HR, HR, RK, RK, GS},
		{RK, RK, GS, GS, GS, GS, HR, HR, RK, RK, RK}
	},

	// 13, A, PACKING

	{
		{WL, WL, WL, WL, WL, DC, WL, WL, WL, WL, WL},
		{GS, GS, GS, GS, GS, GS, GS, GS, GS, GS, GS},
		{GS, GS, GS, GS, GS, GS, GS, GS, GS, GS, GS},
		{GS, GS, GS, BG, GS, GS, BG, GS, GS, BG, GS},
		{GS, FG, GS, GS, GS, GS, GS, GS, GS, GS, GS},
		{GS, GS, GS, BG, GS, GS, BG, GS, GS, BG, GS},
		{GS, GS, GS, GS, GS, GS, GS, GS, GS, GS, GS},
		{GS, RK, RK, RK, RK, GS, RK, RK, RK, RK, GS},
		{GS, RK, SK, SK, RK, GS, RK, SK, RK, HR, GS},
		{GS, RK, SK, SK, RK, GS, RK, SK, RK, RK, GS},
		{GS, GS, GS, GS, GS, GS, GS, GS, GS, GS, GS},
		{GS, GS, GS, GS, GS, GS, GS, GS, GS, GS, GS}
	},

	// 14, A, ROOMS

	{
		{WL, DC, WL, WL, WL, WL, WL, WL, WL, WL, WL},
		{RK, GS, RK, RK, RK, RK, RK, RK, RK, RK, RK},
		{RK, HR, RK, HR, GS, GS, GS, GS, GS, HR, RK},
		{RK, GS, RK, GS, RK, RK, RK, RK, RK, GS, EN},
		{RK, HR, RK, HR, GS, GS, GS, GS, GS, HR, RK},
		{RK, GS, RK, RK, RK, RK, RK, RK, RK, GS, RK},
		{RK, HR, GS, HR, GS, HR, GS, HR, RK, HR, RK},
		{EN, GS, RK, RK, RK, RK, RK, GS, RK, GS, RK},
		{RK, GS, RK, HR, GS, HR, RK, HR, GS, HR, RK},
		{RK, GS, RK, GS, RK, RK, RK, GS, RK, GS, RK},
		{RK, GS, GS, HR, GS, HR, GS, HR, GS, HR, FG},
		{RK, RK, EN, RK, RK, RK, RK, RK, EN, RK, RK}
	},

	// 15, B, MEDOW

	{
		{WL, WL, WL, WL, WL, WL, WL, DC, WL, WL, WL},
		{RK, RK, RK, RK, GS, GS, GS, GS, GS, GS, GS},
		{RK, RK, RK, GS, GS, BG, GS, BG, GS, GS, GS},
		{RK, RK, SK, GS, GS, GS, GS, GS, GS, GS, HR},
		{RK, GS, BG, GS, GS, RK, RK, RK, RK, EN, RK},
		{GS, GS, FG, GS, RK, RK, RK, RK, RK, RK, RK},
		{GS, GS, GS, RK, RK, RK, RK, RK, RK, RK, RK},
		{GS, GS, GS, EN, RK, RK, RK, RK, RK, RK, RK},
		{GS, GS, GS, EN, RK, RK, RK, RK, RK, RK, RK},
		{GS, GS, GS, RK, RK, RK, HR, HR, HR, HR, HR},
		{GS, GS, GS, SK, GS, GS, HR, BG, BG, BG, HR},
		{GS, GS, GS, RK, RK, RK, HR, HR, HR, HR, HR}
	},

	// 16, B, MEADOW

	{
		{WL, WL, WL, WL, WL, DC, WL, WL, WL, WL, WL},
		{GS, GS, GS, EN, GS, GS, GS, GS, RK, BS, BS},
		{GS, GS, GS, GS, GS, GS, HR, GS, RK, BS, BS},
		{EN, GS, GS, GS, GS, GS, GS, GS, RK, BS, BS},
		{GS, GS, GS, GS, GS, FG, GS, GS, RK, BS, BS},
		{GS, GS, GS, GS, BG, GS, GS, GS, RK, BS, BS},
		{GS, HR, BG, GS, GS, GS, GS, GS, RK, BS, BS},
		{GS, GS, GS, GS, GS, GS, GS, GS, RK, BS, BS},
		{RK, RK, RK, RK, RK, RK, RK, RK, GS, RK, RK},
		{EN, EN, EN, EN, EN, EN, EN, EN, RK, GS, GS},
		{EN, EN, EN, EN, EN, EN, EN, EN, RK, GS, GS},
		{EN, EN, EN, EN, EN, EN, EN, EN, RK, GS, GS}
	},

	// 17, B, BUILDING

	{
		{WL, WL, WL, WL, WL, DC, WL, WL, WL, WL, WL},
		{RK, GS, GS, GS, GS, GS, GS, GS, GS, GS, RK},
		{RK, GS, GS, GS, BG, FG, BG, GS, GS, GS, RK},
		{GS, GS, RK, RK, RK, GS, RK, RK, RK, GS, GS},
		{GS, GS, RK, GS, GS, GS, GS, GS, RK, GS, GS},
		{GS, GS, RK, GS, GS, RK, GS, GS, RK, GS, GS},
		{GS, GS, GS, GS, GS, GS, GS, GS, GS, GS, GS},
		{GS, GS, RK, GS, GS, EN, GS, GS, RK, EN, GS},
		{GS, EN, RK, GS, GS, RK, GS, GS, RK, GS, GS},
		{GS, GS, RK, RK, GS, GS, GS, RK, RK, GS, GS},
		{GS, GS, GS, GS, GS, GS, GS, GS, GS, GS, GS},
		{GS, GS, GS, RK, RK, HR, RK, RK, GS, GS, GS}
	},

	// 18, B, PYRAMID

	{
		{WL, WL, WL, DC, WL, WL, WL, WL, WL, WL, WL},
		{RK, GS, GS, GS, GS, GS, RK, RK, GS, GS, GS},
		{RK, RK, GS, GS, GS, GS, RK, RK, GS, GS, GS},
		{RK, RK, RK, GS, GS, BG, RK, RK, BG, GS, GS},
		{RK, RK, RK, GS, BG, GS, GS, GS, GS, BG, GS},
		{RK, RK, GS, GS, GS, GS, GS, GS, GS, GS, GS},
		{RK, RK, GS, GS, GS, GS, GS, GS, GS, GS, GS},
		{RK, RK, BG, BG, GS, GS, EN, EN, GS, GS, GS},
		{RK, RK, GS, GS, BG, GS, RK, RK, GS, GS, GS},
		{RK, RK, GS, BG, GS, RK, RK, RK, RK, GS, GS},
		{RK, RK, BG, GS, RK, RK, RK, RK, SK, SK, GS},
		{RK, RK, FG, RK, RK, HR, HR, HR, HR, RK, RK}
	},

	// 19, B, PACKING

	{
		{WL, WL, WL, WL, WL, DC, WL, WL, WL, WL, WL},
		{GS, RK, GS, GS, GS, GS, GS, GS, GS, RK, GS},
		{RK, GS, GS, GS, GS, GS, GS, GS, GS, GS, RK},
		{GS, GS, BG, HR, BG, HR, BG, HR, BG, GS, GS},
		{GS, GS, HR, BG, HR, BG, HR, BG, HR, GS, GS},
		{GS, GS, BG, HR, BG, HR, BG, HR, BG, GS, GS},
		{GS, GS, GS, GS, GS, GS, GS, GS, GS, GS, GS},
		{GS, GS, GS, RK, SK, SK, SK, RK, GS, GS, GS},
		{GS, GS, RK, SK, SK, FS, SK, SK, RK, GS, GS},
		{GS, GS, GS, RK, SK, SK, SK, RK, GS, GS, GS},
		{BG, GS, GS, GS, GS, GS, GS, GS, GS, GS, BG},
		{GS, BG, GS, GS, GS, GS, GS, GS, GS, BG, GS}
	},

	// 20, B, ROOMS

	{
		{WL, WL, WL, WL, WL, DC, WL, WL, WL, WL, WL},
		{RK, RK, RK, RK, RK, GS, RK, RK, EN, RK, RK},
		{RK, GS, GS, FG, RK, GS, RK, EN, GS, RK, RK},
		{RK, GS, BG, GS, GS, GS, GS, GS, GS, GS, EN},
		{RK, GS, BG, GS, RK, RK, GS, RK, GS, RK, RK},
		{RK, GS, BG, GS, GS, HR, HR, RK, GS, RK, RK},
		{RK, RK, GS, RK, RK, HR, HR, RK, GS, RK, RK},
		{RK, RK, GS, RK, RK, RK, RK, RK, GS, RK, RK},
		{RK, GS, GS, RK, SK, RK, RK, GS, GS, GS, RK},
		{RK, GS, GS, GS, GS, GS, GS, GS, GS, HR, RK},
		{RK, RK, RK, RK, GS, GS, RK, GS, GS, GS, RK},
		{RK, RK, RK, RK, RK, RK, RK, RK, RK, RK, RK}
	},

	// 21, B, ROOMS

	{
		{WL, WL, WL, WL, WL, WL, WL, WL, WL, DC, WL},
		{RK, RK, GS, EN, GS, GS, EN, GS, GS, GS, GS},
		{RK, RK, RK, GS, RK, RK, GS, RK, RK, GS, GS},
		{HR, RK, RK, GS, RK, RK, GS, RK, RK, GS, RK},
		{GS, RK, GS, GS, RK, RK, GS, RK, RK, GS, GS},
		{HR, GS, GS, GS, GS, EN, GS, GS, GS, GS, GS},
		{GS, RK, GS, GS, RK, RK, GS, RK, RK, GS, GS},
		{HR, RK, RK, GS, RK, RK, GS, RK, RK, GS, RK},
		{RK, RK, RK, GS, RK, RK, GS, RK, RK, GS, GS},
		{RK, FG, BG, GS, BG, GS, GS, GS, GS, GS, GS},
		{RK, GS, BG, GS, BG, GS, GS, GS, GS, SK, GS},
		{RK, GS, GS, GS, GS, GS, RK, RK, RK, GS, RK}
	},

	// 22, C, MEADOW

	{
		{WL, WL, WL, WL, WL, DC, WL, WL, WL, WL, WL},
		{GS, GS, GS, EN, BG, GS, BG, EN, GS, GS, EN},
		{GS, GS, GS, GS, GS, GS, GS, GS, GS, GS, HR},
		{GS, GS, GS, GS, GS, FG, GS, GS, GS, GS, HR},
		{GS, RK, BG, GS, GS, GS, GS, GS, GS, GS, HR},
		{RK, GS, GS, RK, BG, GS, GS, GS, GS, GS, HR},
		{GS, HR, RK, GS, GS, RK, HR, GS, GS, GS, HR},
		{GS, GS, GS, HR, RK, GS, GS, RK, BG, GS, HR},
		{GS, GS, GS, GS, GS, BG, RK, GS, GS, RK, HR},
		{GS, GS, GS, GS, GS, GS, GS, HR, RK, GS, HR},
		{GS, GS, GS, GS, GS, GS, GS, GS, GS, HR, RK},
		{EN, GS, GS, EN, GS, GS, GS, GS, GS, GS, GS}
	},

	// 23, C, MEADOW

	{
		{DC, WL, WL, WL, WL, WL, WL, WL, WL, WL, WL},
		{GS, GS, GS, GS, RK, EN, RK, GS, RK, HR, EN},
		{GS, GS, GS, GS, GS, GS, GS, GS, GS, GS, RK},
		{RK, RK, GS, GS, GS, GS, GS, GS, GS, GS, RK},
		{EN, GS, GS, GS, GS, GS, GS, RK, GS, GS, GS},
		{EN, GS, GS, GS, GS, RK, GS, GS, GS, GS, GS},
		{EN, GS, RK, HR, GS, GS, GS, GS, RK, GS, RK},
		{EN, GS, GS, GS, GS, HR, RK, GS, GS, GS, RK},
		{RK, GS, GS, GS, GS, RK, GS, GS, GS, GS, RK},
		{RK, RK, BG, BG, GS, GS, GS, GS, HR, RK, RK},
		{GS, GS, GS, GS, GS, GS, GS, GS, GS, BG, GS},
		{FG, RK, GS, GS, RK, EN, RK, GS, GS, GS, GS}
	},

	// 24, C, BUILDING

	{
		{WL, WL, WL, WL, WL, WL, WL, WL, WL, DC, WL},
		{GS, GS, GS, GS, GS, GS, GS, GS, GS, GS, GS},
		{GS, GS, GS, GS, GS, RK, RK, RK, RK, GS, EN},
		{GS, RK, RK, RK, RK, RK, GS, GS, GS, GS, GS},
		{GS, RK, GS, GS, GS, RK, HR, GS, RK, GS, RK},
		{GS, RK, GS, FG, GS, BS, GS, GS, RK, GS, GS},
		{GS, RK, RK, RK, BS, RK, BS, RK, RK, RK, GS},
		{GS, GS, RK, GS, GS, BS, GS, GS, GS, RK, GS},
		{GS, GS, RK, GS, GS, RK, GS, GS, GS, RK, GS},
		{GS, GS, RK, GS, GS, RK, RK, RK, RK, RK, GS},
		{GS, GS, RK, RK, RK, RK, GS, GS, GS, GS, GS},
		{GS, GS, GS, GS, GS, GS, GS, GS, GS, GS, GS}
	},

	// 25, C, BUILDING

	{
		{WL, WL, WL, WL, WL, DC, WL, WL, WL, WL, WL},
		{GS, GS, GS, GS, GS, GS, GS, GS, GS, GS, GS},
		{GS, GS, GS, GS, GS, GS, GS, GS, GS, GS, GS},
		{GS, GS, GS, GS, GS, GS, GS, GS, GS, GS, GS},
		{GS, GS, RK, RK, RK, BS, RK, RK, RK, GS, GS},
		{GS, GS, RK, GS, GS, GS, GS, GS, RK, GS, GS},
		{GS, GS, BS, GS, GS, HR, GS, GS, BS, GS, GS},
		{GS, RK, RK, BG, RK, RK, RK, BS, RK, RK, GS},
		{GS, RK, GS, GS, GS, RK, GS, GS, GS, RK, GS},
		{GS, BS, GS, FG, GS, BS, GS, HR, GS, BS, GS},
		{GS, RK, RK, RK, RK, RK, RK, RK, RK, RK, GS},
		{GS, GS, GS, GS, GS, GS, GS, GS, GS, GS, GS}
	},

	// 26, C, PYRIMID

	{
		{WL, WL, WL, WL, WL, WL, WL, WL, WL, WL, DC},
		{GS, GS, GS, GS, GS, GS, GS, GS, GS, GS, HR},
		{GS, GS, GS, GS, GS, GS, GS, GS, GS, GS, RK},
		{GS, GS, GS, GS, GS, GS, GS, GS, EN, BS, RK},
		{GS, GS, GS, GS, GS, GS, GS, EN, BG, RK, RK},
		{GS, GS, GS, GS, GS, GS, EN, BG, BS, RK, RK},
		{GS, GS, BG, GS, GS, EN, BG, BG, RK, RK, RK},
		{GS, BG, GS, BG, GS, BG, BG, BS, RK, RK, RK},
		{BG, GS, BG, GS, BG, BG, BG, RK, RK, RK, RK},
		{GS, BG, GS, BG, BG, BG, BS, RK, RK, RK, RK},
		{GS, GS, BG, BG, BG, BG, RK, RK, RK, RK, RK},
		{FG, BG, BG, BG, BG, BS, RK, RK, RK, RK, RK}
	},

	// 27, C, PACKING

	{
		{WL, WL, WL, WL, WL, DC, WL, WL, WL, WL, WL},
		{GS, GS, GS, EN, RK, HR, RK, HR, GS, GS, GS},
		{GS, GS, BG, GS, GS, GS, GS, GS, BG, GS, GS},
		{GS, BG, GS, BG, GS, FG, GS, BG, GS, BG, GS},
		{HR, GS, GS, RK, RK, RK, GS, RK, GS, GS, EN},
		{RK, GS, GS, RK, SK, SK, SK, GS, GS, GS, RK},
		{HR, GS, GS, RK, SK, RK, SK, RK, GS, GS, HR},
		{RK, GS, GS, GS, SK, SK, SK, RK, GS, GS, RK},
		{EN, GS, GS, RK, GS, RK, RK, RK, GS, GS, HR},
		{GS, BG, GS, BG, GS, GS, GS, BG, GS, BG, GS},
		{GS, GS, BG, GS, GS, GS, GS, GS, BG, GS, GS},
		{GS, GS, GS, HR, RK, HR, RK, EN, GS, GS, GS}
	},

	// 28, C, ROOMS

	{
		{WL, WL, WL, WL, WL, WL, WL, DC, WL, WL, WL},
		{GS, GS, GS, GS, GS, RK, RK, GS, RK, RK, RK},
		{GS, BG, BS, BG, GS, RK, RK, GS, GS, GS, RK},
		{GS, GS, GS, GS, FG, RK, RK, RK, RK, GS, RK},
		{RK, RK, GS, RK, RK, RK, RK, GS, GS, GS, RK},
		{RK, RK, BG, RK, HR, HR, RK, GS, RK, RK, RK},
		{RK, RK, GS, RK, GS, GS, GS, GS, GS, GS, EN},
		{GS, GS, GS, SK, GS, GS, RK, HR, GS, RK, RK},
		{GS, RK, GS, RK, GS, GS, GS, GS, GS, RK, RK},
		{GS, GS, GS, RK, RK, RK, RK, SK, RK, RK, RK},
		{RK, RK, GS, RK, GS, GS, BG, GS, GS, GS, RK},
		{RK, RK, EN, RK, HR, HR, HR, HR, HR, HR, RK}
	},

	// 29, C, ROOMS

	{
		{WL, WL, DC, WL, WL, WL, WL, WL, WL, WL, WL},
		{EN, GS, GS, GS, EN, RK, HR, GS, GS, GS, HR},
		{GS, GS, FG, GS, GS, RK, GS, BG, GS, BG, GS},
		{GS, GS, GS, GS, GS, RK, GS, GS, GS, GS, GS},
		{RK, RK, GS, RK, RK, RK, RK, RK, GS, RK, RK},
		{GS, GS, GS, RK, RK, GS, GS, RK, GS, GS, GS},
		{GS, GS, GS, GS, GS, HR, GS, RK, GS, GS, GS},
		{GS, GS, GS, RK, RK, GS, GS, GS, GS, GS, GS},
		{GS, GS, GS, RK, RK, RK, RK, RK, GS, GS, GS},
		{GS, GS, GS, GS, GS, GS, RK, RK, GS, GS, GS},
		{GS, GS, GS, RK, GS, HR, GS, GS, GS, GS, GS},
		{GS, GS, GS, RK, GS, GS, RK, RK, GS, GS, GS}
	},

	// 30, D, MEADOW

	{
		{WL, WL, WL, WL, WL, WL, WL, WL, WL, DC, WL},
		{GS, GS, EN, GS, GS, GS, RK, EN, RK, GS, HR},
		{GS, GS, GS, GS, RK, GS, GS, GS, GS, GS, GS},
		{GS, BG, GS, GS, GS, GS, GS, HR, GS, GS, GS},
		{GS, GS, GS, GS, GS, RK, GS, GS, GS, GS, GS},
		{GS, BG, RK, RK, GS, RK, GS, RK, GS, GS, GS},
		{FG, GS, GS, GS, GS, RK, GS, GS, GS, GS, GS},
		{GS, BG, RK, GS, GS, RK, GS, RK, GS, GS, EN},
		{GS, GS, GS, GS, RK, GS, GS, RK, GS, GS, GS},
		{GS, BG, GS, GS, SK, GS, GS, GS, GS, GS, GS},
		{GS, GS, GS, RK, EN, GS, GS, RK, GS, GS, GS},
		{GS, GS, EN, GS, EN, GS, GS, GS, GS, GS, GS}
	},

	// 31, D, MEADOW

	{
		{WL, WL, WL, WL, WL, DC, WL, WL, WL, WL, WL},
		{SK, GS, RK, EN, GS, GS, GS, EN, RK, GS, BS},
		{SK, GS, EN, GS, GS, GS, GS, GS, EN, GS, SK},
		{SK, GS, GS, GS, GS, GS, GS, GS, GS, GS, SK},
		{SK, GS, GS, BG, GS, BG, GS, BG, GS, GS, SK},
		{SK, GS, BG, GS, BG, GS, BG, GS, BG, GS, SK},
		{GS, GS, GS, BG, GS, BG, GS, BG, GS, GS, GS},
		{GS, GS, BG, GS, BG, FG, BG, GS, BG, GS, GS},
		{GS, GS, GS, BG, GS, BG, GS, BG, GS, GS, GS},
		{RK, GS, BG, GS, HR, GS, HR, GS, BG, GS, RK},
		{RK, GS, GS, BG, GS, BG, GS, BG, GS, GS, RK},
		{RK, RK, GS, HR, EN, HR, EN, HR, GS, RK, RK}
	},

	// 32, D, MEADOW

	{
		{WL, WL, WL, WL, WL, WL, WL, WL, WL, WL, DC},
		{GS, GS, GS, GS, GS, GS, GS, RK, GS, BG, GS},
		{GS, GS, GS, GS, GS, GS, GS, GS, RK, GS, GS},
		{GS, GS, GS, RK, RK, GS, GS, GS, GS, RK, GS},
		{GS, GS, RK, GS, HR, RK, GS, GS, GS, GS, GS},
		{GS, GS, GS, GS, GS, GS, GS, GS, GS, FG, GS},
		{GS, GS, RK, GS, HR, SK, GS, EN, RK, GS, GS},
		{GS, RK, EN, GS, SK, HR, GS, RK, GS, GS, GS},
		{RK, GS, GS, GS, GS, GS, GS, GS, BG, BG, GS},
		{GS, RK, GS, GS, RK, EN, GS, GS, GS, BG, GS},
		{GS, GS, RK, GS, GS, RK, GS, GS, BG, BG, GS},
		{GS, GS, GS, GS, GS, GS, RK, GS, GS, GS, GS}
	},

	// 33, D, MEADOW

	{
		{WL, WL, WL, WL, WL, DC, WL, WL, WL, WL, WL},
		{EN, SK, GS, SK, GS, GS, GS, SK, GS, SK, EN},
		{RK, EN, GS, SK, GS, GS, GS, SK, GS, EN, RK},
		{RK, RK, EN, SK, GS, GS, GS, SK, EN, RK, RK},
		{RK, RK, RK, HR, GS, GS, GS, HR, RK, RK, RK},
		{RK, RK, RK, RK, HR, GS, HR, RK, RK, RK, RK},
		{RK, RK, RK, RK, RK, GS, RK, RK, RK, RK, RK},
		{GS, GS, BG, GS, GS, GS, GS, GS, BG, GS, GS},
		{GS, GS, BG, GS, GS, GS, GS, GS, BG, GS, GS},
		{GS, BG, HR, BG, GS, FG, GS, BG, HR, BG, GS},
		{GS, GS, BG, GS, GS, GS, GS, GS, BG, GS, GS},
		{GS, GS, BG, GS, RK, RK, RK, GS, BG, GS, GS}
	},

	// 34, D, BUILDING

	{
		{WL, WL, WL, WL, WL, WL, WL, DC, WL, WL, WL},
		{RK, RK, GS, GS, GS, GS, GS, GS, GS, GS, GS},
		{RK, GS, GS, GS, GS, GS, GS, FG, GS, GS, GS},
		{GS, GS, GS, SK, RK, RK, GS, GS, GS, GS, GS},
		{GS, GS, SK, RK, GS, EN, RK, GS, RK, RK, RK},
		{GS, GS, RK, HR, GS, GS, GS, GS, GS, GS, RK},
		{GS, GS, RK, HR, HR, GS, GS, RK, RK, GS, RK},
		{GS, GS, SK, RK, HR, HR, RK, GS, GS, GS, RK},
		{GS, GS, GS, SK, RK, RK, GS, GS, RK, RK, RK},
		{RK, GS, GS, GS, GS, GS, GS, GS, GS, GS, GS},
		{RK, RK, GS, GS, GS, BG, BG, BG, BG, BG, BG},
		{RK, RK, RK, GS, GS, GS, GS, GS, GS, GS, GS}
	},

	// 35, D, PRYIMID

	{
		{WL, WL, WL, WL, WL, DC, WL, WL, WL, WL, WL},
		{RK, RK, RK, RK, RK, GS, RK, RK, RK, RK, RK},
		{RK, RK, RK, RK, GS, GS, GS, RK, RK, RK, RK},
		{RK, RK, RK, GS, GS, BG, GS, GS, RK, RK, RK},
		{RK, RK, GS, SK, BG, BG, GS, GS, GS, RK, RK},
		{RK, GS, GS, BG, SK, RK, GS, GS, GS, GS, RK},
		{GS, GS, BG, GS, RK, RK, EN, GS, GS, GS, GS},
		{RK, GS, GS, FG, HR, RK, GS, GS, GS, GS, RK},
		{RK, RK, GS, RK, EN, GS, HR, BG, GS, RK, RK},
		{RK, RK, RK, GS, GS, HR, GS, GS, RK, RK, RK},
		{RK, RK, RK, RK, GS, GS, GS, RK, RK, RK, RK},
		{RK, RK, RK, RK, RK, GS, RK, RK, RK, RK, RK}
	},

	// 36, D, PACKING

	{
		{WL, WL, WL, WL, WL, DC, WL, WL, WL, WL, WL},
		{GS, GS, GS, GS, GS, GS, GS, GS, GS, GS, GS},
		{GS, GS, GS, GS, GS, GS, GS, GS, GS, GS, GS},
		{RK, RK, GS, RK, RK, GS, RK, RK, GS, RK, RK},
		{RK, SK, HR, HR, RK, GS, RK, HR, HR, SK, RK},
		{RK, SK, SK, HR, SK, HR, SK, HR, SK, SK, RK},
		{RK, RK, RK, GS, RK, GS, RK, GS, RK, RK, RK},
		{GS, GS, GS, GS, GS, GS, GS, GS, GS, GS, GS},
		{GS, GS, BG, GS, BG, GS, BG, GS, BG, GS, GS},
		{GS, GS, GS, GS, GS, FG, GS, GS, GS, GS, GS},
		{GS, GS, BG, GS, BG, GS, BG, GS, BG, GS, GS},
		{GS, GS, GS, GS, GS, GS, GS, GS, GS, GS, GS}
	},

	// 37, D, ROOMS

	{
		{WL, WL, WL, WL, WL, DC, WL, WL, WL, WL, WL},
		{GS, GS, GS, GS, GS, GS, GS, GS, GS, GS, GS},
		{GS, BG, GS, GS, GS, GS, GS, GS, GS, BG, GS},
		{GS, BG, GS, RK, RK, SK, RK, RK, GS, BG, GS},
		{GS, GS, RK, GS, GS, GS, GS, GS, RK, GS, GS},
		{RK, RK, RK, GS, RK, SK, RK, GS, RK, RK, RK},
		{GS, GS, SK, GS, FG, SK, SK, GS, SK, GS, GS},
		{GS, GS, RK, GS, RK, SK, RK, GS, RK, GS, GS},
		{GS, BG, RK, GS, GS, GS, GS, GS, RK, BG, GS},
		{GS, GS, GS, RK, RK, SK, RK, RK, GS, GS, GS},
		{GS, BG, GS, RK, HR, HR, HR, RK, GS, BG, GS},
		{GS, GS, GS, RK, HR, HR, HR, RK, GS, GS, GS}
	},

	// 38, E, MEADOW

	{
		{WL, WL, WL, WL, WL, DC, WL, WL, WL, WL, WL},
		{HR, HR, GS, GS, GS, GS, GS, GS, GS, HR, HR},
		{HR, HR, GS, GS, GS, GS, GS, GS, GS, HR, HR},
		{GS, GS, GS, GS, GS, BG, GS, RK, GS, GS, GS},
		{GS, GS, RK, EN, RK, GS, GS, EN, GS, GS, GS},
		{GS, GS, GS, GS, GS, BG, GS, RK, GS, GS, GS},
		{GS, GS, HR, GS, BG, FG, BG, GS, HR, GS, GS},
		{GS, GS, GS, RK, GS, BG, GS, GS, GS, GS, GS},
		{GS, GS, GS, EN, GS, GS, RK, EN, RK, GS, GS},
		{GS, GS, GS, RK, GS, BG, GS, GS, GS, GS, GS},
		{HR, HR, GS, GS, GS, GS, GS, GS, GS, HR, HR},
		{HR, HR, GS, GS, GS, GS, GS, GS, GS, HR, HR}
	},

	// 39, E, MEADOW

	{
		{WL, WL, WL, WL, WL, DC, WL, WL, WL, WL, WL},
		{GS, GS, GS, GS, GS, GS, GS, GS, GS, GS, GS},
		{GS, GS, GS, BG, BG, GS, HR, HR, GS, GS, GS},
		{GS, FG, GS, BG, GS, GS, GS, HR, GS, HR, GS},
		{GS, RK, RK, RK, GS, SK, GS, RK, RK, RK, GS},
		{EN, GS, HR, GS, HR, GS, BG, GS, BG, GS, BG},
		{GS, RK, RK, RK, RK, SK, RK, RK, RK, RK, GS},
		{GS, GS, BG, GS, GS, GS, GS, GS, BG, GS, GS},
		{GS, RK, RK, RK, RK, SK, RK, RK, RK, RK, GS},
		{GS, GS, BG, GS, GS, GS, GS, GS, BG, GS, GS},
		{GS, GS, RK, RK, RK, SK, RK, RK, RK, GS, GS},
		{GS, GS, GS, GS, GS, EN, GS, GS, GS, GS, GS}
	},

	// 40, E, MEADOW

	{
		{WL, WL, WL, DC, WL, WL, WL, WL, WL, WL, WL},
		{RK, RK, GS, GS, HR, HR, HR, GS, GS, RK, RK},
		{RK, RK, RK, RK, HR, BG, HR, GS, RK, RK, RK},
		{GS, RK, RK, GS, HR, HR, HR, EN, GS, RK, GS},
		{GS, RK, GS, EN, GS, GS, BG, RK, GS, GS, GS},
		{HR, HR, BG, HR, BG, GS, GS, FG, GS, GS, GS},
		{HR, GS, GS, HR, GS, GS, GS, BG, GS, GS, GS},
		{HR, GS, GS, HR, GS, BG, GS, GS, EN, GS, GS},
		{HR, HR, HR, HR, EN, RK, BG, GS, GS, GS, GS},
		{GS, RK, GS, GS, GS, HR, HR, HR, GS, RK, GS},
		{RK, RK, RK, GS, GS, HR, GS, HR, RK, RK, RK},
		{RK, RK, GS, GS, GS, HR, HR, HR, GS, RK, RK}
	},

	// 41, E, MEADOW

	{
		{DC, WL, WL, WL, WL, WL, WL, WL, WL, WL, WL},
		{FG, GS, GS, GS, RK, EN, EN, RK, GS, GS, GS},
		{GS, HR, BG, BG, GS, GS, GS, GS, BG, HR, GS},
		{GS, BG, HR, HR, GS, GS, GS, GS, HR, BG, GS},
		{GS, BG, HR, HR, GS, GS, GS, GS, HR, HR, GS},
		{RK, GS, GS, GS, GS, GS, GS, GS, GS, GS, RK},
		{EN, GS, GS, GS, GS, HR, HR, GS, GS, GS, EN},
		{EN, GS, GS, GS, GS, HR, HR, GS, GS, GS, EN},
		{RK, GS, GS, GS, GS, GS, GS, GS, GS, GS, RK},
		{GS, BS, BG, BG, GS, GS, GS, GS, BG, BS, GS},
		{GS, BG, BS, BS, GS, GS, GS, GS, BS, BG, GS},
		{GS, GS, GS, GS, RK, EN, EN, RK, GS, GS, GS}
	},

	// 42, E, PYRAMID

	{
		{WL, WL, WL, WL, WL, DC, WL, WL, WL, WL, WL},
		{GS, GS, GS, GS, GS, FG, GS, GS, GS, GS, GS},
		{GS, BG, HR, BG, HR, BG, HR, BG, HR, BG, GS},
		{GS, GS, BG, HR, BG, HR, BG, HR, BG, GS, GS},
		{GS, GS, GS, BG, HR, BG, HR, BG, GS, GS, GS},
		{GS, GS, GS, GS, BG, HR, BG, GS, GS, GS, GS},
		{EN, GS, GS, GS, GS, BS, GS, GS, GS, GS, EN},
		{EN, GS, GS, GS, SK, GS, SK, GS, GS, GS, EN},
		{EN, GS, GS, SK, GS, GS, GS, SK, GS, GS, EN},
		{GS, GS, SK, GS, GS, GS, GS, GS, SK, GS, GS},
		{GS, SK, GS, GS, GS, GS, GS, GS, GS, SK, GS},
		{SK, GS, GS, GS, GS, GS, GS, GS, GS, GS, SK}
	},

	// 43, E, PACKING

	{
		{WL, WL, WL, WL, WL, DC, WL, WL, WL, WL, WL},
		{RK, GS, GS, GS, GS, FG, GS, GS, GS, GS, RK},
		{RK, GS, GS, BG, GS, BG, GS, BG, GS, GS, RK},
		{RK, GS, GS, BG, GS, BG, GS, BG, GS, GS, RK},
		{GS, GS, GS, BG, GS, BG, GS, BG, GS, GS, GS},
		{GS, GS, GS, RK, RK, RK, RK, RK, GS, GS, GS},
		{GS, GS, RK, RK, SK, RK, SK, RK, RK, GS, GS},
		{GS, GS, RK, SK, SK, SK, SK, SK, RK, GS, GS},
		{GS, GS, RK, RK, SK, RK, SK, BS, RK, GS, GS},
		{GS, GS, GS, BG, GS, BG, GS, BG, GS, GS, GS},
		{GS, GS, GS, GS, GS, GS, GS, GS, GS, GS, GS},
		{GS, EN, HR, GS, GS, GS, GS, GS, EN, EN, GS}
	},

	// 44, E, PACKING

	{
		{WL, DC, WL, WL, WL, WL, WL, WL, WL, WL, WL},
		{GS, GS, GS, GS, GS, GS, GS, BG, GS, GS, GS},
		{GS, FG, GS, GS, GS, GS, GS, BG, BG, GS, GS},
		{GS, BG, GS, GS, GS, GS, GS, BG, GS, GS, GS},
		{RK, GS, GS, GS, GS, RK, RK, GS, RK, RK, RK},
		{EN, GS, GS, GS, GS, RK, GS, GS, SK, SK, RK},
		{EN, GS, GS, GS, HR, RK, GS, GS, SK, SK, RK},
		{EN, GS, GS, GS, GS, RK, GS, RK, RK, RK, RK},
		{GS, GS, GS, GS, GS, GS, BG, GS, GS, GS, GS},
		{GS, GS, GS, GS, GS, GS, BG, BG, GS, GS, GS},
		{GS, GS, GS, GS, GS, GS, BG, GS, GS, GS, GS},
		{RK, HR, RK, RK, EN, RK, GS, GS, GS, GS, GS}
	},

	// 45, E, ROOMS

	{
		{WL, WL, WL, WL, WL, WL, WL, WL, DC, WL, WL},
		{EN, GS, GS, GS, EN, RK, EN, GS, GS, GS, EN},
		{GS, HR, HR, HR, BS, RK, SK, HR, HR, HR, GS},
		{GS, BG, FG, BG, GS, GS, GS, BG, HR, BG, GS},
		{GS, HR, BG, BG, BS, RK, SK, HR, HR, HR, GS},
		{EN, SK, GS, SK, EN, RK, EN, BS, GS, BS, EN},
		{RK, RK, GS, RK, RK, RK, RK, RK, GS, RK, RK},
		{EN, BS, GS, BS, EN, RK, EN, SK, GS, SK, EN},
		{GS, HR, HR, HR, SK, RK, BS, HR, BG, HR, GS},
		{GS, HR, HR, BG, GS, GS, GS, HR, HR, BG, GS},
		{GS, HR, BG, GS, SK, RK, BS, HR, HR, HR, GS},
		{EN, GS, GS, GS, EN, RK, EN, GS, GS, GS, EN}
	},

	// 46, E, ROOMS

	{
		{WL, WL, WL, WL, WL, WL, WL, WL, DC, WL, WL},
		{GS, SK, GS, BG, GS, GS, RK, GS, HR, GS, EN},
		{GS, GS, HR, BG, HR, GS, RK, GS, GS, GS, EN},
		{GS, GS, GS, RK, GS, GS, RK, GS, HR, GS, EN},
		{GS, GS, GS, RK, GS, GS, BG, GS, GS, GS, EN},
		{RK, HR, RK, RK, RK, RK, BG, RK, HR, RK, RK},
		{GS, GS, GS, RK, GS, FG, GS, RK, GS, GS, GS},
		{GS, GS, GS, RK, BG, RK, RK, RK, RK, RK, BG},
		{GS, GS, GS, BG, GS, GS, GS, RK, GS, GS, GS},
		{GS, GS, GS, RK, GS, GS, GS, RK, GS, GS, GS},
		{GS, GS, HR, RK, BG, GS, BG, BG, HR, GS, GS},
		{GS, EN, GS, RK, GS, GS, GS, BG, GS, GS, GS}
	},

	// 47, E, ROOMS

	{
		{DC, WL, WL, WL, WL, WL, WL, WL, WL, WL, WL},
		{GS, GS, GS, GS, GS, GS, RK, RK, RK, RK, RK},
		{GS, BG, GS, BG, GS, GS, RK, RK, RK, RK, RK},
		{GS, GS, GS, GS, GS, GS, RK, GS, SK, RK, RK},
		{GS, HR, GS, GS, GS, GS, GS, GS, GS, GS, RK},
		{GS, GS, GS, EN, GS, GS, RK, RK, GS, GS, RK},
		{RK, RK, RK, RK, RK, GS, EN, RK, GS, RK, RK},
		{GS, GS, GS, GS, GS, GS, RK, RK, GS, GS, RK},
		{GS, BG, GS, GS, FG, BG, GS, GS, GS, SK, RK},
		{GS, BG, GS, GS, GS, GS, RK, GS, GS, RK, RK},
		{GS, SK, GS, GS, GS, GS, RK, RK, RK, RK, RK},
		{GS, GS, GS, EN, GS, GS, RK, RK, RK, RK, RK}
	},

	// 48, SPECIAL, BEFORE FINAL

	{
		{WL, WL, WL, WL, WL, WL, WL, WL, DC, WL, WL},
		{EN, EN, EN, EN, RK, RK, GS, GS, GS, GS, FG},
		{RK, GS, GS, GS, GS, BG, GS, BG, BG, GS, GS},
		{EN, GS, GS, RK, GS, RK, GS, GS, BG, BG, HR},
		{EN, RK, RK, RK, GS, RK, RK, GS, GS, BG, HR},
		{RK, RK, SK, SK, SK, GS, GS, GS, GS, GS, HR},
		{RK, RK, RK, RK, SK, RK, RK, RK, GS, RK, RK},
		{EN, RK, SK, SK, SK, GS, GS, RK, GS, GS, RK},
		{EN, RK, RK, GS, RK, RK, GS, RK, RK, GS, HR},
		{EN, RK, RK, GS, RK, GS, GS, GS, BG, GS, HR},
		{GS, GS, GS, GS, GS, GS, GS, GS, BG, GS, RK},
		{HR, GS, GS, GS, RK, RK, GS, HR, HR, HR, HR}
	},

	// 49, SPECIAL, (|<)

	{
		{WL, WL, WL, WL, WL, DO, WL, WL, WL, WL, WL},
		{GS, GS, GS, GS, GS, GS, GS, GS, GS, GS, GS},
		{GS, GS, GS, GS, GS, GS, GS, GS, GS, GS, GS},
		{GS, GS, RK, RK, GS, GS, GS, RK, RK, GS, GS},
		{GS, RK, GS, RK, GS, GS, RK, GS, GS, RK, GS},
		{GS, RK, GS, RK, GS, RK, GS, GS, GS, RK, GS},
		{GS, RK, GS, RK, GS, RK, GS, GS, GS, RK, GS},
		{GS, RK, GS, RK, GS, GS, RK, GS, GS, RK, GS},
		{GS, GS, RK, RK, GS, GS, GS, RK, RK, GS, GS},
		{GS, GS, GS, GS, GS, GS, GS, GS, GS, GS, GS},
		{GS, GS, GS, GS, GS, FG, GS, GS, GS, GS, GS},
		{GS, GS, GS, GS, GS, GS, GS, GS, GS, GS, GS}
	},

	// 50, SPECIAL, FINAL

	{
		{WL, WL, WL, WL, WL, DC, WL, WL, WL, WL, WL},
		{GS, GS, GS, GS, GS, FG, GS, RK, EN, GS, GS},
		{GS, GS, HR, BG, BG, GS, GS, RK, GS, GS, GS},
		{GS, HR, GS, GS, GS, GS, GS, RK, HR, HR, HR},
		{RK, RK, RK, RK, GS, RK, RK, RK, BG, BG, HR},
		{GS, GS, GS, RK, SK, GS, SK, GS, GS, GS, GS},
		{GS, HR, GS, RK, GS, RK, GS, RK, BG, BG, HR},
		{GS, GS, GS, GS, SK, GS, SK, RK, HR, HR, HR},
		{RK, GS, RK, RK, RK, RK, GS, RK, RK, RK, RK},
		{HR, GS, GS, RK, GS, HR, GS, BG, GS, HR, GS},
		{HR, GS, GS, RK, HR, GS, HR, GS, HR, GS, EN},
		{HR, HR, EN, RK, GS, HR, GS, HR, GS, HR, GS}
	}

};

/* LEVEL CODES */

static char *levelcode[NUMLEVELS] =
{
	/* LEVEL 01 */ "VKC",
	/* LEVEL 02 */ "RDS",
	/* LEVEL 03 */ "HKU",
	/* LEVEL 04 */ "CNZ",
	/* LEVEL 05 */ "QDS",
	/* LEVEL 06 */ "HWK",
	/* LEVEL 07 */ "ANZ",
	/* LEVEL 08 */ "KES",
	/* LEVEL 09 */ "FRT",
	/* LEVEL 10 */ "ECM",
	/* LEVEL 11 */ "ESV",
	/* LEVEL 12 */ "EKV",
	/* LEVEL 13 */ "JYK",
	/* LEVEL 14 */ "QGW",
	/* LEVEL 15 */ "JWH",
	/* LEVEL 16 */ "AFP",
	/* LEVEL 17 */ "XLW",
	/* LEVEL 18 */ "NOY",
	/* LEVEL 19 */ "EYJ",
	/* LEVEL 20 */ "UMZ",
	/* LEVEL 21 */ "CJR",
	/* LEVEL 22 */ "JVH",
	/* LEVEL 23 */ "XPJ",
	/* LEVEL 24 */ "DXE",
	/* LEVEL 25 */ "NTF",
	/* LEVEL 26 */ "TJZ",
	/* LEVEL 27 */ "QBV",
	/* LEVEL 28 */ "HTJ",
	/* LEVEL 29 */ "WYH",
	/* LEVEL 30 */ "JZS",
	/* LEVEL 31 */ "LUY",
	/* LEVEL 32 */ "RLA",
	/* LEVEL 33 */ "TLF",
	/* LEVEL 34 */ "ESM",
	/* LEVEL 35 */ "FVK",
	/* LEVEL 36 */ "WFM",
	/* LEVEL 37 */ "TNF",
	/* LEVEL 38 */ "ITK",
	/* LEVEL 39 */ "EXJ",
	/* LEVEL 40 */ "OBD",
	/* LEVEL 41 */ "TCI",
	/* LEVEL 42 */ "PJA",
	/* LEVEL 43 */ "OHW",
	/* LEVEL 44 */ "KCN",
	/* LEVEL 45 */ "EXT",
	/* LEVEL 46 */ "IMB",
	/* LEVEL 47 */ "SGS",
	/* LEVEL 48 */ "LES",
	/* LEVEL 49 */ "JZO",
	/* LEVEL 50 */ "CRD"
};

/**********************************************************/
/* end of file levels.h                                   */
/**********************************************************/
