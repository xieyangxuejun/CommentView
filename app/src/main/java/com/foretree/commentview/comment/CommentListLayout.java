//package com.foretree.commentview.comment;
//
//import android.content.Context;
//import android.util.AttributeSet;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.animation.Animation;
//import android.view.animation.TranslateAnimation;
//import android.widget.FrameLayout;
//import android.widget.LinearLayout;
//import android.widget.TextView;
//
//import com.foretree.commentview.R;
//
//public class CommentListLayout extends LinearLayout {
//    LinearLayout a;
//    private View b;
//    private Context c;
//    private int d;
//    private int e;
//    private final int f;
//    private QZonePullToRefreshListView g;
//    private TextView h;
//    private FrameLayout i;
//    private View j;
//    private TranslateAnimation k;
//    private TranslateAnimation l;
//    private volatile boolean m;
//
//    public CommentListLayout(Context context, int i, int i2) {
//        this(context, null);
//        this.d = i;
//        this.e = i2;
//    }
//
//    public CommentListLayout(Context context, AttributeSet attributeSet) {
//        super(context, attributeSet);
//        this.d = -1;
//        this.e = ViewUtils.getScreenHeight() / 2;
//        this.f = 300;
//        this.m = false;
//        this.c = context;
//        c();
//    }
//
//    public QZonePullToRefreshListView getListView() {
//        return this.g;
//    }
//
//    private void c() {
//        LayoutInflater from = LayoutInflater.from(this.c);
//        if (from != null) {
//            this.b = from.inflate(R.layout.qzone_widget_feed_detail_comment_view, null);
//            this.g = (QZonePullToRefreshListView) this.b.findViewById(R.id.mainContentListView);
//            addView(this.b, new LayoutParams(this.d, this.e));
//            this.a = (LinearLayout) this.b.findViewById(R.id.qzone_detail_rapidcomment_container);
//            this.h = (TextView) this.b.findViewById(R.id.textViewCommentTitle);
//            this.i = (FrameLayout) this.b.findViewById(R.id.btnClose);
//            this.j = this.b.findViewById(R.id.progressBarForGetComments);
//            this.j.setVisibility(4);
//            setVisible(false);
//        }
//    }
//
//    public synchronized void a() {
//        if (!(getVisibility() == 0 || this.m)) {
//            this.m = true;
//            startAnimation(getShowAnimation());
//        }
//    }
//
//    public synchronized void b() {
//        if (getVisibility() == 0 && !this.m) {
//            this.m = true;
//            startAnimation(getHideAnimation());
//        }
//    }
//
//    public void setVisible(boolean z) {
//        setVisibility(z ? 0 : 4);
//    }
//
//    public void a(boolean z) {
//        if (this.j != null) {
//            this.j.setVisibility(z ? 0 : 4);
//        }
//    }
//
//    public void setOnClickListenerForCommentContainer(OnClickListener onClickListener) {
//        if (this.a != null) {
//            this.a.setOnClickListener(onClickListener);
//        }
//    }
//
//    public void setOnClickListenerForCloseBtn(OnClickListener onClickListener) {
//        if (this.i != null) {
//            this.i.setOnClickListener(onClickListener);
//        }
//    }
//
//    public void setCommentNum(int i) {
//        if (this.h != null) {
//            CharSequence charSequence = "评论";
//            if (i > 0) {
//                charSequence = String.format("评论(%d)", new Object[]{Integer.valueOf(i)});
//            }
//            this.h.setText(charSequence);
//        }
//    }
//
//    public Animation getShowAnimation() {
//        if (this.k == null) {
//            this.k = new TranslateAnimation(0.0f, 0.0f, (float) this.e, 0.0f);
//            this.k.setDuration(300);
//            this.k.setAnimationListener(new Animation.AnimationListener() {
//
//                public void onAnimationStart(Animation animation) {
//                }
//
//                public void onAnimationEnd(Animation animation) {
//                    CommentListLayout.this.post(new Runnable() {
//                        public void run() {
//                            CommentListLayout.this.setVisible(true);
//                        }
//                    });
//                    CommentListLayout.this.m = false;
//                }
//
//                public void onAnimationRepeat(Animation animation) {
//                }
//            });
//        }
//        return this.k;
//    }
//
//    public Animation getHideAnimation() {
//        if (this.l == null) {
//            this.l = new TranslateAnimation(0.0f, 0.0f, 0.0f, (float) this.e);
//            this.l.setDuration(300);
//            this.l.setAnimationListener(new Animation.AnimationListener() {
//
//                public void onAnimationStart(Animation animation) {
//                }
//
//                public void onAnimationEnd(Animation animation) {
//                    CommentListLayout.this.post(new Runnable() {
//
//                        public void run() {
//                            CommentListLayout.this.setVisible(false);
//                        }
//                    });
//                    CommentListLayout.this.m = false;
//                }
//
//                public void onAnimationRepeat(Animation animation) {
//                }
//            });
//        }
//        return this.l;
//    }
//}