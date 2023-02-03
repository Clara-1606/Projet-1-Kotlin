package com.ynov.firstproject.ui.lists.spells

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModelProvider
import com.ynov.firstproject.databinding.FragmentSpellsBinding
import com.ynov.firstproject.lists.model.Spell


class SpellsFragment : Fragment() {

    private lateinit var viewModel: SpellsViewModel

    private var _binding: FragmentSpellsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val spellsViewModel =
            ViewModelProvider(this).get(SpellsViewModel::class.java)

        _binding = FragmentSpellsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.composeView.setContent {
            SpellList(spellsViewModel.spells)
        }

        return root
        }

    @Composable
    fun SpellList(spells: List<Spell>) {

        LazyColumn(
            modifier = Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(16.dp))
        {
            items(spells) { spell ->
                SpellRow(spell)
            }
        }
    }

    @Composable
    fun SpellRow(spell: Spell){
        Card(
            modifier = Modifier.padding(10.dp)
                .fillMaxWidth()
                .wrapContentHeight(),
            shape = MaterialTheme.shapes.medium
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Column(Modifier.padding(8.dp)) {
                    Text(
                        text = spell.name,
                        style = MaterialTheme.typography.headlineSmall,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                    Text(
                        text = getString(spell.effect),
                        style = MaterialTheme.typography.bodySmall
                    )
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}