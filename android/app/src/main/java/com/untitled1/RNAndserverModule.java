
package com.untitled1;

import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

import java.util.Objects;

public class RNAndserverModule extends ReactContextBaseJavaModule {

  private final ReactApplicationContext reactContext;

  public RNAndserverModule(ReactApplicationContext reactContext) {
    super(reactContext);
    this.reactContext = reactContext;
  }

  @Override
  public String getName() {
    return "RNAndServerDemo";
  }

  /**
   * 获取本地html路径
   */
  @ReactMethod
  public void getHtmlUrl(Callback callback) {
      String hostAddress = Objects.requireNonNull(NetUtils.getLocalIPAddress()).getHostAddress();
      String url = "http://" + hostAddress + ":8080/src/freakxapps.com/demo/me/piggy-night5/index.html";
      callback.invoke(url);
  }

}