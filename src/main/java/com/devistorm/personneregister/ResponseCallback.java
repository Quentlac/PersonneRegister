package com.devistorm.personneregister;

public interface ResponseCallback<T> {

    public void success(T t);
    public void fail(T t);

}
