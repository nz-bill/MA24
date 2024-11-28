package com.example.viewmodelex1

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.viewmodelex1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding


//    val vm: MyviewModel by viewModels         // alternativ till att skapa viewmodel ist för via ViewModelProvider

// om vi inte anväbder oss av 'by viewModels' metoden så skapar vi en lateinit var
    lateinit var vm: MyviewModel

    val topFragment = TopFragment()
    val bottomFragment = BottomFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)


        //skapar en instans av vår viewModel via ViewModelProvider
       vm = ViewModelProvider(this).get(MyviewModel::class.java)


        supportFragmentManager.beginTransaction().apply {
            replace(binding.ffragmentContainerTop.id, topFragment)
            replace(binding.ffragmentContainerBottom.id, bottomFragment)
        }.commit()

//        //vi 'observerar' LiveData variabeln counter som finns i vår viewmodel, så fort den ändras så körs koden innanför { }
//        vm.counter.observe(this, Observer { count ->
//            binding.textView.text = count.toString()            //textView uppdateras när counter ändras i vår viewModel
//        })
//
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }
//
//
//        binding.btnAdd.setOnClickListener {
//
//            // när vi klickar på btnAdd så anropar vi en metod i vår viewModel
//           vm.incrementCounter()
//
//
//        }


    }
}