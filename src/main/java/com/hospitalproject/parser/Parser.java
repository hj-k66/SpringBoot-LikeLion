package com.hospitalproject.parser;

public interface Parser<T> {
    T parse(String str);
}
