package com.example.android.giasu;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager2.widget.ViewPager2;

import com.example.android.Find.Fragment_Find;
import com.example.android.Find.Fragment_finduser;
import com.example.android.Retrofig2.APIUtils;
import com.example.android.Retrofig2.DataClient;
import com.example.android.banner.Photo;
import com.example.android.banner.PhotoAdapter;
import com.example.android.classlist.Room;
import com.example.android.classlist.RoomAdapter;
import com.example.android.classlist.RoomFragment;
import com.example.android.classlist1.Room1;
import com.example.android.classlist1.RoomAdapter1;
import com.example.android.classlist1.RoomFragment1;
import com.example.android.teacherclass.TeacherClassFragment;
import com.example.android.teacherclass.TeacherClassFragment1;
import com.example.android.teacheruser.ListFragment;

import java.util.ArrayList;
import java.util.List;

import me.relex.circleindicator.CircleIndicator3;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Fragment_home extends Fragment {
    View v;
    private TextView viewteacherall, viewroomall;
    private ViewPager2 mViewPager2;
    private ImageView img_find;
    private CircleIndicator3 mCircleIndicator3;
    private List<Photo> mListPhoto;
    private Handler mHandler = new Handler(Looper.getMainLooper());
    private Runnable mRunnable = new Runnable() {
        @Override
        public void run() {
            int current = mViewPager2.getCurrentItem();
            if (current == mListPhoto.size() - 1) {
                mViewPager2.setCurrentItem(0);
            } else {
                mViewPager2.setCurrentItem(current + 1);
            }
        }
    };

    private ArrayList<Room> roomList;
    private ArrayList<Room1> listRoom1;

    public Fragment_home() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.activity_home, container, false);
        viewteacherall = v.findViewById(R.id.txt_viewteacherall);
        viewroomall = v.findViewById(R.id.txt_viewroomall);
        img_find = v.findViewById(R.id.img_find);

        DataClient dataClient = APIUtils.getData();
        Call<List<Room1>> callback = dataClient.getRoomList1();
        callback.enqueue(new Callback<List<Room1>>() {
            @Override
            public void onResponse(Call<List<Room1>> call, Response<List<Room1>> response) {
                listRoom1 = (ArrayList<Room1>) response.body();
            }

            @Override
            public void onFailure(Call<List<Room1>> call, Throwable t) {

            }
        });

        viewteacherall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Bundle bundle =new Bundle(); // truyền dữ lệu qua Teacher
//                bundle.putSerializable("data3",listRoom1);
//                RoomFragment1 fragment_room1=new RoomFragment1();
//                fragment_room1.setArguments(bundle);
                replaceFragment4(new TeacherClassFragment1());
            }
        });
        viewroomall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle(); // truyền dữ lệu qua RoomFragment1
                bundle.putSerializable("data", listRoom1);
                RoomFragment1 fragment_room1 = new RoomFragment1();
                fragment_room1.setArguments(bundle);
                replaceFragment4(fragment_room1);
            }
        });

        Bundle bundle1 = getArguments();

        img_find.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragment4(new Fragment_Find());
            }
        });


        replaceFragment(new ListFragment());

        replaceFragment2(new RoomFragment());

        replaceFragment3(new TeacherClassFragment());


        mViewPager2 = v.findViewById(R.id.view_pager_2);
        mCircleIndicator3 = v.findViewById(R.id.circle_indicator_3);
        mListPhoto = getListPhoto();
        PhotoAdapter photoAdapter = new PhotoAdapter(this, mListPhoto);
        mViewPager2.setAdapter(photoAdapter);
        mCircleIndicator3.setViewPager(mViewPager2);
        mViewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                mHandler.removeCallbacks(mRunnable);
                mHandler.postDelayed(mRunnable, 3000);
            }
        });

        return v;

    }

    private void replaceFragment(Fragment fragment) {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.rcv_user1, fragment).commit();
    }

    private void replaceFragment2(Fragment fragment) {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.rcv_user2, fragment).commit();
    }

    private void replaceFragment3(Fragment fragment) {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.rcv_user3, fragment).commit();
    }

    private void replaceFragment4(Fragment fragment) {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.main, fragment).commit();
    }

    private List<Photo> getListPhoto() {
        List<Photo> list = new ArrayList<>();
        list.add(new Photo(R.drawable.banner1));
        list.add(new Photo(R.drawable.banner2));
        list.add(new Photo(R.drawable.banner3));
        return list;
    }

    @Override
    public void onPause() {
        super.onPause();
        mHandler.removeCallbacks(mRunnable);
    }

    @Override
    public void onResume() {
        super.onResume();
        mHandler.postDelayed(mRunnable, 3000);
    }
}
