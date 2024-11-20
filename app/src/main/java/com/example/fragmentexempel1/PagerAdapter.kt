package com.example.fragmentexempel1

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class PagerAdapter(fa: FragmentActivity): FragmentStateAdapter(fa) {
    override fun getItemCount(): Int {
       return 3
    }

    override fun createFragment(position: Int): Fragment {

        return when (position){

            0 -> FirstFragment()

            1 -> SecondFragment()

            2 -> ThirdFragment()

            else -> FirstFragment()
        }
    }
}