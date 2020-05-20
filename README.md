# ActivityTaskMaze

懶人指令  
```
adb shell dumpsys activity com.bardxhong.activitytaskmaze | grep -v "FragmentManager" | grep -e "ACTIVITY com.bardxhong.activitytaskmaze" -e "TASK" -e "mResumed=true"
```

Logcat filter: `TaskInformation`
