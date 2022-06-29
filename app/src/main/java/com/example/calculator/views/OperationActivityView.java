package com.example.calculator.views;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.calculator.R;
import com.example.calculator.interfaces.OperationPresenter;
import com.example.calculator.interfaces.OperationView;
import com.example.calculator.presenters.OperationPresenterImpl;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textview.MaterialTextView;

import java.util.Objects;

public class OperationActivityView extends AppCompatActivity implements OperationView {

    private TextInputEditText edtFirstNumber;
    private TextInputEditText edtSecondNumber;
    private MaterialTextView tvResult;
    private OperationPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_operation_view);
        initView();
    }

    private void initView(){

        edtFirstNumber = findViewById(R.id.edtFirstNumber);
        edtSecondNumber = findViewById(R.id.edtSecondNumber);
        presenter = new OperationPresenterImpl(this);

        MaterialButton btnAdd = findViewById(R.id.btnAdd);
        MaterialButton btnSubstract = findViewById(R.id.btnSubstract);
        MaterialButton btnMultiply = findViewById(R.id.btnMultiply);
        MaterialButton btnDivide = findViewById(R.id.btnDivide);

        tvResult = findViewById(R.id.tvResult);

        btnAdd.setOnClickListener(this::doAdd);
        btnSubstract.setOnClickListener(this::doSubstract);
        btnMultiply.setOnClickListener(this::doMultiply);
        btnDivide.setOnClickListener(this::doDivide);
    }

    private void doAdd(View v){
        try {
            presenter.add(getFirstNumber(), getSecondNumber());
        } catch (Exception e) {
            invalidOperation();
        }
    }

    private void doSubstract(View v){
        try {
            presenter.subtract(getFirstNumber(), getSecondNumber());
        } catch (Exception e) {
            invalidOperation();
        }
    }

    private void doMultiply(View v){
        try {
            presenter.multiply(getFirstNumber(), getSecondNumber());
        } catch (NumberFormatException e) {
            invalidOperation();
        }
    }

    private void doDivide(View v){
        try {
            presenter.divide(getFirstNumber(), getSecondNumber());
        } catch (Exception e) {
            invalidOperation();
        }
    }

    private int getFirstNumber(){
        return Integer.parseInt(Objects.requireNonNull(edtFirstNumber.getText()).toString());
    }

    private int getSecondNumber(){
        return Integer.parseInt(Objects.requireNonNull(edtSecondNumber.getText()).toString());
    }

    @Override
    public void showResult(String result) {
        tvResult.setText(result);
    }

    @Override
    public void invalidOperation() {
        Toast.makeText(this, "Invalid operation", Toast.LENGTH_SHORT).show();
    }
}