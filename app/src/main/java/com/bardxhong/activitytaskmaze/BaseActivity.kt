package com.bardxhong.activitytaskmaze

import android.content.Intent
import android.content.Intent.*
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.base_activity.*


open class BaseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.base_activity)
        activity_name.text = componentName.shortClassName
        logIntent(intent)
        val rootView = activity_root
        val someActivityList = BaseActivity::class.nestedClasses
        someActivityList.forEach { kClass ->
            val startIntentButton = LayoutInflater.from(this).inflate(
                R.layout.start_intent_button,
                null,
                false
            ) as StartIntentButton

            startIntentButton
                .apply {
                    text = kClass.simpleName
                    setOnClickListener {
                        showChoosingDialog(
                            Intent(
                                this@BaseActivity,
                                kClass.java
                            )
                        )
                    }
                }
                .let {
                    rootView.addView(it)
                }
        }


    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        Log.i("TaskInformation", "onNewIntent called")
        logIntent(intent)
    }

    private fun logIntent(intent: Intent?) {
        Log.i("TaskInformation", "className: ${componentName.shortClassName}, ref: ${toString().replace(javaClass.name, "")}, taskId: $taskId, flags: ${intent?.flags?.toString(16)}")
        Log.d("TaskInformation", "FLAG_ACTIVITY_NEW_TASK: ${intent?.flags?:0 and FLAG_ACTIVITY_NEW_TASK == FLAG_ACTIVITY_NEW_TASK}")
        Log.d("TaskInformation", "FLAG_ACTIVITY_CLEAR_TOP: ${intent?.flags?:0 and FLAG_ACTIVITY_CLEAR_TOP == FLAG_ACTIVITY_CLEAR_TOP}")
        Log.d("TaskInformation", "FLAG_ACTIVITY_SINGLE_TOP: ${intent?.flags?:0 and FLAG_ACTIVITY_SINGLE_TOP == FLAG_ACTIVITY_SINGLE_TOP}")
        Log.d("TaskInformation", "FLAG_ACTIVITY_CLEAR_TASK: ${intent?.flags?:0 and FLAG_ACTIVITY_CLEAR_TASK == FLAG_ACTIVITY_CLEAR_TASK}")
    }

    class Standard : BaseActivity()

    class Standard_Affinity : BaseActivity()

    class SingleTop : BaseActivity()

    class SingleTop_Affinity : BaseActivity()

    class SingleTask : BaseActivity()

    class SingleTask_Affinity : BaseActivity()

    class SingleInstance : BaseActivity()

    class SingleIntance_Affinity: BaseActivity()
}


