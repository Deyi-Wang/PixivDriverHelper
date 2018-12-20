# 恭喜你安装成功！！！
## 第一次配置教程及常见问题解决
## 1,第一次安装后配置
### （1）安装证书
打开软件，点击“安装证书”按钮，弹出安装证书界面：<br>
![](https://i.imgur.com/Ph4GUsk.png)<br>
点击“安装证书”<br>
![](https://i.imgur.com/soK42Pz.png)<br>
然后按照如下图步骤操作即可成功导入证书！<br>
![](https://i.imgur.com/8vI6MLH.png)
![](https://i.imgur.com/7NXtgyR.png)
![](https://i.imgur.com/rFjB9QY.png)
![](https://i.imgur.com/h1L43hi.png)
![](https://i.imgur.com/u0z8Cgq.png)<br>
### (2)修改hosts文件
打开软件，点击“修改hosts文件”按钮，打开一个文件夹：<br>
右键-以管理员身份运行“一键修改.bat”一键修改hosts！<br>
![](https://i.imgur.com/XEfzM5j.png)<br>
按照批处理里面的指示操作即可！<br>
![](https://i.imgur.com/DmATfZC.png)
![](https://i.imgur.com/tFRV610.png)<br>
也可以手动修改，复制hosts文件到目录C:\Windows\System32\drivers\etc下并覆盖原文件。<br>

提示没有权限无法覆盖？请看管理员权限获取教程:[点击查看](https://blog.csdn.net/yanhanhui1/article/details/82746357)<br>
#### 这样，第一次配置就完成了！

## 以后日常使用：
（1）每次启动软件首先会进行更新检测，检测时软件在短时间内无法使用，等待几秒更新检测完成后即可开始。<br>
![](https://i.imgur.com/i1K6tQU.png)<br>
（2）检测更新完成后点击“启动服务”按钮，显示“服务正在运行”时，即启动服务成功！现在就可以访问pixiv了！<br>
![](https://i.imgur.com/hzPUYYF.png)<br>
（3）使用完毕后最好点击“停止服务”按钮，关闭服务。<br>
![](https://i.imgur.com/rbf9OTm.png)<br>

## 2，常见问题及解决方法
### （1）使用Google Chrome浏览器提示“您的连接不是私密连接攻击者可能会试图从 www.pixiv.net 窃取您的信息（例如：密码、通讯内容或信用卡信息）。”
这是由于我们先开始修改了证书所导致。修改证书后该软件才能正常运行，否则无法访问pixiv。证书完全安全，所以放心。<br>
只需依次点击“高级-继续前往。。。”即可。
![](https://i.imgur.com/8FSx2An.png)<br>
![](https://i.imgur.com/W0mjn6P.png)
### （2）软件打开后一直显示“检查更新中。。。”而无法使用。
那是因为没有联网或dns配置有问题而导致。<br>
连接互联网或者修改dns为114.114.114.114或8.8.8.8即可。
### （3）无法启动服务
可能是用户误删了软件中的配置文件或者软件被安装在了一个中文目录而导致。<br>
重新安装软件，并安装到纯英文目录！
### （4）其它问题
点击“更新配置文件”按钮，再按照上面步骤重新修改hosts文件即可。