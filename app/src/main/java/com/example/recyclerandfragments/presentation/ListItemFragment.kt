package com.example.recyclerandfragments.presentation

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResultListener

import com.example.recyclerandfragments.R
import com.example.recyclerandfragments.databinding.FragmentLinearItemBinding
import com.example.recyclerandfragments.presentation.InfoFragment.Companion.LAST_NAME
import com.example.recyclerandfragments.presentation.InfoFragment.Companion.NAME
import com.example.recyclerandfragments.presentation.InfoFragment.Companion.NUMBER
import com.example.recyclerandfragments.presentation.InfoFragment.Companion.REQUEST_KEY_1
import com.example.recyclerandfragments.presentation.InfoFragment.Companion.REQUEST_KEY_2
import com.example.recyclerandfragments.presentation.InfoFragment.Companion.REQUEST_KEY_3
import com.example.recyclerandfragments.presentation.InfoFragment.Companion.REQUEST_KEY_4

open class ListItemFragment : Fragment(R.layout.fragment_linear_item) {

    private var _binding: FragmentLinearItemBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLinearItemBinding.inflate(inflater, container, false)
        return binding.root
    }

    private var listItemNavigationAction: ListItemNavigationAction? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listItemNavigationAction = requireActivity() as ListItemNavigationAction

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tryItem()
        clickHandling()

    }

    private fun clickHandling() {

        binding.item1.setOnClickListener {
            listItemNavigationAction?.showFullInfo(
                binding.id1.text.toString(),
                binding.name1.text.toString(),
                binding.lastName1.text.toString(),
                binding.number1.text.toString(),
            )
        }

        binding.item2.setOnClickListener {
            listItemNavigationAction?.showFullInfo(
                binding.id2.text.toString(),
                binding.name2.text.toString(),
                binding.lastName2.text.toString(),
                binding.number2.text.toString(),
            )
        }

        binding.item3.setOnClickListener {
            listItemNavigationAction?.showFullInfo(
                binding.id3.text.toString(),
                binding.name3.text.toString(),
                binding.lastName3.text.toString(),
                binding.number3.text.toString(),
            )
        }

        binding.item4.setOnClickListener {
            listItemNavigationAction?.showFullInfo(
                binding.id4.text.toString(),
                binding.name4.text.toString(),
                binding.lastName4.text.toString(),
                binding.number4.text.toString(),
            )
        }
    }

    private fun tryItem() {

        setFragmentResultListener(REQUEST_KEY_1) { _, bundle ->
            val resultName = bundle.getString(NAME)
            val resultLastName = bundle.getString(LAST_NAME)
            val resultNumber = bundle.getString(NUMBER)
            binding.name1.text = resultName
            binding.lastName1.text = resultLastName
            binding.number1.text = resultNumber
        }

        setFragmentResultListener(REQUEST_KEY_2) { _, bundle ->
            val resultName = bundle.getString(NAME)
            val resultLastName = bundle.getString(LAST_NAME)
            val resultNumber = bundle.getString(NUMBER)
            binding.name2.text = resultName
            binding.lastName2.text = resultLastName
            binding.number2.text = resultNumber
        }

        setFragmentResultListener(REQUEST_KEY_3) { _, bundle ->
            val resultName = bundle.getString(NAME)
            val resultLastName = bundle.getString(LAST_NAME)
            val resultNumber = bundle.getString(NUMBER)
            binding.name3.text = resultName
            binding.lastName3.text = resultLastName
            binding.number3.text = resultNumber

        }

        setFragmentResultListener(REQUEST_KEY_4) { _, bundle ->
            val resultName = bundle.getString(NAME)
            val resultLastName = bundle.getString(LAST_NAME)
            val resultNumber = bundle.getString(NUMBER)
            binding.name4.text = resultName
            binding.lastName4.text = resultLastName
            binding.number4.text = resultNumber

        }
    }

    companion object {
        const val LIST_ITEM_FRAGMENT = "LIST_ITEM_FRAGMENT"

        fun newInstance() = ListItemFragment()
    }
}


