package com.example.fragmentexempel1

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.fragmentexempel1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    val firstFragment= FirstFragment()
    val secondFragment = SecondFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

//         ---------tre sätt att använda fragmentManager----------

        // metod 1: skapa referens till begintransaction()
//        val transaction =supportFragmentManager.beginTransaction()
//        transaction.add(R.id.fc_container,firstFragment)
//        transaction.commit()

        //metod 2: gör alla operationer på en rad
  //      supportFragmentManager.beginTransaction().add(R.id.fc_container,firstFragment).commit()


        //metod 3: använd Apply metoden för att 'gruppera' operationerna
        supportFragmentManager.beginTransaction().apply {

            add(R.id.fc_container, firstFragment )
            commit()

        }

        binding.btnFirst.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {

                replace(R.id.fc_container, firstFragment )

                //addToBackStack gör så att vi kan använda 'back' knappen i android för att gå tillbaka till föregående vy
                addToBackStack("frag1")
                commit()

            }
        }


        binding.btnSecond.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {

                // skapa en bundle som innehåller key-value par som vi vill skicka med fragmentet
                val myBundle = Bundle()
                myBundle.apply {
                    putString("bodyText", "Jag är text från en bundle")

                }

                //uppdatera secondFragment med nya argument (bundle)
                secondFragment.arguments = myBundle

                //byter ut fragment i vår fragmentManager
                replace(R.id.fc_container, secondFragment)
                addToBackStack("frag2")
                commit()
            }
        }



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}