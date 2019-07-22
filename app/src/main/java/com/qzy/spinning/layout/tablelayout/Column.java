package com.qzy.spinning.layout.tablelayout;

import android.support.annotation.NonNull;

import java.util.List;


/**
 * @author tanhaoshi
 * create on 7/18/2019
 */
public class Column implements Comparable<Column>{

    private String       columnName;
    private List<Column> children;
    private boolean      isParent;

    public Column(String columnName, List<Column> children){
        this.columnName = columnName;
        this.children   = children;
        isParent        = true;
    }

    @Override
    public int compareTo(@NonNull Column o) {
        return 0;
    }
}
