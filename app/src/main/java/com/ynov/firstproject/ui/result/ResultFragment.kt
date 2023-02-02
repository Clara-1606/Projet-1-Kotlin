package com.ynov.firstproject.ui.result

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.ynov.firstproject.R
import com.ynov.firstproject.databinding.FragmentGalleryBinding
import com.ynov.firstproject.databinding.FragmentResultBinding
import com.ynov.firstproject.quiz.result.ResultHelper
import com.ynov.firstproject.ui.personalinfos.PersonnalInfosViewModel

class ResultFragment : Fragment() {

    var comment : String? = null
    var name : String ="";

    private var _binding: FragmentResultBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val resultViewModel =
            ViewModelProvider(this).get(ResultViewModel::class.java)

        _binding = FragmentResultBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.buttonAdd.setOnClickListener{add()}

        val textResult = binding.result
        val imageView = binding.imageView

        val score = requireArguments().getInt("RESULT")
        val (image, result) = ResultHelper.getResultFromScore(score)
        val name = requireArguments().getString("NAME")
        imageView.setImageResource(image)

        textResult.text = getString(R.string.text_win) + name +  " " + getString(R.string.text_be) + getString(result) + " !!"

        return root
    }

    private fun add () {
        if (comment == null) {
            val editComment = binding.editText
            val resultComment = binding.comment
            comment = editComment.text.toString();
            resultComment.text = editComment.text
            val buttonAdd = binding.buttonAdd
            buttonAdd.isEnabled = false;
            Toast.makeText(context, R.string.text_toast_ok, Toast.LENGTH_LONG).show()
            editComment.setText("")
            editComment.isEnabled = false
        }
        else {
            Toast.makeText(context, R.string.text_toast_error_comment, Toast.LENGTH_LONG).show()
        }


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}