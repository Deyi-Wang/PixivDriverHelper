@echo off
taskkill /f /im nginx.exe
color 0A
echo ������ʼ���£�����رմ˴��ڣ�����
timeout /t 3
Auto-Updater\aria2c.exe -d "Auto-Updater\confs" -i "Auto-Updater\downlist.txt"
move /y "Auto-Updater\confs\*.*" "Nginx\conf\"
echo ��ɣ�
timeout /t 3
exit