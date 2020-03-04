package com.example.appstreet.extension

import android.content.Context
import android.graphics.Color
import com.example.appstreet.R
import com.faltenreich.skeletonlayout.Skeleton

fun Skeleton.setup(context: Context) {
    maskColor = Color.parseColor("#e9e9e9")
    shimmerColor = Color.parseColor("#cccccc")
    shimmerDurationInMillis = 2000
    maskCornerRadius = context.resources.getDimension(R.dimen.radiusSkeleton)
}