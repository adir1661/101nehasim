package com.adirabargil.adirstools.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.firebase.ui.storage.images.FirebaseImageLoader;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Adir on 3/5/2018.
 */

public class OtherTools {
    public static Bitmap imageViewToBitmap(ImageView imageView) {
        imageView.setDrawingCacheEnabled(true);
        imageView.buildDrawingCache();
        return imageView.getDrawingCache();
//        return ((BitmapDrawable)imageView.getDrawable()).getBitmap();

    }

    // -------- upload the picture to firebase storage------------
    public static class UploadPictureToFirebaseAsync extends AsyncTask<Uri, ProgressBar, Void> {
        private final ProgressDialog mDialog;
        private Context mContext;
        private final StorageReference mStorageRef;
        String mFilePath;
        //TODO: Add file Path for the current picture...

        public UploadPictureToFirebaseAsync(Context context, String filePath) {
            this.mContext = context;
            this.mDialog = new ProgressDialog(context);
            this.mDialog.setIndeterminate(true);
            this.mDialog.setMessage("Uploading Docs");
            this.mStorageRef = FirebaseStorage.getInstance().getReference();
            this.mFilePath =filePath;
        }


        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            final ProgressDialog progressDialog = mDialog;
            progressDialog.setTitle("Uploading...");
            progressDialog.show();

        }

        @Override
        protected Void doInBackground(Uri... uris) {
            final StorageReference mainPicRef = mStorageRef.child(mFilePath);
            mainPicRef.putFile(uris[0])
                    .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                            mDialog.dismiss();
                            Toast.makeText(mContext.getApplicationContext(), "Picture Uploaded", Toast.LENGTH_LONG).show();
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception exception) {
                            mDialog.dismiss();
                            Toast.makeText(mContext.getApplicationContext(), exception.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    })
                    .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                            double progress = (100.0 * taskSnapshot.getBytesTransferred());
                            taskSnapshot.getTotalByteCount();
                            mDialog.setMessage(((int) progress) + "% Uploading...");
                        }
                    });
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
//            Toast.makeText(mContext,"uploaded picture", Toast.LENGTH_LONG).show();
        }
    }
    // -------- download the picture from firebase storage------------
    public static class DownloadPictureFromFirebaseAsync extends AsyncTask<Uri, ProgressBar, Bitmap> {
        private final ProgressDialog mDialog;
        private final WeakReference<Context> mContext;
        private final StorageReference mStorageRef;
        private final String pathString;
        private Bitmap mBitmap;
        ImageView mImageView;

        //TODO: Add file Path for the current picture...

        public DownloadPictureFromFirebaseAsync(Context context, String pathString/*for example"images/MainPicture.jpg" */, ImageView imageView) {
            this.mContext = new WeakReference<Context>(context);
            this.mDialog = new ProgressDialog(context);
            this.pathString = pathString;
            this.mDialog.setIndeterminate(true);
            this.mDialog.setMessage("Uploading Docs");
            this.mStorageRef = FirebaseStorage.getInstance().getReference();
            this.mImageView = imageView;
        }


        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            final ProgressDialog progressDialog = mDialog;
            progressDialog.setTitle("Downloading...");
//            progressDialog.show();

        }

        @Override
        protected Bitmap doInBackground(Uri... uris) {
//            final StorageReference pathReference = mStorageRef.child(pathString);
//            Glide.with(mContext.get() /* context */)
//                    .using(new FirebaseImageLoader())
//                    .load(pathReference)
//                    .into(mImageView);
            return null;//imageViewToBitmap(mImageView);
        }

        @Override
        protected void onPostExecute(Bitmap aBitmap) {
            super.onPostExecute(aBitmap);
            mBitmap = aBitmap;
//            Toast.makeText(mContext.get(),
//                    "download successful", Toast.LENGTH_LONG).show();
            Glide.with(mContext.get())
                    .using(new FirebaseImageLoader())
                    .load(mStorageRef.child(pathString))
                    .into(mImageView);
        }

        public Bitmap getValue() {
            if (mBitmap != null)
                return mBitmap;
            else return null;
        }
    }
    public static Bitmap getBitmapFromURL(String src) {
        try {
            URL url = new URL(src);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoInput(true);
            connection.connect();
            InputStream input = connection.getInputStream();
            Bitmap myBitmap = BitmapFactory.decodeStream(input);
            return myBitmap;
        } catch (IOException e) {
            // Log exception
            return null;
        }
    }
}
