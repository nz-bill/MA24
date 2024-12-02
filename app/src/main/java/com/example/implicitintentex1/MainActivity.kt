package com.example.implicitintentex1

import android.content.ContentResolver
import android.content.ContentValues
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    //camera
    private lateinit var takePicture: ActivityResultLauncher<Uri>
    private lateinit var imageUri: Uri                                  //referens till URI för extern lagring på enheten

    //gallery
    private lateinit var getFromGallery: ActivityResultLauncher<String>
    private lateinit var profileView: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //vi kontrollerar och begär behörigheter till kameran
        checkCameraPerimssion()

        profileView = findViewById(R.id.img_profile)
        val cameraButton = findViewById<Button>(R.id.btn_camera)
        val imageButton = findViewById<Button>(R.id.btn_image)

        //definierar activityResultLauncher som anropar kameran och returnerar en bild
        takePicture = registerForActivityResult(ActivityResultContracts.TakePicture()){success ->
            if(success){
                profileView.setImageURI(imageUri)
            }

        }

        //definierar activityResultLauncher som anropar galleriet och returnerar en bild
        getFromGallery = registerForActivityResult(ActivityResultContracts.GetContent()){
            uri:Uri? -> profileView.setImageURI(uri)
        }


        cameraButton.setOnClickListener {
            imageUri = createImageUri()         //sätter imageUri till just denna enhets lagringsplats för bilder
            takePicture.launch(imageUri)        //startar upp vår activityResultLauncher som anropar kameran
        }

        imageButton.setOnClickListener {
            getFromGallery.launch("image/*")    //startar upp vår activityResultLauncher som anropar galleriet
        }

     }


    //metod som skapar en URI för att spara en bild i det externa lagringsområdet på en Android-enhet.
    private fun createImageUri(): Uri{

//        ContentResolver är en klass som används för att hantera interaktioner med innehållsleverantörer (Content Providers),
//         t.ex. att läsa och skriva data till lagring via Androids API.
        val contentResoler: ContentResolver = this.contentResolver

        //ContentValues är en behållare för att lagra nyckel-värde-par.
        //Här används den för att ange metadata för bilden:
        //"image/jpeg" är MIME-typen för en JPEG-bild.
        val contentValues = ContentValues().apply {
            put(MediaStore.Images.Media.MIME_TYPE, "image/jpeg")
        }

//      contentResolver.insert() används för att lägga till en ny post i content providern.
//      MediaStore.Images.Media.EXTERNAL_CONTENT_URI är en URI som pekar på standardplatsen för bilder i enhetens externa lagring.
//      contentValues innehåller metadata för den nya posten.
//      Funktionen returnerar en Uri som refererar till den nyskapade posten.
        return contentResoler.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues)!!
    }

    //vi kontrollerar och begär behörigheter till kameran
    private fun checkCameraPerimssion(){

        if(ContextCompat.checkSelfPermission(this, android.Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED){
            requestPermissions(arrayOf(android.Manifest.permission.CAMERA), 2)
        }
    }




    //URI = Uniform Resource Identifier


    //nedan metoder används ej i detta exemepel
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