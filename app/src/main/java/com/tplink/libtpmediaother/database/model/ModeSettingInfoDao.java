package com.tplink.libtpmediaother.database.model;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import com.tplink.libtpmediaother.database.model.e;
import java.util.List;
import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;
import org.greenrobot.greendao.internal.DaoConfig;

/* loaded from: classes3.dex */
public class ModeSettingInfoDao extends AbstractDao<e, Void> {
    public static final String TABLENAME = "MODE_SETTING_INFO";
    private final e.c a = new e.c();

    /* renamed from: b  reason: collision with root package name */
    private final e.c f12593b = new e.c();

    /* renamed from: c  reason: collision with root package name */
    private final e.a f12594c = new e.a();

    /* renamed from: d  reason: collision with root package name */
    private final e.b f12595d = new e.b();

    /* renamed from: e  reason: collision with root package name */
    private final e.a f12596e = new e.a();

    /* loaded from: classes3.dex */
    public static class Properties {
        public static final Property A;
        public static final Property B;
        public static final Property D;
        public static final Property E;
        public static final Property F;

        /* renamed from: b  reason: collision with root package name */
        public static final Property f12597b;

        /* renamed from: c  reason: collision with root package name */
        public static final Property f12598c;

        /* renamed from: d  reason: collision with root package name */
        public static final Property f12599d;

        /* renamed from: e  reason: collision with root package name */
        public static final Property f12600e;

        /* renamed from: f  reason: collision with root package name */
        public static final Property f12601f;
        public static final Property g;
        public static final Property h;
        public static final Property i;
        public static final Property j;
        public static final Property k;
        public static final Property l;
        public static final Property m;
        public static final Property n;
        public static final Property p;
        public static final Property q;
        public static final Property r;
        public static final Property s;
        public static final Property t;
        public static final Property u;
        public static final Property v;
        public static final Property w;
        public static final Property x;
        public static final Property y;
        public static final Property z;
        public static final Property a = new Property(0, String.class, "deviceIdMD5", false, "DEVICE_ID_MD5");
        public static final Property o = new Property(14, String.class, "alarmSoundType", false, "ALARM_SOUND_TYPE");
        public static final Property C = new Property(28, String.class, "regionList", false, "REGION_LIST");
        public static final Property G = new Property(32, String.class, "tamperSensitivity", false, "TAMPER_SENSITIVITY");
        public static final Property H = new Property(33, String.class, "areaIntrusionRegionList", false, "AREA_INTRUSION_REGION_LIST");
        public static final Property I = new Property(34, String.class, "areaIntrusionArmScheduleInfo", false, "AREA_INTRUSION_ARM_SCHEDULE_INFO");
        public static final Property J = new Property(35, String.class, "lineCrossingRegionList", false, "LINE_CROSSING_REGION_LIST");
        public static final Property K = new Property(36, String.class, "lineCrossingArmScheduleInfo", false, "LINE_CROSSING_ARM_SCHEDULE_INFO");

        static {
            Class cls = Boolean.TYPE;
            f12597b = new Property(1, cls, "inHomeMode", false, "IN_HOME_MODE");
            f12598c = new Property(2, cls, "notificationEnable", false, "NOTIFICATION_ENABLE");
            f12599d = new Property(3, cls, "detectionEnable", false, "DETECTION_ENABLE");
            f12600e = new Property(4, cls, "humanRecognitionEnabled", false, "HUMAN_RECOGNITION_ENABLED");
            f12601f = new Property(5, cls, "babyCryingDetectionEnabled", false, "BABY_CRYING_DETECTION_ENABLED");
            g = new Property(6, cls, "humanEnhancedEnabled", false, "HUMAN_ENHANCED_ENABLED");
            h = new Property(7, cls, "targetTrackEnabled", false, "TARGET_TRACK_ENABLED");
            Class cls2 = Integer.TYPE;
            i = new Property(8, cls2, "babyCryingDetectionSensitivity", false, "BABY_CRYING_DETECTION_SENSITIVITY");
            j = new Property(9, cls2, "sensitivity", false, "SENSITIVITY");
            k = new Property(10, cls, "alarmEnabled", false, "ALARM_ENABLED");
            l = new Property(11, cls, "alarmSoundEnabled", false, "ALARM_SOUND_ENABLED");
            m = new Property(12, cls, "alarmLightEnabled", false, "ALARM_LIGHT_ENABLED");
            n = new Property(13, cls, "scheduleEnabled", false, "SCHEDULE_ENABLED");
            p = new Property(15, cls2, "alarmStartHour", false, "ALARM_START_HOUR");
            q = new Property(16, cls2, "alarmStartMinute", false, "ALARM_START_MINUTE");
            r = new Property(17, cls2, "alarmEndHour", false, "ALARM_END_HOUR");
            s = new Property(18, cls2, "alarmEndMinute", false, "ALARM_END_MINUTE");
            t = new Property(19, cls2, "alarmDays", false, "ALARM_DAYS");
            u = new Property(20, cls, "msgPushNotificationEnabled", false, "MSG_PUSH_NOTIFICATION_ENABLED");
            v = new Property(21, cls, "msgPushRichNotificationEnabled", false, "MSG_PUSH_RICH_NOTIFICATION_ENABLED");
            w = new Property(22, cls, "msgPushScheduleEnabled", false, "MSG_PUSH_SCHEDULE_ENABLED");
            x = new Property(23, cls2, "msgPushStartHour", false, "MSG_PUSH_START_HOUR");
            y = new Property(24, cls2, "msgPushStartMinute", false, "MSG_PUSH_START_MINUTE");
            z = new Property(25, cls2, "msgPushEndHour", false, "MSG_PUSH_END_HOUR");
            A = new Property(26, cls2, "msgPushEndMinute", false, "MSG_PUSH_END_MINUTE");
            B = new Property(27, cls2, "msgPushDays", false, "MSG_PUSH_DAYS");
            D = new Property(29, cls, "tamperDetectionEnabled", false, "TAMPER_DETECTION_ENABLED");
            E = new Property(30, cls, "areaIntrusionDetectionEnabled", false, "AREA_INTRUSION_DETECTION_ENABLED");
            F = new Property(31, cls, "lineCrossingDetectionEnabled", false, "LINE_CROSSING_DETECTION_ENABLED");
        }
    }

    public ModeSettingInfoDao(DaoConfig daoConfig, b bVar) {
        super(daoConfig, bVar);
    }

    public static void c(Database database, boolean z) {
        String str = z ? "IF NOT EXISTS " : "";
        database.execSQL("CREATE TABLE " + str + "\"MODE_SETTING_INFO\" (\"DEVICE_ID_MD5\" TEXT,\"IN_HOME_MODE\" INTEGER NOT NULL ,\"NOTIFICATION_ENABLE\" INTEGER NOT NULL ,\"DETECTION_ENABLE\" INTEGER NOT NULL ,\"HUMAN_RECOGNITION_ENABLED\" INTEGER NOT NULL ,\"BABY_CRYING_DETECTION_ENABLED\" INTEGER NOT NULL ,\"HUMAN_ENHANCED_ENABLED\" INTEGER NOT NULL ,\"TARGET_TRACK_ENABLED\" INTEGER NOT NULL ,\"BABY_CRYING_DETECTION_SENSITIVITY\" INTEGER NOT NULL ,\"SENSITIVITY\" INTEGER NOT NULL ,\"ALARM_ENABLED\" INTEGER NOT NULL ,\"ALARM_SOUND_ENABLED\" INTEGER NOT NULL ,\"ALARM_LIGHT_ENABLED\" INTEGER NOT NULL ,\"SCHEDULE_ENABLED\" INTEGER NOT NULL ,\"ALARM_SOUND_TYPE\" TEXT,\"ALARM_START_HOUR\" INTEGER NOT NULL ,\"ALARM_START_MINUTE\" INTEGER NOT NULL ,\"ALARM_END_HOUR\" INTEGER NOT NULL ,\"ALARM_END_MINUTE\" INTEGER NOT NULL ,\"ALARM_DAYS\" INTEGER NOT NULL ,\"MSG_PUSH_NOTIFICATION_ENABLED\" INTEGER NOT NULL ,\"MSG_PUSH_RICH_NOTIFICATION_ENABLED\" INTEGER NOT NULL ,\"MSG_PUSH_SCHEDULE_ENABLED\" INTEGER NOT NULL ,\"MSG_PUSH_START_HOUR\" INTEGER NOT NULL ,\"MSG_PUSH_START_MINUTE\" INTEGER NOT NULL ,\"MSG_PUSH_END_HOUR\" INTEGER NOT NULL ,\"MSG_PUSH_END_MINUTE\" INTEGER NOT NULL ,\"MSG_PUSH_DAYS\" INTEGER NOT NULL ,\"REGION_LIST\" TEXT NOT NULL ,\"TAMPER_DETECTION_ENABLED\" INTEGER NOT NULL ,\"AREA_INTRUSION_DETECTION_ENABLED\" INTEGER NOT NULL ,\"LINE_CROSSING_DETECTION_ENABLED\" INTEGER NOT NULL ,\"TAMPER_SENSITIVITY\" TEXT,\"AREA_INTRUSION_REGION_LIST\" TEXT,\"AREA_INTRUSION_ARM_SCHEDULE_INFO\" TEXT,\"LINE_CROSSING_REGION_LIST\" TEXT,\"LINE_CROSSING_ARM_SCHEDULE_INFO\" TEXT);");
        database.execSQL("CREATE UNIQUE INDEX " + str + "IDX_MODE_SETTING_INFO_DEVICE_ID_MD5_IN_HOME_MODE ON \"MODE_SETTING_INFO\" (\"DEVICE_ID_MD5\" ASC,\"IN_HOME_MODE\" ASC);");
    }

    public static void d(Database database, boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append("DROP TABLE ");
        sb.append(z ? "IF EXISTS " : "");
        sb.append("\"MODE_SETTING_INFO\"");
        database.execSQL(sb.toString());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public final void bindValues(SQLiteStatement sQLiteStatement, e eVar) {
        sQLiteStatement.clearBindings();
        String q = eVar.q();
        if (q != null) {
            sQLiteStatement.bindString(1, q);
        }
        long j = 1;
        sQLiteStatement.bindLong(2, eVar.t() ? 1L : 0L);
        sQLiteStatement.bindLong(3, eVar.G() ? 1L : 0L);
        sQLiteStatement.bindLong(4, eVar.p() ? 1L : 0L);
        sQLiteStatement.bindLong(5, eVar.s() ? 1L : 0L);
        sQLiteStatement.bindLong(6, eVar.n() ? 1L : 0L);
        sQLiteStatement.bindLong(7, eVar.r() ? 1L : 0L);
        sQLiteStatement.bindLong(8, eVar.M() ? 1L : 0L);
        sQLiteStatement.bindLong(9, eVar.o());
        sQLiteStatement.bindLong(10, eVar.J());
        sQLiteStatement.bindLong(11, eVar.c() ? 1L : 0L);
        sQLiteStatement.bindLong(12, eVar.g() ? 1L : 0L);
        sQLiteStatement.bindLong(13, eVar.f() ? 1L : 0L);
        sQLiteStatement.bindLong(14, eVar.I() ? 1L : 0L);
        String h = eVar.h();
        if (h != null) {
            sQLiteStatement.bindString(15, h);
        }
        sQLiteStatement.bindLong(16, eVar.i());
        sQLiteStatement.bindLong(17, eVar.j());
        sQLiteStatement.bindLong(18, eVar.d());
        sQLiteStatement.bindLong(19, eVar.e());
        sQLiteStatement.bindLong(20, eVar.b());
        sQLiteStatement.bindLong(21, eVar.B() ? 1L : 0L);
        sQLiteStatement.bindLong(22, eVar.C() ? 1L : 0L);
        sQLiteStatement.bindLong(23, eVar.D() ? 1L : 0L);
        sQLiteStatement.bindLong(24, eVar.E());
        sQLiteStatement.bindLong(25, eVar.F());
        sQLiteStatement.bindLong(26, eVar.z());
        sQLiteStatement.bindLong(27, eVar.A());
        sQLiteStatement.bindLong(28, eVar.y());
        sQLiteStatement.bindString(29, this.a.convertToDatabaseValue(eVar.H()));
        sQLiteStatement.bindLong(30, eVar.K() ? 1L : 0L);
        sQLiteStatement.bindLong(31, eVar.l() ? 1L : 0L);
        if (!eVar.v()) {
            j = 0;
        }
        sQLiteStatement.bindLong(32, j);
        String L = eVar.L();
        if (L != null) {
            sQLiteStatement.bindString(33, L);
        }
        List<e.c> m = eVar.m();
        if (m != null) {
            sQLiteStatement.bindString(34, this.f12593b.convertToDatabaseValue(m));
        }
        e.a k = eVar.k();
        if (k != null) {
            sQLiteStatement.bindString(35, this.f12594c.convertToDatabaseValue(k));
        }
        List<e.b> w = eVar.w();
        if (w != null) {
            sQLiteStatement.bindString(36, this.f12595d.convertToDatabaseValue(w));
        }
        e.a u = eVar.u();
        if (u != null) {
            sQLiteStatement.bindString(37, this.f12596e.convertToDatabaseValue(u));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: b */
    public final void bindValues(DatabaseStatement databaseStatement, e eVar) {
        databaseStatement.clearBindings();
        String q = eVar.q();
        if (q != null) {
            databaseStatement.bindString(1, q);
        }
        long j = 1;
        databaseStatement.bindLong(2, eVar.t() ? 1L : 0L);
        databaseStatement.bindLong(3, eVar.G() ? 1L : 0L);
        databaseStatement.bindLong(4, eVar.p() ? 1L : 0L);
        databaseStatement.bindLong(5, eVar.s() ? 1L : 0L);
        databaseStatement.bindLong(6, eVar.n() ? 1L : 0L);
        databaseStatement.bindLong(7, eVar.r() ? 1L : 0L);
        databaseStatement.bindLong(8, eVar.M() ? 1L : 0L);
        databaseStatement.bindLong(9, eVar.o());
        databaseStatement.bindLong(10, eVar.J());
        databaseStatement.bindLong(11, eVar.c() ? 1L : 0L);
        databaseStatement.bindLong(12, eVar.g() ? 1L : 0L);
        databaseStatement.bindLong(13, eVar.f() ? 1L : 0L);
        databaseStatement.bindLong(14, eVar.I() ? 1L : 0L);
        String h = eVar.h();
        if (h != null) {
            databaseStatement.bindString(15, h);
        }
        databaseStatement.bindLong(16, eVar.i());
        databaseStatement.bindLong(17, eVar.j());
        databaseStatement.bindLong(18, eVar.d());
        databaseStatement.bindLong(19, eVar.e());
        databaseStatement.bindLong(20, eVar.b());
        databaseStatement.bindLong(21, eVar.B() ? 1L : 0L);
        databaseStatement.bindLong(22, eVar.C() ? 1L : 0L);
        databaseStatement.bindLong(23, eVar.D() ? 1L : 0L);
        databaseStatement.bindLong(24, eVar.E());
        databaseStatement.bindLong(25, eVar.F());
        databaseStatement.bindLong(26, eVar.z());
        databaseStatement.bindLong(27, eVar.A());
        databaseStatement.bindLong(28, eVar.y());
        databaseStatement.bindString(29, this.a.convertToDatabaseValue(eVar.H()));
        databaseStatement.bindLong(30, eVar.K() ? 1L : 0L);
        databaseStatement.bindLong(31, eVar.l() ? 1L : 0L);
        if (!eVar.v()) {
            j = 0;
        }
        databaseStatement.bindLong(32, j);
        String L = eVar.L();
        if (L != null) {
            databaseStatement.bindString(33, L);
        }
        List<e.c> m = eVar.m();
        if (m != null) {
            databaseStatement.bindString(34, this.f12593b.convertToDatabaseValue(m));
        }
        e.a k = eVar.k();
        if (k != null) {
            databaseStatement.bindString(35, this.f12594c.convertToDatabaseValue(k));
        }
        List<e.b> w = eVar.w();
        if (w != null) {
            databaseStatement.bindString(36, this.f12595d.convertToDatabaseValue(w));
        }
        e.a u = eVar.u();
        if (u != null) {
            databaseStatement.bindString(37, this.f12596e.convertToDatabaseValue(u));
        }
    }

    /* renamed from: e */
    public Void getKey(e eVar) {
        return null;
    }

    /* renamed from: f */
    public boolean hasKey(e eVar) {
        return false;
    }

    /* renamed from: g */
    public e readEntity(Cursor cursor, int i) {
        int i2 = i + 0;
        String string = cursor.isNull(i2) ? null : cursor.getString(i2);
        boolean z = cursor.getShort(i + 1) != 0;
        boolean z2 = cursor.getShort(i + 2) != 0;
        boolean z3 = cursor.getShort(i + 3) != 0;
        boolean z4 = cursor.getShort(i + 4) != 0;
        boolean z5 = cursor.getShort(i + 5) != 0;
        boolean z6 = cursor.getShort(i + 6) != 0;
        boolean z7 = cursor.getShort(i + 7) != 0;
        int i3 = cursor.getInt(i + 8);
        int i4 = cursor.getInt(i + 9);
        boolean z8 = cursor.getShort(i + 10) != 0;
        boolean z9 = cursor.getShort(i + 11) != 0;
        boolean z10 = cursor.getShort(i + 12) != 0;
        boolean z11 = cursor.getShort(i + 13) != 0;
        int i5 = i + 14;
        String string2 = cursor.isNull(i5) ? null : cursor.getString(i5);
        int i6 = cursor.getInt(i + 15);
        int i7 = cursor.getInt(i + 16);
        int i8 = cursor.getInt(i + 17);
        int i9 = cursor.getInt(i + 18);
        int i10 = cursor.getInt(i + 19);
        boolean z12 = cursor.getShort(i + 20) != 0;
        boolean z13 = cursor.getShort(i + 21) != 0;
        boolean z14 = cursor.getShort(i + 22) != 0;
        int i11 = cursor.getInt(i + 23);
        int i12 = cursor.getInt(i + 24);
        int i13 = cursor.getInt(i + 25);
        int i14 = cursor.getInt(i + 26);
        int i15 = cursor.getInt(i + 27);
        List<e.c> b2 = this.a.convertToEntityProperty(cursor.getString(i + 28));
        boolean z15 = cursor.getShort(i + 29) != 0;
        boolean z16 = cursor.getShort(i + 30) != 0;
        boolean z17 = cursor.getShort(i + 31) != 0;
        int i16 = i + 32;
        String string3 = cursor.isNull(i16) ? null : cursor.getString(i16);
        int i17 = i + 33;
        List<e.c> b3 = cursor.isNull(i17) ? null : this.f12593b.convertToEntityProperty(cursor.getString(i17));
        int i18 = i + 34;
        e.a b4 = cursor.isNull(i18) ? null : this.f12594c.convertToEntityProperty(cursor.getString(i18));
        int i19 = i + 35;
        List<e.b> c2 = cursor.isNull(i19) ? null : this.f12595d.convertToEntityProperty(cursor.getString(i19));
        int i20 = i + 36;
        return new e(string, z, z2, z3, z4, z5, z6, z7, i3, i4, z8, z9, z10, z11, string2, i6, i7, i8, i9, i10, z12, z13, z14, i11, i12, i13, i14, i15, b2, z15, z16, z17, string3, b3, b4, c2, cursor.isNull(i20) ? null : this.f12596e.convertToEntityProperty(cursor.getString(i20)));
    }

    /* renamed from: h */
    public void readEntity(Cursor cursor, e eVar, int i) {
        int i2 = i + 0;
        e.a aVar = null;
        eVar.f0(cursor.isNull(i2) ? null : cursor.getString(i2));
        boolean z = true;
        eVar.i0(cursor.getShort(i + 1) != 0);
        eVar.u0(cursor.getShort(i + 2) != 0);
        eVar.e0(cursor.getShort(i + 3) != 0);
        eVar.h0(cursor.getShort(i + 4) != 0);
        eVar.c0(cursor.getShort(i + 5) != 0);
        eVar.g0(cursor.getShort(i + 6) != 0);
        eVar.A0(cursor.getShort(i + 7) != 0);
        eVar.d0(cursor.getInt(i + 8));
        eVar.x0(cursor.getInt(i + 9));
        eVar.R(cursor.getShort(i + 10) != 0);
        eVar.V(cursor.getShort(i + 11) != 0);
        eVar.U(cursor.getShort(i + 12) != 0);
        eVar.w0(cursor.getShort(i + 13) != 0);
        int i3 = i + 14;
        eVar.W(cursor.isNull(i3) ? null : cursor.getString(i3));
        eVar.X(cursor.getInt(i + 15));
        eVar.Y(cursor.getInt(i + 16));
        eVar.S(cursor.getInt(i + 17));
        eVar.T(cursor.getInt(i + 18));
        eVar.Q(cursor.getInt(i + 19));
        eVar.p0(cursor.getShort(i + 20) != 0);
        eVar.q0(cursor.getShort(i + 21) != 0);
        eVar.r0(cursor.getShort(i + 22) != 0);
        eVar.s0(cursor.getInt(i + 23));
        eVar.t0(cursor.getInt(i + 24));
        eVar.n0(cursor.getInt(i + 25));
        eVar.o0(cursor.getInt(i + 26));
        eVar.m0(cursor.getInt(i + 27));
        eVar.v0(this.a.convertToEntityProperty(cursor.getString(i + 28)));
        eVar.y0(cursor.getShort(i + 29) != 0);
        eVar.a0(cursor.getShort(i + 30) != 0);
        if (cursor.getShort(i + 31) == 0) {
            z = false;
        }
        eVar.k0(z);
        int i4 = i + 32;
        eVar.z0(cursor.isNull(i4) ? null : cursor.getString(i4));
        int i5 = i + 33;
        eVar.b0(cursor.isNull(i5) ? null : this.f12593b.convertToEntityProperty(cursor.getString(i5)));
        int i6 = i + 34;
        eVar.Z(cursor.isNull(i6) ? null : this.f12594c.convertToEntityProperty(cursor.getString(i6)));
        int i7 = i + 35;
        eVar.l0(cursor.isNull(i7) ? null : this.f12595d.convertToEntityProperty(cursor.getString(i7)));
        int i8 = i + 36;
        if (!cursor.isNull(i8)) {
            aVar = this.f12596e.convertToEntityProperty(cursor.getString(i8));
        }
        eVar.j0(aVar);
    }

    /* renamed from: i */
    public Void readKey(Cursor cursor, int i) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.greenrobot.greendao.AbstractDao
    public final boolean isEntityUpdateable() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: j */
    public final Void updateKeyAfterInsert(e eVar, long j) {
        return null;
    }
}
