package com.example.android.giasu;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.android.Retrofig2.APIUtils;
import com.example.android.Retrofig2.DataClient;
import com.example.android.Subject;
import com.example.android.classlist.Fragment_manage;
import com.example.android.get_student;
import com.example.android.profile_static;
import com.example.android.tutar;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import com.example.android.classlist.my_post;

public class profile_tutor extends Fragment {

    Login login;
    TextView upload, txtName, txtcv, phone, gioi, address, td, date, upload1, ic_class, class1,monday ,monhoc,mon2,bd,on,off;
//    String url = "http://192.168.1.7:8080/appGS/proflie.php";
    Button btn_contact;
    ImageView img_back;
    CheckBox cb1,cb2;
    String id = login.id;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_profile1, container, false);
        upload = v.findViewById(R.id.upload);
        txtName = v.findViewById(R.id.txtName);
        txtcv = v.findViewById(R.id.textView74);
        phone = v.findViewById(R.id.phone);
        gioi = v.findViewById(R.id.gioi);
        address = v.findViewById(R.id.address);
        td = v.findViewById(R.id.level);
        bd = v.findViewById(R.id.bd);
        cb1 = v.findViewById(R.id.checkbox1);
        cb2 = v.findViewById(R.id.checkbox2);
        img_back = v.findViewById(R.id.img_back);
//        date = v.findViewById(R.id.date);
//        upload1 = v.findViewById(R.id.upload2);
//        ic_class = v.findViewById(R.id.ic_class);
        monday = v.findViewById(R.id.txt_mon);
        monhoc =v.findViewById(R.id.monhoc);
        btn_contact = v.findViewById(R.id.btn_contact);
        on= v.findViewById(R.id.luong11);
        off = v.findViewById(R.id.luong22);

        txtName.setText(profile_static.getName());
        txtcv.setText(profile_static.getPerr());
        phone.setText(profile_static.getPhone());
        gioi.setText(profile_static.getGender());
        address.setText(profile_static.getAddress());
        bd.setText(profile_static.getDob());

//        date.setText(profile_static.getDob());


        String i = td.getText().toString().trim();

//        if (i.equals("0")) {
//            ic_class.setVisibility(View.INVISIBLE);
//            class1.setVisibility(View.INVISIBLE);
//            DataClient dataClient = APIUtils.getData();
//            Call<List<get_student>> callback = dataClient.get_student(id);
//            callback.enqueue(new Callback<List<get_student>>() {
//                @Override
//                public void onResponse(Call<List<get_student>> call, Response<List<get_student>> response) {
//                    td.setText(response.body().get(0).getLevel());
//                }
//
//                @Override
//                public void onFailure(Call<List<get_student>> call, Throwable t) {
//                    Toast.makeText(getContext(), ""+t, Toast.LENGTH_SHORT).show();
//                    td.setText(t.toString());
//                }
//            });
//
//
//
//
//
//        } else {
            DataClient dataClient = APIUtils.getData();
            Call<List<tutar>> callback = dataClient.get_tutor(id);
            callback.enqueue(new Callback<List<tutar>>() {
                @Override
                public void onResponse(Call<List<tutar>> call, Response<List<tutar>> response) {
                    if(response.body().size()>0) {

//                        mon1.setText(response.body().get(0).getGrade());
                        td.setText(response.body().get(0).getLevel());
                    }
                    else
                        Toast.makeText(getContext(), "khong co", Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onFailure(Call<List<tutar>> call, Throwable t) {
                    Toast.makeText(getContext(), "loi"+t, Toast.LENGTH_SHORT).show();
                }
            });
//        }
//        DataClient dataClient = APIUtils.getData();
        Call<List<my_post>> list = dataClient.get_my_post(id);
        list.enqueue(new Callback<List<my_post>>() {
            @Override
            public void onResponse(Call<List<my_post>> call, Response<List<my_post>> res) {
                ArrayList<my_post> listSubjects = (ArrayList<my_post>) res.body();
                String result ="",onn = "",offf="";
                if(listSubjects.size()>0) {
                    for(int i = 0; i<listSubjects.size(); i++){
                        result +=listSubjects.get(i).getSubject()+listSubjects.get(i).getGrade() + " | ";
                        if((Integer.parseInt(listSubjects.get(i).getMethod()) ==1)) {
                            onn =listSubjects.get(i).getFee()+"đ/Buổi("+listSubjects.get(i).getHour()+")";
                            cb1.setChecked(true);
                        }else if((Integer.parseInt(listSubjects.get(i).getMethod()) ==2)) {
                            offf =listSubjects.get(i).getFee()+"đ/Buổi("+listSubjects.get(i).getHour()+")";
                            cb2.setChecked(true);
                        }
                        else{
                            onn =listSubjects.get(i).getFee()+"đ/Buổi("+listSubjects.get(i).getHour()+")";
                            offf =listSubjects.get(i).getFee()+"đ/Buổi("+listSubjects.get(i).getHour()+")";
                            cb1.setChecked(true);
                            cb2.setChecked(true);
                        }


                    }
                    monhoc.setText(result);
                    on.setText(onn);
                    off.setText(offf);
                }
                else
                    Toast.makeText(getContext(), "khong co", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<List<my_post>> call, Throwable t) {
                Toast.makeText(getContext(), "loi"+t, Toast.LENGTH_SHORT).show();
            }
        });
//        ArrayList<Subject> listSubjects = (ArrayList<Subject>) dataClient.get_list_subjects(id);
//        for (Subject subject : listSubjects) {
//            monhoc.setText(subject.getName_subjects() + subject.getClassname()+" | ");
//        }


        if (txtcv.getText().toString().equals("1"))
            txtcv.setText("Gia Sư");
        else
            txtcv.setText("Học Sinh");
        if (gioi.getText().toString().equals("0"))
            gioi.setText("Nam");
        else
            gioi.setText("Nữ");

        upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragment4(new update_profile());
            }
        });
        img_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment4(new Fragment_profile()); 
            }
        });
        btn_contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment4(new Fragment_manage());
            }
        });
//        upload1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                replaceFragment4(new update_profile());
//            }
//        });


//        DataClient dataClient= APIUtils.getData();
//        Call<List<Account>> callback=dataClient.profile(id.trim());
//        callback.enqueue(new Callback<List<Account>>() {
//            @Override
//            public void onResponse(Call<List<Account>> call, Response<List<Account>> response) {
//                ArrayList<Account> accountsList= (ArrayList<Account>) response.body();
//
//                txtName.setText(accountsList.get(0).getName().trim());
//
////                if(accountsList.size()>0){
////                    Toast.makeText(getContext(), "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
////
////                    // register.setText(accountsList.get(0).getName());
////                    // profile.pro.setName(accountsList.get(0).getName());
////
////                }
//            }
//
//            @Override
//            public void onFailure(Call<List<Account>> call, Throwable t) {
//                Toast.makeText(getContext(), "Tài khoảng không tồn tại", Toast.LENGTH_SHORT).show();
//            }
//
//            });


//            DataClient dataClient= APIUtils.getData();
//            Call<List<Account>> callback=dataClient.profile("3");
//            callback.enqueue(new Callback<List<Account>>() {
//                @Override
//                public void onResponse(Call<List<Account>> call, Response<List<Account>> response) {
//                    ArrayList<Account> accountsList1= (ArrayList<Account>) response.body();
//
//
//
//                    if(accountsList1.size()>0){
//                        Toast.makeText(getContext(), "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
//                        txtName.setText(accountsList1.get(0).getName().trim());
//                        txtcv.setText(accountsList1.get(0).getPerr());
//                        if(txtcv.getText().toString().equals("0"))
//                            txtcv.setText("Gia Sư");
//                        else
//                            txtcv.setText("Học Sinh");
//                        phone.setText(accountsList1.get(0).getPhone());
//                        gioi.setText(accountsList1.get(0).getGender());
//                        if(gioi.getText().toString().equals("0"))
//                            gioi.setText("Nam");
//                        else
//                            gioi.setText("Nữ");
//                        address.setText(accountsList1.get(0).getAddress());
//                        td.setText(accountsList1.get(0).getPerr());
//                        date.setText(accountsList1.get(0).getDob());
//
//                    }
//                }
//
//                @Override
//                public void onFailure(Call<List<Account>> call, Throwable t) {
//                    Toast.makeText(getContext(), "Tài khoảng không tồn tại", Toast.LENGTH_SHORT).show();
//                }
//            });
//
        return v;
    }

    private void replaceFragment4(Fragment fragment) {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.main, fragment).commit();
    }
}