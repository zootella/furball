package org.zootella.furball.original;
	
public class OriginalFurballC {
	
	/**********************************************************/
	/*                                                        */
	/*        F U R B A L L ’ S    A D V E N T U R E S        */
	/*                                                        */
	/**********************************************************/
	
	/**********************************************************/
	/* file furball.c                                         */
	/**********************************************************/
	
	/* 
	 * This file is one of five files that make up the source code 
	 * to Furball’s Adventures, a multimedia puzzle game for 
	 * Windows 95 and Windows NT.  The five files including this 
	 * one are levels.h, furball.h, furball.c, game.h, and game.c.  
	 * These files compile into the Windows executable file 
	 * Furball.exe.
	 * 
	 * This file contains WinMain, MainWindowProcedure, and all the 
	 * other functions that call the Windows API.  The functions 
	 * here deal with setting up and maintaining the application 
	 * window, drawing graphics, and playing wave audio and MIDI 
	 * music.
	 * 
	 * The functions in this file need the definitions and 
	 * functions in three external h files.  The file windows.h 
	 * must be included in all Windows programs.  The file 
	 * resource.h is prepared by Microsoft Developer Studio and 
	 * contains the resource bitmaps, dialogs, menu, icons, and 
	 * wave audio files that are compiled into the executable.  The 
	 * file mmsystem.h relates to the multimedia system that 
	 * Windows provides, and must be included here for the 
	 * functions that control sound effects and music.
	 * 
	 * The three h files that are part of the source code of this 
	 * file, levels.h, furball.h, and game.h, are also included.
	 * 
	 * This file uses a number of global variables.  Please see the 
	 * design document for Furball’s Adventures for a compelling 
	 * argument as to why all these global variables are absolutely 
	 * necessary.
	 * 
	 * The global variables that are related closely to Windows 
	 * include hgInstance, the handle to the instance of this 
	 * application, and hWnd, the handle to the main application 
	 * window.  This program has no child or secondary windows, so 
	 * hWnd is the only window handle that the program deals with.  
	 * Also defined as global are the handles to all the graphic 
	 * tiles used by the program to draw the board.  The night 
	 * version of each tile has a similar name, but with an 
	 * additional trailing "n".
	 * 
	 * The variables soundeffectson, startuphelp, and 
	 * currentmusicoption are defined in memory to mirror the three 
	 * values stored in the Registry.  If the sound effects are on 
	 * and quick help should be displayed at startup, the two first 
	 * variables are TRUE.  The third variable, currentmusicoption, 
	 * is of type music, but should never be set to the data value 
	 * THRONE.
	 * 
	 * The external global variable currentlevel is brought in from 
	 * the file game.c and used here by the function jukebox.  The 
	 * only game-related global variable defined in this file is 
	 * currentdaystate, which is either DAY or NIGHT, depending on 
	 * the local time of the computer’s clock.
	 */
	
	/* EXTERNAL INCLUDE STATEMENTS */
	
	#include <windows.h>
	#include "resource.h"
	#include "mmsystem.h"
	
	/* INTERNAL INCLUDE STATEMENTS */
	
	#include "levels.h"
	#include "furball.h"
	#include "game.h"
	
	/* WINDOWS GLOBAL VARIABLES */
	
	HINSTANCE hgInstance;	// THE UNIQUE NUMBER FOR THIS INSTANCE
	HWND hWnd;				// THE HANDLE TO THE APPLICATION WINDOW
	
	HBITMAP fbongrass, fbongrassn; // HOLDERS FOR THE BITMAPS
	HBITMAP fbonsink, fbonsinkn;
	HBITMAP boxongrass, boxongrassn;
	HBITMAP boxonsink, boxonsinkn;
	HBITMAP rock, rockn;
	HBITMAP wall, walln;
	HBITMAP enemy, enemyn;
	HBITMAP grass, grassn;
	HBITMAP sink, sinkn;
	HBITMAP heart, heartn;
	HBITMAP doorclosed, doorclosedn;
	HBITMAP dooropen, dooropenn;
	
	/* REGISTRY GLOBAL VARIABLES */
	
	BOOL soundeffectson;
	BOOL startuphelp;
	music currentmusicoption;
	
	/* GAME GLOBAL VARIABLES */
	
	extern int currentlevel;
	daystate currentdaystate;
	
	/********************************************/
	/* WIN MAIN                                 */
	/********************************************/
	
	/* 
	 * This function is where control starts in the program.  It 
	 * has the job of initializing variables, setting up data 
	 * structures, registering the window, and displaying the 
	 * window.  It then passes control to MainWindowProcedure.  The 
	 * function has many arguments and a return value, all of which 
	 * are specified by Windows and which do not relate to the 
	 * programming of the game.
	 * 
	 * The variable msg deals with window messages, wndclass deals 
	 * with the class of the window, and hIcon is a handle to the 
	 * application icon.  The integers desxpos and desypos are the 
	 * desired x and y position of the window that the window will 
	 * be moved to, while deswinwidth and deswinheight are the 
	 * desired window width and height.
	 * 
	 * This function works by first saving the instance number that 
	 * Windows gives the application as soon as it is run into a 
	 * global variable.  The application icon and all the bitmap 
	 * graphics used by the game are then loaded into memory, and 
	 * the handle to each is checked to make sure that the process 
	 * was successful.  Data is then filled into the wndclass 
	 * structure to prepare the class of the main application 
	 * window, which is then registered with the system.  The 
	 * function GetSystemMetrics is called numerous times to find 
	 * out about the size of various graphical elements of the 
	 * current user’s Windows configuration, and based on this 
	 * information, the desired window width and height is 
	 * calculated.  More calls are made to GetSystemMetrics, and 
	 * the desired initial window position is found.  The main 
	 * window is then created based upon the previously registered 
	 * window class, although the window is not displayed on the 
	 * screen yet.  Three calls to the function setupregvar are 
	 * made to get information from the registry and load it into 
	 * global variables.  The current day state is found, and the 
	 * game is setup by calling initialize in game.c.  Now the 
	 * window is displayed and the inside painted.  At this point 
	 * initialize has also send a command to jukebox, and the music 
	 * will have started.  If appropriate, the quick help dialog 
	 * box is displayed, and the game does not begin until it is 
	 * cleared.  With all initializations complete and the game in 
	 * progress, control is forwarded to MainWindowProcedure where 
	 * it will center for the rest of the time the application is 
	 * running.
	 * 
	 * This function ignores any command line arguments that the 
	 * program was run with.
	 */
	
	int WINAPI WinMain(HINSTANCE hInstance, HINSTANCE hPrevInstance,
					   PSTR szCmdLine, int iCmdShow)
	{
		MSG        msg;
		WNDCLASSEX wndclass;
		HICON      hIcon;
		int        desxpos, desypos;
		int        deswinwidth, deswinheight;
	
		/* SAVE THE INSTANCE NUMBER IN A GLOBAL VARIABLE */
	
		hgInstance = hInstance;
	
		/* LOAD THE APPLICATION ICON */
	
		hIcon = LoadImage(hInstance, "APPICON", IMAGE_ICON, 16, 16, LR_DEFAULTCOLOR);
		if (hIcon == (HICON)NULL) MessageBox(hWnd, "The icon could not be loaded.", APPNAMELONG, MB_OK);
	
		/* LOAD THE GAME TILE BITMAPS */
	
		fbongrass   = LoadImage(hInstance, "FBONGRASS",   IMAGE_BITMAP, TILESIZE, TILESIZE, LR_DEFAULTCOLOR);
		fbongrassn  = LoadImage(hInstance, "FBONGRASSN",  IMAGE_BITMAP, TILESIZE, TILESIZE, LR_DEFAULTCOLOR);
		fbonsink    = LoadImage(hInstance, "FBONSINK",    IMAGE_BITMAP, TILESIZE, TILESIZE, LR_DEFAULTCOLOR);
		fbonsinkn   = LoadImage(hInstance, "FBONSINKN",   IMAGE_BITMAP, TILESIZE, TILESIZE, LR_DEFAULTCOLOR);
		boxongrass  = LoadImage(hInstance, "BOXONGRASS",  IMAGE_BITMAP, TILESIZE, TILESIZE, LR_DEFAULTCOLOR);
		boxongrassn = LoadImage(hInstance, "BOXONGRASSN", IMAGE_BITMAP, TILESIZE, TILESIZE, LR_DEFAULTCOLOR);
		boxonsink   = LoadImage(hInstance, "BOXONSINK",   IMAGE_BITMAP, TILESIZE, TILESIZE, LR_DEFAULTCOLOR);
		boxonsinkn  = LoadImage(hInstance, "BOXONSINKN",  IMAGE_BITMAP, TILESIZE, TILESIZE, LR_DEFAULTCOLOR);
		rock        = LoadImage(hInstance, "ROCK",        IMAGE_BITMAP, TILESIZE, TILESIZE, LR_DEFAULTCOLOR);
		rockn       = LoadImage(hInstance, "ROCKN",       IMAGE_BITMAP, TILESIZE, TILESIZE, LR_DEFAULTCOLOR);
		wall        = LoadImage(hInstance, "WALL",        IMAGE_BITMAP, TILESIZE, TILESIZE, LR_DEFAULTCOLOR);
		walln       = LoadImage(hInstance, "WALLN",       IMAGE_BITMAP, TILESIZE, TILESIZE, LR_DEFAULTCOLOR);
		enemy       = LoadImage(hInstance, "ENEMY",       IMAGE_BITMAP, TILESIZE, TILESIZE, LR_DEFAULTCOLOR);
		enemyn      = LoadImage(hInstance, "ENEMYN",      IMAGE_BITMAP, TILESIZE, TILESIZE, LR_DEFAULTCOLOR);
		grass       = LoadImage(hInstance, "GRASS",       IMAGE_BITMAP, TILESIZE, TILESIZE, LR_DEFAULTCOLOR);
		grassn      = LoadImage(hInstance, "GRASSN",      IMAGE_BITMAP, TILESIZE, TILESIZE, LR_DEFAULTCOLOR);
		sinkn       = LoadImage(hInstance, "SINKN",       IMAGE_BITMAP, TILESIZE, TILESIZE, LR_DEFAULTCOLOR);
		sink        = LoadImage(hInstance, "SINK",        IMAGE_BITMAP, TILESIZE, TILESIZE, LR_DEFAULTCOLOR);
		heart       = LoadImage(hInstance, "HEART",       IMAGE_BITMAP, TILESIZE, TILESIZE, LR_DEFAULTCOLOR);
		heartn      = LoadImage(hInstance, "HEARTN",      IMAGE_BITMAP, TILESIZE, TILESIZE, LR_DEFAULTCOLOR);
		doorclosed  = LoadImage(hInstance, "DOORCLOSED",  IMAGE_BITMAP, TILESIZE, TILESIZE, LR_DEFAULTCOLOR);
		doorclosedn = LoadImage(hInstance, "DOORCLOSEDN", IMAGE_BITMAP, TILESIZE, TILESIZE, LR_DEFAULTCOLOR);
		dooropen    = LoadImage(hInstance, "DOOROPEN",    IMAGE_BITMAP, TILESIZE, TILESIZE, LR_DEFAULTCOLOR);
		dooropenn   = LoadImage(hInstance, "DOOROPENN",   IMAGE_BITMAP, TILESIZE, TILESIZE, LR_DEFAULTCOLOR);
	
		if (fbongrass   == (HBITMAP)NULL) MessageBox(hWnd, "A bitmap could not be loaded.", APPNAMELONG, MB_OK);
		if (fbongrassn  == (HBITMAP)NULL) MessageBox(hWnd, "A bitmap could not be loaded.", APPNAMELONG, MB_OK);
		if (fbonsink    == (HBITMAP)NULL) MessageBox(hWnd, "A bitmap could not be loaded.", APPNAMELONG, MB_OK);
		if (fbonsinkn   == (HBITMAP)NULL) MessageBox(hWnd, "A bitmap could not be loaded.", APPNAMELONG, MB_OK);
		if (boxongrass  == (HBITMAP)NULL) MessageBox(hWnd, "A bitmap could not be loaded.", APPNAMELONG, MB_OK);
		if (boxongrassn == (HBITMAP)NULL) MessageBox(hWnd, "A bitmap could not be loaded.", APPNAMELONG, MB_OK);
		if (boxonsink   == (HBITMAP)NULL) MessageBox(hWnd, "A bitmap could not be loaded.", APPNAMELONG, MB_OK);
		if (boxonsinkn  == (HBITMAP)NULL) MessageBox(hWnd, "A bitmap could not be loaded.", APPNAMELONG, MB_OK);
		if (rock        == (HBITMAP)NULL) MessageBox(hWnd, "A bitmap could not be loaded.", APPNAMELONG, MB_OK);
		if (rockn       == (HBITMAP)NULL) MessageBox(hWnd, "A bitmap could not be loaded.", APPNAMELONG, MB_OK);
		if (wall        == (HBITMAP)NULL) MessageBox(hWnd, "A bitmap could not be loaded.", APPNAMELONG, MB_OK);
		if (walln       == (HBITMAP)NULL) MessageBox(hWnd, "A bitmap could not be loaded.", APPNAMELONG, MB_OK);
		if (enemy       == (HBITMAP)NULL) MessageBox(hWnd, "A bitmap could not be loaded.", APPNAMELONG, MB_OK);
		if (enemyn      == (HBITMAP)NULL) MessageBox(hWnd, "A bitmap could not be loaded.", APPNAMELONG, MB_OK);
		if (grass       == (HBITMAP)NULL) MessageBox(hWnd, "A bitmap could not be loaded.", APPNAMELONG, MB_OK);
		if (grassn      == (HBITMAP)NULL) MessageBox(hWnd, "A bitmap could not be loaded.", APPNAMELONG, MB_OK);
		if (sink        == (HBITMAP)NULL) MessageBox(hWnd, "A bitmap could not be loaded.", APPNAMELONG, MB_OK);
		if (sinkn       == (HBITMAP)NULL) MessageBox(hWnd, "A bitmap could not be loaded.", APPNAMELONG, MB_OK);
		if (heart       == (HBITMAP)NULL) MessageBox(hWnd, "A bitmap could not be loaded.", APPNAMELONG, MB_OK);
		if (heartn      == (HBITMAP)NULL) MessageBox(hWnd, "A bitmap could not be loaded.", APPNAMELONG, MB_OK);
		if (doorclosed  == (HBITMAP)NULL) MessageBox(hWnd, "A bitmap could not be loaded.", APPNAMELONG, MB_OK);
		if (doorclosedn == (HBITMAP)NULL) MessageBox(hWnd, "A bitmap could not be loaded.", APPNAMELONG, MB_OK);
		if (dooropen    == (HBITMAP)NULL) MessageBox(hWnd, "A bitmap could not be loaded.", APPNAMELONG, MB_OK);
		if (dooropenn   == (HBITMAP)NULL) MessageBox(hWnd, "A bitmap could not be loaded.", APPNAMELONG, MB_OK);
	
		/* REGISTER THE CLASS FOR THE MAIN WINDOW */
	
		wndclass.cbSize			= sizeof(wndclass);						// SIZE OF THIS STRUCTURE
		wndclass.style			= 0;									// SYTLE
		wndclass.lpfnWndProc	= MainWindowProcedure;					// WINDOW PROCEDURE TO CALL
		wndclass.cbClsExtra		= 0;									// EXTRA DATA BYTES NOT USED
		wndclass.cbWndExtra		= 0;									// EXTRA DATA BYTES NOT USED
		wndclass.hInstance		= hInstance;							// INSTANCE
		wndclass.hIcon			= hIcon;								// CLASS ICON
		wndclass.hCursor		= LoadCursor(NULL,IDC_ARROW);			// CURSOR FOR WINDOW
		wndclass.hbrBackground	= (HBRUSH)GetStockObject(BLACK_BRUSH);	// COLOR OF BLANK WINDOW
		wndclass.lpszMenuName	= "IDR_MENU1";							// MENU NAME
		wndclass.lpszClassName	= APPNAME;								// APPLICATION NAME
		wndclass.hIconSm		= hIcon;								// SMALL ICON
	
		RegisterClassEx(&wndclass);
	
		/* COMPUTE VALUES FOR THE DESIRED WINDOW DIMENSIONS */
	
		deswinwidth  = BCOLPIX
			+ 2 * GetSystemMetrics(SM_CXFRAME)
			+ 2 * TDBORDER;
		deswinheight = BROWPIX
			+ 2 * GetSystemMetrics(SM_CYFRAME)
			+ 2 * TDBORDER
			+ GetSystemMetrics(SM_CYCAPTION)
			+ 2 * GetSystemMetrics(SM_CYMENU);
	
		/* FIND THE DESIRED CENTERED WINDOW POSITION */
	
		desxpos = (GetSystemMetrics(SM_CXFULLSCREEN) / 2)
			- (deswinwidth  / 2);
	
		desypos = ((GetSystemMetrics(SM_CYFULLSCREEN)
			+ GetSystemMetrics(SM_CYCAPTION)) / 2)
			- (deswinheight / 2);
	
		/* CREATE THE MAIN WINDOW */
	
		hWnd = CreateWindow(
			APPNAME,				// REGISTERED CLASS NAME
			APPNAMELONG,			// TEXT DISPLAYED IN TITLE BAR
			WS_OVERLAPPEDWINDOW,	// STYLES
			desxpos,				// INITIAL X POSITION OF WINDOW
			desypos,				// INITIAL Y POSITION OF WINDOW
			deswinwidth,			// TOTAL WINDOW WIDTH, IN PIXELS
			deswinheight,			// TOTAL WINDOW HEIGHT, IN PIXELS
			NULL,					// PARENT HANDLE
			NULL,					// MENU
			hInstance,				// APPLICATION INSTANCE
			NULL);					// ADDITIONAL WINDOW DATA
	
		/* GET INFORMATION FROM THE REGISTRY */
	
		setupregvar("RegSound", &soundeffectson,     DEFAULTSOUNDINT);
		setupregvar("RegHelp",  &startuphelp,        DEFAULTHELPINT );
		setupregvar("RegMusic", &currentmusicoption, DEFAULTMUSICINT);
	
		/* INITIALIZE THE GAME BEFORE DISPLAYING THE WINDOW */
	
		currentdaystate = getlight();
		initialize(INITIALSTARTINGLEVEL); // START AT LEVEL 0
	
		/* SHOW THE MAIN WINDOW AS REQUESTED BY WINDOWS AND PAINT IT */
	
		ShowWindow(hWnd, iCmdShow);
		UpdateWindow(hWnd);
	
		/* DISPLAY THE QUICK HELP DIALOG IF REQUESTED */
	
		if (startuphelp)
			menuquickhelp();
	
		/* ENTER THE MESSAGE LOOP */
	
		while (GetMessage(&msg, NULL, 0, 0)) {
	
			TranslateMessage(&msg);
			DispatchMessage(&msg);
	
		}
	
		return msg.wParam;
	}
	
	/********************************************/
	/* MAIN WINDOW PROCEDURE                    */
	/********************************************/
	
	/* 
	 * Messages for the main window are delivered to this function, 
	 * which has the job of sorting them and then making calls to 
	 * many other functions to process the information.  The 
	 * function’s arguments and return value are set by Windows, 
	 * and do not relate directly to the workings of the game.
	 * 
	 * The variable ps is a paintstruct that can be used to 
	 * describe the part of the screen that needs to be redrawn.  
	 * The variable hDC is a handle to the device context that 
	 * should be used to redrawn the screen when a message to do so 
	 * comes in.
	 * 
	 * This function works by using a several levels switch 
	 * statements to first sort the message that has most recently 
	 * come in.  If the message is WM_SIZE, the window has been 
	 * resized, and the function wasresized is called to deal with 
	 * this.  Likewise, prepareoptionsmenu is called if the message 
	 * is that the user has clicked on the Options menu.
	 * 
	 * Isolated enu commands like New Game or Sound Effects cause a 
	 * WM_COMMAND message to enter the function, and the bottom 
	 * word of the incoming message is read to see what menu item 
	 * was chosen.  For most menu items, this function shuttles 
	 * control directly to a function of a similar name as the menu 
	 * command.  This is not the case for the music option 
	 * functions, where more is done directly in 
	 * MainWindowProcedure.  For each selected music option, 
	 * writeregvar is first called to change the registry data to 
	 * the newly selected value as well as change the mirroring 
	 * global variable.  The command jukebox(PLAY) is then given to 
	 * refresh the music after the change.
	 * 
	 * Mouse movements and clicks are totally ignored by 
	 * MainWindowProcedure, and the only four keystrokes which are 
	 * followed are from the arrow keys.  The function calls 
	 * movefurball(UP), movefurball(DOWN), and so on are made 
	 * accordingly when the arrow keys are pressed.
	 * 
	 * When the application gets a WM_PAINT message, two somewhat 
	 * unorthodox steps are taken in redrawing the window.  First, 
	 * the information about the area of the window which has been 
	 * declared bad is ignored, and the entire window is redrawn.  
	 * Secondly, the hDC that Windows gives this function to use 
	 * when redrawing the window is not used for anything.  This is 
	 * because if the hDC were to be used, it would have to be 
	 * passed through several functions, many of which are in 
	 * game.c and should not really contain any Windows code, 
	 * before reaching drawtile or statusbar where it would finally 
	 * be used.
	 * 
	 * If this function gets a WM_DESTROY message, it closes 
	 * immediately and without checking if the user really wanted 
	 * to quit.  Hundreds of messages pass through this function as 
	 * the game progresses, the vast majority of which I do not 
	 * care about in the slightest.  For this reason, the function 
	 * ends by forwarding any message that was not sorted away and 
	 * used back to Windows.
	 */
	
	LRESULT CALLBACK MainWindowProcedure(HWND hWnd, UINT uiMessage,
										 WPARAM wParam, LPARAM lParam)
	{
		PAINTSTRUCT ps;
		HDC	hDC;
	
		switch (uiMessage) {
	
			/* THE WINDOW IS BEING RESIZED */
	
			case WM_SIZE:
				wasresized();
				return (0);
	
			/* WINDOWS IS ABOUT TO DISPLAY THE MENU */
	
			case WM_INITMENUPOPUP:
	
				if (lParam == 1) // THE OPTIONS MENU WAS CLICKED
					prepareoptionsmenu();
	
				break;
	
			/* THE USER CLICKED ON A MENU ITEM */
	
			case WM_COMMAND:
	
				switch (LOWORD(wParam)) {
	
					/* GAME MENU */
	
					case IDM_NEWGAME:        menunewgame();        break;
					case IDM_GIVEUP:         menugiveup();         break;
					case IDM_ENTERLEVELCODE: menuenterlevelcode(); break;
					case IDM_EXIT:           menuexit();           break;
					case IDM_SOUNDEFFECTS:   menusoundeffects();   break;
	
					/* OPTIONS MENU */
	
					case IDM_NOMUSIC:
						writeregvar("RegMusic", &currentmusicoption, (int)NOMUSIC);
						jukebox(PLAY);
						break;
					case IDM_CYCLEMUSIC:
						writeregvar("RegMusic", &currentmusicoption, (int)CYCLEMUSIC);
						jukebox(PLAY);
						break;
					case IDM_ODYSSEY:
						writeregvar("RegMusic", &currentmusicoption, (int)ODYSSEY);
						jukebox(PLAY);
						break;
					case IDM_AXLE:
						writeregvar("RegMusic", &currentmusicoption, (int)AXLE);
						jukebox(PLAY);
						break;
					case IDM_BOND:
						writeregvar("RegMusic", &currentmusicoption, (int)BOND);
						jukebox(PLAY);
						break;
					case IDM_ISTANBUL:
						writeregvar("RegMusic", &currentmusicoption, (int)ISTANBUL);
						jukebox(PLAY);
						break;
					case IDM_MERIDIAN:
						writeregvar("RegMusic", &currentmusicoption, (int)MERIDIAN);
						jukebox(PLAY);
						break;
					case IDM_MISSION:
						writeregvar("RegMusic", &currentmusicoption, (int)MISSION);
						jukebox(PLAY);
						break;
					case IDM_PARADISE:
						writeregvar("RegMusic", &currentmusicoption, (int)PARADISE);
						jukebox(PLAY);
						break;
					case IDM_PEANUTS:
						writeregvar("RegMusic", &currentmusicoption, (int)PEANUTS);
						jukebox(PLAY);
						break;
					case IDM_POPCORN:
						writeregvar("RegMusic", &currentmusicoption, (int)POPCORN);
						jukebox(PLAY);
						break;
					case IDM_WIPEOUT:
						writeregvar("RegMusic", &currentmusicoption, (int)WIPEOUT);
						jukebox(PLAY);
						break;
					case IDM_BOHEMIAN:
						writeregvar("RegMusic", &currentmusicoption, (int)BOHEMIAN);
						jukebox(PLAY);
						break;
					case IDM_CANNON:
						writeregvar("RegMusic", &currentmusicoption, (int)CANNON);
						jukebox(PLAY);
						break;
					case IDM_CHILDREN:
						writeregvar("RegMusic", &currentmusicoption, (int)CHILDREN);
						jukebox(PLAY);
						break;
					case IDM_DEMON:
						writeregvar("RegMusic", &currentmusicoption, (int)DEMON);
						jukebox(PLAY);
						break;
					case IDM_LION:
						writeregvar("RegMusic", &currentmusicoption, (int)LION);
						jukebox(PLAY);
						break;
					case IDM_MAD:
						writeregvar("RegMusic", &currentmusicoption, (int)MAD);
						jukebox(PLAY);
						break;
	
					/* HELP MENU */
	
					case IDM_QUICKHELP:      menuquickhelp();      break;
					case IDM_ABOUT:          menuabout();          break;
	
				}
	
				return (0);
	
			/* THE USER PRESSED A KEY ON THE KEYBOARD */
	
			case WM_KEYDOWN:
	
				switch (wParam) {
	
					case VK_UP:    movefurball(UP);    break;
					case VK_DOWN:  movefurball(DOWN);  break;
					case VK_LEFT:  movefurball(LEFT);  break;
					case VK_RIGHT: movefurball(RIGHT); break;
	
				}
	
				break;
	
			/* WINDOWS WANTS THE PROGRAM TO REPAINT THE WINDOW */
	
			case WM_PAINT:
	
				hDC = BeginPaint(hWnd, &ps); // WINDOWS REQUIRES THIS
				drawwindow();				 // I DON'T USE THE GIVEN HDC
				EndPaint(hWnd, &ps);         // WINDOWS REQUIRES THIS
	
				return (0);
	
			/* CLOSE THE APPLICATION */
	
			case WM_DESTROY:
	
				PostQuitMessage(0);
	
				return (0);
	
			}
	
		/* IF A MESSAGE MAKES IT HERE, I DON'T CARE ABOUT IT,
		   PASS IT ON TO WINDOWS */
	
		return DefWindowProc(hWnd, uiMessage, wParam, lParam);
	}
	
	/********************************************/
	/* WAS RESIZED                              */
	/********************************************/
	
	/* 
	 * This function is called whenever Windows reports that the 
	 * user has moved or resized the application window.  It checks 
	 * if the new size is large enough to view the entire screen, 
	 * and makes it large enough if it is not.  The function gets 
	 * information about the window directly from the system, and 
	 * makes API calls to resize and reposition the window as 
	 * necessary.  There are no arguments or a return value.
	 * 
	 * The variable clientrect is a rectangle structure that holds 
	 * the size of the client area of the main application window 
	 * of the program.  Boolean value isbigenough is a flag that 
	 * keeps track if a window dimension too small to keep the 
	 * entire board visible has been detected.  The integers 
	 * deswinwidth, deswinheight, desxpos, and desypos are the 
	 * desired pixel dimensions and positions of the window if it 
	 * is to be resized.
	 * 
	 * This function works by first finding the size of the client 
	 * area of the window from the system by calling GetClientRect.  
	 * The function then checks the dimensions that GetClientRect 
	 * loaded into the clientrect strucure to make sure that both 
	 * the x and y dimensions are big enough to hold the board.  If 
	 * either side of the client rectangle is found to be too 
	 * small, the flag isbigenough is set to FALSE.  Control then 
	 * splits into one of two options.  If the client area was big 
	 * enough, API calls are made to have windows send the program 
	 * messages to repaint the window.  These messages are handled 
	 * by functions other than wasresized.  The function then ends.  
	 * If instead the window was determined to be too small, the 
	 * desired window size and position are calculated, and the 
	 * program moves and resizes the window.  Control then returns 
	 * to the calling function, which is always 
	 * MainWindowProcedure, and from there the next message is 
	 * processed.
	 * 
	 * It should be noted that if the window is resized, commands 
	 * are not made here to repaint the window.  Suppose the user 
	 * sizes the window to be too small to view the entire board.  
	 * After he or she resizes the window, the program will receive 
	 * a message that a resize occurred, and this function will be 
	 * called.  The window will be found to be too small, and 
	 * control will enter case 2 in this function.  Here, the 
	 * window will be resized again, but this time, by the program 
	 * itself.  This resize will still cause a message that the 
	 * window has been changed to wait at the top of 
	 * MainWindowProcedure, however.  Control will thus enter this 
	 * function a second time.  Now, the window has been resized by 
	 * the computer and is of minimal, but large enough dimensions, 
	 * so control will enter case 1.  This will cause the window to 
	 * be repainted.  This process happens very quickly even on a 
	 * slow computer, so it appears to the user that the autosize 
	 * and painting happens simultaneously.
	 */
	
	void wasresized()
	{
		RECT clientrect;
		BOOL isbigenough;
		int deswinwidth, deswinheight;
		int desxpos, desypos;
	
		/* FIND OUT HOW BIG THE NEWLY RESIZED CLIENT AREA IS */
	
		GetClientRect(hWnd,	&clientrect);
	
		/* FIND OUT IF THE CLIENT AREA IS BIG ENOUGH */
		
		isbigenough = TRUE;
	
		if (clientrect.right < (BCOLPIX + (2 * TDBORDER)))
			isbigenough = FALSE;
	
		if (clientrect.bottom < (BROWPIX + GetSystemMetrics(SM_CYMENU)
			+ (2 * TDBORDER)))
			isbigenough = FALSE;
	
		/* CASE 1: THE WINDOW IS BIG ENOUGH */
	
		if (isbigenough) {
	
			/* HAVE THE SYSTEM SEND A MESSAGE TO REPAINT THE WINDOW */
	
			InvalidateRect(hWnd, NULL, TRUE);
			UpdateWindow(hWnd);
	
		/* CASE 2: THE WINDOW IS TOO SMALL */
	
		} else {
	
			/* COMPUTE VALUES FOR THE DESIRED WINDOW DIMENSIONS */
		
			deswinwidth  = BCOLPIX
				+ 2 * GetSystemMetrics(SM_CXFRAME)
				+ 2 * TDBORDER;
			deswinheight = BROWPIX
				+ 2 * GetSystemMetrics(SM_CYFRAME)
				+ 2 * TDBORDER
				+ GetSystemMetrics(SM_CYCAPTION)
				+ 2 * GetSystemMetrics(SM_CYMENU);
		
			/* FIND THE DESIRED CENTERED WINDOW POSITION */
		
			desxpos = (GetSystemMetrics(SM_CXFULLSCREEN) / 2)
				- (deswinwidth  / 2);
		
			desypos = ((GetSystemMetrics(SM_CYFULLSCREEN)
				+ GetSystemMetrics(SM_CYCAPTION)) / 2)
				- (deswinheight / 2);
	
			/* MOVE AND RESIZE THE WINDOW */
	
			MoveWindow(
				hWnd,			// HANDLE OF WINDOW
				desxpos,		// NEW HORIZONTAL POSITION
				desypos,		// NEW VERTICAL POSITION
				deswinwidth,	// NEW WIDTH
				deswinheight,	// NEW HEIGHT
				TRUE);			// REPAINT THE WINDOW NOW
	
		}
	}
	
	/********************************************/
	/* DRAW TILE                                */
	/********************************************/
	
	/* 
	 * This function is the main low-level graphics engine for the 
	 * program.  Given the name of a tile and the grid row and 
	 * column to place it, it takes care of drawing the correct 
	 * graphic at the correct location to keep the board centered 
	 * in the client area of the window.  There is no return value.
	 * 
	 * The variables hDC and hDCMemory are handles to device 
	 * contexts, used to display the bitmaps on the screen.  The 
	 * rectangle structure clientrect is used to hold the 
	 * dimensions of the client rectangle of the window.  The 
	 * integers xcenterspace and ycenterspace hold the x and y 
	 * pixel dimensions of the client area excluding the area taken 
	 * up by the status bar.  The integers xoffset and yoffset keep 
	 * track of how far from the upper left corner of the client 
	 * area the upper left corner of the board should be drawn.  
	 * The integers xdrawat and ydrawat give the coordinates that 
	 * the tile should be drawn at, given the tile’s specified grid 
	 * location.
	 * 
	 * This function works by first setting up a handle to device 
	 * context, which will be used to draw the bitmap on the 
	 * screen.  The current size in pixels of the client rectangle 
	 * is then found, and the values xcenterspace and ycenterspace 
	 * are calculated.  The status bar is set to be the same height 
	 * as the menu, and this is taken into consideration in this 
	 * calculation.  The vector offset of the board is then 
	 * calculated.  The integer arguments xgrid and ygrid are 
	 * converted into pixels and then added to the offset distances 
	 * to find xdrawat and ydrawat.
	 * 
	 * Now that we know the exact pixel dimensions at which to draw 
	 * the tile, a series of API calls are made to actually put the 
	 * loaded bitmap onto the screen.  First, CreateCompatableDC is 
	 * called to initialize hDCMemory.  Two switch statements 
	 * located within an if, else statement are used to take the 
	 * given tile name and select the correct graphic, given the 
	 * desired tile and whether it currently night or day.  The API 
	 * call BitBlt actually draws the selected graphic at the 
	 * calculated location.  The handles and memory used to draw 
	 * this tile are then freed, and the function ends.
	 * 
	 * For optimal performance, this function should probably be 
	 * written in two versions, one that is used only to draw one 
	 * tile and which gets and then destroys all the needed handles 
	 * to do so, and another which is used when the entire board or 
	 * a large number of tiles need to be drawn.  The other version 
	 * would takes in a hDC, use it, and then passes it back to be 
	 * used again.  As this program is currently organized, it is 
	 * somewhat wasteful for the system to have to initialize, use, 
	 * and then get rid of the graphics handle each time a tile is 
	 * drawn.  However, this method makes the program much simpler, 
	 * as all tile drawing can be handled by one function that does 
	 * not need any special windows variables like hDC.  Also, 
	 * there is no noticeable delay as the board is drawn with the 
	 * program written in this way.  For these reasons, I have 
	 * decided to use this one version of drawtile for all the 
	 * graphics services needed by the program.
	 */
	
	void drawtile(tile tilename, int xgrid, int ygrid)
	{
		HDC hDC, hDCMemory;
		RECT clientrect;
		int xcenterspace, ycenterspace, xoffset, yoffset, xdrawat, ydrawat;
	
		/* SETUP THE HDC FOR THIS FUNCTION */
	
		hDC = GetDC(hWnd);
	
		/* FIND THE SIZE OF THE CLIENT AREA ABOVE THE STATUS BAR */
	
		GetClientRect(hWnd, &clientrect);
		
		xcenterspace = clientrect.right
			- 2 * TDBORDER;
		ycenterspace = clientrect.bottom
			- GetSystemMetrics(SM_CYMENU)
			- 2 * TDBORDER;
	
		/* COMPUTE THE BOARD OFFSET FROM THIS INFORMATION */
		
		xoffset = (xcenterspace / 2) - (BCOLPIX / 2) + TDBORDER;
		yoffset = (ycenterspace / 2) - (BROWPIX / 2) + TDBORDER;
	
		/* FIND THE LOCATION TO DRAW THE TILE AT */
	
		xdrawat = xoffset + (xgrid * TILESIZE);
		ydrawat = yoffset + (ygrid * TILESIZE);
	
		/* DRAW THE SPECIFIED TILE AT THE CORRECT LOCATION */
		
		hDCMemory = CreateCompatibleDC(hDC);
	
		if (currentdaystate == DAY) { // LOAD THE CORRECT DAY TILE
	
			switch (tilename) {
				case FBONGRASS:  SelectObject(hDCMemory, fbongrass);   break;
				case FBONSINK:   SelectObject(hDCMemory, fbonsink);    break;
				case BOXONGRASS: SelectObject(hDCMemory, boxongrass);  break;
				case BOXONSINK:  SelectObject(hDCMemory, boxonsink);   break;
				case ROCK:       SelectObject(hDCMemory, rock);        break;
				case WALL:       SelectObject(hDCMemory, wall);        break;
				case ENEMY:      SelectObject(hDCMemory, enemy);       break;
				case GRASS:      SelectObject(hDCMemory, grass);       break;
				case SINK:       SelectObject(hDCMemory, sink);        break;
				case HEART:      SelectObject(hDCMemory, heart);       break;
				case DOORCLOSED: SelectObject(hDCMemory, doorclosed);  break;
				case DOOROPEN:   SelectObject(hDCMemory, dooropen);    break;
			}
		
		} else { // LOAD THE CORRECT NIGHT TILE
	
			switch (tilename) {
				case FBONGRASS:  SelectObject(hDCMemory, fbongrassn);  break;
				case FBONSINK:   SelectObject(hDCMemory, fbonsinkn);   break;
				case BOXONGRASS: SelectObject(hDCMemory, boxongrassn); break;
				case BOXONSINK:  SelectObject(hDCMemory, boxonsinkn);  break;
				case ROCK:       SelectObject(hDCMemory, rockn);       break;
				case WALL:       SelectObject(hDCMemory, walln);       break;
				case ENEMY:      SelectObject(hDCMemory, enemyn);      break;
				case GRASS:      SelectObject(hDCMemory, grassn);      break;
				case SINK:       SelectObject(hDCMemory, sinkn);       break;
				case HEART:      SelectObject(hDCMemory, heartn);      break;
				case DOORCLOSED: SelectObject(hDCMemory, doorclosedn); break;
				case DOOROPEN:   SelectObject(hDCMemory, dooropenn);   break;
			}
	
		}
	
		BitBlt(hDC, xdrawat, ydrawat, TILESIZE, TILESIZE, hDCMemory,
			0, 0, SRCCOPY);
		DeleteDC(hDCMemory);
	
		/* FREE THE MEMORY OF THE HDC USED BY THIS FUNCTION */
	
		ReleaseDC(hWnd, hDC);
	}
	
	/********************************************/
	/* STATUS BAR                               */
	/********************************************/
	
	/* 
	 * This function draws the status bar at the bottom of the 
	 * window, as well as the 3-D boarder around the client 
	 * rectangle.  It has two arguments, the integer number of the 
	 * current level starting a zero, and the number of remaining 
	 * lives.  This function is most frequently called from 
	 * function sin the file game.c, where these two augments are 
	 * global variables.  There is no return value; the function 
	 * simply completes its task and then returns control.
	 * 
	 * The variable hDC is used to draw graphics.  The rectangle 
	 * structure statusbarrect is used to hold the coordinates of 
	 * the rectangle in the client area that will be taken up by 
	 * the status bar.  The rectangle clientrect is used to hold 
	 * the size of the client rectangle of the current window.  The 
	 * rectangle borderrect is used to hold the size of the part of 
	 * the client area not covered by the status bar, as this is 
	 * the area that should be framed by a sunken inner 3-D border.  
	 * The rectangle statusborder is used to hold the dimensions of 
	 * the 3-D border that surrounds the text in the status bar.  
	 * The handle to a font hFont is used to draw text in the 
	 * status bar, and the string statustext is used to hold the 
	 * text that will be displayed.
	 * 
	 * This function works by first setting up hDC.  The same hDC 
	 * will be used in this function to draw both the graphics and 
	 * borders of the status bar as well as the status bar text.  
	 * The size of the client area is then found, and from this the 
	 * dimensions and position of the part of the client area that 
	 * will be used up by the status bar is calculated.  This area 
	 * is a strip on the bottom of the window with the same height 
	 * as the window menu.  The status bar rectangle is then filled 
	 * with 3-D face color.  The dimensions of the large inner 3-D 
	 * boarder are calculated, and then the command DrawEdge is 
	 * made to draw this boarder.  In a similar manner, the 
	 * location of the bounding rectangle of the boarder within the 
	 * status bar is calculated, and then that boarder is drawn.
	 * 
	 * Now all that remains is the task of preparing and drawing 
	 * the text of the status bar.  The windows string function 
	 * wsprintf is called to assemble the string of text to 
	 * display.  A 1 is added to the current level number before it 
	 * is displayed to make the levels begin at 1, not 0, as far as 
	 * the user can see.  The integer lives is displayed just as it 
	 * is.  A string is taken from the static array levelcode to 
	 * display the level code for the current level.  These three 
	 * values are found and then loaded in-between the static text 
	 * in the first argument of the call to wsprintf.
	 * 
	 * GetStockObject is called to ask Windows what the default 
	 * system font currently is.  This is the font that the status 
	 * bar text will be written in.  TextOut is then called to draw 
	 * the prepared string on the screen in that font and at the 
	 * correct location within the window.  The hDC used by this 
	 * function is freed, and the function exits.
	 */
	
	void statusbar(int currentlevel, int lives)
	{
		HDC hDC;
		RECT statusbarrect, clientrect, borderrect, statusborder;
		HFONT hFont;
		char statustext[MAXSTRINGLENGTH];
	
		/* SETUP THE HDC FOR THIS FUNCTION */
	
		hDC = GetDC(hWnd);
	
		/* FIND THE SIZE OF THE CLIENT AREA */
	
		GetClientRect(hWnd, &clientrect);
		
		/* SETUP THE RECTANGLE STRUCTURE FOR THE STATUS BAR */
	
		statusbarrect.left   = 0;
		statusbarrect.right  = clientrect.right;
		statusbarrect.top    = clientrect.bottom - GetSystemMetrics(SM_CYMENU); 
		statusbarrect.bottom = clientrect.bottom;
	
		/* DRAW THE RECTANGULAR REGION OF THE STATUS BAR */
	
		FillRect(hDC, &statusbarrect, (HBRUSH)(COLOR_3DFACE + 1));
	
		/* DRAW THE LARGE INNER 3-D BORDER FOR THE WINDOW */
	
		borderrect.left = 0;
		borderrect.right = clientrect.right;
		borderrect.top = 0;
		borderrect.bottom = clientrect.bottom - GetSystemMetrics(SM_CYMENU);
	
		DrawEdge(hDC, &borderrect,
			BDR_SUNKENOUTER | BDR_SUNKENINNER, BF_RECT);
	  
		/* DRAW THE STATUS BAR 3-D BORDER */
	
		statusborder.left = 0;
		statusborder.right = clientrect.right;
		statusborder.top = clientrect.bottom
			- GetSystemMetrics(SM_CYMENU)
			+ (GetSystemMetrics(SM_CYFRAME) / 2);
		statusborder.bottom = clientrect.bottom;
	
		DrawEdge(hDC, &statusborder, BDR_SUNKENOUTER, BF_RECT);
	
		/* ASSEMBLE THE TEXT OF THE STATUS BAR */
	
		wsprintf(statustext,
			"Level: %d    Lives Remaining: %d    Level Code: %s",
			currentlevel + 1,		  // NUMBER THE LEVELS FROM 1, NOT 0
			lives,					  // SHOW THE NUMBER OF LIVES LEFT
			levelcode[currentlevel]); // LOOK UP THE LEVEL CODE
	
		/* DRAW THE TEXT OF THE STATUS BAR */
	
		hFont = (HFONT)GetStockObject(DEFAULT_GUI_FONT);
		hFont = SelectObject(hDC, hFont);
		SetBkMode(hDC, TRANSPARENT);
	
		TextOut(hDC, GetSystemMetrics(SM_CYFRAME),
			clientrect.bottom
			- GetSystemMetrics(SM_CYMENU)
			+ GetSystemMetrics(SM_CYFRAME),
			statustext,				// SHOW THE PREPARED STRING
			lstrlen(statustext));	// FIND AND REPORT ITS LENGTH
	  
		/* FREE THE MEMORY OF THE HDC USED BY THIS FUNCTION */
	
		ReleaseDC(hWnd, hDC);
	}
	
	/********************************************/
	/* SOUND EFFECT                             */
	/********************************************/
	
	/* 
	 * This function is the interface the rest of the program uses 
	 * to play sound effects.  It takes the name of a sound to 
	 * play, returns nothing, and then plays the sound.
	 * 
	 * This function works by first checking to make sure that the 
	 * sound effects have been turned on.  If the global Boolean 
	 * variable that keeps track of this user preference indicates 
	 * that they are off, the function returns without doing 
	 * anything more.  If the sounds are on, control is then sorted 
	 * into one of 5 sections by a switch statement.  There the API 
	 * call PlaySound is made to play the appropriate sound.  
	 * Windows plays the sound in a separate execution thread, so 
	 * the program does not freeze or pause while the sound is 
	 * being played.
	 */
	
	void soundeffect(soundtitle sound)
	{
		/* IF THE SOUND EFFECTS ARE OFF, LEAVE NOW */
	
		if (!soundeffectson)
			return;
	
		/* PLAY THE REQUESTED SOUND EFFECT */
	
		if (currentdaystate == DAY) { // IT IS DAY
	
			switch (sound) {
	
				case GETHEART:
					PlaySound("GETHEART", hgInstance, SND_RESOURCE | SND_ASYNC); 
					break;
				case BOXSINK:
					PlaySound("BOXSINK", hgInstance, SND_RESOURCE | SND_ASYNC); 
					break;
				case DOOROPENS:
					PlaySound("DOOROPENS", hgInstance, SND_RESOURCE | SND_ASYNC); 
					break;
				case LEVELDONE:
					PlaySound("LEVELDONE", hgInstance, SND_RESOURCE | SND_ASYNC); 
					break;
				case KILL:
					PlaySound("KILL", hgInstance, SND_RESOURCE | SND_ASYNC); 
					break;
				case GAMEOVER:
					PlaySound("GAMEOVER", hgInstance, SND_RESOURCE | SND_ASYNC); 
					break;
	
			}
	
		} else { // IT IS NIGHT
	
			switch (sound) {
	
				case GETHEART:
					PlaySound("GETHEARTN", hgInstance, SND_RESOURCE | SND_ASYNC); 
					break;
				case BOXSINK:
					PlaySound("BOXSINKN", hgInstance, SND_RESOURCE | SND_ASYNC); 
					break;
				case DOOROPENS:
					PlaySound("DOOROPENSN", hgInstance, SND_RESOURCE | SND_ASYNC); 
					break;
				case LEVELDONE:
					PlaySound("LEVELDONEN", hgInstance, SND_RESOURCE | SND_ASYNC); 
					break;
				case KILL:
					PlaySound("KILLN", hgInstance, SND_RESOURCE | SND_ASYNC); 
					break;
				case GAMEOVER:
					PlaySound("GAMEOVERN", hgInstance, SND_RESOURCE | SND_ASYNC); 
					break;
	
			}
	
		}
	}
	
	/********************************************/
	/* JUKEBOX                                  */
	/********************************************/
	
	/* 
	 * This function is the interface the rest of the program uses 
	 * to play music.  It takes a command of type musiccommand, and 
	 * returns nothing.
	 * 
	 * The integer variable songnum is used to select which song 
	 * should be played when music cycling is turned on.
	 * 
	 * This function works by using a switch statement to sort the 
	 * commands that can be given to the function.  If the argument 
	 * command is STOP, the helper function stopmidi is called to 
	 * carry out this task.  If the command is PLAY, the music 
	 * played according to the current music option, the current 
	 * level, and the current day state.  Another switch statement 
	 * sorts control between these cases as follows:  If the 
	 * current music option is NOMUSIC, a recursive call 
	 * jukebox(STOP) is made to stop all music that might have been 
	 * playing, and the function is done.
	 * 
	 * If the current music option is CYCLEMUSIC, a music-cycling 
	 * algorithm is used to choose what music to play based on the 
	 * current level and the current day state.  The music should 
	 * be cycled as follows:  All the songs are divided into 3 
	 * groups, a set of day music, and a set of night music.  In 
	 * the 0th level, the first song of the appropriate set should 
	 * play.  In the 1st level, the next song of the same set 
	 * should play.  When all the songs in the set have been 
	 * played, the list should loop back so that the next level 
	 * plays the first song again.  With this system, each numbered 
	 * level has associated with it one day song and one night 
	 * song, and no other songs should be played.  This algorithm 
	 * is put into the code of this section of the function as 
	 * follows:  two if statements first sort control into a day 
	 * case and a night case.  The variable songnum is then set to 
	 * be the iunteger remainder when the current level is divided 
	 * by the number of day songs in the set of day songs.  This 
	 * makes songnum an integer between 0 and DAYSONGS - 1, 
	 * inclusive, depending on the current level.  Based on the 
	 * value of songnum, a call to playsong is then made to play 
	 * the appropriate song.  An identical process finds the 
	 * correct song if it is night.
	 * 
	 * If the current music option is not CYCLEMUSIC, the case 
	 * described above is never entered, and control moves directly 
	 * to the row of individual song cases.  For instance, if 
	 * currentmusicoption = AXLE, the user has indicated a desire 
	 * to only and always hear the song "Axle F."  Thus, when the 
	 * call jukebox(PLAY) is made, control will enter the case AXLE 
	 * in this function, and the call from here of playsong(AXLE) 
	 * will play the desired music.
	 * 
	 * If the jukebox receives the command WON, the program should 
	 * play the victory fanfare no matter what the current music 
	 * selection is, even if the music has been turned off.  It 
	 * does this by passing the song name THRONE to the function 
	 * playsong.
	 * 
	 * This function needs to know the current level number to 
	 * correctly pick the right music if the user has activated 
	 * automatic music cycling.  For this reason, the global 
	 * integer variable currentlevel is brought in to this file 
	 * from game.c.
	 */
	
	void jukebox(musiccommand command)
	{
		int songnum;
	
		switch (command) {
	
			case STOP: // IMMEDIATELY STOP THE MIDI FILE THAT IS PLAYING
		
				stopmidi();
				break;
	
			case PLAY: // BEGIN MUSIC ACCORDING TO CURRENT MUSIC OPTION
	
				switch (currentmusicoption) {
	
					case NOMUSIC:
		
						jukebox(STOP);
						break;
	
					case CYCLEMUSIC:
		
						if (currentdaystate == DAY) {
			
							songnum = currentlevel % DAYSONGS;
			
							switch (songnum) {
								case 0: playsong(ODYSSEY);  break;
								case 1: playsong(AXLE);     break;
								case 2: playsong(BOND);     break;
								case 3: playsong(ISTANBUL); break;
								case 4: playsong(MERIDIAN); break;
								case 5: playsong(MISSION);  break;
								case 6: playsong(PARADISE); break;
								case 7: playsong(PEANUTS);  break;
								case 8: playsong(POPCORN);  break;
								case 9: playsong(WIPEOUT);  break;
							}
			
						}
			
						if (currentdaystate == NIGHT) {
			
							songnum = currentlevel % NIGHTSONGS;
			
							switch (songnum) {
								case 0: playsong(BOHEMIAN); break;
								case 1: playsong(CANNON);   break;
								case 2: playsong(CHILDREN); break;
								case 3: playsong(DEMON);    break;
								case 4: playsong(LION);     break;
								case 5: playsong(MAD);      break;
							}
			
						}
					
						break;
	
					case ODYSSEY:  playsong(ODYSSEY);  break;
					case AXLE:     playsong(AXLE);     break;
					case BOND:     playsong(BOND);     break;
					case ISTANBUL: playsong(ISTANBUL); break;
					case MERIDIAN: playsong(MERIDIAN); break;
					case MISSION:  playsong(MISSION);  break;
					case PARADISE: playsong(PARADISE); break;
					case PEANUTS:  playsong(PEANUTS);  break;
					case POPCORN:  playsong(POPCORN);  break;
					case WIPEOUT:  playsong(WIPEOUT);  break;
					case BOHEMIAN: playsong(BOHEMIAN); break;
					case CANNON:   playsong(CANNON);   break;
					case CHILDREN: playsong(CHILDREN); break;
					case DEMON:    playsong(DEMON);    break;
					case LION:     playsong(LION);     break;
					case MAD:      playsong(MAD);      break;
	
				}
	
				break;
	
			case WON: // PLAY THE ENDING FANFARE
	
				playsong(THRONE);
				break;
	
		}
	}
	
	/********************************************/
	/* PLAY SONG                                */
	/********************************************/
	
	/* 
	 * This function has the job of playing a song.  Its one 
	 * argument is the title of the song to play, a label of 
	 * enumeration type music.  There is no return value.
	 * 
	 * This function works by first calling jukebox(STOP) to make 
	 * sure that anything that was playing is stopped before the 
	 * new song begins.  A switch statement then makes the correct 
	 * call to the function playmidi based on the song name that 
	 * the function was given.  The function playmidi takes the 
	 * filename of an external file to play.  The MIDI files that 
	 * come with the executable file of this program and which must 
	 * be placed in the same folder for the music to work properly 
	 * have somewhat cryptic filenames to keep users from playing, 
	 * copying, moving, or deleting them.  This is why the third 
	 * song filename is "FBDAT03.FBD" and not just "BOND.MID".
	 */
	
	void playsong(music songname)
	{
		/* STOP PLAYING ALL MUSIC */
	
		jukebox(STOP);
	
		/* PLAY THE REQUESTED SONG ONCE */
	
		switch (songname) {
	
			case ODYSSEY:  playmidi(hWnd, "FBDAT01.FBD"); break;
			case AXLE:     playmidi(hWnd, "FBDAT02.FBD"); break;
			case BOND:     playmidi(hWnd, "FBDAT03.FBD"); break;
			case ISTANBUL: playmidi(hWnd, "FBDAT04.FBD"); break;
			case MERIDIAN: playmidi(hWnd, "FBDAT05.FBD"); break;
			case MISSION:  playmidi(hWnd, "FBDAT06.FBD"); break;
			case PARADISE: playmidi(hWnd, "FBDAT07.FBD"); break;
			case PEANUTS:  playmidi(hWnd, "FBDAT08.FBD"); break;
			case POPCORN:  playmidi(hWnd, "FBDAT09.FBD"); break;
			case WIPEOUT:  playmidi(hWnd, "FBDAT10.FBD"); break;
			case BOHEMIAN: playmidi(hWnd, "FBDAT11.FBD"); break;
			case CANNON:   playmidi(hWnd, "FBDAT12.FBD"); break;
			case CHILDREN: playmidi(hWnd, "FBDAT13.FBD"); break;
			case DEMON:    playmidi(hWnd, "FBDAT14.FBD"); break;
			case LION:     playmidi(hWnd, "FBDAT15.FBD"); break;
			case MAD:      playmidi(hWnd, "FBDAT16.FBD"); break;
			case THRONE:   playmidi(hWnd, "FBDAT17.FBD"); break;
	
		}
	}
	
	/********************************************/
	/* PLAY MIDI                                */
	/********************************************/
	
	/* 
	 * This function has the job of making the API calls necessary 
	 * to actually play the indicated MIDI file.  It takes a handle 
	 * to the main window as well as the filename of the music file 
	 * to play.
	 * 
	 * The process of playing a MIDI file is much more complicated 
	 * than playing a WAV sound.  Instead of simply making a call 
	 * to the API function PlaySound, a MIDI sequencer device must 
	 * be found, opened, and checked, and then used to play the 
	 * desired file.
	 * 
	 * I did not write this function, rather I copied it in from an 
	 * article I found on the Microsoft Development Library CD-ROM.  
	 * The function seems to work without error, although I am not 
	 * sure of exactly how it works.
	 */
	
	DWORD playmidi(HWND hWndNotify, LPSTR lpszMIDIFileName)
	{
	    UINT wDeviceID;
	    DWORD dwReturn;
	    MCI_OPEN_PARMS mciOpenParms;
	    MCI_PLAY_PARMS mciPlayParms;
	    MCI_STATUS_PARMS mciStatusParms;
	    MCI_SEQ_SET_PARMS mciSeqSetParms;
	
	    /* OPEN THE DEVICE AND FILE */
	
	    mciOpenParms.lpstrDeviceType = "sequencer";
	    mciOpenParms.lpstrElementName = lpszMIDIFileName;
	
	    if (dwReturn = mciSendCommand(NULL, MCI_OPEN,
	        MCI_OPEN_TYPE | MCI_OPEN_ELEMENT,
	        (DWORD)(LPVOID) &mciOpenParms)) {
	
	        /* FAILED TO OPEN DEVICE, REPORT ERROR */
	
	    	return (dwReturn);
	    
		}
	
	    /* THE DEVICE OPENED SUCCESSFULLY, GET THE DEVICE ID */
	    
		wDeviceID = mciOpenParms.wDeviceID;
	
	    /* CHECK IF THE OUTPUT PORT IS THE MIDI MAPPER */
	    
		mciStatusParms.dwItem = MCI_SEQ_STATUS_PORT;
	    
		if (dwReturn = mciSendCommand(wDeviceID, MCI_STATUS, 
	        MCI_STATUS_ITEM, (DWORD)(LPVOID) &mciStatusParms)) {
	
	        mciSendCommand(wDeviceID, MCI_CLOSE, 0, NULL);
	        return (dwReturn);
	
	    }
	
	    /* BEGIN PLAYBACK */
	
	    mciPlayParms.dwCallback = (DWORD) hWndNotify;
	
	    if (dwReturn = mciSendCommand(wDeviceID, MCI_PLAY, MCI_NOTIFY, 
	        (DWORD)(LPVOID) &mciPlayParms)) {
	
	        mciSendCommand(wDeviceID, MCI_CLOSE, 0, NULL);
	        return (dwReturn);
	
	    }
	
	    return (0L);
	}
	
	/********************************************/
	/* STOP MIDI                                */
	/********************************************/
	
	/* 
	 * This function has the job of stopping all the MIDI music 
	 * that might be playing.  It has no arguments or return 
	 * values.
	 * 
	 * This function works by making an API call to close all MCI 
	 * devices currently in use by this application.  This includes 
	 * all devices open playing MIDI.  Although the function does 
	 * successfully quickly stop any music that is playing without 
	 * bothering the sound effects or graphics capabilities of the 
	 * program, this is probably not the best way to stop a 
	 * currently running MIDI song.
	 */
	
	void stopmidi()
	{
		mciSendCommand(MCI_ALL_DEVICE_ID, MCI_CLOSE, MCI_WAIT, NULL);
	}
	
	/********************************************/
	/* PREPARE OPTIONS MENU                     */
	/********************************************/
	
	/* 
	 * When the user clicks on the Options menu in the main 
	 * application window, the program gets a message that the menu 
	 * is about to be displayed.  Control then enters this 
	 * function, which has the task of checking or unchecking the 
	 * items on the menu to reflect the current user preference 
	 * settings.  This serves as a means of feedback to the user, 
	 * as he or she can check on the current settings simply by 
	 * displaying the menu and then not making a new selection.  
	 * There are no arguments or return values.
	 * 
	 * The variable hMenu is a handle to the menu on top of the 
	 * main application window.
	 * 
	 * This function works by first using the API call GetMenu to 
	 * initiaze hMenu.  Based on the current state of the global 
	 * variable soundeffectson, the function then either calls 
	 * CheckMenuItem to check or uncheck the Sound Effects item on 
	 * the Options menu.  The function then uses the current value 
	 * of the global preference setting currentmusicoption in a 
	 * long list of if else statements to uncheck all of the music 
	 * options except for the selected one, which is checked.  Each 
	 * menu item is handled independently and as part of one pass, 
	 * so the correct menu item is checked on in one command, and 
	 * does not blink on after a moment of initialization.
	 */
	
	void prepareoptionsmenu()
	{
		HMENU hMenu;
	
		/* GET A HANDLE TO THE MENU ON THE MAIN WINDOW */
	
		hMenu = GetMenu(hWnd);
	
		/* CHECK OR UNCHECK THE SOUND EFFECTS MENU OPTION */
	
		if (soundeffectson)
			CheckMenuItem(hMenu, IDM_SOUNDEFFECTS, MF_CHECKED);
		else
			CheckMenuItem(hMenu, IDM_SOUNDEFFECTS, MF_UNCHECKED);
	
		/* CHECK OR UNCHECK ALL THE MUSIC OPTIONS */
	
		if (currentmusicoption == NOMUSIC)
			CheckMenuItem(hMenu, IDM_NOMUSIC, MF_CHECKED);
		else
			CheckMenuItem(hMenu, IDM_NOMUSIC, MF_UNCHECKED);
	
		if (currentmusicoption == CYCLEMUSIC)
			CheckMenuItem(hMenu, IDM_CYCLEMUSIC, MF_CHECKED);
		else
			CheckMenuItem(hMenu, IDM_CYCLEMUSIC, MF_UNCHECKED);
	
		if (currentmusicoption == ODYSSEY)
			CheckMenuItem(hMenu, IDM_ODYSSEY, MF_CHECKED);
		else
			CheckMenuItem(hMenu, IDM_ODYSSEY, MF_UNCHECKED);
	
		if (currentmusicoption == AXLE)
			CheckMenuItem(hMenu, IDM_AXLE, MF_CHECKED);
		else
			CheckMenuItem(hMenu, IDM_AXLE, MF_UNCHECKED);
	
		if (currentmusicoption == BOND)
			CheckMenuItem(hMenu, IDM_BOND, MF_CHECKED);
		else
			CheckMenuItem(hMenu, IDM_BOND, MF_UNCHECKED);
	
		if (currentmusicoption == ISTANBUL)
			CheckMenuItem(hMenu, IDM_ISTANBUL, MF_CHECKED);
		else
			CheckMenuItem(hMenu, IDM_ISTANBUL, MF_UNCHECKED);
	
		if (currentmusicoption == MERIDIAN)
			CheckMenuItem(hMenu, IDM_MERIDIAN, MF_CHECKED);
		else
			CheckMenuItem(hMenu, IDM_MERIDIAN, MF_UNCHECKED);
	
		if (currentmusicoption == MISSION)
			CheckMenuItem(hMenu, IDM_MISSION, MF_CHECKED);
		else
			CheckMenuItem(hMenu, IDM_MISSION, MF_UNCHECKED);
	
		if (currentmusicoption == PARADISE)
			CheckMenuItem(hMenu, IDM_PARADISE, MF_CHECKED);
		else
			CheckMenuItem(hMenu, IDM_PARADISE, MF_UNCHECKED);
	
		if (currentmusicoption == PEANUTS)
			CheckMenuItem(hMenu, IDM_PEANUTS, MF_CHECKED);
		else
			CheckMenuItem(hMenu, IDM_PEANUTS, MF_UNCHECKED);
	
		if (currentmusicoption == POPCORN)
			CheckMenuItem(hMenu, IDM_POPCORN, MF_CHECKED);
		else
			CheckMenuItem(hMenu, IDM_POPCORN, MF_UNCHECKED);
	
		if (currentmusicoption == WIPEOUT)
			CheckMenuItem(hMenu, IDM_WIPEOUT, MF_CHECKED);
		else
			CheckMenuItem(hMenu, IDM_WIPEOUT, MF_UNCHECKED);
	
		if (currentmusicoption == BOHEMIAN)
			CheckMenuItem(hMenu, IDM_BOHEMIAN, MF_CHECKED);
		else
			CheckMenuItem(hMenu, IDM_BOHEMIAN, MF_UNCHECKED);
	
		if (currentmusicoption == CANNON)
			CheckMenuItem(hMenu, IDM_CANNON, MF_CHECKED);
		else
			CheckMenuItem(hMenu, IDM_CANNON, MF_UNCHECKED);
	
		if (currentmusicoption == CHILDREN)
			CheckMenuItem(hMenu, IDM_CHILDREN, MF_CHECKED);
		else
			CheckMenuItem(hMenu, IDM_CHILDREN, MF_UNCHECKED);
	
		if (currentmusicoption == DEMON)
			CheckMenuItem(hMenu, IDM_DEMON, MF_CHECKED);
		else
			CheckMenuItem(hMenu, IDM_DEMON, MF_UNCHECKED);
	
		if (currentmusicoption == LION)
			CheckMenuItem(hMenu, IDM_LION, MF_CHECKED);
		else
			CheckMenuItem(hMenu, IDM_LION, MF_UNCHECKED);
	
		if (currentmusicoption == MAD)
			CheckMenuItem(hMenu, IDM_MAD, MF_CHECKED);
		else
			CheckMenuItem(hMenu, IDM_MAD, MF_UNCHECKED);
	}
	
	/********************************************/
	/* MENU NEW GAME                            */
	/********************************************/
	 
	/* 
	 * This function is called when the user clicks on the menu 
	 * Game, New Game.  It has the job of making sure the user 
	 * wants to start a new game, and then starting one.  There are 
	 * no arguments or a return value.
	 * 
	 * The integer variable response is used to hold the response 
	 * the user gives to clear the confirmation message box that is 
	 * displayed by this function.
	 * 
	 * This function works by making the API call MessageBox to 
	 * display a dialog box that asks the user if he or she would 
	 * really like to restart the game from the first level.  When 
	 * the user clears this dialog box, control returns from 
	 * Windows to this function, and the identification label of 
	 * the button that was used to clear the box is stored in the 
	 * variable response.  An if statement then checks to see if 
	 * the user clicked OK.  If he or she did, control is passed to 
	 * the function initialize to restart the game at the initial 
	 * starting level.  Calls to redraw the board and restart the 
	 * music are made from the initialize function.
	 * 
	 * If the user instead cleared the box by pressing Cancel, 
	 * control will not enter the if statement and this function 
	 * will return to MainWindowProcedure without disturbing the 
	 * currently running game at all.
	 */
	
	void menunewgame()
	{
		int response;
	
		response = MessageBox(hWnd, NEWGAMETEXT, "New Game", MB_OKCANCEL);
	
		if (response == IDOK) // THE USER PRESSED OK TO CLEAR THE BOX
			initialize(INITIALSTARTINGLEVEL);
	}
	
	/********************************************/
	/* MENU GIVE UP                            */
	/********************************************/
	 
	/* 
	 * This function is called when the user clicks on the menu 
	 * Game, Give Up.  The user must click on this menu item if he 
	 * or she has accidentally made a level impossible to solve and 
	 * impossible to perish within.  This function has the job of 
	 * restarting the current level as though the Furball has died.  
	 * There are no arguments or a return value.
	 * 
	 * This function works by making one call to the game function 
	 * killfurball.  Control is immediately transferred there, 
	 * where the tasks of playing the kill sound effect and 
	 * resetting the level are carried out.
	 */
	
	void menugiveup()
	{
		killfurball();
	}
	
	/********************************************/
	/* MENU ENTER LEVEL CODE                    */
	/********************************************/
	
	/* 
	 * This function is called when the user clicks on the menu 
	 * Game, Enter Level Code....  The function has the job of 
	 * displaying a dialog box to get a level code from the user.  
	 * There are no arguments or a return value.
	 * 
	 * This function works by telling windows to display the dialog 
	 * box IDD_ENTERCODE, which is loaded as a resource.  When 
	 * control is returned from the dialog, the function ends and 
	 * control returns to MainWindowProcedure.
	 * 
	 * I was not able to figure out how to get the dialog procedure 
	 * function that goes with this dialog box to pass back the 
	 * entered string to this function, and so all the code that 
	 * checks the entered string and acts on its validity is 
	 * located within the dialog procedure.
	 */
	
	void menuenterlevelcode()
	{
		DialogBox(hgInstance, MAKEINTRESOURCE(IDD_ENTERCODE), hWnd,
			(DLGPROC)dplevelcode);
	}
	
	/********************************************/
	/* DIALOG PROCEDURE LEVEL CODE              */
	/********************************************/
	
	/* 
	 * This function is the dialog procedure for the Enter Level 
	 * Code dialog box.  Its arguments and return value are 
	 * specified by Windows.
	 * 
	 * The variable inputstring is the string that the user gives 
	 * as a level code.  The integer codevalid is a flag that is 
	 * used to keep track of whether the string that the user 
	 * entered is a valid level code or not.
	 * 
	 * This function works by sorting messages to the dialog box in 
	 * a miniature version of the process found in 
	 * MainWindowProcedure.  If the user presses OK, the text 
	 * string that was entered is taken in, and then passed to the 
	 * helper function lookuplevelcode for analysis.  The function 
	 * lookuplevelcode returns 1 if the code was found to be valid, 
	 * or 0 if it was not.  Back in this function, if the code was 
	 * valid, the job of this dialog is done, and an API call is 
	 * made to clear the dialog from the screen.  If the code was 
	 * invalid the dialog box remains, the focus is reset to the 
	 * text box, and the user is given another chance to enter a 
	 * correct code.  If the user presses Cancel, the dialog is 
	 * simply immediately cleared.
	 */
	
	BOOL CALLBACK dplevelcode(HWND hDlg, UINT message, WPARAM wParam,
							  LPARAM lParam)
	{
		char inputstring[MAXSTRINGLENGTH];
		int codevalid;
	
		switch (message) {
	
			case WM_INITDIALOG: // THE DIALOG IS ABOUT TO BE DISPLAYED
	
				/* MAKE THE TEXT BOX BLANK */
	
				SetDlgItemText(hDlg, IDC_LEVELCODE,	"");
				
				/* SET THE FOCUS TO THE TEXT BOX */
				
				SetFocus(GetDlgItem(hDlg, IDC_LEVELCODE));
				return (FALSE);
				
			case WM_COMMAND:
	
				switch (LOWORD(wParam)) {
	
					case IDOK: // THE USER PRESSED OK
	
						/* GET THE STRING THAT WAS ENTERED */
	
						GetDlgItemText(hDlg, IDC_LEVELCODE,	inputstring,
							MAXSTRINGLENGTH);
						
						/* PROCESS THE ENTERED STRING */
	
						codevalid = lookuplevelcode(inputstring);
	
						/* IF THE CODE WAS VALID, CLOSE THE DIALOG */
	
						if (codevalid)
							EndDialog(hDlg, TRUE);
	
						/* CODE INVALID, KEEP DIALOG, RESET FOCUS */
				
						SetFocus(GetDlgItem(hDlg, IDC_LEVELCODE));
	
						return (TRUE);
						break;
					
					case IDCANCEL:
						
						/* CLOSE THE DIALOG */
	
						EndDialog(hDlg, FALSE);
						return (FALSE);
						break;
				
				}
				
				break;
				
			default:
				
				return (FALSE);
	
		}
	
		return (FALSE);
	}
	
	/********************************************/
	/* LOOK UP LEVEL CODE                       */
	/********************************************/
	
	/* 
	 * This function has the job of taking a string that the user 
	 * entered, determining if it is a valid level code, moving 
	 * game play to the correct level if the code was valid, and 
	 * then reporting the results of the operation back to the 
	 * calling function.  The argument string inputstring is the 
	 * string that the user has given to the program.  The function 
	 * returns 1 if the level was found and loaded, or 0 if the 
	 * code was not valid.
	 * 
	 * The variable levelscan is used to scan through all the 
	 * levels, from 0 to NUMLEVELS - 1.
	 * 
	 * This function works by using a for loop and the windows 
	 * library function lstrcmp to try to compare the string that 
	 * the user entered with the valid level code strings in the 
	 * static array levelcode.  The index variable levelscan is 
	 * used to page through the array.  If a perfect match is 
	 * found, control is passed to initialize, where the desired 
	 * level is initialized, the new music is started, and then 
	 * control is returned to this function.  This is all done with 
	 * the Enter Level Code dialog box still displayed.  This 
	 * function then returns the value 1 to indicate that the 
	 * process of jumping to a new level was successful.
	 * 
	 * If the for loop completes without finding a match, a message 
	 * box is displayed that tells the user that the level code was 
	 * not valid and encourages him or her to try again.  The 
	 * function then returns to dpenterlevelcode with the return 
	 * value of 0, indicating that the level code was not valid.
	 */
	
	int lookuplevelcode(char *inputstring)
	{
		int levelscan;
	
		for (levelscan = 0; levelscan <= (NUMLEVELS - 1); levelscan++) {
	
			/* COMPARE THE INPUT STRING WITH THE TABLE OF CODES */
	
			if (lstrcmp(inputstring, levelcode[levelscan]) == 0) {
	
				/* MATCH FOUND, GO TO THE DESIRED LEVEL, REPORT SUCCESS */
				
				initialize(levelscan);
				return (1);
				
			}
	
		}
	
		/* THE ENTERED STRING COULD NOT BE MATCHED TO A CODE */
		
		MessageBox(hWnd, INVALIDCODETEXT, "Invalid Level Code", MB_OK);
		return (0);
	}
	
	/********************************************/
	/* MENU EXIT                                */
	/********************************************/
	
	/* 
	 * This function is called when the user clicks on the menu 
	 * Game, Exit.  It has the job of immediately closing the 
	 * application.  There are no arguments or a return value
	 * 
	 * This function works by making the API call 
	 * DestroyWindow(hWnd), where hWnd is the handle to the main 
	 * application window of the program.
	 */
	
	void menuexit()
	{
		DestroyWindow(hWnd);
	}
	
	/********************************************/
	/* MENU SOUND EFFECTS                       */
	/********************************************/
	
	/* 
	 * This function is called when the user clicks on the menu 
	 * Options, Sound Effects.  It has the job of turning off the 
	 * sound effects if they are currently on, or turning on the 
	 * sound effects if they are currently off.  There are no 
	 * arguments or a return value.
	 * 
	 * The function works by sorting control into two cases.  If 
	 * the global preference setting variable soundeffecton is 
	 * TRUE, the menu item must have been checked and this message 
	 * indicates that the user would like to switch the sound 
	 * effects off.  The function writeregvar is called to make 
	 * this change in the Registry as well as the mirroring global 
	 * variable soundeffectson.  Otherwise, the sound effects need 
	 * to be turned on, and a similar call to writeregvar completes 
	 * this task.
	 */
	
	void menusoundeffects()
	{
		/* TOGGLE THE SOUND EFFECTS */
	
		if (soundeffectson)
			writeregvar("RegSound", &soundeffectson, (int)FALSE);
		else
			writeregvar("RegSound", &soundeffectson, (int)TRUE);
	}
	
	/********************************************/
	/* MENU QUICK HELP                          */
	/********************************************/
	
	/* 
	 * This function is called when the user clicks on the menu 
	 * Help, Quick Help.  The function has the job of displaying 
	 * the Quick Help dialog box.  There are no arguments or a 
	 * return value.
	 * 
	 * This function works by telling windows to display the dialog 
	 * box IDD_QUICKHELP, which is loaded as a resource.  When 
	 * control is returned from the dialog, the function ends and 
	 * control returns to MainWindowProcedure.
	 */
	
	void menuquickhelp()
	{
		DialogBox(hgInstance, MAKEINTRESOURCE(IDD_QUICKHELP), hWnd,
			(DLGPROC)dpquickhelp);
	}
	
	/********************************************/
	/* DIALOG PROCEDURE QUICK HELP              */
	/********************************************/
	
	/* 
	 * This function is the dialog procedure for the Quick Help 
	 * dialog box.  Its arguments and return value are specified by 
	 * Windows.
	 * 
	 * This function works by sorting messages to the dialog box in 
	 * a miniature version of the process found in 
	 * MainWindowProcedure.  Windows sends the dialog box a 
	 * WM_INITDIALOG message just before it is displayed, giving 
	 * this function a chance to check or uncheck the startuphelp 
	 * button in the dialog based on the current state of this user 
	 * preference.  The command return (TRUE) tells windows to set 
	 * the focus of the dialog to the OK button.
	 * 
	 * The dialog can be cleared either by pressing OK, or Cancel.  
	 * If the user pressed OK, this function takes the information 
	 * about whether the checkbox was checked and writes it to the 
	 * registry.  If the user presses Cancel, the dialog simply 
	 * closes.
	 */
	
	BOOL CALLBACK dpquickhelp(HWND hDlg, UINT message,
							  WPARAM wParam, LPARAM lParam)
	{
		switch (message) {
	
			case WM_INITDIALOG: // THE DIALOG IS ABOUT TO BE DISPLAYED
	
				/* CHECK THE SHOW AGAIN BOX APPROPRIATELY */
	
				if (startuphelp)
					CheckDlgButton(hDlg, IDC_SHOWAGAIN, 1);
				else
					CheckDlgButton(hDlg, IDC_SHOWAGAIN, 0);
	
				/* TELL WINDOWS TO SET FOCUS TO OK BUTTON */
	
				return (TRUE);
	
			case WM_COMMAND: // THE DIALOG WAS CLEARED BY THE USER
	
				switch(LOWORD(wParam)) {
	
					case IDOK: // THE USER PRESSED OK
	
						/* TAKE ANSWER FROM DIALOG BOX */
	
						if (IsDlgButtonChecked(hDlg, IDC_SHOWAGAIN))
							writeregvar("RegHelp", &startuphelp, (int)TRUE);
						else
							writeregvar("RegHelp", &startuphelp, (int)FALSE);
	
						EndDialog(hDlg, TRUE);
						return (TRUE); 
						break;
	
					case IDCANCEL: // THE USER PRESSED CANCEL
	
						/* CHANGE NOTHING */
	
						EndDialog(hDlg,FALSE);
						return (TRUE);
						break;
	
				}
	
				break;
	
			default:
			
				return (FALSE);
	
		}
	}
	
	/********************************************/
	/* MENU ABOUT                               */
	/********************************************/
	
	/* 
	 * This function is called when the user clicks on the menu 
	 * Help, About.  The function has the job of displaying the 
	 * About Furball’s Adventures dialog box.  There are no 
	 * arguments or a return value.
	 * 
	 * This function works by telling windows to display the dialog 
	 * box IDD_ABOUT, which is loaded as a resource.  When control 
	 * is returned from the dialog, the function ends and control 
	 * returns to MainWindowProcedure.
	 */
	
	void menuabout()
	{
		DialogBox(hgInstance, MAKEINTRESOURCE(IDD_ABOUT), hWnd,
			(DLGPROC)dpabout);
	}
	
	/********************************************/
	/* DIALOG PROCEDURE ABOUT                   */
	/********************************************/
	
	/* 
	 * This function is the dialog procedure for the About 
	 * Furball’s Adventures dialog box.  Its arguments and return 
	 * value are specified by Windows.
	 * 
	 * The only reason About Furball’s Adventures is a full-blown 
	 * dialog box and not just a message box is that it needs to 
	 * contain positioned text as well as a graphic.  The dialog 
	 * procedure is very simple, as the only way to clear the box 
	 * is by clicking on the lone OK button.  When this happens, 
	 * the function clears the dialog and returns control to 
	 * MainWindowProcedure.
	 */
	
	BOOL CALLBACK dpabout(HWND hDlg, UINT message, 
						  WPARAM wParam, LPARAM lParam)
	{
		switch (message) {
	
			case WM_INITDIALOG: // THE DIALOG IS ABOUT TO BE DISPLAYED
	
				return (TRUE);
	
			case WM_COMMAND: // THE DIALOG WAS CLEARED BY THE USER
	
				EndDialog(hDlg,FALSE);
				return (TRUE);
	
			default:
			
				return (FALSE);
	
		}
	}
	
	/********************************************/
	/* GAME OVER                                */
	/********************************************/
	
	/* 
	 * This function is called when the Furball has been killed and 
	 * no replacement Furball’s remain.  It has the task of 
	 * stopping the music, telling the user the bad news, and then 
	 * starting the game from the first level.  There are no 
	 * arguments or a return value.
	 * 
	 * This function works by first calling jukebox(STOP) to stop 
	 * any music that might have been playing.  The API call 
	 * MessageBox is then made to display the Game Over message 
	 * box.  Once the user has cleared this box by pressing the OK 
	 * button there, the function initialize is given control to 
	 * setup the game from the very start.
	 */
	
	void gameover()
	{
		/* STOP THE MUSIC */
	
		jukebox(STOP);
	
		/* CALL A SOUND EFFECT */
	
		soundeffect(GAMEOVER);
	
		/* DISPLAY A DIALOG BOX */
	
		MessageBox(hWnd, GAMEOVERTEXT, "Game Over", MB_OK);
	
		/* RESTART THE GAME FROM THE FIRST LEVEL */
	
		initialize(INITIALSTARTINGLEVEL);
	}
	
	/********************************************/
	/* GAME WON                                 */
	/********************************************/
	
	/* 
	 * This function is called when the final level has been 
	 * completed.  It has the task of playing a MIDI file, 
	 * displaying a congratulatory dialog box, and then starting 
	 * the game from the first level.  There are no arguments or a 
	 * return value.
	 * 
	 * This function works by first calling jukebox(WON) to stop 
	 * any music that might have been playing and begin playing 
	 * THRONE, the victory fanfare.  The music starts and the API 
	 * call DialogBox is made to display the You Win! dialog.  Once 
	 * the user has cleared this box by pressing the Restart Game 
	 * button there, the music is stopped and the function 
	 * initialize is given control to setup the game from the very 
	 * start.
	 */
	
	void gamewon()
	{
		/* DISPLAY A DIALOG BOX AND PLAY THE VICTORY FANFARE */
	
		jukebox(WON);
	
		DialogBox(hgInstance, MAKEINTRESOURCE(IDD_WON), hWnd,
			(DLGPROC)dpgamewon);
	
		jukebox(STOP);
	
		/* RESTART THE GAME FROM THE FIRST LEVEL */
	
		initialize(INITIALSTARTINGLEVEL);
	}
	
	/********************************************/
	/* DIALOG PROCEDURE GAME WON                */
	/********************************************/
	
	/* 
	 * This function is the dialog procedure for the You Win! 
	 * dialog box.  Its arguments and return value are specified by 
	 * Windows.
	 * 
	 * The only reason You Win! is a full-blown dialog box and not 
	 * just a message box is that it needs to contain a graphic and 
	 * a different text string on the OK button than just "OK."  
	 * The dialog procedure is very simple, as the only way to 
	 * clear the box is by clicking on the lone OK button.  When 
	 * this happens, the function clears the dialog and returns 
	 * control to gamewon.
	 */
	
	BOOL CALLBACK dpgamewon(HWND hDlg, UINT message, 
							WPARAM wParam, LPARAM lParam)
	{
		switch (message) {
	
			case WM_INITDIALOG: // THE DIALOG IS ABOUT TO BE DISPLAYED
	
				return (TRUE);
	
			case WM_COMMAND: // THE DIALOG WAS CLEARED BY THE USER
	
				EndDialog(hDlg, FALSE);
				return (TRUE);
	
			default:
			
				return (FALSE);
	
		}
	}
	
	/********************************************/
	/* SETUP REGISTRY VARIABLE                  */
	/********************************************/
	
	/* 
	 * This function has the job of setting up a key in the Windows 
	 * System Registry for the application, writing an integer 
	 * value to a new or existing data label in that key, and then 
	 * setting a mirroring global memory variable to reflect the 
	 * same information.  If the function detects that the registry 
	 * has already been setup, it simply opens the application’s 
	 * key and then reads a value into memory.  There are three 
	 * arguments.  The string regvarname is the name of the data 
	 * label that should be used in the Registry.  The integer 
	 * pointer memoryvar points at the global memory variable that 
	 * mirrors the registry data with name regvarname.  The integer 
	 * defaultvalue is the default value that the Registry and 
	 * memory variables should be set to if there is no previously 
	 * set value already stored in the Registry.  The function has 
	 * no return value.
	 * 
	 * The variable currentkey is a handle to the currently open 
	 * Registry key.  The variables disposition and result are used 
	 * by the API calls that communicate with the Registry, and the 
	 * dwords double, size, and type are used to pass data from 
	 * memory to the registry and back.
	 * 
	 * This function first makes the API call RegCreateKeyEx, which 
	 * opens the registry, looks for the key for this application, 
	 * and opens it.  If the application key cannot be found, the 
	 * registry was either damaged, edited, or this is simply the 
	 * first time the program has been run on this computer.  In 
	 * that case, RegCreateKeyEx automatically creates a blank key 
	 * in the registry for this application.  Now we know that the 
	 * registry key is open and without errors, but the data value 
	 * we are interested in within that key may still be damaged or 
	 * missing.
	 * 
	 * Next, the API call RegQueryValueEx is made to read the value 
	 * from the registry specified in the function argument 
	 * regvarname.  The result of this call is stored in the 
	 * variable result.  If the read operation was successful, the 
	 * registry has been properly set up for this piece of 
	 * information, and the previous setting has been read.  All 
	 * that must be done is to copy the retrieved value into the 
	 * mirroring memory global variable.
	 * 
	 * If the read operation was not successful, the registry has 
	 * been damaged or not yet set up with this value.  In that 
	 * case, RegSetValueEx is called to load the factory default 
	 * setting specified by the function argument defaultvalue into 
	 * the registry and then adjust the memory variable 
	 * accordingly.  The function then exits.
	 */
	
	void setupregvar(char *regvarname, int *memoryvar, int defaultvalue)
	{
		HKEY  currentkey;
		DWORD disposition;
		long  result;
		DWORD data, size, type;
	
		/* OPEN OR CREATE A REGISTRY KEY FOR THIS APPLICATION */
	
		result = RegCreateKeyEx(
			HKEY_CURRENT_USER,				// HANDLE OF THE OPEN ROOT KEY
			"Software\\KNIF\\Furball\\100",	// ADDRESS OF SUBKEY NAME
			0,								// RESERVED, MUST BE 0
			"REG_SZ",						// ADDRESS OF CLASS STRING
			REG_OPTION_NON_VOLATILE,		// SPECIAL OPTIONS FLAG
			KEY_ALL_ACCESS,					// OPEN ACCESS GIVEN
			NULL,							// NO SECURITY STRUCTURE USED
			&currentkey,					// ADDRESS OF BUFFER FOR OPEN HANDLE
			&disposition					// ADDRESS OF DISPOSITION VALUE BUFFER
		);
	
		if (result != ERROR_SUCCESS)
			MessageBox(hWnd, "The registry could not be opened.",
				APPNAMELONG, MB_OK);
	
		/* READ REGVARNAME AND PUT ITS VALUE IN DATA */
		
		data = DOUBLEWORDDATA; // 1
		size = DOUBLEWORDSIZE; // 4
		type = DOUBLEWORDTYPE; // 0
	
		result = RegQueryValueEx(
			currentkey,				// HANDLE TO THE FURBALL KEY
			regvarname,				// NAME OF THE REGISTRY VARIABLE TO READ
			NULL,					// RESERVED BY WINDOWS
			&type,					// RETURNS THE TYPE
			(LPBYTE)&data,			// THE READ VALUE WILL BE PUT IN DATA
			&size					// SIZE OF BUFFER
		);
	
		/* CASE 1: THE VALUE WAS READ CORRECTLY */
	
		if (result == ERROR_SUCCESS) {
	
			/* LOAD THE READ VALUE INTO THE MEMORY VARIABLE */
	
			*memoryvar = (int)data;
	
		/* CASE 2: THE VALUE COULD NOT BE READ */
	
		} else {
	
			/* PUT THE DEFAULT VALUE IN THE REGISTRY */
	
			data = defaultvalue;
	
			result = RegSetValueEx(
				currentkey,				// HANDLE TO THE FURBALL KEY
				regvarname,				// NAME OF THE VARIABLE TO MAKE
				0,						// RESERVED BY WINDOWS
				REG_DWORD,				// THE TYPE OF THE NEW VARIABLE
				(const BYTE *)&data,	// POINTER TO THE VALUE TO LOAD
				BYTESINDWORD			// THERE ARE 4 BYTES IN A DWORD
			);
	
			/* PUT THE DEFAULT VALUE IN THE MEMORY VARIABLE */
	
			*memoryvar = defaultvalue;
	
		}
	}
	
	/********************************************/
	/* WRITE REGISTRY VARIABLE                  */
	/********************************************/
	
	/* 
	 * This function has the job of opening the application’s key 
	 * in the Windows System Registry, writing an integer value to 
	 * an existing data label in that key, and then setting a 
	 * mirroring global memory variable to reflect the same 
	 * information.  There are three arguments.  The string 
	 * regvarname is the name of the data label that should be used 
	 * in the Registry.  The integer pointer memoryvar points at 
	 * the global memory variable that mirrors the registry data 
	 * with name regvarname.  The integer newvalue is the new value 
	 * that the Registry and memory variables should be set to.  
	 * The function has no return value.
	 * 
	 * The variable currentkey is a handle to the currently open 
	 * Registry key.  The variables disposition and result are used 
	 * by the API calls that communicate with the Registry.
	 * 
	 * This function first makes the API call RegCreateKeyEx, which 
	 * opens the registry, looks for the key for this application, 
	 * and opens it.  If the application key cannot be found, the 
	 * registry was either damaged or edited.  In that case, 
	 * RegCreateKeyEx automatically creates a blank key in the 
	 * registry for this application.  Now we know that the 
	 * registry key is open and without errors, but the data value 
	 * we are interested in within that key may still be damaged or 
	 * missing.
	 * 
	 * Next, the API call RegSetValueEx is called to load the new 
	 * integer specified as an argument into the registry.  The 
	 * integer pointer is then used to set the mirroring global 
	 * variable to the same value.  The function then exits.
	 */
	
	void writeregvar(char *regvarname, int *memoryvar, int newvalue)
	{
		HKEY  currentkey;
		DWORD disposition;
		long  result;
	
		/* OPEN OR CREATE A REGISTRY KEY FOR THIS APPLICATION */
	
		result = RegCreateKeyEx(
			HKEY_CURRENT_USER,				// HANDLE OF THE OPEN ROOT KEY
			"Software\\KNIF\\Furball\\100",	// ADDRESS OF SUBKEY NAME
			0,								// RESERVED, MUST BE 0
			"REG_SZ",						// ADDRESS OF CLASS STRING
			REG_OPTION_NON_VOLATILE,		// SPECIAL OPTIONS FLAG
			KEY_ALL_ACCESS,					// OPEN ACCESS GIVEN
			NULL,							// NO SECURITY STRUCTURE USED
			&currentkey,					// ADDRESS OF BUFFER FOR OPEN HANDLE
			&disposition					// ADDRESS OF DISPOSITION VALUE BUFFER
		);
	
		if (result != ERROR_SUCCESS)
			MessageBox(hWnd, "The registry could not be opened.",
				APPNAMELONG, MB_OK);
	
		/* WRITE THE GIVEN VALUE TO THE SPECIFIED REGISTRY VARIABLE */
	
		result = RegSetValueEx(
			currentkey,					// HANDLE TO THE FURBALL KEY
			regvarname,					// NAME OF THE VARIABLE TO ACCESS
			0,							// RESERVED BY WINDOWS
			REG_DWORD,					// THE TYPE OF THE NEW VARIABLE
			(const BYTE *)&newvalue,	// POINTER TO THE VALUE TO LOAD
			BYTESINDWORD				// THERE ARE 4 BYTES IN A DWORD
		);
	
		/* ALSO CHANGE THE VARIABLE IN MEMORY */
	
		*memoryvar = newvalue;
	}
	
	/********************************************/
	/* CHECK DAY STATE                          */
	/********************************************/
	
	/* 
	 * Furball’s Adventures has an Easter-egg feature of Day and 
	 * Night.  Based on the local time of the system clock, the 
	 * appearance of the board and the music that is played will be 
	 * different in the day than in the night.  This function has 
	 * the job of checking what time it is, and changing day to 
	 * night or night to day if necessary.  There are no arguments 
	 * or return values.
	 * 
	 * The variable newdaystate, of type daystate, is the day state 
	 * found by this function each time it is run.
	 * 
	 * This function works by first calling getlight and loading 
	 * the day state right now into the variable newdaystate.  This 
	 * function now has access to two accounts of whether it is 
	 * night or day.  The global variable currentdaystate tells 
	 * what mode the program is currently running under, and the 
	 * local variable newdaystate tells what the most recent time 
	 * analysis said the day state was.  Most of the time, these 
	 * two variables will agree.  If a set time for dawn or dusk 
	 * has happened since the last check, however, the two will not 
	 * be the same, and this function must take change 
	 * currentdaystate to daystate, and then alert the rest of the 
	 * program about the event.
	 * 
	 * If the currentdaysate is NIGHT while the newdaystate is DAY, 
	 * dawn has occurred since the last check.  The function 
	 * displays a message box to report sunrise to the user, 
	 * updates the currentdaystate global variable, redraws the 
	 * board, and restarts the music.  A similar list of tasks are 
	 * carried out if the function detects that DAY has turned to 
	 * NIGHT.
	 */
	
	void checkdaystate()
	{
		daystate newdaystate;
	
		/* FIND THE LIGHT STATE RIGHT NOW */
	
		newdaystate = getlight();
	
		/* CHECK FOR DAWN */
	
		if (currentdaystate == NIGHT && newdaystate == DAY) {
	
			MessageBox(hWnd, DAWNTEXT, "Dawn Breaks", MB_OK);
			currentdaystate = newdaystate;
			drawboard();
			jukebox(PLAY);
	
		}
	
		/* CHECK FOR DUSK */
	
		if (currentdaystate == DAY && newdaystate == NIGHT) {
	
			MessageBox(hWnd, DUSKTEXT, "Night Falls", MB_OK);
			currentdaystate = newdaystate;
			drawboard();
			jukebox(PLAY);
	
		}
	}
	
	/********************************************/
	/* GET LIGHT                                */
	/********************************************/
	
	/* 
	 * Furball’s Adventures has an Easter-egg feature of Day and 
	 * Night.  Based on the local time of the system clock, the 
	 * appearance of the board and the music that is played will be 
	 * different in the day than in the night.  This function 
	 * determines whether it is day or night right now, and returns 
	 * the right answer.  There are no arguments, and the return 
	 * value is either DAY or NIGHT.
	 * 
	 * The variable currentlocaltime, a structure of type 
	 * SYSTEMTIME which is defined by Windows, is used to hold 
	 * information about the current local time on the computer the 
	 * application is running on.  The integer hournow is a holding 
	 * place for the hour integer from the currentlocaltime 
	 * structure.  
	 * 
	 * This function works by first making the API call 
	 * GetLocalTime to fill the currentlocaltime structure with 
	 * information about the time right now on the user’s computer.  
	 * The number of the hour from this structure is then copied 
	 * into the variable hournow.  The function then returns DAY if 
	 * hournow is found to both be later than the defined constant 
	 * DAWN and before the constant DUSK - 1.  Otherwise, the 
	 * function returns NIGHT.
	 */
	
	daystate getlight()
	{
		SYSTEMTIME currentlocaltime;
		int hournow;
	
		GetLocalTime(&currentlocaltime);
		hournow = currentlocaltime.wHour;
	
		if ((hournow >= DAWN) && (hournow <= (DUSK - 1)))
			return (DAY);
		else
			return (NIGHT);
	}
	
	/**********************************************************/
	/* end of file furball.c                                  */
	/**********************************************************/
}
