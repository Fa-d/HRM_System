package go.faddy.hmrsystem.ui.popup;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

import go.faddy.hmrsystem.R;
import go.faddy.hmrsystem.api.RetrofitClient;
import go.faddy.hmrsystem.api.responses.SupplierFetchResponseModel;
import go.faddy.hmrsystem.ui.gallery.GalleryFragment;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DeletePopUp extends AppCompatActivity {
    private GalleryFragment fragment;
    MaterialButton insertbtn;
    TextInputEditText id;
    String idString;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_pop_up);
        initilizeIDs();
        insertbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getTexts();
//                RetrofitClient.getInstance().getApi().SearchItem(idString)
//                        .enqueue(
//                                new Callback<SupplierFetchResponseModel>() {
//                                    @Override
//                                    public void onResponse(Call<SupplierFetchResponseModel> call, Response<SupplierFetchResponseModel> response) {
//
//                                    }
//
//                                    @Override
//                                    public void onFailure(Call<SupplierFetchResponseModel> call, Throwable t) {
//
//                                    }
//                                }
//                        );
//
//                finish();
            }

        });
    }
    private void getTexts(){
        idString = id.getText().toString().trim();

    }

    private void initilizeIDs() {
        id = findViewById(R.id.id_popup_delete);
        insertbtn = findViewById(R.id.btn_popup_delete);
    }
}