package com.example.implicitintentex1

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val cameraButton = findViewById<Button>(R.id.btn_camera)
        val ImageButton = findViewById<Button>(R.id.btn_image)

//        button.setOnClickListener {
//            //callAFriend()
//            //surfTheWeb()
//            //maps()
//            //sendStuff()
//        }
    }


    //URI = Universal Resource Identifier

    fun callAFriend(){
        val telUri = Uri.parse("tel:0701234567")
        val callIntent = Intent(Intent.ACTION_DIAL, telUri)
        startActivity(callIntent)
    }

    fun surfTheWeb(){
        val webUri = Uri.parse("https://www.android.com")
        val webIntent = Intent(Intent.ACTION_VIEW, webUri)

        startActivity(webIntent)
    }

    fun maps(){
        val mapCords = Uri.parse("geo: 59, 18, 10")
        val mapIntent = Intent(Intent.ACTION_VIEW,mapCords)
        startActivity(mapIntent)
    }

    fun sendStuff(){

        val sendIntent = Intent(Intent.ACTION_SEND)
        sendIntent.putExtra(Intent.EXTRA_TEXT,"hej från min app")
        sendIntent.type = "text/plain"
        startActivity(sendIntent)
    }
}