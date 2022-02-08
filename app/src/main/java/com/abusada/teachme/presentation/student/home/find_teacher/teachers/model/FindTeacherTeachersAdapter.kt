package com.abusada.teachme.presentation.student.home.find_teacher.teachers.model

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.abusada.teachme.data.models.Teacher
import com.abusada.teachme.databinding.RowFindTeacherTeacherBinding
import com.abusada.teachme.presentation.BaseRecyclerViewAdapter
import com.abusada.teachme.presentation.student.home.find_teacher.FindTeacherViewModel

class FindTeacherTeachersAdapter(private val viewModel: FindTeacherViewModel) :
    BaseRecyclerViewAdapter<Teacher>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return FindTeacherTeachersViewHolder(
            RowFindTeacherTeacherBinding.inflate(
                LayoutInflater.from(
                    parent.context
                ), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if(holder is FindTeacherTeachersViewHolder)
            holder.bind(mItems[position])
    }

    inner class FindTeacherTeachersViewHolder(val item: RowFindTeacherTeacherBinding) :
        RecyclerView.ViewHolder(item.root) {

        fun bind(teacher: Teacher) {
            item.viewModel = viewModel
            item.teacher = teacher
        }
    }
}