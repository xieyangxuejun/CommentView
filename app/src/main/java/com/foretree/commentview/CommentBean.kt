package com.foretree.commentview

import com.foretree.commment.Constants

/**
 * Created by silen on 01/12/2017.
 */

data class CommentBean(var id: Int = 1, var nickName: String = "谢杨学君", var toNickName: String = "小罗",
                       var content: String = Constants.TEST_TEXT, var userId: Int = 100,
                       var user: UserBean = UserBean(1, "谢杨学君", "","2017"),
                       var toUserId: Int = 101, var toCommentId: Int = 0, var createAt: String = "")

data class UserBean(var id: Int, var nickname: String, var headimage: String, var created_at: String)