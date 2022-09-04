package io.itsydv.quizapp

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import io.itsydv.quizapp.databinding.ItemOptionBinding
import io.itsydv.quizapp.models.Option
import java.util.*

class OptionsAdapter {

//class OptionsAdapter(val listener: (Option, View) -> Unit): RecyclerView.Adapter<OptionsAdapter.OptionsViewHolder>() {

//    @SuppressLint("ClickableViewAccessibility")
//    inner class OptionsViewHolder(val binding: ItemOptionBinding): RecyclerView.ViewHolder(binding.root) {
//        init {
//            itemView.setOnClickListener {
//                listener.invoke(differ.currentList[adapterPosition], it)
//            }
//            binding.wvOption.setOnTouchListener { view, _ ->
//                listener.invoke(differ.currentList[adapterPosition], binding.root)
//                true
//            }
//        }
//    }
//
//    private val diffCallBack = object: DiffUtil.ItemCallback<Option>() {
//        override fun areItemsTheSame(oldItem: Option, newItem: Option): Boolean {
//            return oldItem.id == newItem.id
//        }
//
//        override fun areContentsTheSame(oldItem: Option, newItem: Option): Boolean {
//            return oldItem == newItem
//        }
//    }
//
//    val differ = AsyncListDiffer(this, diffCallBack)
//    private var optionChar = 'A'
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OptionsViewHolder {
//        return OptionsViewHolder(ItemOptionBinding.inflate(
//            LayoutInflater.from(parent.context),
//            parent,
//            false
//        ))
//    }
//
//    @SuppressLint("SetJavaScriptEnabled")
//    override fun onBindViewHolder(holder: OptionsViewHolder, position: Int) {
//        val option = differ.currentList[position]
//        holder.binding.apply {
//            tvOptionNumber.text = optionChar.toString()
//            optionChar++
//            wvOption.clearCache(true)
//            wvOption.settings.apply {
//                allowFileAccess = true
//                javaScriptEnabled = true
//                builtInZoomControls = false
//            }
//            loadData(wvOption, Utils.JS_FILES + option.text!!)
//        }
//    }
//
//    override fun getItemCount() = differ.currentList.size
}