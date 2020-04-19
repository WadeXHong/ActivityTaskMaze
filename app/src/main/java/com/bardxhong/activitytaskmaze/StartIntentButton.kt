package com.bardxhong.activitytaskmaze

import android.app.Activity
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.util.AttributeSet
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.AppCompatCheckBox

class StartIntentButton @JvmOverloads constructor(
    context: Context,
    attr: AttributeSet? = null,
    defStyle: Int = 0
) : androidx.appcompat.widget.AppCompatButton(context, attr, defStyle) {

    private val selectView by lazy { IntentFlagSelectView(context) }
    val cbNewTask: AppCompatCheckBox by lazy { selectView.findViewById<AppCompatCheckBox>(R.id.checkbox_new_task) }
    val cbClearTop: AppCompatCheckBox by lazy { selectView.findViewById<AppCompatCheckBox>(R.id.checkbox_clear_top) }
    val cbSingleTop: AppCompatCheckBox by lazy { selectView.findViewById<AppCompatCheckBox>(R.id.checkbox_single_top) }
    val cbClearTask: AppCompatCheckBox by lazy { selectView.findViewById<AppCompatCheckBox>(R.id.checkbox_clear_task) }
    val cbReorderToFront: AppCompatCheckBox by lazy { selectView.findViewById<AppCompatCheckBox>(R.id.checkbox_reorder_to_front) }
    val cbIsCallFinish: AppCompatCheckBox by lazy { selectView.findViewById<AppCompatCheckBox>(R.id.checkbox_finish_after_intent) }


    fun showChoosingDialog(intent: Intent) {
        AlertDialog.Builder(context)
            .setView(selectView)
            .setPositiveButton("send", object :DialogInterface.OnClickListener {
                override fun onClick(dialog: DialogInterface?, which: Int) {
                    if (cbNewTask.isChecked) intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                    if (cbClearTop.isChecked) intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                    if (cbSingleTop.isChecked) intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP)
                    if (cbClearTask.isChecked) intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
                    if (cbReorderToFront.isChecked) intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT)
                    context.startActivity(intent).also { if (cbIsCallFinish.isChecked) (context as? Activity)?.finish()}
                }
            })
            .show()
        Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT
    }
}