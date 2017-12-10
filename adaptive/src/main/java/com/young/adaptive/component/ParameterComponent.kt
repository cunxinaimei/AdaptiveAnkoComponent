package com.young.adaptive.component

import android.view.View
import android.view.ViewGroup
import com.young.adaptive.AdaptiveLayoutContext
import com.young.adaptive.IComponent
import com.young.adaptive.PX_1
import com.young.adaptive.PX_UNIT

/**
 * Created by Young on 2017/12/10.
 */
open class ParameterComponent : IComponent {
    override fun adaptive(view: View, screenWidth: Int, screenHeight: Int, designWidth: Int, designHeight: Int) {
        val params: ViewGroup.LayoutParams? = view.layoutParams
        params?.apply {
            view.layoutParams = autoLayoutParameters(params, screenWidth, screenHeight, view, designWidth, designHeight)
        }
    }

    open fun autoLayoutParameters(params: ViewGroup.LayoutParams,
                                  screenWidth: Int, screenHeight: Int,
                                  view: View,
                                  designWidth: Int, designHeight: Int): ViewGroup.LayoutParams {
        if (params.width > 0) {
            params.width = AdaptiveLayoutContext.calculate(designWidth, screenWidth, params.width)
        } else if (params.width == PX_1) {
            params.width = PX_UNIT
        }
        if (params.height > 0) {
            params.height = AdaptiveLayoutContext.calculate(designHeight, screenHeight, params.height)
        } else if (params.height == PX_1) {
            params.height = PX_UNIT
        }

        if (params is ViewGroup.MarginLayoutParams) {
            if (params.leftMargin > 0) {
                params.leftMargin = AdaptiveLayoutContext.calculate(designWidth, screenWidth, params.leftMargin)
            } else if (params.leftMargin == PX_1) {
                params.leftMargin = PX_UNIT
            }
            if (params.rightMargin > 0) {
                params.rightMargin = AdaptiveLayoutContext.calculate(designWidth, screenWidth, params.rightMargin)
            } else if (params.rightMargin == PX_1) {
                params.rightMargin = PX_UNIT
            }
            if (params.topMargin > 0) {
                params.topMargin = AdaptiveLayoutContext.calculate(designHeight, screenHeight, params.topMargin)
            } else if (params.topMargin == PX_1) {
                params.topMargin = PX_UNIT
            }
            if (params.bottomMargin > 0) {
                params.bottomMargin = AdaptiveLayoutContext.calculate(designHeight, screenHeight, params.bottomMargin)
            } else if (params.bottomMargin == PX_1) {
                params.bottomMargin = PX_UNIT
            }
        }
        return params
    }
}