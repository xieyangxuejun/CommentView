//package com.foretree.commentview.comment;
//
//import android.content.Intent;
//import android.net.Uri;
//import android.os.Bundle;
//import android.text.TextUtils;
//import android.view.View;
//
//import java.util.ArrayList;
//
//public class CommentElementClickListener implements OnFeedElementClickListener {
//    QZoneBaseActivity a;
//    BusinessFeedData b;
//    private CommentListBaseController c;
//
//    public CommentElementClickListener(QZoneBaseActivity qZoneBaseActivity, CommentListBaseController commentListBaseController) {
//        Zygote.class.getName();
//        this.a = qZoneBaseActivity;
//        this.c = commentListBaseController;
//    }
//
//    public void a(BusinessFeedData businessFeedData) {
//        this.b = businessFeedData;
//    }
//
//    public void a(View view, FeedElement feedElement, int i, Object obj) {
//        if (this.a != null) {
//            BusinessFeedData businessFeedData;
//            switch (AnonymousClass4.a[feedElement.ordinal()]) {
//                case 1:
//                    this.c.r();
//                    return;
//                case 2:
//                    a(view, obj);
//                    return;
//                case 3:
//                    b(view);
//                    return;
//                case 4:
//                    a(view, (Integer) obj);
//                    return;
//                case 5:
//                    d(view);
//                    return;
//                case 6:
//                    b(view, obj);
//                    return;
//                case 7:
//                case 8:
//                    c(obj);
//                    return;
//                case 9:
//                    d(obj);
//                    return;
//                case 10:
//                    d(obj);
//                    break;
//                case 11:
//                    break;
//                case 12:
//                    a(obj, this.b);
//                    return;
//                case 13:
//                    a();
//                    return;
//                case 14:
//                    b(obj);
//                    return;
//                case 15:
//                    a(obj);
//                    return;
//                case 16:
//                    a((CellReferInfo) obj);
//                    return;
//                case 17:
//                    FeedEnv.S().b(this.a);
//                    return;
//                case 18:
//                    if (obj instanceof User) {
//                        d(obj);
//                        return;
//                    }
//                    return;
//                case 19:
//                    a(view);
//                    return;
//                case 20:
//                    FeedVideoHelper.reportExposedVideoInfo((ArrayList) obj, 7);
//                    return;
//                case 21:
//                    businessFeedData = this.b;
//                    if (businessFeedData != null && businessFeedData.getCellBottomRecomm() != null) {
//                        if (!TextUtils.isEmpty(businessFeedData.getCellBottomRecomm().actionurl)) {
//                            ((ISchemeService) SchemeProxy.g.getServiceInterface()).analyUrl(Qzone.a(), businessFeedData.getCellBottomRecomm().actionurl, 0);
//                        }
//                        TTTReportManager.a().a(3, 65, 1, System.currentTimeMillis());
//                        return;
//                    }
//                    return;
//                case 22:
//                    BusinessFeedData businessFeedData2 = this.b;
//                    if (obj instanceof BusinessFeedData) {
//                        BusinessFeedData businessFeedData3 = (BusinessFeedData) obj;
//                        if (!(this.b == null || businessFeedData3 == null || businessFeedData3.getOriginalInfo() == null || businessFeedData3.getOriginalInfo().getCellBottomRecomm() == null)) {
//                            businessFeedData = this.b.getOriginalInfo();
//                            if (businessFeedData != null && businessFeedData.getCellBottomRecomm() != null && !TextUtils.isEmpty(businessFeedData.getCellBottomRecomm().actionurl)) {
//                                ((ISchemeService) SchemeProxy.g.getServiceInterface()).analyUrl(Qzone.a(), businessFeedData.getCellBottomRecomm().actionurl, 0);
//                                return;
//                            }
//                            return;
//                        }
//                    }
//                    businessFeedData = businessFeedData2;
//                    if (businessFeedData != null) {
//                        return;
//                    }
//                    return;
//                case 23:
//                    businessFeedData = this.b;
//                    if (businessFeedData != null && businessFeedData.getCellBottomRecomm() != null && !TextUtils.isEmpty(businessFeedData.getCellBottomRecomm().actionurl)) {
//                        ((ISchemeService) SchemeProxy.g.getServiceInterface()).analyUrl(Qzone.a(), businessFeedData.getCellBottomRecomm().actionurl, 0);
//                        return;
//                    }
//                    return;
//                case 24:
//                    c(view, obj);
//                    return;
//                default:
//                    return;
//            }
//            e(obj);
//        }
//    }
//
//    protected void a(View view) {
//        if (this.b != null) {
//        }
//    }
//
//    public boolean a(FeedElement feedElement, Object obj, View view, CellTextView.OnTextOperater onTextOperater) {
//        switch (AnonymousClass4.a[feedElement.ordinal()]) {
//            case 25:
//                c(view);
//                break;
//            case 26:
//                a(view, onTextOperater);
//                break;
//        }
//        return true;
//    }
//
//    private void a(Object obj, BusinessFeedData businessFeedData) {
//        if (obj instanceof Long) {
//            HomePageJump.a(this.a, ((Long) obj).longValue(), true, false, businessFeedData);
//            ClickReport.g().report("329", "5", "5");
//        }
//    }
//
//    private void b(Object obj) {
//        int i = 2;
//        if (obj instanceof ViewFeedPhotoData) {
//            ViewFeedPhotoData viewFeedPhotoData = (ViewFeedPhotoData) obj;
//            boolean z = viewFeedPhotoData.photoSource == ViewFeedPhotoData.FROM_COMMENT;
//            viewFeedPhotoData.appid = this.c.d;
//            viewFeedPhotoData.isLike = this.c.k().a().getLikeInfo().isLiked;
//            viewFeedPhotoData.likeNum = this.c.k().a().getLikeInfo().likeNum;
//            viewFeedPhotoData.commentNum = this.c.k().a().getCommentInfo().commentNum;
//            viewFeedPhotoData.curKey = this.c.k().a().getFeedCommInfo().curlikekey;
//            viewFeedPhotoData.orgKey = this.c.k().a().getFeedCommInfo().orglikekey;
//            viewFeedPhotoData.feedId = this.c.k().a().getFeedCommInfo().ugckey;
//            StaticDetailData.a(this.c.k().a());
//            viewFeedPhotoData.isFromDetail = true;
//            viewFeedPhotoData.cell_id = this.c.f;
//            viewFeedPhotoData.cell_commSubId = this.c.k().a().getFeedCommInfo().subid;
//            viewFeedPhotoData.cell_subId = this.c.e;
//            CellPictureInfo pictureInfo = this.c.k().a().getPictureInfo();
//            if (!(pictureInfo != null || this.c.k().a().getOriginalInfo() == null || this.c.k().a().getOriginalInfo().getPictureInfo() == null)) {
//                pictureInfo = this.c.k().a().getOriginalInfo().getPictureInfo();
//            }
//            if (z || pictureInfo == null || pictureInfo.actiontype != 2 || TextUtils.isEmpty(pictureInfo.actionurl)) {
//                if (pictureInfo != null) {
//                    viewFeedPhotoData.pictureInfo.albumid = pictureInfo.albumid;
//                    if (TextUtils.isEmpty(pictureInfo.albumid)) {
//                        QZLog.i(QZLog.TO_DEVICE_TAG, "CommentList to QZonePictureViewer---uin:" + this.c.c + "AlbumID:" + pictureInfo.albumid);
//                    }
//                    viewFeedPhotoData.pictureInfo.albumnum = pictureInfo.albumnum;
//                }
//                if (viewFeedPhotoData.pictureInfo.uin == 0) {
//                    viewFeedPhotoData.pictureInfo.uin = this.c.k().a().getUser().uin;
//                }
//                viewFeedPhotoData.busi_param = this.c.k().a().getOperationInfo().busiParam;
//                if (z) {
//                    i = 7;
//                }
//                ((IPhotoUI) PhotoProxy.g.getUiInterface()).a(i, this.a, new Object[]{viewFeedPhotoData});
//                ClickReport.g().report("301", "1", "", 4, "getDetail");
//                return;
//            }
//            Uri parse = Uri.parse(pictureInfo.actionurl);
//            if (((ISchemeService) SchemeProxy.g.getServiceInterface()).isSchemaUrl(parse)) {
//                Intent intent = new Intent();
//                intent.setData(parse);
//                ((ISchemeService) SchemeProxy.g.getServiceInterface()).analyIntent(this.a, intent);
//                return;
//            }
//            ForwardUtil.b(this.a, pictureInfo.actionurl, true, null, -1);
//        }
//    }
//
//    private void a(CellReferInfo cellReferInfo) {
//        if (cellReferInfo != null) {
//            AppInfo appInfo = null;
//            int i = -1;
//            try {
//                i = NumberUtil.c(cellReferInfo.appid);
//                appInfo = ((IPlusUnionService) PlusUnionProxy.g.getServiceInterface()).a(i);
//            } catch (Exception e) {
//                i = i;
//            }
//            if (((IPlusUnionService) PlusUnionProxy.g.getServiceInterface()).a(appInfo) && ((IPlusUnionService) PlusUnionProxy.g.getServiceInterface()).c(appInfo)) {
//                ((IPlusUnionService) PlusUnionProxy.g.getServiceInterface()).a(this.a, appInfo);
//                return;
//            }
//            Bundle bundle = new Bundle();
//            try {
//                bundle.putInt(PlusUnionConst.b, i);
//            } catch (Exception e2) {
//            }
//            ((IPlusUnionUI) PlusUnionProxy.g.getUiInterface()).b(this.a, bundle, Error.SEND_DONE_BUT_NETWORK_BROKEN);
//        }
//    }
//
//    private void a(View view, Integer num) {
//        this.c.a(view, num);
//    }
//
//    private void d(View view) {
//        ClickedComment clickedComment = (ClickedComment) view.getTag();
//        if (clickedComment == null || clickedComment.d() == null || clickedComment.d().user == null) {
//            QZLog.e("CommentElementClickListener", "reply is null!! long click");
//        } else {
//            this.c.a(view, clickedComment.c(), clickedComment.d(), clickedComment);
//        }
//    }
//
//    private void c(Object obj) {
//        if (obj instanceof ClickedLink) {
//            BusinessFeedData a = this.c.k().a();
//            QBossFeedsReporter.b(a);
//            ClickedLink clickedLink = (ClickedLink) obj;
//            if (clickedLink.a().startsWith("mqzone://arouse/watermark") || clickedLink.a().startsWith("mqzone://arouse/newwatermark") || clickedLink.a().startsWith("mqzonev2://arouse/watermark") || clickedLink.a().startsWith("mqzonev2://arouse/newwatermark")) {
//                String str = "";
//                if (!TextUtils.isEmpty(this.c.k().a().getFeedCommInfo().ugckey)) {
//                    str = this.c.k().a().getFeedCommInfo().ugckey;
//                }
//                ClickReport.g().report("302", "4", "", str);
//            }
//            HyperLinkClickReportHelper.reportLinkClick(null, this.c.d, this.c.k().a().getUser().uin, clickedLink.a());
//            this.c.l.a(clickedLink.a(), clickedLink.b(), clickedLink.d(), a);
//        }
//    }
//
//    private void d(Object obj) {
//        if (obj instanceof Long) {
//            a(this.c.k().a(), ((Long) obj).longValue(), FeedElement.USER_AVATAR);
//        }
//    }
//
//    private void e(Object obj) {
//        if (obj instanceof Long) {
//            a(this.b, ((Long) obj).longValue(), FeedElement.USER_NICKNAME);
//            ClickReport.g().report("329", "5", "5");
//        }
//    }
//
//    protected void a(BusinessFeedData businessFeedData, long j, FeedElement feedElement) {
//        String str = "";
//        if (businessFeedData != null) {
//            str = businessFeedData.getFeedCommInfo().feedskey;
//            switch (businessFeedData.getCellUserInfo().actionType) {
//                case 6:
//                    return;
//                case 20:
//                    if (businessFeedData.getOperationInfo().actionType != 20) {
//                        if (businessFeedData.getOperationInfo().actionType != 2) {
//                            this.c.l.a(businessFeedData.getOperationInfo().actionType, businessFeedData.getOperationInfo().actionUrl, false, null, businessFeedData, false, feedElement);
//                            return;
//                        } else {
//                            this.c.l.a(businessFeedData.getOperationInfo().actionType, businessFeedData.getOperationInfo().downloadUrl, false, null, businessFeedData, false, feedElement);
//                            return;
//                        }
//                    }
//                    break;
//            }
//        }
//        this.c.l.a(j, businessFeedData);
//    }
//
//    protected void a(View view, Object obj) {
//        this.c.b(view, obj);
//    }
//
//    protected void b(View view) {
//        CellTextView.OnTextOperater onTextOperater = (ClickedComment) view.getTag();
//        if (onTextOperater == null || onTextOperater.c() == null || onTextOperater.c().user == null) {
//            QZLog.e("OnDetailFeedElementClickListener", "comment is null!! long click");
//        } else {
//            this.c.a(view, onTextOperater.c(), onTextOperater);
//        }
//    }
//
//    public void a(Object obj) {
//        if (obj != null && (obj instanceof ClickedPicture)) {
//            this.c.l.a((ClickedPicture) obj, this.c.k().a(), "getDetail", 0);
//        }
//    }
//
//    protected void b(View view, Object obj) {
//        this.c.a(view, obj);
//    }
//
//    public void c(View view) {
//        String str;
//        String str2 = null;
//        BusinessFeedData a = this.c.k().a();
//        if (!((IFeedComponentUI) FeedComponentProxy.g.getUiInterface()).a(view) || a.getOriginalInfo() == null) {
//            if (a.getCellSummaryV2() != null) {
//                str2 = a.getCellSummaryV2().summary;
//            }
//            str = str2;
//        } else {
//            str = a.getOriginalInfo().getCellSummaryV2() != null ? a.getOriginalInfo().getCellSummaryV2().summary : null;
//        }
//        final OnTextOperater anonymousClass1 = new OnTextOperater(this) {
//            final /* synthetic */ CommentElementClickListener b;
//
//            public void e() {
//                try {
//                    ((ClipboardManager) this.b.a.getSystemService("clipboard")).setText(str);
//                    Toast.makeText(this.b.a.getApplicationContext(), "复制成功", 0).show();
//                } catch (Exception e) {
//                }
//            }
//
//            public void f() {
//            }
//        };
//        CommentListBaseController.a(this.a, view, anonymousClass1, new ClickListener(this) {
//            final /* synthetic */ CommentElementClickListener b;
//
//            public void onFirstItemClick(Object obj) {
//                if (anonymousClass1 != null) {
//                    anonymousClass1.e();
//                }
//            }
//
//            public void onSecondItemClick(Object obj) {
//                if (anonymousClass1 != null) {
//                    anonymousClass1.f();
//                }
//            }
//        }, false, true);
//    }
//
//    public void a(View view, final OnTextOperater onTextOperater) {
//        CommentListBaseController.a(this.a, view, onTextOperater, new ClickListener(this) {
//            final /* synthetic */ CommentElementClickListener b;
//
//            public void onFirstItemClick(Object obj) {
//                if (onTextOperater != null) {
//                    onTextOperater.e();
//                }
//            }
//
//            public void onSecondItemClick(Object obj) {
//                if (onTextOperater != null) {
//                    onTextOperater.f();
//                }
//            }
//        }, false, true);
//    }
//
//    private void c(View view, Object obj) {
//        this.c.a(obj);
//    }
//}