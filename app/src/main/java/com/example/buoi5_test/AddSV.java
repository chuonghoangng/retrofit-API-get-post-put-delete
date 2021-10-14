package com.example.buoi5_test;

import static com.example.lib.RetrofitClient.getRetrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lib.InterfaceRepository.Methods;
import com.example.lib.Model.SinhVienInsert;
import com.example.lib.Model.SinhVienResponse;
import com.example.lib.Model.SinhvienModel;

import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddSV extends AppCompatActivity {

    TextView txttitle,txtUrl;
    EditText edtTitle,editUrl,edtgroup,edtcontent;
    Button btnAdd,btndelete,btnEdit;
    ImageView img;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_sv);
        txttitle=findViewById(R.id.txtSV);
        txtUrl=findViewById(R.id.txtNhapduongdan);
        edtTitle=findViewById(R.id.edt123);
        editUrl=findViewById(R.id.edtUrl);
        edtgroup=findViewById(R.id.edtgroupName);
        edtcontent=findViewById(R.id.edtcontent);

        btnAdd=findViewById(R.id.btnadd);
        btndelete=findViewById(R.id.btndelete);
        btnEdit=findViewById(R.id.btnEdit);
        //img=findViewById(R.id.imageView);

        Intent intent = getIntent();
        SinhVienResponse sv = (SinhVienResponse) intent.getSerializableExtra("object");
        if(sv!=null)

        {
            edtTitle.setText(sv.getTitle());
            editUrl.setText(sv.getImageUrl());
            edtgroup.setText(sv.getGroupName());
            edtcontent.setText(sv.getContent());
            btnAdd.setVisibility(View.GONE);

        }
        else{
            btndelete.setVisibility(View.GONE);
            btnEdit.setVisibility(View.GONE);
        }
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Methods methods = getRetrofit().create(Methods.class);
                SinhVienInsert sv= new SinhVienInsert();
                sv.setTitle(edtTitle.getText().toString());
                sv.setContent(edtcontent.getText().toString());
                sv.setImageUrl(editUrl.getText().toString());
                sv.setGroupName(edtgroup.getText().toString());


                Call<SinhVienResponse> call = methods.insertSinhVien(sv);
                MainActivity.svadapter.notifyDataSetChanged();
                MainActivity.listView.setAdapter(MainActivity.svadapter);

                call.enqueue(new Callback<SinhVienResponse>() {
                    @Override
                    public void onResponse(Call<SinhVienResponse> call, Response<SinhVienResponse> response) {
                        Intent i = new Intent(AddSV.this, MainActivity.class);
                        startActivity(i);
                        //finish();
                        Toast.makeText(AddSV.this, "Success", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<SinhVienResponse> call, Throwable t) {
                        Toast.makeText(AddSV.this, "Error", Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });
        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Methods methods = getRetrofit().create(Methods.class);
                SinhVienInsert svedit= new SinhVienInsert();
                svedit.setTitle(edtTitle.getText().toString());
                svedit.setContent(edtcontent.getText().toString());
                svedit.setImageUrl(editUrl.getText().toString());
                svedit.setGroupName(edtgroup.getText().toString());

                String id=sv.get_id().toString();
                Call<SinhVienResponse> call = methods.EditSinhVien(id,svedit);
                MainActivity.svadapter.notifyDataSetChanged();
                MainActivity.listView.setAdapter(MainActivity.svadapter);

                call.enqueue(new Callback<SinhVienResponse>() {
                    @Override
                    public void onResponse(Call<SinhVienResponse> call, Response<SinhVienResponse> response) {

                        Intent i = new Intent(AddSV.this, MainActivity.class);
                        startActivity(i);
                        //finish();
                        Toast.makeText(AddSV.this, "Success", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<SinhVienResponse> call, Throwable t) {
                        Toast.makeText(AddSV.this, "Error", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
        btndelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Methods methods = getRetrofit().create(Methods.class);


                String id=sv.get_id().toString();
                Call<SinhVienResponse> call = methods.DeleteSinhVien(id);
                MainActivity.svadapter.notifyDataSetChanged();
                MainActivity.listView.setAdapter(MainActivity.svadapter);

                call.enqueue(new Callback<SinhVienResponse>() {
                    @Override
                    public void onResponse(Call<SinhVienResponse> call, Response<SinhVienResponse> response) {
                        Intent i = new Intent(AddSV.this, MainActivity.class);
                        startActivity(i);
                        //finish();
                        Toast.makeText(AddSV.this, "Success", Toast.LENGTH_SHORT).show();

                    }

                    @Override
                    public void onFailure(Call<SinhVienResponse> call, Throwable t) {
                        Toast.makeText(AddSV.this, "Error", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });









    }


}