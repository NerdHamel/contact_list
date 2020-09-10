package com.example.stcpaycodingchallenge.baseclasses.Util

import android.content.Context
import android.graphics.*
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatImageView

class RoundedImageView : AppCompatImageView {
    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(
        context,
        attrs
    ) {
    }

    protected override fun onDraw(canvas: Canvas) {
        val drawable: Drawable = getDrawable() ?: return
        if (getWidth() === 0 || getHeight() === 0) {
            return
        }
        val b = (drawable as BitmapDrawable).bitmap
        if (b != null) {
            val bitmap = b.copy(Bitmap.Config.ARGB_8888, true)
            val w = (getWidth() * 0.9).toInt()
            val h = (getHeight() * 0.9).toInt()
            val roundBitmap = getCroppedBitmap(bitmap, w)
            canvas.drawBitmap(roundBitmap, 0f, 0f, null)
            setScaleType(ScaleType.FIT_CENTER)
        }
    }

    companion object {
        fun getCroppedBitmap(bmp: Bitmap): Bitmap {
            return getCroppedBitmap(bmp, if (bmp.height > bmp.width) bmp.width else bmp.height)
        }

        fun getCroppedBitmap(bmp: Bitmap, radius: Int): Bitmap {
            val sbmp: Bitmap
            sbmp = if (bmp.width != radius || bmp.height != radius) Bitmap.createScaledBitmap(
                bmp,
                radius,
                radius,
                false
            ) else bmp
            val output = Bitmap.createBitmap(
                sbmp.width,
                sbmp.height, Bitmap.Config.ARGB_8888
            )
            val canvas = Canvas(output)
            val color = -0x5e688c
            val paint = Paint()
            val rect = Rect(0, 0, sbmp.width, sbmp.height)
            paint.isAntiAlias = true
            paint.isFilterBitmap = true
            paint.isDither = true
            canvas.drawARGB(0, 0, 0, 0)
            paint.color = Color.parseColor("#BAB399")
            canvas.drawCircle(
                sbmp.width / 2f, sbmp.height / 2f,
                sbmp.width / 2f - 1, paint
            )
            paint.xfermode = PorterDuffXfermode(PorterDuff.Mode.SRC_IN)
            canvas.drawBitmap(sbmp, rect, rect, paint)
            return output
        }

        fun frameBitmap(bmp: Bitmap, frameColor: Int): Bitmap {
            val sbmp: Bitmap
            sbmp = bmp
            val canvas = Canvas(sbmp)
            val paint = Paint()
            paint.isAntiAlias = true
            paint.isFilterBitmap = true
            paint.isDither = true
            paint.style = Paint.Style.STROKE
            paint.color = frameColor
            val width = 10f
            paint.strokeWidth = width
            canvas.drawCircle(
                sbmp.width / 2 + 0.7f, sbmp.height / 2 + 0.7f,
                sbmp.width / 2 - width / 2, paint
            )
            paint.xfermode = PorterDuffXfermode(PorterDuff.Mode.SRC_IN)
            return sbmp
        }
    }
}