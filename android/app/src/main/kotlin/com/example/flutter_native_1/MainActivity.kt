package com.example.flutter_native_1

import io.flutter.embedding.android.FlutterActivity

//class MainActivity: FlutterActivity()
import android.content.Context

//class MainActivity: FlutterActivity()
import android.content.Intent
import android.os.Bundle
import android.util.Log
//import io.flutter.embedding.android.FlutterActivity
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.embedding.engine.dart.DartExecutor
import io.flutter.plugin.common.MethodChannel
import io.flutter.embedding.engine.FlutterEngineCache


class MainActivity : FlutterActivity() {
    private val CHANNEL = "your_channel_name"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        MethodChannel(flutterEngine!!.dartExecutor.binaryMessenger, CHANNEL).setMethodCallHandler { call, result ->
            if (call.method == "startFullScreenActivity") {
                val title = call.argument<String>("title")
                val body = call.argument<String>("body")
                startFullScreenAlarmActivity(title, body)
                result.success(null)
            } else {
                result.notImplemented()
            }
        }
    }

    private fun startFullScreenAlarmActivity(title: String?, body: String?) {
        val intent = Intent(this, FullScreenAlarmActivity::class.java).apply {
            putExtra("title", title)
            putExtra("body", body)
        }
        startActivity(intent)
    }
}


//class MainActivity : FlutterActivity() {
//    private val CHANNEL = "your_channel_name"
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//
//        // Get the singleton FlutterEngine
//        val flutterEngine = FlutterEngineSingleton.getFlutterEngine(this)
//
//        MethodChannel(flutterEngine.dartExecutor.binaryMessenger, CHANNEL).setMethodCallHandler { call, result ->
//            if (call.method == "startFullScreenActivity") {
//                val title = call.argument<String>("title")
//                val body = call.argument<String>("body")
//                startFullScreenAlarmActivity(title, body)
//                result.success(null)
//            } else {
//                result.notImplemented()
//            }
//        }
//    }
//
//    private fun startFullScreenAlarmActivity(title: String?, body: String?) {
//        val intent = Intent(this, FullScreenAlarmActivity::class.java).apply {
//            putExtra("title", title)
//            putExtra("body", body)
//            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
//        }
//        startActivity(intent)
//    }
//
//    override fun provideFlutterEngine(context: Context): FlutterEngine? {
//        return FlutterEngineSingleton.getFlutterEngine(context)
//    }
//}




//class MainActivity : FlutterActivity() {
//    private val CHANNEL = "your_channel_name"
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//
//        // Set up the MethodChannel to listen for method calls from Flutter
//        MethodChannel(flutterEngine!!.dartExecutor.binaryMessenger, CHANNEL).setMethodCallHandler { call, result ->
//            if (call.method == "startFullScreenActivity") {
//                val title = call.argument<String>("title")
//                val body = call.argument<String>("body")
//                startFullScreenAlarmActivity(title, body)
//                result.success(null)
//            } else {
//                result.notImplemented()
//            }
//        }
//    }
//
//    private fun startFullScreenAlarmActivity(title: String?, body: String?) {
//        val intent = Intent(this, FullScreenAlarmActivity::class.java).apply {
//            putExtra("title", title)
//            putExtra("body", body)
//        }
//        startActivity(intent)
//    }
//
//    override fun configureFlutterEngine(flutterEngine: FlutterEngine) {
//        super.configureFlutterEngine(flutterEngine)
//        MethodChannel(flutterEngine.dartExecutor.binaryMessenger, CHANNEL).setMethodCallHandler { call, result ->
//            if (call.method == "startFullScreenActivity") {
//                val title = call.argument<String>("title")
//                val body = call.argument<String>("body")
//                startFullScreenAlarmActivity(title, body)
//                result.success(null)
//            } else {
//                result.notImplemented()
//            }
//        }
//    }
//}