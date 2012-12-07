# Microsoft Developer Studio Generated NMAKE File, Format Version 4.10
# ** DO NOT EDIT **

# TARGTYPE "Win32 (x86) Application" 0x0101

!IF "$(CFG)" == ""
CFG=Furball - Win32 Debug
!MESSAGE No configuration specified.  Defaulting to Furball - Win32 Debug.
!ENDIF 

!IF "$(CFG)" != "Furball - Win32 Release" && "$(CFG)" !=\
 "Furball - Win32 Debug"
!MESSAGE Invalid configuration "$(CFG)" specified.
!MESSAGE You can specify a configuration when running NMAKE on this makefile
!MESSAGE by defining the macro CFG on the command line.  For example:
!MESSAGE 
!MESSAGE NMAKE /f "Furball.mak" CFG="Furball - Win32 Debug"
!MESSAGE 
!MESSAGE Possible choices for configuration are:
!MESSAGE 
!MESSAGE "Furball - Win32 Release" (based on "Win32 (x86) Application")
!MESSAGE "Furball - Win32 Debug" (based on "Win32 (x86) Application")
!MESSAGE 
!ERROR An invalid configuration is specified.
!ENDIF 

!IF "$(OS)" == "Windows_NT"
NULL=
!ELSE 
NULL=nul
!ENDIF 
################################################################################
# Begin Project
# PROP Target_Last_Scanned "Furball - Win32 Debug"
RSC=rc.exe
MTL=mktyplib.exe
CPP=cl.exe

!IF  "$(CFG)" == "Furball - Win32 Release"

# PROP BASE Use_MFC 0
# PROP BASE Use_Debug_Libraries 0
# PROP BASE Output_Dir "Release"
# PROP BASE Intermediate_Dir "Release"
# PROP BASE Target_Dir ""
# PROP Use_MFC 0
# PROP Use_Debug_Libraries 0
# PROP Output_Dir "Release"
# PROP Intermediate_Dir "Release"
# PROP Target_Dir ""
OUTDIR=.\Release
INTDIR=.\Release

ALL : "$(OUTDIR)\Furball.exe"

CLEAN : 
	-@erase "$(INTDIR)\furball.obj"
	-@erase "$(INTDIR)\furball.res"
	-@erase "$(INTDIR)\game.obj"
	-@erase "$(OUTDIR)\Furball.exe"

"$(OUTDIR)" :
    if not exist "$(OUTDIR)/$(NULL)" mkdir "$(OUTDIR)"

# ADD BASE CPP /nologo /W3 /GX /O2 /D "WIN32" /D "NDEBUG" /D "_WINDOWS" /YX /c
# ADD CPP /nologo /W3 /GX /O2 /D "WIN32" /D "NDEBUG" /D "_WINDOWS" /YX /c
CPP_PROJ=/nologo /ML /W3 /GX /O2 /D "WIN32" /D "NDEBUG" /D "_WINDOWS"\
 /Fp"$(INTDIR)/Furball.pch" /YX /Fo"$(INTDIR)/" /c 
CPP_OBJS=.\Release/
CPP_SBRS=.\.
# ADD BASE MTL /nologo /D "NDEBUG" /win32
# ADD MTL /nologo /D "NDEBUG" /win32
MTL_PROJ=/nologo /D "NDEBUG" /win32 
# ADD BASE RSC /l 0x409 /d "NDEBUG"
# ADD RSC /l 0x409 /d "NDEBUG"
RSC_PROJ=/l 0x409 /fo"$(INTDIR)/furball.res" /d "NDEBUG" 
BSC32=bscmake.exe
# ADD BASE BSC32 /nologo
# ADD BSC32 /nologo
BSC32_FLAGS=/nologo /o"$(OUTDIR)/Furball.bsc" 
BSC32_SBRS= \
	
LINK32=link.exe
# ADD BASE LINK32 kernel32.lib user32.lib gdi32.lib winspool.lib comdlg32.lib advapi32.lib shell32.lib ole32.lib oleaut32.lib uuid.lib /nologo /subsystem:windows /machine:I386
# ADD LINK32 kernel32.lib user32.lib gdi32.lib winspool.lib comdlg32.lib advapi32.lib shell32.lib ole32.lib oleaut32.lib uuid.lib winmm.lib /nologo /subsystem:windows /machine:I386
LINK32_FLAGS=kernel32.lib user32.lib gdi32.lib winspool.lib comdlg32.lib\
 advapi32.lib shell32.lib ole32.lib oleaut32.lib uuid.lib winmm.lib /nologo\
 /subsystem:windows /incremental:no /pdb:"$(OUTDIR)/Furball.pdb" /machine:I386\
 /out:"$(OUTDIR)/Furball.exe" 
LINK32_OBJS= \
	"$(INTDIR)\furball.obj" \
	"$(INTDIR)\furball.res" \
	"$(INTDIR)\game.obj"

"$(OUTDIR)\Furball.exe" : "$(OUTDIR)" $(DEF_FILE) $(LINK32_OBJS)
    $(LINK32) @<<
  $(LINK32_FLAGS) $(LINK32_OBJS)
<<

!ELSEIF  "$(CFG)" == "Furball - Win32 Debug"

# PROP BASE Use_MFC 0
# PROP BASE Use_Debug_Libraries 1
# PROP BASE Output_Dir "Debug"
# PROP BASE Intermediate_Dir "Debug"
# PROP BASE Target_Dir ""
# PROP Use_MFC 0
# PROP Use_Debug_Libraries 1
# PROP Output_Dir "Debug"
# PROP Intermediate_Dir "Debug"
# PROP Target_Dir ""
OUTDIR=.\Debug
INTDIR=.\Debug

ALL : "$(OUTDIR)\Furball.exe"

CLEAN : 
	-@erase "$(INTDIR)\furball.obj"
	-@erase "$(INTDIR)\furball.res"
	-@erase "$(INTDIR)\game.obj"
	-@erase "$(INTDIR)\vc40.idb"
	-@erase "$(INTDIR)\vc40.pdb"
	-@erase "$(OUTDIR)\Furball.exe"
	-@erase "$(OUTDIR)\Furball.ilk"
	-@erase "$(OUTDIR)\Furball.pdb"

"$(OUTDIR)" :
    if not exist "$(OUTDIR)/$(NULL)" mkdir "$(OUTDIR)"

# ADD BASE CPP /nologo /W3 /Gm /GX /Zi /Od /D "WIN32" /D "_DEBUG" /D "_WINDOWS" /YX /c
# ADD CPP /nologo /W3 /Gm /GX /Zi /Od /D "WIN32" /D "_DEBUG" /D "_WINDOWS" /YX /c
CPP_PROJ=/nologo /MLd /W3 /Gm /GX /Zi /Od /D "WIN32" /D "_DEBUG" /D "_WINDOWS"\
 /Fp"$(INTDIR)/Furball.pch" /YX /Fo"$(INTDIR)/" /Fd"$(INTDIR)/" /c 
CPP_OBJS=.\Debug/
CPP_SBRS=.\.
# ADD BASE MTL /nologo /D "_DEBUG" /win32
# ADD MTL /nologo /D "_DEBUG" /win32
MTL_PROJ=/nologo /D "_DEBUG" /win32 
# ADD BASE RSC /l 0x409 /d "_DEBUG"
# ADD RSC /l 0x409 /d "_DEBUG"
RSC_PROJ=/l 0x409 /fo"$(INTDIR)/furball.res" /d "_DEBUG" 
BSC32=bscmake.exe
# ADD BASE BSC32 /nologo
# ADD BSC32 /nologo
BSC32_FLAGS=/nologo /o"$(OUTDIR)/Furball.bsc" 
BSC32_SBRS= \
	
LINK32=link.exe
# ADD BASE LINK32 kernel32.lib user32.lib gdi32.lib winspool.lib comdlg32.lib advapi32.lib shell32.lib ole32.lib oleaut32.lib uuid.lib /nologo /subsystem:windows /debug /machine:I386
# ADD LINK32 kernel32.lib user32.lib gdi32.lib winspool.lib comdlg32.lib advapi32.lib shell32.lib ole32.lib oleaut32.lib uuid.lib winmm.lib /nologo /subsystem:windows /debug /machine:I386
LINK32_FLAGS=kernel32.lib user32.lib gdi32.lib winspool.lib comdlg32.lib\
 advapi32.lib shell32.lib ole32.lib oleaut32.lib uuid.lib winmm.lib /nologo\
 /subsystem:windows /incremental:yes /pdb:"$(OUTDIR)/Furball.pdb" /debug\
 /machine:I386 /out:"$(OUTDIR)/Furball.exe" 
LINK32_OBJS= \
	"$(INTDIR)\furball.obj" \
	"$(INTDIR)\furball.res" \
	"$(INTDIR)\game.obj"

"$(OUTDIR)\Furball.exe" : "$(OUTDIR)" $(DEF_FILE) $(LINK32_OBJS)
    $(LINK32) @<<
  $(LINK32_FLAGS) $(LINK32_OBJS)
<<

!ENDIF 

.c{$(CPP_OBJS)}.obj:
   $(CPP) $(CPP_PROJ) $<  

.cpp{$(CPP_OBJS)}.obj:
   $(CPP) $(CPP_PROJ) $<  

.cxx{$(CPP_OBJS)}.obj:
   $(CPP) $(CPP_PROJ) $<  

.c{$(CPP_SBRS)}.sbr:
   $(CPP) $(CPP_PROJ) $<  

.cpp{$(CPP_SBRS)}.sbr:
   $(CPP) $(CPP_PROJ) $<  

.cxx{$(CPP_SBRS)}.sbr:
   $(CPP) $(CPP_PROJ) $<  

################################################################################
# Begin Target

# Name "Furball - Win32 Release"
# Name "Furball - Win32 Debug"

!IF  "$(CFG)" == "Furball - Win32 Release"

!ELSEIF  "$(CFG)" == "Furball - Win32 Debug"

!ENDIF 

################################################################################
# Begin Source File

SOURCE=.\appicon.ico

!IF  "$(CFG)" == "Furball - Win32 Release"

!ELSEIF  "$(CFG)" == "Furball - Win32 Debug"

!ENDIF 

# End Source File
################################################################################
# Begin Source File

SOURCE=.\furball.aps

!IF  "$(CFG)" == "Furball - Win32 Release"

!ELSEIF  "$(CFG)" == "Furball - Win32 Debug"

!ENDIF 

# End Source File
################################################################################
# Begin Source File

SOURCE=.\furball.c
DEP_CPP_FURBA=\
	".\furball.h"\
	".\game.h"\
	".\levels.h"\
	

"$(INTDIR)\furball.obj" : $(SOURCE) $(DEP_CPP_FURBA) "$(INTDIR)"


# End Source File
################################################################################
# Begin Source File

SOURCE=.\furball.h

!IF  "$(CFG)" == "Furball - Win32 Release"

!ELSEIF  "$(CFG)" == "Furball - Win32 Debug"

!ENDIF 

# End Source File
################################################################################
# Begin Source File

SOURCE=.\furball.rc

!IF  "$(CFG)" == "Furball - Win32 Release"

DEP_RSC_FURBAL=\
	".\appicon.ico"\
	".\boxongrass.bmp"\
	".\boxongrassn.bmp"\
	".\boxonsink.bmp"\
	".\boxonsinkn.bmp"\
	".\dialogabout.ico"\
	".\dialogwon.ico"\
	".\doorclosed.bmp"\
	".\doorclosedn.bmp"\
	".\dooropen.bmp"\
	".\dooropenn.bmp"\
	".\enemy.bmp"\
	".\enemyn.bmp"\
	".\fbongrass.bmp"\
	".\fbongrassn.bmp"\
	".\fbonsink.bmp"\
	".\fbonsinkn.bmp"\
	".\grass.bmp"\
	".\grassn.bmp"\
	".\heart.bmp"\
	".\heartn.bmp"\
	".\rock.bmp"\
	".\rockn.bmp"\
	".\sink.bmp"\
	".\sinkn.bmp"\
	".\wall.bmp"\
	".\walln.bmp"\
	
NODEP_RSC_FURBAL=\
	".\Release\0x7f7f"\
	

"$(INTDIR)\furball.res" : $(SOURCE) $(DEP_RSC_FURBAL) "$(INTDIR)"
   $(RSC) $(RSC_PROJ) $(SOURCE)


!ELSEIF  "$(CFG)" == "Furball - Win32 Debug"

DEP_RSC_FURBAL=\
	".\appicon.ico"\
	".\boxongrass.bmp"\
	".\boxongrassn.bmp"\
	".\boxonsink.bmp"\
	".\boxonsinkn.bmp"\
	".\dialogabout.ico"\
	".\dialogwon.ico"\
	".\doorclosed.bmp"\
	".\doorclosedn.bmp"\
	".\dooropen.bmp"\
	".\dooropenn.bmp"\
	".\enemy.bmp"\
	".\enemyn.bmp"\
	".\fbongrass.bmp"\
	".\fbongrassn.bmp"\
	".\fbonsink.bmp"\
	".\fbonsinkn.bmp"\
	".\grass.bmp"\
	".\grassn.bmp"\
	".\heart.bmp"\
	".\heartn.bmp"\
	".\rock.bmp"\
	".\rockn.bmp"\
	".\sink.bmp"\
	".\sinkn.bmp"\
	".\wall.bmp"\
	".\walln.bmp"\
	
NODEP_RSC_FURBAL=\
	".\Debug\0x7f7f"\
	

"$(INTDIR)\furball.res" : $(SOURCE) $(DEP_RSC_FURBAL) "$(INTDIR)"
   $(RSC) $(RSC_PROJ) $(SOURCE)


!ENDIF 

# End Source File
################################################################################
# Begin Source File

SOURCE=.\resource.h

!IF  "$(CFG)" == "Furball - Win32 Release"

!ELSEIF  "$(CFG)" == "Furball - Win32 Debug"

!ENDIF 

# End Source File
################################################################################
# Begin Source File

SOURCE=.\levels.h

!IF  "$(CFG)" == "Furball - Win32 Release"

!ELSEIF  "$(CFG)" == "Furball - Win32 Debug"

!ENDIF 

# End Source File
################################################################################
# Begin Source File

SOURCE=.\game.h

!IF  "$(CFG)" == "Furball - Win32 Release"

!ELSEIF  "$(CFG)" == "Furball - Win32 Debug"

!ENDIF 

# End Source File
################################################################################
# Begin Source File

SOURCE=.\game.c
DEP_CPP_GAME_=\
	".\furball.h"\
	".\game.h"\
	".\levels.h"\
	

"$(INTDIR)\game.obj" : $(SOURCE) $(DEP_CPP_GAME_) "$(INTDIR)"


# End Source File
# End Target
# End Project
################################################################################
