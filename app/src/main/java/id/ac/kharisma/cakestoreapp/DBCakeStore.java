package id.ac.kharisma.cakestoreapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBCakeStore extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "CakeStore.db";
    private static final int DATABASE_VERSION = 1;
    public DBCakeStore(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        // TODO Auto-generated constructor stub
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub
        String sql = "create table User(No integer primary key autoincrement, Username text null, Password text null);";
        Log.d("Data", "onCreate: " + sql);
        db.execSQL(sql);
        sql = "INSERT INTO User VALUES (1, 'Felisca', 'user123');";
        db.execSQL(sql);

        sql = "create table Transaksi(No integer primary key, KodeKue integer null, Jumlah integer null);";
        Log.d("Data", "onCreate: " + sql);
        db.execSQL(sql);
        sql = "INSERT INTO Transaksi VALUES (1, 1, 0);";
        db.execSQL(sql);
        sql = "INSERT INTO Transaksi VALUES (2, 2, 0);";
        db.execSQL(sql);
        sql = "INSERT INTO Transaksi VALUES (3, 3, 0);";
        db.execSQL(sql);
        sql = "INSERT INTO Transaksi VALUES (4, 4, 0);";
        db.execSQL(sql);
        sql = "INSERT INTO Transaksi VALUES (5, 5, 0);";
        db.execSQL(sql);
        sql = "INSERT INTO Transaksi VALUES (6, 6, 0);";
        db.execSQL(sql);
        sql = "INSERT INTO Transaksi VALUES (7, 7, 0);";
        db.execSQL(sql);
        sql = "INSERT INTO Transaksi VALUES (8, 8, 0);";
        db.execSQL(sql);
        sql = "INSERT INTO Transaksi VALUES (9, 9, 0);";
        db.execSQL(sql);
        sql = "INSERT INTO Transaksi VALUES (10, 10, 0);";
        db.execSQL(sql);
        sql = "INSERT INTO Transaksi VALUES (11, 11, 0);";
        db.execSQL(sql);
        sql = "INSERT INTO Transaksi VALUES (12, 12, 0);";
        db.execSQL(sql);

        sql = "create table ListKue(No integer primary key, Jenis text null, Nama text null, Harga real null);";
        Log.d("Data", "onCreate: " + sql);
        db.execSQL(sql);
        sql = "INSERT INTO ListKue VALUES (1, 'Kue Kering', 'Kue Keju - Kastangel', 120000);";
        db.execSQL(sql);
        sql = "INSERT INTO ListKue VALUES (2, 'Kue Kering', 'Kue Sagu Keju', 150000);";
        db.execSQL(sql);
        sql = "INSERT INTO ListKue VALUES (3, 'Kue Kering', 'Bola-Bola Coklat', 170000);";
        db.execSQL(sql);
        sql = "INSERT INTO ListKue VALUES (4, 'Kue Kering', 'Kue Kacang Mede', 175000);";
        db.execSQL(sql);
        sql = "INSERT INTO ListKue VALUES (5, 'Kue Bolu', 'Bolu Pandan', 135000);";
        db.execSQL(sql);
        sql = "INSERT INTO ListKue VALUES (6, 'Kue Bolu', 'Bolu Gulung Coklat', 90000);";
        db.execSQL(sql);
        sql = "INSERT INTO ListKue VALUES (7, 'Kue Bolu', 'Bolu Pisang', 115000);";
        db.execSQL(sql);
        sql = "INSERT INTO ListKue VALUES (8, 'Kue Bolu', 'Bolu Kukus Coklat', 100000);";
        db.execSQL(sql);
        sql = "INSERT INTO ListKue VALUES (9, 'Kue Ulang Tahun', 'Black Forest Cake', 250000);";
        db.execSQL(sql);
        sql = "INSERT INTO ListKue VALUES (10, 'Kue Ulang Tahun', 'Tiramisu Cake', 270000);";
        db.execSQL(sql);
        sql = "INSERT INTO ListKue VALUES (11, 'Kue Ulang Tahun', 'Chesse Cake', 300000);";
        db.execSQL(sql);
        sql = "INSERT INTO ListKue VALUES (12, 'Kue Ulang Tahun', 'Rainbow Cake', 320000);";
        db.execSQL(sql);

    }


    @Override
    public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
        // TODO Auto-generated method stub
    }
}