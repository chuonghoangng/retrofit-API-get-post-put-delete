package com.example.lib.InterfaceRepository;

import com.example.lib.Model.SinhVienInsert;
import com.example.lib.Model.SinhVienResponse;
import com.example.lib.Model.SinhvienModel;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface Methods {
    @GET("/article/18dthd6_DreamTeam")
    Call<SinhvienModel> getsinhvien();
    @POST("/article")
    Call<SinhVienResponse> insertSinhVien(@Body SinhVienInsert sinhVienInsert);
    @PUT("/article/{id}")
    Call<SinhVienResponse> EditSinhVien(@Path("id") String id , @Body SinhVienInsert sinhVienInsert  );
    @DELETE("/article/{id}")
    Call<SinhVienResponse> DeleteSinhVien(@Path("id") String id);

}
