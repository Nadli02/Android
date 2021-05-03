/*Package merupakan nama project yang pertama kali kita buat*/
package com.example.uts_18030012;
/*Import library - library yang dibutuhkan dalam membuat koding, Library yang berwarna abu-abu
dijadikan contoh untuk library yang tidak digunakan*/
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
/*Merupakan activity yang akan dijalankan setelah kita menekan tombol send data pada main activity*/
public class SecondActivity extends AppCompatActivity {
    /*Koding dibawah merupakan deklarasi untuk variabel - variabel yang akan digunakan dalam datepicker*/
    private SimpleDateFormat format_tanggal;
    private DatePickerDialog datePickerDialog;
    private TextView Hasil_Tanggal;
    private Button Pick_Date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        /*Koding dibawah adalah untuk membuat format tanggal yang digunakan dalam datepicker*/
        format_tanggal = new SimpleDateFormat("dd-MM-yyyy", Locale.US);
        /*Koding dibawah merupakan inisialisasi untuk palette yang akan digunakan untuk menampilkan data yang dibawah dari activity sebelumnya*/
        TextView nim = findViewById(R.id.hasil_nim);
        TextView nama = findViewById(R.id.hasil_nama);
        TextView kelas = findViewById(R.id.hasil_kelas);
        /*Koding dibawah merupakan pembentukan variabel untuk menampilkan data yang dibawa dari activity sebelumnya*/
        String nim_mhs = getIntent().getStringExtra("NIM");
        String nama_mhs = getIntent().getStringExtra("NAMA");
        String kelas_mhs = getIntent().getStringExtra("KELAS");
        /*Koding dibawah merupakan pemberian nilai pada pallete yang berdasarkan dari data yang disimpan di variabel*/
        nim.setText(nim_mhs);
        nama.setText(nama_mhs);
        kelas.setText(kelas_mhs);
        /*Koding dibawah merupakan inisialisasi palette untuk datepicker*/
        Hasil_Tanggal = (TextView) findViewById(R.id.tgl);
        Pick_Date = (Button) findViewById(R.id.tanggal);
        Pick_Date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDateDialog();
            }
        });
    }
    /*Koding dibawah merupakan method untuk datepicker agar dapat berfungsi*/
        private void showDateDialog () {
            Calendar newCalendar = Calendar.getInstance();
            datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                    Calendar newDate = Calendar.getInstance();
                    newDate.set(year, monthOfYear, dayOfMonth);
                    Hasil_Tanggal.setText(format_tanggal.format(newDate.getTime()));
                }
            }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));
            datePickerDialog.show();
        }
    /*Koding dibawah Merupakan method yang digunakan untuk mereset data saat tombol reset ditekan*/
    public void reset(View view) {
        /*Koding dibawah merupakan inisialisasi untuk palette yang akan digunakan dalam method*/
        EditText input_matkul = findViewById(R.id.input_matkul);
        EditText input_dp = findViewById(R.id.input_dp);
        EditText input_studi = findViewById(R.id.input_studi);
        EditText input_sifat = findViewById(R.id.input_sifat);
        EditText input_sks = findViewById(R.id.input_sks);
        TextView hasil_tanggal = findViewById(R.id.tgl);
        /*Koding dibawah berfungsi untuk membuat semua isi pallete EditText menjadi kosong saat tombol reset ditekan*/
        input_matkul.setText("");
        input_dp.setText("");
        input_sifat.setText("");
        input_sks.setText("");
        input_studi.setText("");
        hasil_tanggal.setText("");
    }
    /*Koding dibawah Merupakan method yang digunakan untuk mereset data saat tombol reset ditekan*/
    public void submit(View view) {
        /*Koding dibawah merupakan inisialisasi untuk palette yang akan digunakan dalam method*/
        TextView nim = findViewById(R.id.hasil_nim);
        TextView nama = findViewById(R.id.hasil_nama);
        TextView kelas = findViewById(R.id.hasil_kelas);
        EditText input_matkul = findViewById(R.id.input_matkul);
        EditText input_dp = findViewById(R.id.input_dp);
        EditText input_studi = findViewById(R.id.input_studi);
        EditText input_sifat = findViewById(R.id.input_sifat);
        EditText input_sks = findViewById(R.id.input_sks);
        TextView hasil_tanggal = findViewById(R.id.tgl);
        /*Koding dibawah merupakan pembentukan variabel untuk menyimpan data yang akan dibawa ke activity selanjutnya*/
        String nim_mhs = nim.getText().toString();
        String nama_mhs = nama.getText().toString();
        String kelas_mhs = kelas.getText().toString();
        String matkul_ujn = input_matkul.getText().toString();
        String dp_ujn = input_dp.getText().toString();
        String studi_ujn = input_studi.getText().toString();
        String sifat_ujn = input_sifat.getText().toString();
        String sks_ujn = input_sks.getText().toString();
        String tanggal_ujn = hasil_tanggal.getText().toString();
        /*Koding dibawah merupakan metode/fungsi intent yang digunakan untuk pindah ke activity selanjutnya*/
        Intent intent = new Intent(this, ThirdActivity.class);
        intent.putExtra("NIM", nim_mhs);
        intent.putExtra("NAMA", nama_mhs);
        intent.putExtra("KELAS", kelas_mhs);
        intent.putExtra("MATKUL", matkul_ujn);
        intent.putExtra("DP", dp_ujn);
        intent.putExtra("STUDI", studi_ujn);
        intent.putExtra("SIFAT", sifat_ujn);
        intent.putExtra("SKS", sks_ujn);
        intent.putExtra("TANGGAL", tanggal_ujn);
        startActivity(intent);
        /*Untuk "intent.putextra" adalah koding yang digunakan untuk membawa data yang tersimpan ke activity selanjutnya*/
    }
}

