package go.faddy.hmrsystem.ui.gallery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import java.util.List;

import go.faddy.hmrsystem.R;
import go.faddy.hmrsystem.api.RetrofitClient;
import go.faddy.hmrsystem.api.responses.UserFetchResponseModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GalleryFragment extends Fragment {

    private GalleryViewModel galleryViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        galleryViewModel =
                new ViewModelProvider(this).get(GalleryViewModel.class);
        View root = inflater.inflate(R.layout.fragment_gallery, container, false);

        final TableLayout tableLayout = root.findViewById(R.id.table);

        RetrofitClient.getInstance().getApi().getCarModels().enqueue(
                new Callback<List<UserFetchResponseModel>>() {
                    @Override
                    public void onResponse(Call<List<UserFetchResponseModel>> call, Response<List<UserFetchResponseModel>> response) {
                        int x = response.body().size();
                        for (int i = 0; i < x; i++) {
                            final TableRow tableRow = new TableRow(getActivity());
                            tableRow.setLayoutParams(new TableLayout.LayoutParams(TableLayout.LayoutParams.WRAP_CONTENT, TableLayout.LayoutParams.WRAP_CONTENT));

                            final TextView Id = new TextView(getActivity());
                            final TextView name = new TextView(getActivity());
                            final TextView phone = new TextView(getActivity());
                            final TextView address = new TextView(getActivity());

                            Id.setText(String.valueOf(response.body().get(i).getId() )+ "\t\t");
                            name.setText(response.body().get(i).getName()+ "\t\t");
                            phone.setText(response.body().get(i).getPhone()+ "\t\t");
                            address.setText(String.valueOf(response.body().get(i).getAddress()+ "\t\t") );

                            Id.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT));
                            name.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT));
                            phone.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT));
                            address.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT));

                            tableRow.addView(Id);
                            tableRow.addView(name);
                            tableRow.addView(phone);
                            tableRow.addView(address);

                            tableLayout.addView(tableRow);
                        }
                    }

                    @Override
                    public void onFailure(Call<List<UserFetchResponseModel>> call, Throwable t) {

                    }
                }
        );
        return root;
    }

}