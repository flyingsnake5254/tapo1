package com.tplink.libtpnetwork.cameranetwork.bean.listing;

import com.tplink.libtpnetwork.cameranetwork.bean.helpers.KeyValue;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

/* loaded from: classes3.dex */
public class ListingUtils {
    public static List<ColumnFilter> getDefaultFilters() {
        ArrayList arrayList = new ArrayList();
        Calendar instance = GregorianCalendar.getInstance();
        instance.add(2, -1);
        arrayList.add(new ColumnFilter("updatedOn", instance.getTime(), Operation.GE));
        arrayList.add(new ColumnFilter("updatedOn", GregorianCalendar.getInstance().getTime(), Operation.LE));
        return arrayList;
    }

    public static KeyValue<String> getSortBy(String str, boolean z) {
        KeyValue<String> keyValue = new KeyValue<>();
        keyValue.setKey(str);
        keyValue.setValue(z ? "asc" : "desc");
        return keyValue;
    }
}
