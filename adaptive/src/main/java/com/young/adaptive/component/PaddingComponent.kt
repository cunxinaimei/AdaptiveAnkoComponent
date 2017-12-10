package com.young.adaptive.component

import android.view.View
import com.young.adaptive.AdaptiveLayoutContext
import com.young.adaptive.IComponent
import com.young.adaptive.PX_1
import com.young.adaptive.PX_UNIT

/**
 * Created by Young on 2017/12/10.
 */
class PaddingComponent : IComponent {
    override fun adaptive(view: View, screenWidth: Int, screenHeight: Int, designWidth: Int, designHeight: Int) {
        var paddingLeft = 0
        if (view.paddingLeft > 0) {
            paddingLeft = AdaptiveLayoutContext.calculate(designWidth, screenWidth, view.paddingLeft)
        } else if (view.paddingLeft == PX_1) {
            paddingLeft = PX_UNIT
        }

        var paddingTop = 0
        if (view.paddingTop > 0) {
            paddingTop = AdaptiveLayoutContext.calculate(designHeight, screenHeight, view.paddingTop)
        } else if (view.paddingTop == PX_1) {
            paddingTop = PX_UNIT
        }

        var paddingRight = 0
        if (view.paddingRight > 0) {
            paddingRight = AdaptiveLayoutContext.calculate(designWidth, screenWidth, view.paddingRight)
        } else if (view.paddingRight == PX_1) {
            paddingRight = PX_UNIT
        }

        var paddingBottom = 0
        if (view.paddingBottom > 0) {
            paddingBottom = AdaptiveLayoutContext.calculate(designHeight, screenHeight, view.paddingBottom)
        } else if (view.paddingBottom == PX_1) {
            paddingBottom = PX_UNIT
        }

        view.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom)
    }
}