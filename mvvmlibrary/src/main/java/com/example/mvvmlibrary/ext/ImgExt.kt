package com.example.mvvmlibrary.ext

import android.widget.ImageView
import androidx.annotation.DrawableRes
import androidx.annotation.IntegerRes
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.mvvmlibrary.utils.ArmsUtils
import com.example.mvvmlibrary.utils.CornerTransform

/**
 *  @author RenGX on 2020/6/11
 *
 */
fun ImageView.loadImg(url: String, @DrawableRes placeHolder: Int){
    Glide.with(this.context).load(url).placeholder(placeHolder).into(this)
}

fun ImageView.loadCircleImg(url: String, @DrawableRes placeHolder: Int) {
    Glide.with(this.context).load(url).placeholder(placeHolder).circleCrop().into(this)
}

fun ImageView.loadRadiusImg(
    url: String,
    @DrawableRes placeHolder: Int,
    radius: Float = 20.0f,
    leftTop: Boolean = false,
    rightTop: Boolean = false,
    leftBottom: Boolean = false,
    rightBottom: Boolean = false) {

    val transformation = CornerTransform(this.context, ArmsUtils.dip2px(this.context, radius).toFloat())
    //  false 设置圆角  true 不设置圆角
    transformation.setExceptCorner(leftTop, rightTop, leftBottom, rightBottom)

    val requestOptions = RequestOptions().transform(transformation)

    Glide.with(this.context)
        .asBitmap()
        .apply(requestOptions)
        .load(url)
        .placeholder(placeHolder)
        .into(this)
}