
package com.duguodong.andserver;

import android.content.res.AssetManager;
import android.widget.Toast;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.yanzhenjie.andserver.AndServer;
import com.yanzhenjie.andserver.Server;
import com.yanzhenjie.andserver.website.AssetsWebsite;

public class RNAndserverModule extends ReactContextBaseJavaModule {

  private final ReactApplicationContext reactContext;
  private Server mServer;

  public RNAndserverModule(ReactApplicationContext reactContext) {
    super(reactContext);
    this.reactContext = reactContext;
  }

  @Override
  public String getName() {
    return "RNAndServer";
  }


  /**
   * 启动本地服务
   */
  @ReactMethod
  public void startLocalServer() {
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
  }

  /**
   * 停止本地服务
   */
  @ReactMethod
  public void stopLocalServer() {
    if(mServer == null){
      Toast.makeText(reactContext,"请先开启服务",Toast.LENGTH_SHORT).show();
      return;
    }
    if(mServer.isRunning()){
      mServer.stop();
    }
  }


  private Server.Listener mListener = new Server.Listener() {
    @Override
    public void onStarted() {
      // 服务器启动成功.
      Toast.makeText(reactContext,"服务启动成功",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onStopped() {
      // 服务器停止了，一般是开发者调用server.stop()才会停止。
      Toast.makeText(reactContext,"服务停止",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onError(Exception e) {
      // 服务器启动发生错误，一般是端口被占用。
      Toast.makeText(reactContext,"服务器启动发生错误",Toast.LENGTH_SHORT).show();
    }
  };
}