package com.example.recyclerandfragments.presentation

interface ListItemNavigationAction {

    fun showFullInfo(
        id : String,
        name : String,
        lastName : String,
        number : String
    )
}