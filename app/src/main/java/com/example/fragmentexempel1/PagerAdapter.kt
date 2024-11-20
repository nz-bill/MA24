package com.example.fragmentexempel1

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter


// pagereadaptern håller eda på de fragmetn vi vill kunna 'bläddra' bland
// i detta exempel så låter vi den ärva från FragmentStateAdapter men andra adaptrar förekommer
class PagerAdapter(fa: FragmentActivity): FragmentStateAdapter(fa) {

    //onItemCount returnerar antal fragment i pagern
    override fun getItemCount(): Int {
       return 3
    }

    //createFragment skapar,indexerar och returnerar våra fragment i viewpagern baserat på dess position i viewPagern
    override fun createFragment(position: Int): Fragment {

        return when (position){

            0 -> FirstFragment()

            1 -> SecondFragment()

            2 -> ThirdFragment()

            else -> FirstFragment()
        }
    }
}