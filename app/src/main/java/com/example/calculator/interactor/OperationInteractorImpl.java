package com.example.calculator.interactor;

import com.example.calculator.interfaces.OperationInteractor;
import com.example.calculator.interfaces.OperationPresenter;

public class OperationInteractorImpl implements OperationInteractor {

    private int result;
    private OperationPresenter presenter;

    public OperationInteractorImpl(OperationPresenter operationPresenter){
        this.presenter = operationPresenter;
    }

    @Override
    public void add(int num1, int num2) {
        result = num1 + num2;
        presenter.showResult(String.valueOf(result));
    }

    @Override
    public void substract(int num1, int num2) {
        result = num1 - num2;
        presenter.showResult(String.valueOf(result));
    }

    @Override
    public void multiply(int num1, int num2) {
        result = num1 * num2;
        presenter.showResult(String.valueOf(result));
    }

    @Override
    public void divide(int num1, int num2) {
        if (num2 != 0) {
            result = num1 / num2;
            presenter.showResult(Integer.toString(result));
        } else {
            presenter.invalidOperation();
        }
    }
}
