package com.example.android.teacherclass;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.android.Retrofig2.APIUtils;
import com.example.android.Retrofig2.DataClient;
import com.example.android.giasu.Fragment_mess;
import com.example.android.giasu.Fragment_home;
import com.example.android.giasu.Login;
import com.example.android.giasu.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TeacherClass2 extends Fragment {
    public Login user_id1;
    String id = user_id1.id;
    String gs = user_id1.perr;
    ImageView img;
    TextView txt_monHoc, txt_lop, txt_hocPhi, txt_diaChi, txt_hinhThucDay, txt_soBuoi, txt_soGio;
    Button btn_nhapLop, btn_traoDoi;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_detail_post, container, false);
        img = v.findViewById(R.id.img_back);
        txt_monHoc = v.findViewById(R.id.txt_monHoc);
        txt_lop = v.findViewById(R.id.txt_lop);
        txt_hocPhi = v.findViewById(R.id.txt_hocPhi);
        txt_diaChi = v.findViewById(R.id.txt_diaChi);
        txt_hinhThucDay = v.findViewById(R.id.txt_hinhThucDay);
        btn_nhapLop = v.findViewById(R.id.btn_nhanLop);
        txt_soBuoi = v.findViewById(R.id.txt_soBuoi);
        txt_soGio = v.findViewById(R.id.txt_soGio);
        btn_traoDoi = v.findViewById(R.id.btn_traoDoi);
        if (gs.equals("1")) {
            btn_nhapLop.setVisibility(View.VISIBLE);
            btn_traoDoi.setVisibility(View.VISIBLE);
            btn_traoDoi.setEnabled(false);
            btn_nhapLop.setEnabled(false);
        }
        btn_traoDoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragment4(new Fragment_mess());
            }
        });


        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragment4(new Fragment_home());
            }
        });
        Bundle bundle = getArguments();
        TeacherClass teacherClass = (TeacherClass) bundle.getSerializable("data");
       // Toast.makeText(getActivity(), "" + id + teacherClass.getLesson_detail_id() + teacherClass.getId(), Toast.LENGTH_SHORT).show();

        txt_hocPhi.setText((teacherClass.getFee()) + "VND");
        txt_soBuoi.setText(teacherClass.getNumber());
        txt_soGio.setText(teacherClass.getHour());
        txt_monHoc.setText(teacherClass.getSubject());
        txt_lop.setText(teacherClass.getGrade());
        txt_diaChi.setText(teacherClass.getAddress());
        if (teacherClass.getMethod() == "1") {
            txt_hinhThucDay.setText("Online");
        } else if ((teacherClass.getMethod() == "2")) {
            txt_hinhThucDay.setText("Offline");
        } else {
            txt_hinhThucDay.setText("Online,Offline");
        }

        btn_nhapLop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DataClient dataClient = APIUtils.getData();
                Call<String> callback = dataClient.insertLesson(teacherClass.getLesson_detail_id(), id, teacherClass.getId());
                callback.enqueue(new Callback<String>() {
                    @Override
                    public void onResponse(Call<String> call, Response<String> response) {
                        if (response.body().equals("indc")) {
                            openDialog(Gravity.BOTTOM);
                        } else {
                            openDialog1(Gravity.BOTTOM);
                        }
                    }

                    @Override
                    public void onFailure(Call<String> call, Throwable t) {

                    }
                });
            }
        });

        return v;
    }

    private void replaceFragment4(Fragment fragment) {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.main, fragment).addToBackStack(null).commit();
    }

    private void openDialog(int gravity) {
        final Dialog dialog = new Dialog(getActivity());
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_confirm);
        Window window = dialog.getWindow();
        if (window == null) {
            return;
        }
        window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        WindowManager.LayoutParams layoutParams = window.getAttributes();
        layoutParams.gravity = gravity;
        window.setAttributes(layoutParams);
        if (Gravity.BOTTOM == gravity) {
            dialog.setCancelable(true);
        } else {
            dialog.setCancelable(false);
        }
        dialog.show();
    }

    private void openDialog1(int gravity) {
        final Dialog dialog = new Dialog(getActivity());
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_confirm1);
        Window window = dialog.getWindow();
        if (window == null) {
            return;
        }
        window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        WindowManager.LayoutParams layoutParams = window.getAttributes();
        layoutParams.gravity = gravity;
        window.setAttributes(layoutParams);
        if (Gravity.BOTTOM == gravity) {
            dialog.setCancelable(true);
        } else {
            dialog.setCancelable(false);
        }
        dialog.show();
    }
}
