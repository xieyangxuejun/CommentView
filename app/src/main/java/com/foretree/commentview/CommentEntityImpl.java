package com.foretree.commentview;

import com.foretree.commment.bean.ICommentEntity;

/**
 * Created by silen on 01/12/2017.
 */

public class CommentEntityImpl implements ICommentEntity<CommentBean> {
    private CommentBean mBean;

    public CommentEntityImpl(CommentBean bean) {
        this.mBean = bean;
    }

    @Override
    public CommentBean getData() {
        return mBean;
    }

    @Override
    public String getContent() {
        return mBean.getContent();
    }

    @Override
    public int getUserID() {
        return mBean.getUserId();
    }

    @Override
    public int getToUserID() {
        return mBean.getToUserId();
    }

    @Override
    public String getNickName() {
        return mBean.getUser().getNickname();
    }

    @Override
    public String getToNickName() {
        return mBean.getToNickName();
    }

    @Override
    public String getAvatarUrl() {
        return mBean.getUser().getHeadimage();
    }

    @Override
    public String getCreateAt() {
        return mBean.getCreateAt();
    }

    @Override
    public short getType() {
        return mBean.getToCommentId() == 0 ? ICommentEntity.TYPE_COMMENT : ICommentEntity.TYPE_REPLY;
    }
}
