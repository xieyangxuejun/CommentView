//package com.foretree.commentview.comment;
//
//import android.content.Context;
//import android.content.res.ColorStateList;
//import android.graphics.Paint;
//import android.os.Handler;
//import android.os.Message;
//import android.view.View;
//
//public class CellTextView extends View implements TextLayoutBase {
//    private static final long LONG_CLICK_TRIG_TIME = 600;
//    private boolean cellClickable = true;
//    private boolean drawBackground = false;
//    private boolean hasAttached = false;
//    private boolean hasSetColorLink = false;
//    private boolean isLongClicked = false;
//    private Handler longClickHandler = new Handler() {
//        public void handleMessage(Message message) {
//            CellTextView.this.longClickTrig = true;
//            CellTextView.this.performLongClick();
//            TextCell access$500 = this.a.touchTarget;
//            CellTextView.this.initTextCellLayout();
//            CellTextView.this.textLayout.j();
//            CellTextView.this.touchTarget = access$500;
//        }
//    };
//    private boolean longClickTrig = false;
//    private Context mContext = null;
//    private OnCellClickListener onCellClickListener;
//    private OnClickListener onClickListener;
//    protected Paint paint = new Paint(1);
//    private String rawText;
//    private ArrayList<TextCell> text;
//    private int textColor = -16777216;
//    private int textColorLink = -16711936;
//    private ColorStateList textColorLinkList = null;
//    private ColorStateList textColorList = null;
//    private TextCellLayout textLayout;
//    private OnTextOperater textOperator = new OnTextOperater(this) {
//        final /* synthetic */ CellTextView a;
//
//        {
//            this.a = r2;
//            Zygote.class.getName();
//        }
//
//        public void e() {
//            this.a.copyText(this.a.getCopiedText());
//            this.a.isLongClicked = false;
//            this.a.postInvalidate();
//        }
//
//        public void f() {
//            this.a.isLongClicked = false;
//            this.a.postInvalidate();
//        }
//    };
//    private TextCell touchTarget;
//
//    /* compiled from: ProGuard */
//    public interface OnTextOperater {
//        void e();
//
//        void f();
//    }
//
//    public void setOnTextOperateListener(OnTextOperater onTextOperater) {
//        this.textOperator = onTextOperater;
//    }
//
//    public void setHighlightColorRes(int i) {
//    }
//
//    public static void setCanCopy(ArrayList<TextCell> arrayList, boolean z) {
//        if (arrayList != null) {
//            Iterator it = arrayList.iterator();
//            while (it.hasNext()) {
//                ((TextCell) it.next()).c(z);
//            }
//        }
//    }
//
//    public void addLeftDrawable(Drawable drawable, int i) {
//        initTextCellLayout();
//        this.textLayout.a(drawable, i);
//    }
//
//    public void addRightDrawable(Drawable drawable, int i) {
//        initTextCellLayout();
//        this.textLayout.b(drawable, i);
//    }
//
//    public void resetSideDrawables() {
//        initTextCellLayout();
//        this.textLayout.c();
//    }
//
//    public void setDrawablePadding(int i) {
//        initTextCellLayout();
//        this.textLayout.h(i);
//    }
//
//    public void setOnSideDrawableClickListener(OnSideDrawableClickListener onSideDrawableClickListener) {
//        initTextCellLayout();
//        this.textLayout.a(onSideDrawableClickListener);
//    }
//
//    public void setShowMore(boolean z) {
//        initTextCellLayout();
//        this.textLayout.c(z);
//    }
//
//    public void setDrawBackground(boolean z) {
//        initTextCellLayout();
//        this.textLayout.b(z);
//    }
//
//    public void setCellClickable(boolean z) {
//        this.cellClickable = z;
//        initTextCellLayout();
//        this.textLayout.e(z);
//    }
//
//    public void setLineBreakNeeded(boolean z) {
//        initTextCellLayout();
//        this.textLayout.f(z);
//    }
//
//    public void setLineBreakInContent(boolean z) {
//        initTextCellLayout();
//        this.textLayout.g(z);
//    }
//
//    public void setClickable(boolean z) {
//        super.setClickable(z);
//        initTextCellLayout();
//        this.textLayout.h(z);
//    }
//
//    public void setOnClickListener(OnClickListener onClickListener) {
//        super.setOnClickListener(onClickListener);
//        this.onClickListener = onClickListener;
//    }
//
//    public void setShadowLayer(int i, int i2, int i3, int i4) {
//        initTextCellLayout();
//        this.textLayout.b(i, i2, i3, i4);
//    }
//
//    public void setLongclickable(boolean z) {
//        this.textLayout.i(z);
//        if (z) {
//            setOnLongClickListener(new OnLongClickListener(this) {
//                final /* synthetic */ CellTextView a;
//
//                {
//                    this.a = r2;
//                    Zygote.class.getName();
//                }
//
//                public boolean onLongClick(View view) {
//                    this.a.isLongClicked = true;
//                    this.a.postInvalidate();
//                    if (this.a.onCellClickListener != null) {
//                        this.a.onCellClickListener.onLongClick(this.a, this.a.textOperator);
//                    }
//                    return true;
//                }
//            });
//        }
//    }
//
//    public void setOnCellClickListener(OnCellClickListener onCellClickListener) {
//        this.onCellClickListener = onCellClickListener;
//        initTextCellLayout();
//        this.textLayout.a(onCellClickListener);
//    }
//
//    public CellTextView(Context context, AttributeSet attributeSet, int i) {
//        super(context, attributeSet, i);
//        Zygote.class.getName();
//        init(context, attributeSet, i);
//    }
//
//    public CellTextView(Context context, AttributeSet attributeSet) {
//        super(context, attributeSet);
//        Zygote.class.getName();
//        init(context, attributeSet, 0);
//    }
//
//    public CellTextView(Context context) {
//        super(context);
//        Zygote.class.getName();
//        init(context, null, 0);
//    }
//
//    protected void init(Context context, AttributeSet attributeSet, int i) {
//        initTextCellLayout();
//        setDrawBackground(this.drawBackground);
//        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CellTextView, i, 0);
//        int indexCount = obtainStyledAttributes.getIndexCount();
//        int i2 = 0;
//        int i3 = 0;
//        int i4 = 0;
//        int i5 = 0;
//        for (int i6 = 0; i6 < indexCount; i6++) {
//            int index = obtainStyledAttributes.getIndex(i6);
//            if (index == R.styleable.CellTextView_android_textSize) {
//                setTextSize((float) obtainStyledAttributes.getDimensionPixelSize(index, (int) FeedGlobalEnv.v().a(13.0f)));
//            } else if (index == R.styleable.CellTextView_android_textColor) {
//                setTextColor(obtainStyledAttributes.getColor(index, this.textColor));
//            } else if (index == R.styleable.CellTextView_android_singleLine) {
//                if (obtainStyledAttributes.getBoolean(index, false)) {
//                    setMaxLine(1);
//                }
//            } else if (index == R.styleable.CellTextView_android_maxWidth) {
//                setMaxWidth(obtainStyledAttributes.getDimensionPixelSize(index, -1));
//            } else if (index == R.styleable.CellTextView_android_maxLines) {
//                setMaxLine(obtainStyledAttributes.getInt(index, -1));
//            } else if (index == R.styleable.CellTextView_android_text) {
//                setText(obtainStyledAttributes.getString(index));
//            } else if (index == R.styleable.CellTextView_android_paddingLeft) {
//                i5 = obtainStyledAttributes.getDimensionPixelSize(index, 0);
//            } else if (index == R.styleable.CellTextView_android_paddingRight) {
//                i4 = obtainStyledAttributes.getDimensionPixelSize(index, 0);
//            } else if (index == R.styleable.CellTextView_android_paddingTop) {
//                i3 = obtainStyledAttributes.getDimensionPixelSize(index, 0);
//            } else if (index == R.styleable.CellTextView_android_paddingBottom) {
//                i2 = obtainStyledAttributes.getDimensionPixelSize(index, 0);
//            }
//        }
//        setPadding(i5, i3, i4, i2);
//        obtainStyledAttributes.recycle();
//        this.mContext = context;
//    }
//
//    public void clearText() {
//    }
//
//    public void setPadding(int i, int i2, int i3, int i4) {
//        super.setPadding(i, i2, i3, i4);
//        initTextCellLayout();
//        this.textLayout.a(i, i2, i3, i4);
//    }
//
//    public void setEllipsisStr(String str) {
//        initTextCellLayout();
//        this.textLayout.c(str);
//    }
//
//    private void initTextCellLayout() {
//        if (this.textLayout == null) {
//            this.textLayout = new TextCellLayout(this);
//        }
//        this.textLayout.a((TextLayoutBase) this);
//    }
//
//    public void copyText(String str) {
//        try {
//            ((ClipboardManager) getContext().getSystemService("clipboard")).setText(str);
//            Toast.makeText(getContext(), "复制成功", 0).show();
//        } catch (Exception e) {
//            Toast.makeText(getContext(), "复制失败", 0).show();
//        }
//    }
//
//    public void setMaxLine(int i) {
//        initTextCellLayout();
//        this.textLayout.c(i);
//    }
//
//    public void setMaxLines(int i) {
//        setMaxLine(i);
//    }
//
//    public void setText(int i) {
//        setText(getResources().getString(i));
//    }
//
//    public void setText(String str) {
//        this.text = new ArrayList();
//        this.text.add(new TextCell(0, str));
//        initTextCellLayout();
//        this.textLayout.a(this.text);
//        requestLayout();
//        invalidate();
//    }
//
//    public void setText(ArrayList<TextCell> arrayList) {
//        this.text = arrayList;
//        initTextCellLayout();
//        this.textLayout.a((ArrayList) arrayList);
//        requestLayout();
//        invalidate();
//    }
//
//    public void setText(TextCell textCell) {
//        this.text = new ArrayList();
//        this.text.add(textCell);
//        initTextCellLayout();
//        this.textLayout.b(textCell);
//        requestLayout();
//        invalidate();
//    }
//
//    public void setTextBold(boolean z) {
//        initTextCellLayout();
//        this.textLayout.j(z);
//    }
//
//    public String getText() {
//        initTextCellLayout();
//        return this.textLayout.i();
//    }
//
//    private String getCopiedText() {
//        initTextCellLayout();
//        return this.textLayout.d();
//    }
//
//    public String getDisplayedText() {
//        initTextCellLayout();
//        return this.textLayout.e();
//    }
//
//    public void setTextSize(float f) {
//        initTextCellLayout();
//        this.textLayout.a(f);
//        requestLayout();
//        invalidate();
//    }
//
//    public void setTextSize(int i, float f) {
//        Resources system;
//        Context context = getContext();
//        if (context == null) {
//            system = Resources.getSystem();
//        } else {
//            system = context.getResources();
//        }
//        float applyDimension = TypedValue.applyDimension(i, f, system.getDisplayMetrics());
//        if (applyDimension != getTextSize()) {
//            setTextSize(applyDimension);
//        }
//    }
//
//    public float getTextSize() {
//        initTextCellLayout();
//        return this.textLayout.f();
//    }
//
//    public void setTextColor(int i) {
//        initTextCellLayout();
//        this.textLayout.j(i);
//        invalidate();
//    }
//
//    public void setLineSpace(int i) {
//        initTextCellLayout();
//        this.textLayout.k(i);
//        invalidate();
//    }
//
//    public void setTextColorLink(int i) {
//        this.hasSetColorLink = true;
//        this.textColorLink = i;
//        initTextCellLayout();
//        this.textLayout.l(i);
//        invalidate();
//    }
//
//    public void setTextColor(ColorStateList colorStateList) {
//        initTextCellLayout();
//        this.textLayout.a(colorStateList);
//        drawableStateChanged();
//        invalidate();
//    }
//
//    public void setTextColorLink(ColorStateList colorStateList) {
//        initTextCellLayout();
//        this.textLayout.b(colorStateList);
//        drawableStateChanged();
//        invalidate();
//    }
//
//    public void setTextColorLinkBackground(int i) {
//        initTextCellLayout();
//        this.textLayout.m(i);
//    }
//
//    public void setTextColorAnimation(ArrayList<Integer> arrayList, int i) {
//        initTextCellLayout();
//        this.textLayout.a((ArrayList) arrayList, i);
//    }
//
//    public void setUrlColorRes(int i) {
//    }
//
//    private String getModeStr(int i) {
//        switch (i) {
//            case Integer.MIN_VALUE:
//                return "AT_MOST";
//            case 0:
//                return "UNSPECIFIED";
//            case 1073741824:
//                return "EXACTLY";
//            default:
//                return "";
//        }
//    }
//
//    public void requestLayout() {
//        initTextCellLayout();
//        this.textLayout.g();
//        super.requestLayout();
//    }
//
//    public void forceRequestLayout() {
//        initTextCellLayout();
//        this.textLayout.h();
//        requestLayout();
//    }
//
//    public void setMeasuredTextCacheEnabled(boolean z) {
//        initTextCellLayout();
//        this.textLayout.k(z);
//    }
//
//    @SuppressLint({"DrawAllocation"})
//    protected void onMeasure(int i, int i2) {
//        initTextCellLayout();
//        this.textLayout.a(i, i2);
//        setMeasuredDimension(this.textLayout.a(), this.textLayout.b());
//        setContentDescription(getDisplayedText());
//    }
//
//    protected void drawableStateChanged() {
//        super.drawableStateChanged();
//        if (this.textColorLinkList != null) {
//            this.textColorLink = this.textColorLinkList.getColorForState(getDrawableState(), this.textColorLink);
//            invalidate();
//        }
//        if (this.textColorList != null) {
//            this.textColor = this.textColorList.getColorForState(getDrawableState(), this.textColor);
//            invalidate();
//        }
//    }
//
//    private void attachStateChangeToParent() {
//        if (!this.hasAttached) {
//            this.hasAttached = true;
//            ViewParent parent = getParent();
//            while (parent instanceof ViewGroup) {
//                ViewGroup viewGroup = (ViewGroup) parent;
//                viewGroup.setAddStatesFromChildren(true);
//                parent = viewGroup.getParent();
//            }
//        }
//    }
//
//    public boolean onTouchEvent(MotionEvent motionEvent) {
//        initTextCellLayout();
//        return this.textLayout.a(motionEvent, this.longClickHandler);
//    }
//
//    public void performCellClick(TextCell textCell) {
//        if (textCell == null) {
//            if (this.onClickListener != null) {
//                this.onClickListener.onClick(this);
//            }
//        } else if (this.onCellClickListener != null) {
//            this.onCellClickListener.onClick(textCell, this);
//        }
//    }
//
//    public void performCellLongClick() {
//        this.longClickHandler.sendMessageDelayed(this.longClickHandler.obtainMessage(0), LONG_CLICK_TRIG_TIME);
//    }
//
//    public void onDraw(Canvas canvas) {
//        super.onDraw(canvas);
//        initTextCellLayout();
//        if (this.hasSetColorLink) {
//            this.textLayout.o(this.textColorLink);
//        }
//        this.textLayout.a((TextLayoutBase) this, canvas);
//    }
//
//    protected int getCellHeight(TextCell textCell) {
//        initTextCellLayout();
//        return textCell.b(this.textLayout.k());
//    }
//
//    protected float getCellWidth(TextCell textCell) {
//        initTextCellLayout();
//        return textCell.a(this.textLayout.k());
//    }
//
//    public Paint getPaint() {
//        initTextCellLayout();
//        return this.textLayout.k();
//    }
//
//    public void setUserNameRichText(TextCell textCell, CharSequence charSequence) {
//        setRichText(charSequence);
//        if (this.text != null) {
//            this.text.add(0, textCell);
//            requestLayout();
//            invalidate();
//        }
//    }
//
//    public void setmutiRichText(ArrayList<TextCell> arrayList, CharSequence charSequence) {
//        setRichText(charSequence);
//        if (this.text != null) {
//            this.text.addAll(0, arrayList);
//            requestLayout();
//            invalidate();
//        }
//    }
//
//    public ArrayList<TextCell> setRichText(CharSequence charSequence, boolean z) {
//        if (charSequence != null) {
//            this.rawText = charSequence.toString();
//        }
//        Object parseContent = parseContent(charSequence, z);
//        if (this.text == null) {
//            this.text = new ArrayList();
//        }
//        this.text.clear();
//        this.text.addAll(parseContent);
//        initTextCellLayout();
//        this.textLayout.a(this.text);
//        requestLayout();
//        invalidate();
//        return parseContent;
//    }
//
//    public ArrayList<TextCell> setRichText(CharSequence charSequence, boolean z, int i, int i2) {
//        if (charSequence != null) {
//            this.rawText = charSequence.toString();
//        }
//        Object parseContent = parseContent(charSequence, z);
//        if (this.text == null) {
//            this.text = new ArrayList();
//        }
//        this.text.clear();
//        this.text.addAll(parseContent);
//        initTextCellLayout();
//        this.textLayout.a(this.text);
//        this.textLayout.j(i2);
//        this.textLayout.l(i);
//        requestLayout();
//        invalidate();
//        return parseContent;
//    }
//
//    public ArrayList<TextCell> setRichTextWhenTextChange(CharSequence charSequence, boolean z) {
//        if (charSequence == null || this.rawText == null || !this.rawText.equals(charSequence.toString())) {
//            return setRichText(charSequence, z);
//        }
//        return this.text;
//    }
//
//    public ArrayList<TextCell> setRichText(CharSequence charSequence) {
//        return setRichText(charSequence, true);
//    }
//
//    public ArrayList<TextCell> setRichTextWhenTextChange(CharSequence charSequence) {
//        return setRichTextWhenTextChange(charSequence, true);
//    }
//
//    public void setRichText(CharSequence charSequence, int i, int i2, int i3, int i4, ArrayList<RichTextElement> arrayList) {
//        setRichText(charSequence);
//    }
//
//    public void setRichText(CharSequence charSequence, int i, int i2, int i3) {
//        setRichText(charSequence, true, i, i2);
//    }
//
//    public ArrayList<TextCell> parseContent(CharSequence charSequence) {
//        return parseContent(charSequence, true);
//    }
//
//    public ArrayList<TextCell> parseContent(CharSequence charSequence, boolean z) {
//        return TextCellParser.a(this, charSequence, this.textLayout.c(getTextSize()), this.cellClickable, z, -1);
//    }
//
//    public void setFakeFeed(boolean z) {
//        initTextCellLayout();
//        this.textLayout.l(z);
//    }
//
//    public void setHasMore(boolean z) {
//        initTextCellLayout();
//        this.textLayout.m(z);
//    }
//
//    public void setMaxWidth(int i) {
//        initTextCellLayout();
//        this.textLayout.p(i);
//    }
//
//    public void postRequestLayout() {
//        requestLayout();
//    }
//
//    public boolean isLongClickTrig() {
//        return this.longClickTrig;
//    }
//
//    public void setLongClickTrig(boolean z) {
//        this.longClickTrig = z;
//    }
//
//    public void reset() {
//    }
//
//    public void setParseUrl(boolean z) {
//    }
//
//    public int getLineCount() {
//        return this.textLayout != null ? this.textLayout.m() : 0;
//    }
//
//    public boolean isFinished() {
//        return this.textLayout.n();
//    }
//
//    public View getAttachedView() {
//        return this;
//    }
//
//    public void setFont(int i, String str, int i2) {
//        initTextCellLayout();
//        this.textLayout.a(i, str, i2);
//    }
//
//    public void setGradientColor(int[] iArr, float[] fArr, Orientation orientation) {
//        initTextCellLayout();
//        this.textLayout.a(iArr, fArr, orientation);
//    }
//}