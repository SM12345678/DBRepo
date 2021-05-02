package com.db.library.model;

import java.util.List;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class AutoCompleteItem {

    public int id;
    public String text;

}