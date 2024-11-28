package com.example.viewmodelex1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.viewmodelex1.databinding.FragmentBottomBinding


/**
 * A simple [Fragment] subclass.
 * Use the [BottomFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class BottomFragment : Fragment() {

    lateinit var binding: FragmentBottomBinding

    lateinit var vm: MyviewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentBottomBinding.inflate(inflater,container,false)
        vm = ViewModelProvider(requireActivity()).get(MyviewModel::class.java)


        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnCount.setOnClickListener {
            vm.incrementCounter()
        }
    }


}