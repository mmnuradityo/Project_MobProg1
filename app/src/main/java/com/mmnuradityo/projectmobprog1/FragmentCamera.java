package com.mmnuradityo.projectmobprog1;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;
import androidx.fragment.app.Fragment;

import java.io.File;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentCamera extends Fragment {

    // untuk android marshmallow atau diatasnya
    private static final String[] CAMERA_PERMISSION = {
            "android.permission.CAMERA",
            "android.permission.WRITE_EXTERNAL_STORAGE",
            "android.permission.READ_EXTERNAL_STORAGE",
    };
    private TextView tvTitle;
    private Button btnOpenCamera;
    private ImageView imgFromCamera;
    private String AUTHORITY = "com.mmnuradityo.projectmobprog1";
    private Uri filePath;
    // value bisa di isi apapun pastikan tidak boleh sama dengan request code yang lain
    private int REQUEST_CODE_CAMERA = 109;

    public FragmentCamera() {
    }

    // cek permission camera "untuk android marshmallow atau diatasnya"
    private static boolean checkCameraPermissions(Context context, String... perms) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            // batalkan proses bila versi android lollipop atau di bawahnya
            return true;
        }

        for (String perm : perms) {
            boolean hasPerm = (ContextCompat.checkSelfPermission(context, perm) ==
                    PackageManager.PERMISSION_GRANTED);
            if (!hasPerm) {
                return false;
            }
        }

        return true;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_camera, container, false);

        tvTitle = view.findViewById(R.id.title);
        btnOpenCamera = view.findViewById(R.id.btn_open_camera);
        imgFromCamera = view.findViewById(R.id.img_from_camera);

        btnOpenCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fileName = System.currentTimeMillis() + ".jpg";
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

                if (intent.resolveActivity(getActivity().getPackageManager()) != null) {
                    filePath = getFilePath(fileName);
                    intent.putExtra(MediaStore.EXTRA_OUTPUT, filePath);

                    // untuk android marshmallow atau diatasnya
                    if (checkCameraPermissions(getActivity(), CAMERA_PERMISSION)) {
                        startActivityForResult(intent, REQUEST_CODE_CAMERA);
                    } else {
                        requestPermissions(CAMERA_PERMISSION, REQUEST_CODE_CAMERA);
                    }
                }
            }
        });

        return view;
    }

    private Uri getFilePath(String fileName) {
        File path = new File(getActivity().getExternalCacheDir(), "camera");
        if (!path.exists()) {
            path.mkdir();
        }

        File image = new File(path, fileName);
        return FileProvider.getUriForFile(getActivity(), AUTHORITY, image);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK) {
            // check code and data image
            if (requestCode == 109 && filePath != null) {

                // set data image
                imgFromCamera.setImageURI(filePath);

                // get image name from file path
                String path = filePath.getPath();
                int index = path.lastIndexOf("/") + 1;
                String imageName = path.substring(index);

                // print image name
                tvTitle.setText(imageName);
                Toast.makeText(getActivity(),
                        "Success get " + imageName,
                        Toast.LENGTH_SHORT).show();
            }
        }
    }

}
