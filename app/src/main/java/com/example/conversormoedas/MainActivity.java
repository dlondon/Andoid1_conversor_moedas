package com.example.conversormoedas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private ViewHolder mViewHolder = new ViewHolder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.mViewHolder.editValue = findViewById(R.id.edit_value);
        this.mViewHolder.textDolar = findViewById(R.id.text_dolar);
        this.mViewHolder.textEuro = findViewById(R.id.text_euro);
        this.mViewHolder.buttonCalculate = findViewById(R.id.button_calculate);
        this.mViewHolder.buttonCalculate.setOnClickListener(this);
        this.clearValues();


        //EditText valor = findViewById(R.id.edit_value);
        //valor.getText();
    }

    private void clearValues() {
        this.mViewHolder.textDolar.setText("");
        this.mViewHolder.textEuro.setText("");
    }


    public void CapturaCotacaoDolar()
    {

        // Instantiate the RequestQueue.
        //RequestQueue queue = Volley.newRequestQueue(this);
        //String url ="http://www.google.com";



        /*public static final MediaType JSON
                = MediaType.parse("application/json; charset=utf-8");

        OkHttpClient client = new OkHttpClient();

        String post(String url, String json) throws IOException {
        RequestBody body = RequestBody.create(JSON, json);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        Response response = client.newCall(request).execute();
        return response.body().string();
    }*/
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.button_calculate)
        {
            String value = this.mViewHolder.editValue.getText().toString();
            if(value.equals(""))
            {
                Toast.makeText(getApplicationContext(), this.getString(R.string.informe_valor), Toast.LENGTH_LONG).show();
            }
            else
            {
                Double real = Double.valueOf(value);

                this.mViewHolder.textDolar.setText(String.format("%.2f", (real / 4)));
                this.mViewHolder.textEuro.setText(String.format("%.2f", (real / 5)));
            }
            
        }
    }

    private static class ViewHolder{

        EditText editValue;
        TextView textDolar;
        TextView textEuro;
        Button buttonCalculate;


    }
}