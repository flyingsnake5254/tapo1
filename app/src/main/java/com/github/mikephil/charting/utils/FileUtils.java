package com.github.mikephil.charting.utils;

import android.content.res.AssetManager;
import android.os.Environment;
import android.util.Log;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.paho.client.mqttv3.MqttTopic;

/* loaded from: classes.dex */
public class FileUtils {
    private static final String LOG = "MPChart-FileUtils";

    /* JADX WARN: Multi-variable type inference failed */
    public static List<BarEntry> loadBarEntriesFromAssets(AssetManager assetManager, String str) {
        IOException e2;
        BufferedReader bufferedReader;
        ArrayList arrayList = new ArrayList();
        BufferedReader bufferedReader2 = null;
        BufferedReader bufferedReader3 = null;
        bufferedReader2 = null;
        bufferedReader2 = null;
        try {
            try {
                try {
                    bufferedReader = new BufferedReader(new InputStreamReader(assetManager.open(str), "UTF-8"));
                } catch (IOException e3) {
                    Log.e(LOG, e3.toString());
                }
            } catch (IOException e4) {
                e2 = e4;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            String readLine = bufferedReader.readLine();
            while (readLine != null) {
                String[] split = readLine.split(MqttTopic.MULTI_LEVEL_WILDCARD);
                float parseFloat = Float.parseFloat(split[1]);
                arrayList.add(new BarEntry(parseFloat, Float.parseFloat(split[0])));
                readLine = bufferedReader.readLine();
                bufferedReader3 = parseFloat;
            }
            bufferedReader.close();
            bufferedReader2 = bufferedReader3;
        } catch (IOException e5) {
            e2 = e5;
            bufferedReader2 = bufferedReader;
            Log.e(LOG, e2.toString());
            if (bufferedReader2 != null) {
                bufferedReader2.close();
                bufferedReader2 = bufferedReader2;
            }
            return arrayList;
        } catch (Throwable th2) {
            th = th2;
            bufferedReader2 = bufferedReader;
            if (bufferedReader2 != null) {
                try {
                    bufferedReader2.close();
                } catch (IOException e6) {
                    Log.e(LOG, e6.toString());
                }
            }
            throw th;
        }
        return arrayList;
    }

    /* JADX WARN: Type inference failed for: r2v10, types: [float] */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v8, types: [float[]] */
    /* JADX WARN: Unknown variable types count: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.util.List<com.github.mikephil.charting.data.Entry> loadEntriesFromAssets(android.content.res.AssetManager r7, java.lang.String r8) {
        /*
            java.lang.String r0 = "MPChart-FileUtils"
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            r2 = 0
            java.io.BufferedReader r3 = new java.io.BufferedReader     // Catch: all -> 0x0070, IOException -> 0x0072
            java.io.InputStreamReader r4 = new java.io.InputStreamReader     // Catch: all -> 0x0070, IOException -> 0x0072
            java.io.InputStream r7 = r7.open(r8)     // Catch: all -> 0x0070, IOException -> 0x0072
            java.lang.String r8 = "UTF-8"
            r4.<init>(r7, r8)     // Catch: all -> 0x0070, IOException -> 0x0072
            r3.<init>(r4)     // Catch: all -> 0x0070, IOException -> 0x0072
            java.lang.String r7 = r3.readLine()     // Catch: all -> 0x006a, IOException -> 0x006d
        L_0x001c:
            if (r7 == 0) goto L_0x0066
            java.lang.String r8 = "#"
            java.lang.String[] r7 = r7.split(r8)     // Catch: all -> 0x006a, IOException -> 0x006d
            int r8 = r7.length     // Catch: all -> 0x006a, IOException -> 0x006d
            r2 = 2
            r4 = 0
            r5 = 1
            if (r8 > r2) goto L_0x003f
            com.github.mikephil.charting.data.Entry r8 = new com.github.mikephil.charting.data.Entry     // Catch: all -> 0x006a, IOException -> 0x006d
            r2 = r7[r5]     // Catch: all -> 0x006a, IOException -> 0x006d
            float r2 = java.lang.Float.parseFloat(r2)     // Catch: all -> 0x006a, IOException -> 0x006d
            r7 = r7[r4]     // Catch: all -> 0x006a, IOException -> 0x006d
            float r7 = java.lang.Float.parseFloat(r7)     // Catch: all -> 0x006a, IOException -> 0x006d
            r8.<init>(r2, r7)     // Catch: all -> 0x006a, IOException -> 0x006d
            r1.add(r8)     // Catch: all -> 0x006a, IOException -> 0x006d
            goto L_0x0061
        L_0x003f:
            int r8 = r7.length     // Catch: all -> 0x006a, IOException -> 0x006d
            int r8 = r8 - r5
            float[] r2 = new float[r8]     // Catch: all -> 0x006a, IOException -> 0x006d
        L_0x0043:
            if (r4 >= r8) goto L_0x0050
            r6 = r7[r4]     // Catch: all -> 0x006a, IOException -> 0x006d
            float r6 = java.lang.Float.parseFloat(r6)     // Catch: all -> 0x006a, IOException -> 0x006d
            r2[r4] = r6     // Catch: all -> 0x006a, IOException -> 0x006d
            int r4 = r4 + 1
            goto L_0x0043
        L_0x0050:
            com.github.mikephil.charting.data.BarEntry r8 = new com.github.mikephil.charting.data.BarEntry     // Catch: all -> 0x006a, IOException -> 0x006d
            int r4 = r7.length     // Catch: all -> 0x006a, IOException -> 0x006d
            int r4 = r4 - r5
            r7 = r7[r4]     // Catch: all -> 0x006a, IOException -> 0x006d
            int r7 = java.lang.Integer.parseInt(r7)     // Catch: all -> 0x006a, IOException -> 0x006d
            float r7 = (float) r7     // Catch: all -> 0x006a, IOException -> 0x006d
            r8.<init>(r7, r2)     // Catch: all -> 0x006a, IOException -> 0x006d
            r1.add(r8)     // Catch: all -> 0x006a, IOException -> 0x006d
        L_0x0061:
            java.lang.String r7 = r3.readLine()     // Catch: all -> 0x006a, IOException -> 0x006d
            goto L_0x001c
        L_0x0066:
            r3.close()     // Catch: IOException -> 0x0080
            goto L_0x0088
        L_0x006a:
            r7 = move-exception
            r2 = r3
            goto L_0x0089
        L_0x006d:
            r7 = move-exception
            r2 = r3
            goto L_0x0073
        L_0x0070:
            r7 = move-exception
            goto L_0x0089
        L_0x0072:
            r7 = move-exception
        L_0x0073:
            java.lang.String r7 = r7.toString()     // Catch: all -> 0x0070
            android.util.Log.e(r0, r7)     // Catch: all -> 0x0070
            if (r2 == 0) goto L_0x0088
            r2.close()     // Catch: IOException -> 0x0080
            goto L_0x0088
        L_0x0080:
            r7 = move-exception
            java.lang.String r7 = r7.toString()
            android.util.Log.e(r0, r7)
        L_0x0088:
            return r1
        L_0x0089:
            if (r2 == 0) goto L_0x0097
            r2.close()     // Catch: IOException -> 0x008f
            goto L_0x0097
        L_0x008f:
            r8 = move-exception
            java.lang.String r8 = r8.toString()
            android.util.Log.e(r0, r8)
        L_0x0097:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.mikephil.charting.utils.FileUtils.loadEntriesFromAssets(android.content.res.AssetManager, java.lang.String):java.util.List");
    }

    public static List<Entry> loadEntriesFromFile(String str) {
        File file = new File(Environment.getExternalStorageDirectory(), str);
        ArrayList arrayList = new ArrayList();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                String[] split = readLine.split(MqttTopic.MULTI_LEVEL_WILDCARD);
                if (split.length <= 2) {
                    arrayList.add(new Entry(Float.parseFloat(split[0]), Integer.parseInt(split[1])));
                } else {
                    int length = split.length - 1;
                    float[] fArr = new float[length];
                    for (int i = 0; i < length; i++) {
                        fArr[i] = Float.parseFloat(split[i]);
                    }
                    arrayList.add(new BarEntry(Integer.parseInt(split[split.length - 1]), fArr));
                }
            }
        } catch (IOException e2) {
            Log.e(LOG, e2.toString());
        }
        return arrayList;
    }

    public static void saveToSdCard(List<Entry> list, String str) {
        File file = new File(Environment.getExternalStorageDirectory(), str);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e2) {
                Log.e(LOG, e2.toString());
            }
        }
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, true));
            for (Entry entry : list) {
                bufferedWriter.append((CharSequence) (entry.getY() + MqttTopic.MULTI_LEVEL_WILDCARD + entry.getX()));
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e3) {
            Log.e(LOG, e3.toString());
        }
    }
}
