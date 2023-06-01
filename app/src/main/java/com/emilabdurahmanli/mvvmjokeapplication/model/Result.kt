package com.emilabdurahmanli.mvvmjokeapplication.model

data class Result(var error : Boolean, var category : String, var type : String, var setup : String, var delivery : String, var flags : Flags,var id : Int, var safe : Boolean, var lang : String)
