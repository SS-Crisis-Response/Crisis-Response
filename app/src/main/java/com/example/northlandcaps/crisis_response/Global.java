package com.example.northlandcaps.crisis_response;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;

public class Global {
    public static boolean active;
    public static int textnormalcolors = Color.parseColor("#FF000000");
    public static int textlightcolors = Color.parseColor("#FF696969");
    public static int textdarkcolors = Color.parseColor("#FFBFBFBF");

    public static int[] normalcolor = {Color.parseColor("#679acf"), Color.parseColor("#3b5e94")};
    public static GradientDrawable NormalGD = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, normalcolor);

    static int[] darkcolor = {Color.parseColor("#213351"), Color.parseColor("#000268")};
    public static GradientDrawable DarkGD = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, darkcolor);

    static int[] lightcolor = {Color.parseColor("#65a1ff"), Color.parseColor("#0006ff")};
    public static GradientDrawable LightGD = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, lightcolor);

    public static int themetype = 1;
}