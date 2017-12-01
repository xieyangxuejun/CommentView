package com.foretree.commentview.canvasui;

import android.graphics.Color;
import android.text.TextUtils;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Iterator;

public class LayoutAttrSet {
    public static final int VALUE_NOT_SET = Integer.MIN_VALUE;
    public String above;
    public String alignBottom;
    public String alignLeft;
    public boolean alignParentBottom;
    public boolean alignParentLeft;
    public boolean alignParentRight;
    public boolean alignParentTop;
    public String alignRight;
    public String alignTop;
    public boolean alignWithParentIfMissing;
    public String below;
    public int bg_color = -1;
    public int bottom;
    public int bottomMargin;
    public int bottomPadding;
    public boolean centerHorizontal;
    public boolean centerInParent;
    public boolean centerVertical;
    public int height;
    public String id;
    public int layout_gravity = 3;
    public int left;
    public int leftMargin;
    public int leftPadding;
    public HashMap<String, Object> mAttrs = new HashMap();
    public int orientation = 1;
    public int right;
    public int rightMargin;
    public int rightPadding;
    public String toLeftOf;
    public String toRightOf;
    public int top;
    public int topMargin;
    public int topPadding;
    public int width;

    protected void parseContent(String str, Object obj) {
        try {
            if ("id".equals(str)) {
                this.id = (String) obj;
            } else if ("width".equals(str)) {
                this.width = parseInteger(obj.toString());
            } else if ("height".equals(str)) {
                this.height = parseInteger(obj.toString());
            } else if (LayoutAttrDefine.Orientation.KEY.equals(str)) {
                this.orientation = LayoutAttrDefine.Orientation.parse((String) obj);
            } else if (LayoutAttrDefine.Gravity.Layout_Gravity.equals(str)) {
                this.layout_gravity = LayoutAttrDefine.Gravity.parse((String) obj);
            } else if (LayoutAttrDefine.MARGIN.equals(str)) {
                parseMargin((String) obj);
            } else if (LayoutAttrDefine.PADDING.equals(str)) {
                parsePadding((String) obj);
            } else if (LayoutAttrDefine.BG_Color.equals(str)) {
                this.bg_color = Color.parseColor((String) obj);
            } else if (LayoutAttrDefine.CENTERVERTICAL.equals(str)) {
                this.centerVertical = ((Boolean) obj).booleanValue();
            } else if (LayoutAttrDefine.CENTERHORIZONTAL.equals(str)) {
                this.centerHorizontal = ((Boolean) obj).booleanValue();
            } else if (LayoutAttrDefine.CENTERINPARENT.equals(str)) {
                this.centerInParent = ((Boolean) obj).booleanValue();
            } else if (LayoutAttrDefine.ALIGNPARENTLEFT.equals(str)) {
                this.alignParentLeft = ((Boolean) obj).booleanValue();
            } else if (LayoutAttrDefine.ALIGNPARENTBOTTOM.equals(str)) {
                this.alignParentBottom = ((Boolean) obj).booleanValue();
            } else if (LayoutAttrDefine.ALIGNPARENTRIGHT.equals(str)) {
                this.alignParentRight = ((Boolean) obj).booleanValue();
            } else if (LayoutAttrDefine.ALIGNPARENTTOP.equals(str)) {
                this.alignParentTop = ((Boolean) obj).booleanValue();
            } else if (LayoutAttrDefine.ALIGNWITHPARENTIFMISSING.equals(str)) {
                this.alignWithParentIfMissing = ((Boolean) obj).booleanValue();
            } else if (LayoutAttrDefine.ALIGNTOP.equals(str)) {
                this.alignTop = (String) obj;
            } else if (LayoutAttrDefine.ALIGNBOTTOM.equals(str)) {
                this.alignBottom = (String) obj;
            } else if (LayoutAttrDefine.ALIGNLEFT.equals(str)) {
                this.alignLeft = (String) obj;
            } else if (LayoutAttrDefine.ALIGNRIGHT.equals(str)) {
                this.alignRight = (String) obj;
            } else if (LayoutAttrDefine.ABOVE.equals(str)) {
                this.above = (String) obj;
            } else if (LayoutAttrDefine.BELOW.equals(str)) {
                this.below = (String) obj;
            } else if (LayoutAttrDefine.TOLEFTOF.equals(str)) {
                this.toLeftOf = (String) obj;
            } else if (LayoutAttrDefine.TORIGHTOF.equals(str)) {
                this.toRightOf = (String) obj;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void parseMargin(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                String[] split = str.split(",");
                if (split != null && split.length >= 4) {
                    int[] iArr = new int[4];
                    for (int i = 0; i < iArr.length; i++) {
                        iArr[i] = parseInteger(split[i].trim());
                    }
                    this.leftMargin = iArr[0];
                    this.topMargin = iArr[1];
                    this.rightMargin = iArr[2];
                    this.bottomMargin = iArr[3];
                }
            } catch (Exception e) {
            }
        }
    }

    public void parsePadding(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                String[] split = str.split(",");
                if (split != null && split.length >= 4) {
                    int[] iArr = new int[4];
                    for (int i = 0; i < iArr.length; i++) {
                        iArr[i] = parseInteger(split[i].trim());
                    }
                    this.leftPadding = iArr[0];
                    this.topPadding = iArr[1];
                    this.rightPadding = iArr[2];
                    this.bottomPadding = iArr[3];
                }
            } catch (Exception e) {
            }
        }
    }

    public static LayoutAttrSet createFrom(JSONObject jSONObject) {
        LayoutAttrSet layoutAttrSet = new LayoutAttrSet();
        if (jSONObject != null) {
            try {
                Iterator keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String str = keys.next() + "";
                    layoutAttrSet.addLayoutAttr(str, jSONObject.get(str));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return layoutAttrSet;
    }

    public void addLayoutAttr(String str, Object obj) {
        parseContent(str, obj);
        this.mAttrs.put(str, obj);
    }

    public boolean hasAttr(String str) {
        return this.mAttrs.containsKey(str);
    }

    public String getAttr(String str, String str2) {
        try {
            return (String) this.mAttrs.get(str);
        } catch (Exception e) {
            return str2;
        }
    }

    public int getAttr(String str, int i) {
        try {
            i = (Integer) this.mAttrs.get(str);
        } catch (Exception e) {
        }
        return i;
    }

    public int getPostFixedAttr(String str, int i) {
        try {
            i = parseInteger((String) this.mAttrs.get(str));
        } catch (Exception e) {
        }
        return i;
    }

    public long getAttr(String str, long j) {
        try {
            j = (Long) this.mAttrs.get(str);
        } catch (Exception e) {
        }
        return j;
    }

    private int parseInteger(java.lang.String r7) {
        try {
            return Integer.parseInt(r7);
        }catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }
}