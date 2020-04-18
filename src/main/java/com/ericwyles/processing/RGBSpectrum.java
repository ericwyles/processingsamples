package com.ericwyles.processing;

import java.util.ArrayList;
import java.util.List;

public class RGBSpectrum {
    private List<RGB> rgbList;
    private int currentRgb=0;
    private boolean increment=true;

    public RGBSpectrum() {
        rgbList = new ArrayList<>();
        int red, green, blue;
        int step=15;

        for (green = 0; green < 255; green=green+step) {
            for (blue = 0; blue < 255; blue=blue+step) {
                for (red = 0; red < 255; red=red+step) {
                    rgbList.add(new RGB(red,green,blue));
                }
            }
        }
    }

    public RGB getNextRgb() {
        RGB rgb = rgbList.get(currentRgb);

        if (increment) {
            currentRgb++;
            increment = currentRgb < rgbList.size()-1;
        } else {
            currentRgb--;
            increment = currentRgb == 0;
        }


        return rgb;
    }
}
