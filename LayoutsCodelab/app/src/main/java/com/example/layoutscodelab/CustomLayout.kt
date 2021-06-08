package com.example.layoutscodelab

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.AlignmentLine
import androidx.compose.ui.layout.FirstBaseline
import androidx.compose.ui.layout.layout
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.layoutscodelab.ui.theme.LayoutsCodelabTheme

//Compose 中的布局原则: 如果一个元素有子元素，它可以测量它们中的每一个来帮助确定它自己的大小。
//一旦一个元素报告了它自己的大小，它就有机会相对于自身放置它的子元素。
//Compose UI 不允许多次测量,单遍测量有利于提高性能，使 Compose 能够有效地处理深层 UI 树


//自定义layout修饰符的常见结构如下：
//fun Modifier.customLayoutModifier(...) = Modifier.layout { measurable, constraints ->
//    ...
//measurable：要测量和放置的孩子
//constraints: 孩子的宽度和高度的最小值和最大值
//})


fun Modifier.firstBaselineToTop(
    firstBaselineToTop: Dp
) = this.then(
    layout { measurable, constraints ->
        val placeable = measurable.measure(constraints)
        // Check the composable has a first baseline
        check(placeable[FirstBaseline] != AlignmentLine.Unspecified)
        val firstBaseline = placeable[FirstBaseline]

        // Height of the composable with padding - first baseline
        // placeableY为占据的实际高度
        val placeableY = firstBaselineToTop.roundToPx() - firstBaseline
        val height = placeable.height + placeableY
        //重新设置 计算出来的height
        layout(placeable.width, height) {
            // Where the composable gets placed
            placeable.placeRelative(0, placeableY)
        }
    }
)

@Preview
@Composable
fun TextWithPaddingToBaselinePreview() {
    LayoutsCodelabTheme {
        Text("Hi there!", Modifier.firstBaselineToTop(32.dp))
    }
}

@Preview
@Composable
fun TextWithNormalPaddingPreview() {
    LayoutsCodelabTheme {
        Text("Hi there!", Modifier.padding(top = 32.dp))
    }
}