package com.ynov.firstproject.ui.lists.spells

import androidx.lifecycle.ViewModel
import com.ynov.firstproject.R
import com.ynov.firstproject.lists.model.Spell

class SpellsViewModel : ViewModel() {
    val spells = listOf<Spell>(
        Spell("Accio", R.string.spell_accio),
        Spell("Allohomora", R.string.spell_allohomora),
        Spell("Amplificatum", R.string.spell_amplificatum),
        Spell("Avada kedavra", R.string.spell_avada_kedavra),
        Spell("Collaporta", R.string.spell_collaporta),
        Spell("Crac badaboum", R.string.spell_crac_badaboum),
        Spell("Destructum", R.string.spell_destructum),
        Spell("Diffinito", R.string.spell_diffinito),
        Spell("Dissensium", R.string.spell_dissensium),
        Spell("Ectoplasmus", R.string.spell_ectoplasmus),
        Spell("Elasticus", R.string.spell_elasticus),
    )
}