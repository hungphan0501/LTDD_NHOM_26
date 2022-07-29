package com.example.android.teacheruser;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.android.Account;
import com.example.android.Retrofig2.APIUtils;
import com.example.android.Retrofig2.DataClient;
import com.example.android.classlist.my_post;
import com.example.android.giasu.Fragment_home;
import com.example.android.giasu.R;
import com.example.android.mess.MessFragment2;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailTeacherSpotLightFragment extends Fragment {
    ImageView back;
    TextView txt_name,txt_phone,txt_cv, txt_level,txt_bd, txt_age, txt_gender, txt_address,txt_luong1,txt_luong2, txt_subject;
    String name;
    CheckBox cbOn, cbOff;
    Button btn_contact;
    ArrayList<Account> listTeacher;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_user2, container, false);
        back = v.findViewById(R.id.img_back);
        txt_cv =v.findViewById(R.id.txt_cv);
        txt_name = v.findViewById(R.id.txtName);
        txt_phone = v.findViewById(R.id.phone);
        txt_gender = v.findViewById(R.id.gioi);
        txt_bd = v.findViewById(R.id.bd);
        txt_address = v.findViewById(R.id.address);
        txt_subject = v.findViewById(R.id.monhoc);
        cbOn = v.findViewById(R.id.checkbox1);
        cbOff =v.findViewById(R.id.checkbox2);
        txt_luong1 = v.findViewById(R.id.luong11);
        txt_luong2 = v.findViewById(R.id.luong22);
        btn_contact = v.findViewById(R.id.btn_contact);
//        txt_method = v.findViewById(R.id.txt_method);
//        txt_monhoc = v.findViewById(R.id.txt_monhoc);
        txt_level = v.findViewById(R.id.level);

        Bundle bundle=getArguments();
        String id=bundle.getString("id");//nhận dữ liệu từ bundle
        System.out.println("IDDDDDDDDDDDDDDDDDDD: " + id);
        String id_user = "";

        DataClient dataClient = APIUtils.getData();//lấy dữ liệu ra
        Call<List<Account>> callback = dataClient.teacherUser(id);
        callback.enqueue(new Callback<List<Account>>() {
            @Override
            public void onResponse(Call<List<Account>> call, Response<List<Account>> response) {
                if(response.body().size()>0) {
                    listTeacher = (ArrayList<Account>) response.body();
                    txt_name.setText(listTeacher.get(0).getName());
                    txt_phone.setText(listTeacher.get(0).getPhone());
                    txt_address.setText(listTeacher.get(0).getAddress());
                    txt_bd.setText(listTeacher.get(0).getDob());
                    if (listTeacher.get(0).getGender() == "1"){
                        txt_gender.setText("Nữ");
                    }else {
                        txt_gender.setText("Nam");
                    }
                } else {
                    Toast.makeText(getActivity(), "lỗi" + response.body(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<Account>> call, Throwable t) {

            }
        });

        Call<List<my_post>> list = dataClient.get_my_post(id);
        list.enqueue(new Callback<List<my_post>>() {
            @Override
            public void onResponse(Call<List<my_post>> call, Response<List<my_post>> res) {
                ArrayList<my_post> listSubjects = (ArrayList<my_post>) res.body();
                String result ="",onn = "",offf="";
                if(listSubjects.size()>0) {
                    for(int i = 0; i<listSubjects.size(); i++){
                        result +=listSubjects.get(i).getSubject()+ " " +listSubjects.get(i).getGrade() + " | ";
                        if((Integer.parseInt(listSubjects.get(i).getMethod()) ==1)) {
                            onn =listSubjects.get(i).getFee()+"đ/Buổi("+listSubjects.get(i).getHour()+")";
                            cbOn.setChecked(true);
                        }else if((Integer.parseInt(listSubjects.get(i).getMethod()) ==2)) {
                            offf =listSubjects.get(i).getFee()+"đ/Buổi("+listSubjects.get(i).getHour()+")";
                            cbOff.setChecked(true);
                        }
                        else{
                            onn =listSubjects.get(i).getFee()+"đ/Buổi("+listSubjects.get(i).getHour()+")";
                            offf =listSubjects.get(i).getFee()+"đ/Buổi("+listSubjects.get(i).getHour()+")";
                            cbOn.setChecked(true);
                            cbOff.setChecked(true);
                        }


                    }
                    txt_subject.setText(result);
                    txt_luong1.setText(onn);
                    txt_luong2.setText(offf);
                }
                else
                    Toast.makeText(getContext(), "khong co", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<List<my_post>> call, Throwable t) {
                Toast.makeText(getContext(), "loi"+t, Toast.LENGTH_SHORT).show();
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragment4(new Fragment_home());
            }
        });

        btn_contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragment4(new MessFragment2());
            }
        });

        return v;
    }


    private void replaceFragment4(Fragment fragment) {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.main, fragment).addToBackStack(null).commit();
    }
    private void getDetailSpotLightList() {
        DataClient dataClient = APIUtils.getData();
        Call<List<DetailTeacherSpotLightClass>> callback = dataClient.getDetailTeacherSpotLight(name);
        callback.enqueue(new Callback<List<DetailTeacherSpotLightClass>>() {
            @Override
            public void onResponse(Call<List<DetailTeacherSpotLightClass>> call, Response<List<DetailTeacherSpotLightClass>> response) {

            }

            @Override
            public void onFailure(Call<List<DetailTeacherSpotLightClass>> call, Throwable t) {

            }
        });

    }
}
