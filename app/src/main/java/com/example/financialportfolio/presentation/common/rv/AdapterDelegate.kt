package com.example.financialportfolio.presentation.common.rv

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.ViewHolder

interface AdapterDelegate<T> {

    fun isForViewType(items: List<T>, position: Int): Boolean

    fun onCreateViewHolder(parent: ViewGroup): ViewHolder

    fun onBindViewHolder(holder: ViewHolder, items: List<T>, position: Int)
}
