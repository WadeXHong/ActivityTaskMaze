package com.bardxhong.activitytaskmaze

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout
import androidx.appcompat.widget.AppCompatCheckBox

class IntentFlagSelectView constructor(
    context: Context,
    attr: AttributeSet? = null,
    defStyle: Int = 0
) : LinearLayout(context, attr, defStyle) {
    init {
        View.inflate(context, R.layout.intent_flag_select_view, this)
    }

    val cbNewTask: AppCompatCheckBox by lazy { findViewById<AppCompatCheckBox>(R.id.checkbox_new_task) }
    val cbClearTop: AppCompatCheckBox by lazy { findViewById<AppCompatCheckBox>(R.id.checkbox_clear_top) }
    val cbSingleTop: AppCompatCheckBox by lazy { findViewById<AppCompatCheckBox>(R.id.checkbox_single_top) }
    val cbClearTask: AppCompatCheckBox by lazy { findViewById<AppCompatCheckBox>(R.id.checkbox_clear_task) }
    val cbMultiTask: AppCompatCheckBox by lazy { findViewById<AppCompatCheckBox>(R.id.checkbox_multi_task) }
    val cbReorderToFront: AppCompatCheckBox by lazy { findViewById<AppCompatCheckBox>(R.id.checkbox_reorder_to_front) }
    val cbRandomBundle: AppCompatCheckBox by lazy { findViewById<AppCompatCheckBox>(R.id.checkbox_random_bundle) }
    val cbIsCallFinish: AppCompatCheckBox by lazy { findViewById<AppCompatCheckBox>(R.id.checkbox_finish_after_intent) }
}