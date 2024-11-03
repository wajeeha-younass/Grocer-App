package com.example.app

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseExpandableListAdapter
import android.widget.TextView
import android.graphics.Typeface

class FAQExpandableListAdapter(
    private val context: Context,
    private val faqList: List<String>,
    private val answerMap: HashMap<String, String>
) : BaseExpandableListAdapter() {

    override fun getChild(listPosition: Int, expandedListPosition: Int): Any {
        return answerMap[faqList[listPosition]] ?: ""
    }

    override fun getChildId(listPosition: Int, expandedListPosition: Int): Long {
        return expandedListPosition.toLong()
    }

    override fun getGroup(listPosition: Int): Any {
        return faqList[listPosition]
    }

    override fun getGroupCount(): Int {
        return faqList.size
    }

    override fun getChildrenCount(listPosition: Int): Int {
        return 1 // Each question has only one answer.
    }

    override fun getGroupId(listPosition: Int): Long {
        return listPosition.toLong()
    }

    override fun hasStableIds(): Boolean {
        return false
    }

    override fun isChildSelectable(listPosition: Int, expandedListPosition: Int): Boolean {
        return true
    }
    override fun getGroupView(
        listPosition: Int, isExpanded: Boolean, convertView: View?, parent: ViewGroup?
    ): View {
        val question = getGroup(listPosition) as String
        val view = convertView ?: LayoutInflater.from(context).inflate(R.layout.faq_group_item, parent, false)
        val textView = view.findViewById<TextView>(R.id.question_text)
        textView.text = question
        return view
    }

    override fun getChildView(
        listPosition: Int, expandedListPosition: Int, isLastChild: Boolean, convertView: View?, parent: ViewGroup?
    ): View {
        val answer = getChild(listPosition, expandedListPosition) as String
        val view = convertView ?: LayoutInflater.from(context).inflate(R.layout.faq_child_item, parent, false)
        val textView = view.findViewById<TextView>(R.id.answer_text)
        textView.text = answer
        return view
    }

}
