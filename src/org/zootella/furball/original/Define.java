package org.zootella.furball.original;

public class Define {
	
	// Board and window dimensions
	public static final int tileSize  = 30;
	public static final int boardCols = 11;
	public static final int boardRows = 12;
	public static final int bColPix = (tileSize * boardCols); // 330
	public static final int bRowPix = (tileSize * boardRows); // 360
	public static final int tdBorder = 2;
	
	// Constants
	public static final String appName = "Furball";
	public static final String appNameLong = "Furball's Adventures";
	public static final int maxStringLength = 200;
	public static final int sleepMilli = 1500; // 1.5 SECONDS

	// Game play constants
	public static final int numLevels = 50;
	public static final int initialStartingLevel = 0;
	public static final int livesAtStart = 2;
	public static final int daySongs = 10;
	public static final int nightSongs = 6;

	// Message text
	public static final String newGameText     = "This will restart the game from the first level.";
	public static final String gameOverText    = "No more Furballs remain. Game over.";
	public static final String invalidCodeText = "The level code that you typed is not correct. Try typing it again.";
	public static final String dawnText        = "That man who does not believe that each day contains an earlier, more sacred, and auroral hour than he has yet profaned, has despaired of life, and is pursuing a descending and darkening way.\n\n-Henry David Thoreau";
	public static final String duskText        = "Night, the beloved. Night, when words fade and things come alive. When the destructive analysis of day is done, and all that is truly important becomes whole and sound again. When man reassembles his fragmentary self and grows with the calm of a tree.\n\n-Antoine de Saint-Exupéry";

	// Settings
	public static final int defaultSoundInt = 1; // SOUND EFFECTS ON
	public static final int defaultHelpInt  = 1; // QUICK HELP DISPLAYED
	public static final int defaultMusicInt = 1; // CYCLE MUSIC SELECTED
}
