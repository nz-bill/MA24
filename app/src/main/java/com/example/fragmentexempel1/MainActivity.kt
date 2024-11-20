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
}