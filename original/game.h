
/**********************************************************/
/*                                                        */
/*        F U R B A L L ’ S    A D V E N T U R E S        */
/*                                                        */
/**********************************************************/

/**********************************************************/
/* file game.h                                            */
/**********************************************************/

/* 
 * This file is one of five files that make up the source code 
 * to Furball’s Adventures, a multimedia puzzle game for 
 * Windows 95 and Windows NT.  The five files including this 
 * one are levels.h, furball.h, furball.c, game.h, and game.c.  
 * These files compile into the Windows executable file 
 * Furball.exe.
 * 
 * This file contains function prototypes for all the functions 
 * in game.c.  The functions there relate to the logic and 
 * workings of the game, and do not make any direct calls to 
 * the Windows API.  They deal with setting up the board, 
 * processing requested moves, and making calls to functions in 
 * furball.h to in turn request services from Windows.
 */

/* FUNCTIONS IN GAME.C */

void initialize(int startinglevel);
void loadlevel(int level);
void saveboard();

void movefurball(direction givendir);
void runchecks();
void findfurball(int *row, int *col);
tile whatsat(int row, int col);
tiletype gettype(tile giventile);
tiledanger getdanger(tile giventile);

void killfurball();
void finishedlevel();

void drawboard();
void drawwindow();
void updateboard();

/**********************************************************/
/* end of file game.h                                     */
/**********************************************************/
