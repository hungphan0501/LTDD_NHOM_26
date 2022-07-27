package com.example.android.teacheruser;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageButton;
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

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailTeacherSpotLightFragment extends Fragment {
    ImageButton imageButton;
    TextView txt_name, txt_level,txt_monhoc, txt_age, txt_gender, txt_address, txt_subject, txt_method;
    String name;
    ArrayList<Account> listTeacher;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_user2, container, false);
        imageButton = v.findViewById(R.id.back);
        txt_name = v.findViewById(R.id.txt_name);
        txt_level = v.findViewById(R.id.txt_level);
        txt_age = v.findViewById(R.id.txt_age);
        txt_gender = v.findViewById(R.id.txt_gender);
        txt_address = v.findViewById(R.id.txt_address);
        txt_subject = v.findViewById(R.id.txt_subject);
        txt_method = v.findViewById(R.id.txt_method);
        txt_monhoc = v.findViewById(R.id.txt_monhoc);
        txt_level = v.findViewById(R.id.level);

        Bundle bundle=getArguments();
        String id=bundle.getString("id");//nhận dữ liệu từ bundle

        DataClient dataClient = APIUtils.getData();//lấy dữ liệu ra
        Call<List<Account>> callback = dataClient.teacherUser(id);
        callback.enqueue(new Callback<List<Account>>() {
            @Override
            public void onResponse(Call<List<Account>> call, Response<List<Account>> response) {
                if(response.body().size()>0) {
                    listTeacher = (ArrayList<Account>) response.body();
                        txt_name.setText(listTeacher.get(0).getName());
                        txt_address.setText(listTeacher.get(0).getAddress());
                        txt_age.setText(listTeacher.get(0).getDob().substring(0,4));
                        if (listTeacher.get(0).getPerr() == "0"){
                            txt_method.setText("Online");
                        }else {
                            txt_method.setText("Offline");
                        }
                        if (listTeacher.get(0).getGender() == "1"){
                            txt_gender.setText("Nữ");
                        }else {
                            txt_gender.setText("Nam");
                        }
                        txt_subject.setText(listTeacher.get(0).getEmail());

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
                if(listSubjects.size()>0) {
                    for(int i = 0; i<listSubjects.size(); i++){
                        if((Integer.parseInt(listSubjects.get(i).getMethod()) ==1)) {
                            txt_method.setText("Online");
                        }else if((Integer.parseInt(listSubjects.get(i).getMethod()) ==2)) {
                            txt_method.setText("Offline");
                        }
                        else{
                            txt_method.setText("Online và Offline");
                        }
//                        txt_level.setText(listSubjects.get(i).getLevel());
                    }
                }
                else
                    Toast.makeText(getContext(), "khong co", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<List<my_post>> call, Throwable t) {
                Toast.makeText(getContext(), "loi"+t, Toast.LENGTH_SHORT).show();
            }
        });
//
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragment4(new Fragment_home());
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
