# RNLocalServer

本项目是示例react native去加载移动设备本地的网页文件

react-native-andserver是开启本地服务的插件用法在src/home.js中已经给出示例

### 插件的用法

1. ` import { NativeModules } from 'react-native' `

> 开启本地服务
2. ` onPress={()=> NativeModules.RNAndServer.startLocalServer()} `

