package com.foretree.commentview

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import com.foretree.commment.callback.OnCommentTouchListener
import com.foretree.commment.twitter.Type
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), OnCommentTouchListener<CommentBean> {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setCommentListView()
    }

    private fun setCommentListView() {
        val commentBean = CommentBean()
        val commentEntity = CommentEntityImpl(commentBean)
        tv_comment.setText(commentEntity, this)
    }

    override fun onClick(v: View?, item: CommentBean?) {
        Toast.makeText(this, item!!.content, Toast.LENGTH_SHORT).show()
    }

    override fun onLongClick(v: View?, item: CommentBean?) {
        Toast.makeText(this, item!!.content, Toast.LENGTH_SHORT).show()
    }

    override fun onItemClick(v: View?, type: Type?, text: String?) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
    }
}