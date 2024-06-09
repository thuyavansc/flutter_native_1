package com.example.flutter_native_1

//class FullScreenAlarmActivity { }

import android.content.Context
import android.content.Intent
import android.os.Bundle
import io.flutter.embedding.android.FlutterActivity
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.embedding.engine.FlutterEngineCache
import io.flutter.plugin.common.MethodChannel

//import androidx.activity.ComponentActivity
//import androidx.activity.compose.setContent
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.padding
//import androidx.compose.material.Button
//import androidx.compose.material.MaterialTheme
//import androidx.compose.material.Text
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.unit.dp


//import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView
import android.widget.Button

class FullScreenAlarmActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_full_screen_alarm)

        val titleView = findViewById<TextView>(R.id.alarmTitle)
        val bodyView = findViewById<TextView>(R.id.alarmBody)
        val stopAlarmButton = findViewById<Button>(R.id.stopAlarmButton)

        // Get extras from intent
        val title = intent.getStringExtra("title") ?: "Default Alarm Title"
        val body = intent.getStringExtra("body") ?: "Default Alarm Body"

        titleView.text = title
        bodyView.text = body

        stopAlarmButton.setOnClickListener {
            finish()  // Close the activity
        }
    }
}


//class FullScreenAlarmActivity : ComponentActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        val title = intent.getStringExtra("title") ?: "Alarm"
//        val body = intent.getStringExtra("body") ?: "Alarm triggered"
//
//        setContent {
//            Column(
//                modifier = Modifier.fillMaxSize().padding(16.dp),
//                horizontalAlignment = Alignment.CenterHorizontally
//            ) {
//                Text(text = title, style = MaterialTheme.typography.h4)
//                Text(text = body, style = MaterialTheme.typography.body1)
//                Button(onClick = {
//                    finish() // Closes the activity
//                }) {
//                    Text("Stop Alarm")
//                }
//            }
//        }
//    }
//}

//
//class FullScreenAlarmActivity : FlutterActivity() {
//    private val CHANNEL = "com.example.flutter_screen_open_from_android_intent_1/alarm"
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//
//        // Get the singleton FlutterEngine
//        val flutterEngine = FlutterEngineSingleton.getFlutterEngine(this)
//
//        MethodChannel(flutterEngine.dartExecutor.binaryMessenger, CHANNEL).invokeMethod("openAlarmPage", mapOf(
//            "title" to intent.getStringExtra("title"),
//            "body" to intent.getStringExtra("body")
//        ))
//
//        // Ensure the activity doesn't stay in the back stack
//        //finish()
//    }
//
//    override fun provideFlutterEngine(context: Context): FlutterEngine? {
//        return FlutterEngineSingleton.getFlutterEngine(context)
//    }
//}


//class FullScreenAlarmActivity : FlutterActivity() {
//    private val CHANNEL = "com.example.flutter_screen_open_from_android_intent_1/alarm"
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//
//        // Extract the extras from the intent
//        val title = intent.getStringExtra("title")
//        val body = intent.getStringExtra("body")
//
//        // Pass the extracted data to the Flutter side
//        MethodChannel(flutterEngine!!.dartExecutor.binaryMessenger, CHANNEL).invokeMethod("openAlarmPage", mapOf("title" to title, "body" to body))
//
//        // Close this activity to avoid keeping it in the back stack
//        //finish()
//    }
//}

