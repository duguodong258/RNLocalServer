# RNLocalServer

本项目是示例react native去加载移动设备本地的网页文件

react-native-andserver是开启本地服务的插件用法在src/home.js中已经给出示例
>开启本地服务
  `public void startLocalServer() {
    AssetManager assetManager = reactContext.getAssets();
    AssetsWebsite assetsWebsite = new AssetsWebsite(assetManager, "");
    AndServer andServer = new AndServer.Build()
            .website(assetsWebsite)
            .listener(mListener)
            .port(8080)
            .build();
    //创建服务器
    mServer = andServer.createServer();
    if(!mServer.isRunning()){
      mServer.start();
    }
  }`
