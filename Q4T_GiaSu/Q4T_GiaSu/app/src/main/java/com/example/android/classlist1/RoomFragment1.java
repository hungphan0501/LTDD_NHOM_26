package com.example.android.classlist1;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android.Find.user;
import com.example.android.Retrofig2.APIUtils;
import com.example.android.Retrofig2.DataClient;
import com.example.android.classlist.Room;
import com.example.android.classlist.RoomAdapter;
import com.example.android.get_student;
import com.example.android.giasu.Fragment_home;
import com.example.android.giasu.Login;
import com.example.android.giasu.R;
import com.example.android.mess.MessFragment2;
import com.example.android.mess.messFragment;
import com.example.android.tutar;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RoomFragment1 extends Fragment {
    View v;
    private RecyclerView rcvRoom1;
    private List<Room1> roomList1;
    private ImageView img_back;
    private RoomAdapter1 roomAdapter1;
    private Room1 room1;
    private Button btn_traoDoi;
    public Login login;
    String id =login.id,i=login.perr;
    public String idcan="";


    public RoomFragment1() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_listroomall, container, false);
        rcvRoom1 = v.findViewById(R.id.rcv_user32);
        img_back = v.findViewById(R.id.img_back);
        btn_traoDoi = v.findViewById(R.id.btn_traoDoi12);
        rcvRoom1.setLayoutManager(new LinearLayoutManager(getContext()));
        rcvRoom1.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        img_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragment4(new Fragment_home());

            }
        });

//        btn_traoDoi.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                replaceFragment4(new MessFragment2());
//            }
//        });


        Bundle bundle=getArguments();
        ArrayList<Room1> listRoom1 = (ArrayList<Room1>) bundle.getSerializable("data");;
        roomAdapter1 = new RoomAdapter1(listRoom1,room1);

        rcvRoom1.setAdapter(roomAdapter1);


        return v;
    }

    private void replaceFragment4(Fragment fragment) {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.main, fragment).addToBackStack(null).commit();
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
}
