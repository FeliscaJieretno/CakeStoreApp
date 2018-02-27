package id.ac.kharisma.cakestoreapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class PilihMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pilih_menu);
    }

    public void KueKering(View view)
    {
        Intent intent = new Intent(this, ActivityPilihKue.class);
        intent.putExtra("EXTRA_MESSAGE", 1);
        startActivity(intent);
    }

    public void KueBolu(View view)
    {
        Intent intent = new Intent(this, ActivityPilihKue.class);
        intent.putExtra("EXTRA_MESSAGE", 2);
        startActivity(intent);
    }

    public void KueUlangTahun(View view)
    {
        Intent intent = new Intent(this, ActivityPilihKue.class);
        intent.putExtra("EXTRA_MESSAGE", 3);
        startActivity(intent);
    }

    public void BtnKlik(View view)
    {
        Intent intent = new Intent(this, Keranjang.class);
        startActivity(intent);
    }

}
