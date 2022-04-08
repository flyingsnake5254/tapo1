package com.tplink.libtpnetwork.cameranetwork.net;

/* loaded from: classes3.dex */
public class CameraException extends Exception {
    public static final int DEVICE_NAME_EXCESSIVE = -63103;
    public static final int METHOD_DO_NOT_EXIST = -40210;
    public static final int MOTOR_BUSY = -64303;
    public static final int MOTOR_LOCKED_ROTOR = -64304;
    public static final int PRESET_ADD_MOVING = -64305;
    public static final int PRESET_SATURATED = -64306;
    public static final int SD_CARD_UNPLUGGED = -52409;
    public static final int TALK_IS_USED = -52411;
    public static final int TALK_WAY_WAS_USED = -52411;
    public static final int TOO_MANY_CLIENT = -52407;
    public static final int TOO_MANY_HTTPS_CLIENT = -52419;
    public static final int TOO_MANY_REQUEST = -52405;
    public static final int USER_ID_EMPLOYED = -71102;
    public static final int USER_ID_FULL = -71101;
    public static final int USER_ID_INVALID = -71103;
    public static final int VOD_INVALID_REQUEST = -52402;
    private final int errorCode;
    private final String message;
    private final String method;

    public CameraException(int i, String str) {
        this.errorCode = i;
        this.method = null;
        this.message = str;
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return this.message;
    }

    public String getMethod() {
        return this.method;
    }

    public CameraException(int i, String str, String str2) {
        this.errorCode = i;
        this.method = str;
        this.message = str2;
    }
}
