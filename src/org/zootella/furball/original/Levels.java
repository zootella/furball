package org.zootella.furball.original;
	
public class Levels {
	
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
	
	public static Tile levelbank[][][] =
	{
	
		// 1, SPECIAL, FIRST
	
		{
			{Tile.wl, Tile.wl, Tile.wl, Tile.wl, Tile.wl, Tile.dc, Tile.wl, Tile.wl, Tile.wl, Tile.wl, Tile.wl},
			{Tile.gs, Tile.gs, Tile.rk, Tile.rk, Tile.gs, Tile.gs, Tile.gs, Tile.rk, Tile.rk, Tile.gs, Tile.gs},
			{Tile.gs, Tile.gs, Tile.rk, Tile.rk, Tile.gs, Tile.gs, Tile.gs, Tile.rk, Tile.rk, Tile.gs, Tile.gs},
			{Tile.gs, Tile.gs, Tile.rk, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.rk, Tile.gs, Tile.gs},
			{Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.hr, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs},
			{Tile.en, Tile.gs, Tile.rk, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.rk, Tile.gs, Tile.en},
			{Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.hr, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs},
			{Tile.en, Tile.gs, Tile.rk, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.rk, Tile.gs, Tile.en},
			{Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.hr, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs},
			{Tile.gs, Tile.gs, Tile.rk, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.rk, Tile.gs, Tile.gs},
			{Tile.gs, Tile.gs, Tile.rk, Tile.rk, Tile.gs, Tile.gs, Tile.gs, Tile.rk, Tile.rk, Tile.gs, Tile.gs},
			{Tile.gs, Tile.gs, Tile.rk, Tile.rk, Tile.gs, Tile.fg, Tile.gs, Tile.rk, Tile.rk, Tile.gs, Tile.gs}
		},
	
		// 2, TUTORIAL, MAZE
	
		{
			{Tile.wl, Tile.wl, Tile.wl, Tile.wl, Tile.wl, Tile.wl, Tile.wl, Tile.wl, Tile.wl, Tile.dc, Tile.wl},
			{Tile.rk, Tile.rk, Tile.rk, Tile.rk, Tile.rk, Tile.rk, Tile.rk, Tile.rk, Tile.rk, Tile.gs, Tile.rk},
			{Tile.rk, Tile.hr, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.rk, Tile.gs, Tile.gs, Tile.gs, Tile.rk},
			{Tile.rk, Tile.rk, Tile.rk, Tile.rk, Tile.rk, Tile.gs, Tile.rk, Tile.gs, Tile.rk, Tile.rk, Tile.rk},
			{Tile.rk, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.rk, Tile.hr, Tile.rk},
			{Tile.rk, Tile.gs, Tile.rk, Tile.rk, Tile.rk, Tile.rk, Tile.rk, Tile.gs, Tile.rk, Tile.gs, Tile.rk},
			{Tile.rk, Tile.gs, Tile.rk, Tile.gs, Tile.gs, Tile.gs, Tile.rk, Tile.gs, Tile.rk, Tile.gs, Tile.rk},
			{Tile.rk, Tile.gs, Tile.rk, Tile.gs, Tile.rk, Tile.gs, Tile.rk, Tile.gs, Tile.rk, Tile.gs, Tile.rk},
			{Tile.rk, Tile.gs, Tile.gs, Tile.gs, Tile.rk, Tile.gs, Tile.rk, Tile.gs, Tile.rk, Tile.gs, Tile.rk},
			{Tile.rk, Tile.rk, Tile.rk, Tile.rk, Tile.rk, Tile.gs, Tile.rk, Tile.gs, Tile.rk, Tile.gs, Tile.rk},
			{Tile.fg, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.rk, Tile.gs, Tile.gs, Tile.gs, Tile.rk},
			{Tile.rk, Tile.rk, Tile.rk, Tile.rk, Tile.rk, Tile.rk, Tile.rk, Tile.rk, Tile.rk, Tile.rk, Tile.rk}
		},
	
		// 3, TUTORIAL, COLLECT HEARTS
	
		{
			{Tile.dc, Tile.wl, Tile.wl, Tile.wl, Tile.wl, Tile.wl, Tile.wl, Tile.wl, Tile.wl, Tile.wl, Tile.wl},
			{Tile.fg, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs},
			{Tile.rk, Tile.rk, Tile.rk, Tile.rk, Tile.rk, Tile.rk, Tile.rk, Tile.rk, Tile.rk, Tile.gs, Tile.rk},
			{Tile.rk, Tile.rk, Tile.rk, Tile.rk, Tile.gs, Tile.gs, Tile.gs, Tile.rk, Tile.rk, Tile.gs, Tile.rk},
			{Tile.rk, Tile.rk, Tile.rk, Tile.rk, Tile.gs, Tile.rk, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.rk},
			{Tile.rk, Tile.rk, Tile.rk, Tile.rk, Tile.gs, Tile.rk, Tile.rk, Tile.rk, Tile.rk, Tile.rk, Tile.rk},
			{Tile.rk, Tile.rk, Tile.rk, Tile.rk, Tile.gs, Tile.gs, Tile.gs, Tile.rk, Tile.rk, Tile.rk, Tile.rk},
			{Tile.rk, Tile.rk, Tile.rk, Tile.rk, Tile.rk, Tile.rk, Tile.gs, Tile.rk, Tile.rk, Tile.rk, Tile.rk},
			{Tile.rk, Tile.rk, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.rk, Tile.hr, Tile.hr, Tile.rk},
			{Tile.rk, Tile.rk, Tile.gs, Tile.rk, Tile.rk, Tile.rk, Tile.rk, Tile.rk, Tile.hr, Tile.hr, Tile.rk},
			{Tile.rk, Tile.rk, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.hr, Tile.hr, Tile.rk},
			{Tile.rk, Tile.rk, Tile.rk, Tile.rk, Tile.rk, Tile.rk, Tile.rk, Tile.rk, Tile.rk, Tile.rk, Tile.rk}
		},
	
		// 4, TUTORIAL, AVOID ENEMY
	
		{
			{Tile.wl, Tile.wl, Tile.wl, Tile.wl, Tile.wl, Tile.dc, Tile.wl, Tile.wl, Tile.wl, Tile.wl, Tile.wl},
			{Tile.gs, Tile.gs, Tile.gs, Tile.rk, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs},
			{Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs},
			{Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs},
			{Tile.rk, Tile.gs, Tile.gs, Tile.en, Tile.gs, Tile.gs, Tile.gs, Tile.rk, Tile.gs, Tile.gs, Tile.gs},
			{Tile.gs, Tile.gs, Tile.gs, Tile.bg, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs},
			{Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.hr, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs},
			{Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.bg, Tile.gs, Tile.gs, Tile.gs},
			{Tile.gs, Tile.gs, Tile.gs, Tile.rk, Tile.gs, Tile.gs, Tile.gs, Tile.en, Tile.gs, Tile.gs, Tile.rk},
			{Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs},
			{Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs},
			{Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.fg, Tile.gs, Tile.rk, Tile.gs, Tile.gs, Tile.gs}
		},
	
		// 5, TUTORIAL, PUSH BOX INTO SINK
	
		{
			{Tile.wl, Tile.wl, Tile.wl, Tile.wl, Tile.wl, Tile.dc, Tile.wl, Tile.wl, Tile.wl, Tile.wl, Tile.wl},
			{Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs},
			{Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs},
			{Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs},
			{Tile.gs, Tile.bg, Tile.gs, Tile.bg, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs},
			{Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.sk, Tile.sk, Tile.gs, Tile.gs},
			{Tile.gs, Tile.bg, Tile.gs, Tile.bg, Tile.gs, Tile.gs, Tile.gs, Tile.sk, Tile.sk, Tile.gs, Tile.gs},
			{Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.sk, Tile.sk, Tile.gs, Tile.gs},
			{Tile.gs, Tile.bg, Tile.gs, Tile.bg, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs},
			{Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs},
			{Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs},
			{Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.fg, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs}
		},
	
		// 6, TUTORIAL, MOVE BOX TO GET OUT
	
		{
			{Tile.wl, Tile.wl, Tile.wl, Tile.wl, Tile.wl, Tile.dc, Tile.wl, Tile.wl, Tile.wl, Tile.wl, Tile.wl},
			{Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs},
			{Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs},
			{Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs},
			{Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.rk, Tile.gs, Tile.rk, Tile.gs, Tile.gs, Tile.gs, Tile.gs},
			{Tile.gs, Tile.rk, Tile.rk, Tile.rk, Tile.rk, Tile.sk, Tile.rk, Tile.rk, Tile.rk, Tile.rk, Tile.gs},
			{Tile.gs, Tile.rk, Tile.gs, Tile.gs, Tile.rk, Tile.gs, Tile.rk, Tile.gs, Tile.gs, Tile.rk, Tile.gs},
			{Tile.gs, Tile.rk, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.rk, Tile.gs},
			{Tile.gs, Tile.rk, Tile.gs, Tile.fg, Tile.gs, Tile.gs, Tile.gs, Tile.bg, Tile.gs, Tile.rk, Tile.gs},
			{Tile.gs, Tile.rk, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.rk, Tile.gs},
			{Tile.gs, Tile.rk, Tile.rk, Tile.rk, Tile.rk, Tile.rk, Tile.rk, Tile.rk, Tile.rk, Tile.rk, Tile.gs},
			{Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs}
		},
	
		// 7, TUTORIAL, USE BOX TO BLOCK ENEMY
	
		{
			{Tile.wl, Tile.wl, Tile.wl, Tile.wl, Tile.wl, Tile.dc, Tile.wl, Tile.wl, Tile.wl, Tile.wl, Tile.wl},
			{Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs},
			{Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs},
			{Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs},
			{Tile.rk, Tile.rk, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs},
			{Tile.rk, Tile.rk, Tile.rk, Tile.rk, Tile.rk, Tile.rk, Tile.gs, Tile.gs, Tile.gs, Tile.rk, Tile.rk},
			{Tile.rk, Tile.rk, Tile.rk, Tile.rk, Tile.rk, Tile.en, Tile.gs, Tile.gs, Tile.gs, Tile.hr, Tile.rk},
			{Tile.rk, Tile.rk, Tile.rk, Tile.rk, Tile.rk, Tile.rk, Tile.gs, Tile.gs, Tile.gs, Tile.rk, Tile.rk},
			{Tile.rk, Tile.rk, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs},
			{Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs},
			{Tile.gs, Tile.gs, Tile.gs, Tile.fg, Tile.gs, Tile.bg, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs},
			{Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs}
		},
	
		// 8, TUTORIAL, COLLECT HEART BY PUSING OVER BOX
	
		{
			{Tile.wl, Tile.wl, Tile.wl, Tile.wl, Tile.wl, Tile.wl, Tile.wl, Tile.wl, Tile.wl, Tile.wl, Tile.dc},
			{Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs},
			{Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs},
			{Tile.gs, Tile.gs, Tile.gs, Tile.rk, Tile.rk, Tile.gs, Tile.rk, Tile.gs, Tile.rk, Tile.sk, Tile.rk},
			{Tile.gs, Tile.bg, Tile.gs, Tile.rk, Tile.rk, Tile.gs, Tile.rk, Tile.sk, Tile.rk, Tile.hr, Tile.rk},
			{Tile.gs, Tile.bg, Tile.gs, Tile.rk, Tile.rk, Tile.sk, Tile.rk, Tile.hr, Tile.rk, Tile.en, Tile.rk},
			{Tile.gs, Tile.bg, Tile.gs, Tile.rk, Tile.rk, Tile.hr, Tile.rk, Tile.en, Tile.rk, Tile.rk, Tile.rk},
			{Tile.gs, Tile.fg, Tile.gs, Tile.rk, Tile.rk, Tile.en, Tile.rk, Tile.rk, Tile.rk, Tile.rk, Tile.rk},
			{Tile.gs, Tile.bg, Tile.gs, Tile.rk, Tile.rk, Tile.rk, Tile.rk, Tile.rk, Tile.rk, Tile.rk, Tile.rk},
			{Tile.gs, Tile.bg, Tile.gs, Tile.rk, Tile.rk, Tile.rk, Tile.rk, Tile.rk, Tile.rk, Tile.rk, Tile.rk},
			{Tile.gs, Tile.bg, Tile.gs, Tile.rk, Tile.rk, Tile.rk, Tile.rk, Tile.rk, Tile.rk, Tile.rk, Tile.rk},
			{Tile.gs, Tile.gs, Tile.gs, Tile.rk, Tile.rk, Tile.rk, Tile.rk, Tile.rk, Tile.rk, Tile.rk, Tile.rk}
		},
	
		// 9, TUTORIAL, SIMPLE LOGIC WALKAROUND
	
		{
			{Tile.wl, Tile.wl, Tile.wl, Tile.wl, Tile.wl, Tile.wl, Tile.wl, Tile.wl, Tile.wl, Tile.wl, Tile.dc},
			{Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs},
			{Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs},
			{Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.hr, Tile.gs, Tile.bg, Tile.gs, Tile.gs},
			{Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs},
			{Tile.rk, Tile.gs, Tile.gs, Tile.gs, Tile.rk, Tile.rk, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.rk},
			{Tile.rk, Tile.gs, Tile.gs, Tile.gs, Tile.en, Tile.rk, Tile.rk, Tile.rk, Tile.rk, Tile.rk, Tile.rk},
			{Tile.rk, Tile.gs, Tile.gs, Tile.gs, Tile.rk, Tile.rk, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.rk},
			{Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs},
			{Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.sk, Tile.gs, Tile.bg, Tile.gs, Tile.gs},
			{Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs},
			{Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.fg}
		},
	
		// 10, A, MEADOW
	
		{
			{Tile.wl, Tile.wl, Tile.dc, Tile.wl, Tile.wl, Tile.wl, Tile.wl, Tile.wl, Tile.wl, Tile.wl, Tile.wl},
			{Tile.gs, Tile.gs, Tile.gs, Tile.rk, Tile.gs, Tile.gs, Tile.hr, Tile.rk, Tile.gs, Tile.gs, Tile.en},
			{Tile.gs, Tile.hr, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs},
			{Tile.en, Tile.gs, Tile.gs, Tile.gs, Tile.rk, Tile.gs, Tile.rk, Tile.gs, Tile.bg, Tile.gs, Tile.gs},
			{Tile.rk, Tile.gs, Tile.gs, Tile.rk, Tile.rk, Tile.en, Tile.rk, Tile.rk, Tile.gs, Tile.gs, Tile.rk},
			{Tile.en, Tile.gs, Tile.rk, Tile.rk, Tile.gs, Tile.gs, Tile.gs, Tile.rk, Tile.rk, Tile.gs, Tile.hr},
			{Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.hr},
			{Tile.gs, Tile.gs, Tile.rk, Tile.rk, Tile.bg, Tile.gs, Tile.gs, Tile.rk, Tile.rk, Tile.gs, Tile.hr},
			{Tile.gs, Tile.gs, Tile.gs, Tile.rk, Tile.rk, Tile.gs, Tile.rk, Tile.rk, Tile.en, Tile.gs, Tile.hr},
			{Tile.gs, Tile.gs, Tile.bg, Tile.gs, Tile.rk, Tile.gs, Tile.rk, Tile.en, Tile.gs, Tile.gs, Tile.gs},
			{Tile.gs, Tile.fg, Tile.gs, Tile.bg, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.rk, Tile.gs},
			{Tile.en, Tile.gs, Tile.gs, Tile.rk, Tile.gs, Tile.gs, Tile.rk, Tile.gs, Tile.gs, Tile.gs, Tile.en}
		},
	
		// 11, A, BUILDING
	
		{
			{Tile.wl, Tile.wl, Tile.wl, Tile.wl, Tile.wl, Tile.wl, Tile.wl, Tile.wl, Tile.wl, Tile.wl, Tile.dc},
			{Tile.gs, Tile.gs, Tile.gs, Tile.sk, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs},
			{Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.rk, Tile.rk, Tile.rk, Tile.rk, Tile.rk, Tile.rk},
			{Tile.gs, Tile.gs, Tile.rk, Tile.rk, Tile.rk, Tile.rk, Tile.hr, Tile.hr, Tile.hr, Tile.hr, Tile.rk},
			{Tile.gs, Tile.gs, Tile.rk, Tile.bg, Tile.bg, Tile.bg, Tile.hr, Tile.hr, Tile.hr, Tile.hr, Tile.rk},
			{Tile.gs, Tile.gs, Tile.rk, Tile.bg, Tile.gs, Tile.bg, Tile.bg, Tile.bg, Tile.bg, Tile.bg, Tile.rk},
			{Tile.gs, Tile.gs, Tile.rk, Tile.bg, Tile.gs, Tile.bg, Tile.gs, Tile.gs, Tile.gs, Tile.bg, Tile.rk},
			{Tile.gs, Tile.gs, Tile.hr, Tile.bg, Tile.bg, Tile.bg, Tile.bg, Tile.bg, Tile.bg, Tile.bg, Tile.rk},
			{Tile.gs, Tile.fg, Tile.gs, Tile.gs, Tile.bg, Tile.gs, Tile.bg, Tile.gs, Tile.gs, Tile.gs, Tile.rk},
			{Tile.gs, Tile.gs, Tile.bg, Tile.bg, Tile.bg, Tile.bg, Tile.bg, Tile.gs, Tile.rk, Tile.rk, Tile.rk},
			{Tile.gs, Tile.gs, Tile.rk, Tile.rk, Tile.rk, Tile.rk, Tile.rk, Tile.rk, Tile.rk, Tile.en, Tile.en},
			{Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.en, Tile.en}
		},
	
		// 12, A, PYRIMID
	
		{
			{Tile.wl, Tile.wl, Tile.wl, Tile.wl, Tile.wl, Tile.wl, Tile.wl, Tile.wl, Tile.wl, Tile.wl, Tile.dc},
			{Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.hr, Tile.gs, Tile.hr, Tile.gs, Tile.hr, Tile.gs},
			{Tile.gs, Tile.rk, Tile.gs, Tile.gs, Tile.gs, Tile.hr, Tile.hr, Tile.hr, Tile.hr, Tile.hr, Tile.gs},
			{Tile.rk, Tile.rk, Tile.rk, Tile.gs, Tile.gs, Tile.hr, Tile.hr, Tile.gs, Tile.hr, Tile.gs, Tile.gs},
			{Tile.rk, Tile.rk, Tile.rk, Tile.bg, Tile.gs, Tile.hr, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs},
			{Tile.rk, Tile.rk, Tile.gs, Tile.gs, Tile.bg, Tile.hr, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs},
			{Tile.rk, Tile.gs, Tile.gs, Tile.gs, Tile.fg, Tile.rk, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs},
			{Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.rk, Tile.rk, Tile.rk, Tile.gs, Tile.gs, Tile.gs, Tile.gs},
			{Tile.gs, Tile.gs, Tile.gs, Tile.rk, Tile.rk, Tile.rk, Tile.rk, Tile.rk, Tile.gs, Tile.gs, Tile.gs},
			{Tile.gs, Tile.gs, Tile.rk, Tile.rk, Tile.rk, Tile.rk, Tile.rk, Tile.rk, Tile.rk, Tile.gs, Tile.gs},
			{Tile.gs, Tile.sk, Tile.sk, Tile.rk, Tile.rk, Tile.rk, Tile.hr, Tile.hr, Tile.rk, Tile.rk, Tile.gs},
			{Tile.rk, Tile.rk, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.hr, Tile.hr, Tile.rk, Tile.rk, Tile.rk}
		},
	
		// 13, A, PACKING
	
		{
			{Tile.wl, Tile.wl, Tile.wl, Tile.wl, Tile.wl, Tile.dc, Tile.wl, Tile.wl, Tile.wl, Tile.wl, Tile.wl},
			{Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs},
			{Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs},
			{Tile.gs, Tile.gs, Tile.gs, Tile.bg, Tile.gs, Tile.gs, Tile.bg, Tile.gs, Tile.gs, Tile.bg, Tile.gs},
			{Tile.gs, Tile.fg, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs},
			{Tile.gs, Tile.gs, Tile.gs, Tile.bg, Tile.gs, Tile.gs, Tile.bg, Tile.gs, Tile.gs, Tile.bg, Tile.gs},
			{Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs},
			{Tile.gs, Tile.rk, Tile.rk, Tile.rk, Tile.rk, Tile.gs, Tile.rk, Tile.rk, Tile.rk, Tile.rk, Tile.gs},
			{Tile.gs, Tile.rk, Tile.sk, Tile.sk, Tile.rk, Tile.gs, Tile.rk, Tile.sk, Tile.rk, Tile.hr, Tile.gs},
			{Tile.gs, Tile.rk, Tile.sk, Tile.sk, Tile.rk, Tile.gs, Tile.rk, Tile.sk, Tile.rk, Tile.rk, Tile.gs},
			{Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs},
			{Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs}
		},
	
		// 14, A, ROOMS
	
		{
			{Tile.wl, Tile.dc, Tile.wl, Tile.wl, Tile.wl, Tile.wl, Tile.wl, Tile.wl, Tile.wl, Tile.wl, Tile.wl},
			{Tile.rk, Tile.gs, Tile.rk, Tile.rk, Tile.rk, Tile.rk, Tile.rk, Tile.rk, Tile.rk, Tile.rk, Tile.rk},
			{Tile.rk, Tile.hr, Tile.rk, Tile.hr, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.hr, Tile.rk},
			{Tile.rk, Tile.gs, Tile.rk, Tile.gs, Tile.rk, Tile.rk, Tile.rk, Tile.rk, Tile.rk, Tile.gs, Tile.en},
			{Tile.rk, Tile.hr, Tile.rk, Tile.hr, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.hr, Tile.rk},
			{Tile.rk, Tile.gs, Tile.rk, Tile.rk, Tile.rk, Tile.rk, Tile.rk, Tile.rk, Tile.rk, Tile.gs, Tile.rk},
			{Tile.rk, Tile.hr, Tile.gs, Tile.hr, Tile.gs, Tile.hr, Tile.gs, Tile.hr, Tile.rk, Tile.hr, Tile.rk},
			{Tile.en, Tile.gs, Tile.rk, Tile.rk, Tile.rk, Tile.rk, Tile.rk, Tile.gs, Tile.rk, Tile.gs, Tile.rk},
			{Tile.rk, Tile.gs, Tile.rk, Tile.hr, Tile.gs, Tile.hr, Tile.rk, Tile.hr, Tile.gs, Tile.hr, Tile.rk},
			{Tile.rk, Tile.gs, Tile.rk, Tile.gs, Tile.rk, Tile.rk, Tile.rk, Tile.gs, Tile.rk, Tile.gs, Tile.rk},
			{Tile.rk, Tile.gs, Tile.gs, Tile.hr, Tile.gs, Tile.hr, Tile.gs, Tile.hr, Tile.gs, Tile.hr, Tile.fg},
			{Tile.rk, Tile.rk, Tile.en, Tile.rk, Tile.rk, Tile.rk, Tile.rk, Tile.rk, Tile.en, Tile.rk, Tile.rk}
		},
	
		// 15, B, MEDOW
	
		{
			{Tile.wl, Tile.wl, Tile.wl, Tile.wl, Tile.wl, Tile.wl, Tile.wl, Tile.dc, Tile.wl, Tile.wl, Tile.wl},
			{Tile.rk, Tile.rk, Tile.rk, Tile.rk, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs},
			{Tile.rk, Tile.rk, Tile.rk, Tile.gs, Tile.gs, Tile.bg, Tile.gs, Tile.bg, Tile.gs, Tile.gs, Tile.gs},
			{Tile.rk, Tile.rk, Tile.sk, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.hr},
			{Tile.rk, Tile.gs, Tile.bg, Tile.gs, Tile.gs, Tile.rk, Tile.rk, Tile.rk, Tile.rk, Tile.en, Tile.rk},
			{Tile.gs, Tile.gs, Tile.fg, Tile.gs, Tile.rk, Tile.rk, Tile.rk, Tile.rk, Tile.rk, Tile.rk, Tile.rk},
			{Tile.gs, Tile.gs, Tile.gs, Tile.rk, Tile.rk, Tile.rk, Tile.rk, Tile.rk, Tile.rk, Tile.rk, Tile.rk},
			{Tile.gs, Tile.gs, Tile.gs, Tile.en, Tile.rk, Tile.rk, Tile.rk, Tile.rk, Tile.rk, Tile.rk, Tile.rk},
			{Tile.gs, Tile.gs, Tile.gs, Tile.en, Tile.rk, Tile.rk, Tile.rk, Tile.rk, Tile.rk, Tile.rk, Tile.rk},
			{Tile.gs, Tile.gs, Tile.gs, Tile.rk, Tile.rk, Tile.rk, Tile.hr, Tile.hr, Tile.hr, Tile.hr, Tile.hr},
			{Tile.gs, Tile.gs, Tile.gs, Tile.sk, Tile.gs, Tile.gs, Tile.hr, Tile.bg, Tile.bg, Tile.bg, Tile.hr},
			{Tile.gs, Tile.gs, Tile.gs, Tile.rk, Tile.rk, Tile.rk, Tile.hr, Tile.hr, Tile.hr, Tile.hr, Tile.hr}
		},
	
		// 16, B, MEADOW
	
		{
			{Tile.wl, Tile.wl, Tile.wl, Tile.wl, Tile.wl, Tile.dc, Tile.wl, Tile.wl, Tile.wl, Tile.wl, Tile.wl},
			{Tile.gs, Tile.gs, Tile.gs, Tile.en, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.rk, Tile.bs, Tile.bs},
			{Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.hr, Tile.gs, Tile.rk, Tile.bs, Tile.bs},
			{Tile.en, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.rk, Tile.bs, Tile.bs},
			{Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.fg, Tile.gs, Tile.gs, Tile.rk, Tile.bs, Tile.bs},
			{Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.bg, Tile.gs, Tile.gs, Tile.gs, Tile.rk, Tile.bs, Tile.bs},
			{Tile.gs, Tile.hr, Tile.bg, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.rk, Tile.bs, Tile.bs},
			{Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.rk, Tile.bs, Tile.bs},
			{Tile.rk, Tile.rk, Tile.rk, Tile.rk, Tile.rk, Tile.rk, Tile.rk, Tile.rk, Tile.gs, Tile.rk, Tile.rk},
			{Tile.en, Tile.en, Tile.en, Tile.en, Tile.en, Tile.en, Tile.en, Tile.en, Tile.rk, Tile.gs, Tile.gs},
			{Tile.en, Tile.en, Tile.en, Tile.en, Tile.en, Tile.en, Tile.en, Tile.en, Tile.rk, Tile.gs, Tile.gs},
			{Tile.en, Tile.en, Tile.en, Tile.en, Tile.en, Tile.en, Tile.en, Tile.en, Tile.rk, Tile.gs, Tile.gs}
		},
	
		// 17, B, BUILDING
	
		{
			{Tile.wl, Tile.wl, Tile.wl, Tile.wl, Tile.wl, Tile.dc, Tile.wl, Tile.wl, Tile.wl, Tile.wl, Tile.wl},
			{Tile.rk, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.rk},
			{Tile.rk, Tile.gs, Tile.gs, Tile.gs, Tile.bg, Tile.fg, Tile.bg, Tile.gs, Tile.gs, Tile.gs, Tile.rk},
			{Tile.gs, Tile.gs, Tile.rk, Tile.rk, Tile.rk, Tile.gs, Tile.rk, Tile.rk, Tile.rk, Tile.gs, Tile.gs},
			{Tile.gs, Tile.gs, Tile.rk, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.rk, Tile.gs, Tile.gs},
			{Tile.gs, Tile.gs, Tile.rk, Tile.gs, Tile.gs, Tile.rk, Tile.gs, Tile.gs, Tile.rk, Tile.gs, Tile.gs},
			{Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs},
			{Tile.gs, Tile.gs, Tile.rk, Tile.gs, Tile.gs, Tile.en, Tile.gs, Tile.gs, Tile.rk, Tile.en, Tile.gs},
			{Tile.gs, Tile.en, Tile.rk, Tile.gs, Tile.gs, Tile.rk, Tile.gs, Tile.gs, Tile.rk, Tile.gs, Tile.gs},
			{Tile.gs, Tile.gs, Tile.rk, Tile.rk, Tile.gs, Tile.gs, Tile.gs, Tile.rk, Tile.rk, Tile.gs, Tile.gs},
			{Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs},
			{Tile.gs, Tile.gs, Tile.gs, Tile.rk, Tile.rk, Tile.hr, Tile.rk, Tile.rk, Tile.gs, Tile.gs, Tile.gs}
		},
	
		// 18, B, PYRAMID
	
		{
			{Tile.wl, Tile.wl, Tile.wl, Tile.dc, Tile.wl, Tile.wl, Tile.wl, Tile.wl, Tile.wl, Tile.wl, Tile.wl},
			{Tile.rk, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.rk, Tile.rk, Tile.gs, Tile.gs, Tile.gs},
			{Tile.rk, Tile.rk, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.rk, Tile.rk, Tile.gs, Tile.gs, Tile.gs},
			{Tile.rk, Tile.rk, Tile.rk, Tile.gs, Tile.gs, Tile.bg, Tile.rk, Tile.rk, Tile.bg, Tile.gs, Tile.gs},
			{Tile.rk, Tile.rk, Tile.rk, Tile.gs, Tile.bg, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.bg, Tile.gs},
			{Tile.rk, Tile.rk, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs},
			{Tile.rk, Tile.rk, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs},
			{Tile.rk, Tile.rk, Tile.bg, Tile.bg, Tile.gs, Tile.gs, Tile.en, Tile.en, Tile.gs, Tile.gs, Tile.gs},
			{Tile.rk, Tile.rk, Tile.gs, Tile.gs, Tile.bg, Tile.gs, Tile.rk, Tile.rk, Tile.gs, Tile.gs, Tile.gs},
			{Tile.rk, Tile.rk, Tile.gs, Tile.bg, Tile.gs, Tile.rk, Tile.rk, Tile.rk, Tile.rk, Tile.gs, Tile.gs},
			{Tile.rk, Tile.rk, Tile.bg, Tile.gs, Tile.rk, Tile.rk, Tile.rk, Tile.rk, Tile.sk, Tile.sk, Tile.gs},
			{Tile.rk, Tile.rk, Tile.fg, Tile.rk, Tile.rk, Tile.hr, Tile.hr, Tile.hr, Tile.hr, Tile.rk, Tile.rk}
		},
	
		// 19, B, PACKING
	
		{
			{Tile.wl, Tile.wl, Tile.wl, Tile.wl, Tile.wl, Tile.dc, Tile.wl, Tile.wl, Tile.wl, Tile.wl, Tile.wl},
			{Tile.gs, Tile.rk, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.rk, Tile.gs},
			{Tile.rk, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.rk},
			{Tile.gs, Tile.gs, Tile.bg, Tile.hr, Tile.bg, Tile.hr, Tile.bg, Tile.hr, Tile.bg, Tile.gs, Tile.gs},
			{Tile.gs, Tile.gs, Tile.hr, Tile.bg, Tile.hr, Tile.bg, Tile.hr, Tile.bg, Tile.hr, Tile.gs, Tile.gs},
			{Tile.gs, Tile.gs, Tile.bg, Tile.hr, Tile.bg, Tile.hr, Tile.bg, Tile.hr, Tile.bg, Tile.gs, Tile.gs},
			{Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs},
			{Tile.gs, Tile.gs, Tile.gs, Tile.rk, Tile.sk, Tile.sk, Tile.sk, Tile.rk, Tile.gs, Tile.gs, Tile.gs},
			{Tile.gs, Tile.gs, Tile.rk, Tile.sk, Tile.sk, Tile.fs, Tile.sk, Tile.sk, Tile.rk, Tile.gs, Tile.gs},
			{Tile.gs, Tile.gs, Tile.gs, Tile.rk, Tile.sk, Tile.sk, Tile.sk, Tile.rk, Tile.gs, Tile.gs, Tile.gs},
			{Tile.bg, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.bg},
			{Tile.gs, Tile.bg, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.bg, Tile.gs}
		},
	
		// 20, B, ROOMS
	
		{
			{Tile.wl, Tile.wl, Tile.wl, Tile.wl, Tile.wl, Tile.dc, Tile.wl, Tile.wl, Tile.wl, Tile.wl, Tile.wl},
			{Tile.rk, Tile.rk, Tile.rk, Tile.rk, Tile.rk, Tile.gs, Tile.rk, Tile.rk, Tile.en, Tile.rk, Tile.rk},
			{Tile.rk, Tile.gs, Tile.gs, Tile.fg, Tile.rk, Tile.gs, Tile.rk, Tile.en, Tile.gs, Tile.rk, Tile.rk},
			{Tile.rk, Tile.gs, Tile.bg, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.en},
			{Tile.rk, Tile.gs, Tile.bg, Tile.gs, Tile.rk, Tile.rk, Tile.gs, Tile.rk, Tile.gs, Tile.rk, Tile.rk},
			{Tile.rk, Tile.gs, Tile.bg, Tile.gs, Tile.gs, Tile.hr, Tile.hr, Tile.rk, Tile.gs, Tile.rk, Tile.rk},
			{Tile.rk, Tile.rk, Tile.gs, Tile.rk, Tile.rk, Tile.hr, Tile.hr, Tile.rk, Tile.gs, Tile.rk, Tile.rk},
			{Tile.rk, Tile.rk, Tile.gs, Tile.rk, Tile.rk, Tile.rk, Tile.rk, Tile.rk, Tile.gs, Tile.rk, Tile.rk},
			{Tile.rk, Tile.gs, Tile.gs, Tile.rk, Tile.sk, Tile.rk, Tile.rk, Tile.gs, Tile.gs, Tile.gs, Tile.rk},
			{Tile.rk, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.hr, Tile.rk},
			{Tile.rk, Tile.rk, Tile.rk, Tile.rk, Tile.gs, Tile.gs, Tile.rk, Tile.gs, Tile.gs, Tile.gs, Tile.rk},
			{Tile.rk, Tile.rk, Tile.rk, Tile.rk, Tile.rk, Tile.rk, Tile.rk, Tile.rk, Tile.rk, Tile.rk, Tile.rk}
		},
	
		// 21, B, ROOMS
	
		{
			{Tile.wl, Tile.wl, Tile.wl, Tile.wl, Tile.wl, Tile.wl, Tile.wl, Tile.wl, Tile.wl, Tile.dc, Tile.wl},
			{Tile.rk, Tile.rk, Tile.gs, Tile.en, Tile.gs, Tile.gs, Tile.en, Tile.gs, Tile.gs, Tile.gs, Tile.gs},
			{Tile.rk, Tile.rk, Tile.rk, Tile.gs, Tile.rk, Tile.rk, Tile.gs, Tile.rk, Tile.rk, Tile.gs, Tile.gs},
			{Tile.hr, Tile.rk, Tile.rk, Tile.gs, Tile.rk, Tile.rk, Tile.gs, Tile.rk, Tile.rk, Tile.gs, Tile.rk},
			{Tile.gs, Tile.rk, Tile.gs, Tile.gs, Tile.rk, Tile.rk, Tile.gs, Tile.rk, Tile.rk, Tile.gs, Tile.gs},
			{Tile.hr, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.en, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs},
			{Tile.gs, Tile.rk, Tile.gs, Tile.gs, Tile.rk, Tile.rk, Tile.gs, Tile.rk, Tile.rk, Tile.gs, Tile.gs},
			{Tile.hr, Tile.rk, Tile.rk, Tile.gs, Tile.rk, Tile.rk, Tile.gs, Tile.rk, Tile.rk, Tile.gs, Tile.rk},
			{Tile.rk, Tile.rk, Tile.rk, Tile.gs, Tile.rk, Tile.rk, Tile.gs, Tile.rk, Tile.rk, Tile.gs, Tile.gs},
			{Tile.rk, Tile.fg, Tile.bg, Tile.gs, Tile.bg, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs},
			{Tile.rk, Tile.gs, Tile.bg, Tile.gs, Tile.bg, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.sk, Tile.gs},
			{Tile.rk, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.rk, Tile.rk, Tile.rk, Tile.gs, Tile.rk}
		},
	
		// 22, C, MEADOW
	
		{
			{Tile.wl, Tile.wl, Tile.wl, Tile.wl, Tile.wl, Tile.dc, Tile.wl, Tile.wl, Tile.wl, Tile.wl, Tile.wl},
			{Tile.gs, Tile.gs, Tile.gs, Tile.en, Tile.bg, Tile.gs, Tile.bg, Tile.en, Tile.gs, Tile.gs, Tile.en},
			{Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.hr},
			{Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.fg, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.hr},
			{Tile.gs, Tile.rk, Tile.bg, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.hr},
			{Tile.rk, Tile.gs, Tile.gs, Tile.rk, Tile.bg, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.hr},
			{Tile.gs, Tile.hr, Tile.rk, Tile.gs, Tile.gs, Tile.rk, Tile.hr, Tile.gs, Tile.gs, Tile.gs, Tile.hr},
			{Tile.gs, Tile.gs, Tile.gs, Tile.hr, Tile.rk, Tile.gs, Tile.gs, Tile.rk, Tile.bg, Tile.gs, Tile.hr},
			{Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.bg, Tile.rk, Tile.gs, Tile.gs, Tile.rk, Tile.hr},
			{Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.hr, Tile.rk, Tile.gs, Tile.hr},
			{Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.hr, Tile.rk},
			{Tile.en, Tile.gs, Tile.gs, Tile.en, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs}
		},
	
		// 23, C, MEADOW
	
		{
			{Tile.dc, Tile.wl, Tile.wl, Tile.wl, Tile.wl, Tile.wl, Tile.wl, Tile.wl, Tile.wl, Tile.wl, Tile.wl},
			{Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.rk, Tile.en, Tile.rk, Tile.gs, Tile.rk, Tile.hr, Tile.en},
			{Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.rk},
			{Tile.rk, Tile.rk, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.rk},
			{Tile.en, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.rk, Tile.gs, Tile.gs, Tile.gs},
			{Tile.en, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.rk, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs},
			{Tile.en, Tile.gs, Tile.rk, Tile.hr, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.rk, Tile.gs, Tile.rk},
			{Tile.en, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.hr, Tile.rk, Tile.gs, Tile.gs, Tile.gs, Tile.rk},
			{Tile.rk, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.rk, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.rk},
			{Tile.rk, Tile.rk, Tile.bg, Tile.bg, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.hr, Tile.rk, Tile.rk},
			{Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.bg, Tile.gs},
			{Tile.fg, Tile.rk, Tile.gs, Tile.gs, Tile.rk, Tile.en, Tile.rk, Tile.gs, Tile.gs, Tile.gs, Tile.gs}
		},
	
		// 24, C, BUILDING
	
		{
			{Tile.wl, Tile.wl, Tile.wl, Tile.wl, Tile.wl, Tile.wl, Tile.wl, Tile.wl, Tile.wl, Tile.dc, Tile.wl},
			{Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs},
			{Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.rk, Tile.rk, Tile.rk, Tile.rk, Tile.gs, Tile.en},
			{Tile.gs, Tile.rk, Tile.rk, Tile.rk, Tile.rk, Tile.rk, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs},
			{Tile.gs, Tile.rk, Tile.gs, Tile.gs, Tile.gs, Tile.rk, Tile.hr, Tile.gs, Tile.rk, Tile.gs, Tile.rk},
			{Tile.gs, Tile.rk, Tile.gs, Tile.fg, Tile.gs, Tile.bs, Tile.gs, Tile.gs, Tile.rk, Tile.gs, Tile.gs},
			{Tile.gs, Tile.rk, Tile.rk, Tile.rk, Tile.bs, Tile.rk, Tile.bs, Tile.rk, Tile.rk, Tile.rk, Tile.gs},
			{Tile.gs, Tile.gs, Tile.rk, Tile.gs, Tile.gs, Tile.bs, Tile.gs, Tile.gs, Tile.gs, Tile.rk, Tile.gs},
			{Tile.gs, Tile.gs, Tile.rk, Tile.gs, Tile.gs, Tile.rk, Tile.gs, Tile.gs, Tile.gs, Tile.rk, Tile.gs},
			{Tile.gs, Tile.gs, Tile.rk, Tile.gs, Tile.gs, Tile.rk, Tile.rk, Tile.rk, Tile.rk, Tile.rk, Tile.gs},
			{Tile.gs, Tile.gs, Tile.rk, Tile.rk, Tile.rk, Tile.rk, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs},
			{Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs}
		},
	
		// 25, C, BUILDING
	
		{
			{Tile.wl, Tile.wl, Tile.wl, Tile.wl, Tile.wl, Tile.dc, Tile.wl, Tile.wl, Tile.wl, Tile.wl, Tile.wl},
			{Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs},
			{Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs},
			{Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs},
			{Tile.gs, Tile.gs, Tile.rk, Tile.rk, Tile.rk, Tile.bs, Tile.rk, Tile.rk, Tile.rk, Tile.gs, Tile.gs},
			{Tile.gs, Tile.gs, Tile.rk, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.rk, Tile.gs, Tile.gs},
			{Tile.gs, Tile.gs, Tile.bs, Tile.gs, Tile.gs, Tile.hr, Tile.gs, Tile.gs, Tile.bs, Tile.gs, Tile.gs},
			{Tile.gs, Tile.rk, Tile.rk, Tile.bg, Tile.rk, Tile.rk, Tile.rk, Tile.bs, Tile.rk, Tile.rk, Tile.gs},
			{Tile.gs, Tile.rk, Tile.gs, Tile.gs, Tile.gs, Tile.rk, Tile.gs, Tile.gs, Tile.gs, Tile.rk, Tile.gs},
			{Tile.gs, Tile.bs, Tile.gs, Tile.fg, Tile.gs, Tile.bs, Tile.gs, Tile.hr, Tile.gs, Tile.bs, Tile.gs},
			{Tile.gs, Tile.rk, Tile.rk, Tile.rk, Tile.rk, Tile.rk, Tile.rk, Tile.rk, Tile.rk, Tile.rk, Tile.gs},
			{Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs}
		},
	
		// 26, C, PYRIMID
	
		{
			{Tile.wl, Tile.wl, Tile.wl, Tile.wl, Tile.wl, Tile.wl, Tile.wl, Tile.wl, Tile.wl, Tile.wl, Tile.dc},
			{Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.hr},
			{Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.rk},
			{Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.en, Tile.bs, Tile.rk},
			{Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.en, Tile.bg, Tile.rk, Tile.rk},
			{Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.en, Tile.bg, Tile.bs, Tile.rk, Tile.rk},
			{Tile.gs, Tile.gs, Tile.bg, Tile.gs, Tile.gs, Tile.en, Tile.bg, Tile.bg, Tile.rk, Tile.rk, Tile.rk},
			{Tile.gs, Tile.bg, Tile.gs, Tile.bg, Tile.gs, Tile.bg, Tile.bg, Tile.bs, Tile.rk, Tile.rk, Tile.rk},
			{Tile.bg, Tile.gs, Tile.bg, Tile.gs, Tile.bg, Tile.bg, Tile.bg, Tile.rk, Tile.rk, Tile.rk, Tile.rk},
			{Tile.gs, Tile.bg, Tile.gs, Tile.bg, Tile.bg, Tile.bg, Tile.bs, Tile.rk, Tile.rk, Tile.rk, Tile.rk},
			{Tile.gs, Tile.gs, Tile.bg, Tile.bg, Tile.bg, Tile.bg, Tile.rk, Tile.rk, Tile.rk, Tile.rk, Tile.rk},
			{Tile.fg, Tile.bg, Tile.bg, Tile.bg, Tile.bg, Tile.bs, Tile.rk, Tile.rk, Tile.rk, Tile.rk, Tile.rk}
		},
	
		// 27, C, PACKING
	
		{
			{Tile.wl, Tile.wl, Tile.wl, Tile.wl, Tile.wl, Tile.dc, Tile.wl, Tile.wl, Tile.wl, Tile.wl, Tile.wl},
			{Tile.gs, Tile.gs, Tile.gs, Tile.en, Tile.rk, Tile.hr, Tile.rk, Tile.hr, Tile.gs, Tile.gs, Tile.gs},
			{Tile.gs, Tile.gs, Tile.bg, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.bg, Tile.gs, Tile.gs},
			{Tile.gs, Tile.bg, Tile.gs, Tile.bg, Tile.gs, Tile.fg, Tile.gs, Tile.bg, Tile.gs, Tile.bg, Tile.gs},
			{Tile.hr, Tile.gs, Tile.gs, Tile.rk, Tile.rk, Tile.rk, Tile.gs, Tile.rk, Tile.gs, Tile.gs, Tile.en},
			{Tile.rk, Tile.gs, Tile.gs, Tile.rk, Tile.sk, Tile.sk, Tile.sk, Tile.gs, Tile.gs, Tile.gs, Tile.rk},
			{Tile.hr, Tile.gs, Tile.gs, Tile.rk, Tile.sk, Tile.rk, Tile.sk, Tile.rk, Tile.gs, Tile.gs, Tile.hr},
			{Tile.rk, Tile.gs, Tile.gs, Tile.gs, Tile.sk, Tile.sk, Tile.sk, Tile.rk, Tile.gs, Tile.gs, Tile.rk},
			{Tile.en, Tile.gs, Tile.gs, Tile.rk, Tile.gs, Tile.rk, Tile.rk, Tile.rk, Tile.gs, Tile.gs, Tile.hr},
			{Tile.gs, Tile.bg, Tile.gs, Tile.bg, Tile.gs, Tile.gs, Tile.gs, Tile.bg, Tile.gs, Tile.bg, Tile.gs},
			{Tile.gs, Tile.gs, Tile.bg, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.bg, Tile.gs, Tile.gs},
			{Tile.gs, Tile.gs, Tile.gs, Tile.hr, Tile.rk, Tile.hr, Tile.rk, Tile.en, Tile.gs, Tile.gs, Tile.gs}
		},
	
		// 28, C, ROOMS
	
		{
			{Tile.wl, Tile.wl, Tile.wl, Tile.wl, Tile.wl, Tile.wl, Tile.wl, Tile.dc, Tile.wl, Tile.wl, Tile.wl},
			{Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.rk, Tile.rk, Tile.gs, Tile.rk, Tile.rk, Tile.rk},
			{Tile.gs, Tile.bg, Tile.bs, Tile.bg, Tile.gs, Tile.rk, Tile.rk, Tile.gs, Tile.gs, Tile.gs, Tile.rk},
			{Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.fg, Tile.rk, Tile.rk, Tile.rk, Tile.rk, Tile.gs, Tile.rk},
			{Tile.rk, Tile.rk, Tile.gs, Tile.rk, Tile.rk, Tile.rk, Tile.rk, Tile.gs, Tile.gs, Tile.gs, Tile.rk},
			{Tile.rk, Tile.rk, Tile.bg, Tile.rk, Tile.hr, Tile.hr, Tile.rk, Tile.gs, Tile.rk, Tile.rk, Tile.rk},
			{Tile.rk, Tile.rk, Tile.gs, Tile.rk, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.en},
			{Tile.gs, Tile.gs, Tile.gs, Tile.sk, Tile.gs, Tile.gs, Tile.rk, Tile.hr, Tile.gs, Tile.rk, Tile.rk},
			{Tile.gs, Tile.rk, Tile.gs, Tile.rk, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.rk, Tile.rk},
			{Tile.gs, Tile.gs, Tile.gs, Tile.rk, Tile.rk, Tile.rk, Tile.rk, Tile.sk, Tile.rk, Tile.rk, Tile.rk},
			{Tile.rk, Tile.rk, Tile.gs, Tile.rk, Tile.gs, Tile.gs, Tile.bg, Tile.gs, Tile.gs, Tile.gs, Tile.rk},
			{Tile.rk, Tile.rk, Tile.en, Tile.rk, Tile.hr, Tile.hr, Tile.hr, Tile.hr, Tile.hr, Tile.hr, Tile.rk}
		},
	
		// 29, C, ROOMS
	
		{
			{Tile.wl, Tile.wl, Tile.dc, Tile.wl, Tile.wl, Tile.wl, Tile.wl, Tile.wl, Tile.wl, Tile.wl, Tile.wl},
			{Tile.en, Tile.gs, Tile.gs, Tile.gs, Tile.en, Tile.rk, Tile.hr, Tile.gs, Tile.gs, Tile.gs, Tile.hr},
			{Tile.gs, Tile.gs, Tile.fg, Tile.gs, Tile.gs, Tile.rk, Tile.gs, Tile.bg, Tile.gs, Tile.bg, Tile.gs},
			{Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.rk, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs},
			{Tile.rk, Tile.rk, Tile.gs, Tile.rk, Tile.rk, Tile.rk, Tile.rk, Tile.rk, Tile.gs, Tile.rk, Tile.rk},
			{Tile.gs, Tile.gs, Tile.gs, Tile.rk, Tile.rk, Tile.gs, Tile.gs, Tile.rk, Tile.gs, Tile.gs, Tile.gs},
			{Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.hr, Tile.gs, Tile.rk, Tile.gs, Tile.gs, Tile.gs},
			{Tile.gs, Tile.gs, Tile.gs, Tile.rk, Tile.rk, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs},
			{Tile.gs, Tile.gs, Tile.gs, Tile.rk, Tile.rk, Tile.rk, Tile.rk, Tile.rk, Tile.gs, Tile.gs, Tile.gs},
			{Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.rk, Tile.rk, Tile.gs, Tile.gs, Tile.gs},
			{Tile.gs, Tile.gs, Tile.gs, Tile.rk, Tile.gs, Tile.hr, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs},
			{Tile.gs, Tile.gs, Tile.gs, Tile.rk, Tile.gs, Tile.gs, Tile.rk, Tile.rk, Tile.gs, Tile.gs, Tile.gs}
		},
	
		// 30, D, MEADOW
	
		{
			{Tile.wl, Tile.wl, Tile.wl, Tile.wl, Tile.wl, Tile.wl, Tile.wl, Tile.wl, Tile.wl, Tile.dc, Tile.wl},
			{Tile.gs, Tile.gs, Tile.en, Tile.gs, Tile.gs, Tile.gs, Tile.rk, Tile.en, Tile.rk, Tile.gs, Tile.hr},
			{Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.rk, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs},
			{Tile.gs, Tile.bg, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.hr, Tile.gs, Tile.gs, Tile.gs},
			{Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.rk, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs},
			{Tile.gs, Tile.bg, Tile.rk, Tile.rk, Tile.gs, Tile.rk, Tile.gs, Tile.rk, Tile.gs, Tile.gs, Tile.gs},
			{Tile.fg, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.rk, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs},
			{Tile.gs, Tile.bg, Tile.rk, Tile.gs, Tile.gs, Tile.rk, Tile.gs, Tile.rk, Tile.gs, Tile.gs, Tile.en},
			{Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.rk, Tile.gs, Tile.gs, Tile.rk, Tile.gs, Tile.gs, Tile.gs},
			{Tile.gs, Tile.bg, Tile.gs, Tile.gs, Tile.sk, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs},
			{Tile.gs, Tile.gs, Tile.gs, Tile.rk, Tile.en, Tile.gs, Tile.gs, Tile.rk, Tile.gs, Tile.gs, Tile.gs},
			{Tile.gs, Tile.gs, Tile.en, Tile.gs, Tile.en, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs}
		},
	
		// 31, D, MEADOW
	
		{
			{Tile.wl, Tile.wl, Tile.wl, Tile.wl, Tile.wl, Tile.dc, Tile.wl, Tile.wl, Tile.wl, Tile.wl, Tile.wl},
			{Tile.sk, Tile.gs, Tile.rk, Tile.en, Tile.gs, Tile.gs, Tile.gs, Tile.en, Tile.rk, Tile.gs, Tile.bs},
			{Tile.sk, Tile.gs, Tile.en, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.en, Tile.gs, Tile.sk},
			{Tile.sk, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.sk},
			{Tile.sk, Tile.gs, Tile.gs, Tile.bg, Tile.gs, Tile.bg, Tile.gs, Tile.bg, Tile.gs, Tile.gs, Tile.sk},
			{Tile.sk, Tile.gs, Tile.bg, Tile.gs, Tile.bg, Tile.gs, Tile.bg, Tile.gs, Tile.bg, Tile.gs, Tile.sk},
			{Tile.gs, Tile.gs, Tile.gs, Tile.bg, Tile.gs, Tile.bg, Tile.gs, Tile.bg, Tile.gs, Tile.gs, Tile.gs},
			{Tile.gs, Tile.gs, Tile.bg, Tile.gs, Tile.bg, Tile.fg, Tile.bg, Tile.gs, Tile.bg, Tile.gs, Tile.gs},
			{Tile.gs, Tile.gs, Tile.gs, Tile.bg, Tile.gs, Tile.bg, Tile.gs, Tile.bg, Tile.gs, Tile.gs, Tile.gs},
			{Tile.rk, Tile.gs, Tile.bg, Tile.gs, Tile.hr, Tile.gs, Tile.hr, Tile.gs, Tile.bg, Tile.gs, Tile.rk},
			{Tile.rk, Tile.gs, Tile.gs, Tile.bg, Tile.gs, Tile.bg, Tile.gs, Tile.bg, Tile.gs, Tile.gs, Tile.rk},
			{Tile.rk, Tile.rk, Tile.gs, Tile.hr, Tile.en, Tile.hr, Tile.en, Tile.hr, Tile.gs, Tile.rk, Tile.rk}
		},
	
		// 32, D, MEADOW
	
		{
			{Tile.wl, Tile.wl, Tile.wl, Tile.wl, Tile.wl, Tile.wl, Tile.wl, Tile.wl, Tile.wl, Tile.wl, Tile.dc},
			{Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.rk, Tile.gs, Tile.bg, Tile.gs},
			{Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.rk, Tile.gs, Tile.gs},
			{Tile.gs, Tile.gs, Tile.gs, Tile.rk, Tile.rk, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.rk, Tile.gs},
			{Tile.gs, Tile.gs, Tile.rk, Tile.gs, Tile.hr, Tile.rk, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs},
			{Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.fg, Tile.gs},
			{Tile.gs, Tile.gs, Tile.rk, Tile.gs, Tile.hr, Tile.sk, Tile.gs, Tile.en, Tile.rk, Tile.gs, Tile.gs},
			{Tile.gs, Tile.rk, Tile.en, Tile.gs, Tile.sk, Tile.hr, Tile.gs, Tile.rk, Tile.gs, Tile.gs, Tile.gs},
			{Tile.rk, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.bg, Tile.bg, Tile.gs},
			{Tile.gs, Tile.rk, Tile.gs, Tile.gs, Tile.rk, Tile.en, Tile.gs, Tile.gs, Tile.gs, Tile.bg, Tile.gs},
			{Tile.gs, Tile.gs, Tile.rk, Tile.gs, Tile.gs, Tile.rk, Tile.gs, Tile.gs, Tile.bg, Tile.bg, Tile.gs},
			{Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.rk, Tile.gs, Tile.gs, Tile.gs, Tile.gs}
		},
	
		// 33, D, MEADOW
	
		{
			{Tile.wl, Tile.wl, Tile.wl, Tile.wl, Tile.wl, Tile.dc, Tile.wl, Tile.wl, Tile.wl, Tile.wl, Tile.wl},
			{Tile.en, Tile.sk, Tile.gs, Tile.sk, Tile.gs, Tile.gs, Tile.gs, Tile.sk, Tile.gs, Tile.sk, Tile.en},
			{Tile.rk, Tile.en, Tile.gs, Tile.sk, Tile.gs, Tile.gs, Tile.gs, Tile.sk, Tile.gs, Tile.en, Tile.rk},
			{Tile.rk, Tile.rk, Tile.en, Tile.sk, Tile.gs, Tile.gs, Tile.gs, Tile.sk, Tile.en, Tile.rk, Tile.rk},
			{Tile.rk, Tile.rk, Tile.rk, Tile.hr, Tile.gs, Tile.gs, Tile.gs, Tile.hr, Tile.rk, Tile.rk, Tile.rk},
			{Tile.rk, Tile.rk, Tile.rk, Tile.rk, Tile.hr, Tile.gs, Tile.hr, Tile.rk, Tile.rk, Tile.rk, Tile.rk},
			{Tile.rk, Tile.rk, Tile.rk, Tile.rk, Tile.rk, Tile.gs, Tile.rk, Tile.rk, Tile.rk, Tile.rk, Tile.rk},
			{Tile.gs, Tile.gs, Tile.bg, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.bg, Tile.gs, Tile.gs},
			{Tile.gs, Tile.gs, Tile.bg, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.bg, Tile.gs, Tile.gs},
			{Tile.gs, Tile.bg, Tile.hr, Tile.bg, Tile.gs, Tile.fg, Tile.gs, Tile.bg, Tile.hr, Tile.bg, Tile.gs},
			{Tile.gs, Tile.gs, Tile.bg, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.bg, Tile.gs, Tile.gs},
			{Tile.gs, Tile.gs, Tile.bg, Tile.gs, Tile.rk, Tile.rk, Tile.rk, Tile.gs, Tile.bg, Tile.gs, Tile.gs}
		},
	
		// 34, D, BUILDING
	
		{
			{Tile.wl, Tile.wl, Tile.wl, Tile.wl, Tile.wl, Tile.wl, Tile.wl, Tile.dc, Tile.wl, Tile.wl, Tile.wl},
			{Tile.rk, Tile.rk, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs},
			{Tile.rk, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.fg, Tile.gs, Tile.gs, Tile.gs},
			{Tile.gs, Tile.gs, Tile.gs, Tile.sk, Tile.rk, Tile.rk, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs},
			{Tile.gs, Tile.gs, Tile.sk, Tile.rk, Tile.gs, Tile.en, Tile.rk, Tile.gs, Tile.rk, Tile.rk, Tile.rk},
			{Tile.gs, Tile.gs, Tile.rk, Tile.hr, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.rk},
			{Tile.gs, Tile.gs, Tile.rk, Tile.hr, Tile.hr, Tile.gs, Tile.gs, Tile.rk, Tile.rk, Tile.gs, Tile.rk},
			{Tile.gs, Tile.gs, Tile.sk, Tile.rk, Tile.hr, Tile.hr, Tile.rk, Tile.gs, Tile.gs, Tile.gs, Tile.rk},
			{Tile.gs, Tile.gs, Tile.gs, Tile.sk, Tile.rk, Tile.rk, Tile.gs, Tile.gs, Tile.rk, Tile.rk, Tile.rk},
			{Tile.rk, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs},
			{Tile.rk, Tile.rk, Tile.gs, Tile.gs, Tile.gs, Tile.bg, Tile.bg, Tile.bg, Tile.bg, Tile.bg, Tile.bg},
			{Tile.rk, Tile.rk, Tile.rk, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs}
		},
	
		// 35, D, PRYIMID
	
		{
			{Tile.wl, Tile.wl, Tile.wl, Tile.wl, Tile.wl, Tile.dc, Tile.wl, Tile.wl, Tile.wl, Tile.wl, Tile.wl},
			{Tile.rk, Tile.rk, Tile.rk, Tile.rk, Tile.rk, Tile.gs, Tile.rk, Tile.rk, Tile.rk, Tile.rk, Tile.rk},
			{Tile.rk, Tile.rk, Tile.rk, Tile.rk, Tile.gs, Tile.gs, Tile.gs, Tile.rk, Tile.rk, Tile.rk, Tile.rk},
			{Tile.rk, Tile.rk, Tile.rk, Tile.gs, Tile.gs, Tile.bg, Tile.gs, Tile.gs, Tile.rk, Tile.rk, Tile.rk},
			{Tile.rk, Tile.rk, Tile.gs, Tile.sk, Tile.bg, Tile.bg, Tile.gs, Tile.gs, Tile.gs, Tile.rk, Tile.rk},
			{Tile.rk, Tile.gs, Tile.gs, Tile.bg, Tile.sk, Tile.rk, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.rk},
			{Tile.gs, Tile.gs, Tile.bg, Tile.gs, Tile.rk, Tile.rk, Tile.en, Tile.gs, Tile.gs, Tile.gs, Tile.gs},
			{Tile.rk, Tile.gs, Tile.gs, Tile.fg, Tile.hr, Tile.rk, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.rk},
			{Tile.rk, Tile.rk, Tile.gs, Tile.rk, Tile.en, Tile.gs, Tile.hr, Tile.bg, Tile.gs, Tile.rk, Tile.rk},
			{Tile.rk, Tile.rk, Tile.rk, Tile.gs, Tile.gs, Tile.hr, Tile.gs, Tile.gs, Tile.rk, Tile.rk, Tile.rk},
			{Tile.rk, Tile.rk, Tile.rk, Tile.rk, Tile.gs, Tile.gs, Tile.gs, Tile.rk, Tile.rk, Tile.rk, Tile.rk},
			{Tile.rk, Tile.rk, Tile.rk, Tile.rk, Tile.rk, Tile.gs, Tile.rk, Tile.rk, Tile.rk, Tile.rk, Tile.rk}
		},
	
		// 36, D, PACKING
	
		{
			{Tile.wl, Tile.wl, Tile.wl, Tile.wl, Tile.wl, Tile.dc, Tile.wl, Tile.wl, Tile.wl, Tile.wl, Tile.wl},
			{Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs},
			{Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs},
			{Tile.rk, Tile.rk, Tile.gs, Tile.rk, Tile.rk, Tile.gs, Tile.rk, Tile.rk, Tile.gs, Tile.rk, Tile.rk},
			{Tile.rk, Tile.sk, Tile.hr, Tile.hr, Tile.rk, Tile.gs, Tile.rk, Tile.hr, Tile.hr, Tile.sk, Tile.rk},
			{Tile.rk, Tile.sk, Tile.sk, Tile.hr, Tile.sk, Tile.hr, Tile.sk, Tile.hr, Tile.sk, Tile.sk, Tile.rk},
			{Tile.rk, Tile.rk, Tile.rk, Tile.gs, Tile.rk, Tile.gs, Tile.rk, Tile.gs, Tile.rk, Tile.rk, Tile.rk},
			{Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs},
			{Tile.gs, Tile.gs, Tile.bg, Tile.gs, Tile.bg, Tile.gs, Tile.bg, Tile.gs, Tile.bg, Tile.gs, Tile.gs},
			{Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.fg, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs},
			{Tile.gs, Tile.gs, Tile.bg, Tile.gs, Tile.bg, Tile.gs, Tile.bg, Tile.gs, Tile.bg, Tile.gs, Tile.gs},
			{Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs}
		},
	
		// 37, D, ROOMS
	
		{
			{Tile.wl, Tile.wl, Tile.wl, Tile.wl, Tile.wl, Tile.dc, Tile.wl, Tile.wl, Tile.wl, Tile.wl, Tile.wl},
			{Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs},
			{Tile.gs, Tile.bg, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.bg, Tile.gs},
			{Tile.gs, Tile.bg, Tile.gs, Tile.rk, Tile.rk, Tile.sk, Tile.rk, Tile.rk, Tile.gs, Tile.bg, Tile.gs},
			{Tile.gs, Tile.gs, Tile.rk, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.rk, Tile.gs, Tile.gs},
			{Tile.rk, Tile.rk, Tile.rk, Tile.gs, Tile.rk, Tile.sk, Tile.rk, Tile.gs, Tile.rk, Tile.rk, Tile.rk},
			{Tile.gs, Tile.gs, Tile.sk, Tile.gs, Tile.fg, Tile.sk, Tile.sk, Tile.gs, Tile.sk, Tile.gs, Tile.gs},
			{Tile.gs, Tile.gs, Tile.rk, Tile.gs, Tile.rk, Tile.sk, Tile.rk, Tile.gs, Tile.rk, Tile.gs, Tile.gs},
			{Tile.gs, Tile.bg, Tile.rk, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.rk, Tile.bg, Tile.gs},
			{Tile.gs, Tile.gs, Tile.gs, Tile.rk, Tile.rk, Tile.sk, Tile.rk, Tile.rk, Tile.gs, Tile.gs, Tile.gs},
			{Tile.gs, Tile.bg, Tile.gs, Tile.rk, Tile.hr, Tile.hr, Tile.hr, Tile.rk, Tile.gs, Tile.bg, Tile.gs},
			{Tile.gs, Tile.gs, Tile.gs, Tile.rk, Tile.hr, Tile.hr, Tile.hr, Tile.rk, Tile.gs, Tile.gs, Tile.gs}
		},
	
		// 38, E, MEADOW
	
		{
			{Tile.wl, Tile.wl, Tile.wl, Tile.wl, Tile.wl, Tile.dc, Tile.wl, Tile.wl, Tile.wl, Tile.wl, Tile.wl},
			{Tile.hr, Tile.hr, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.hr, Tile.hr},
			{Tile.hr, Tile.hr, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.hr, Tile.hr},
			{Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.bg, Tile.gs, Tile.rk, Tile.gs, Tile.gs, Tile.gs},
			{Tile.gs, Tile.gs, Tile.rk, Tile.en, Tile.rk, Tile.gs, Tile.gs, Tile.en, Tile.gs, Tile.gs, Tile.gs},
			{Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.bg, Tile.gs, Tile.rk, Tile.gs, Tile.gs, Tile.gs},
			{Tile.gs, Tile.gs, Tile.hr, Tile.gs, Tile.bg, Tile.fg, Tile.bg, Tile.gs, Tile.hr, Tile.gs, Tile.gs},
			{Tile.gs, Tile.gs, Tile.gs, Tile.rk, Tile.gs, Tile.bg, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs},
			{Tile.gs, Tile.gs, Tile.gs, Tile.en, Tile.gs, Tile.gs, Tile.rk, Tile.en, Tile.rk, Tile.gs, Tile.gs},
			{Tile.gs, Tile.gs, Tile.gs, Tile.rk, Tile.gs, Tile.bg, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs},
			{Tile.hr, Tile.hr, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.hr, Tile.hr},
			{Tile.hr, Tile.hr, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.hr, Tile.hr}
		},
	
		// 39, E, MEADOW
	
		{
			{Tile.wl, Tile.wl, Tile.wl, Tile.wl, Tile.wl, Tile.dc, Tile.wl, Tile.wl, Tile.wl, Tile.wl, Tile.wl},
			{Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs},
			{Tile.gs, Tile.gs, Tile.gs, Tile.bg, Tile.bg, Tile.gs, Tile.hr, Tile.hr, Tile.gs, Tile.gs, Tile.gs},
			{Tile.gs, Tile.fg, Tile.gs, Tile.bg, Tile.gs, Tile.gs, Tile.gs, Tile.hr, Tile.gs, Tile.hr, Tile.gs},
			{Tile.gs, Tile.rk, Tile.rk, Tile.rk, Tile.gs, Tile.sk, Tile.gs, Tile.rk, Tile.rk, Tile.rk, Tile.gs},
			{Tile.en, Tile.gs, Tile.hr, Tile.gs, Tile.hr, Tile.gs, Tile.bg, Tile.gs, Tile.bg, Tile.gs, Tile.bg},
			{Tile.gs, Tile.rk, Tile.rk, Tile.rk, Tile.rk, Tile.sk, Tile.rk, Tile.rk, Tile.rk, Tile.rk, Tile.gs},
			{Tile.gs, Tile.gs, Tile.bg, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.bg, Tile.gs, Tile.gs},
			{Tile.gs, Tile.rk, Tile.rk, Tile.rk, Tile.rk, Tile.sk, Tile.rk, Tile.rk, Tile.rk, Tile.rk, Tile.gs},
			{Tile.gs, Tile.gs, Tile.bg, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.bg, Tile.gs, Tile.gs},
			{Tile.gs, Tile.gs, Tile.rk, Tile.rk, Tile.rk, Tile.sk, Tile.rk, Tile.rk, Tile.rk, Tile.gs, Tile.gs},
			{Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.en, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs}
		},
	
		// 40, E, MEADOW
	
		{
			{Tile.wl, Tile.wl, Tile.wl, Tile.dc, Tile.wl, Tile.wl, Tile.wl, Tile.wl, Tile.wl, Tile.wl, Tile.wl},
			{Tile.rk, Tile.rk, Tile.gs, Tile.gs, Tile.hr, Tile.hr, Tile.hr, Tile.gs, Tile.gs, Tile.rk, Tile.rk},
			{Tile.rk, Tile.rk, Tile.rk, Tile.rk, Tile.hr, Tile.bg, Tile.hr, Tile.gs, Tile.rk, Tile.rk, Tile.rk},
			{Tile.gs, Tile.rk, Tile.rk, Tile.gs, Tile.hr, Tile.hr, Tile.hr, Tile.en, Tile.gs, Tile.rk, Tile.gs},
			{Tile.gs, Tile.rk, Tile.gs, Tile.en, Tile.gs, Tile.gs, Tile.bg, Tile.rk, Tile.gs, Tile.gs, Tile.gs},
			{Tile.hr, Tile.hr, Tile.bg, Tile.hr, Tile.bg, Tile.gs, Tile.gs, Tile.fg, Tile.gs, Tile.gs, Tile.gs},
			{Tile.hr, Tile.gs, Tile.gs, Tile.hr, Tile.gs, Tile.gs, Tile.gs, Tile.bg, Tile.gs, Tile.gs, Tile.gs},
			{Tile.hr, Tile.gs, Tile.gs, Tile.hr, Tile.gs, Tile.bg, Tile.gs, Tile.gs, Tile.en, Tile.gs, Tile.gs},
			{Tile.hr, Tile.hr, Tile.hr, Tile.hr, Tile.en, Tile.rk, Tile.bg, Tile.gs, Tile.gs, Tile.gs, Tile.gs},
			{Tile.gs, Tile.rk, Tile.gs, Tile.gs, Tile.gs, Tile.hr, Tile.hr, Tile.hr, Tile.gs, Tile.rk, Tile.gs},
			{Tile.rk, Tile.rk, Tile.rk, Tile.gs, Tile.gs, Tile.hr, Tile.gs, Tile.hr, Tile.rk, Tile.rk, Tile.rk},
			{Tile.rk, Tile.rk, Tile.gs, Tile.gs, Tile.gs, Tile.hr, Tile.hr, Tile.hr, Tile.gs, Tile.rk, Tile.rk}
		},
	
		// 41, E, MEADOW
	
		{
			{Tile.dc, Tile.wl, Tile.wl, Tile.wl, Tile.wl, Tile.wl, Tile.wl, Tile.wl, Tile.wl, Tile.wl, Tile.wl},
			{Tile.fg, Tile.gs, Tile.gs, Tile.gs, Tile.rk, Tile.en, Tile.en, Tile.rk, Tile.gs, Tile.gs, Tile.gs},
			{Tile.gs, Tile.hr, Tile.bg, Tile.bg, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.bg, Tile.hr, Tile.gs},
			{Tile.gs, Tile.bg, Tile.hr, Tile.hr, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.hr, Tile.bg, Tile.gs},
			{Tile.gs, Tile.bg, Tile.hr, Tile.hr, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.hr, Tile.hr, Tile.gs},
			{Tile.rk, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.rk},
			{Tile.en, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.hr, Tile.hr, Tile.gs, Tile.gs, Tile.gs, Tile.en},
			{Tile.en, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.hr, Tile.hr, Tile.gs, Tile.gs, Tile.gs, Tile.en},
			{Tile.rk, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.rk},
			{Tile.gs, Tile.bs, Tile.bg, Tile.bg, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.bg, Tile.bs, Tile.gs},
			{Tile.gs, Tile.bg, Tile.bs, Tile.bs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.bs, Tile.bg, Tile.gs},
			{Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.rk, Tile.en, Tile.en, Tile.rk, Tile.gs, Tile.gs, Tile.gs}
		},
	
		// 42, E, PYRAMID
	
		{
			{Tile.wl, Tile.wl, Tile.wl, Tile.wl, Tile.wl, Tile.dc, Tile.wl, Tile.wl, Tile.wl, Tile.wl, Tile.wl},
			{Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.fg, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs},
			{Tile.gs, Tile.bg, Tile.hr, Tile.bg, Tile.hr, Tile.bg, Tile.hr, Tile.bg, Tile.hr, Tile.bg, Tile.gs},
			{Tile.gs, Tile.gs, Tile.bg, Tile.hr, Tile.bg, Tile.hr, Tile.bg, Tile.hr, Tile.bg, Tile.gs, Tile.gs},
			{Tile.gs, Tile.gs, Tile.gs, Tile.bg, Tile.hr, Tile.bg, Tile.hr, Tile.bg, Tile.gs, Tile.gs, Tile.gs},
			{Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.bg, Tile.hr, Tile.bg, Tile.gs, Tile.gs, Tile.gs, Tile.gs},
			{Tile.en, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.bs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.en},
			{Tile.en, Tile.gs, Tile.gs, Tile.gs, Tile.sk, Tile.gs, Tile.sk, Tile.gs, Tile.gs, Tile.gs, Tile.en},
			{Tile.en, Tile.gs, Tile.gs, Tile.sk, Tile.gs, Tile.gs, Tile.gs, Tile.sk, Tile.gs, Tile.gs, Tile.en},
			{Tile.gs, Tile.gs, Tile.sk, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.sk, Tile.gs, Tile.gs},
			{Tile.gs, Tile.sk, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.sk, Tile.gs},
			{Tile.sk, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.sk}
		},
	
		// 43, E, PACKING
	
		{
			{Tile.wl, Tile.wl, Tile.wl, Tile.wl, Tile.wl, Tile.dc, Tile.wl, Tile.wl, Tile.wl, Tile.wl, Tile.wl},
			{Tile.rk, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.fg, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.rk},
			{Tile.rk, Tile.gs, Tile.gs, Tile.bg, Tile.gs, Tile.bg, Tile.gs, Tile.bg, Tile.gs, Tile.gs, Tile.rk},
			{Tile.rk, Tile.gs, Tile.gs, Tile.bg, Tile.gs, Tile.bg, Tile.gs, Tile.bg, Tile.gs, Tile.gs, Tile.rk},
			{Tile.gs, Tile.gs, Tile.gs, Tile.bg, Tile.gs, Tile.bg, Tile.gs, Tile.bg, Tile.gs, Tile.gs, Tile.gs},
			{Tile.gs, Tile.gs, Tile.gs, Tile.rk, Tile.rk, Tile.rk, Tile.rk, Tile.rk, Tile.gs, Tile.gs, Tile.gs},
			{Tile.gs, Tile.gs, Tile.rk, Tile.rk, Tile.sk, Tile.rk, Tile.sk, Tile.rk, Tile.rk, Tile.gs, Tile.gs},
			{Tile.gs, Tile.gs, Tile.rk, Tile.sk, Tile.sk, Tile.sk, Tile.sk, Tile.sk, Tile.rk, Tile.gs, Tile.gs},
			{Tile.gs, Tile.gs, Tile.rk, Tile.rk, Tile.sk, Tile.rk, Tile.sk, Tile.bs, Tile.rk, Tile.gs, Tile.gs},
			{Tile.gs, Tile.gs, Tile.gs, Tile.bg, Tile.gs, Tile.bg, Tile.gs, Tile.bg, Tile.gs, Tile.gs, Tile.gs},
			{Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs},
			{Tile.gs, Tile.en, Tile.hr, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.en, Tile.en, Tile.gs}
		},
	
		// 44, E, PACKING
	
		{
			{Tile.wl, Tile.dc, Tile.wl, Tile.wl, Tile.wl, Tile.wl, Tile.wl, Tile.wl, Tile.wl, Tile.wl, Tile.wl},
			{Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.bg, Tile.gs, Tile.gs, Tile.gs},
			{Tile.gs, Tile.fg, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.bg, Tile.bg, Tile.gs, Tile.gs},
			{Tile.gs, Tile.bg, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.bg, Tile.gs, Tile.gs, Tile.gs},
			{Tile.rk, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.rk, Tile.rk, Tile.gs, Tile.rk, Tile.rk, Tile.rk},
			{Tile.en, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.rk, Tile.gs, Tile.gs, Tile.sk, Tile.sk, Tile.rk},
			{Tile.en, Tile.gs, Tile.gs, Tile.gs, Tile.hr, Tile.rk, Tile.gs, Tile.gs, Tile.sk, Tile.sk, Tile.rk},
			{Tile.en, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.rk, Tile.gs, Tile.rk, Tile.rk, Tile.rk, Tile.rk},
			{Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.bg, Tile.gs, Tile.gs, Tile.gs, Tile.gs},
			{Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.bg, Tile.bg, Tile.gs, Tile.gs, Tile.gs},
			{Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.bg, Tile.gs, Tile.gs, Tile.gs, Tile.gs},
			{Tile.rk, Tile.hr, Tile.rk, Tile.rk, Tile.en, Tile.rk, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs}
		},
	
		// 45, E, ROOMS
	
		{
			{Tile.wl, Tile.wl, Tile.wl, Tile.wl, Tile.wl, Tile.wl, Tile.wl, Tile.wl, Tile.dc, Tile.wl, Tile.wl},
			{Tile.en, Tile.gs, Tile.gs, Tile.gs, Tile.en, Tile.rk, Tile.en, Tile.gs, Tile.gs, Tile.gs, Tile.en},
			{Tile.gs, Tile.hr, Tile.hr, Tile.hr, Tile.bs, Tile.rk, Tile.sk, Tile.hr, Tile.hr, Tile.hr, Tile.gs},
			{Tile.gs, Tile.bg, Tile.fg, Tile.bg, Tile.gs, Tile.gs, Tile.gs, Tile.bg, Tile.hr, Tile.bg, Tile.gs},
			{Tile.gs, Tile.hr, Tile.bg, Tile.bg, Tile.bs, Tile.rk, Tile.sk, Tile.hr, Tile.hr, Tile.hr, Tile.gs},
			{Tile.en, Tile.sk, Tile.gs, Tile.sk, Tile.en, Tile.rk, Tile.en, Tile.bs, Tile.gs, Tile.bs, Tile.en},
			{Tile.rk, Tile.rk, Tile.gs, Tile.rk, Tile.rk, Tile.rk, Tile.rk, Tile.rk, Tile.gs, Tile.rk, Tile.rk},
			{Tile.en, Tile.bs, Tile.gs, Tile.bs, Tile.en, Tile.rk, Tile.en, Tile.sk, Tile.gs, Tile.sk, Tile.en},
			{Tile.gs, Tile.hr, Tile.hr, Tile.hr, Tile.sk, Tile.rk, Tile.bs, Tile.hr, Tile.bg, Tile.hr, Tile.gs},
			{Tile.gs, Tile.hr, Tile.hr, Tile.bg, Tile.gs, Tile.gs, Tile.gs, Tile.hr, Tile.hr, Tile.bg, Tile.gs},
			{Tile.gs, Tile.hr, Tile.bg, Tile.gs, Tile.sk, Tile.rk, Tile.bs, Tile.hr, Tile.hr, Tile.hr, Tile.gs},
			{Tile.en, Tile.gs, Tile.gs, Tile.gs, Tile.en, Tile.rk, Tile.en, Tile.gs, Tile.gs, Tile.gs, Tile.en}
		},
	
		// 46, E, ROOMS
	
		{
			{Tile.wl, Tile.wl, Tile.wl, Tile.wl, Tile.wl, Tile.wl, Tile.wl, Tile.wl, Tile.dc, Tile.wl, Tile.wl},
			{Tile.gs, Tile.sk, Tile.gs, Tile.bg, Tile.gs, Tile.gs, Tile.rk, Tile.gs, Tile.hr, Tile.gs, Tile.en},
			{Tile.gs, Tile.gs, Tile.hr, Tile.bg, Tile.hr, Tile.gs, Tile.rk, Tile.gs, Tile.gs, Tile.gs, Tile.en},
			{Tile.gs, Tile.gs, Tile.gs, Tile.rk, Tile.gs, Tile.gs, Tile.rk, Tile.gs, Tile.hr, Tile.gs, Tile.en},
			{Tile.gs, Tile.gs, Tile.gs, Tile.rk, Tile.gs, Tile.gs, Tile.bg, Tile.gs, Tile.gs, Tile.gs, Tile.en},
			{Tile.rk, Tile.hr, Tile.rk, Tile.rk, Tile.rk, Tile.rk, Tile.bg, Tile.rk, Tile.hr, Tile.rk, Tile.rk},
			{Tile.gs, Tile.gs, Tile.gs, Tile.rk, Tile.gs, Tile.fg, Tile.gs, Tile.rk, Tile.gs, Tile.gs, Tile.gs},
			{Tile.gs, Tile.gs, Tile.gs, Tile.rk, Tile.bg, Tile.rk, Tile.rk, Tile.rk, Tile.rk, Tile.rk, Tile.bg},
			{Tile.gs, Tile.gs, Tile.gs, Tile.bg, Tile.gs, Tile.gs, Tile.gs, Tile.rk, Tile.gs, Tile.gs, Tile.gs},
			{Tile.gs, Tile.gs, Tile.gs, Tile.rk, Tile.gs, Tile.gs, Tile.gs, Tile.rk, Tile.gs, Tile.gs, Tile.gs},
			{Tile.gs, Tile.gs, Tile.hr, Tile.rk, Tile.bg, Tile.gs, Tile.bg, Tile.bg, Tile.hr, Tile.gs, Tile.gs},
			{Tile.gs, Tile.en, Tile.gs, Tile.rk, Tile.gs, Tile.gs, Tile.gs, Tile.bg, Tile.gs, Tile.gs, Tile.gs}
		},
	
		// 47, E, ROOMS
	
		{
			{Tile.dc, Tile.wl, Tile.wl, Tile.wl, Tile.wl, Tile.wl, Tile.wl, Tile.wl, Tile.wl, Tile.wl, Tile.wl},
			{Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.rk, Tile.rk, Tile.rk, Tile.rk, Tile.rk},
			{Tile.gs, Tile.bg, Tile.gs, Tile.bg, Tile.gs, Tile.gs, Tile.rk, Tile.rk, Tile.rk, Tile.rk, Tile.rk},
			{Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.rk, Tile.gs, Tile.sk, Tile.rk, Tile.rk},
			{Tile.gs, Tile.hr, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.rk},
			{Tile.gs, Tile.gs, Tile.gs, Tile.en, Tile.gs, Tile.gs, Tile.rk, Tile.rk, Tile.gs, Tile.gs, Tile.rk},
			{Tile.rk, Tile.rk, Tile.rk, Tile.rk, Tile.rk, Tile.gs, Tile.en, Tile.rk, Tile.gs, Tile.rk, Tile.rk},
			{Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.rk, Tile.rk, Tile.gs, Tile.gs, Tile.rk},
			{Tile.gs, Tile.bg, Tile.gs, Tile.gs, Tile.fg, Tile.bg, Tile.gs, Tile.gs, Tile.gs, Tile.sk, Tile.rk},
			{Tile.gs, Tile.bg, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.rk, Tile.gs, Tile.gs, Tile.rk, Tile.rk},
			{Tile.gs, Tile.sk, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.rk, Tile.rk, Tile.rk, Tile.rk, Tile.rk},
			{Tile.gs, Tile.gs, Tile.gs, Tile.en, Tile.gs, Tile.gs, Tile.rk, Tile.rk, Tile.rk, Tile.rk, Tile.rk}
		},
	
		// 48, SPECIAL, BEFORE FINAL
	
		{
			{Tile.wl, Tile.wl, Tile.wl, Tile.wl, Tile.wl, Tile.wl, Tile.wl, Tile.wl, Tile.dc, Tile.wl, Tile.wl},
			{Tile.en, Tile.en, Tile.en, Tile.en, Tile.rk, Tile.rk, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.fg},
			{Tile.rk, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.bg, Tile.gs, Tile.bg, Tile.bg, Tile.gs, Tile.gs},
			{Tile.en, Tile.gs, Tile.gs, Tile.rk, Tile.gs, Tile.rk, Tile.gs, Tile.gs, Tile.bg, Tile.bg, Tile.hr},
			{Tile.en, Tile.rk, Tile.rk, Tile.rk, Tile.gs, Tile.rk, Tile.rk, Tile.gs, Tile.gs, Tile.bg, Tile.hr},
			{Tile.rk, Tile.rk, Tile.sk, Tile.sk, Tile.sk, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.hr},
			{Tile.rk, Tile.rk, Tile.rk, Tile.rk, Tile.sk, Tile.rk, Tile.rk, Tile.rk, Tile.gs, Tile.rk, Tile.rk},
			{Tile.en, Tile.rk, Tile.sk, Tile.sk, Tile.sk, Tile.gs, Tile.gs, Tile.rk, Tile.gs, Tile.gs, Tile.rk},
			{Tile.en, Tile.rk, Tile.rk, Tile.gs, Tile.rk, Tile.rk, Tile.gs, Tile.rk, Tile.rk, Tile.gs, Tile.hr},
			{Tile.en, Tile.rk, Tile.rk, Tile.gs, Tile.rk, Tile.gs, Tile.gs, Tile.gs, Tile.bg, Tile.gs, Tile.hr},
			{Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.bg, Tile.gs, Tile.rk},
			{Tile.hr, Tile.gs, Tile.gs, Tile.gs, Tile.rk, Tile.rk, Tile.gs, Tile.hr, Tile.hr, Tile.hr, Tile.hr}
		},
	
		// 49, SPECIAL, (|<)
	
		{
			{Tile.wl, Tile.wl, Tile.wl, Tile.wl, Tile.wl, Tile.dp, Tile.wl, Tile.wl, Tile.wl, Tile.wl, Tile.wl},
			{Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs},
			{Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs},
			{Tile.gs, Tile.gs, Tile.rk, Tile.rk, Tile.gs, Tile.gs, Tile.gs, Tile.rk, Tile.rk, Tile.gs, Tile.gs},
			{Tile.gs, Tile.rk, Tile.gs, Tile.rk, Tile.gs, Tile.gs, Tile.rk, Tile.gs, Tile.gs, Tile.rk, Tile.gs},
			{Tile.gs, Tile.rk, Tile.gs, Tile.rk, Tile.gs, Tile.rk, Tile.gs, Tile.gs, Tile.gs, Tile.rk, Tile.gs},
			{Tile.gs, Tile.rk, Tile.gs, Tile.rk, Tile.gs, Tile.rk, Tile.gs, Tile.gs, Tile.gs, Tile.rk, Tile.gs},
			{Tile.gs, Tile.rk, Tile.gs, Tile.rk, Tile.gs, Tile.gs, Tile.rk, Tile.gs, Tile.gs, Tile.rk, Tile.gs},
			{Tile.gs, Tile.gs, Tile.rk, Tile.rk, Tile.gs, Tile.gs, Tile.gs, Tile.rk, Tile.rk, Tile.gs, Tile.gs},
			{Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs},
			{Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.fg, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs},
			{Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs}
		},
	
		// 50, SPECIAL, FINAL
	
		{
			{Tile.wl, Tile.wl, Tile.wl, Tile.wl, Tile.wl, Tile.dc, Tile.wl, Tile.wl, Tile.wl, Tile.wl, Tile.wl},
			{Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.fg, Tile.gs, Tile.rk, Tile.en, Tile.gs, Tile.gs},
			{Tile.gs, Tile.gs, Tile.hr, Tile.bg, Tile.bg, Tile.gs, Tile.gs, Tile.rk, Tile.gs, Tile.gs, Tile.gs},
			{Tile.gs, Tile.hr, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.rk, Tile.hr, Tile.hr, Tile.hr},
			{Tile.rk, Tile.rk, Tile.rk, Tile.rk, Tile.gs, Tile.rk, Tile.rk, Tile.rk, Tile.bg, Tile.bg, Tile.hr},
			{Tile.gs, Tile.gs, Tile.gs, Tile.rk, Tile.sk, Tile.gs, Tile.sk, Tile.gs, Tile.gs, Tile.gs, Tile.gs},
			{Tile.gs, Tile.hr, Tile.gs, Tile.rk, Tile.gs, Tile.rk, Tile.gs, Tile.rk, Tile.bg, Tile.bg, Tile.hr},
			{Tile.gs, Tile.gs, Tile.gs, Tile.gs, Tile.sk, Tile.gs, Tile.sk, Tile.rk, Tile.hr, Tile.hr, Tile.hr},
			{Tile.rk, Tile.gs, Tile.rk, Tile.rk, Tile.rk, Tile.rk, Tile.gs, Tile.rk, Tile.rk, Tile.rk, Tile.rk},
			{Tile.hr, Tile.gs, Tile.gs, Tile.rk, Tile.gs, Tile.hr, Tile.gs, Tile.bg, Tile.gs, Tile.hr, Tile.gs},
			{Tile.hr, Tile.gs, Tile.gs, Tile.rk, Tile.hr, Tile.gs, Tile.hr, Tile.gs, Tile.hr, Tile.gs, Tile.en},
			{Tile.hr, Tile.hr, Tile.en, Tile.rk, Tile.gs, Tile.hr, Tile.gs, Tile.hr, Tile.gs, Tile.hr, Tile.gs}
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
