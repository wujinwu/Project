@echo off
color 0a
taskkill /im explorer.exe /f >nul  2>nul
echo ΢��ת��300��
ping -n 5 127.0.0.1 >nul  2>nul
start C:\Windows\explorer.exe
echo ----------
pause