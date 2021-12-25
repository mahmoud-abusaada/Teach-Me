package com.abusada.teachme.presentation.student.home.find_teacher.grades.model

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.abusada.teachme.data.models.GradeDescription
import com.abusada.teachme.databinding.RowFindTeacherGradeBinding
import com.abusada.teachme.presentation.BaseRecyclerViewAdapter

class FindTeacherGradesAdapter(private val listener: RecyclerViewListener) :
    BaseRecyclerViewAdapter<GradeDescription>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FindTeacherGradeViewHolder {
        return FindTeacherGradeViewHolder(
            RowFindTeacherGradeBinding.inflate(
                LayoutInflater.from(
                    parent.context
                ), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is FindTeacherGradeViewHolder)
            holder.bind(mItems[position])
    }

    inner class FindTeacherGradeViewHolder(val item: RowFindTeacherGradeBinding) :
        RecyclerView.ViewHolder(item.root) {

//        init {
//            CoroutineScope(Dispatchers.Main).launch {
//                item.root.clicks().collect {
//                    val position = adapterPosition
//                    if (position != RecyclerView.NO_POSITION)
//                        listener.onItemClicked(position)
//                }
//            }
//        }

        fun bind(grade: GradeDescription) {
            item.grade = grade
        }
    }
}