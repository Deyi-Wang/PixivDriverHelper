@echo off
taskkill /f /im nginx.exe
color 0A
echo 即将开始更新！请勿关闭此窗口！！！
timeout /t 3
Auto-Updater\aria2c.exe -d "Auto-Updater\confs" -i "Auto-Updater\downlist.txt"
move /y "Auto-Updater\confs\*.*" "Nginx\conf\"
echo 完成！
timeout /t 3
exit