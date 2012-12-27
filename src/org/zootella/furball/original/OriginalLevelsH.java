package org.zootella.furball.original;
	
public class OriginalLevelsH {
	
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

	/*
	typedef enum {
	
		// OPTIONS SPECIFIED FROM THE MENU AND STORED IN THE REGISTRY

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
	
		// ADDITIONAL SONG NAME NOT FOR USE AS A MUSIC OPTION
	
		THRONE
	
	} music;
	*/
	
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
	
	public static TileCode levelbank[][][] =
	{
	
		// 1, SPECIAL, FIRST
	
		{
			{TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.DC, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL},
			{TileCode.GS, TileCode.GS, TileCode.RK, TileCode.RK, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.RK, TileCode.RK, TileCode.GS, TileCode.GS},
			{TileCode.GS, TileCode.GS, TileCode.RK, TileCode.RK, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.RK, TileCode.RK, TileCode.GS, TileCode.GS},
			{TileCode.GS, TileCode.GS, TileCode.RK, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.RK, TileCode.GS, TileCode.GS},
			{TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.HR, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS},
			{TileCode.EN, TileCode.GS, TileCode.RK, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.RK, TileCode.GS, TileCode.EN},
			{TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.HR, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS},
			{TileCode.EN, TileCode.GS, TileCode.RK, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.RK, TileCode.GS, TileCode.EN},
			{TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.HR, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS},
			{TileCode.GS, TileCode.GS, TileCode.RK, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.RK, TileCode.GS, TileCode.GS},
			{TileCode.GS, TileCode.GS, TileCode.RK, TileCode.RK, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.RK, TileCode.RK, TileCode.GS, TileCode.GS},
			{TileCode.GS, TileCode.GS, TileCode.RK, TileCode.RK, TileCode.GS, TileCode.FG, TileCode.GS, TileCode.RK, TileCode.RK, TileCode.GS, TileCode.GS}
		},
	
		// 2, TUTORIAL, MAZE
	
		{
			{TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.DC, TileCode.WL},
			{TileCode.RK, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.GS, TileCode.RK},
			{TileCode.RK, TileCode.HR, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.RK, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.RK},
			{TileCode.RK, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.GS, TileCode.RK, TileCode.GS, TileCode.RK, TileCode.RK, TileCode.RK},
			{TileCode.RK, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.RK, TileCode.HR, TileCode.RK},
			{TileCode.RK, TileCode.GS, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.GS, TileCode.RK, TileCode.GS, TileCode.RK},
			{TileCode.RK, TileCode.GS, TileCode.RK, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.RK, TileCode.GS, TileCode.RK, TileCode.GS, TileCode.RK},
			{TileCode.RK, TileCode.GS, TileCode.RK, TileCode.GS, TileCode.RK, TileCode.GS, TileCode.RK, TileCode.GS, TileCode.RK, TileCode.GS, TileCode.RK},
			{TileCode.RK, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.RK, TileCode.GS, TileCode.RK, TileCode.GS, TileCode.RK, TileCode.GS, TileCode.RK},
			{TileCode.RK, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.GS, TileCode.RK, TileCode.GS, TileCode.RK, TileCode.GS, TileCode.RK},
			{TileCode.FG, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.RK, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.RK},
			{TileCode.RK, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.RK}
		},
	
		// 3, TUTORIAL, COLLECT HEARTS
	
		{
			{TileCode.DC, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL},
			{TileCode.FG, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS},
			{TileCode.RK, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.GS, TileCode.RK},
			{TileCode.RK, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.RK, TileCode.RK, TileCode.GS, TileCode.RK},
			{TileCode.RK, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.GS, TileCode.RK, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.RK},
			{TileCode.RK, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.GS, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.RK},
			{TileCode.RK, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.RK},
			{TileCode.RK, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.GS, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.RK},
			{TileCode.RK, TileCode.RK, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.RK, TileCode.HR, TileCode.HR, TileCode.RK},
			{TileCode.RK, TileCode.RK, TileCode.GS, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.HR, TileCode.HR, TileCode.RK},
			{TileCode.RK, TileCode.RK, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.HR, TileCode.HR, TileCode.RK},
			{TileCode.RK, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.RK}
		},
	
		// 4, TUTORIAL, AVOID ENEMY
	
		{
			{TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.DC, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL},
			{TileCode.GS, TileCode.GS, TileCode.GS, TileCode.RK, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS},
			{TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS},
			{TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS},
			{TileCode.RK, TileCode.GS, TileCode.GS, TileCode.EN, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.RK, TileCode.GS, TileCode.GS, TileCode.GS},
			{TileCode.GS, TileCode.GS, TileCode.GS, TileCode.BG, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS},
			{TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.HR, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS},
			{TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.BG, TileCode.GS, TileCode.GS, TileCode.GS},
			{TileCode.GS, TileCode.GS, TileCode.GS, TileCode.RK, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.EN, TileCode.GS, TileCode.GS, TileCode.RK},
			{TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS},
			{TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS},
			{TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.FG, TileCode.GS, TileCode.RK, TileCode.GS, TileCode.GS, TileCode.GS}
		},
	
		// 5, TUTORIAL, PUSH BOX INTO SINK
	
		{
			{TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.DC, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL},
			{TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS},
			{TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS},
			{TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS},
			{TileCode.GS, TileCode.BG, TileCode.GS, TileCode.BG, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS},
			{TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.SK, TileCode.SK, TileCode.GS, TileCode.GS},
			{TileCode.GS, TileCode.BG, TileCode.GS, TileCode.BG, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.SK, TileCode.SK, TileCode.GS, TileCode.GS},
			{TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.SK, TileCode.SK, TileCode.GS, TileCode.GS},
			{TileCode.GS, TileCode.BG, TileCode.GS, TileCode.BG, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS},
			{TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS},
			{TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS},
			{TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.FG, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS}
		},
	
		// 6, TUTORIAL, MOVE BOX TO GET OUT
	
		{
			{TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.DC, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL},
			{TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS},
			{TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS},
			{TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS},
			{TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.RK, TileCode.GS, TileCode.RK, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS},
			{TileCode.GS, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.SK, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.GS},
			{TileCode.GS, TileCode.RK, TileCode.GS, TileCode.GS, TileCode.RK, TileCode.GS, TileCode.RK, TileCode.GS, TileCode.GS, TileCode.RK, TileCode.GS},
			{TileCode.GS, TileCode.RK, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.RK, TileCode.GS},
			{TileCode.GS, TileCode.RK, TileCode.GS, TileCode.FG, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.BG, TileCode.GS, TileCode.RK, TileCode.GS},
			{TileCode.GS, TileCode.RK, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.RK, TileCode.GS},
			{TileCode.GS, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.GS},
			{TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS}
		},
	
		// 7, TUTORIAL, USE BOX TO BLOCK ENEMY
	
		{
			{TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.DC, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL},
			{TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS},
			{TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS},
			{TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS},
			{TileCode.RK, TileCode.RK, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS},
			{TileCode.RK, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.RK, TileCode.RK},
			{TileCode.RK, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.EN, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.HR, TileCode.RK},
			{TileCode.RK, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.RK, TileCode.RK},
			{TileCode.RK, TileCode.RK, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS},
			{TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS},
			{TileCode.GS, TileCode.GS, TileCode.GS, TileCode.FG, TileCode.GS, TileCode.BG, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS},
			{TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS}
		},
	
		// 8, TUTORIAL, COLLECT HEART BY PUSING OVER BOX
	
		{
			{TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.DC},
			{TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS},
			{TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS},
			{TileCode.GS, TileCode.GS, TileCode.GS, TileCode.RK, TileCode.RK, TileCode.GS, TileCode.RK, TileCode.GS, TileCode.RK, TileCode.SK, TileCode.RK},
			{TileCode.GS, TileCode.BG, TileCode.GS, TileCode.RK, TileCode.RK, TileCode.GS, TileCode.RK, TileCode.SK, TileCode.RK, TileCode.HR, TileCode.RK},
			{TileCode.GS, TileCode.BG, TileCode.GS, TileCode.RK, TileCode.RK, TileCode.SK, TileCode.RK, TileCode.HR, TileCode.RK, TileCode.EN, TileCode.RK},
			{TileCode.GS, TileCode.BG, TileCode.GS, TileCode.RK, TileCode.RK, TileCode.HR, TileCode.RK, TileCode.EN, TileCode.RK, TileCode.RK, TileCode.RK},
			{TileCode.GS, TileCode.FG, TileCode.GS, TileCode.RK, TileCode.RK, TileCode.EN, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.RK},
			{TileCode.GS, TileCode.BG, TileCode.GS, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.RK},
			{TileCode.GS, TileCode.BG, TileCode.GS, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.RK},
			{TileCode.GS, TileCode.BG, TileCode.GS, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.RK},
			{TileCode.GS, TileCode.GS, TileCode.GS, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.RK}
		},
	
		// 9, TUTORIAL, SIMPLE LOGIC WALKAROUND
	
		{
			{TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.DC},
			{TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS},
			{TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS},
			{TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.HR, TileCode.GS, TileCode.BG, TileCode.GS, TileCode.GS},
			{TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS},
			{TileCode.RK, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.RK, TileCode.RK, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.RK},
			{TileCode.RK, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.EN, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.RK},
			{TileCode.RK, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.RK, TileCode.RK, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.RK},
			{TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS},
			{TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.SK, TileCode.GS, TileCode.BG, TileCode.GS, TileCode.GS},
			{TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS},
			{TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.FG}
		},
	
		// 10, A, MEADOW
	
		{
			{TileCode.WL, TileCode.WL, TileCode.DC, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL},
			{TileCode.GS, TileCode.GS, TileCode.GS, TileCode.RK, TileCode.GS, TileCode.GS, TileCode.HR, TileCode.RK, TileCode.GS, TileCode.GS, TileCode.EN},
			{TileCode.GS, TileCode.HR, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS},
			{TileCode.EN, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.RK, TileCode.GS, TileCode.RK, TileCode.GS, TileCode.BG, TileCode.GS, TileCode.GS},
			{TileCode.RK, TileCode.GS, TileCode.GS, TileCode.RK, TileCode.RK, TileCode.EN, TileCode.RK, TileCode.RK, TileCode.GS, TileCode.GS, TileCode.RK},
			{TileCode.EN, TileCode.GS, TileCode.RK, TileCode.RK, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.RK, TileCode.RK, TileCode.GS, TileCode.HR},
			{TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.HR},
			{TileCode.GS, TileCode.GS, TileCode.RK, TileCode.RK, TileCode.BG, TileCode.GS, TileCode.GS, TileCode.RK, TileCode.RK, TileCode.GS, TileCode.HR},
			{TileCode.GS, TileCode.GS, TileCode.GS, TileCode.RK, TileCode.RK, TileCode.GS, TileCode.RK, TileCode.RK, TileCode.EN, TileCode.GS, TileCode.HR},
			{TileCode.GS, TileCode.GS, TileCode.BG, TileCode.GS, TileCode.RK, TileCode.GS, TileCode.RK, TileCode.EN, TileCode.GS, TileCode.GS, TileCode.GS},
			{TileCode.GS, TileCode.FG, TileCode.GS, TileCode.BG, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.RK, TileCode.GS},
			{TileCode.EN, TileCode.GS, TileCode.GS, TileCode.RK, TileCode.GS, TileCode.GS, TileCode.RK, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.EN}
		},
	
		// 11, A, BUILDING
	
		{
			{TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.DC},
			{TileCode.GS, TileCode.GS, TileCode.GS, TileCode.SK, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS},
			{TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.RK},
			{TileCode.GS, TileCode.GS, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.HR, TileCode.HR, TileCode.HR, TileCode.HR, TileCode.RK},
			{TileCode.GS, TileCode.GS, TileCode.RK, TileCode.BG, TileCode.BG, TileCode.BG, TileCode.HR, TileCode.HR, TileCode.HR, TileCode.HR, TileCode.RK},
			{TileCode.GS, TileCode.GS, TileCode.RK, TileCode.BG, TileCode.GS, TileCode.BG, TileCode.BG, TileCode.BG, TileCode.BG, TileCode.BG, TileCode.RK},
			{TileCode.GS, TileCode.GS, TileCode.RK, TileCode.BG, TileCode.GS, TileCode.BG, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.BG, TileCode.RK},
			{TileCode.GS, TileCode.GS, TileCode.HR, TileCode.BG, TileCode.BG, TileCode.BG, TileCode.BG, TileCode.BG, TileCode.BG, TileCode.BG, TileCode.RK},
			{TileCode.GS, TileCode.FG, TileCode.GS, TileCode.GS, TileCode.BG, TileCode.GS, TileCode.BG, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.RK},
			{TileCode.GS, TileCode.GS, TileCode.BG, TileCode.BG, TileCode.BG, TileCode.BG, TileCode.BG, TileCode.GS, TileCode.RK, TileCode.RK, TileCode.RK},
			{TileCode.GS, TileCode.GS, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.EN, TileCode.EN},
			{TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.EN, TileCode.EN}
		},
	
		// 12, A, PYRIMID
	
		{
			{TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.DC},
			{TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.HR, TileCode.GS, TileCode.HR, TileCode.GS, TileCode.HR, TileCode.GS},
			{TileCode.GS, TileCode.RK, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.HR, TileCode.HR, TileCode.HR, TileCode.HR, TileCode.HR, TileCode.GS},
			{TileCode.RK, TileCode.RK, TileCode.RK, TileCode.GS, TileCode.GS, TileCode.HR, TileCode.HR, TileCode.GS, TileCode.HR, TileCode.GS, TileCode.GS},
			{TileCode.RK, TileCode.RK, TileCode.RK, TileCode.BG, TileCode.GS, TileCode.HR, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS},
			{TileCode.RK, TileCode.RK, TileCode.GS, TileCode.GS, TileCode.BG, TileCode.HR, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS},
			{TileCode.RK, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.FG, TileCode.RK, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS},
			{TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS},
			{TileCode.GS, TileCode.GS, TileCode.GS, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.GS, TileCode.GS, TileCode.GS},
			{TileCode.GS, TileCode.GS, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.GS, TileCode.GS},
			{TileCode.GS, TileCode.SK, TileCode.SK, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.HR, TileCode.HR, TileCode.RK, TileCode.RK, TileCode.GS},
			{TileCode.RK, TileCode.RK, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.HR, TileCode.HR, TileCode.RK, TileCode.RK, TileCode.RK}
		},
	
		// 13, A, PACKING
	
		{
			{TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.DC, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL},
			{TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS},
			{TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS},
			{TileCode.GS, TileCode.GS, TileCode.GS, TileCode.BG, TileCode.GS, TileCode.GS, TileCode.BG, TileCode.GS, TileCode.GS, TileCode.BG, TileCode.GS},
			{TileCode.GS, TileCode.FG, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS},
			{TileCode.GS, TileCode.GS, TileCode.GS, TileCode.BG, TileCode.GS, TileCode.GS, TileCode.BG, TileCode.GS, TileCode.GS, TileCode.BG, TileCode.GS},
			{TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS},
			{TileCode.GS, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.GS, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.GS},
			{TileCode.GS, TileCode.RK, TileCode.SK, TileCode.SK, TileCode.RK, TileCode.GS, TileCode.RK, TileCode.SK, TileCode.RK, TileCode.HR, TileCode.GS},
			{TileCode.GS, TileCode.RK, TileCode.SK, TileCode.SK, TileCode.RK, TileCode.GS, TileCode.RK, TileCode.SK, TileCode.RK, TileCode.RK, TileCode.GS},
			{TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS},
			{TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS}
		},
	
		// 14, A, ROOMS
	
		{
			{TileCode.WL, TileCode.DC, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL},
			{TileCode.RK, TileCode.GS, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.RK},
			{TileCode.RK, TileCode.HR, TileCode.RK, TileCode.HR, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.HR, TileCode.RK},
			{TileCode.RK, TileCode.GS, TileCode.RK, TileCode.GS, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.GS, TileCode.EN},
			{TileCode.RK, TileCode.HR, TileCode.RK, TileCode.HR, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.HR, TileCode.RK},
			{TileCode.RK, TileCode.GS, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.GS, TileCode.RK},
			{TileCode.RK, TileCode.HR, TileCode.GS, TileCode.HR, TileCode.GS, TileCode.HR, TileCode.GS, TileCode.HR, TileCode.RK, TileCode.HR, TileCode.RK},
			{TileCode.EN, TileCode.GS, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.GS, TileCode.RK, TileCode.GS, TileCode.RK},
			{TileCode.RK, TileCode.GS, TileCode.RK, TileCode.HR, TileCode.GS, TileCode.HR, TileCode.RK, TileCode.HR, TileCode.GS, TileCode.HR, TileCode.RK},
			{TileCode.RK, TileCode.GS, TileCode.RK, TileCode.GS, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.GS, TileCode.RK, TileCode.GS, TileCode.RK},
			{TileCode.RK, TileCode.GS, TileCode.GS, TileCode.HR, TileCode.GS, TileCode.HR, TileCode.GS, TileCode.HR, TileCode.GS, TileCode.HR, TileCode.FG},
			{TileCode.RK, TileCode.RK, TileCode.EN, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.EN, TileCode.RK, TileCode.RK}
		},
	
		// 15, B, MEDOW
	
		{
			{TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.DC, TileCode.WL, TileCode.WL, TileCode.WL},
			{TileCode.RK, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS},
			{TileCode.RK, TileCode.RK, TileCode.RK, TileCode.GS, TileCode.GS, TileCode.BG, TileCode.GS, TileCode.BG, TileCode.GS, TileCode.GS, TileCode.GS},
			{TileCode.RK, TileCode.RK, TileCode.SK, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.HR},
			{TileCode.RK, TileCode.GS, TileCode.BG, TileCode.GS, TileCode.GS, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.EN, TileCode.RK},
			{TileCode.GS, TileCode.GS, TileCode.FG, TileCode.GS, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.RK},
			{TileCode.GS, TileCode.GS, TileCode.GS, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.RK},
			{TileCode.GS, TileCode.GS, TileCode.GS, TileCode.EN, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.RK},
			{TileCode.GS, TileCode.GS, TileCode.GS, TileCode.EN, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.RK},
			{TileCode.GS, TileCode.GS, TileCode.GS, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.HR, TileCode.HR, TileCode.HR, TileCode.HR, TileCode.HR},
			{TileCode.GS, TileCode.GS, TileCode.GS, TileCode.SK, TileCode.GS, TileCode.GS, TileCode.HR, TileCode.BG, TileCode.BG, TileCode.BG, TileCode.HR},
			{TileCode.GS, TileCode.GS, TileCode.GS, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.HR, TileCode.HR, TileCode.HR, TileCode.HR, TileCode.HR}
		},
	
		// 16, B, MEADOW
	
		{
			{TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.DC, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL},
			{TileCode.GS, TileCode.GS, TileCode.GS, TileCode.EN, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.RK, TileCode.BS, TileCode.BS},
			{TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.HR, TileCode.GS, TileCode.RK, TileCode.BS, TileCode.BS},
			{TileCode.EN, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.RK, TileCode.BS, TileCode.BS},
			{TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.FG, TileCode.GS, TileCode.GS, TileCode.RK, TileCode.BS, TileCode.BS},
			{TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.BG, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.RK, TileCode.BS, TileCode.BS},
			{TileCode.GS, TileCode.HR, TileCode.BG, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.RK, TileCode.BS, TileCode.BS},
			{TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.RK, TileCode.BS, TileCode.BS},
			{TileCode.RK, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.GS, TileCode.RK, TileCode.RK},
			{TileCode.EN, TileCode.EN, TileCode.EN, TileCode.EN, TileCode.EN, TileCode.EN, TileCode.EN, TileCode.EN, TileCode.RK, TileCode.GS, TileCode.GS},
			{TileCode.EN, TileCode.EN, TileCode.EN, TileCode.EN, TileCode.EN, TileCode.EN, TileCode.EN, TileCode.EN, TileCode.RK, TileCode.GS, TileCode.GS},
			{TileCode.EN, TileCode.EN, TileCode.EN, TileCode.EN, TileCode.EN, TileCode.EN, TileCode.EN, TileCode.EN, TileCode.RK, TileCode.GS, TileCode.GS}
		},
	
		// 17, B, BUILDING
	
		{
			{TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.DC, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL},
			{TileCode.RK, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.RK},
			{TileCode.RK, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.BG, TileCode.FG, TileCode.BG, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.RK},
			{TileCode.GS, TileCode.GS, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.GS, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.GS, TileCode.GS},
			{TileCode.GS, TileCode.GS, TileCode.RK, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.RK, TileCode.GS, TileCode.GS},
			{TileCode.GS, TileCode.GS, TileCode.RK, TileCode.GS, TileCode.GS, TileCode.RK, TileCode.GS, TileCode.GS, TileCode.RK, TileCode.GS, TileCode.GS},
			{TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS},
			{TileCode.GS, TileCode.GS, TileCode.RK, TileCode.GS, TileCode.GS, TileCode.EN, TileCode.GS, TileCode.GS, TileCode.RK, TileCode.EN, TileCode.GS},
			{TileCode.GS, TileCode.EN, TileCode.RK, TileCode.GS, TileCode.GS, TileCode.RK, TileCode.GS, TileCode.GS, TileCode.RK, TileCode.GS, TileCode.GS},
			{TileCode.GS, TileCode.GS, TileCode.RK, TileCode.RK, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.RK, TileCode.RK, TileCode.GS, TileCode.GS},
			{TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS},
			{TileCode.GS, TileCode.GS, TileCode.GS, TileCode.RK, TileCode.RK, TileCode.HR, TileCode.RK, TileCode.RK, TileCode.GS, TileCode.GS, TileCode.GS}
		},
	
		// 18, B, PYRAMID
	
		{
			{TileCode.WL, TileCode.WL, TileCode.WL, TileCode.DC, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL},
			{TileCode.RK, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.RK, TileCode.RK, TileCode.GS, TileCode.GS, TileCode.GS},
			{TileCode.RK, TileCode.RK, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.RK, TileCode.RK, TileCode.GS, TileCode.GS, TileCode.GS},
			{TileCode.RK, TileCode.RK, TileCode.RK, TileCode.GS, TileCode.GS, TileCode.BG, TileCode.RK, TileCode.RK, TileCode.BG, TileCode.GS, TileCode.GS},
			{TileCode.RK, TileCode.RK, TileCode.RK, TileCode.GS, TileCode.BG, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.BG, TileCode.GS},
			{TileCode.RK, TileCode.RK, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS},
			{TileCode.RK, TileCode.RK, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS},
			{TileCode.RK, TileCode.RK, TileCode.BG, TileCode.BG, TileCode.GS, TileCode.GS, TileCode.EN, TileCode.EN, TileCode.GS, TileCode.GS, TileCode.GS},
			{TileCode.RK, TileCode.RK, TileCode.GS, TileCode.GS, TileCode.BG, TileCode.GS, TileCode.RK, TileCode.RK, TileCode.GS, TileCode.GS, TileCode.GS},
			{TileCode.RK, TileCode.RK, TileCode.GS, TileCode.BG, TileCode.GS, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.GS, TileCode.GS},
			{TileCode.RK, TileCode.RK, TileCode.BG, TileCode.GS, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.SK, TileCode.SK, TileCode.GS},
			{TileCode.RK, TileCode.RK, TileCode.FG, TileCode.RK, TileCode.RK, TileCode.HR, TileCode.HR, TileCode.HR, TileCode.HR, TileCode.RK, TileCode.RK}
		},
	
		// 19, B, PACKING
	
		{
			{TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.DC, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL},
			{TileCode.GS, TileCode.RK, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.RK, TileCode.GS},
			{TileCode.RK, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.RK},
			{TileCode.GS, TileCode.GS, TileCode.BG, TileCode.HR, TileCode.BG, TileCode.HR, TileCode.BG, TileCode.HR, TileCode.BG, TileCode.GS, TileCode.GS},
			{TileCode.GS, TileCode.GS, TileCode.HR, TileCode.BG, TileCode.HR, TileCode.BG, TileCode.HR, TileCode.BG, TileCode.HR, TileCode.GS, TileCode.GS},
			{TileCode.GS, TileCode.GS, TileCode.BG, TileCode.HR, TileCode.BG, TileCode.HR, TileCode.BG, TileCode.HR, TileCode.BG, TileCode.GS, TileCode.GS},
			{TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS},
			{TileCode.GS, TileCode.GS, TileCode.GS, TileCode.RK, TileCode.SK, TileCode.SK, TileCode.SK, TileCode.RK, TileCode.GS, TileCode.GS, TileCode.GS},
			{TileCode.GS, TileCode.GS, TileCode.RK, TileCode.SK, TileCode.SK, TileCode.FS, TileCode.SK, TileCode.SK, TileCode.RK, TileCode.GS, TileCode.GS},
			{TileCode.GS, TileCode.GS, TileCode.GS, TileCode.RK, TileCode.SK, TileCode.SK, TileCode.SK, TileCode.RK, TileCode.GS, TileCode.GS, TileCode.GS},
			{TileCode.BG, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.BG},
			{TileCode.GS, TileCode.BG, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.BG, TileCode.GS}
		},
	
		// 20, B, ROOMS
	
		{
			{TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.DC, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL},
			{TileCode.RK, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.GS, TileCode.RK, TileCode.RK, TileCode.EN, TileCode.RK, TileCode.RK},
			{TileCode.RK, TileCode.GS, TileCode.GS, TileCode.FG, TileCode.RK, TileCode.GS, TileCode.RK, TileCode.EN, TileCode.GS, TileCode.RK, TileCode.RK},
			{TileCode.RK, TileCode.GS, TileCode.BG, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.EN},
			{TileCode.RK, TileCode.GS, TileCode.BG, TileCode.GS, TileCode.RK, TileCode.RK, TileCode.GS, TileCode.RK, TileCode.GS, TileCode.RK, TileCode.RK},
			{TileCode.RK, TileCode.GS, TileCode.BG, TileCode.GS, TileCode.GS, TileCode.HR, TileCode.HR, TileCode.RK, TileCode.GS, TileCode.RK, TileCode.RK},
			{TileCode.RK, TileCode.RK, TileCode.GS, TileCode.RK, TileCode.RK, TileCode.HR, TileCode.HR, TileCode.RK, TileCode.GS, TileCode.RK, TileCode.RK},
			{TileCode.RK, TileCode.RK, TileCode.GS, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.GS, TileCode.RK, TileCode.RK},
			{TileCode.RK, TileCode.GS, TileCode.GS, TileCode.RK, TileCode.SK, TileCode.RK, TileCode.RK, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.RK},
			{TileCode.RK, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.HR, TileCode.RK},
			{TileCode.RK, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.GS, TileCode.GS, TileCode.RK, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.RK},
			{TileCode.RK, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.RK}
		},
	
		// 21, B, ROOMS
	
		{
			{TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.DC, TileCode.WL},
			{TileCode.RK, TileCode.RK, TileCode.GS, TileCode.EN, TileCode.GS, TileCode.GS, TileCode.EN, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS},
			{TileCode.RK, TileCode.RK, TileCode.RK, TileCode.GS, TileCode.RK, TileCode.RK, TileCode.GS, TileCode.RK, TileCode.RK, TileCode.GS, TileCode.GS},
			{TileCode.HR, TileCode.RK, TileCode.RK, TileCode.GS, TileCode.RK, TileCode.RK, TileCode.GS, TileCode.RK, TileCode.RK, TileCode.GS, TileCode.RK},
			{TileCode.GS, TileCode.RK, TileCode.GS, TileCode.GS, TileCode.RK, TileCode.RK, TileCode.GS, TileCode.RK, TileCode.RK, TileCode.GS, TileCode.GS},
			{TileCode.HR, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.EN, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS},
			{TileCode.GS, TileCode.RK, TileCode.GS, TileCode.GS, TileCode.RK, TileCode.RK, TileCode.GS, TileCode.RK, TileCode.RK, TileCode.GS, TileCode.GS},
			{TileCode.HR, TileCode.RK, TileCode.RK, TileCode.GS, TileCode.RK, TileCode.RK, TileCode.GS, TileCode.RK, TileCode.RK, TileCode.GS, TileCode.RK},
			{TileCode.RK, TileCode.RK, TileCode.RK, TileCode.GS, TileCode.RK, TileCode.RK, TileCode.GS, TileCode.RK, TileCode.RK, TileCode.GS, TileCode.GS},
			{TileCode.RK, TileCode.FG, TileCode.BG, TileCode.GS, TileCode.BG, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS},
			{TileCode.RK, TileCode.GS, TileCode.BG, TileCode.GS, TileCode.BG, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.SK, TileCode.GS},
			{TileCode.RK, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.GS, TileCode.RK}
		},
	
		// 22, C, MEADOW
	
		{
			{TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.DC, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL},
			{TileCode.GS, TileCode.GS, TileCode.GS, TileCode.EN, TileCode.BG, TileCode.GS, TileCode.BG, TileCode.EN, TileCode.GS, TileCode.GS, TileCode.EN},
			{TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.HR},
			{TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.FG, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.HR},
			{TileCode.GS, TileCode.RK, TileCode.BG, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.HR},
			{TileCode.RK, TileCode.GS, TileCode.GS, TileCode.RK, TileCode.BG, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.HR},
			{TileCode.GS, TileCode.HR, TileCode.RK, TileCode.GS, TileCode.GS, TileCode.RK, TileCode.HR, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.HR},
			{TileCode.GS, TileCode.GS, TileCode.GS, TileCode.HR, TileCode.RK, TileCode.GS, TileCode.GS, TileCode.RK, TileCode.BG, TileCode.GS, TileCode.HR},
			{TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.BG, TileCode.RK, TileCode.GS, TileCode.GS, TileCode.RK, TileCode.HR},
			{TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.HR, TileCode.RK, TileCode.GS, TileCode.HR},
			{TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.HR, TileCode.RK},
			{TileCode.EN, TileCode.GS, TileCode.GS, TileCode.EN, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS}
		},
	
		// 23, C, MEADOW
	
		{
			{TileCode.DC, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL},
			{TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.RK, TileCode.EN, TileCode.RK, TileCode.GS, TileCode.RK, TileCode.HR, TileCode.EN},
			{TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.RK},
			{TileCode.RK, TileCode.RK, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.RK},
			{TileCode.EN, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.RK, TileCode.GS, TileCode.GS, TileCode.GS},
			{TileCode.EN, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.RK, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS},
			{TileCode.EN, TileCode.GS, TileCode.RK, TileCode.HR, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.RK, TileCode.GS, TileCode.RK},
			{TileCode.EN, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.HR, TileCode.RK, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.RK},
			{TileCode.RK, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.RK, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.RK},
			{TileCode.RK, TileCode.RK, TileCode.BG, TileCode.BG, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.HR, TileCode.RK, TileCode.RK},
			{TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.BG, TileCode.GS},
			{TileCode.FG, TileCode.RK, TileCode.GS, TileCode.GS, TileCode.RK, TileCode.EN, TileCode.RK, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS}
		},
	
		// 24, C, BUILDING
	
		{
			{TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.DC, TileCode.WL},
			{TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS},
			{TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.GS, TileCode.EN},
			{TileCode.GS, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS},
			{TileCode.GS, TileCode.RK, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.RK, TileCode.HR, TileCode.GS, TileCode.RK, TileCode.GS, TileCode.RK},
			{TileCode.GS, TileCode.RK, TileCode.GS, TileCode.FG, TileCode.GS, TileCode.BS, TileCode.GS, TileCode.GS, TileCode.RK, TileCode.GS, TileCode.GS},
			{TileCode.GS, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.BS, TileCode.RK, TileCode.BS, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.GS},
			{TileCode.GS, TileCode.GS, TileCode.RK, TileCode.GS, TileCode.GS, TileCode.BS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.RK, TileCode.GS},
			{TileCode.GS, TileCode.GS, TileCode.RK, TileCode.GS, TileCode.GS, TileCode.RK, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.RK, TileCode.GS},
			{TileCode.GS, TileCode.GS, TileCode.RK, TileCode.GS, TileCode.GS, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.GS},
			{TileCode.GS, TileCode.GS, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS},
			{TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS}
		},
	
		// 25, C, BUILDING
	
		{
			{TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.DC, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL},
			{TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS},
			{TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS},
			{TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS},
			{TileCode.GS, TileCode.GS, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.BS, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.GS, TileCode.GS},
			{TileCode.GS, TileCode.GS, TileCode.RK, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.RK, TileCode.GS, TileCode.GS},
			{TileCode.GS, TileCode.GS, TileCode.BS, TileCode.GS, TileCode.GS, TileCode.HR, TileCode.GS, TileCode.GS, TileCode.BS, TileCode.GS, TileCode.GS},
			{TileCode.GS, TileCode.RK, TileCode.RK, TileCode.BG, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.BS, TileCode.RK, TileCode.RK, TileCode.GS},
			{TileCode.GS, TileCode.RK, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.RK, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.RK, TileCode.GS},
			{TileCode.GS, TileCode.BS, TileCode.GS, TileCode.FG, TileCode.GS, TileCode.BS, TileCode.GS, TileCode.HR, TileCode.GS, TileCode.BS, TileCode.GS},
			{TileCode.GS, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.GS},
			{TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS}
		},
	
		// 26, C, PYRIMID
	
		{
			{TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.DC},
			{TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.HR},
			{TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.RK},
			{TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.EN, TileCode.BS, TileCode.RK},
			{TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.EN, TileCode.BG, TileCode.RK, TileCode.RK},
			{TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.EN, TileCode.BG, TileCode.BS, TileCode.RK, TileCode.RK},
			{TileCode.GS, TileCode.GS, TileCode.BG, TileCode.GS, TileCode.GS, TileCode.EN, TileCode.BG, TileCode.BG, TileCode.RK, TileCode.RK, TileCode.RK},
			{TileCode.GS, TileCode.BG, TileCode.GS, TileCode.BG, TileCode.GS, TileCode.BG, TileCode.BG, TileCode.BS, TileCode.RK, TileCode.RK, TileCode.RK},
			{TileCode.BG, TileCode.GS, TileCode.BG, TileCode.GS, TileCode.BG, TileCode.BG, TileCode.BG, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.RK},
			{TileCode.GS, TileCode.BG, TileCode.GS, TileCode.BG, TileCode.BG, TileCode.BG, TileCode.BS, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.RK},
			{TileCode.GS, TileCode.GS, TileCode.BG, TileCode.BG, TileCode.BG, TileCode.BG, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.RK},
			{TileCode.FG, TileCode.BG, TileCode.BG, TileCode.BG, TileCode.BG, TileCode.BS, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.RK}
		},
	
		// 27, C, PACKING
	
		{
			{TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.DC, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL},
			{TileCode.GS, TileCode.GS, TileCode.GS, TileCode.EN, TileCode.RK, TileCode.HR, TileCode.RK, TileCode.HR, TileCode.GS, TileCode.GS, TileCode.GS},
			{TileCode.GS, TileCode.GS, TileCode.BG, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.BG, TileCode.GS, TileCode.GS},
			{TileCode.GS, TileCode.BG, TileCode.GS, TileCode.BG, TileCode.GS, TileCode.FG, TileCode.GS, TileCode.BG, TileCode.GS, TileCode.BG, TileCode.GS},
			{TileCode.HR, TileCode.GS, TileCode.GS, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.GS, TileCode.RK, TileCode.GS, TileCode.GS, TileCode.EN},
			{TileCode.RK, TileCode.GS, TileCode.GS, TileCode.RK, TileCode.SK, TileCode.SK, TileCode.SK, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.RK},
			{TileCode.HR, TileCode.GS, TileCode.GS, TileCode.RK, TileCode.SK, TileCode.RK, TileCode.SK, TileCode.RK, TileCode.GS, TileCode.GS, TileCode.HR},
			{TileCode.RK, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.SK, TileCode.SK, TileCode.SK, TileCode.RK, TileCode.GS, TileCode.GS, TileCode.RK},
			{TileCode.EN, TileCode.GS, TileCode.GS, TileCode.RK, TileCode.GS, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.GS, TileCode.GS, TileCode.HR},
			{TileCode.GS, TileCode.BG, TileCode.GS, TileCode.BG, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.BG, TileCode.GS, TileCode.BG, TileCode.GS},
			{TileCode.GS, TileCode.GS, TileCode.BG, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.BG, TileCode.GS, TileCode.GS},
			{TileCode.GS, TileCode.GS, TileCode.GS, TileCode.HR, TileCode.RK, TileCode.HR, TileCode.RK, TileCode.EN, TileCode.GS, TileCode.GS, TileCode.GS}
		},
	
		// 28, C, ROOMS
	
		{
			{TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.DC, TileCode.WL, TileCode.WL, TileCode.WL},
			{TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.RK, TileCode.RK, TileCode.GS, TileCode.RK, TileCode.RK, TileCode.RK},
			{TileCode.GS, TileCode.BG, TileCode.BS, TileCode.BG, TileCode.GS, TileCode.RK, TileCode.RK, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.RK},
			{TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.FG, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.GS, TileCode.RK},
			{TileCode.RK, TileCode.RK, TileCode.GS, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.RK},
			{TileCode.RK, TileCode.RK, TileCode.BG, TileCode.RK, TileCode.HR, TileCode.HR, TileCode.RK, TileCode.GS, TileCode.RK, TileCode.RK, TileCode.RK},
			{TileCode.RK, TileCode.RK, TileCode.GS, TileCode.RK, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.EN},
			{TileCode.GS, TileCode.GS, TileCode.GS, TileCode.SK, TileCode.GS, TileCode.GS, TileCode.RK, TileCode.HR, TileCode.GS, TileCode.RK, TileCode.RK},
			{TileCode.GS, TileCode.RK, TileCode.GS, TileCode.RK, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.RK, TileCode.RK},
			{TileCode.GS, TileCode.GS, TileCode.GS, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.SK, TileCode.RK, TileCode.RK, TileCode.RK},
			{TileCode.RK, TileCode.RK, TileCode.GS, TileCode.RK, TileCode.GS, TileCode.GS, TileCode.BG, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.RK},
			{TileCode.RK, TileCode.RK, TileCode.EN, TileCode.RK, TileCode.HR, TileCode.HR, TileCode.HR, TileCode.HR, TileCode.HR, TileCode.HR, TileCode.RK}
		},
	
		// 29, C, ROOMS
	
		{
			{TileCode.WL, TileCode.WL, TileCode.DC, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL},
			{TileCode.EN, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.EN, TileCode.RK, TileCode.HR, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.HR},
			{TileCode.GS, TileCode.GS, TileCode.FG, TileCode.GS, TileCode.GS, TileCode.RK, TileCode.GS, TileCode.BG, TileCode.GS, TileCode.BG, TileCode.GS},
			{TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.RK, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS},
			{TileCode.RK, TileCode.RK, TileCode.GS, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.GS, TileCode.RK, TileCode.RK},
			{TileCode.GS, TileCode.GS, TileCode.GS, TileCode.RK, TileCode.RK, TileCode.GS, TileCode.GS, TileCode.RK, TileCode.GS, TileCode.GS, TileCode.GS},
			{TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.HR, TileCode.GS, TileCode.RK, TileCode.GS, TileCode.GS, TileCode.GS},
			{TileCode.GS, TileCode.GS, TileCode.GS, TileCode.RK, TileCode.RK, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS},
			{TileCode.GS, TileCode.GS, TileCode.GS, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.GS, TileCode.GS, TileCode.GS},
			{TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.RK, TileCode.RK, TileCode.GS, TileCode.GS, TileCode.GS},
			{TileCode.GS, TileCode.GS, TileCode.GS, TileCode.RK, TileCode.GS, TileCode.HR, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS},
			{TileCode.GS, TileCode.GS, TileCode.GS, TileCode.RK, TileCode.GS, TileCode.GS, TileCode.RK, TileCode.RK, TileCode.GS, TileCode.GS, TileCode.GS}
		},
	
		// 30, D, MEADOW
	
		{
			{TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.DC, TileCode.WL},
			{TileCode.GS, TileCode.GS, TileCode.EN, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.RK, TileCode.EN, TileCode.RK, TileCode.GS, TileCode.HR},
			{TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.RK, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS},
			{TileCode.GS, TileCode.BG, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.HR, TileCode.GS, TileCode.GS, TileCode.GS},
			{TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.RK, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS},
			{TileCode.GS, TileCode.BG, TileCode.RK, TileCode.RK, TileCode.GS, TileCode.RK, TileCode.GS, TileCode.RK, TileCode.GS, TileCode.GS, TileCode.GS},
			{TileCode.FG, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.RK, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS},
			{TileCode.GS, TileCode.BG, TileCode.RK, TileCode.GS, TileCode.GS, TileCode.RK, TileCode.GS, TileCode.RK, TileCode.GS, TileCode.GS, TileCode.EN},
			{TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.RK, TileCode.GS, TileCode.GS, TileCode.RK, TileCode.GS, TileCode.GS, TileCode.GS},
			{TileCode.GS, TileCode.BG, TileCode.GS, TileCode.GS, TileCode.SK, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS},
			{TileCode.GS, TileCode.GS, TileCode.GS, TileCode.RK, TileCode.EN, TileCode.GS, TileCode.GS, TileCode.RK, TileCode.GS, TileCode.GS, TileCode.GS},
			{TileCode.GS, TileCode.GS, TileCode.EN, TileCode.GS, TileCode.EN, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS}
		},
	
		// 31, D, MEADOW
	
		{
			{TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.DC, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL},
			{TileCode.SK, TileCode.GS, TileCode.RK, TileCode.EN, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.EN, TileCode.RK, TileCode.GS, TileCode.BS},
			{TileCode.SK, TileCode.GS, TileCode.EN, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.EN, TileCode.GS, TileCode.SK},
			{TileCode.SK, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.SK},
			{TileCode.SK, TileCode.GS, TileCode.GS, TileCode.BG, TileCode.GS, TileCode.BG, TileCode.GS, TileCode.BG, TileCode.GS, TileCode.GS, TileCode.SK},
			{TileCode.SK, TileCode.GS, TileCode.BG, TileCode.GS, TileCode.BG, TileCode.GS, TileCode.BG, TileCode.GS, TileCode.BG, TileCode.GS, TileCode.SK},
			{TileCode.GS, TileCode.GS, TileCode.GS, TileCode.BG, TileCode.GS, TileCode.BG, TileCode.GS, TileCode.BG, TileCode.GS, TileCode.GS, TileCode.GS},
			{TileCode.GS, TileCode.GS, TileCode.BG, TileCode.GS, TileCode.BG, TileCode.FG, TileCode.BG, TileCode.GS, TileCode.BG, TileCode.GS, TileCode.GS},
			{TileCode.GS, TileCode.GS, TileCode.GS, TileCode.BG, TileCode.GS, TileCode.BG, TileCode.GS, TileCode.BG, TileCode.GS, TileCode.GS, TileCode.GS},
			{TileCode.RK, TileCode.GS, TileCode.BG, TileCode.GS, TileCode.HR, TileCode.GS, TileCode.HR, TileCode.GS, TileCode.BG, TileCode.GS, TileCode.RK},
			{TileCode.RK, TileCode.GS, TileCode.GS, TileCode.BG, TileCode.GS, TileCode.BG, TileCode.GS, TileCode.BG, TileCode.GS, TileCode.GS, TileCode.RK},
			{TileCode.RK, TileCode.RK, TileCode.GS, TileCode.HR, TileCode.EN, TileCode.HR, TileCode.EN, TileCode.HR, TileCode.GS, TileCode.RK, TileCode.RK}
		},
	
		// 32, D, MEADOW
	
		{
			{TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.DC},
			{TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.RK, TileCode.GS, TileCode.BG, TileCode.GS},
			{TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.RK, TileCode.GS, TileCode.GS},
			{TileCode.GS, TileCode.GS, TileCode.GS, TileCode.RK, TileCode.RK, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.RK, TileCode.GS},
			{TileCode.GS, TileCode.GS, TileCode.RK, TileCode.GS, TileCode.HR, TileCode.RK, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS},
			{TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.FG, TileCode.GS},
			{TileCode.GS, TileCode.GS, TileCode.RK, TileCode.GS, TileCode.HR, TileCode.SK, TileCode.GS, TileCode.EN, TileCode.RK, TileCode.GS, TileCode.GS},
			{TileCode.GS, TileCode.RK, TileCode.EN, TileCode.GS, TileCode.SK, TileCode.HR, TileCode.GS, TileCode.RK, TileCode.GS, TileCode.GS, TileCode.GS},
			{TileCode.RK, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.BG, TileCode.BG, TileCode.GS},
			{TileCode.GS, TileCode.RK, TileCode.GS, TileCode.GS, TileCode.RK, TileCode.EN, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.BG, TileCode.GS},
			{TileCode.GS, TileCode.GS, TileCode.RK, TileCode.GS, TileCode.GS, TileCode.RK, TileCode.GS, TileCode.GS, TileCode.BG, TileCode.BG, TileCode.GS},
			{TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.RK, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS}
		},
	
		// 33, D, MEADOW
	
		{
			{TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.DC, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL},
			{TileCode.EN, TileCode.SK, TileCode.GS, TileCode.SK, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.SK, TileCode.GS, TileCode.SK, TileCode.EN},
			{TileCode.RK, TileCode.EN, TileCode.GS, TileCode.SK, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.SK, TileCode.GS, TileCode.EN, TileCode.RK},
			{TileCode.RK, TileCode.RK, TileCode.EN, TileCode.SK, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.SK, TileCode.EN, TileCode.RK, TileCode.RK},
			{TileCode.RK, TileCode.RK, TileCode.RK, TileCode.HR, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.HR, TileCode.RK, TileCode.RK, TileCode.RK},
			{TileCode.RK, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.HR, TileCode.GS, TileCode.HR, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.RK},
			{TileCode.RK, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.GS, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.RK},
			{TileCode.GS, TileCode.GS, TileCode.BG, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.BG, TileCode.GS, TileCode.GS},
			{TileCode.GS, TileCode.GS, TileCode.BG, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.BG, TileCode.GS, TileCode.GS},
			{TileCode.GS, TileCode.BG, TileCode.HR, TileCode.BG, TileCode.GS, TileCode.FG, TileCode.GS, TileCode.BG, TileCode.HR, TileCode.BG, TileCode.GS},
			{TileCode.GS, TileCode.GS, TileCode.BG, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.BG, TileCode.GS, TileCode.GS},
			{TileCode.GS, TileCode.GS, TileCode.BG, TileCode.GS, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.GS, TileCode.BG, TileCode.GS, TileCode.GS}
		},
	
		// 34, D, BUILDING
	
		{
			{TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.DC, TileCode.WL, TileCode.WL, TileCode.WL},
			{TileCode.RK, TileCode.RK, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS},
			{TileCode.RK, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.FG, TileCode.GS, TileCode.GS, TileCode.GS},
			{TileCode.GS, TileCode.GS, TileCode.GS, TileCode.SK, TileCode.RK, TileCode.RK, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS},
			{TileCode.GS, TileCode.GS, TileCode.SK, TileCode.RK, TileCode.GS, TileCode.EN, TileCode.RK, TileCode.GS, TileCode.RK, TileCode.RK, TileCode.RK},
			{TileCode.GS, TileCode.GS, TileCode.RK, TileCode.HR, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.RK},
			{TileCode.GS, TileCode.GS, TileCode.RK, TileCode.HR, TileCode.HR, TileCode.GS, TileCode.GS, TileCode.RK, TileCode.RK, TileCode.GS, TileCode.RK},
			{TileCode.GS, TileCode.GS, TileCode.SK, TileCode.RK, TileCode.HR, TileCode.HR, TileCode.RK, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.RK},
			{TileCode.GS, TileCode.GS, TileCode.GS, TileCode.SK, TileCode.RK, TileCode.RK, TileCode.GS, TileCode.GS, TileCode.RK, TileCode.RK, TileCode.RK},
			{TileCode.RK, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS},
			{TileCode.RK, TileCode.RK, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.BG, TileCode.BG, TileCode.BG, TileCode.BG, TileCode.BG, TileCode.BG},
			{TileCode.RK, TileCode.RK, TileCode.RK, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS}
		},
	
		// 35, D, PRYIMID
	
		{
			{TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.DC, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL},
			{TileCode.RK, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.GS, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.RK},
			{TileCode.RK, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.RK},
			{TileCode.RK, TileCode.RK, TileCode.RK, TileCode.GS, TileCode.GS, TileCode.BG, TileCode.GS, TileCode.GS, TileCode.RK, TileCode.RK, TileCode.RK},
			{TileCode.RK, TileCode.RK, TileCode.GS, TileCode.SK, TileCode.BG, TileCode.BG, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.RK, TileCode.RK},
			{TileCode.RK, TileCode.GS, TileCode.GS, TileCode.BG, TileCode.SK, TileCode.RK, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.RK},
			{TileCode.GS, TileCode.GS, TileCode.BG, TileCode.GS, TileCode.RK, TileCode.RK, TileCode.EN, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS},
			{TileCode.RK, TileCode.GS, TileCode.GS, TileCode.FG, TileCode.HR, TileCode.RK, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.RK},
			{TileCode.RK, TileCode.RK, TileCode.GS, TileCode.RK, TileCode.EN, TileCode.GS, TileCode.HR, TileCode.BG, TileCode.GS, TileCode.RK, TileCode.RK},
			{TileCode.RK, TileCode.RK, TileCode.RK, TileCode.GS, TileCode.GS, TileCode.HR, TileCode.GS, TileCode.GS, TileCode.RK, TileCode.RK, TileCode.RK},
			{TileCode.RK, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.RK},
			{TileCode.RK, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.GS, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.RK}
		},
	
		// 36, D, PACKING
	
		{
			{TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.DC, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL},
			{TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS},
			{TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS},
			{TileCode.RK, TileCode.RK, TileCode.GS, TileCode.RK, TileCode.RK, TileCode.GS, TileCode.RK, TileCode.RK, TileCode.GS, TileCode.RK, TileCode.RK},
			{TileCode.RK, TileCode.SK, TileCode.HR, TileCode.HR, TileCode.RK, TileCode.GS, TileCode.RK, TileCode.HR, TileCode.HR, TileCode.SK, TileCode.RK},
			{TileCode.RK, TileCode.SK, TileCode.SK, TileCode.HR, TileCode.SK, TileCode.HR, TileCode.SK, TileCode.HR, TileCode.SK, TileCode.SK, TileCode.RK},
			{TileCode.RK, TileCode.RK, TileCode.RK, TileCode.GS, TileCode.RK, TileCode.GS, TileCode.RK, TileCode.GS, TileCode.RK, TileCode.RK, TileCode.RK},
			{TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS},
			{TileCode.GS, TileCode.GS, TileCode.BG, TileCode.GS, TileCode.BG, TileCode.GS, TileCode.BG, TileCode.GS, TileCode.BG, TileCode.GS, TileCode.GS},
			{TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.FG, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS},
			{TileCode.GS, TileCode.GS, TileCode.BG, TileCode.GS, TileCode.BG, TileCode.GS, TileCode.BG, TileCode.GS, TileCode.BG, TileCode.GS, TileCode.GS},
			{TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS}
		},
	
		// 37, D, ROOMS
	
		{
			{TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.DC, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL},
			{TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS},
			{TileCode.GS, TileCode.BG, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.BG, TileCode.GS},
			{TileCode.GS, TileCode.BG, TileCode.GS, TileCode.RK, TileCode.RK, TileCode.SK, TileCode.RK, TileCode.RK, TileCode.GS, TileCode.BG, TileCode.GS},
			{TileCode.GS, TileCode.GS, TileCode.RK, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.RK, TileCode.GS, TileCode.GS},
			{TileCode.RK, TileCode.RK, TileCode.RK, TileCode.GS, TileCode.RK, TileCode.SK, TileCode.RK, TileCode.GS, TileCode.RK, TileCode.RK, TileCode.RK},
			{TileCode.GS, TileCode.GS, TileCode.SK, TileCode.GS, TileCode.FG, TileCode.SK, TileCode.SK, TileCode.GS, TileCode.SK, TileCode.GS, TileCode.GS},
			{TileCode.GS, TileCode.GS, TileCode.RK, TileCode.GS, TileCode.RK, TileCode.SK, TileCode.RK, TileCode.GS, TileCode.RK, TileCode.GS, TileCode.GS},
			{TileCode.GS, TileCode.BG, TileCode.RK, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.RK, TileCode.BG, TileCode.GS},
			{TileCode.GS, TileCode.GS, TileCode.GS, TileCode.RK, TileCode.RK, TileCode.SK, TileCode.RK, TileCode.RK, TileCode.GS, TileCode.GS, TileCode.GS},
			{TileCode.GS, TileCode.BG, TileCode.GS, TileCode.RK, TileCode.HR, TileCode.HR, TileCode.HR, TileCode.RK, TileCode.GS, TileCode.BG, TileCode.GS},
			{TileCode.GS, TileCode.GS, TileCode.GS, TileCode.RK, TileCode.HR, TileCode.HR, TileCode.HR, TileCode.RK, TileCode.GS, TileCode.GS, TileCode.GS}
		},
	
		// 38, E, MEADOW
	
		{
			{TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.DC, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL},
			{TileCode.HR, TileCode.HR, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.HR, TileCode.HR},
			{TileCode.HR, TileCode.HR, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.HR, TileCode.HR},
			{TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.BG, TileCode.GS, TileCode.RK, TileCode.GS, TileCode.GS, TileCode.GS},
			{TileCode.GS, TileCode.GS, TileCode.RK, TileCode.EN, TileCode.RK, TileCode.GS, TileCode.GS, TileCode.EN, TileCode.GS, TileCode.GS, TileCode.GS},
			{TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.BG, TileCode.GS, TileCode.RK, TileCode.GS, TileCode.GS, TileCode.GS},
			{TileCode.GS, TileCode.GS, TileCode.HR, TileCode.GS, TileCode.BG, TileCode.FG, TileCode.BG, TileCode.GS, TileCode.HR, TileCode.GS, TileCode.GS},
			{TileCode.GS, TileCode.GS, TileCode.GS, TileCode.RK, TileCode.GS, TileCode.BG, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS},
			{TileCode.GS, TileCode.GS, TileCode.GS, TileCode.EN, TileCode.GS, TileCode.GS, TileCode.RK, TileCode.EN, TileCode.RK, TileCode.GS, TileCode.GS},
			{TileCode.GS, TileCode.GS, TileCode.GS, TileCode.RK, TileCode.GS, TileCode.BG, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS},
			{TileCode.HR, TileCode.HR, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.HR, TileCode.HR},
			{TileCode.HR, TileCode.HR, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.HR, TileCode.HR}
		},
	
		// 39, E, MEADOW
	
		{
			{TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.DC, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL},
			{TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS},
			{TileCode.GS, TileCode.GS, TileCode.GS, TileCode.BG, TileCode.BG, TileCode.GS, TileCode.HR, TileCode.HR, TileCode.GS, TileCode.GS, TileCode.GS},
			{TileCode.GS, TileCode.FG, TileCode.GS, TileCode.BG, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.HR, TileCode.GS, TileCode.HR, TileCode.GS},
			{TileCode.GS, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.GS, TileCode.SK, TileCode.GS, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.GS},
			{TileCode.EN, TileCode.GS, TileCode.HR, TileCode.GS, TileCode.HR, TileCode.GS, TileCode.BG, TileCode.GS, TileCode.BG, TileCode.GS, TileCode.BG},
			{TileCode.GS, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.SK, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.GS},
			{TileCode.GS, TileCode.GS, TileCode.BG, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.BG, TileCode.GS, TileCode.GS},
			{TileCode.GS, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.SK, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.GS},
			{TileCode.GS, TileCode.GS, TileCode.BG, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.BG, TileCode.GS, TileCode.GS},
			{TileCode.GS, TileCode.GS, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.SK, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.GS, TileCode.GS},
			{TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.EN, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS}
		},
	
		// 40, E, MEADOW
	
		{
			{TileCode.WL, TileCode.WL, TileCode.WL, TileCode.DC, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL},
			{TileCode.RK, TileCode.RK, TileCode.GS, TileCode.GS, TileCode.HR, TileCode.HR, TileCode.HR, TileCode.GS, TileCode.GS, TileCode.RK, TileCode.RK},
			{TileCode.RK, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.HR, TileCode.BG, TileCode.HR, TileCode.GS, TileCode.RK, TileCode.RK, TileCode.RK},
			{TileCode.GS, TileCode.RK, TileCode.RK, TileCode.GS, TileCode.HR, TileCode.HR, TileCode.HR, TileCode.EN, TileCode.GS, TileCode.RK, TileCode.GS},
			{TileCode.GS, TileCode.RK, TileCode.GS, TileCode.EN, TileCode.GS, TileCode.GS, TileCode.BG, TileCode.RK, TileCode.GS, TileCode.GS, TileCode.GS},
			{TileCode.HR, TileCode.HR, TileCode.BG, TileCode.HR, TileCode.BG, TileCode.GS, TileCode.GS, TileCode.FG, TileCode.GS, TileCode.GS, TileCode.GS},
			{TileCode.HR, TileCode.GS, TileCode.GS, TileCode.HR, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.BG, TileCode.GS, TileCode.GS, TileCode.GS},
			{TileCode.HR, TileCode.GS, TileCode.GS, TileCode.HR, TileCode.GS, TileCode.BG, TileCode.GS, TileCode.GS, TileCode.EN, TileCode.GS, TileCode.GS},
			{TileCode.HR, TileCode.HR, TileCode.HR, TileCode.HR, TileCode.EN, TileCode.RK, TileCode.BG, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS},
			{TileCode.GS, TileCode.RK, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.HR, TileCode.HR, TileCode.HR, TileCode.GS, TileCode.RK, TileCode.GS},
			{TileCode.RK, TileCode.RK, TileCode.RK, TileCode.GS, TileCode.GS, TileCode.HR, TileCode.GS, TileCode.HR, TileCode.RK, TileCode.RK, TileCode.RK},
			{TileCode.RK, TileCode.RK, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.HR, TileCode.HR, TileCode.HR, TileCode.GS, TileCode.RK, TileCode.RK}
		},
	
		// 41, E, MEADOW
	
		{
			{TileCode.DC, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL},
			{TileCode.FG, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.RK, TileCode.EN, TileCode.EN, TileCode.RK, TileCode.GS, TileCode.GS, TileCode.GS},
			{TileCode.GS, TileCode.HR, TileCode.BG, TileCode.BG, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.BG, TileCode.HR, TileCode.GS},
			{TileCode.GS, TileCode.BG, TileCode.HR, TileCode.HR, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.HR, TileCode.BG, TileCode.GS},
			{TileCode.GS, TileCode.BG, TileCode.HR, TileCode.HR, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.HR, TileCode.HR, TileCode.GS},
			{TileCode.RK, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.RK},
			{TileCode.EN, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.HR, TileCode.HR, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.EN},
			{TileCode.EN, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.HR, TileCode.HR, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.EN},
			{TileCode.RK, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.RK},
			{TileCode.GS, TileCode.BS, TileCode.BG, TileCode.BG, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.BG, TileCode.BS, TileCode.GS},
			{TileCode.GS, TileCode.BG, TileCode.BS, TileCode.BS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.BS, TileCode.BG, TileCode.GS},
			{TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.RK, TileCode.EN, TileCode.EN, TileCode.RK, TileCode.GS, TileCode.GS, TileCode.GS}
		},
	
		// 42, E, PYRAMID
	
		{
			{TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.DC, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL},
			{TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.FG, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS},
			{TileCode.GS, TileCode.BG, TileCode.HR, TileCode.BG, TileCode.HR, TileCode.BG, TileCode.HR, TileCode.BG, TileCode.HR, TileCode.BG, TileCode.GS},
			{TileCode.GS, TileCode.GS, TileCode.BG, TileCode.HR, TileCode.BG, TileCode.HR, TileCode.BG, TileCode.HR, TileCode.BG, TileCode.GS, TileCode.GS},
			{TileCode.GS, TileCode.GS, TileCode.GS, TileCode.BG, TileCode.HR, TileCode.BG, TileCode.HR, TileCode.BG, TileCode.GS, TileCode.GS, TileCode.GS},
			{TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.BG, TileCode.HR, TileCode.BG, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS},
			{TileCode.EN, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.BS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.EN},
			{TileCode.EN, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.SK, TileCode.GS, TileCode.SK, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.EN},
			{TileCode.EN, TileCode.GS, TileCode.GS, TileCode.SK, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.SK, TileCode.GS, TileCode.GS, TileCode.EN},
			{TileCode.GS, TileCode.GS, TileCode.SK, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.SK, TileCode.GS, TileCode.GS},
			{TileCode.GS, TileCode.SK, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.SK, TileCode.GS},
			{TileCode.SK, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.SK}
		},
	
		// 43, E, PACKING
	
		{
			{TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.DC, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL},
			{TileCode.RK, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.FG, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.RK},
			{TileCode.RK, TileCode.GS, TileCode.GS, TileCode.BG, TileCode.GS, TileCode.BG, TileCode.GS, TileCode.BG, TileCode.GS, TileCode.GS, TileCode.RK},
			{TileCode.RK, TileCode.GS, TileCode.GS, TileCode.BG, TileCode.GS, TileCode.BG, TileCode.GS, TileCode.BG, TileCode.GS, TileCode.GS, TileCode.RK},
			{TileCode.GS, TileCode.GS, TileCode.GS, TileCode.BG, TileCode.GS, TileCode.BG, TileCode.GS, TileCode.BG, TileCode.GS, TileCode.GS, TileCode.GS},
			{TileCode.GS, TileCode.GS, TileCode.GS, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.GS, TileCode.GS, TileCode.GS},
			{TileCode.GS, TileCode.GS, TileCode.RK, TileCode.RK, TileCode.SK, TileCode.RK, TileCode.SK, TileCode.RK, TileCode.RK, TileCode.GS, TileCode.GS},
			{TileCode.GS, TileCode.GS, TileCode.RK, TileCode.SK, TileCode.SK, TileCode.SK, TileCode.SK, TileCode.SK, TileCode.RK, TileCode.GS, TileCode.GS},
			{TileCode.GS, TileCode.GS, TileCode.RK, TileCode.RK, TileCode.SK, TileCode.RK, TileCode.SK, TileCode.BS, TileCode.RK, TileCode.GS, TileCode.GS},
			{TileCode.GS, TileCode.GS, TileCode.GS, TileCode.BG, TileCode.GS, TileCode.BG, TileCode.GS, TileCode.BG, TileCode.GS, TileCode.GS, TileCode.GS},
			{TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS},
			{TileCode.GS, TileCode.EN, TileCode.HR, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.EN, TileCode.EN, TileCode.GS}
		},
	
		// 44, E, PACKING
	
		{
			{TileCode.WL, TileCode.DC, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL},
			{TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.BG, TileCode.GS, TileCode.GS, TileCode.GS},
			{TileCode.GS, TileCode.FG, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.BG, TileCode.BG, TileCode.GS, TileCode.GS},
			{TileCode.GS, TileCode.BG, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.BG, TileCode.GS, TileCode.GS, TileCode.GS},
			{TileCode.RK, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.RK, TileCode.RK, TileCode.GS, TileCode.RK, TileCode.RK, TileCode.RK},
			{TileCode.EN, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.RK, TileCode.GS, TileCode.GS, TileCode.SK, TileCode.SK, TileCode.RK},
			{TileCode.EN, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.HR, TileCode.RK, TileCode.GS, TileCode.GS, TileCode.SK, TileCode.SK, TileCode.RK},
			{TileCode.EN, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.RK, TileCode.GS, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.RK},
			{TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.BG, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS},
			{TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.BG, TileCode.BG, TileCode.GS, TileCode.GS, TileCode.GS},
			{TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.BG, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS},
			{TileCode.RK, TileCode.HR, TileCode.RK, TileCode.RK, TileCode.EN, TileCode.RK, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS}
		},
	
		// 45, E, ROOMS
	
		{
			{TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.DC, TileCode.WL, TileCode.WL},
			{TileCode.EN, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.EN, TileCode.RK, TileCode.EN, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.EN},
			{TileCode.GS, TileCode.HR, TileCode.HR, TileCode.HR, TileCode.BS, TileCode.RK, TileCode.SK, TileCode.HR, TileCode.HR, TileCode.HR, TileCode.GS},
			{TileCode.GS, TileCode.BG, TileCode.FG, TileCode.BG, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.BG, TileCode.HR, TileCode.BG, TileCode.GS},
			{TileCode.GS, TileCode.HR, TileCode.BG, TileCode.BG, TileCode.BS, TileCode.RK, TileCode.SK, TileCode.HR, TileCode.HR, TileCode.HR, TileCode.GS},
			{TileCode.EN, TileCode.SK, TileCode.GS, TileCode.SK, TileCode.EN, TileCode.RK, TileCode.EN, TileCode.BS, TileCode.GS, TileCode.BS, TileCode.EN},
			{TileCode.RK, TileCode.RK, TileCode.GS, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.GS, TileCode.RK, TileCode.RK},
			{TileCode.EN, TileCode.BS, TileCode.GS, TileCode.BS, TileCode.EN, TileCode.RK, TileCode.EN, TileCode.SK, TileCode.GS, TileCode.SK, TileCode.EN},
			{TileCode.GS, TileCode.HR, TileCode.HR, TileCode.HR, TileCode.SK, TileCode.RK, TileCode.BS, TileCode.HR, TileCode.BG, TileCode.HR, TileCode.GS},
			{TileCode.GS, TileCode.HR, TileCode.HR, TileCode.BG, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.HR, TileCode.HR, TileCode.BG, TileCode.GS},
			{TileCode.GS, TileCode.HR, TileCode.BG, TileCode.GS, TileCode.SK, TileCode.RK, TileCode.BS, TileCode.HR, TileCode.HR, TileCode.HR, TileCode.GS},
			{TileCode.EN, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.EN, TileCode.RK, TileCode.EN, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.EN}
		},
	
		// 46, E, ROOMS
	
		{
			{TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.DC, TileCode.WL, TileCode.WL},
			{TileCode.GS, TileCode.SK, TileCode.GS, TileCode.BG, TileCode.GS, TileCode.GS, TileCode.RK, TileCode.GS, TileCode.HR, TileCode.GS, TileCode.EN},
			{TileCode.GS, TileCode.GS, TileCode.HR, TileCode.BG, TileCode.HR, TileCode.GS, TileCode.RK, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.EN},
			{TileCode.GS, TileCode.GS, TileCode.GS, TileCode.RK, TileCode.GS, TileCode.GS, TileCode.RK, TileCode.GS, TileCode.HR, TileCode.GS, TileCode.EN},
			{TileCode.GS, TileCode.GS, TileCode.GS, TileCode.RK, TileCode.GS, TileCode.GS, TileCode.BG, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.EN},
			{TileCode.RK, TileCode.HR, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.BG, TileCode.RK, TileCode.HR, TileCode.RK, TileCode.RK},
			{TileCode.GS, TileCode.GS, TileCode.GS, TileCode.RK, TileCode.GS, TileCode.FG, TileCode.GS, TileCode.RK, TileCode.GS, TileCode.GS, TileCode.GS},
			{TileCode.GS, TileCode.GS, TileCode.GS, TileCode.RK, TileCode.BG, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.BG},
			{TileCode.GS, TileCode.GS, TileCode.GS, TileCode.BG, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.RK, TileCode.GS, TileCode.GS, TileCode.GS},
			{TileCode.GS, TileCode.GS, TileCode.GS, TileCode.RK, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.RK, TileCode.GS, TileCode.GS, TileCode.GS},
			{TileCode.GS, TileCode.GS, TileCode.HR, TileCode.RK, TileCode.BG, TileCode.GS, TileCode.BG, TileCode.BG, TileCode.HR, TileCode.GS, TileCode.GS},
			{TileCode.GS, TileCode.EN, TileCode.GS, TileCode.RK, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.BG, TileCode.GS, TileCode.GS, TileCode.GS}
		},
	
		// 47, E, ROOMS
	
		{
			{TileCode.DC, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL},
			{TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.RK},
			{TileCode.GS, TileCode.BG, TileCode.GS, TileCode.BG, TileCode.GS, TileCode.GS, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.RK},
			{TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.RK, TileCode.GS, TileCode.SK, TileCode.RK, TileCode.RK},
			{TileCode.GS, TileCode.HR, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.RK},
			{TileCode.GS, TileCode.GS, TileCode.GS, TileCode.EN, TileCode.GS, TileCode.GS, TileCode.RK, TileCode.RK, TileCode.GS, TileCode.GS, TileCode.RK},
			{TileCode.RK, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.GS, TileCode.EN, TileCode.RK, TileCode.GS, TileCode.RK, TileCode.RK},
			{TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.RK, TileCode.RK, TileCode.GS, TileCode.GS, TileCode.RK},
			{TileCode.GS, TileCode.BG, TileCode.GS, TileCode.GS, TileCode.FG, TileCode.BG, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.SK, TileCode.RK},
			{TileCode.GS, TileCode.BG, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.RK, TileCode.GS, TileCode.GS, TileCode.RK, TileCode.RK},
			{TileCode.GS, TileCode.SK, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.RK},
			{TileCode.GS, TileCode.GS, TileCode.GS, TileCode.EN, TileCode.GS, TileCode.GS, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.RK}
		},
	
		// 48, SPECIAL, BEFORE FINAL
	
		{
			{TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.DC, TileCode.WL, TileCode.WL},
			{TileCode.EN, TileCode.EN, TileCode.EN, TileCode.EN, TileCode.RK, TileCode.RK, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.FG},
			{TileCode.RK, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.BG, TileCode.GS, TileCode.BG, TileCode.BG, TileCode.GS, TileCode.GS},
			{TileCode.EN, TileCode.GS, TileCode.GS, TileCode.RK, TileCode.GS, TileCode.RK, TileCode.GS, TileCode.GS, TileCode.BG, TileCode.BG, TileCode.HR},
			{TileCode.EN, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.GS, TileCode.RK, TileCode.RK, TileCode.GS, TileCode.GS, TileCode.BG, TileCode.HR},
			{TileCode.RK, TileCode.RK, TileCode.SK, TileCode.SK, TileCode.SK, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.HR},
			{TileCode.RK, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.SK, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.GS, TileCode.RK, TileCode.RK},
			{TileCode.EN, TileCode.RK, TileCode.SK, TileCode.SK, TileCode.SK, TileCode.GS, TileCode.GS, TileCode.RK, TileCode.GS, TileCode.GS, TileCode.RK},
			{TileCode.EN, TileCode.RK, TileCode.RK, TileCode.GS, TileCode.RK, TileCode.RK, TileCode.GS, TileCode.RK, TileCode.RK, TileCode.GS, TileCode.HR},
			{TileCode.EN, TileCode.RK, TileCode.RK, TileCode.GS, TileCode.RK, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.BG, TileCode.GS, TileCode.HR},
			{TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.BG, TileCode.GS, TileCode.RK},
			{TileCode.HR, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.RK, TileCode.RK, TileCode.GS, TileCode.HR, TileCode.HR, TileCode.HR, TileCode.HR}
		},
	
		// 49, SPECIAL, (|<)
	
		{
			{TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.DO, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL},
			{TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS},
			{TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS},
			{TileCode.GS, TileCode.GS, TileCode.RK, TileCode.RK, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.RK, TileCode.RK, TileCode.GS, TileCode.GS},
			{TileCode.GS, TileCode.RK, TileCode.GS, TileCode.RK, TileCode.GS, TileCode.GS, TileCode.RK, TileCode.GS, TileCode.GS, TileCode.RK, TileCode.GS},
			{TileCode.GS, TileCode.RK, TileCode.GS, TileCode.RK, TileCode.GS, TileCode.RK, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.RK, TileCode.GS},
			{TileCode.GS, TileCode.RK, TileCode.GS, TileCode.RK, TileCode.GS, TileCode.RK, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.RK, TileCode.GS},
			{TileCode.GS, TileCode.RK, TileCode.GS, TileCode.RK, TileCode.GS, TileCode.GS, TileCode.RK, TileCode.GS, TileCode.GS, TileCode.RK, TileCode.GS},
			{TileCode.GS, TileCode.GS, TileCode.RK, TileCode.RK, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.RK, TileCode.RK, TileCode.GS, TileCode.GS},
			{TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS},
			{TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.FG, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS},
			{TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS}
		},
	
		// 50, SPECIAL, FINAL
	
		{
			{TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.DC, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL, TileCode.WL},
			{TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.FG, TileCode.GS, TileCode.RK, TileCode.EN, TileCode.GS, TileCode.GS},
			{TileCode.GS, TileCode.GS, TileCode.HR, TileCode.BG, TileCode.BG, TileCode.GS, TileCode.GS, TileCode.RK, TileCode.GS, TileCode.GS, TileCode.GS},
			{TileCode.GS, TileCode.HR, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.RK, TileCode.HR, TileCode.HR, TileCode.HR},
			{TileCode.RK, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.GS, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.BG, TileCode.BG, TileCode.HR},
			{TileCode.GS, TileCode.GS, TileCode.GS, TileCode.RK, TileCode.SK, TileCode.GS, TileCode.SK, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS},
			{TileCode.GS, TileCode.HR, TileCode.GS, TileCode.RK, TileCode.GS, TileCode.RK, TileCode.GS, TileCode.RK, TileCode.BG, TileCode.BG, TileCode.HR},
			{TileCode.GS, TileCode.GS, TileCode.GS, TileCode.GS, TileCode.SK, TileCode.GS, TileCode.SK, TileCode.RK, TileCode.HR, TileCode.HR, TileCode.HR},
			{TileCode.RK, TileCode.GS, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.GS, TileCode.RK, TileCode.RK, TileCode.RK, TileCode.RK},
			{TileCode.HR, TileCode.GS, TileCode.GS, TileCode.RK, TileCode.GS, TileCode.HR, TileCode.GS, TileCode.BG, TileCode.GS, TileCode.HR, TileCode.GS},
			{TileCode.HR, TileCode.GS, TileCode.GS, TileCode.RK, TileCode.HR, TileCode.GS, TileCode.HR, TileCode.GS, TileCode.HR, TileCode.GS, TileCode.EN},
			{TileCode.HR, TileCode.HR, TileCode.EN, TileCode.RK, TileCode.GS, TileCode.HR, TileCode.GS, TileCode.HR, TileCode.GS, TileCode.HR, TileCode.GS}
		}
	
	};
	
	/* LEVEL CODES */
	
	public static final String levelcode[] =
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
}
