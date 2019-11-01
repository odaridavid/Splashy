package com.davidodari.splashy.customview

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatImageView

/**
 * Custom Image View that works with image different aspect ratio based on their width
 * and height
 */
class SplashyImageView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : AppCompatImageView(context, attrs, defStyleAttr) {

    var aspectRatio: Double = -1.0

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        if (aspectRatio == -1.0) return
        val width = measuredWidth
        val height = (width * aspectRatio).toInt()
        if (height == measuredHeight) return
        setMeasuredDimension(width, height)
    }
}