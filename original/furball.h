
/**********************************************************/
/*                                                        */
/*        F U R B A L L ’ S    A D V E N T U R E S        */
/*                                                        */
/**********************************************************/

/**********************************************************/
/* file furball.h                                         */
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
 * in furball.c  The functions there include WinMain, 
 * MainWindowProcedure, and all the other functions that call 
 * the Windows API.  They deal with setting up and maintaining 
 * the application window, drawing graphics, and playing wave 
 * audio and MIDI music.
 */

/* FUNCTIONS IN FURBALL.C */

// (no declaration needed for winmain)
LRESULT CALLBACK MainWindowProcedure(HWND hWnd, UINT uiMessage, WPARAM wParam, LPARAM lParam);

void wasresized();
void drawtile(tile tilename, int xgrid, int ygrid);
void statusbar(int currentlevel, int lives);

void soundeffect(soundtitle sound);
void jukebox(musiccommand command);
void playsong(music songname);
DWORD playmidi(HWND hWndNotify, LPSTR lpszMIDIFileName);
void stopmidi();

void prepareoptionsmenu();
void menunewgame();
void menugiveup();
void menuenterlevelcode();
BOOL CALLBACK dplevelcode(HWND hDlg, UINT message, WPARAM wParam, LPARAM lParam);
int lookuplevelcode(char *inputstring);
void menuexit();
void menusoundeffects();
void menuquickhelp();
BOOL CALLBACK dpquickhelp(HWND hDlg, UINT message, WPARAM wParam, LPARAM lParam);
void menuabout();
BOOL CALLBACK dpabout(HWND hDlg, UINT message, WPARAM wParam, LPARAM lParam);

void gameover();
void gamewon();
BOOL CALLBACK dpgamewon(HWND hDlg, UINT message, WPARAM wParam, LPARAM lParam);

void setupregvar(char *regvarname, int *memoryvar, int defaultvalue);
void writeregvar(char *regvarname, int *memoryvar, int newvalue);

void checkdaystate();
daystate getlight();

/**********************************************************/
/* end of file furball.h                                  */
/**********************************************************/
