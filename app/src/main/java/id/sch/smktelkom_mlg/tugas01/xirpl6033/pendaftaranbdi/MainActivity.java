package id.sch.smktelkom_mlg.tugas01.xirpl6033.pendaftaranbdi;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText etNama;
    TextView tvHasil, tvHasil2, tvHasil3, tvHasil4;
    RadioGroup rgJenisKelamin;
    Spinner spinnerKelas;
    CheckBox SA, SI, SM, STS, SIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNama = (EditText) findViewById(R.id.editTextNama);
        tvHasil = (TextView) findViewById(R.id.textViewHasil);
        tvHasil2 = (TextView) findViewById(R.id.textViewHasil2);
        tvHasil3 = (TextView) findViewById(R.id.textViewHasil3);
        tvHasil4 = (TextView) findViewById(R.id.textViewHasil4);
        rgJenisKelamin = (RadioGroup) findViewById(R.id.RGJK);
        spinnerKelas = (Spinner) findViewById(R.id.spinnerKelas);
        SA = (CheckBox) findViewById(R.id.SA);
        SI = (CheckBox) findViewById(R.id.SI);
        SM = (CheckBox) findViewById(R.id.SM);
        STS = (CheckBox) findViewById(R.id.STS);
        SIn = (CheckBox) findViewById(R.id.SIn);

        findViewById(R.id.buttonDaftar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doClick();
            }
        });
    }

    private void doClick() {
        String nama = etNama.getText().toString();
        String hasil2 = null;
        String hasil4 = "Divisi         : ";
        int startlen = hasil4.length();


        if (nama.isEmpty()) {
            etNama.setError("Nama Belum Diisi");
        } else if (nama.length() <= 3) {
            etNama.setError("Gunakan Nama Lengkap");
        } else {
            etNama.setError(null);
        }
        tvHasil.setText("Selamat Anda telah terdaftar sebagai calon anggota BDI \n Nama         : " + nama);


        if (rgJenisKelamin.getCheckedRadioButtonId() != -1) {
            RadioButton rb = (RadioButton)
                    findViewById(rgJenisKelamin.getCheckedRadioButtonId());
            hasil2 = rb.getText().toString();
        } else {
            tvHasil2.setText("Jenis Kelamin         :" + hasil2);
        }
        tvHasil3.setText("Kelas         : " + spinnerKelas.getSelectedItem().toString());

        if (SA.isChecked()) hasil4 += SA.getText() + ", ";
        if (SI.isChecked()) hasil4 += SI.getText() + ", ";
        if (SM.isChecked()) hasil4 += SM.getText() + ", ";
        if (STS.isChecked()) hasil4 += STS.getText() + ", ";
        if (SIn.isChecked()) hasil4 += SIn.getText() + ", ";

        if (hasil4.length() == startlen) hasil4 += "Tidak ada pilihan";
        tvHasil4.setText(hasil4);
    }
}
