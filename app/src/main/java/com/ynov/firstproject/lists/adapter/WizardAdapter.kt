package com.ynov.firstproject.lists.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ynov.firstproject.databinding.ItemWizardBinding
import com.ynov.firstproject.lists.model.Wizard

class WizardAdapter (val items : Array<Wizard>) : RecyclerView.Adapter<WizardAdapter.ViewHolder>(){

    private var context: Context? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemWizardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        context = parent.context;
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        context?.let { holder.bindWizard(items[position], it) }
    }

    override fun getItemCount(): Int = items.size

    inner class ViewHolder (val binding: ItemWizardBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bindWizard(wizard: Wizard, context: Context) {
            binding.wizardName.text = wizard.name
            binding.wizardImage.setImageResource(wizard.image)
            Glide.with(context)
                .load(wizard.image)
                .override(350, 350)
                .into(binding.wizardImage)
        }
    }
}
