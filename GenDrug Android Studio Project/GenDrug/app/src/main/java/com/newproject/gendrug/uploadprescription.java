package com.newproject.gendrug;

import android.Manifest;
import android.app.Dialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.Image;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.StrictMode;
import android.preference.PreferenceManager;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.error.VolleyError;
import com.android.volley.request.SimpleMultiPartRequest;
import com.android.volley.toolbox.Volley;
import com.newproject.gendrug.ApiHelper.JsonField;
import com.newproject.gendrug.ApiHelper.WebURL;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class uploadprescription extends AppCompatActivity implements View.OnClickListener {
    EditText enterpres,enteremail;
    Button  uploadpres,uploadsubmit;
    ImageView ProfilePreview;

    private String mCameraFileName;
    private String imagePath;
    private static final int PICK_IMAGE_REQUEST =001;
    private static final int CAMERA_REQUEST =002;

    private static final int PERMISSION_REQUEST=100;
    Dialog ImageChooserDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uploadprescription);
        StrictMode.VmPolicy.Builder builder=new StrictMode.VmPolicy.Builder();
        StrictMode.setVmPolicy(builder.build());

        enterpres= (EditText)findViewById(R.id.etenterpres);
        uploadpres=(Button)findViewById(R.id.buploadpres);
        enteremail=(EditText)findViewById(R.id.etenteremail);
        uploadsubmit= (Button)findViewById(R.id.buploadsubmit);
        ProfilePreview=(ImageView)findViewById(R.id.ProfilePreview);

        uploadpres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getPermission();
            }
        });

        uploadsubmit.setOnClickListener(this);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void getPermission() {
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.M)
        {
            if(ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) !=  PackageManager.PERMISSION_GRANTED
                    && ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) !=PackageManager.PERMISSION_GRANTED
                    && ActivityCompat.checkSelfPermission(this, Manifest.permission.CAMERA) !=PackageManager.PERMISSION_GRANTED)
            {
                ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.CAMERA}, PERMISSION_REQUEST);
            }else{
                showOptionPopUp();
            }
        }else{
                showOptionPopUp();
        }
    }

    private void showOptionPopUp() {
        ImageChooserDialog = new Dialog(this);
        ImageChooserDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        ImageChooserDialog.setContentView(R.layout.image_chooser_option);
        TextView tvTakePicture=ImageChooserDialog.findViewById(R.id.tv_choose_image_take_picture);
        TextView tvPickGallery=ImageChooserDialog.findViewById(R.id.tv_choose_image_from_gallery);

        tvPickGallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ImageChooserDialog.dismiss();
                pickImage();
            }
        });

        tvTakePicture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ImageChooserDialog.dismiss();
                takePicture();
            }
        });
        ImageChooserDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        ImageChooserDialog.show();
        ImageChooserDialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode== CAMERA_REQUEST && resultCode==RESULT_OK){
            String photoURI = PreferenceManager.getDefaultSharedPreferences(this).getString("USER_PHOTO_FILE","");

            if(photoURI != null){
                imagePath=photoURI;
                Log.d("IMAGE_PATH",imagePath);
                setImage(imagePath);
            }else{
                Toast.makeText(this,"Capture image uri not found", Toast.LENGTH_SHORT).show();
            }
        }else if(requestCode==PICK_IMAGE_REQUEST&& resultCode== RESULT_OK){
            if (data !=null){
                Uri uri = data.getData();
                String[] projection ={MediaStore.Images.Media.DATA};
                Cursor cursor = getContentResolver().query(uri, projection,null, null, null);
                cursor.moveToFirst();
                int index= cursor.getColumnIndex(projection[0]);
                imagePath=cursor.getString(index);
                Log.d("IMAGE_PATH",imagePath);
                setImage(imagePath);
            }

        }
    }

    private void setImage(String imagePath) {
        Bitmap bitmap = BitmapFactory.decodeFile(imagePath);
        ProfilePreview.setVisibility(View.VISIBLE);
        ProfilePreview.setImageBitmap(bitmap);
    }

    private void takePicture() {
        if(getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA)){
            Date date=new Date();
            DateFormat df = new SimpleDateFormat("hh-mm-ss");
            File storageDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);

            String strPath = storageDirectory.getPath()+"/"+"ImageUploalDemo";

            storageDirectory=new File(strPath);
            storageDirectory.mkdirs();
            strPath=storageDirectory.getPath()+"/"+"Report_"+df.format(date)+".jpg";
            mCameraFileName=storageDirectory.getPath();

            PreferenceManager.getDefaultSharedPreferences(this).edit().putString("USER_PHOTO_FILE", mCameraFileName).apply();
            Uri outuri = Uri.fromFile(storageDirectory);
            Intent intent= new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            intent.putExtra(MediaStore.EXTRA_OUTPUT, outuri);
            startActivityForResult(intent,CAMERA_REQUEST);

        }
    }

    private void pickImage() {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent, PICK_IMAGE_REQUEST);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case android.R.id.home:
                onBackPressed();
                break;
        }

        return super.onOptionsItemSelected(item);

    }

    @Override
    public void onClick(View view) {
        sendUploadRequest();
        Toast.makeText(uploadprescription.this, "Upload done successfully", Toast.LENGTH_SHORT).show();
    }

    private void sendUploadRequest() {
        SimpleMultiPartRequest stringRequest=new SimpleMultiPartRequest(Request.Method.POST, WebURL.UPLOAD_PRESCRIPTION_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                parseUploadResponse(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }

        });
        if (imagePath !=null){
            stringRequest.addFile(JsonField.UPLOAD_PHOTO,imagePath);
        }
        stringRequest.addStringParam(JsonField.UPLOAD_NAME, enterpres.getText().toString().trim());
        stringRequest.addStringParam(JsonField.UPLOAD_EMAIL, enteremail.getText().toString().trim());

        RequestQueue requestQueue = Volley.newRequestQueue(uploadprescription.this);
        requestQueue.add(stringRequest);

    }

    private void parseUploadResponse(String response) {
        Log.d("RESPONSE",response);
        try {
            JSONObject jsonObject = new JSONObject(response);
            int flag = jsonObject.optInt(JsonField.FLAG);
            if(flag==1){
             String message = jsonObject.optString(JsonField.MESSAGE);
             Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
             finish();
            }else{
                String message = jsonObject.optString(JsonField.MESSAGE);
                Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }


    }

}

