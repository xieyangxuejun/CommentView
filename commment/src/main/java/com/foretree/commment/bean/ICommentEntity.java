package com.foretree.commment.bean;

/**
 * 代理评论数据类
 * Created by silen on 01/12/2017.
 */

public interface ICommentEntity<T> {
    short TYPE_COMMENT = 110;
    short TYPE_REPLY = 111;

    //获取完整数据方便传递
    T getData();
    String getContent();
    //评论谁
    int getUserID();
    int getToUserID();
    //昵称
    String getNickName();
    String getToNickName();
    //头像
    String getAvatarUrl();
    //时间
    String getCreateAt();

    //是否评论和回复
    short getType();
}
