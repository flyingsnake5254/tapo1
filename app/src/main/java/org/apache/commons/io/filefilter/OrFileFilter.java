package org.apache.commons.io.filefilter;

import com.tplink.libtpmediastatistics.SSLClient;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes4.dex */
public class OrFileFilter extends a implements Serializable {
    private static final long serialVersionUID = 5767770777065432721L;
    private final List<b> fileFilters;

    public OrFileFilter() {
        this.fileFilters = new ArrayList();
    }

    @Override // org.apache.commons.io.filefilter.a, org.apache.commons.io.filefilter.b, java.io.FileFilter
    public boolean accept(File file) {
        for (b bVar : this.fileFilters) {
            if (bVar.accept(file)) {
                return true;
            }
        }
        return false;
    }

    public void addFileFilter(b bVar) {
        this.fileFilters.add(bVar);
    }

    public List<b> getFileFilters() {
        return Collections.unmodifiableList(this.fileFilters);
    }

    public boolean removeFileFilter(b bVar) {
        return this.fileFilters.remove(bVar);
    }

    public void setFileFilters(List<b> list) {
        this.fileFilters.clear();
        this.fileFilters.addAll(list);
    }

    @Override // org.apache.commons.io.filefilter.a
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("(");
        if (this.fileFilters != null) {
            for (int i = 0; i < this.fileFilters.size(); i++) {
                if (i > 0) {
                    sb.append(SSLClient.COMMA);
                }
                b bVar = this.fileFilters.get(i);
                sb.append(bVar == null ? "null" : bVar.toString());
            }
        }
        sb.append(")");
        return sb.toString();
    }

    public OrFileFilter(List<b> list) {
        if (list == null) {
            this.fileFilters = new ArrayList();
        } else {
            this.fileFilters = new ArrayList(list);
        }
    }

    @Override // org.apache.commons.io.filefilter.a, org.apache.commons.io.filefilter.b, java.io.FilenameFilter
    public boolean accept(File file, String str) {
        for (b bVar : this.fileFilters) {
            if (bVar.accept(file, str)) {
                return true;
            }
        }
        return false;
    }

    public OrFileFilter(b bVar, b bVar2) {
        if (bVar == null || bVar2 == null) {
            throw new IllegalArgumentException("The filters must not be null");
        }
        this.fileFilters = new ArrayList(2);
        addFileFilter(bVar);
        addFileFilter(bVar2);
    }
}
