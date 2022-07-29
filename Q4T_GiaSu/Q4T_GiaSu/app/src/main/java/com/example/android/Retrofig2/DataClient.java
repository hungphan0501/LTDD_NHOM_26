package com.example.android.Retrofig2;

import com.example.android.Account;
import com.example.android.Find.user;
import com.example.android.Subject;
import com.example.android.classlist.Room;
import com.example.android.classlist.my_post;
import com.example.android.classlist.my_post_home;
import com.example.android.classlist1.Room1;
import com.example.android.get_student;
import com.example.android.teacherclass.TeacherClass;
import com.example.android.teacheruser.DetailTeacherSpotLightClass;
import com.example.android.teacheruser.TeacherUser;
import com.example.android.tutar;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface DataClient {
    @FormUrlEncoded
    @POST("login.php")
    Call<List<Account>> LoginData(@Field("email") String email, @Field("pass") String pass);

    @FormUrlEncoded
    @POST("register.php")
    Call<String> Register(@Field("name") String name
            ,@Field("email") String email
            ,@Field("pass") String pass
            ,@Field("address") String address
            ,@Field("gender") String gender
            ,@Field("phone") String phone
            ,@Field("dob") String dob
            ,@Field("perr") String perr
            ,@Field("level") String level);

    @GET("spotlightTeacher.php")
    Call<List<TeacherUser>> getSpotlightTeacher();

    @GET("roomList.php")
    Call<List<Room>> getRoomList();
    @GET("roomList.php")
    Call<List<Room1>> getRoomList1();
    @GET("teacherList.php")

    Call<List<TeacherClass>> getTeacherClass();
    @GET("detailTeacherSpotLight.php")
    Call<List<DetailTeacherSpotLightClass>> getDetailTeacherSpotLight(@Field("name") String name);

    @FormUrlEncoded
    @POST("get_my_post.php")
    Call<List<my_post>> get_my_post(@Field("id") String id);
    @FormUrlEncoded

    @POST("get_my_post_home.php")
    Call<List<my_post_home>> get_my_post_home(@Field("id") String id);
    @FormUrlEncoded

    @POST("delete_lesson.php")
    Call<String> delete_my_post(@Field("lesson_detail_id") String lesson_detail_id);

    @FormUrlEncoded
    @POST("insertLesson.php")
    Call<String> insertLesson(@Field("lesson_id") String lesson_id,
                              @Field("user_id1") String user_id1,
                              @Field("user_id2") String user_id2
                              );

    @FormUrlEncoded
    @POST("post.php")
    Call<String> post(@Field("id") String id
            ,@Field("number") String number
            ,@Field("method") String method
            ,@Field("hour") String hour
            ,@Field("fee") String fee
            ,@Field("clas") String clas
            ,@Field("mon") String mon
            ,@Field("address") String address);

    @FormUrlEncoded
    @POST("find.php")
    Call<List<user>> find(@Field("info") String info, @Field("mon") String mon, @Field("lop") String lop);

    @FormUrlEncoded
    @POST("account.php")
    Call<List<Account>> teacherUser(@Field("id") String id);
    @FormUrlEncoded
    @POST("change_pass.php")
    Call<String> change_pass (@Field("id") String id

            ,@Field("pass") String pass
            ,@Field("pass_old") String pass_old);

    @FormUrlEncoded
    @POST("get_tutor.php")
    Call<List<tutar>> get_tutor (@Field("id") String id);

    @FormUrlEncoded
    @POST("get_tutor.php")
    Call<List<tutar>> get_tutor_home (@Field("id") String id);

    @FormUrlEncoded
    @POST("get_id_tutor.php")
    Call<List<Account>> get_id_user (@Field("id") String id);

    @FormUrlEncoded
    @POST("get_list_subjects.php")
    Call<List<Subject>> get_list_subjects (@Field("id") String id);

    @FormUrlEncoded
    @POST("get_student.php")
    Call<List<get_student>> get_student (@Field("id") String id);


    @FormUrlEncoded
    @POST("update_profile.php")
    Call<String> update_profilr(@Field("name") String name

            ,@Field("perr") String perr
            ,@Field("phone") String phone
            ,@Field("gender") String gender
            ,@Field("address") String address
            ,@Field("id") String id
            ,@Field("dob") String dob);


}
