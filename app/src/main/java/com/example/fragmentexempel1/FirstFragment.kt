package com.example.fragmentexempel1

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.fragmentexempel1.databinding.FragmentFirstBinding



/**
 * A simple [Fragment] subclass.
 * Use the [FirstFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class FirstFragment : Fragment() {


    //    1. vi skapar en interface som tillhör fragmentet. Då kan vi skapa ett 'kontrakt' med den aktivitet/fragment
    //    som detta fragment sitter i så interfacets metoder måste användas
    interface FirstFragmentListener{
        fun addButtonPressed(name: String)

    }


    //medlemsvariabler:
    // vi sätter upp viewBinding
    lateinit var binding: FragmentFirstBinding

    // 2. referens till den aktivitet/fragment som 'äger' detta fragment
    // vi säger att den ska vara en instans av vår interface (dvs ägeren ska implementera FirstFragmentListener)
    var ownerActivity: FirstFragmentListener? = null



    // onAttach är den första metoden som anropas när ett nytt fragment skapas
    override fun onAttach(context: Context) {
        super.onAttach(context)

        try {
            // 3. vi försöker sätta vår ägar referens till den Activity (context) som skapade fragmentet.
            // är den inte en FirstFragmentListener (dvs inte implementerar vårt interface) så får vi ett Exception och hamnar i catch
            ownerActivity = context as FirstFragmentListener
            Log.e("SOUT", "listener interface implemented in activity succesfully")
        } catch (e: Exception){
            Log.e("SOUT", "listener interface not implemented in activity")
        }
    }


    //onCreateView är den andra metoden som anropas i livscykeln. Här färdigställer vi vår viewBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentFirstBinding.inflate(inflater,container,false)


        return binding.root
    }


    //onViewCreated anropas efter onCreateView. Här inne vet vi att alla UI element finns tillgängliga och kan utföra operationer på dem
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnAdd.setOnClickListener {
            val name = binding.etName.text.toString()


            // 4. har vi lyckats implemetera vårt interface så vet vi att det kommer finnas en version
            // av metoden addButtonPressed() i aktiviteten som skapade fragmentet
            ownerActivity?.addButtonPressed(name)


        }
    }


    //onDetach är den sista metoden som körs innan fragmentet går i graven.
    //här brukar man vilja frigöra resurser etc för att förhindra minnesläckor

    override fun onDetach() {
        super.onDetach()

        // 5. eftersom vår interface är en sk 'lyssnare' så finns risken att den hänger kvar som referens även efter att fragmentet försvinner
        //därför tar vi det säkra före det osäkra och sätta ownerActivity till null så det inte finns några "spökreferenser" kvar
        ownerActivity = null
    }





}