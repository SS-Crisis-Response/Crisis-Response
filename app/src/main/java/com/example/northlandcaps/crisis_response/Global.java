package com.example.northlandcaps.crisis_response;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;

public class Global {
    public static boolean active;
    //theme types
    public static int textnormalcolors = Color.parseColor("#FF000000");
    public static int textlightcolors = Color.parseColor("#5c5c5c");
    public static int textdarkcolors = Color.parseColor("#FFBFBFBF");
    public static boolean animationon = false;

    //lists of buildings and rooms
    public static String[] item = {"YRC", "Parking Lot", "Synergy House"};
    public static String[] items = {"Bathrooms",
            "Board Room",
            "CAC",
            "Childcare Room",
            "Clinic",
            "Conference Room",
            "Downstairs office",
            "Drop-in",
            "Fitness Room",
            "Front Bathrooms",
            "Great Room",
            "Gym",
            "Kitchen/Dining Room",
            "Laundry Room",
            "Library",
            "Med Room",
            "Reception",
            "Recording Studio",
            "Staff Cubes",
            "Staff Kitchen",
            "Teaching Kitchen",
            "Upstairs bedrooms",
            "Upstairs Group Room",
            "Upstairs office",
            "Youth Alley"};
    public static String CurrentBuilding = "Nothing";
    public static String CurrentRoom = "Nothing";
//normal colors
    public static int[] normalcolor = {Color.parseColor("#679acf"), Color.parseColor("#3b5e94")};
    public static GradientDrawable NormalGD = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, normalcolor);
//dark colors
    static int[] darkcolor = {Color.parseColor("#213351"), Color.parseColor("#000268")};
    public static GradientDrawable DarkGD = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, darkcolor);
//light colors
    static int[] lightcolor = {Color.parseColor("#eff0ff"), Color.parseColor("#65a1ff")};
    public static GradientDrawable LightGD = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, lightcolor);

    public static int themetype = 1;
}