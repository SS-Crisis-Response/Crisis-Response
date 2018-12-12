package com.example.northlandcaps.crisis_response;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;

public class Global {
    public static boolean active;
    public static int textnormalcolors = Color.parseColor("#FF000000");
    public static int textlightcolors = Color.parseColor("#5c5c5c");
    public static int textdarkcolors = Color.parseColor("#FFBFBFBF");
    public static boolean animationon = false;
    public static String[] item = {"YRC", "Parking Lot", "Synergy House"};
    public static String[] items = {"Clinic","Staff Cubes","Staff Kitchen","Fitness Room","CAC","Bathrooms","Conference Room", "Board Room", "Teaching Kitchen","Recording Studio", "Childcare Room", "Drop-in", "Youth Alley", "Gym", "Laundry Room", "Front Bathrooms", "Reception","Downstairs office","Upstairs office", "Upstairs Group Room", "Upstairs bedrooms", "Library", "Med Room", "Great Room", "Kitchen/Dining Room"};
    public static String CurrentBuilding = "Nothing";
    public static String CurrentRoom = "Nothing";


    public static int[] normalcolor = {Color.parseColor("#679acf"), Color.parseColor("#3b5e94")};
    public static GradientDrawable NormalGD = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, normalcolor);

    static int[] darkcolor = {Color.parseColor("#213351"), Color.parseColor("#000268")};
    public static GradientDrawable DarkGD = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, darkcolor);

    static int[] lightcolor = {Color.parseColor("#eff0ff"), Color.parseColor("#65a1ff")};
    public static GradientDrawable LightGD = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, lightcolor);

    public static int themetype = 1;
}