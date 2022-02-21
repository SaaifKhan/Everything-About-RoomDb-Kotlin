package com.roomdb

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import com.roomdb.databinding.FragmentViewBinding
import kotlinx.android.synthetic.main.fragment_add_user.*


class ViewFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val viewUserFragment: FragmentViewBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_view, container, false)

        val users: List<User> =
            (activity as MainActivity).myAppDatabase!!.myDao()!!.getAllItem()

        var info = ""

        for ((id, name, email) in users) {
            info = """${info}id : $id 
                name : $name 
                email: $email
"""
        }
        viewUserFragment.userDetails.text = info;

        return viewUserFragment.getRoot();


    }

//    return v.root;


}