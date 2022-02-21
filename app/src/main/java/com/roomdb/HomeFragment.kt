package com.roomdb

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.roomdb.databinding.FragmentHomeBinding


class HomeFragment : Fragment(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val homeBinding: FragmentHomeBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)

        homeBinding.bnAddUser.setOnClickListener(this)
        homeBinding.bnViewUser.setOnClickListener(this)
        homeBinding.bnDeleteUser.setOnClickListener(this)
        homeBinding.bnUpdateUser.setOnClickListener(this)
        return homeBinding.root
    }

    override fun onClick(v: View?) {
        when (v!!.id) {

            R.id.bn_add_user -> {
                (activity as MainActivity).fragmentManager?.beginTransaction()
                    ?.replace(R.id.fragment_container, AddUserFragment())?.addToBackStack(null)
                    ?.commit()

            }
            R.id.bn_delete_user -> {
                (activity as MainActivity).fragmentManager?.beginTransaction()
                    ?.replace(R.id.fragment_container, DeleteUserFragment())?.addToBackStack(null)
                    ?.commit()
            }
            R.id.bn_update_user -> {
                (activity as MainActivity).fragmentManager?.beginTransaction()
                    ?.replace(R.id.fragment_container, UpdateUserFragment())?.addToBackStack(null)
                    ?.commit()
            }
            R.id.bn_view_user -> {
                (activity as MainActivity).fragmentManager?.beginTransaction()
                    ?.replace(R.id.fragment_container, ViewFragment())?.addToBackStack(null)
                    ?.commit()
            }

        }
    }


}