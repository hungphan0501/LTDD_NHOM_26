package com.example.android.create;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.android.Register.Register_Teacher;
import com.example.android.Retrofig2.APIUtils;
import com.example.android.Retrofig2.DataClient;
import com.example.android.giasu.Login;
import com.example.android.giasu.R;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CreateTeacherFragment extends Fragment {
    Spinner sprmonhoc, srplopgoc;
    String sobuoi, gio, money, hinhthuc, address, mon, lop;
    public Login login;
    String id=login.id , perr=login.perr;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_createteacher, container, false);

        sprmonhoc = (Spinner) v.findViewById(R.id.menu);
        srplopgoc = (Spinner) v.findViewById(R.id.menu1);
        Spinner sprAddress = (Spinner) v.findViewById(R.id.edtaddress);

        ArrayList<String> monhocList = new ArrayList<>();
        monhocList.add("Toán");
        monhocList.add("Lý");
        monhocList.add("Hóa");
        monhocList.add("Văn");
        monhocList.add("Sử");
        monhocList.add("Địa");
        monhocList.add("Tiếng Anh");
        monhocList.add("GDCD");
        monhocList.add("Sinh");
        ArrayAdapter monhocAdapter = new ArrayAdapter(getActivity(), R.layout.support_simple_spinner_dropdown_item, monhocList);
        monhocAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sprmonhoc.setAdapter(monhocAdapter);

        ArrayList<String> lophocList = new ArrayList<>();

        lophocList.add("12");
        lophocList.add("11");
        lophocList.add("10");
        lophocList.add("9");
        lophocList.add("8");
        lophocList.add("7");
        lophocList.add("6");
        lophocList.add("5");
        lophocList.add("4");
        lophocList.add("3");
        lophocList.add("2");
        lophocList.add("1");

        ArrayAdapter lophocAdapter = new ArrayAdapter(getActivity(), R.layout.support_simple_spinner_dropdown_item, lophocList);
        lophocAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        srplopgoc.setAdapter(lophocAdapter);

        srplopgoc.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                lop = lophocList.get(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        sprmonhoc.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                mon = monhocList.get(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ArrayList<String> addressList = new ArrayList<>();
        addressList.add("Phường An Khánh,Tp Thủ Đức ");
        addressList.add("Phường An Lợi Đông,Tp Thủ Đức ");
        addressList.add("Phường An Phú,Tp Thủ Đức ");
        addressList.add("Phường Bình Chiểu,Tp Thủ Đức ");
        addressList.add("Phường Bình Thọ,Tp Thủ Đức ");
        addressList.add("Phường Bình Trưng Đông,Tp Thủ Đức ");
        addressList.add("Phường Bình Trưng Tây,Tp Thủ Đức ");
        addressList.add("Phường Cát Lái,Tp Thủ Đức ");
        addressList.add("Phường Hiệp Bình Chánh,Tp Thủ Đức ");
        addressList.add("Phường Hiệp Bình Phước,Tp Thủ Đức ");
        addressList.add("Phường Hiệp Phú,Tp Thủ Đức ");
        addressList.add("Phường Linh Chiểu,Tp Thủ Đức ");
        addressList.add("Phường Linh Đông,Tp Thủ Đức ");
        addressList.add("Phường Linh Tây,Tp Thủ Đức ");
        addressList.add("Phường Linh Trung,Tp Thủ Đức ");
        addressList.add("Phường Linh Xuân,Tp Thủ Đức ");
        addressList.add("Phường Long Bình,Tp Thủ Đức ");
        addressList.add("Phường Long Phước,Tp Thủ Đức ");
        addressList.add("Phường Long Thạnh Mỹ,Tp Thủ Đức ");
        addressList.add("Phường Long Trường,Tp Thủ Đức ");
        addressList.add("Phường Phú Hữu,Tp Thủ Đức ");
        addressList.add("Phường Phước Bình,Tp Thủ Đức ");
        addressList.add("Phường Phước Long A,Tp Thủ Đức ");
        addressList.add("Phường Phước Long B,Tp Thủ Đức ");
        addressList.add("Phường Tam Bình,Tp Thủ Đức ");
        addressList.add("Phường Tam Phú,Tp Thủ Đức ");
        addressList.add("Phường Tăng Nhơn Phú A,Tp Thủ Đức ");
        addressList.add("Phường Tăng Nhơn Phú B,Tp Thủ Đức ");
        addressList.add("Phường Tân Phú,Tp Thủ Đức ");
        addressList.add("Phường Thảo Điền,Tp Thủ Đức ");
        addressList.add("Phường Thạnh Mỹ Lợi,Tp Thủ Đức ");
        addressList.add("Phường Thủ Thiêm,Tp Thủ Đức ");
        addressList.add("Phường Trường Thạnh,Tp Thủ Đức ");
        addressList.add("Phường Trường Thọ,Tp Thủ Đức ");
        addressList.add("Phường Bến Nghé,Quận 1");
        addressList.add("Phường Bến Thành,Quận 1");
        addressList.add("Phường Cầu Kho,Quận 1");
        addressList.add("Phường Cầu Ông Lãnh,Quận 1");
        addressList.add("Phường Cô Giang,Quận 1");
        addressList.add("Phường Đa Kao,Quận 1");
        addressList.add("Phường Nguyễn Cư Trinh,Quận 1");
        addressList.add("Phường Nguyễn Thái Bình,Quận 1");
        addressList.add("Phường Phạm Ngũ Lão,Quận 1");
        addressList.add("Phường Tân Định,Quận 1");
        addressList.add("Phường 01,Quận 3");
        addressList.add("Phường 02,Quận 3");
        addressList.add("Phường 03,Quận 3");
        addressList.add("Phường 04,Quận 3");
        addressList.add("Phường 05,Quận 3");
        addressList.add("Phường Võ Thị Sáu,Quận 3");
        addressList.add("Phường 09,Quận 3");
        addressList.add("Phường 10,Quận 3");
        addressList.add("Phường 11,Quận 3");
        addressList.add("Phường 12,Quận 3");
        addressList.add("Phường 13,Quận 3");
        addressList.add("Phường 14,Quận 3");
        addressList.add("Phường 01,Quận 4");
        addressList.add("Phường 02,Quận 4");
        addressList.add("Phường 03,Quận 4");
        addressList.add("Phường 04,Quận 4");
        addressList.add("Phường 06,Quận 4");
        addressList.add("Phường 08,Quận 4");
        addressList.add("Phường 09,Quận 4");
        addressList.add("Phường 10,Quận 4");
        addressList.add("Phường 13,Quận 4");
        addressList.add("Phường 14,Quận 4");
        addressList.add("Phường 15,Quận 4");
        addressList.add("Phường 16,Quận 4");
        addressList.add("Phường 18,Quận 4");
        addressList.add("Phường 01, Quận 5");
        addressList.add("Phường 02, Quận 5");
        addressList.add("Phường 03, Quận 5");
        addressList.add("Phường 04, Quận 5");
        addressList.add("Phường 05, Quận 5");
        addressList.add("Phường 06, Quận 5");
        addressList.add("Phường 07, Quận 5");
        addressList.add("Phường 08, Quận 5");
        addressList.add("Phường 09, Quận 5");
        addressList.add("Phường 10, Quận 5");
        addressList.add("Phường 11, Quận 5");
        addressList.add("Phường 12, Quận 5");
        addressList.add("Phường 13, Quận 5");
        addressList.add("Phường 14, Quận 5");
        addressList.add("Phường 01, Quận 6");
        addressList.add("Phường 02, Quận 6");
        addressList.add("Phường 03, Quận 6");
        addressList.add("Phường 04, Quận 6");
        addressList.add("Phường 05, Quận 6");
        addressList.add("Phường 06, Quận 6");
        addressList.add("Phường 07, Quận 6");
        addressList.add("Phường 08, Quận 6");
        addressList.add("Phường 09, Quận 6");
        addressList.add("Phường 10, Quận 6");
        addressList.add("Phường 11, Quận 6");
        addressList.add("Phường 12, Quận 6");
        addressList.add("Phường 13, Quận 6");
        addressList.add("Phường 14, Quận 6");
        addressList.add("Phường Bình Thuận, Quận 7");
        addressList.add("Phường Phú Mỹ, Quận 7");
        addressList.add("Phường Phú Thuận, Quận 7");
        addressList.add("Phường Tân Hưng, Quận 7");
        addressList.add("Phường Tân Kiểng, Quận 7");
        addressList.add("Phường Tân Phong, Quận 7");
        addressList.add("Phường Tân Phú, Quận 7");
        addressList.add("Phường Tân Quy, Quận 7");
        addressList.add("Phường Tân Thuận Đông, Quận 7");
        addressList.add("Phường Tân Thuận Tây, Quận 7");
        addressList.add("Phường 01, Quận 8");
        addressList.add("Phường 02, Quận 8");
        addressList.add("Phường 03, Quận 8");
        addressList.add("Phường 04, Quận 8");
        addressList.add("Phường 05, Quận 8");
        addressList.add("Phường 06, Quận 8");
        addressList.add("Phường 07, Quận 8");
        addressList.add("Phường 08, Quận 8");
        addressList.add("Phường 09, Quận 8");
        addressList.add("Phường 10, Quận 8");
        addressList.add("Phường 11, Quận 8");
        addressList.add("Phường 12, Quận 8");
        addressList.add("Phường 13, Quận 8");
        addressList.add("Phường 14, Quận 8");
        addressList.add("Phường 15, Quận 8");
        addressList.add("Phường 16, Quận 8");
        addressList.add("Phường 02, Quận 10");
        addressList.add("Phường 04, Quận 10");
        addressList.add("Phường 05, Quận 10");
        addressList.add("Phường 06, Quận 10");
        addressList.add("Phường 07, Quận 10");
        addressList.add("Phường 08, Quận 10");
        addressList.add("Phường 09, Quận 10");
        addressList.add("Phường 10, Quận 10");
        addressList.add("Phường 11, Quận 10");
        addressList.add("Phường 12, Quận 10");
        addressList.add("Phường 13, Quận 10");
        addressList.add("Phường 14, Quận 10");
        addressList.add("Phường 15, Quận 10");
        addressList.add("Phường 01, Quận 11");
        addressList.add("Phường 02, Quận 11");
        addressList.add("Phường 03, Quận 11");
        addressList.add("Phường 04, Quận 11");
        addressList.add("Phường 05, Quận 11");
        addressList.add("Phường 06, Quận 11");
        addressList.add("Phường 07, Quận 11");
        addressList.add("Phường 08, Quận 11");
        addressList.add("Phường 09, Quận 11");
        addressList.add("Phường 10, Quận 11");
        addressList.add("Phường 11, Quận 11");
        addressList.add("Phường 12, Quận 11");
        addressList.add("Phường 13, Quận 11");
        addressList.add("Phường 14, Quận 11");
        addressList.add("Phường 15, Quận 11");
        addressList.add("Phường 16, Quận 11");
        addressList.add("Phường An Phú Đông, Quận 12");
        addressList.add("Phường Đông Hưng Thuận, Quận 12");
        addressList.add("Phường Hiệp Thành, Quận 12");
        addressList.add("Phường Tân Chánh Hiệp, Quận 12");
        addressList.add("Phường Tân Hưng Thuận, Quận 12");
        addressList.add("Phường Tân Thới Hiệp, Quận 12");
        addressList.add("Phường Tân Thới Nhất, Quận 12");
        addressList.add("Phường Thạnh Lộc, Quận 12");
        addressList.add("Phường Thạnh Xuân, Quận 12");
        addressList.add("Phường Thới An, Quận 12");
        addressList.add("Phường Trung Mỹ Tây, Quận 12");



        ArrayAdapter addressAdapter = new ArrayAdapter(getActivity(), R.layout.support_simple_spinner_dropdown_item, addressList);
        addressAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sprAddress.setAdapter(addressAdapter);

        sprAddress.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                address = addressList.get(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        Button btn_day1 = v.findViewById(R.id.btn_day1);
        Button btn_day2 = v.findViewById(R.id.btn_day2);
        Button btn_day3 = v.findViewById(R.id.btn_day3);
        Button btn_day4 = v.findViewById(R.id.btn_day4);
        Button btn_day5 = v.findViewById(R.id.btn_day5);
        Button btn_day6 = v.findViewById(R.id.btn_day6);
        Button btn_day7 = v.findViewById(R.id.btn_day7);

        btn_day2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_day2.setBackgroundResource(R.drawable.button_11);
                sobuoi = btn_day2.getText().toString();
                btn_day1.setBackgroundResource(R.drawable.button_22);
                btn_day3.setBackgroundResource(R.drawable.button_22);
                btn_day4.setBackgroundResource(R.drawable.button_22);
                btn_day5.setBackgroundResource(R.drawable.button_22);
                btn_day6.setBackgroundResource(R.drawable.button_22);
                btn_day7.setBackgroundResource(R.drawable.button_22);

            }
        });
        btn_day3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                btn_day3.setBackgroundResource(R.drawable.button_11);
                sobuoi = btn_day3.getText().toString();
                btn_day1.setBackgroundResource(R.drawable.button_22);
                btn_day2.setBackgroundResource(R.drawable.button_22);
                btn_day4.setBackgroundResource(R.drawable.button_22);
                btn_day5.setBackgroundResource(R.drawable.button_22);
                btn_day6.setBackgroundResource(R.drawable.button_22);
                btn_day7.setBackgroundResource(R.drawable.button_22);
            }
        });
        btn_day4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                btn_day4.setBackgroundResource(R.drawable.button_11);
                sobuoi = btn_day4.getText().toString();
                btn_day1.setBackgroundResource(R.drawable.button_22);
                btn_day3.setBackgroundResource(R.drawable.button_22);
                btn_day2.setBackgroundResource(R.drawable.button_22);
                btn_day5.setBackgroundResource(R.drawable.button_22);
                btn_day6.setBackgroundResource(R.drawable.button_22);
                btn_day7.setBackgroundResource(R.drawable.button_22);
            }
        });
        btn_day5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                btn_day5.setBackgroundResource(R.drawable.button_11);
                sobuoi = btn_day5.getText().toString();
                btn_day1.setBackgroundResource(R.drawable.button_22);
                btn_day3.setBackgroundResource(R.drawable.button_22);
                btn_day4.setBackgroundResource(R.drawable.button_22);
                btn_day2.setBackgroundResource(R.drawable.button_22);
                btn_day6.setBackgroundResource(R.drawable.button_22);
                btn_day7.setBackgroundResource(R.drawable.button_22);
            }
        });
        btn_day6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_day6.setBackgroundResource(R.drawable.button_11);
                sobuoi = btn_day6.getText().toString();
                btn_day1.setBackgroundResource(R.drawable.button_22);
                btn_day3.setBackgroundResource(R.drawable.button_22);
                btn_day4.setBackgroundResource(R.drawable.button_22);
                btn_day5.setBackgroundResource(R.drawable.button_22);
                btn_day2.setBackgroundResource(R.drawable.button_22);
                btn_day7.setBackgroundResource(R.drawable.button_22);
            }
        });
        btn_day7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_day7.setBackgroundResource(R.drawable.button_11);
                sobuoi = btn_day7.getText().toString();
                btn_day1.setBackgroundResource(R.drawable.button_22);
                btn_day3.setBackgroundResource(R.drawable.button_22);
                btn_day4.setBackgroundResource(R.drawable.button_22);
                btn_day5.setBackgroundResource(R.drawable.button_22);
                btn_day6.setBackgroundResource(R.drawable.button_22);
                btn_day2.setBackgroundResource(R.drawable.button_22);
            }
        });
        btn_day1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_day1.setBackgroundResource(R.drawable.button_11);
                sobuoi = btn_day1.getText().toString();
                btn_day2.setBackgroundResource(R.drawable.button_22);
                btn_day3.setBackgroundResource(R.drawable.button_22);
                btn_day4.setBackgroundResource(R.drawable.button_22);
                btn_day5.setBackgroundResource(R.drawable.button_22);
                btn_day6.setBackgroundResource(R.drawable.button_22);
                btn_day7.setBackgroundResource(R.drawable.button_22);
            }
        });

        Button btn_hour1 = v.findViewById(R.id.button13);
        Button btn_hour2 = v.findViewById(R.id.button);
        Button btn_hour3 = v.findViewById(R.id.button3);
        Button btn_hour4 = v.findViewById(R.id.button4);
        Button btn_hour5 = v.findViewById(R.id.button5);

        btn_hour1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_hour1.setBackgroundResource(R.drawable.button_1);
                gio = btn_hour1.getText().toString();
                btn_hour2.setBackgroundResource(R.drawable.button_2);
                btn_hour3.setBackgroundResource(R.drawable.button_2);
                btn_hour4.setBackgroundResource(R.drawable.button_2);
                btn_hour5.setBackgroundResource(R.drawable.button_2);


            }
        });
        btn_hour2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_hour2.setBackgroundResource(R.drawable.button_1);
                gio = btn_hour2.getText().toString();
                btn_hour1.setBackgroundResource(R.drawable.button_2);
                btn_hour3.setBackgroundResource(R.drawable.button_2);
                btn_hour4.setBackgroundResource(R.drawable.button_2);
                btn_hour5.setBackgroundResource(R.drawable.button_2);


            }
        });
        btn_hour3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_hour3.setBackgroundResource(R.drawable.button_1);
                gio = btn_hour3.getText().toString();
                btn_hour2.setBackgroundResource(R.drawable.button_2);
                btn_hour1.setBackgroundResource(R.drawable.button_2);
                btn_hour4.setBackgroundResource(R.drawable.button_2);
                btn_hour5.setBackgroundResource(R.drawable.button_2);


            }
        });
        btn_hour4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_hour4.setBackgroundResource(R.drawable.button_1);
                gio = btn_hour4.getText().toString();
                btn_hour2.setBackgroundResource(R.drawable.button_2);
                btn_hour3.setBackgroundResource(R.drawable.button_2);
                btn_hour1.setBackgroundResource(R.drawable.button_2);
                btn_hour5.setBackgroundResource(R.drawable.button_2);


            }
        });
        btn_hour5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_hour5.setBackgroundResource(R.drawable.button_1);
                gio = btn_hour5.getText().toString();
                btn_hour2.setBackgroundResource(R.drawable.button_2);
                btn_hour3.setBackgroundResource(R.drawable.button_2);
                btn_hour4.setBackgroundResource(R.drawable.button_2);
                btn_hour1.setBackgroundResource(R.drawable.button_2);


            }
        });

        Button btn_money1 = v.findViewById(R.id.button6);
        Button btn_money2 = v.findViewById(R.id.button15);
        Button btn_money3 = v.findViewById(R.id.button14);

        btn_money1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_money1.setBackgroundResource(R.drawable.button_1);
                money = btn_money1.getText().toString();
                btn_money2.setBackgroundResource(R.drawable.button_2);
                btn_money3.setBackgroundResource(R.drawable.button_2);
            }
        });


        btn_money2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_money2.setBackgroundResource(R.drawable.button_1);
                money = btn_money2.getText().toString();
                btn_money1.setBackgroundResource(R.drawable.button_2);
                btn_money3.setBackgroundResource(R.drawable.button_2);
            }
        });
        btn_money3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_money3.setBackgroundResource(R.drawable.button_1);
                money = btn_money3.getText().toString();
                btn_money1.setBackgroundResource(R.drawable.button_2);
                btn_money2.setBackgroundResource(R.drawable.button_2);
            }
        });

        Button btn_hinhthuc1 = v.findViewById(R.id.button16);
        Button btn_hinhthuc2 = v.findViewById(R.id.btn_online);

        btn_hinhthuc1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_hinhthuc1.setBackgroundResource(R.drawable.button_1);
                hinhthuc = btn_hinhthuc1.getText().toString();
                btn_hinhthuc2.setBackgroundResource(R.drawable.button_2);
            }
        });
        btn_hinhthuc2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_hinhthuc2.setBackgroundResource(R.drawable.button_1);
                hinhthuc = btn_hinhthuc2.getText().toString();
                btn_hinhthuc1.setBackgroundResource(R.drawable.button_2);
            }
        });

        Button btn_ok = v.findViewById(R.id.btn_next);

        Bundle bundle = getArguments();

        btn_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (address.equals("") || mon.equals("") || lop.equals("") || sobuoi.equals("") || gio.equals("") || money.equals("") || hinhthuc.equals("")) {
                    Toast.makeText(getActivity(), "Bạn chưa chọn đủ thông tin", Toast.LENGTH_SHORT).show();
                } else {
//                    String id = bundle.getString("id").toString().trim();
//                    String perr = bundle.getString("perr").toString().trim();
                    DataClient Post = APIUtils.getData();
                    Call<String> callback = Post.post(id, sobuoi, hinhthuc, gio, money, lop, mon, address);
                    callback.enqueue(new Callback<String>() {
                        @Override
                        public void onResponse(Call<String> call, Response<String> response) {
                            String result = response.body();
                            if (result.equals("success")) {
                                showDialog(Gravity.BOTTOM);
                                btn_money1.setBackgroundResource(R.drawable.button_2);
                                btn_money2.setBackgroundResource(R.drawable.button_2);
                                btn_money3.setBackgroundResource(R.drawable.button_2);
                                btn_day1.setBackgroundResource(R.drawable.button_22);
                                btn_day2.setBackgroundResource(R.drawable.button_22);
                                btn_day3.setBackgroundResource(R.drawable.button_22);
                                btn_day4.setBackgroundResource(R.drawable.button_22);
                                btn_day5.setBackgroundResource(R.drawable.button_22);
                                btn_day6.setBackgroundResource(R.drawable.button_22);
                                btn_day7.setBackgroundResource(R.drawable.button_22);
                                btn_hinhthuc1.setBackgroundResource(R.drawable.button_2);
                                btn_hinhthuc2.setBackgroundResource(R.drawable.button_2);
                                btn_hour1.setBackgroundResource(R.drawable.button_2);
                                btn_hour2.setBackgroundResource(R.drawable.button_2);
                                btn_hour3.setBackgroundResource(R.drawable.button_2);
                                btn_hour4.setBackgroundResource(R.drawable.button_2);
                                btn_hour5.setBackgroundResource(R.drawable.button_2);

                            } else {
                                Toast.makeText(getActivity(), "thất bại" + response.body(), Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onFailure(Call<String> call, Throwable t) {
                            Toast.makeText(getActivity(), "Xảy ra lỗi " + t.toString(), Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        });

        return v;
    }

    private void showDialog(int gravity) {
        final Dialog dialog = new Dialog(getActivity());
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_post);
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

