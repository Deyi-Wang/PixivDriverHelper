@echo off
echo 是否修改hosts？修改前建议先备份原hosts文件。
echo 若修改失败，请先关闭所有杀毒软件并右键以管理员身份运行此程序！
pause
copy /y "%~dp0hosts" "C:\Windows\System32\drivers\etc\"
echo 修改完成，按任意键退出！
pause >nul