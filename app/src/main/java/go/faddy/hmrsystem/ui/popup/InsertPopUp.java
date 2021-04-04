package go.faddy.hmrsystem.ui.popup;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

import go.faddy.hmrsystem.R;
import go.faddy.hmrsystem.api.RetrofitClient;
import go.faddy.hmrsystem.api.responses.UserFetchResponseModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class InsertPopUp extends AppCompatActivity {
    TextInputEditText username, phone, address;
    MaterialButton insertbtn;
    String usernameString, phoneString, addressString;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_pop_up);
        WindowManager.LayoutParams params = getWindow().getAttributes();
        params.x = -params.height / 2;
        params.width = params.width / 2;
        params.y = -params.width / 2;
        this.getWindow().setAttributes(params);
        initilizeIDs();
        insertbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getTexts();
                RetrofitClient.getInstance().getApi().insertNewUser(usernameString, phoneString, addressString).enqueue(new Callback<UserFetchResponseModel>() {
                    @Override
                    public void onResponse(Call<UserFetchResponseModel> call, Response<UserFetchResponseModel> response) {
                        if(response.isSuccessful()){
                            Toast.makeText(InsertPopUp.this, "Done", Toast.LENGTH_SHORT).show();
                        }else{
                        }
                    }

                    @Override
                    public void onFailure(Call<UserFetchResponseModel> call, Throwable t) {
                    }
                });
                finish();
            }
        });


    }

    private void getTexts(){
        usernameString = username.getText().toString().trim();
        phoneString = phone.getText().toString();
        addressString = address.getText().toString();
    }

    private void initilizeIDs() {
        username = findViewById(R.id.carname_popup_insert);
        phone = findViewById(R.id.owner_name_popup_insert);
        address = findViewById(R.id.model_popup_insert);
        insertbtn = findViewById(R.id.btn_popup_insert);
    }
}

