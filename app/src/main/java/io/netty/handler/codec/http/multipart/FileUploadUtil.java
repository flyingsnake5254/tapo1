package io.netty.handler.codec.http.multipart;

/* loaded from: classes3.dex */
final class FileUploadUtil {
    private FileUploadUtil() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int compareTo(FileUpload fileUpload, FileUpload fileUpload2) {
        return fileUpload.getName().compareToIgnoreCase(fileUpload2.getName());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean equals(FileUpload fileUpload, FileUpload fileUpload2) {
        return fileUpload.getName().equalsIgnoreCase(fileUpload2.getName());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int hashCode(FileUpload fileUpload) {
        return fileUpload.getName().hashCode();
    }
}
