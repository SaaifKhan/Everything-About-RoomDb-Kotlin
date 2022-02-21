package com.roomdb

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.roomdb.databinding.FragmentUpdateUserBinding

class UpdateUserFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val updateFragment: FragmentUpdateUserBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_update_user, container, false)

        updateFragment.btnSubmit.setOnClickListener(object : View.OnClickListener{
            override fun onClick(p0: View?) {

                val id: Int = updateFragment.id.text.toString().toInt()
                val name: String = updateFragment.name.text.toString()
                val email: String = updateFragment.email.text.toString()

                val user = User()
                user.id = id
                user.name = name
                user.email = email

                (activity as MainActivity).myAppDatabase!!.myDao()!!.update(user)
                Toast.makeText(context, "User updated successfully", Toast.LENGTH_SHORT).show();




            }

        })
        return updateFragment.root

    }


}