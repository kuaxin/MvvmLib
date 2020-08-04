package com.example.mvvmlibrary

import android.app.Application
import com.hjq.toast.ToastUtils
import com.kingja.loadsir.core.LoadSir
import com.scwang.smart.refresh.footer.ClassicsFooter
import com.scwang.smart.refresh.header.ClassicsHeader
import com.scwang.smart.refresh.layout.SmartRefreshLayout
import me.jessyan.autosize.AutoSizeConfig
import me.jessyan.autosize.unit.Subunits

class MvvmUtils {

    init {
        SmartRefreshLayout.setDefaultRefreshHeaderCreator { context, layout ->
            return@setDefaultRefreshHeaderCreator ClassicsHeader(context)
        }
        SmartRefreshLayout.setDefaultRefreshFooterCreator { context, layout ->
            return@setDefaultRefreshFooterCreator ClassicsFooter(context)
        }
    }


    companion object {

        fun init(application: Application) {
            checkNullPointer(application)

            //初始化Toast
            initToast(application)

            //初始化Autosize
            initAutosize()

            //初始话Dialog框架
//            intLoadSir()
        }

        private fun initAutosize() {
            //AutoSize 屏蔽DP  Sp   MM 为单位适配
            AutoSizeConfig.getInstance()
                .setBaseOnWidth(true)
                .unitsManager
                .setSupportDP(false)
                .setSupportSP(false).supportSubunits = Subunits.MM
        }

        private fun initToast(application: Application) {
            ToastUtils.init(application)
        }

        /**
         * 检查对象是否为空
         */
        private fun checkNullPointer(any: Any?) {
            if (any == null) {
                throw NullPointerException("are you init mvvm by MvvmUtils.init(application)?")
            }
        }

    }

}