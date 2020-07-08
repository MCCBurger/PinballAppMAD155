package com.ebookfrenzy.pinballappmad155

import android.app.DatePickerDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.DatePicker
import android.widget.TextView
import kotlinx.android.synthetic.main.fragment_play_log.*
import java.util.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [PlayLogFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class PlayLogFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }

    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_play_log, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val list = arrayListOf<String>()

        var selectedDate=""

        pckDatePlayed.setOnClickListener {
            val cal  = Calendar.getInstance()
            val year = cal.get(Calendar.YEAR)
            val month = cal.get(Calendar.MONTH)
            val day = cal.get(Calendar.DAY_OF_MONTH)

            val dateOfPlay = DatePickerDialog(requireContext(),DatePickerDialog.OnDateSetListener{ view, myear, mMonth, mday ->
                pckDatePlayed.setText("$myear/${mMonth+1}/$mday")
            selectedDate = "$myear/${mMonth+1}/$mday"},year,month,day)

            dateOfPlay.show()
        }




        btnSave.setOnClickListener {
            val name = editTextName.text.toString()
            val date = selectedDate.toString()
            val score = editTextScore.text.toString()
            val rating = ratingBar!!.rating.toString()

            list.add("$name   $date   $score  $rating")
            listViewItems.adapter = ArrayAdapter(requireActivity().baseContext,android.R.layout.simple_list_item_1,list)
            editTextName.setText("")
            selectedDate=""
            pckDatePlayed.setText("")
            editTextScore.setText("")
            ratingBar.rating = 0F

        }

    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment PlayLogFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            PlayLogFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}