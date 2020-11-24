<?xml version="1.0" encoding="utf-8"?>
<layout xmlns:android="http://schemas.android.com/apk/res/android">

    <data>

        <variable
            name="listener"
            type="${packageName}.${folderName}.${activityClass}"/>
    </data>

    <androidx.constraintlayout.widget.ConstraintLayout
        xmlns:tools="http://schemas.android.com/tools"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        tools:context="${packageName}.${folderName}.${activityClass}">

    </androidx.constraintlayout.widget.ConstraintLayout>
</layout>
