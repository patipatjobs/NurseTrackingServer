package com.mysoso.nursetrackingserver.ui.server

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.google.gson.Gson
import com.mysoso.nursetrackingserver.MQTTHelper
import com.mysoso.nursetrackingserver.MainActivity
import com.mysoso.nursetrackingserver.R

class ServerFragment : Fragment() {

    private lateinit var serverViewModel: ServerViewModel


    private  var TAG = "ServerFragment"

    // MQTT
    private lateinit var mqttHelper: MQTTHelper

    //Gson
    val gson = Gson()

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?

    ): View? {
//        (activity as MainActivity?)!!.fragmentMethod()



        serverViewModel =
                ViewModelProviders.of(this).get(ServerViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_server, container, false)
        val textView: TextView = root.findViewById(R.id.text_server)
        serverViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root

    }
}