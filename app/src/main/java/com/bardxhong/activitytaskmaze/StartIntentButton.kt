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


    fun showChoosingDialog(intent: Intent) {
        val selectView = IntentFlagSelectView(context)

        AlertDialog.Builder(context)
            .setView(selectView)
            .setPositiveButton("send", object :DialogInterface.OnClickListener {
                override fun onClick(dialog: DialogInterface?, which: Int) {
                    if (selectView.cbNewTask.isChecked) intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                    if (selectView.cbClearTop.isChecked) intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                    if (selectView.cbSingleTop.isChecked) intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP)
                    if (selectView.cbClearTask.isChecked) intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
                    if (selectView.cbMultiTask.isChecked) intent.addFlags(Intent.FLAG_ACTIVITY_MULTIPLE_TASK)
                    if (selectView.cbReorderToFront.isChecked) intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT)
                    if (selectView.cbRandomBundle.isChecked) intent.putExtra(System.currentTimeMillis().toString(), System.currentTimeMillis())
                    context.startActivity(intent).also {
                        if (selectView.cbIsCallFinish.isChecked) (context as? Activity)?.finish()
                    }
                }
            })
            .show()
    }
}