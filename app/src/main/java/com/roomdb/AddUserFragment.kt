package com.roomdb

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.roomdb.databinding.FragmentAddUserBinding


class AddUserFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val addUserFragment: FragmentAddUserBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_add_user, container, false)

        addUserFragment.btnSubmit.setOnClickListener(object : View.OnClickListener {
            override fun onClick(p0: View?) {
                val id: Int = addUserFragment.id.text.toString().toInt()
                val name: String = addUserFragment.name.text.toString()
                val email: String = addUserFragment.email.getText().toString()

                val user = User(id, name, email)

                (activity as MainActivity).myAppDatabase!!.myDao()!!.insertEntry(user)

                Toast.makeText(context, "User added successfully", Toast.LENGTH_SHORT).show();


            }

        })

        return addUserFragment.root;
    }

}