/*Package merupakan nama project yang pertama kali kita buat*/
package com.example.uts_18030012;
/*Import library - library yang dibutuhkan dalam membuat koding*/
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
/*Merupakan activity utama yang akan dijalankan pertama kali ketika project di run*/
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    /*Koding dibawah Merupakan method yang digunakan untuk mengirim data saat tombol send data ditekan*/
    public void send(View view) {
        /*Koding dibawah merupakan inisialisasi untuk palette yang akan digunakan dalam method*/
        EditText input_nim = findViewById(R.id.input_nim);
        EditText input_nama = findViewById(R.id.input_nama);
        RadioGroup input_kelas = findViewById(R.id.rg);
        /*Koding dibawah merupakan pembentukan variabel untuk menyimpan data yang akan dibawa ke activity selanjutnya*/
        String nim = input_nim.getText().toString();
        String nama = input_nama.getText().toString();
        int kelas = input_kelas.getCheckedRadioButtonId();
        RadioButton kls = findViewById(kelas);
        String kelasa = String.valueOf(kls.getText().toString());
        /*Koding dibawah merupakan metode/fungsi intent yang digunakan untuk pindah ke activity selanjutnya*/
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("NIM", nim);
        intent.putExtra("NAMA", nama);
        intent.putExtra("KELAS", kelasa);
        startActivity(intent);
        /*Untuk "intent.putextra" adalah koding yang digunakan untuk membawa data yang tersimpan ke activity selanjutnya*/
    }
}