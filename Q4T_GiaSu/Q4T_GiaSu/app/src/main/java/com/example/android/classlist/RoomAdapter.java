package com.example.android.classlist;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android.giasu.R;

import java.util.List;

public class RoomAdapter extends RecyclerView.Adapter<RoomAdapter.UserViewHolder> {
    private List<Room> mListRoom;
    private interfaceListPost interfaceListPost;


    public RoomAdapter(List<Room> mListRoom, interfaceListPost room) {
        this.mListRoom = mListRoom;
        this.interfaceListPost= interfaceListPost;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_class, parent, false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        Room room = mListRoom.get(position);
        if (room == null) {
            return;
        }

        holder.tvname.setText(room.getGrade());
        holder.tvsubject.setText(room.getSubject());
        holder.tvmoney.setText(room.getFee());
        holder.tvarea.setText(room.getAddress());
        holder.tvonline.setText(room.getMethod());
        holder.rlt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                interfaceListPost.onItemClick(room);
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

    public class UserViewHolder extends RecyclerView.ViewHolder {

        private TextView tvname, tvsubject, tvmoney, tvarea, tvonline;
        private RelativeLayout rlt;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);

            tvname = itemView.findViewById(R.id.txtnameclass);
            tvsubject = itemView.findViewById(R.id.txtsubject);
            tvmoney = itemView.findViewById(R.id.txtmoney);
            tvarea = itemView.findViewById(R.id.txtarea);
            tvonline = itemView.findViewById(R.id.txtonline);
            rlt= itemView.findViewById(R.id.rlt);
        }
    }
}