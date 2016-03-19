## Android报警

基本结构参照：
git@git.oschina.net:xuqi1987/Android.git

### 创建虚拟环境

	mkvirtualenv raspberry

### 安装Flask
	
	pip install Flask
	
### 安装 GPIO
	
	pip install rpi.gpio

#### 看引脚的方式：

![](http://cl.ly/3k0L373q213E/Image%202016-03-19%20at%203.31.20%20%E4%B8%8B%E5%8D%88.png)

#### 引脚图：

![](http://cl.ly/0G0g2r3l1E3i/Image%202016-03-19%20at%204.01.31%20%E4%B8%8B%E5%8D%88.png)

口哨传感器的ACC，GND，OUT连接树莓派物理引脚的4，6，8，其中引脚8对应的BCM为GPIO14。





