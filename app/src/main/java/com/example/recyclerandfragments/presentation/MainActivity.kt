package com.example.recyclerandfragments.presentation

import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentContainerView
import com.example.recyclerandfragments.R

class MainActivity :
    FragmentActivity(R.layout.activity_main),
    ListItemNavigationAction,
    EditInfoSave {

    private var rightFragment: FragmentContainerView? = null
    private var leftFragment: FragmentContainerView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        rightFragment = findViewById(R.id.fragment_container_for_right)
        leftFragment = findViewById(R.id.fragment_container_for_left)

        supportFragmentManager.beginTransaction().run {
            setReorderingAllowed(true)

            val listItemFragment = ListItemFragment.newInstance()

            if (examination()) {
                replace(R.id.fragment_container, listItemFragment, ListItemFragment.LIST_ITEM_FRAGMENT)
                addToBackStack(ListItemFragment.LIST_ITEM_FRAGMENT)
                commit()
            } else {
                replace(R.id.fragment_container_for_right, listItemFragment, ListItemFragment.LIST_ITEM_FRAGMENT)
                addToBackStack(ListItemFragment.LIST_ITEM_FRAGMENT)
                commit()
            }
        }
    }

    private fun examination(): Boolean {
        return rightFragment == null && leftFragment == null
    }

    override fun editSave() {
        onBackPressed()
    }

    override fun showFullInfo(id: String, name: String, lastName: String, number: String) {
        supportFragmentManager.beginTransaction().run {
            setReorderingAllowed(true)

            val info = InfoFragment.newInstance(id, name, lastName, number)

            if (examination()) {
                replace(R.id.fragment_container, info, InfoFragment.INFO_FRAGMENT_TAG)
                addToBackStack(InfoFragment.INFO_FRAGMENT_TAG)
                commit()
            } else {
                replace(R.id.fragment_container_for_left, info, InfoFragment.INFO_FRAGMENT_TAG)
                addToBackStack(ListItemFragment.LIST_ITEM_FRAGMENT)
                commit()
            }
        }
    }

}


