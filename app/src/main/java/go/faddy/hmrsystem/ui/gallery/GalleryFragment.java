package go.faddy.hmrsystem.ui.gallery;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.StyleSpan;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import go.faddy.hmrsystem.R;
import go.faddy.hmrsystem.api.RetrofitClient;
import go.faddy.hmrsystem.api.responses.SupplierFetchResponseModel;
import go.faddy.hmrsystem.ui.popup.DebitPopUp;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GalleryFragment extends Fragment {

    private GalleryViewModel galleryViewModel;
//    private ImageButton imageButton;

    SearchView searchView;
    private FrameLayout frameLayout;
    int leftMargin = 10;
    int topMargin = 2;
    int rightMargin = 10;
    int bottomMargin = 2;

    boolean frameExpand = false;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        galleryViewModel =
                new ViewModelProvider(this).get(GalleryViewModel.class);

        View root = inflater.inflate(R.layout.fragment_gallery, container, false);
        final TableLayout tableLayout = root.findViewById(R.id.table);

        marginRow(tableLayout);
        frameLayout = root.findViewById(R.id.inputs_gallery);
        searchView = root.findViewById(R.id.simpleSearchView);
//        imageButton = root.findViewById(R.id.frame_expand_minimize);
//        imageButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if (frameExpand) {
//                    frameLayout.setVisibility(View.GONE);
//                    imageButton.setImageResource(R.drawable.ic_baseline_search_24);
//                    frameExpand = false;
//                    mainTable(tableLayout);
//                } else {
//                    tableLayout.removeAllViews();
//                    marginRow(tableLayout);
//                    frameLayout.setVisibility(View.VISIBLE);
////                    serachButtons(frameLayout, tableLayout);
//                    imageButton.setImageResource(R.drawable.ic_baseline_close_24);
//                    frameExpand = true;
//                }
//
//            }
//        });
        searchView.setOnCloseListener(new SearchView.OnCloseListener() {
            @Override
            public boolean onClose() {
                tableLayout.removeAllViews();
                marginRow(tableLayout);
                mainTable(tableLayout);
                return false;
            }
        });
        searchView.setOnSearchClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tableLayout.removeAllViews();
                marginRow(tableLayout);
            }
        });
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                queryView(tableLayout, newText);
                tableLayout.removeAllViews();
                marginRow(tableLayout);
                return false;
            }
        });

        mainTable(tableLayout);

        return root;
    }

//    void serachButtons(FrameLayout frameLayout, TableLayout tableLayout) {
//        LinearLayout linearLayoutVertical1 = new LinearLayout(getContext());
//        linearLayoutVertical1.setOrientation(LinearLayout.VERTICAL);
//
//        EditText supCode = new EditText(getContext());
//        supCode.setHint("Enter Supplier Code");
//
//        EditText supName = new EditText(getContext());
//        supName.setHint("Enter Supplier Name");
//
//
//        linearLayoutVertical1.addView(supCode);
//        linearLayoutVertical1.addView(supName);
//
//
//        LinearLayout linearLayoutVertical2 = new LinearLayout(getContext());
//        linearLayoutVertical2.setOrientation(LinearLayout.VERTICAL);
//
//
//        DatePickerDialog datePicker1 = new DatePickerDialog(getContext());
//        DatePickerDialog datePicker2 = new DatePickerDialog(getContext());
//
//        Button fromButton = new Button(getContext());
//        fromButton.setText("Search");
//        fromButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                tableLayout.removeAllViews();
//                marginRow(tableLayout);
//                RetrofitClient.getInstance().getApi().SearchItem(supCode.getText().toString(),
//                        supName.getText().toString())
//                        .enqueue(new Callback<List<SupplierFetchResponseModel>>() {
//                            @Override
//                            public void onResponse(Call<List<SupplierFetchResponseModel>> call, Response<List<SupplierFetchResponseModel>> response) {
//                                int x = response.body().size();
//                                if (x > 0) {
//                                    for (int i = 0; i < x; i++) {
//                                        final TableRow tableRow = new TableRow(getActivity());
//                                        TableLayout.LayoutParams tableRowParams = new TableLayout.LayoutParams(TableLayout.LayoutParams.WRAP_CONTENT,
//                                                TableLayout.LayoutParams.WRAP_CONTENT);
//                                        tableRowParams.setMargins(leftMargin, topMargin, rightMargin, bottomMargin);
//                                        tableRow.setLayoutParams(tableRowParams);
//
//                                        final TextView supcode = initPlainTextView(i);
//                                        final TextView supname = initPlainTextView(i);
//                                        final TextView invnum = initPlainTextView(i);
//                                        final TextView doctype = initPlainTextView(i);
//                                        final TextView invdate = initPlainTextView(i);
//                                        final TextView debit = initPlainTextView(i);
//                                        final TextView credit = initPlainTextView(i);
//
//                                        supcode.setText(boldingText(String.valueOf(response.body().get(i).getSupcode()) + "\t\t"));
//                                        supname.setText(boldingText(response.body().get(i).getSupname() + "\t\t"));
//                                        invnum.setText(boldingText(response.body().get(i).getInvnum() + "\t\t"));
//                                        doctype.setText(boldingText(response.body().get(i).getDoctype() + "\t\t"));
//                                        invdate.setText(boldingText(String.valueOf(response.body().get(i).getInvdate() + "\t\t")));
//                                        debit.setText(boldingText(response.body().get(i).getDebit() + "\t\t"));
//                                        credit.setText(boldingText(String.valueOf(response.body().get(i).getCredit() + "\t\t")));
//
//                                        supcode.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT));
//                                        supname.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT));
//                                        invnum.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT));
//                                        doctype.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT));
//                                        invdate.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT));
//
//                                        tableRow.addView(supcode);
//                                        tableRow.addView(supname);
//                                        tableRow.addView(invnum);
//                                        tableRow.addView(doctype);
//                                        tableRow.addView(invdate);
//                                        tableRow.addView(debit);
//                                        tableRow.addView(credit);
//
//                                        tableLayout.addView(tableRow);
//                                    }
//                                }
//                            }
//
//                            @Override
//                            public void onFailure(Call<List<SupplierFetchResponseModel>> call, Throwable t) {
//
//                            }
//                        });
//            }
//        });
//        Button toButton = new Button(getContext());
//        toButton.setText("Select Ending Date");
//
//        final Calendar fromCalendar = Calendar.getInstance();
//        final Calendar toCalendar = Calendar.getInstance();
//        fromButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                datePicker1.setOnDateSetListener(new DatePickerDialog.OnDateSetListener() {
//                    @Override
//                    public void onDateSet(DatePicker view, int year, int monthOfYear,
//                                          int dayOfMonth) {
//
//                        fromCalendar.set(Calendar.YEAR, year);
//                        fromCalendar.set(Calendar.MONTH, monthOfYear);
//                        fromCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
//
//                        fromButton.setText(updateLabel(fromCalendar));
//                    }
//                });
//            }
//        });
//
//        linearLayoutVertical2.addView(fromButton);
////        linearLayoutVertical2.addView(toButton);
//
//        LinearLayout linearLayoutHoriztonal = new LinearLayout(getContext());
////        linearLayoutHoriztonal.setOrientation(LinearLayout.HORIZONTAL);
//
//        linearLayoutHoriztonal.addView(linearLayoutVertical1);
//
//        linearLayoutHoriztonal.addView(linearLayoutVertical2);
//
//        frameLayout.addView(linearLayoutHoriztonal);
//
//    }

    private String updateLabel(Calendar myCalendar) {
        String myFormat = "MM/dd/yy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        return sdf.format(myCalendar.getTime());
    }
    void queryView(TableLayout tableLayout, String text){
        RetrofitClient.getInstance().getApi().SearchItem(text)
                .enqueue(new Callback<List<SupplierFetchResponseModel>>() {
                    @Override
                    public void onResponse(Call<List<SupplierFetchResponseModel>> call, Response<List<SupplierFetchResponseModel>> response) {
                        if(response.isSuccessful()){
                            int x = response.body().size();
                           if(x > 0){
                               for (int i = 0; i < x; i++) {

                                   final TableRow tableRow = new TableRow(getActivity());
                                   TableLayout.LayoutParams tableRowParams = new TableLayout.LayoutParams(TableLayout.LayoutParams.WRAP_CONTENT, TableLayout.LayoutParams.WRAP_CONTENT);
                                   tableRowParams.setMargins(leftMargin, topMargin, rightMargin, bottomMargin);
                                   tableRow.setLayoutParams(tableRowParams);

                                   final TextView supcode = initPlainTextView(i);
                                   final TextView supname = initPlainTextView(i);
                                   final TextView invnum = initPlainTextView(i);
                                   final TextView invdate = initPlainTextView(i);
                                   final TextView debit = initPlainTextView(i);
                                   final TextView credit = initPlainTextView(i);

                                   supcode.setText(boldingText(String.valueOf(response.body().get(i).getSupcode()) + "\t\t"));
                                   supname.setText(boldingText(response.body().get(i).getSupname() + "\t\t"));
                                   invnum.setText(boldingText(response.body().get(i).getInvnum() + "\t\t"));
                                   invdate.setText(boldingText(String.valueOf(response.body().get(i).getInvdate() + "\t\t")));
                                   debit.setText(boldingText(response.body().get(i).getDebit() + "\t\t"));
                                   credit.setText(boldingText(String.valueOf(response.body().get(i).getCredit() + "\t\t")));

                                   supcode.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT));
                                   supname.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT));
                                   invnum.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT));

                                   invdate.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT));

                                   tableRow.addView(supcode);
                                   tableRow.addView(supname);
                                   tableRow.addView(invnum);
                                   tableRow.addView(invdate);
                                   tableRow.addView(debit);
                                   tableRow.addView(credit);

                                   tableLayout.addView(tableRow);
                               }
                           }
                        }

                    }

                    @Override
                    public void onFailure(Call<List<SupplierFetchResponseModel>> call, Throwable t) {

                    }
                });
    }

    void marginRow(TableLayout tableLayout) {
        final TableRow tableRow1 = new TableRow(getActivity());
        TableLayout.LayoutParams tableRowParams1 = new TableLayout
                .LayoutParams(TableLayout.LayoutParams.WRAP_CONTENT, TableLayout.LayoutParams.WRAP_CONTENT);
        tableRowParams1.setMargins(leftMargin, topMargin, rightMargin, bottomMargin);
        tableRow1.setLayoutParams(tableRowParams1);
//
        final TextView supcode1 = initPlainTextViewTitle();
        final TextView supname1 = initPlainTextViewTitle();
        final TextView invnum1 = initPlainTextViewTitle();
        final TextView doctype1 = initPlainTextViewTitle();
        final TextView invdate1 = initPlainTextViewTitle();
        final TextView debit1 = initPlainTextViewTitle();
        final TextView credit1 = initPlainTextViewTitle();

        supcode1.setText(boldingText("Supplier Code"));
        supname1.setText(boldingText("Supplier Name"));
        invnum1.setText(boldingText("Invoice Number"));
        doctype1.setText(boldingText("Document Type"));
        invdate1.setText(boldingText("Invoice Date"));
        debit1.setText(boldingText("Debit"));
        credit1.setText(boldingText("Credit"));

        tableRow1.addView(supcode1);
        tableRow1.addView(supname1);
        tableRow1.addView(invnum1);
        tableRow1.addView(doctype1);
        tableRow1.addView(invdate1);
        tableRow1.addView(debit1);
        tableRow1.addView(credit1);

        tableLayout.addView(tableRow1);

    }

    void mainTable(TableLayout tableLayout) {

        RetrofitClient.getInstance().getApi().getSupplierListJSON()
                .enqueue(new Callback<List<SupplierFetchResponseModel>>() {
                    @Override
                    public void onResponse(Call<List<SupplierFetchResponseModel>> call, Response<List<SupplierFetchResponseModel>> response) {
                        int x = response.body().size();
                        for (int i = 0; i < x; i++) {

                            final TableRow tableRow = new TableRow(getActivity());
                            TableLayout.LayoutParams tableRowParams = new TableLayout.LayoutParams(TableLayout.LayoutParams.WRAP_CONTENT, TableLayout.LayoutParams.WRAP_CONTENT);
                            tableRowParams.setMargins(leftMargin, topMargin, rightMargin, bottomMargin);
                            tableRow.setLayoutParams(tableRowParams);

                            final TextView supcode = initPlainTextView(i);
                            final TextView supname = initPlainTextView(i);
                            final TextView invnum = initPlainTextView(i);
                            final TextView doctype = initPlainTextView(i);
                            final TextView invdate = initPlainTextView(i);
                            final TextView debit = initPlainTextView(i);
                            final TextView credit = initPlainTextView(i);

                            supcode.setText(boldingText(String.valueOf(response.body().get(i).getSupcode()) + "\t\t"));
                            supname.setText(boldingText(response.body().get(i).getSupname() + "\t\t"));
                            invnum.setText(boldingText(response.body().get(i).getInvnum() + "\t\t"));
                            doctype.setText(boldingText(response.body().get(i).getDoctype() + "\t\t"));
                            invdate.setText(boldingText(String.valueOf(response.body().get(i).getInvdate() + "\t\t")));
                            debit.setText(boldingText(response.body().get(i).getDebit() + "\t\t"));
                            credit.setText(boldingText(String.valueOf(response.body().get(i).getCredit() + "\t\t")));


                            debit.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Intent intent = new Intent(getContext(), DebitPopUp.class);
                                    intent.putExtra("supcode", supcode.getText().toString());
                                    intent.putExtra("supname", supname.getText().toString());
                                    intent.putExtra("credit", credit.getText().toString());
                                    intent.putExtra("invnum", invnum.getText().toString());
                                    startActivity(intent);
                                }
                            });

                            supcode.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT));
                            supname.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT));
                            invnum.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT));
                            doctype.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT));
                            invdate.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT));

                            tableRow.addView(supcode);
                            tableRow.addView(supname);
                            tableRow.addView(invnum);
                            tableRow.addView(doctype);
                            tableRow.addView(invdate);
                            tableRow.addView(debit);
                            tableRow.addView(credit);

                            tableLayout.addView(tableRow);
                        }
                    }

                    @Override
                    public void onFailure(Call<List<SupplierFetchResponseModel>> call, Throwable t) {

                    }
                });
    }


    private SpannableString boldingText(String s) {
        SpannableString spanString = new SpannableString(s);
        spanString.setSpan(new StyleSpan(Typeface.BOLD), 0, spanString.length(), 0);
        return spanString;
    }

    private TextView initPlainTextView(int i) {
        TextView textView = new TextView(getContext());
        textView.setPadding(15, 15, 15, 15);
        if (i % 2 == 0) {
            textView.setBackgroundResource(R.drawable.cell_shape_odd);
        } else {
            textView.setBackgroundResource(R.drawable.cell_shape_even);
        }
        textView.setGravity(Gravity.CENTER);
        return textView;
    }

    private TextView initPlainTextViewTitle() {
        TextView textView = new TextView(getContext());
        textView.setPadding(15, 15, 15, 15);

        textView.setBackgroundResource(R.drawable.cell_shape_title);

        textView.setGravity(Gravity.CENTER);
        return textView;
    }

}