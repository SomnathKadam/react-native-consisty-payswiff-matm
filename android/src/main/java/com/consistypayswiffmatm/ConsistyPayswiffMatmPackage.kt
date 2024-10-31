package com.consistypayswiffmatm

import com.facebook.react.ReactPackage
import com.facebook.react.bridge.JavaScriptModule
import com.facebook.react.bridge.NativeModule
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.uimanager.ViewManager
import java.util.Collections


class ConsistyPayswiffMatmPackage : ReactPackage {
  override fun createNativeModules(reactContext: ReactApplicationContext): List<NativeModule> {
    return listOf(ConsistyPayswiffMatmModule(reactContext))
  }

  override fun createJSModules(): MutableList<Class<out JavaScriptModule>> {
    return Collections.emptyList();
  }

  override fun createViewManagers(reactContext: ReactApplicationContext): List<ViewManager<*, *>> {
    return emptyList()
  }
}
