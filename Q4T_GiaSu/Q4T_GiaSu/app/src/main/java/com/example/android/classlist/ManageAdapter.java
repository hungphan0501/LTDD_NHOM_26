package com.example.android.classlist;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android.Retrofig2.APIUtils;
import com.example.android.Retrofig2.DataClient;
import com.example.android.giasu.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ManageAdapter extends RecyclerView.Adapter<ManageAdapter.UserViewHolder> {
    private List<my_post> mListRoom;
    private interfaceListPost interfaceListPost;
    private my_post room;
    public Context context;




    public void setData(List<my_post> mListRoom) {
        this.mListRoom = mListRoom;
        notifyDataSetChanged();
    }

    public ManageAdapter(Context context, List<my_post> roomList, my_post room) {
        this.context =context;
        this.mListRoom = roomList;
        this.room = room;
        notifyDataSetChanged();
    }
//        public ManageAdapter(List<my_post> roomList, Click click) {
//        this.mListRoom = roomList;
//        this.click = click;
//        notifyDataSetChanged();


    public ManageAdapter(List<my_post> roomList, interfaceListPost interfaceListPost) {
        this.mListRoom = roomList;
        this.interfaceListPost = interfaceListPost;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_post, parent, false);
        return new UserViewHolder(view);
        
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        my_post room = mListRoom.get(position);
        if (room == null) {
            return;
        }

        holder.tvname.setText(room.getGrade());
        holder.tvsubject.setText(room.getSubject());
        holder.tvmoney.setText(room.getFee());
        holder.tvarea.setText(room.getAddress());
        if(room.getMethod() == "1") {
            holder.tvonline.setText("Online");
        }
        else if(room.getMethod() =="2") {
            holder.tvonline.setText("Offline");
        }else {
            holder.tvonline.setText("Online | Offline");
        }

        holder.id_post.setText(room.getLesson_detail_id());

        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new AlertDialog.Builder(context).
                        setTitle("Thông báo")
                        .setMessage("Bạn muốn xóa thông tin này ")
                        .setPositiveButton("Có", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                                DataClient dataClient = APIUtils.getData();
                                Call<String> callback = dataClient.delete_my_post(room.getLesson_detail_id());
                                callback.enqueue(new Callback<String>() {
                                    @Override
                                    public void onResponse(Call<String> call, Response<String> response) {
                                        if(response.body().equals("1"))
                                        Toast.makeText(context, "Đã xóa", Toast.LENGTH_SHORT).show();
                                        else
                                            Toast.makeText(context, "Không thành công", Toast.LENGTH_SHORT).show();
                                    }

                                    @Override
                                    public void onFailure(Call<String> call, Throwable t) {
                                        Toast.makeText(context, "Loi", Toast.LENGTH_SHORT).show();
                                    }
                                });
                            }
                        })
                        .setNegativeButton("không", null).show();

            }
        });
        holder.update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "Không Vào được", Toast.LENGTH_SHORT).show();
            }
        });
    }



    @Override
    public int getItemCount() {
        if (mListRoom != null) {
            return mListRoom.size();
        }
        return 0;
    }

    public class UserViewHolder extends RecyclerView.ViewHolder{

        private TextView tvname, tvsubject, tvmoney, tvarea, tvonline,id_post,delete;
        private Button update;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            tvname = itemView.findViewById(R.id.txtnameclass);
            tvsubject = itemView.findViewById(R.id.txtsubject);
            tvmoney = itemView.findViewById(R.id.txtmoney);
            tvarea = itemView.findViewById(R.id.txtarea);
            tvonline = itemView.findViewById(R.id.txtonline);
            id_post = itemView.findViewById(R.id.id_post);
            delete = itemView.findViewById(R.id.delete);
            update= itemView.findViewById(R.id.btn_update);
        }
    }

}