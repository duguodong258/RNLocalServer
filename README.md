# RNLocalServer

本项目是示例react native去加载移动设备本地的网页文件

![image text](https://github.com/duguodong258/RNLocalServer/blob/master/src/images/screen_shot2.png)
![image text](https://github.com/duguodong258/RNLocalServer/blob/master/src/images/screen_shot.jpg)

react-native-andserver是开启本地服务的插件用法在src/home.js中已经给出示例

### 插件的用法

1. 导入原生模块

`import { NativeModules } from 'react-native'`<br><br><br>



2. 通过RNAndServer去调用原生的方法

+ 开启本地服务<br>

` onPress={()=> NativeModules.RNAndServer.startLocalServer()} `<br><br>

+ 停止本地服务

` onPress={()=> NativeModules.RNAndServer.stopLocalServer()} `
