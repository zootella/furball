package org.zootella.furball.original;

public class Define {

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
	 * codes like "TileCode.FG" into the valid enum data "FBONGRASS" in the 
	 * static levelbank array.  It is much easier to edit and read 
	 * the code in this array with the two letter abbreviations.
	 */
	
	/* BOARD AND WINDOW DIMENSIONS */
	
	public static final int tileSize  = 30;
	public static final int boardCols = 11;
	public static final int boardRows = 12;
	public static final int bColPix = (tileSize * boardCols); // 330
	public static final int bRowPix = (tileSize * boardRows); // 360
	public static final int tdBorder = 2;
	
	/* WINDOWS CONSTANTS */
	
	public static final String appName = "Furball";
	public static final String appNameLong = "Furball's Adventures";
	public static final int maxStringLength = 200;
	public static final int sleepMilli = 1500; // 1.5 SECONDS
	
	/* GAME PLAY CONSTANTS */
	
	public static final int numLevels = 50;
	public static final int initialStartingLevel = 0;
	public static final int livesAtStart = 2;
	public static final int dawn = 6;  // DAWN WILL HAPPEN AT 6:00 AM
	public static final int dusk = 20; // DUSK WILL HAPPEN AT 8:00 PM
	public static final int daySongs = 10;
	public static final int nightSongs = 6;
	
	/* MESSAGE BOX TEXT */
	
	public static final String newGameText     = "This will restart the game from the first level.";
	public static final String gameOverText    = "No more Furballs remain. Game over.";
	public static final String invalidCodeText = "The level code that you typed is not correct. Try typing it again.";
	public static final String dawnText        = "That man who does not believe that each day contains an earlier, more sacred, and auroral hour than he has yet profaned, has despaired of life, and is pursuing a descending and darkening way.\n\n-Henry David Thoreau";
	public static final String duskText        = "Night, the beloved. Night, when words fade and things come alive. When the destructive analysis of day is done, and all that is truly important becomes whole and sound again. When man reassembles his fragmentary self and grows with the calm of a tree.\n\n-Antoine de Saint-Exupéry";
	
	/* REGISTRY CONSTANTS */
	
	/*
	public static final int DOUBLEWORDDATA 1
	public static final int DOUBLEWORDSIZE 4
	public static final int DOUBLEWORDTYPE 0
	public static final int BYTESINDWORD 4
	*/
	public static final int defaultSoundInt = 1; // SOUND EFFECTS ON
	public static final int defaultHelpInt  = 1; // QUICK HELP DISPLAYED
	public static final int defaultMusicInt = 1; // CYCLE MUSIC SELECTED
}
