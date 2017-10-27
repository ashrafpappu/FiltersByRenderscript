package com.example.pappu.filtersbyrenderscript.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;

/**
 * Created by hello on 10/26/17.
 */

public class ImageUtils {
    public static Bitmap resizeBitmap(Bitmap bm, int reqWidth) {

        int width = bm.getWidth();

        int height = bm.getHeight();

        float aspect = (float) width / height;

        float scaleWidth = reqWidth;

        float scaleHeight = scaleWidth / aspect; // yeah!

        // create a matrix for the manipulation

        Matrix matrix = new Matrix();

        // resize the bit map

        matrix.postScale(scaleWidth / width, scaleHeight / height);

        // recreate the new Bitmap

        Bitmap resizedBitmap = Bitmap.createBitmap(bm, 0, 0, width, height,
                matrix, true);


        bm.recycle();


        return resizedBitmap;
    }
}
