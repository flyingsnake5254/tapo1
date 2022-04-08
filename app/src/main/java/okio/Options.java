package okio;

import java.util.AbstractList;
import java.util.List;
import java.util.RandomAccess;

/* loaded from: classes4.dex */
public final class Options extends AbstractList<ByteString> implements RandomAccess {
    final ByteString[] byteStrings;
    final int[] trie;

    private Options(ByteString[] byteStringArr, int[] iArr) {
        this.byteStrings = byteStringArr;
        this.trie = iArr;
    }

    private static void buildTrieRecursive(long j, Buffer buffer, int i, List<ByteString> list, int i2, int i3, List<Integer> list2) {
        int i4;
        int i5;
        int i6 = i2;
        if (i6 < i3) {
            for (int i7 = i6; i7 < i3; i7++) {
                if (list.get(i7).size() < i) {
                    throw new AssertionError();
                }
            }
            ByteString byteString = list.get(i2);
            ByteString byteString2 = list.get(i3 - 1);
            int i8 = -1;
            if (i == byteString.size()) {
                i8 = list2.get(i6).intValue();
                i6++;
                byteString = list.get(i6);
            }
            if (byteString.getByte(i) != byteString2.getByte(i)) {
                int i9 = 1;
                for (int i10 = i6 + 1; i10 < i3; i10++) {
                    if (list.get(i10 - 1).getByte(i) != list.get(i10).getByte(i)) {
                        i9++;
                    }
                }
                long intCount = j + intCount(buffer) + 2 + (i9 * 2);
                buffer.writeInt(i9);
                buffer.writeInt(i8);
                for (int i11 = i6; i11 < i3; i11++) {
                    byte b2 = list.get(i11).getByte(i);
                    if (i11 == i6 || b2 != list.get(i11 - 1).getByte(i)) {
                        buffer.writeInt(b2 & 255);
                    }
                }
                Buffer buffer2 = new Buffer();
                int i12 = i6;
                while (i12 < i3) {
                    byte b3 = list.get(i12).getByte(i);
                    int i13 = i12 + 1;
                    int i14 = i13;
                    while (true) {
                        if (i14 >= i3) {
                            i5 = i3;
                            break;
                        } else if (b3 != list.get(i14).getByte(i)) {
                            i5 = i14;
                            break;
                        } else {
                            i14++;
                        }
                    }
                    if (i13 == i5 && i + 1 == list.get(i12).size()) {
                        buffer.writeInt(list2.get(i12).intValue());
                        i12 = i5;
                        buffer2 = buffer2;
                    } else {
                        buffer.writeInt((int) ((intCount(buffer2) + intCount) * (-1)));
                        i12 = i5;
                        buffer2 = buffer2;
                        buildTrieRecursive(intCount, buffer2, i + 1, list, i12, i5, list2);
                    }
                }
                buffer.write(buffer2, buffer2.size());
                return;
            }
            int i15 = 0;
            int min = Math.min(byteString.size(), byteString2.size());
            for (int i16 = i; i16 < min && byteString.getByte(i16) == byteString2.getByte(i16); i16++) {
                i15++;
            }
            long intCount2 = 1 + j + intCount(buffer) + 2 + i15;
            buffer.writeInt(-i15);
            buffer.writeInt(i8);
            int i17 = i;
            while (true) {
                i4 = i + i15;
                if (i17 >= i4) {
                    break;
                }
                buffer.writeInt(byteString.getByte(i17) & 255);
                i17++;
            }
            if (i6 + 1 != i3) {
                Buffer buffer3 = new Buffer();
                buffer.writeInt((int) ((intCount(buffer3) + intCount2) * (-1)));
                buildTrieRecursive(intCount2, buffer3, i4, list, i6, i3, list2);
                buffer.write(buffer3, buffer3.size());
            } else if (i4 == list.get(i6).size()) {
                buffer.writeInt(list2.get(i6).intValue());
            } else {
                throw new AssertionError();
            }
        } else {
            throw new AssertionError();
        }
    }

    private static int intCount(Buffer buffer) {
        return (int) (buffer.size() / 4);
    }

    /* JADX WARN: Code restructure failed: missing block: B:49:0x00bc, code lost:
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static okio.Options of(okio.ByteString... r10) {
        /*
            Method dump skipped, instructions count: 264
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.Options.of(okio.ByteString[]):okio.Options");
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.byteStrings.length;
    }

    @Override // java.util.AbstractList, java.util.List
    public ByteString get(int i) {
        return this.byteStrings[i];
    }
}
