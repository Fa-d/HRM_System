package go.faddy.hmrsystem;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import go.faddy.hmrsystem.api.RetrofitClient;
import go.faddy.hmrsystem.api.responses.CarFetchResponseModel;
import go.faddy.hmrsystem.ui.LoginActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private TextView rest_txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rest_txt = findViewById(R.id.rest_filling);
        findViewById(R.id.next_activity).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), LoginActivity.class));
            }
        });

        findViewById(R.id.sign_up).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RetrofitClient.getInstance().getApi().getCarModels().enqueue(new Callback<CarFetchResponseModel>() {
                    @Override
                    public void onResponse(Call<CarFetchResponseModel> call, Response<CarFetchResponseModel> response) {
                        rest_txt.setText("324");
                    }

                    @Override
                    public void onFailure(Call<CarFetchResponseModel> call, Throwable t) {
                        Toast.makeText(MainActivity.this, "Failed", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}