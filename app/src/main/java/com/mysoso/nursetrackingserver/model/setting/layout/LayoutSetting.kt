package com.mysoso.nursetrackingserver.model.setting.layout

data class LayoutSetting (
    var version:String,
    val layout_type:Int,
    val roomX:Int,
    val roomY:Int
)