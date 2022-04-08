package com.github.mikephil.charting.data;

import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.utils.Utils;
import com.tplink.libtpmediastatistics.SSLClient;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public abstract class DataSet<T extends Entry> extends BaseDataSet<T> {
    protected List<T> mValues;
    protected float mYMax = -3.4028235E38f;
    protected float mYMin = Float.MAX_VALUE;
    protected float mXMax = -3.4028235E38f;
    protected float mXMin = Float.MAX_VALUE;

    /* loaded from: classes.dex */
    public enum Rounding {
        UP,
        DOWN,
        CLOSEST
    }

    public DataSet(List<T> list, String str) {
        super(str);
        this.mValues = null;
        this.mValues = list;
        if (list == null) {
            this.mValues = new ArrayList();
        }
        calcMinMax();
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public boolean addEntry(T t) {
        if (t == null) {
            return false;
        }
        List<T> values = getValues();
        if (values == null) {
            values = new ArrayList<>();
        }
        calcMinMax(t);
        return values.add(t);
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public void addEntryOrdered(T t) {
        if (t != null) {
            if (this.mValues == null) {
                this.mValues = new ArrayList();
            }
            calcMinMax(t);
            if (this.mValues.size() > 0) {
                List<T> list = this.mValues;
                if (list.get(list.size() - 1).getX() > t.getX()) {
                    this.mValues.add(getEntryIndex(t.getX(), t.getY(), Rounding.UP), t);
                    return;
                }
            }
            this.mValues.add(t);
        }
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public void calcMinMax() {
        List<T> list = this.mValues;
        if (!(list == null || list.isEmpty())) {
            this.mYMax = -3.4028235E38f;
            this.mYMin = Float.MAX_VALUE;
            this.mXMax = -3.4028235E38f;
            this.mXMin = Float.MAX_VALUE;
            for (T t : this.mValues) {
                calcMinMax(t);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void calcMinMaxX(T t) {
        if (t.getX() < this.mXMin) {
            this.mXMin = t.getX();
        }
        if (t.getX() > this.mXMax) {
            this.mXMax = t.getX();
        }
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public void calcMinMaxY(float f2, float f3) {
        List<T> list = this.mValues;
        if (!(list == null || list.isEmpty())) {
            this.mYMax = -3.4028235E38f;
            this.mYMin = Float.MAX_VALUE;
            int entryIndex = getEntryIndex(f3, Float.NaN, Rounding.UP);
            for (int entryIndex2 = getEntryIndex(f2, Float.NaN, Rounding.DOWN); entryIndex2 <= entryIndex; entryIndex2++) {
                calcMinMaxY(this.mValues.get(entryIndex2));
            }
        }
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public void clear() {
        this.mValues.clear();
        notifyDataSetChanged();
    }

    public abstract DataSet<T> copy();

    /* JADX INFO: Access modifiers changed from: protected */
    public void copy(DataSet dataSet) {
        super.copy((BaseDataSet) dataSet);
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x003b, code lost:
        r1 = r6.mValues.size();
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0041, code lost:
        if (r3 >= r1) goto L_0x0069;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0043, code lost:
        r2 = r6.mValues.get(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0051, code lost:
        if (r2.getX() != r7) goto L_0x0069;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0053, code lost:
        r0.add(r2);
        r3 = r3 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0024, code lost:
        if (r3 <= 0) goto L_0x003b;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0036, code lost:
        if (r6.mValues.get(r3 - 1).getX() != r7) goto L_0x003b;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0038, code lost:
        r3 = r3 - 1;
     */
    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.util.List<T> getEntriesForXValue(float r7) {
        /*
            r6 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.List<T extends com.github.mikephil.charting.data.Entry> r1 = r6.mValues
            int r1 = r1.size()
            int r1 = r1 + (-1)
            r2 = 0
        L_0x000e:
            if (r2 > r1) goto L_0x0069
            int r3 = r1 + r2
            int r3 = r3 / 2
            java.util.List<T extends com.github.mikephil.charting.data.Entry> r4 = r6.mValues
            java.lang.Object r4 = r4.get(r3)
            com.github.mikephil.charting.data.Entry r4 = (com.github.mikephil.charting.data.Entry) r4
            float r5 = r4.getX()
            int r5 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r5 != 0) goto L_0x0059
        L_0x0024:
            if (r3 <= 0) goto L_0x003b
            java.util.List<T extends com.github.mikephil.charting.data.Entry> r1 = r6.mValues
            int r2 = r3 + (-1)
            java.lang.Object r1 = r1.get(r2)
            com.github.mikephil.charting.data.Entry r1 = (com.github.mikephil.charting.data.Entry) r1
            float r1 = r1.getX()
            int r1 = (r1 > r7 ? 1 : (r1 == r7 ? 0 : -1))
            if (r1 != 0) goto L_0x003b
            int r3 = r3 + (-1)
            goto L_0x0024
        L_0x003b:
            java.util.List<T extends com.github.mikephil.charting.data.Entry> r1 = r6.mValues
            int r1 = r1.size()
        L_0x0041:
            if (r3 >= r1) goto L_0x0069
            java.util.List<T extends com.github.mikephil.charting.data.Entry> r2 = r6.mValues
            java.lang.Object r2 = r2.get(r3)
            com.github.mikephil.charting.data.Entry r2 = (com.github.mikephil.charting.data.Entry) r2
            float r4 = r2.getX()
            int r4 = (r4 > r7 ? 1 : (r4 == r7 ? 0 : -1))
            if (r4 != 0) goto L_0x0069
            r0.add(r2)
            int r3 = r3 + 1
            goto L_0x0041
        L_0x0059:
            float r4 = r4.getX()
            int r4 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r4 <= 0) goto L_0x0065
            int r3 = r3 + 1
            r2 = r3
            goto L_0x000e
        L_0x0065:
            int r3 = r3 + (-1)
            r1 = r3
            goto L_0x000e
        L_0x0069:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.mikephil.charting.data.DataSet.getEntriesForXValue(float):java.util.List");
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public int getEntryCount() {
        return this.mValues.size();
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public T getEntryForIndex(int i) {
        return this.mValues.get(i);
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public T getEntryForXValue(float f2, float f3, Rounding rounding) {
        int entryIndex = getEntryIndex(f2, f3, rounding);
        if (entryIndex > -1) {
            return this.mValues.get(entryIndex);
        }
        return null;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public int getEntryIndex(Entry entry) {
        return this.mValues.indexOf(entry);
    }

    public List<T> getValues() {
        return this.mValues;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public float getXMax() {
        return this.mXMax;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public float getXMin() {
        return this.mXMin;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public float getYMax() {
        return this.mYMax;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public float getYMin() {
        return this.mYMin;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public boolean removeEntry(T t) {
        List<T> list;
        if (t == null || (list = this.mValues) == null) {
            return false;
        }
        boolean remove = list.remove(t);
        if (remove) {
            calcMinMax();
        }
        return remove;
    }

    public void setValues(List<T> list) {
        this.mValues = list;
        notifyDataSetChanged();
    }

    public String toSimpleString() {
        StringBuffer stringBuffer = new StringBuffer();
        StringBuilder sb = new StringBuilder();
        sb.append("DataSet, label: ");
        sb.append(getLabel() == null ? "" : getLabel());
        sb.append(", entries: ");
        sb.append(this.mValues.size());
        sb.append("\n");
        stringBuffer.append(sb.toString());
        return stringBuffer.toString();
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(toSimpleString());
        for (int i = 0; i < this.mValues.size(); i++) {
            stringBuffer.append(this.mValues.get(i).toString() + SSLClient.WHITE_SPACE);
        }
        return stringBuffer.toString();
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public int getEntryIndex(float f2, float f3, Rounding rounding) {
        T t;
        List<T> list = this.mValues;
        if (list == null || list.isEmpty()) {
            return -1;
        }
        int i = 0;
        int size = this.mValues.size() - 1;
        while (i < size) {
            int i2 = (i + size) / 2;
            float x = this.mValues.get(i2).getX() - f2;
            int i3 = i2 + 1;
            float abs = Math.abs(x);
            float abs2 = Math.abs(this.mValues.get(i3).getX() - f2);
            if (abs2 >= abs) {
                if (abs >= abs2) {
                    double d2 = x;
                    if (d2 < Utils.DOUBLE_EPSILON) {
                        if (d2 < Utils.DOUBLE_EPSILON) {
                        }
                    }
                }
                size = i2;
            }
            i = i3;
        }
        if (size == -1) {
            return size;
        }
        float x2 = this.mValues.get(size).getX();
        if (rounding == Rounding.UP) {
            if (x2 < f2 && size < this.mValues.size() - 1) {
                size++;
            }
        } else if (rounding == Rounding.DOWN && x2 > f2 && size > 0) {
            size--;
        }
        if (Float.isNaN(f3)) {
            return size;
        }
        while (size > 0 && this.mValues.get(size - 1).getX() == x2) {
            size--;
        }
        float y = this.mValues.get(size).getY();
        loop2: while (true) {
            do {
                size++;
                if (size >= this.mValues.size()) {
                    break loop2;
                }
                t = this.mValues.get(size);
                if (t.getX() != x2) {
                    break loop2;
                }
            } while (Math.abs(t.getY() - f3) >= Math.abs(y - f3));
            y = f3;
        }
        return size;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IDataSet
    public T getEntryForXValue(float f2, float f3) {
        return getEntryForXValue(f2, f3, Rounding.CLOSEST);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void calcMinMaxY(T t) {
        if (t.getY() < this.mYMin) {
            this.mYMin = t.getY();
        }
        if (t.getY() > this.mYMax) {
            this.mYMax = t.getY();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void calcMinMax(T t) {
        if (t != null) {
            calcMinMaxX(t);
            calcMinMaxY(t);
        }
    }
}
