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

public class UpdatePopUp extends AppCompatActivity {
    TextInputEditText username, phone, address, id;
    MaterialButton updatebtn;
    private String usernameString, phoneString, addressString, idString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_pop_up);
        WindowManager.LayoutParams params = getWindow().getAttributes();
        params.x = -params.height / 2;
        params.width = params.width / 2;
        params.y = -params.width / 2;
        this.getWindow().setAttributes(params);
        initilizeIDs();
        updatebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getTexts();
                RetrofitClient.getInstance().getApi().updateUser(idString, usernameString, phoneString, addressString)
                        .enqueue(new Callback<UserFetchResponseModel>() {
                            @Override
                            public void onResponse(Call<UserFetchResponseModel> call, Response<UserFetchResponseModel> response) {
//                                Toast.makeText(UpdatePopUp.this, "Success", Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onFailure(Call<UserFetchResponseModel> call, Throwable t) {
//                                Toast.makeText(UpdatePopUp.this, "failure", Toast.LENGTH_SHORT).show();
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
        idString = id.getText().toString().trim();
    }

    private void initilizeIDs() {
        id = findViewById(R.id.id_popup_update);
        username = findViewById(R.id.carname_popup_update);
        phone = findViewById(R.id.owner_name_popup_update);
        address = findViewById(R.id.model_popup_update);
        updatebtn = findViewById(R.id.btn_popup_update);
    }
}