package com.jcraft.jsch;

import com.tplink.libtpmediastatistics.SSLClient;
import java.util.Date;

/* loaded from: classes2.dex */
public class SftpATTRS {
    public static final int SSH_FILEXFER_ATTR_ACMODTIME = 8;
    public static final int SSH_FILEXFER_ATTR_EXTENDED = Integer.MIN_VALUE;
    public static final int SSH_FILEXFER_ATTR_PERMISSIONS = 4;
    public static final int SSH_FILEXFER_ATTR_SIZE = 1;
    public static final int SSH_FILEXFER_ATTR_UIDGID = 2;
    static final int S_IEXEC = 64;
    static final int S_IFBLK = 24576;
    static final int S_IFCHR = 8192;
    static final int S_IFDIR = 16384;
    static final int S_IFIFO = 4096;
    static final int S_IFLNK = 40960;
    static final int S_IFMT = 61440;
    static final int S_IFREG = 32768;
    static final int S_IFSOCK = 49152;
    static final int S_IREAD = 256;
    static final int S_IRGRP = 32;
    static final int S_IROTH = 4;
    static final int S_IRUSR = 256;
    static final int S_ISGID = 1024;
    static final int S_ISUID = 2048;
    static final int S_ISVTX = 512;
    static final int S_IWGRP = 16;
    static final int S_IWOTH = 2;
    static final int S_IWRITE = 128;
    static final int S_IWUSR = 128;
    static final int S_IXGRP = 8;
    static final int S_IXOTH = 1;
    static final int S_IXUSR = 64;
    private static final int pmask = 4095;
    int atime;
    int gid;
    int mtime;
    int permissions;
    long size;
    int uid;
    int flags = 0;
    String[] extended = null;

    private SftpATTRS() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static SftpATTRS getATTR(Buffer buffer) {
        int i;
        SftpATTRS sftpATTRS = new SftpATTRS();
        int i2 = buffer.getInt();
        sftpATTRS.flags = i2;
        if ((i2 & 1) != 0) {
            sftpATTRS.size = buffer.getLong();
        }
        if ((sftpATTRS.flags & 2) != 0) {
            sftpATTRS.uid = buffer.getInt();
            sftpATTRS.gid = buffer.getInt();
        }
        if ((sftpATTRS.flags & 4) != 0) {
            sftpATTRS.permissions = buffer.getInt();
        }
        if ((sftpATTRS.flags & 8) != 0) {
            sftpATTRS.atime = buffer.getInt();
        }
        if ((sftpATTRS.flags & 8) != 0) {
            sftpATTRS.mtime = buffer.getInt();
        }
        if ((sftpATTRS.flags & Integer.MIN_VALUE) != 0 && (i = buffer.getInt()) > 0) {
            sftpATTRS.extended = new String[i * 2];
            for (int i3 = 0; i3 < i; i3++) {
                int i4 = i3 * 2;
                sftpATTRS.extended[i4] = Util.byte2str(buffer.getString());
                sftpATTRS.extended[i4 + 1] = Util.byte2str(buffer.getString());
            }
        }
        return sftpATTRS;
    }

    private boolean isType(int i) {
        return (this.flags & 4) != 0 && (this.permissions & S_IFMT) == i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void dump(Buffer buffer) {
        int length;
        buffer.putInt(this.flags);
        if ((this.flags & 1) != 0) {
            buffer.putLong(this.size);
        }
        if ((this.flags & 2) != 0) {
            buffer.putInt(this.uid);
            buffer.putInt(this.gid);
        }
        if ((this.flags & 4) != 0) {
            buffer.putInt(this.permissions);
        }
        if ((this.flags & 8) != 0) {
            buffer.putInt(this.atime);
        }
        if ((this.flags & 8) != 0) {
            buffer.putInt(this.mtime);
        }
        if ((this.flags & Integer.MIN_VALUE) != 0 && (length = this.extended.length / 2) > 0) {
            for (int i = 0; i < length; i++) {
                int i2 = i * 2;
                buffer.putString(Util.str2byte(this.extended[i2]));
                buffer.putString(Util.str2byte(this.extended[i2 + 1]));
            }
        }
    }

    public int getATime() {
        return this.atime;
    }

    public String getAtimeString() {
        return new Date(this.atime * 1000).toString();
    }

    public String[] getExtended() {
        return this.extended;
    }

    public int getFlags() {
        return this.flags;
    }

    public int getGId() {
        return this.gid;
    }

    public int getMTime() {
        return this.mtime;
    }

    public String getMtimeString() {
        return new Date(this.mtime * 1000).toString();
    }

    public int getPermissions() {
        return this.permissions;
    }

    public String getPermissionsString() {
        StringBuffer stringBuffer = new StringBuffer(10);
        if (isDir()) {
            stringBuffer.append('d');
        } else if (isLink()) {
            stringBuffer.append('l');
        } else {
            stringBuffer.append('-');
        }
        if ((this.permissions & 256) != 0) {
            stringBuffer.append('r');
        } else {
            stringBuffer.append('-');
        }
        if ((this.permissions & 128) != 0) {
            stringBuffer.append('w');
        } else {
            stringBuffer.append('-');
        }
        int i = this.permissions;
        if ((i & 2048) != 0) {
            stringBuffer.append('s');
        } else if ((i & 64) != 0) {
            stringBuffer.append('x');
        } else {
            stringBuffer.append('-');
        }
        if ((this.permissions & 32) != 0) {
            stringBuffer.append('r');
        } else {
            stringBuffer.append('-');
        }
        if ((this.permissions & 16) != 0) {
            stringBuffer.append('w');
        } else {
            stringBuffer.append('-');
        }
        int i2 = this.permissions;
        if ((i2 & 1024) != 0) {
            stringBuffer.append('s');
        } else if ((i2 & 8) != 0) {
            stringBuffer.append('x');
        } else {
            stringBuffer.append('-');
        }
        if ((this.permissions & 4) != 0) {
            stringBuffer.append('r');
        } else {
            stringBuffer.append('-');
        }
        if ((this.permissions & 2) != 0) {
            stringBuffer.append('w');
        } else {
            stringBuffer.append('-');
        }
        if ((this.permissions & 1) != 0) {
            stringBuffer.append('x');
        } else {
            stringBuffer.append('-');
        }
        return stringBuffer.toString();
    }

    public long getSize() {
        return this.size;
    }

    public int getUId() {
        return this.uid;
    }

    public boolean isBlk() {
        return isType(S_IFBLK);
    }

    public boolean isChr() {
        return isType(8192);
    }

    public boolean isDir() {
        return isType(16384);
    }

    public boolean isFifo() {
        return isType(4096);
    }

    public boolean isLink() {
        return isType(S_IFLNK);
    }

    public boolean isReg() {
        return isType(32768);
    }

    public boolean isSock() {
        return isType(S_IFSOCK);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int length() {
        int i = this.flags;
        int i2 = (i & 1) != 0 ? 12 : 4;
        if ((i & 2) != 0) {
            i2 += 8;
        }
        if ((i & 4) != 0) {
            i2 += 4;
        }
        if ((i & 8) != 0) {
            i2 += 8;
        }
        if ((i & Integer.MIN_VALUE) != 0) {
            i2 += 4;
            int length = this.extended.length / 2;
            if (length > 0) {
                for (int i3 = 0; i3 < length; i3++) {
                    int i4 = i3 * 2;
                    i2 = i2 + 4 + this.extended[i4].length() + 4 + this.extended[i4 + 1].length();
                }
            }
        }
        return i2;
    }

    public void setACMODTIME(int i, int i2) {
        this.flags |= 8;
        this.atime = i;
        this.mtime = i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setFLAGS(int i) {
        this.flags = i;
    }

    public void setPERMISSIONS(int i) {
        this.flags |= 4;
        this.permissions = (i & pmask) | (this.permissions & (-4096));
    }

    public void setSIZE(long j) {
        this.flags |= 1;
        this.size = j;
    }

    public void setUIDGID(int i, int i2) {
        this.flags |= 2;
        this.uid = i;
        this.gid = i2;
    }

    public String toString() {
        return getPermissionsString() + SSLClient.WHITE_SPACE + getUId() + SSLClient.WHITE_SPACE + getGId() + SSLClient.WHITE_SPACE + getSize() + SSLClient.WHITE_SPACE + getMtimeString();
    }
}
