package com.foretree.commentview.canvasui;

public class LayoutAttrDefine {
    public static final String ABOVE = "above";
    public static final String ALIGNBOTTOM = "alignBottom";
    public static final String ALIGNLEFT = "alignLeft";
    public static final String TOLEFTOF = "toLeftOf";
    public static final String TORIGHTOF = "toRightOf";
    public static final String ALIGNPARENTBOTTOM = "alignParentBottom";
    public static final String ALIGNPARENTLEFT = "alignParentLeft";
    public static final String ALIGNPARENTRIGHT = "alignParentRight";
    public static final String ALIGNPARENTTOP = "alignParentTop";
    public static final String ALIGNRIGHT = "alignRight";
    public static final String ALIGNTOP = "alignTop";
    public static final String ALIGNWITHPARENTIFMISSING = "alignWithParentIfMissing";
    public static final String BELOW = "below";
    public static final String BG_Color = "bg_color";
    public static final String BorderColor = "border_color";
    public static final String BorderRadius = "border_radius";
    public static final String BorderWidth = "border_width";
    public static final String CENTERHORIZONTAL = "centerHorizontal";
    public static final String CENTERINPARENT = "centerInParent";
    public static final String CENTERVERTICAL = "centerVertical";
    public static final String Height = "height";
    public static final String ID = "id";
    public static final String MARGIN = "margin";
    public static final int MatchParent = -1;
    public static final String PADDING = "padding";
    public static final String[] RULES_HORIZONTAL = new String[]{TOLEFTOF, TORIGHTOF, ALIGNLEFT, ALIGNRIGHT};
    public static final String[] RULES_VERTICAL = new String[]{ABOVE, BELOW, ALIGNTOP, ALIGNBOTTOM};
    public static final String SKRINK_COLUMNS = "shrinkColumns";
    public static final String STRETCH_COLUMNS = "stretchColumns";
    public static final String Width = "width";
    public static final int WrapContent = -2;

    public static class Gravity {
        public static final int BOTTOM = 80;
        public static final int CENTER = 17;
        public static final int CENTER_HORIZONTAL = 1;
        public static final int CENTER_VERTICAL = 16;
        public static final String DEF_BOTTOM = "bottom";
        public static final String DEF_CENTER = "center";
        public static final String DEF_CENTER_HORIZONTAL = "center_horizontal";
        public static final String DEF_CENTER_VERTICAL = "center_vertical";
        public static final String DEF_LEFT = "left";
        public static final String DEF_RIGHT = "right";
        public static final String DEF_TOP = "top";
        public static final String Gravity = "gravity";
        public static final int LEFT = 3;
        public static final String Layout_Gravity = "layout_gravity";
        public static final int NONE = 0;
        public static final int RIGHT = 5;
        public static final int TOP = 48;


        public static int parse(String str) {
            if (DEF_TOP.equals(str)) {
                return 48;
            }
            if (DEF_BOTTOM.equals(str)) {
                return 80;
            }
            if (DEF_LEFT.equals(str)) {
                return 3;
            }
            if ("right".equals(str)) {
                return 5;
            }
            if (DEF_CENTER_VERTICAL.equals(str)) {
                return 16;
            }
            if (DEF_CENTER_HORIZONTAL.equals(str)) {
                return 1;
            }
            if (DEF_CENTER.equals(str)) {
                return 17;
            }
            return 3;
        }
    }

    public static class Orientation {
        public static final String DEF_Horizontal = "horizontal";
        public static final String DEF_Vertical = "vertical";
        public static final int Horizontal = 2;
        public static final String KEY = "orientation";
        public static final int Vertical = 1;


        public static int parse(String str) {
            if (DEF_Horizontal.equals(str)) {
                return 2;
            }
            return 1;
        }
    }

}