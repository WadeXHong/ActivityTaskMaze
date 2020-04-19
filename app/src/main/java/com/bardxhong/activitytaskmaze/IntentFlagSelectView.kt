package com.bardxhong.activitytaskmaze

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout

class IntentFlagSelectView constructor(
    context: Context,
    attr: AttributeSet? = null,
    defStyle: Int = 0
) : LinearLayout(context, attr, defStyle) {
    init {
        View.inflate(context, R.layout.intent_flag_select_view, this)
    }
}