package com.jang.mvvmjangstagram.model

data class ContentModel(
    var explain : String? = null, //사진 촬영
    var imageUrl : String? = null, //사진 주소
    var uid : String? = null, //유저 시퀀스값
    var userId : String? = null, //youe@icloud.com
    var timestamp : Long? = null //업로드 시간
    var favoriteCount : Int? = null, //좋아요 카운트
    var favorites : MutableMap<String, Boolean> = HashMap()
){
    data class Comment(
        var uid : String? = null, //유저 시퀀스값
        var userId : String? = null, //youe@icloud.com
        var comment : String? = null, //댓글
        var timestamp : Long? = null //댓글 시간
    )
}
