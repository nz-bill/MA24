package com.example.fragmentexempel1

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.fragmentexempel1.databinding.ActivityMainBinding
import com.example.fragmentexempel1.databinding.TabFragsBinding
import com.google.android.material.tabs.TabLayoutMediator
import com.google.android.material.tabs.TabLayoutMediator.TabConfigurationStrategy

// (kommenterer 1-5 finns i FirstActivity.kt)
// 6. Vi implementerar vår interface i den/de aktiviteter som ska skapa instanser av FirstFragment()
class MainActivity : AppCompatActivity(), FirstFragment.FirstFragmentListener {

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
//        supportFragmentManager.beginTransaction().apply {
//
//            add(R.id.fc_container, firstFragment )
//            commit()
//
//        }


        val pagerAdapter = PagerAdapter(this)

        binding.vpContainer.adapter = pagerAdapter



        binding.btnFirst.setOnClickListener {
            binding.vpContainer.currentItem--
           // binding.vpContainer.setCurrentItem(binding.vpContainer.currentItem -1, false)
        }


        binding.btnSecond.setOnClickListener {
            binding.vpContainer.currentItem++
           // binding.vpContainer.setCurrentItem(binding.vpContainer.currentItem + 1, false)

        }




        TabLayoutMediator(binding.tlTabs, binding.vpContainer){ tab, pos ->



            val customTab = layoutInflater.inflate(R.layout.tab_frags, null)
            val icon = customTab.findViewById<ImageView>(R.id.img_icon)
            val tabText = customTab.findViewById<TextView>(R.id.tv_text)

            //med viewBinding
//               val bind = TabFragsBinding.inflate(layoutInflater)
//            val customTab = binding.root

            when (pos){
                    0 -> {

                        //med viewBinding
//                        bind.imgIcon.setImageResource(android.R.drawable.ic_menu_week)
//                        bind.tvText.text= "frag 1"

                        icon.setImageResource(android.R.drawable.ic_menu_week)
                        tabText.text= "frag 1"
                    }
                    1 -> {
                        icon.setImageResource(android.R.drawable.btn_star)
                        tabText.text= "frag 2"
                    }
                    2 -> {
                        icon.setImageResource(android.R.drawable.btn_dialog)
                        tabText.text= "frag 3"
                    }

                }
            tab.customView = customTab
        }.attach()


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }


    // 7. eftersom vi implementerar vårt FirstFragmentListener interface så måste vi definiera en metod addButtonPressed()
    override fun addButtonPressed(name: String) {

        // 8. Aktiviteten kan hitta sina fragment via supportFragmentmanager.
        // fragment i en viewPager får som default taggarna "f0", "f1","f2"... osv
        // vi använder oss av det och anropar någon metod i vårt SecondFragment
        val frag2 = supportFragmentManager.findFragmentByTag("f1") as SecondFragment?
        frag2?.setHelloText(name)

    }


//        skapar man fragment med fragmentmanager kan man sätta en tag till ett fragment med den tredje parametern i add/replace metoderna

//        val frag1 = FirstFragment()
//        supportFragmentManager.beginTransaction().apply {
//            replace(binding.vpContainer,frag1,"taggen")
//        }
}