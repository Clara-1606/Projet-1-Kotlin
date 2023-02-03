package com.ynov.firstproject.ui.lists.wizards

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.ynov.firstproject.R
import com.ynov.firstproject.databinding.FragmentListWizardBinding
import com.ynov.firstproject.lists.adapter.WizardAdapter
import com.ynov.firstproject.lists.model.Wizard


class ListWizardFragment : Fragment() {

    private lateinit var binding: FragmentListWizardBinding

    private var items = mutableListOf<Wizard>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentListWizardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        items = seedItems()
        binding.wizardRecyclerView.layoutManager = LinearLayoutManager(context)
        binding.wizardRecyclerView.adapter = WizardAdapter(items.toTypedArray())
    }

    private fun seedItems(): MutableList<Wizard> {
        val wizardString = resources.getStringArray(R.array.wizards)
        val imageArray = intArrayOf(
            R.drawable.dumbledore,
            R.drawable.hagrid,
            R.drawable.harry_potter,
            R.drawable.ron_weasley,
            R.drawable.hermione_granger,
            R.drawable.severus_rogue,
            R.drawable.voldemort,
            R.drawable.drago_malefoy,
            R.drawable.macgonagall,
        )

        for (i in wizardString.indices) {
            items.add(Wizard(wizardString[i], imageArray[i]))
        }
        return items
    }
}
