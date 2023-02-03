package com.ynov.firstproject.lists.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ynov.firstproject.databinding.ItemWizardBinding
import com.ynov.firstproject.lists.model.Wizard

class WizardAdapter (val items : Array<Wizard>) : RecyclerView.Adapter<WizardAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemWizardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindWizard(items[position])
    }

    override fun getItemCount(): Int = items.size

    inner class ViewHolder (val binding: ItemWizardBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bindWizard(wizard: Wizard) {
            binding.wizardName.text = wizard.name
            binding.wizardImage.setImageResource(wizard.image)
        }
    }
}
