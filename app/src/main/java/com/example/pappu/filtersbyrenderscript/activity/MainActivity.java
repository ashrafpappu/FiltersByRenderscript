package com.example.pappu.filtersbyrenderscript.activity;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v8.renderscript.Allocation;
import android.support.v8.renderscript.RenderScript;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.pappu.filtersbyrenderscript.utils.ImageUtils;
import com.example.pappu.filtersbyrenderscript.R;
import com.example.pappu.filtersbyrenderscript.filters.RSImageProcessing;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private static int RESULT_LOAD = 1;
    private Button pickImage;
    private String Tag = "Mainactivity";
    String img_Decodable_Str;
    ImageView imgView;
    private static final int REQUEST_CODE_PERMISSION = 2;
    private static String[] PERMISSIONS_REQ = {
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.CAMERA
    };
    private RenderScript rs = null;
    private Button normalButton,bwButton,brightnessButton;
    Bitmap bitmap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //density();
        isExternalStorageWritable();
        isExternalStorageReadable();

        // For API 23+ you need to request the read/write permissions even if they are already in your manifest.
        int currentapiVersion = android.os.Build.VERSION.SDK_INT;

        if (currentapiVersion >= Build.VERSION_CODES.M) {
            verifyPermissions(this);
        }
        imgView = (ImageView) findViewById(R.id.imageview);
        pickImage = (Button) findViewById(R.id.pick_image);
        normalButton = (Button)findViewById(R.id.normal);
        bwButton = (Button)findViewById(R.id.blackwhite);
        brightnessButton = (Button)findViewById(R.id.brightness);
        normalButton.setOnClickListener(this);
        brightnessButton.setOnClickListener(this);
        bwButton.setOnClickListener(this);
        pickImage.setOnClickListener(this);
    }

    public void loadImagefromGallery() {
        // Create intent to Open Image applications like Gallery, Google Photos
        Intent galleryIntent = new Intent(Intent.ACTION_PICK,
                android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        // Start the Intent
        startActivityForResult(galleryIntent, RESULT_LOAD);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        try {
            // When an Image is picked
            if (requestCode == RESULT_LOAD && resultCode == RESULT_OK
                    && null != data) {
                // Get the Image from data

                Uri selectedImage = data.getData();
                String[] filePathColumn = { MediaStore.Images.Media.DATA };

                // Get the cursor
                Cursor cursor = getContentResolver().query(selectedImage,
                        filePathColumn, null, null, null);
                // Move to first row
                cursor.moveToFirst();

                int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
                img_Decodable_Str = cursor.getString(columnIndex);
                cursor.close();
                rs = RenderScript.create(this);
                bitmap =  BitmapFactory
                        .decodeFile(img_Decodable_Str);

                if(bitmap.getWidth()>720)
                bitmap= ImageUtils.resizeBitmap(bitmap,
                        720);
                // Set the Image in ImageView after decoding the String
                imgView.setImageBitmap(bitmap);
                pickImage.setVisibility(View.GONE);
                normalButton.setVisibility(View.VISIBLE);
                bwButton.setVisibility(View.VISIBLE);
                brightnessButton.setVisibility(View.VISIBLE);

            } else {
                Toast.makeText(this, "Hey pick your image first",
                        Toast.LENGTH_LONG).show();
            }
        } catch (Exception e) {
            Toast.makeText(this, "Something went embrassing", Toast.LENGTH_LONG)
                    .show();
        }

    }
    void applyFilter(int filter,Bitmap fakeBitmap){
        Allocation allocationYuvOut;
        allocationYuvOut = Allocation.createFromBitmap(rs, fakeBitmap,
                Allocation.MipmapControl.MIPMAP_NONE, Allocation.USAGE_SCRIPT);
        RSImageProcessing.applyFilter(allocationYuvOut,fakeBitmap,this,filter ,rs);

        RSImageProcessing.destroyFilter(filter);
    }

    @Override
    public void onClick(View view) {
        Bitmap fakeBitmap = null;
        switch (view.getId()){
           case R.id.pick_image:
            loadImagefromGallery();
            break;
            case R.id.normal:
                imgView.setImageBitmap(bitmap);
                break;
            case R.id.blackwhite:
                fakeBitmap = bitmap.copy(bitmap.getConfig(), true);
               applyFilter(RSImageProcessing.FilterType.BlackWhiteFilter,fakeBitmap);
                imgView.setImageBitmap(fakeBitmap);
                break;

            case R.id.brightness:
                fakeBitmap = bitmap.copy(bitmap.getConfig(), true);
                applyFilter(RSImageProcessing.FilterType.BrightContrastFilter,fakeBitmap);
                imgView.setImageBitmap(fakeBitmap);
                break;
        }
    }
    private static boolean verifyPermissions(Activity activity) {
        // Check if we have write permission
        int write_permission = ActivityCompat.checkSelfPermission(activity, Manifest.permission.WRITE_EXTERNAL_STORAGE);
        int read_persmission = ActivityCompat.checkSelfPermission(activity, Manifest.permission.READ_EXTERNAL_STORAGE);
        int camera_permission = ActivityCompat.checkSelfPermission(activity, Manifest.permission.CAMERA);

        if (write_permission != PackageManager.PERMISSION_GRANTED ||
                read_persmission != PackageManager.PERMISSION_GRANTED ||
                camera_permission != PackageManager.PERMISSION_GRANTED) {
            // We don't have permission so prompt the user
            ActivityCompat.requestPermissions(
                    activity,
                    PERMISSIONS_REQ,
                    REQUEST_CODE_PERMISSION
            );
            return false;
        } else {
            return true;
        }
    }


    private boolean isExternalStorageWritable() {
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state)) {
            return true;
        }
        return false;
    }

    /* Checks if external storage is available to at least read */

    private boolean isExternalStorageReadable() {
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state) ||
                Environment.MEDIA_MOUNTED_READ_ONLY.equals(state)) {
            return true;
        }
        return false;
    }
}
