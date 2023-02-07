package edu.quinnipiac.ser210.ls03_nav_demo


import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import edu.quinnipiac.ser210.ls03_nav_demo.ChooseRecipientFragmentDirections


class ChooseRecipientFragment : Fragment(), View.OnClickListener {


    lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_choose_recipient, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        view.findViewById<Button>(R.id.next_btn).setOnClickListener(this)
        view.findViewById<Button>(R.id.cancel_btn).setOnClickListener(this)
    }

    override fun onClick(v: View?) {
      when(v!!.id){
          R.id.next_btn ->{
              val input_recipient: EditText = requireView().findViewById(R.id.input_recipient)
              if (! TextUtils.isEmpty(input_recipient.text.toString())){
                  val recipient = input_recipient.text.toString()
                  val action = ChooseRecipientFragmentDirections.actionChooseRecipientFragmentToSpecifyAmountFragment(recipient)
                  v.findNavController().navigate(action)
              }
          }
          R.id.cancel_btn -> requireActivity().onBackPressed()
      }
    }
}
