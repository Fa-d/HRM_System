package go.faddy.hmrsystem.ui.popup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import java.util.List;

import go.faddy.hmrsystem.R;
import go.faddy.hmrsystem.api.RetrofitClient;
import go.faddy.hmrsystem.api.responses.SupplierFetchResponseModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DebitPopUp extends AppCompatActivity {
    private String debit;
    private TextInputEditText inputEditText;
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_debit_pop_up);

        WindowManager.LayoutParams params = getWindow().getAttributes();
        params.x = -params.height / 2;
        params.width = params.width / 2;
        params.y = -params.width / 2;
        this.getWindow().setAttributes(params);

        String supcode  = getIntent().getExtras().getString("supcode");
        String supname  = getIntent().getExtras().getString("supname");
        String credit  = getIntent().getExtras().getString("credit");
        String invnum  = getIntent().getExtras().getString("invnum");



        button = findViewById(R.id.debit_amount_button);
        inputEditText = findViewById(R.id.debit_amount_popup);

        debit = inputEditText.getText().toString().trim();
         button.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 Toast.makeText(DebitPopUp.this, debit, Toast.LENGTH_SHORT).show();
                 int debitAmount  = Integer.valueOf(debit) + Integer.valueOf(inputEditText.getText().toString().trim());
                 int creditAmount =  Integer.valueOf(credit) - Integer.valueOf(inputEditText.getText().toString().trim());
//                 RetrofitClient.getInstance().getApi().UpdateDebitCredit(
//                         supcode, supname, invnum, debitAmount, creditAmount
//                 ).enqueue(new Callback<List<SupplierFetchResponseModel>>() {
//                     @Override
//                     public void onResponse(Call<List<SupplierFetchResponseModel>> call, Response<List<SupplierFetchResponseModel>> response) {
//                         finish();
//                     }
//
//                     @Override
//                     public void onFailure(Call<List<SupplierFetchResponseModel>> call, Throwable t) {
//
//                     }
//                 });
             }
         });

    }
}