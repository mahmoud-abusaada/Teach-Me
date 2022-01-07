package com.abusada.teachme.presentation.student.home.find_teacher.grades.model

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.abusada.teachme.data.models.Grade
import com.abusada.teachme.databinding.RowFindTeacherGradeBinding
import com.abusada.teachme.presentation.BaseRecyclerViewAdapter
import com.abusada.teachme.presentation.student.home.find_teacher.FindTeacherViewModel

class FindTeacherGradesAdapter(private val viewModel: FindTeacherViewModel) :
    BaseRecyclerViewAdapter<Grade>() {

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

        fun bind(grade: Grade) {
            item.viewModel = viewModel
            item.grade = grade
        }
    }
}