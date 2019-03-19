: # Polyglot demo
: #
:<<":UN_X"
@echo off
goto :WIN


:UN_X
export myDev=/media/CRUZER2/Dev/zVSAM/classes  #
export myJar=/media/CRUZER2/Dev/zVSAM/classes/z390hs03t.jar  #
export prodn=/media/CRUZER2/Dev/z/z390.jar  #
#
java -cp ${myDev}:${myJar}:{$prodn} ez390 /media/CRUZER2/Dev/zVSAM/wto1  #
exit $?  #






:WIN
setlocal
set myDev=\Dev\zVSAM\classes
set myJar=\Dev\zVSAM\classes\z390hs03t.jar
set prodn=\Dev\z\z390.jar
 
java -cp %myDev%;myJar;%prodn% ez390 \dev\zVSAM\wto1
exit /b %errorlevel%
