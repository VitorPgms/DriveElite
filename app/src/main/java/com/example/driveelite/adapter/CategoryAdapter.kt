package com.example.driveelite.adapter

import android.graphics.Color
import android.view.ViewGroup
import android.widget.Button
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.driveelite.R

class CategoryAdapter (
    private val categories: List<String>,
    private var selectedCategory: String,
    private val onCategoryClick: (String) -> Unit
) : RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {


    inner class CategoryViewHolder(val button: Button) : RecyclerView.ViewHolder(button)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val button = Button(parent.context).apply {
            layoutParams = ViewGroup.MarginLayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            ).apply {
                marginEnd = 16
            }
            setPadding(32, 12,32,12)
            background = ContextCompat.getDrawable(context, R.drawable.bg_brand_item)
        }
        return CategoryViewHolder(button)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val category = categories[position]
        val isSelected = category == selectedCategory

        holder.button.text = category
        holder.button.setTextColor(
            if (isSelected) Color.WHITE else Color.BLACK
        )
        holder.button.setBackgroundColor(
            if (isSelected) Color.BLACK else Color.LTGRAY
        )

        holder.button.setOnClickListener {
            selectedCategory = category
            notifyDataSetChanged()
            onCategoryClick(category)
        }
    }

    override fun getItemCount(): Int = categories.size
}
