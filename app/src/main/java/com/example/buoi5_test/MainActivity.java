package com.example.buoi5_test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import static com.example.lib.RetrofitClient.getRetrofit;

import com.example.lib.InterfaceRepository.Methods;
import com.example.lib.Model.SinhVienResponse;
import com.example.lib.Model.SinhvienModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    //ArrayList<String> list;
    TextView textView;
    public static ListView listView;
    //List<Room> roomList;
    public static List<SinhVienResponse> sinhvienList;
    //RoomAdapter adapter;
    public static sinhvienadapter svadapter;
    Button btnAdd;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.txtnew);
        listView=findViewById(R.id.lvdata);
        btnAdd=findViewById(R.id.btnThem);


        getSV();
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, AddSV.class); startActivity(i);
            }
        });


        //roomList.add(new Room("122", "456"));
        //roomList.add(new Room("asd", "456"));


        //insertRooms();
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(MainActivity.this, AddSV.class);
                SinhVienResponse sv = sinhvienList.get(position);
                i.putExtra("object",sv);
                startActivity(i);
            }
        });

    }

    private void getSV() {
        Methods methods = getRetrofit().create(Methods.class);
        Call<SinhvienModel> call = methods.getsinhvien();
        sinhvienList= new ArrayList<>();
        call.enqueue(new Callback<SinhvienModel>() {
            @Override
            public void onResponse(Call<SinhvienModel> call, Response<SinhvienModel> response) {
                SinhvienModel.Data[] data = response.body().getData();
                for(SinhvienModel.Data dt: data){
                    //Log.v("log:", dt.getName() + "_");
                    SinhVienResponse sv = new SinhVienResponse();
                    sv.setCreatedAt(dt.getCreatedAt());
                    sv.setGroupName(dt.getGroupName());
                    sv.setImageUrl(dt.getImageUrl());
                    sv.set__v(dt.get__v());
                    sv.set_id(dt.get_id());
                    sv.setTitle(dt.getTitle());
                    sv.setContent(dt.getContent());
                    sv.setUpdatedAt(dt.getUpdatedAt());
                    sinhvienList.add(sv);

                    //textView.append(dt.getId()+dt.getName()+"\n");
                }
                //textView.setText("Thanh Cong");
                svadapter=new sinhvienadapter(MainActivity.this,R.layout.itemsv,sinhvienList);
                listView.setAdapter(svadapter);
            }

            @Override
            public void onFailure(Call<SinhvienModel> call, Throwable t) {

            }
        });

    }



}