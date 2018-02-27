package id.ac.kharisma.cakestoreapp;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ActivityPilihKue extends AppCompatActivity {
    protected Cursor cursor;
    DBCakeStore db;
    //TextView txtCake[];
    TextView txtCake1,txtCake2,txtCake3,txtCake4,txtHarga1,txtHarga2,txtHarga3,txtHarga4;
    TextView txtJumlah1,txtJumlah2,txtJumlah3,txtJumlah4;

    private int max,min;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pilih_kue);
        max = 10;
        min = 0;

        txtCake1 = (TextView) findViewById(R.id.txtCake1);
        txtCake2 = (TextView) findViewById(R.id.txtCake2);
        txtCake3 = (TextView) findViewById(R.id.txtCake3);
        txtCake4 = (TextView) findViewById(R.id.txtCake4);
        txtHarga1 = (TextView) findViewById(R.id.txtHarga1);
        txtHarga2 = (TextView) findViewById(R.id.txtHarga2);
        txtHarga3 = (TextView) findViewById(R.id.txtHarga3);
        txtHarga4 = (TextView) findViewById(R.id.txtHarga4);
        txtJumlah1 = (TextView) findViewById(R.id.txtQty1);
        txtJumlah2 = (TextView) findViewById(R.id.txtQty2);
        txtJumlah3 = (TextView) findViewById(R.id.txtQty3);
        txtJumlah4 = (TextView) findViewById(R.id.txtQty4);

        Intent intent = getIntent();
        int x = intent.getIntExtra("EXTRA_MESSAGE",0);
        db = new DBCakeStore(this);
        SQLiteDatabase dbread = db.getReadableDatabase();
        if (x == 1) {
            cursor = dbread.rawQuery("SELECT a.*,b.Jumlah FROM ListKue a join Transaksi b on a.No=b.KodeKue" +
                    " where Jenis = 'Kue Kering' Order By No",null);}
        else if (x == 2) {
            cursor = dbread.rawQuery("SELECT a.*,b.Jumlah FROM ListKue a join Transaksi b on a.No=b.KodeKue" +
                    " where Jenis = 'Kue Bolu' Order By No",null);}
        else if (x == 3) {
            cursor = dbread.rawQuery("SELECT a.*,b.Jumlah FROM ListKue a join Transaksi b on a.No=b.KodeKue" +
                    " where Jenis = 'Kue Ulang Tahun' Order By No", null);
        }

        if ((cursor != null) && (cursor.getCount() > 0)) {
            cursor.moveToFirst();
            txtCake1.setText(cursor.getString(2).toString());
            txtHarga1.setText("Rp." + cursor.getString(3).toString());
            txtJumlah1.setText(cursor.getString(4).toString());
            cursor.moveToNext();
            txtCake2.setText(cursor.getString(2).toString());
            txtHarga2.setText("Rp." + cursor.getString(3).toString());
            txtJumlah2.setText(cursor.getString(4).toString());
            cursor.moveToNext();
            txtCake3.setText(cursor.getString(2).toString());
            txtHarga3.setText("Rp." + cursor.getString(3).toString());
            txtJumlah3.setText(cursor.getString(4).toString());
            cursor.moveToNext();
            txtCake4.setText(cursor.getString(2).toString());
            txtHarga4.setText("Rp." + cursor.getString(3).toString());
            txtJumlah4.setText(cursor.getString(4).toString());
            cursor.moveToNext();
        }
    }

    public void Plus1(View view) {
        txtJumlah1 = (TextView) findViewById(R.id.txtQty1);
        if (Integer.valueOf(txtJumlah1.getText().toString()) < max) {
            txtJumlah1.setText(String.valueOf(Integer.valueOf(txtJumlah1.getText().toString()) + 1));
        }
    }

    public void Plus2(View view) {
        txtJumlah2 = (TextView) findViewById(R.id.txtQty2);
        if (Integer.valueOf(txtJumlah2.getText().toString()) < max) {
            txtJumlah2.setText(String.valueOf(Integer.valueOf(txtJumlah2.getText().toString()) + 1));
        }
    }

    public void Plus3(View view) {
        txtJumlah3 = (TextView) findViewById(R.id.txtQty3);
        if (Integer.valueOf(txtJumlah3.getText().toString()) < max) {
            txtJumlah3.setText(String.valueOf(Integer.valueOf(txtJumlah3.getText().toString()) + 1));
        }
    }

    public void Plus4(View view) {
        txtJumlah4 = (TextView) findViewById(R.id.txtQty4);
        if (Integer.valueOf(txtJumlah4.getText().toString()) < max) {
            txtJumlah4.setText(String.valueOf(Integer.valueOf(txtJumlah4.getText().toString()) + 1));
        }
    }

    public void Min1(View view) {
        txtJumlah1 = (TextView) findViewById(R.id.txtQty1);
        if (Integer.valueOf(txtJumlah1.getText().toString()) > min) {
            txtJumlah1.setText(String.valueOf(Integer.valueOf(txtJumlah1.getText().toString()) - 1));
        }
    }

    public void Min2(View view) {
        txtJumlah2 = (TextView) findViewById(R.id.txtQty2);
        if (Integer.valueOf(txtJumlah2.getText().toString()) > min) {
            txtJumlah2.setText(String.valueOf(Integer.valueOf(txtJumlah2.getText().toString()) - 1));
        }
    }

    public void Min3(View view) {
        txtJumlah3 = (TextView) findViewById(R.id.txtQty3);
        if (Integer.valueOf(txtJumlah3.getText().toString()) > min) {
            txtJumlah3.setText(String.valueOf(Integer.valueOf(txtJumlah3.getText().toString()) - 1));
        }
    }

    public void Min4(View view) {
        txtJumlah4 = (TextView) findViewById(R.id.txtQty4);
        if (Integer.valueOf(txtJumlah4.getText().toString()) > min) {
            txtJumlah4.setText(String.valueOf(Integer.valueOf(txtJumlah4.getText().toString()) - 1));
        }
    }

    public void Update(View view) {
        SQLiteDatabase dbwrite = db.getWritableDatabase();

        cursor.moveToFirst();
        dbwrite.execSQL("update Transaksi Set Jumlah = "+ Integer.valueOf(txtJumlah1.getText().toString()) +
                " where KodeKue =" + cursor.getString(0).toString());
        cursor.moveToNext();
        dbwrite.execSQL("update Transaksi Set Jumlah = "+ Integer.valueOf(txtJumlah2.getText().toString()) +
                " where KodeKue =" + cursor.getString(0).toString());
        cursor.moveToNext();
        dbwrite.execSQL("update Transaksi Set Jumlah = "+ Integer.valueOf(txtJumlah3.getText().toString()) +
                " where KodeKue =" + cursor.getString(0).toString());
        cursor.moveToNext();
        dbwrite.execSQL("update Transaksi Set Jumlah = "+ Integer.valueOf(txtJumlah4.getText().toString()) +
                " where KodeKue =" + cursor.getString(0).toString());

        Toast.makeText(getApplicationContext(), "Pembaharuan keranjang berhasil", Toast.LENGTH_SHORT).show();
    }

}
