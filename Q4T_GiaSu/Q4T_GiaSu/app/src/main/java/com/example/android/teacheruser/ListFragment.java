package com.example.android.teacheruser;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android.Retrofig2.APIUtils;
import com.example.android.Retrofig2.DataClient;
import com.example.android.giasu.R;
import com.example.android.spotlightTeacher;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ListFragment extends Fragment {
    View v;
    private RecyclerView rcvUser;
    private List<TeacherUser> mListUser;
    private TeacherUserAdapter userAdapter;
    private spotlightTeacher mSpotlightTeacher;
    String name;
    ArrayList<TeacherUser> listTeacher;
    public ListFragment() {
    };

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_list, container, false);
        rcvUser = v.findViewById(R.id.rcv_user);
        rcvUser.setLayoutManager(new LinearLayoutManager(getContext()));
        rcvUser.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        getSpotLightList();
        return v;
    }

    private void replaceFragment4(Fragment fragment) {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.main, fragment).addToBackStack(null).commit();
    }

    private void getSpotLightList() {
        DataClient dataClient = APIUtils.getData();
        Call<List<TeacherUser>> callback = dataClient.getSpotlightTeacher();
        callback.enqueue(new Callback<List<TeacherUser>>() {
            @Override
            public void onResponse(Call<List<TeacherUser>> call, Response<List<TeacherUser>> response) {
                listTeacher = (ArrayList<TeacherUser>) response.body();
                // sua cai nay la click dc
                userAdapter = new TeacherUserAdapter(listTeacher, new RecyclerViewClickInterface() {
                    @Override
                    public void onItemClick(String id) {
                        Bundle bundle = new Bundle();//truyen du lieu qua DetailTeacherSpotLightFragment
                        bundle.putString("id",id);
                        DetailTeacherSpotLightFragment fragment1=new DetailTeacherSpotLightFragment();
                        fragment1.setArguments(bundle);
                        replaceFragment4(fragment1);
                    }
                });
                rcvUser.setAdapter(userAdapter);
            }

            @Override
            public void onFailure(Call<List<TeacherUser>> call, Throwable t) {

            }
        });
    }
}