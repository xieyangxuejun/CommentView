//package com.foretree.commentview.comment;
//
//public class CommentListBaseController implements main {
//    private boolean A = false;
//    private boolean B = false;
//    private boolean C = false;
//    private boolean D;
//    private OnCommentViewDismissListener E;
//    private boolean F = false;
//    private int G = 0;
//    private Comment H = null;
//    private Reply I = null;
//    private OnClickListener J = new OnClickListener(this) {
//        final /* synthetic */ CommentListBaseController a;
//
//        {
//            this.a = r2;
//            Zygote.class.getName();
//        }
//
//        public void onClick(View view) {
//            switch (this.a.G) {
//                case 0:
//                    if (this.a.H == null) {
//                        ToastUtils.show("该条评论不存在或已被删除", 3, this.a.k);
//                        break;
//                    } else {
//                        this.a.a(this.a.q, this.a.k().a(), this.a.H);
//                        break;
//                    }
//                case 1:
//                    if (this.a.I == null) {
//                        ToastUtils.show("该条回复不存在或已被删除", 3, this.a.k);
//                        break;
//                    } else {
//                        this.a.a(this.a.q, this.a.k().a(), this.a.I, this.a.H, 0);
//                        break;
//                    }
//            }
//            if (this.a.b != null) {
//                this.a.b.dismiss();
//            }
//        }
//    };
//    private ListAdapter K;
//    protected int a = 0;
//    protected ActionSheetDialog b;
//    protected long c;
//    protected int d;
//    protected String e;
//    protected String f;
//    protected String g;
//    protected String h;
//    protected String i;
//    protected Map<Integer, String> j;
//    protected QZoneBaseActivity k;
//    protected IFeedUIBusiness l;
//    protected MergeListAdapter m;
//    protected AbsFeedDetailCommentAdapter n;
//    protected AbsFeedDetailCommentAdapter o;
//    protected AbsDetailWidgetAdapter p;
//    protected Handler q;
//    protected User r;
//    protected BusinessFeedData s;
//    QZoneServiceCallback t;
//    protected CommentElementClickListener u;
//    private QzoneCommentService v;
//    private CommentListLayout w;
//    private int x;
//    private QZonePullToRefreshListView y;
//    private boolean z = false;
//
//    /* compiled from: ProGuard */
//    public interface OnCommentViewDismissListener {
//        void a();
//    }
//
//    protected CommentListBaseController(QZoneBaseActivity qZoneBaseActivity) {
//        Zygote.class.getName();
//        this.k = qZoneBaseActivity;
//        this.q = new Handler(this, Looper.getMainLooper()) {
//            final /* synthetic */ CommentListBaseController a;
//
//            public void handleMessage(Message message) {
//                super.handleMessage(message);
//                this.a.a(message);
//                QZLog.b("CommentListBaseController", 0, "-----------------get msg from QZoneDetailSevice.");
//            }
//        };
//        this.t = new QZoneServiceCallback(this) {
//            final /* synthetic */ CommentListBaseController a;
//
//            {
//                this.a = r2;
//                Zygote.class.getName();
//            }
//
//            public void onResult(QZoneResult qZoneResult) {
//                this.a.a(qZoneResult);
//            }
//        };
//        this.l = ((IFeedUI) FeedProxy.g.getUiInterface()).a(LikeFeedType.FriendFeed, qZoneBaseActivity, null);
//        k();
//    }
//
//    public static CommentListBaseController a(QZoneBaseActivity qZoneBaseActivity, int i) {
//        switch (i) {
//            case 1:
//                return new CommentListBaseController(qZoneBaseActivity);
//            case 2:
//                return new CommentListBaseController(qZoneBaseActivity);
//            default:
//                return new CommentListBaseController(qZoneBaseActivity);
//        }
//    }
//
//    public Handler a() {
//        return this.q;
//    }
//
//    public CommentListBaseController a(Bundle bundle) {
//        u();
//        c(bundle);
//        return this;
//    }
//
//    private void c(Bundle bundle) {
//        y();
//        t();
//        b(bundle);
//    }
//
//    private void t() {
//        if (this.w == null) {
//            this.w = new CommentListLayout(this.k, -1, ViewUtils.getScreenHeight() / 2);
//            this.y = this.w.getListView();
//            this.y.setOnRefreshListener(new PullToRefreshBase$OnRefreshListener<ListView>(this) {
//                final /* synthetic */ CommentListBaseController a;
//
//                {
//                    this.a = r2;
//                    Zygote.class.getName();
//                }
//
//                public void onRefresh(PullToRefreshBase<ListView> pullToRefreshBase) {
//                    this.a.l();
//                }
//
//                public void onRefreshComplete(PullToRefreshBase<ListView> pullToRefreshBase) {
//                }
//            });
//            this.y.setOnScrollListener(new OnScrollListener(this) {
//                final /* synthetic */ CommentListBaseController a;
//
//                {
//                    this.a = r2;
//                    Zygote.class.getName();
//                }
//
//                public void onScrollStateChanged(AbsListView absListView, int i) {
//                    switch (i) {
//                        case 0:
//                            if (((ListView) this.a.y.getRefreshableView()).getLastVisiblePosition() >= (((ListView) this.a.y.getRefreshableView()).getCount() - ((ListView) this.a.y.getRefreshableView()).getHeaderViewsCount()) - 1) {
//                                if (QZLog.a()) {
//                                    QZLog.b("CommentListBaseController", 0, "---getMoreComment");
//                                }
//                                this.a.m();
//                                return;
//                            }
//                            return;
//                        default:
//                            return;
//                    }
//                }
//
//                public void onScroll(AbsListView absListView, int i, int i2, int i3) {
//                }
//            });
//            this.C = true;
//            this.w.setOnClickListenerForCommentContainer(new OnClickListener(this) {
//                final /* synthetic */ CommentListBaseController a;
//
//                {
//                    this.a = r2;
//                    Zygote.class.getName();
//                }
//
//                public void onClick(View view) {
//                    this.a.r();
//                }
//            });
//            this.w.setOnClickListenerForCloseBtn(new OnClickListener(this) {
//                final /* synthetic */ CommentListBaseController a;
//
//                {
//                    this.a = r2;
//                    Zygote.class.getName();
//                }
//
//                public void onClick(View view) {
//                    this.a.d();
//                }
//            });
//        }
//        ((ListView) this.y.getRefreshableView()).setAdapter(f());
//    }
//
//    protected void b(Bundle bundle) {
//        this.c = bundle.getLong("uin");
//        this.d = bundle.getInt("appid");
//        this.e = bundle.getString("sub_id");
//        this.f = bundle.getString("cell_id");
//        this.g = bundle.getString("ugc_key");
//        this.h = bundle.getString("feed_id");
//        MapParcelable mapParcelable = (MapParcelable) bundle.getParcelable("business_params");
//        if (mapParcelable != null) {
//            this.j = mapParcelable.getSingleMap();
//        }
//        if (this.j != null) {
//            this.i = (String) this.j.get(Integer.valueOf(2));
//        }
//        this.x = bundle.getInt("comment_num");
//        this.B = true;
//        if (!TextUtils.isEmpty(this.g) && !TextUtils.isEmpty(this.h) && this.d == 311 && QZLog.a()) {
//            QZLog.a("CommentListBaseController", 0, "-------ugcKey:" + this.g + ",feedId:" + this.h);
//        }
//    }
//
//    private void u() {
//        if (this.n != null) {
//            this.n.a(null);
//        }
//        if (this.o != null) {
//            this.o.a(null);
//        }
//        if (this.p != null) {
//            this.p.a(Boolean.valueOf(false));
//        }
//        this.c = 0;
//        this.d = 0;
//        this.e = "";
//        this.f = "";
//        this.g = "";
//        this.h = "";
//        this.j = null;
//        this.B = false;
//        this.v = null;
//        this.x = 0;
//        this.w.setCommentNum(0);
//        this.D = false;
//    }
//
//    public void a(OnCommentViewDismissListener onCommentViewDismissListener) {
//        this.E = onCommentViewDismissListener;
//    }
//
//    public CommentListLayout b() {
//        if (this.w == null) {
//            t();
//        }
//        return this.w;
//    }
//
//    public void c() {
//        if (!this.C) {
//            t();
//        }
//        this.w.a();
//        l();
//        ClickReport.g().report("34", "1");
//    }
//
//    public void d() {
//        this.w.b();
//        if (this.E != null) {
//            this.E.a();
//        }
//    }
//
//    public void a(boolean z) {
//        if (this.w != null) {
//            this.w.setVisible(z);
//        }
//    }
//
//    public boolean e() {
//        return this.w.getVisibility() == 0 || this.F;
//    }
//
//    protected MergeListAdapter f() {
//        if (this.m == null) {
//            this.m = new MergeListAdapter();
//            this.m.add(g());
//            this.m.add(h());
//            this.m.add(i());
//        }
//        return this.m;
//    }
//
//    protected AbsFeedDetailCommentAdapter g() {
//        if (this.n == null) {
//            this.n = ((IFeedComponentUI) FeedComponentProxy.g.getUiInterface()).a(this.k, null, j());
//            this.n.f(false);
//            this.n.a(true);
//            this.n.b(false);
//            this.n.i(true);
//            this.n.j(true);
//            this.n.h(true);
//        }
//        if (!(k().a() == null || k().a().getPictureInfo() == null || !k().a().getPictureInfo().isSharingAlbumData())) {
//            this.n.g(true);
//        }
//        return this.n;
//    }
//
//    protected AbsFeedDetailCommentAdapter h() {
//        if (this.o == null) {
//            this.o = ((IFeedComponentUI) FeedComponentProxy.g.getUiInterface()).a(this.k, null, j());
//            this.o.f(false);
//            this.o.a(true);
//            this.o.b(true);
//            this.o.c(true);
//            this.o.d(true);
//            this.n.i(true);
//            this.n.j(true);
//            this.o.h(true);
//        }
//        return this.o;
//    }
//
//    protected AbsDetailWidgetAdapter i() {
//        if (this.p == null) {
//            this.p = ((IFeedComponentUI) FeedComponentProxy.g.getUiInterface()).a(this.k, 2);
//            this.p.a(Boolean.valueOf(false));
//            this.p.a(j());
//        }
//        return this.p;
//    }
//
//    public CommentElementClickListener j() {
//        if (this.u == null) {
//            this.u = new CommentElementClickListener(this.k, this);
//        }
//        return this.u;
//    }
//
//    public QzoneCommentService k() {
//        if (this.v == null) {
//            this.v = new QzoneCommentService();
//        }
//        return this.v;
//    }
//
//    public void l() {
//        if (v()) {
//            QZLog.b("CommentListBaseController", "----network not link.");
//            return;
//        }
//        Message obtain = Message.obtain();
//        obtain.what = 1;
//        a().removeMessages(1);
//        a().sendMessageDelayed(obtain, 500);
//        if (!this.D && g().getCount() + h().getCount() == 0) {
//            this.w.a(true);
//        }
//    }
//
//    public void m() {
//        Message obtain = Message.obtain();
//        obtain.what = 2;
//        a().removeMessages(2);
//        a().sendMessageDelayed(obtain, 500);
//    }
//
//    protected void n() {
//        if (k().e > 0 && !k().a) {
//            k().a(this.c, this.d, this.f, this.e, k().d, 29, this.j, 1048578, false, this.t);
//        } else if (k().g > 0 && !k().a) {
//            k().a(this.c, this.d, this.f, this.e, k().f, 29, this.j, 1048579, this.t);
//        }
//    }
//
//    protected void o() {
//        k().a(this.c, this.d, this.f, this.e, this.j, k().a(), this.t);
//    }
//
//    protected void a(Handler handler, BusinessFeedData businessFeedData, Comment comment) {
//        ((IOperationService) OperationProxy.g.getServiceInterface()).a(businessFeedData, comment, this.t);
//    }
//
//    protected void a(Handler handler, BusinessFeedData businessFeedData, Reply reply, Comment comment, int i) {
//        ((IOperationService) OperationProxy.g.getServiceInterface()).a(businessFeedData, reply, comment, this.t);
//    }
//
//    protected ActionSheetDialog a(int i, Comment comment, Reply reply) {
//        this.G = i;
//        this.H = comment;
//        this.I = reply;
//        if (this.b == null) {
//            this.b = new ActionSheetDialog(this.k, R.style.TransparentWithTitle);
//            this.b.addButton("删除", 1, this.J);
//        }
//        return this.b;
//    }
//
//    public void a(Message message) {
//        switch (message.what) {
//            case 1:
//                o();
//                break;
//            case 2:
//                n();
//                break;
//            case 589825:
//                QZLog.a("CommentListBaseController", 0, "---onHandleMessage render");
//                a(k().a());
//                break;
//        }
//        a(QZoneResult.b(message));
//    }
//
//    protected void a(QZoneResult qZoneResult) {
//        if (qZoneResult != null) {
//            final Bundle bundle;
//            switch (qZoneResult.a) {
//                case 999900:
//                    QZLog.a("CommentListBaseController", 0, "---onServiceResult MSG_DETAIL_GET_DATA_COMPLETE");
//                    this.w.a(false);
//                    b(qZoneResult);
//                    return;
//                case 999905:
//                    if (!qZoneResult.e()) {
//                        ToastUtils.show(this.k, qZoneResult.g());
//                    }
//                    QZLog.a("CommentListBaseController", 0, "---onServiceResult MSG_WRITE_COMMENT_FINISH");
//                    a().post(new Runnable(this) {
//                        final /* synthetic */ CommentListBaseController a;
//
//                        {
//                            this.a = r2;
//                            Zygote.class.getName();
//                        }
//
//                        public void run() {
//                            if (this.a.k().a() != null) {
//                                if (this.a.k().a().getCommentInfo() != null) {
//                                    this.a.g().a(this.a.k().a().getCommentInfo().commments);
//                                }
//                                if (this.a.k().a().getCommentEssence() != null) {
//                                    this.a.h().a(this.a.k().a().getCommentEssence().commments);
//                                }
//                            }
//                            this.a.w();
//                            this.a.f().notifyDataSetChanged();
//                        }
//                    });
//                    try {
//                        a().postDelayed(new Runnable(this) {
//                            final /* synthetic */ CommentListBaseController a;
//
//                            {
//                                this.a = r2;
//                                Zygote.class.getName();
//                            }
//
//                            public void run() {
//                                ((ListView) this.a.y.getRefreshableView()).setSelection(Math.max(0, (((ListView) this.a.y.getRefreshableView()).getHeaderViewsCount() + this.a.f().getCount()) - 1));
//                            }
//                        }, 400);
//                        return;
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                        return;
//                    }
//                case 999907:
//                    if (!qZoneResult.e()) {
//                        ToastUtils.show(this.k, qZoneResult.g());
//                    }
//                    QZLog.a("CommentListBaseController", 0, "---onServiceResult MSG_WRITE_REPLAY_FINISH");
//                    a().post(new Runnable(this) {
//                        final /* synthetic */ CommentListBaseController a;
//
//                        {
//                            this.a = r2;
//                            Zygote.class.getName();
//                        }
//
//                        public void run() {
//                            if (this.a.k().a() != null) {
//                                if (this.a.k().a().getCommentInfo() != null) {
//                                    this.a.g().a(this.a.k().a().getCommentInfo().commments);
//                                }
//                                if (this.a.k().a().getCommentEssence() != null) {
//                                    this.a.h().a(this.a.k().a().getCommentEssence().commments);
//                                }
//                            }
//                            this.a.w();
//                            this.a.f().notifyDataSetChanged();
//                        }
//                    });
//                    return;
//                case 999909:
//                    if (qZoneResult != null && !qZoneResult.e()) {
//                        ToastUtils.show(this.k, !TextUtils.isEmpty(qZoneResult.g()) ? qZoneResult.g() : "删除失败");
//                        return;
//                    }
//                    return;
//                case 999927:
//                    if (qZoneResult == null || !(qZoneResult.e() || qZoneResult.f() == 0)) {
//                        a(false, "");
//                        QZLog.a("CommentListBaseController", 0, "---onServiceResult MSG_GET_MORE_COMMENT_SUCCESS failed");
//                        return;
//                    }
//                    QZLog.a("CommentListBaseController", 0, "---onServiceResult MSG_GET_MORE_COMMENT_SUCCESS success");
//                    a(true, "");
//                    bundle = (Bundle) qZoneResult.a();
//                    if (bundle != null) {
//                        a().post(new Runnable(this) {
//                            final /* synthetic */ CommentListBaseController b;
//
//                            public void run() {
//                                BusinessFeedData businessFeedData = (BusinessFeedData) ParcelableWrapper.getDataFromBudle(bundle, BusinessFeedData.STORE_KEY);
//                                if (businessFeedData != null) {
//                                    this.b.g().a(businessFeedData.getCommentInfo().commments);
//                                    this.b.w();
//                                }
//                                this.b.f().notifyDataSetChanged();
//                            }
//                        });
//                        return;
//                    }
//                    return;
//                case 1000243:
//                    if (qZoneResult == null || !qZoneResult.e()) {
//                        a(false, "");
//                        QZLog.a("CommentListBaseController", 0, "---onServiceResult MSG_GET_MORE_COMMENT_ESSENCE failed");
//                        return;
//                    }
//                    QZLog.a("CommentListBaseController", 0, "---onServiceResult MSG_GET_MORE_COMMENT_ESSENCE success");
//                    a(true, "");
//                    bundle = (Bundle) qZoneResult.a();
//                    if (bundle != null) {
//                        a().post(new Runnable(this) {
//                            final /* synthetic */ CommentListBaseController b;
//
//                            public void run() {
//                                BusinessFeedData businessFeedData = (BusinessFeedData) ParcelableWrapper.getDataFromBudle(bundle, BusinessFeedData.STORE_KEY);
//                                if (!(businessFeedData == null || businessFeedData.getCommentEssence() == null)) {
//                                    this.b.h().a(businessFeedData.getCommentEssence().commments);
//                                    this.b.w();
//                                }
//                                this.b.f().notifyDataSetChanged();
//                            }
//                        });
//                        return;
//                    }
//                    return;
//                case 1000471:
//                    if (qZoneResult == null) {
//                        return;
//                    }
//                    if (qZoneResult.e()) {
//                        QZLog.a("CommentListBaseController", 0, "---onServiceResult MSG_WRITE_COMMENT_LIKE_FINISH success");
//                        return;
//                    }
//                    QZLog.a("CommentListBaseController", 0, "---onServiceResult MSG_WRITE_COMMENT_LIKE_FINISH failed");
//                    ToastUtils.show(this.k, qZoneResult.g());
//                    return;
//                default:
//                    return;
//            }
//        }
//    }
//
//    private void b(QZoneResult qZoneResult) {
//        if (qZoneResult.e() || qZoneResult.f() == 0) {
//            a(true, "");
//            Bundle bundle = (Bundle) qZoneResult.a();
//            if (bundle == null || ((BusinessFeedData) ParcelableWrapper.getDataFromBudle(bundle, BusinessFeedData.STORE_KEY)) != null) {
//                a(k().a());
//                if (this.d == 334) {
//                    if (LoginManager.getInstance().getUin() == this.c) {
//                        this.z = true;
//                    }
//                    if (!(k() == null || k().a() == null || k().a().getUser().uin != LoginManager.getInstance().getUin())) {
//                        this.A = true;
//                    }
//                }
//                a(f());
//            } else {
//                return;
//            }
//        }
//        a(false, qZoneResult.g());
//        if ((qZoneResult.f() == -4403 || qZoneResult.f() == -4404) && QZLog.a()) {
//            QZLog.b("CommentListBaseController", 0, "visit forbidden result: " + qZoneResult.e() + " resultCode: " + qZoneResult.f() + " result.msg: " + qZoneResult.g());
//        }
//        if (QZLog.a()) {
//            QZLog.b("CommentListBaseController", 0, "this log is for qzonetest : comment detail is loading complete, result: " + qZoneResult.e() + " resultCode: " + qZoneResult.f() + " result.msg: " + qZoneResult.g());
//        }
//    }
//
//    private void a(ListAdapter listAdapter) {
//        if (this.y.getRefreshableView() != null && this.K != listAdapter) {
//            ((ListView) this.y.getRefreshableView()).setAdapter(listAdapter);
//            this.K = listAdapter;
//        }
//    }
//
//    private void a(boolean z, String str) {
//        if (this.y == null) {
//            return;
//        }
//        if (z) {
//            this.y.a(true, "刷新成功");
//        } else {
//            this.y.a(false, "刷新失败");
//        }
//    }
//
//    private boolean v() {
//        if (NetworkState.g().isNetworkConnected()) {
//            return false;
//        }
//        ToastUtils.show(this.k, R.string.qzone_network_no_link);
//        return true;
//    }
//
//    public void a(BusinessFeedData businessFeedData) {
//        if (businessFeedData != null && businessFeedData.getUser() != null) {
//            if (businessFeedData.getUser().uin != 0 || businessFeedData.isAdFeeds()) {
//                x();
//                if (this.C) {
//                    QZLog.a("CommentListBaseController", 0, "--do render");
//                    this.s = businessFeedData;
//                    j().a(businessFeedData);
//                    if (!(businessFeedData.getCellUserInfo().getUser() == null || TextUtils.isEmpty(businessFeedData.getCellUserInfo().getUser().qzoneDesc))) {
//                        try {
//                            JSONObject jSONObject = new JSONObject(businessFeedData.getCellUserInfo().getUser().qzoneDesc);
//                            String decode = URLDecoder.decode(jSONObject.optString("url"), "UTF-8");
//                            businessFeedData.getCellUserInfo().getUser().qzoneDesc = Patterns.CUSTOM_URL_PREFIX + decode + ",text:" + jSONObject.optString("text") + "}";
//                        } catch (Throwable e) {
//                            QZLog.a("CommentListBaseController", "render", e);
//                        }
//                    }
//                    this.y.setVisibility(0);
//                    g().a(businessFeedData.getCommentInfo().commments);
//                    if (businessFeedData.getCommentEssence() != null) {
//                        h().a(businessFeedData.getCommentEssence().commments);
//                    }
//                    w();
//                    this.w.a(false);
//                    switch (this.d) {
//                        case 2:
//                            QZLog.b("CommentListBaseController", "---render AppidConsts.BLOG");
//                            break;
//                        case 334:
//                            g().c(false);
//                            h().c(false);
//                            QZLog.b("CommentListBaseController", "---render AppidConsts.MESSAGE");
//                            break;
//                    }
//                    a(f());
//                    b().setCommentNum(p());
//                }
//            }
//        }
//    }
//
//    private void w() {
//        this.D = g().getCount() + h().getCount() == 0;
//        i().a(Boolean.valueOf(this.D));
//    }
//
//    public int p() {
//        int i;
//        int i2 = 0;
//        if (this.s != null) {
//            if (this.s.getCommentInfo() != null) {
//                i = this.s.getCommentInfo().commentNum;
//            } else {
//                i = 0;
//            }
//            if (this.s.getCommentEssence() != null) {
//                i2 = i;
//                i = this.s.getCommentEssence().commentNum;
//            } else {
//                i2 = i;
//                i = 0;
//            }
//        } else {
//            i = 0;
//        }
//        return i > 0 ? i : i2;
//    }
//
//    private boolean x() {
//        if (!this.B || this.C) {
//            return false;
//        }
//        t();
//        this.C = true;
//        return true;
//    }
//
//    public QZonePullToRefreshListView q() {
//        return this.y;
//    }
//
//    public void r() {
//        BusinessFeedData a = k().a();
//        if (!(a == null || a.getFeedCommInfo() == null)) {
//            boolean isFeedCommentInsertImage = a.isFeedCommentInsertImage();
//            a(this.k, "评论", "", FeedActionPanelActivity.l, 10001, Integer.valueOf(0), ParcelableWrapper.obtain(k().a()), "", 0, 500, null, "", "", false, ActionPanelCacheKey.b, isFeedCommentInsertImage, k().a().getFeedCommInfo().appid, a.getFeedCommInfo().isPrivateFeed(), false, false);
//        }
//        ClickReport.g().report("34", "2");
//    }
//
//    protected void a(final BaseAdapter baseAdapter) {
//        a().post(new Runnable(this) {
//            final /* synthetic */ CommentListBaseController b;
//
//            public void run() {
//                if (baseAdapter != null) {
//                    baseAdapter.notifyDataSetChanged();
//                }
//            }
//        });
//    }
//
//    public void onEventUIThread(Event event) {
//        if (DetailService.a.equals(event.source.getName()) || QzoneCommentService.class.getName().equals(event.source.getName())) {
//            switch (event.what) {
//                case 0:
//                    a(k().a());
//                    f().notifyDataSetChanged();
//                    return;
//                default:
//                    return;
//            }
//        }
//    }
//
//    private void y() {
//        EventCenter.getInstance().addUIObserver(this, QzoneCommentService.class.getName(), new int[]{0, 1, 2});
//    }
//
//    private void z() {
//        EventCenter.getInstance().removeObserver(this);
//    }
//
//    public void s() {
//        z();
//        ThreadManager.executeOnSubThread(new Runnable(this) {
//            final /* synthetic */ CommentListBaseController a;
//
//            {
//                this.a = r2;
//                Zygote.class.getName();
//            }
//
//            public void run() {
//                this.a.k().b();
//            }
//        });
//    }
//
//    public void a(int i, int i2, Intent intent) {
//        if ((i == 10001 || i == 10000) && this.F) {
//            a().postDelayed(new Runnable(this) {
//                final /* synthetic */ CommentListBaseController a;
//
//                {
//                    this.a = r2;
//                    Zygote.class.getName();
//                }
//
//                public void run() {
//                    this.a.F = false;
//                    this.a.b().setVisible(true);
//                }
//            }, 100);
//        }
//        if (i2 != 0) {
//            String str = "";
//            BusinessFeedData a = k().a();
//            int i3 = i == 101 ? 1 : 0;
//            QZoneBaseActivity qZoneBaseActivity;
//            BusinessFeedData businessFeedData;
//            CellPictureInfo cellPictureInfo;
//            switch (i) {
//                case 100:
//                case 101:
//                    qZoneBaseActivity = this.k;
//                    if (i2 == -1) {
//                        Comment comment;
//                        String stringExtra = intent.getStringExtra("contentIntentKey");
//                        String stringExtra2 = intent.getStringExtra("originalContentIntentKey");
//                        int intValue = ((Integer) intent.getSerializableExtra("extraIntentKey")).intValue();
//                        businessFeedData = (BusinessFeedData) ParcelableWrapper.getDataFromeIntent(intent, "extraIntentKeyParcelable");
//                        if (i3 == 0) {
//                            if (!(businessFeedData == null || businessFeedData.getCommentInfo() == null || businessFeedData.getCommentInfo().commments == null)) {
//                                if (intValue <= businessFeedData.getCommentInfo().commments.size() - 1) {
//                                    Comment comment2;
//                                    if (businessFeedData.getCommentInfo().commments != null) {
//                                        comment2 = (Comment) k().a().getCommentInfo().commments.get(intValue);
//                                    } else {
//                                        comment2 = null;
//                                    }
//                                    comment = comment2;
//                                } else {
//                                    return;
//                                }
//                            }
//                            comment = null;
//                        } else {
//                            if (!(i3 != 1 || businessFeedData == null || businessFeedData.getCommentEssence() == null || businessFeedData.getCommentEssence().commments == null)) {
//                                if (intValue <= businessFeedData.getCommentEssence().commments.size() - 1) {
//                                    comment = businessFeedData.getCommentEssence().commments != null ? (Comment) k().a().getCommentEssence().commments.get(intValue) : null;
//                                } else {
//                                    return;
//                                }
//                            }
//                            comment = null;
//                        }
//                        if (comment == null) {
//                            QZLog.b("CommentListBaseController", "onActivityResult: comment is null");
//                            return;
//                        }
//                        long j = comment.user != null ? comment.user.uin : 0;
//                        String str2 = "";
//                        Map map = businessFeedData.getOperationInfo().busiParam;
//                        if (map == null) {
//                            map = new HashMap();
//                        }
//                        switch (this.d) {
//                            case 4:
//                                cellPictureInfo = (CellPictureInfo) FeedDataCalculateHelper.c(a).first;
//                                if (cellPictureInfo != null && cellPictureInfo.pics != null && cellPictureInfo.pics.get(0) != null) {
//                                    str2 = cellPictureInfo.albumid;
//                                    map.put(Integer.valueOf(2), ((PictureItem) cellPictureInfo.pics.get(0)).lloc);
//                                    map.put(Integer.valueOf(1), ((PictureItem) cellPictureInfo.pics.get(0)).sloc);
//                                    break;
//                                }
//                                ToastUtils.show(this.k, R.string.qz_operation_photo_not_exist);
//                                break;
//                            default:
//                                str2 = this.f;
//                                break;
//                        }
//                        Map hashMap = new HashMap();
//                        if (!TextUtils.isEmpty(intent.getStringExtra("extra_key_font_url"))) {
//                            hashMap.put(CellSummary.KEY_FONT_ID, intent.getIntExtra("extra_key_font_id", 0) + "");
//                            hashMap.put(CellSummary.KEY_FONT_TYPE, intent.getIntExtra("extra_key_font_format_type", 0) + "");
//                            hashMap.put(CellSummary.KEY_FONT_URL, intent.getStringExtra("extra_key_font_url"));
//                        }
//                        if (!TextUtils.isEmpty(intent.getStringExtra("extra_key_super_font_json"))) {
//                            hashMap.put("SPARKLE_WORD_ID", intent.getIntExtra("extra_key_super_font_id", 0) + "");
//                            hashMap.put("sparkle_json", intent.getStringExtra("extra_key_super_font_json"));
//                        }
//                        ((IOperationService) OperationProxy.g.getServiceInterface()).a(a, a.getFeedCommInfo().ugckey, a.getFeedCommInfo().appid, this.c, j, str2, comment.commentid, stringExtra, 0, map, this.t, this.r, stringExtra2, a.getFeedCommInfo().feedskey, hashMap);
//                    }
//                    ClickReport.g().report("34", "7");
//                    return;
//                case 10001:
//                    qZoneBaseActivity = this.k;
//                    if (i2 == -1) {
//                        String stringExtra3 = intent.getStringExtra("contentIntentKey");
//                        ArrayList parcelableArrayListExtra = intent.getParcelableArrayListExtra("imageListContentIntentKey");
//                        String stringExtra4 = intent.getStringExtra("originalContentIntentKey");
//                        businessFeedData = (BusinessFeedData) ParcelableWrapper.getDataFromeIntent(intent, "extraIntentKeyParcelable");
//                        boolean booleanExtra = intent.getBooleanExtra("is_private", false);
//                        RapidCommentExpressionInfo rapidCommentExpressionInfo = (RapidCommentExpressionInfo) intent.getParcelableExtra("rapidCommentCommitInfo");
//                        if (businessFeedData != null) {
//                            String str3;
//                            String str4 = "";
//                            if (!(businessFeedData == null || businessFeedData.getIdInfo() == null)) {
//                                str4 = businessFeedData.getIdInfo().cellId;
//                            }
//                            Map map2 = businessFeedData.getOperationInfo().busiParam;
//                            if (map2 == null) {
//                                map2 = new HashMap();
//                            }
//                            switch (this.d) {
//                                case 4:
//                                    cellPictureInfo = (CellPictureInfo) FeedDataCalculateHelper.c(a).first;
//                                    if (cellPictureInfo != null && cellPictureInfo.pics != null && cellPictureInfo.pics.get(0) != null) {
//                                        str3 = cellPictureInfo.albumid;
//                                        map2.put(Integer.valueOf(2), ((PictureItem) cellPictureInfo.pics.get(0)).lloc);
//                                        map2.put(Integer.valueOf(1), ((PictureItem) cellPictureInfo.pics.get(0)).sloc);
//                                        break;
//                                    }
//                                    com.qzonex.utils.log.QZLog.w("CommentListBaseController", "REQUEST_CODE_COMMENT, uin= " + this.c + ", appid= " + this.d + ", pictureInfo= " + cellPictureInfo + ", imageInfos= " + parcelableArrayListExtra);
//                                    str3 = str4;
//                                    break;
//                                default:
//                                    str3 = this.f;
//                                    break;
//                            }
//                            Map hashMap2 = new HashMap();
//                            if (!TextUtils.isEmpty(intent.getStringExtra("extra_key_font_url"))) {
//                                hashMap2.put(CellSummary.KEY_FONT_ID, intent.getIntExtra("extra_key_font_id", 0) + "");
//                                hashMap2.put(CellSummary.KEY_FONT_TYPE, intent.getIntExtra("extra_key_font_format_type", 0) + "");
//                                hashMap2.put(CellSummary.KEY_FONT_URL, intent.getStringExtra("extra_key_font_url"));
//                            }
//                            if (!TextUtils.isEmpty(intent.getStringExtra("extra_key_super_font_json"))) {
//                                hashMap2.put("SPARKLE_WORD_ID", intent.getIntExtra("extra_key_super_font_id", 0) + "");
//                                hashMap2.put("sparkle_json", intent.getStringExtra("extra_key_super_font_json"));
//                            }
//                            a.getPictureInfo();
//                            if (rapidCommentExpressionInfo != null) {
//                                ((IOperationService) OperationProxy.g.getServiceInterface()).a(a, stringExtra3, stringExtra4, this.t, false, 0, booleanExtra, rapidCommentExpressionInfo);
//                            } else {
//                                ((IOperationService) OperationProxy.g.getServiceInterface()).a(a.getFeedCommInfo().ugckey, a.getFeedCommInfo().appid, this.c, str3, stringExtra3, stringExtra4, 0, map2, a.getFeedCommInfo().feedskey, this.t, false, parcelableArrayListExtra, a, booleanExtra, hashMap2);
//                            }
//                            a(k().a());
//                            f().notifyDataSetChanged();
//                            ClickReport.g().report("34", "7");
//                            return;
//                        }
//                        return;
//                    }
//                    return;
//                default:
//                    return;
//            }
//        }
//    }
//
//    protected void a(View view, Object obj) {
//        if (this.d == 334) {
//            r();
//            return;
//        }
//        int i;
//        int i2;
//        Comment comment;
//        Bundle bundle = (Bundle) obj;
//        int i3 = bundle.getInt("position");
//        if (bundle.getInt("position") == 1) {
//            i = bundle.getInt("reply_pos", -1);
//            i2 = bundle.getInt("commenttype", 0);
//        } else {
//            i = bundle.getInt("reply_pos", -1);
//            i2 = bundle.getInt("commenttype", 0);
//        }
//        if (i2 == 0) {
//            if (k().a().getCommentInfo().commments == null || i3 <= k().a().getCommentInfo().commments.size() - 1) {
//                comment = k().a().getCommentInfo().commments != null ? (Comment) k().a().getCommentInfo().commments.get(i3) : null;
//            } else {
//                return;
//            }
//        } else if (i2 != 1) {
//            comment = null;
//        } else if (k().a().getCommentEssence().commments == null || i3 <= k().a().getCommentEssence().commments.size() - 1) {
//            comment = k().a().getCommentEssence().commments != null ? (Comment) k().a().getCommentEssence().commments.get(i3) : null;
//        } else {
//            return;
//        }
//        if (comment == null) {
//            QZLog.b("CommentListBaseController", "onReplyButtonClick: comment is null");
//            return;
//        }
//        Reply reply;
//        if (i == -1 || comment == null || comment.replies == null) {
//            reply = null;
//        } else {
//            reply = (Reply) comment.replies.get(i);
//        }
//        a(view, comment, reply, i3, 100);
//    }
//
//    public void a(View view, Comment comment, Reply reply, int i, int i2) {
//        if (this.d == 334 && !this.z && !this.A) {
//            return;
//        }
//        if (comment == null) {
//            QZLog.b("CommentListBaseController", "onReply: comment is null");
//            return;
//        }
//        if (comment == null || comment.commentType != 0) {
//            if (comment != null && comment.commentType == 1) {
//                if (k() != null && k().a() != null && k().a().getCommentEssence() != null && k().a().getCommentEssence().commments != null) {
//                    if (i > k().a().getCommentEssence().commments.size() - 1) {
//                        return;
//                    }
//                }
//                return;
//            }
//        } else if (k() == null || k().a() == null || k().a().getCommentInfo() == null || k().a().getCommentInfo().commments == null || i > k().a().getCommentInfo().commments.size() - 1) {
//            return;
//        }
//        if (i2 == 101 && comment != null && comment.user != null && comment.user.uin == LoginManager.getInstance().getUin()) {
//            a(0, comment, reply).show();
//        } else if (i2 != 1 || comment == null || reply == null || reply.user == null || reply.user.uin != LoginManager.getInstance().getUin()) {
//            String str;
//            String str2;
//            String str3 = "";
//            String str4 = "";
//            if (reply != null) {
//                if (reply.user != null) {
//                    str3 = "回复" + reply.user.nickName + ":";
//                    str4 = NickUtil.b(reply.user) + " ";
//                } else {
//                    str3 = "回复 :";
//                }
//                this.r = reply.user;
//                str = str4;
//                str2 = str3;
//            } else {
//                if (comment != null) {
//                    if (comment.user != null) {
//                        str3 = "回复" + comment.user.nickName + ":";
//                        str4 = NickUtil.b(comment.user) + " ";
//                    } else {
//                        str3 = "回复 :";
//                    }
//                    this.r = comment.user;
//                }
//                str = str4;
//                str2 = str3;
//            }
//            int i3 = comment.commentType == 1 ? 101 : 100;
//            boolean z = comment != null ? comment.isPrivate : true;
//            k().a().isFeedCommentInsertImage();
//            a(this.k, "回复", "", FeedActionPanelActivity.l, i3, Integer.valueOf(i), ParcelableWrapper.obtain(k().a()), "", 0, 500, null, str2, str, false, ActionPanelCacheKey.b, k().a().isFeedCommentQuickComment(), k().a().getFeedCommInfo().appid, z, false, false);
//        } else {
//            a(1, comment, reply).show();
//        }
//    }
//
//    protected void a(Context context, String str, String str2, int i, int i2, Serializable serializable, Parcelable parcelable, String str3, int i3, int i4, ArrayList<User> arrayList, String str4, String str5, boolean z, String str6, boolean z2, int i5, boolean z3, boolean z4, boolean z5) {
//        Intent intent = new Intent(context, FeedActionPanelActivity.class);
//        intent.putExtra("feedTitleIntentKey", str);
//        intent.putExtra("feedIconIntentKey", str2);
//        intent.putExtra("feedDscTypeIntentKey", i);
//        intent.putExtra("feedContentMinKey", i3);
//        intent.putExtra("feedContentMaxKey", i4);
//        int i6 = 0;
//        if (!(k() == null || k().a() == null)) {
//            i6 = FeedActionPanelActivity.a(k().a());
//        }
//        intent.putExtra("showFontIcon", i6);
//        ParcelableWrapper.putArrayListToIntent(intent, "feedAtListKey", arrayList);
//        intent.putExtra("feedTextHintKey", str4);
//        intent.putExtra("feedTextAutoFillKey", str5);
//        intent.putExtra("feedShouldPutHead", z);
//        intent.putExtra("autoSaveModeEnable", true);
//        if (k() != null) {
//            intent.putExtra("autoSaveStorageKey", k().a().getFeedCommInfo().ugckey);
//            intent.putExtra("autoSaveStorageKey", k().a().getFeedCommInfo().ugckey);
//        }
//        intent.putExtra("autoSaveUniqueCacheKey", str6);
//        intent.putExtra("isInsertPicture", z2);
//        if (serializable != null) {
//            intent.putExtra("extraIntentKey", serializable);
//        }
//        if (parcelable != null) {
//            intent.putExtra("extraIntentKeyParcelable", parcelable);
//        }
//        if (str3 != null) {
//            intent.putExtra("feedTextIntentKey", str3);
//        }
//        intent.putExtra("from_appid", i5);
//        intent.putExtra("is_private", z3);
//        if (i2 == 10003 || i2 == 10004) {
//            intent.putExtra("is_from_forward", true);
//        }
//        if (!z2) {
//            z4 = false;
//            z5 = false;
//        }
//        intent.putExtra("useRapidComment", z4);
//        intent.putExtra("action_panel_activity_request_code_extre_name", i2);
//        if (z5) {
//            intent.putExtra("rapidCommentImmediately", true);
//        }
//        if (k() != null) {
//            intent.putExtra("is_hide_private_comment", FeedDataCalculateHelper.a(k().a().getFeedCommInfo().operatemask, 28));
//        }
//        this.k.startActivityForResult(intent, i2);
//    }
//
//    public void b(View view, Object obj) {
//        ClickedComment clickedComment = (ClickedComment) view.getTag();
//        if (clickedComment == null || clickedComment.c() == null || clickedComment.c().user == null) {
//            QZLog.a("CommentListBaseController", "comment is null!! click");
//        } else if (clickedComment.c().isFake) {
//            QZLog.a("CommentListBaseController", "fake comment clicked");
//        } else if (clickedComment.c().isAbleToReply) {
//            a(view, clickedComment.c(), clickedComment.d(), ((Integer) obj).intValue(), 101);
//        } else if (clickedComment.c().commentType == 1) {
//            ToastUtils.show(this.k, "精华评论不允许回复!");
//        } else {
//            ToastUtils.show(this.k, "当前评论不允许回复!");
//        }
//    }
//
//    public void a(View view, Integer num) {
//        ClickedComment clickedComment = (ClickedComment) view.getTag();
//        if (clickedComment == null || clickedComment.d() == null || clickedComment.d().user == null) {
//            QZLog.a("CommentListBaseController", "reply is null!!");
//            return;
//        }
//        a(view, clickedComment.c(), clickedComment.d(), num.intValue(), 1);
//    }
//
//    public void a(View view, final Comment comment, final OnTextOperater onTextOperater) {
//        final OnTextOperater anonymousClass8 = new OnTextOperater(this) {
//            final /* synthetic */ CommentListBaseController b;
//
//            public void e() {
//                if (onTextOperater != null) {
//                    onTextOperater.e();
//                }
//            }
//
//            public void f() {
//                if (onTextOperater != null) {
//                    onTextOperater.f();
//                }
//            }
//        };
//        BusinessFeedData a = k().a();
//        if (a == null) {
//            QZLog.b("CommentListBaseController", "--onCommentLongClick, businessFeedData is null.");
//            return;
//        }
//        ClickListener anonymousClass9 = new ClickListener(this) {
//            final /* synthetic */ CommentListBaseController c;
//
//            public void onFirstItemClick(Object obj) {
//                if (anonymousClass8 != null) {
//                    anonymousClass8.e();
//                }
//            }
//
//            public void onSecondItemClick(Object obj) {
//                if (anonymousClass8 != null) {
//                    anonymousClass8.f();
//                }
//                this.c.a(0, comment, null).show();
//            }
//        };
//        if (a.getLocalInfo() != null && !a.getLocalInfo().canDelComment) {
//            a(this.k, view, anonymousClass8, anonymousClass9, true, true);
//        } else if (comment == null || comment.user == null) {
//            a(this.k, view, anonymousClass8, anonymousClass9, false, true);
//        } else if (comment.user.uin != LoginManager.getInstance().getUin() && a.getUser().uin != LoginManager.getInstance().getUin()) {
//            a(this.k, view, anonymousClass8, anonymousClass9, false, true);
//        } else if (this.d != 334 || comment.user.uin == LoginManager.getInstance().getUin() || this.z) {
//            a(this.k, view, anonymousClass8, anonymousClass9, true, true);
//        } else {
//            a(this.k, view, anonymousClass8, anonymousClass9, false, true);
//        }
//    }
//
//    public void a(View view, Comment comment, Reply reply, final OnTextOperater onTextOperater) {
//        final BusinessFeedData a = k().a();
//        final OnTextOperater anonymousClass10 = new OnTextOperater(this) {
//            final /* synthetic */ CommentListBaseController b;
//
//            public void e() {
//                if (onTextOperater != null) {
//                    onTextOperater.e();
//                }
//            }
//
//            public void f() {
//                if (onTextOperater != null) {
//                    onTextOperater.f();
//                }
//            }
//        };
//        final Reply reply2 = reply;
//        final Comment comment2 = comment;
//        AnonymousClass11 anonymousClass11 = new ClickListener(this) {
//            final /* synthetic */ CommentListBaseController e;
//
//            public void onFirstItemClick(Object obj) {
//                if (anonymousClass10 != null) {
//                    anonymousClass10.e();
//                }
//            }
//
//            public void onSecondItemClick(Object obj) {
//                if (anonymousClass10 != null) {
//                    anonymousClass10.f();
//                }
//                if (reply2.user.uin == LoginManager.getInstance().getUin() || a.getUser().uin == LoginManager.getInstance().getUin()) {
//                    this.e.a(1, comment2, reply2).show();
//                }
//            }
//        };
//        if (comment == null || reply == null || a == null) {
//            a(this.k, view, anonymousClass10, anonymousClass11, false, true);
//        } else if (reply.user.uin == LoginManager.getInstance().getUin() || a.getUser().uin == LoginManager.getInstance().getUin()) {
//            a(this.k, view, anonymousClass10, anonymousClass11, true, true);
//        } else {
//            a(this.k, view, anonymousClass10, anonymousClass11, false, true);
//        }
//    }
//
//    public static void a(Context context, View view, Object obj, ClickListener clickListener, boolean z, boolean z2) {
//        String str = null;
//        String str2 = z2 ? "复制" : null;
//        if (z) {
//            str = "删除";
//        }
//        Popup2Window popup2Window = new Popup2Window(context, clickListener, str2, str);
//        popup2Window.setAttachData(obj);
//        popup2Window.showAsDropDown(view, context.getResources().getDimensionPixelSize(R.dimen.dp25), 0);
//    }
//
//    protected void a(Object obj) {
//        Comment comment;
//        Bundle bundle = (Bundle) obj;
//        int i = bundle.getInt("position");
//        int i2 = bundle.getInt("commenttype", 0);
//        BusinessFeedData a = k().a();
//        if (i2 == 0) {
//            if (a.getCommentInfo().commments != null) {
//                if (i <= a.getCommentInfo().commments.size() - 1) {
//                    comment = (Comment) a.getCommentInfo().commments.get(i);
//                } else {
//                    return;
//                }
//            }
//            comment = null;
//        } else {
//            if (i2 == 1) {
//                CellCommentEssence commentEssence = a.getCommentEssence();
//                if (commentEssence != null && commentEssence.commments != null && commentEssence.commments.size() > i) {
//                    comment = (Comment) commentEssence.commments.get(i);
//                } else {
//                    return;
//                }
//            }
//            comment = null;
//        }
//        if (comment == null) {
//            QZLog.b("CommentListBaseController", "onCommentPraiseClick: comment is null");
//        } else {
//            ((IOperationService) OperationProxy.g.getServiceInterface()).a(a, comment, null);
//        }
//    }
//}