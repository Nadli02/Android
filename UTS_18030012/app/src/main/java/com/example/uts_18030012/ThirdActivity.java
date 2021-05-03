/*Package merupakan nama project yang pertama kali kita buat*/
package com.example.uts_18030012;
/*Import library - library yang dibutuhkan dalam membuat koding, Library yang berwarna abu-abu
dijadikan contoh untuk library yang tidak digunakan*/
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
/*Merupakan activity yang akan dijalankan setelah kita menekan tombol submmit pada second activity*/
public class ThirdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        /*Koding dibawah merupakan inisialisasi untuk palette yang akan digunakan untuk menampilkan data yang dibawah dari activity sebelumnya*/
        TextView nim = findViewById(R.id.output_nim);
        TextView nama = findViewById(R.id.output_nama);
        TextView kelas = findViewById(R.id.output_kelas);
        TextView studi = findViewById(R.id.output_studi);
        TextView sks = findViewById(R.id.output_sks);
        TextView dp = findViewById(R.id.output_dp);
        TextView tanggal = findViewById(R.id.output_tanggal);
        TextView matkul = findViewById(R.id.output_matkul);
        /*Koding dibawah merupakan pembentukan variabel untuk menampilkan data yang dibawa dari activity sebelumnya*/
        String nim_mhs = getIntent().getStringExtra("NIM");
        String nama_mhs = getIntent().getStringExtra("NAMA");
        String kelas_mhs = getIntent().getStringExtra("KELAS");
        String dp_ujn = getIntent().getStringExtra("DP");
        String matkul_ujn = getIntent().getStringExtra("MATKUL");
        String studi_ujn = getIntent().getStringExtra("STUDI");
        String tanggal_ujn = getIntent().getStringExtra("TANGGAL");
        String sks_ujn = getIntent().getStringExtra("SKS");
        /*Koding dibawah merupakan pemberian nilai pada pallete yang berdasarkan dari data yang disimpan di variabel*/
        nim.setText(nim_mhs);
        nama.setText(nama_mhs);
        kelas.setText(kelas_mhs);
        dp.setText(dp_ujn);
        matkul.setText(matkul_ujn);
        studi.setText("PROGRAM STUDI - "+studi_ujn);
        tanggal.setText(tanggal_ujn);
        sks.setText(sks_ujn);
    }
}