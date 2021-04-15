package go.faddy.hmrsystem.ui.popup;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

import java.util.List;

import go.faddy.hmrsystem.R;
import go.faddy.hmrsystem.api.RetrofitClient;
import go.faddy.hmrsystem.api.responses.SupplierFetchResponseModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class InsertPopUp extends AppCompatActivity {
    private TextInputEditText supcode, supname, invnum, debit, credit, invdate, doctype;
    private MaterialButton pushBtn;
    private String supcodeString, supNameString, invnumString, invDateString, doctypeString, debitString, creditString;

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
        pushBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getTexts();
                RetrofitClient.getInstance().getApi().insertIntoSupplierBal(
                        supcodeString, supNameString, invnumString, doctypeString, invDateString,
                        Integer.valueOf(debitString), Integer.valueOf(creditString)
                ).enqueue(new Callback<List<SupplierFetchResponseModel>>() {
                    @Override
                    public void onResponse(Call<List<SupplierFetchResponseModel>> call,
                                           Response<List<SupplierFetchResponseModel>> response) {
                        finish();
                    }

                    @Override
                    public void onFailure(Call<List<SupplierFetchResponseModel>> call, Throwable t) {

                    }

                });
                finish();
            }
        });
    }

    private void getTexts() {
        supcodeString = supcode.getText().toString().trim();
        supNameString = supname.getText().toString().trim();
        invnumString = invnum.getText().toString().trim();
        invDateString = invdate.getText().toString().trim();
        debitString = debit.getText().toString().trim();
        creditString = credit.getText().toString().trim();
        doctypeString = doctype.getText().toString().trim();
    }

    private void initilizeIDs() {
        supcode = findViewById(R.id.supplier_code_insert_popup);
        supname = findViewById(R.id.supname_popup_insert);
        invnum = findViewById(R.id.invnum_popup_insert);
        invdate = findViewById(R.id.invdate_popup_insert);
        debit = findViewById(R.id.debit_popup_insert);
        credit = findViewById(R.id.credit_popup_insert);
        pushBtn = findViewById(R.id.btn_popup_insert);
        doctype = findViewById(R.id.doctype_popup_insert);
    }
}

