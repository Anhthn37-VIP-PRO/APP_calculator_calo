package com.diet.simplecaloriecounter.simplecaloriecounter.ui.photo;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.diet.simplecaloriecounter.simplecaloriecounter.MainActivity;
import com.diet.simplecaloriecounter.simplecaloriecounter.R;

import java.io.IOException;

public class PhotoFragment extends Fragment {

    private static final int CAMERA_PERMISSION_REQUEST_CODE = 1002;
    private static final int REQUEST_IMAGE_CAPTURE = 1;

    private ImageView imageView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ((MainActivity)getActivity()).getSupportActionBar().setTitle("Photo");
        View view = inflater.inflate(R.layout.fragment_photo, container, false);


        imageView = view.findViewById(R.id.imageView);
        Button captureButton = view.findViewById(R.id.captureButton);


        captureButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                requestCameraPermission();
            }
        });

        return view;
    }

    private void requestCameraPermission() {
        if (ContextCompat.checkSelfPermission(requireActivity(), Manifest.permission.CAMERA) ==
                PackageManager.PERMISSION_GRANTED) {
            dispatchTakePictureIntent();
        } else {
            ActivityCompat.requestPermissions(requireActivity(),
                    new String[]{Manifest.permission.CAMERA},
                    CAMERA_PERMISSION_REQUEST_CODE);
        }
    }

    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == getActivity().RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            displayCapturedImage(imageBitmap);
        }
    }

    private void displayCapturedImage(Bitmap bitmap) {
        Glide.with(this)
                .load(bitmap)
                .into(imageView);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == CAMERA_PERMISSION_REQUEST_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                dispatchTakePictureIntent();
            } else {
                Toast.makeText(requireContext(), "Camera permission denied", Toast.LENGTH_SHORT).show();
            }
        }
    }
}