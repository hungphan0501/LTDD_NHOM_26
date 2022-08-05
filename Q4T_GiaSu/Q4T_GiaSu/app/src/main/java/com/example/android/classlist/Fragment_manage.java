package com.example.android.classlist;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android.Retrofig2.APIUtils;
import com.example.android.Retrofig2.DataClient;
import com.example.android.create.CreateTeacherFragment;
import com.example.android.get_student;
import com.example.android.giasu.Fragment_profile;
import com.example.android.giasu.Login;
import com.example.android.giasu.R;
import com.example.android.teacherclass.DetailPostFragment;
import com.example.android.tutar;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Fragment_manage extends Fragment {
    public Login login;

    private RecyclerView rcvRoom;
    private List<my_post> roomList;
    private ManageAdapter roomAdapter;
    private my_post room;
    public static Context context;

    String id =login.id,i=login.perr;
    public String idcan="";
    public Fragment_manage() {
    }

    ;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_manage, container, false);
        ImageView img_back = v.findViewById(R.id.img_back);
        ImageView btn_them = v.findViewById(R.id.btn_them);
        rcvRoom = v.findViewById(R.id.rcv_users);
        roomAdapter = new ManageAdapter(roomList, new interfaceListPost() {
            @Override
            public void onItemClick(Room room) {
                replaceFragment4(new CreateTeacherFragment() );
            }
        });
        rcvRoom.setLayoutManager(new LinearLayoutManager(getContext()));
        rcvRoom.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        img_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragment4(new Fragment_profile());
            }
        });

        btn_them.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragment4(new CreateTeacherFragment());
            }
        });

        getRoomList();
        return v;
    }

    private void replaceFragment4(Fragment fragment) {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.main, fragment).addToBackStack(null).commit();
    }
    private void getRoomList() {
        DataClient dataClient = APIUtils.getData();
        Call<List<my_post>> callback = dataClient.get_my_post(id);
        callback.enqueue(new Callback<List<my_post>>() {
            @Override
            public void onResponse(Call<List<my_post>> call, Response<List<my_post>> response) {
                ArrayList<my_post> listRoom = (ArrayList<my_post>) response.body();
                roomAdapter = new ManageAdapter(getContext(),listRoom, room);
                rcvRoom.setAdapter(roomAdapter);
            }

            @Override
            public void onFailure(Call<List<my_post>> call, Throwable t) {

            }
        });
//        callback.enqueue(new Callback<List<Room>>() {
//            @Override
//            public void onResponse(Call<List<Room>> call, Response<List<Room>> response) {
//                ArrayList<Room> listRoom = (ArrayList<Room>) response.body();
//                roomAdapter = new ManageAdapter(listRoom, room);
//                rcvRoom.setAdapter(roomAdapter);
//            }
//            @Override
//            public void onFailure(Call<List<Room>> call, Throwable t) {
//            }
//        });
    }



    private String idperr(){

        if (i.equals("0")) {

            DataClient dataClient = APIUtils.getData();
            Call<List<get_student>> callback = dataClient.get_student(id);
            callback.enqueue(new Callback<List<get_student>>() {
                @Override
                public void onResponse(Call<List<get_student>> call, Response<List<get_student>> response) {
                    idcan =response.body().get(0).getStudent_id();

                }

                @Override
                public void onFailure(Call<List<get_student>> call, Throwable t) {


                }
            });
        } else {
            DataClient dataClient = APIUtils.getData();
            Call<List<tutar>> callback = dataClient.get_tutor(id);
            callback.enqueue(new Callback<List<tutar>>() {
                @Override
                public void onResponse(Call<List<tutar>> call, Response<List<tutar>> response) {
                    ArrayList<tutar> accountsList = (ArrayList<tutar>) response.body();

                    idcan =response.body().get(0).getTutor_id().toString().trim();

                }

                @Override
                public void onFailure(Call<List<tutar>> call, Throwable t) {

                }
            });
        }
        return idcan;

    }

    public void deletedoor(my_post room){
        new AlertDialog.Builder(getContext()).
                setTitle("Thông báo")
                .setMessage("Bạn muốn xóa thông tin này ")
                .setPositiveButton("Có", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {


                    }
                })
                .setNegativeButton("không", null).show();
    }
}
