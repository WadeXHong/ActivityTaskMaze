package com.bardxhong.activitytaskmaze

import android.content.Intent
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

        Log.i("TaskInformation", "className: ${componentName.shortClassName}, taskId: $taskId, flags: ${intent.flags.toString(16)}")

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
        Log.i("TaskInformation", "className: ${componentName.shortClassName}, taskId: $taskId, flags: ${intent?.flags?.toString(16)}")
    }


    class SingleTopActivity : BaseActivity()

    class SingleTaskActivity : BaseActivity()

    class SingleInstanceActivity : BaseActivity()
}


