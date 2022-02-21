package com.roomdb

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.roomdb.databinding.FragmentDeleteUserBinding


class DeleteUserFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val deleteFragment: FragmentDeleteUserBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_delete_user, container, false)

        deleteFragment.deleteBtn.setOnClickListener {
            val user = User()

            if (deleteFragment.deleteId.text.toString().isNotEmpty()) {
                val id: Int = Integer.parseInt(deleteFragment.deleteId.text.toString())
                user.id = id
                (activity as MainActivity).myAppDatabase!!.myDao()!!.delete(user)
                Toast.makeText(context, "User Deleted successfully", Toast.LENGTH_SHORT)
                    .show();


            } else {
                Toast.makeText(context, "Something wrong!!", Toast.LENGTH_SHORT).show();


            }
        }
        return deleteFragment.root;


    }
}