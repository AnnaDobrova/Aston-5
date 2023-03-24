package com.example.recyclerandfragments.presentation

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResult
import com.example.recyclerandfragments.R
import com.example.recyclerandfragments.databinding.FragmentInfoBinding

class InfoFragment : Fragment(R.layout.fragment_info) {

    private var editInfoSave: EditInfoSave? = null

    private var _binding: FragmentInfoBinding? = null
    private val binding get() = _binding!!

    override fun onAttach(context: Context) {
        super.onAttach(context)
        editInfoSave = requireActivity() as EditInfoSave
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentInfoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.idOnSecond.text = requireArguments().getString(ID)
        binding.textViewWithNameInfo.setText(requireArguments().getString(NAME))
        binding.textViewWithLastNameInfo.setText(requireArguments().getString(LAST_NAME))
        binding.textViewWithNumberInfo.setText(requireArguments().getString(NUMBER))

        binding.buttonToSave.setOnClickListener {
            takeData()
            editInfoSave?.editSave()
        }

    }

    private fun takeData() {
        val resultId = binding.idOnSecond.text.toString()
        val resultName = binding.textViewWithNameInfo.text.toString()
        val resultLastName = binding.textViewWithLastNameInfo.text.toString()
        val resultNumber = binding.textViewWithNumberInfo.text.toString()
        if (resultId == "1") {

            setFragmentResult(
                REQUEST_KEY_1,
                bundleOf(NAME to resultName, LAST_NAME to resultLastName, NUMBER to resultNumber)
            )
        }
        if (resultId == "2") {

            setFragmentResult(
                REQUEST_KEY_2,
                bundleOf(NAME to resultName, LAST_NAME to resultLastName, NUMBER to resultNumber)
            )
        }
        if (resultId == "3") {

            setFragmentResult(
                REQUEST_KEY_3,
                bundleOf(NAME to resultName, LAST_NAME to resultLastName, NUMBER to resultNumber)
            )
        }
        if (resultId == "4") {

            setFragmentResult(
                REQUEST_KEY_4,
                bundleOf(NAME to resultName, LAST_NAME to resultLastName, NUMBER to resultNumber)
            )
        }
    }

    companion object {
        const val INFO_FRAGMENT_TAG = "INFO_FRAGMENT_TAG"
        const val REQUEST_KEY_1 = "REQUEST_KEY_1"
        const val REQUEST_KEY_2 = "REQUEST_KEY_2"
        const val REQUEST_KEY_3 = "REQUEST_KEY_3"
        const val REQUEST_KEY_4 = "REQUEST_KEY_4"
        const val NAME = "NAME"
        const val LAST_NAME = "LAST_NAME"
        const val NUMBER = "NUMBER"
        const val ID = "ID"

        fun newInstance(
            id: String,
            name: String,
            lastName: String,
            number: String
        ) = InfoFragment().also {
            it.arguments = bundleOf(
                ID to id,
                NAME to name,
                LAST_NAME to lastName,
                NUMBER to number
            )
        }
    }
}