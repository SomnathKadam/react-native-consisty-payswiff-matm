package com.consistypayswiffmatm

import android.app.Activity
import android.content.Intent
import com.driver.payswiffmatm.MainActivity
import com.facebook.react.bridge.ActivityEventListener
import com.facebook.react.bridge.Arguments
import com.facebook.react.bridge.Promise
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.bridge.ReactContextBaseJavaModule
import com.facebook.react.bridge.ReactMethod
import com.facebook.react.bridge.ReadableMap
 

//refer : https://stackoverflow.com/questions/53411220/pass-activity-result-into-a-react-native-module

class ConsistyPayswiffMatmModule(reactContext: ReactApplicationContext) :
  ReactContextBaseJavaModule(reactContext), ActivityEventListener {

  private var transactionPromise: Promise? = null
  private val REQUEST_CODE = 1

  override fun getName(): String {
    return NAME
  }

  companion object {
    const val NAME = "ConsistyPayswiffMatm"
  }

  init {
    reactContext.addActivityEventListener(this) //Register this native module as Activity result listener
  }

  override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
    if (requestCode == REQUEST_CODE) {
      val promise = transactionPromise ?: return
      transactionPromise = null

      if (resultCode == Activity.RESULT_OK && data != null) {
        val result = Arguments.createMap().apply {
          putString("statusCode", data.getStringExtra("con_statusCode"))
          putString("message", data.getStringExtra("con_message"))
          putString("rrn", data.getStringExtra("rrn"))
          putString("accountHolderName", data.getStringExtra("account_holder_name"))
          putString("accountBalance", data.getStringExtra("account_balance"))
          putString("cardType", data.getStringExtra("cardType"))
          putString("cardBrand", data.getStringExtra("cardBrand"))
          putString("transactionDateTime", data.getStringExtra("transactionDateTime"))
          putDouble("merchantId", data.getLongExtra("merchantId", 0).toDouble())
          putString("terminalSerialNo", data.getStringExtra("terminalSerialNo"))
          putString("ledgerBalance", data.getStringExtra("ledgerBalance"))
        }
        promise.resolve(result)
      } else {
        promise.reject("TRANSACTION_FAILED", "Transaction was cancelled or failed")
      }
    }
  }


  @ReactMethod
  fun initiateTransaction(config: ReadableMap, promise: Promise) {
    val currentActivity = currentActivity ?: run {
      promise.reject("NO_ACTIVITY", "No activity available")
      return
    }

    transactionPromise = promise

    val intent = Intent(currentActivity, MainActivity::class.java).apply {
      putExtra("transactionType", config.getString("transactionType"))
      putExtra("amount", config.getString("amount"))
      putExtra("userName", config.getString("userName"))
      putExtra("password", config.getString("password"))
      putExtra("orderId", config.getString("orderId"))
      putExtra("defaultPassword", config.getString("defaultPassword"))
      putExtra("appName", "${config.getString("deviceName")}#${config.getString("macAddress")}")
    }

    currentActivity.startActivityForResult(intent, REQUEST_CODE)
  }
}



