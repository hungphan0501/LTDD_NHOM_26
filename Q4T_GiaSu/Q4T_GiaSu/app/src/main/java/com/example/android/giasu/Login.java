package com.example.android.giasu;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.android.Account;
import com.example.android.Register.Register;
import com.example.android.Retrofig2.APIUtils;
import com.example.android.Retrofig2.DataClient;
import com.example.android.profile_static;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Login extends AppCompatActivity {

    TextView register;
    Button btnLogin;
    EditText edtEmail, edtPass;
    String email, pass;
    public static String id="1";
    public static String name="name",perr="0";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_login);

        register = findViewById(R.id.register);
        btnLogin = findViewById(R.id.btnlogin);
        edtEmail = findViewById(R.id.edttxtemail);
        edtPass = findViewById(R.id.txt_pass);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                email = edtEmail.getText().toString().trim();
                pass = edtPass.getText().toString().trim();
                if (email.length() > 0 && pass.length() > 0) {
                    DataClient dataClient = APIUtils.getData();
                    Call<List<Account>> callback = dataClient.LoginData(email, pass);
                    callback.enqueue(new Callback<List<Account>>() {
                        @Override
                        public void onResponse(Call<List<Account>> call, Response<List<Account>> response) {
                                ArrayList<Account> accountsList = (ArrayList<Account>) response.body();
                            if (accountsList.size() > 0) {

                                profile_static.setName(accountsList.get(0).getName());
                                name =accountsList.get(0).getName();
                                profile_static.setPerr(accountsList.get(0).getPerr());
                                profile_static.setPhone(accountsList.get(0).getPhone());
                                profile_static.setGender(accountsList.get(0).getGender());
                                profile_static.setAddress(accountsList.get(0).getAddress());
                                profile_static.setPerr(accountsList.get(0).getPerr());
                                perr =accountsList.get(0).getPerr();
                                profile_static.setDob(accountsList.get(0).getDob());
                                profile_static.setImage(accountsList.get(0).getImage());
                                profile_static.setId(accountsList.get(0).getId());
                                id=(accountsList.get(0).getId());

                                Intent login = new Intent(Login.this, MainActivity.class);
                                Bundle bundle=new Bundle();
                                bundle.putString("id",accountsList.get(0).getId().toString());
                                bundle.putString("perr",accountsList.get(0).getPerr().toString());
                                login.putExtra("account",bundle);
                                openDialog(Gravity.BOTTOM);
                                startActivity(login);
                            }
                        }

                        @Override
                        public void onFailure(Call<List<Account>> call, Throwable t) {
                            Toast.makeText(Login.this, "Tài khoản không tồn tại", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent register = new Intent(Login.this, Register.class);
                startActivity(register);
            }
        });
    }
    private void openDialog(int gravity){
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_login);
        Window window = dialog.getWindow();
        if(window == null){
            return;
        }
        window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        WindowManager.LayoutParams layoutParams = window.getAttributes();
        layoutParams.gravity = gravity;
        window.setAttributes(layoutParams);
        if(Gravity.BOTTOM == gravity){
            dialog.setCancelable(true);
        }else {
            dialog.setCancelable(false);
        }
        dialog.show();
    }

    public static String getId() {
        return id;
    }

    public static void setId(String id) {
        Login.id = id;
    }

    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        Login.name = name;
    }

    public static String getPerr() {
        return perr;
    }

    public static void setPerr(String perr) {
        Login.perr = perr;
    }
}