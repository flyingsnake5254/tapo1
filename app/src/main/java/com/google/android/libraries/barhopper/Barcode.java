package com.google.android.libraries.barhopper;

import android.graphics.Point;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.apps.common.proguard.UsedByNative;

/* compiled from: com.google.mlkit:barcode-scanning@@16.0.1 */
@UsedByNative("barhopper-v2-jni.cc")
/* loaded from: classes2.dex */
public class Barcode implements Parcelable {
    public static final Parcelable.Creator<Barcode> CREATOR = new a();
    @UsedByNative("barhopper-v2-jni.cc")
    public BoardingPass boardingPass;
    @UsedByNative("barhopper-v2-jni.cc")
    public CalendarEvent calendarEvent;
    @UsedByNative("barhopper-v2-jni.cc")
    public ContactInfo contactInfo;
    @UsedByNative("barhopper-v2-jni.cc")
    public Point[] cornerPoints;
    @UsedByNative("barhopper-v2-jni.cc")
    public String displayValue;
    @UsedByNative("barhopper-v2-jni.cc")
    public DriverLicense driverLicense;
    @UsedByNative("barhopper-v2-jni.cc")
    public Email email;
    @UsedByNative("barhopper-v2-jni.cc")
    public int format;
    @UsedByNative("barhopper-v2-jni.cc")
    public GeoPoint geoPoint;
    @UsedByNative("barhopper-v2-jni.cc")
    public boolean isRecognized;
    @UsedByNative("barhopper-v2-jni.cc")
    public Phone phone;
    @UsedByNative("barhopper-v2-jni.cc")
    public byte[] rawBytes;
    @UsedByNative("barhopper-v2-jni.cc")
    public String rawValue;
    @UsedByNative("barhopper-v2-jni.cc")
    public Sms sms;
    @UsedByNative("barhopper-v2-jni.cc")
    public UrlBookmark url;
    @UsedByNative("barhopper-v2-jni.cc")
    public int valueFormat;
    @UsedByNative("barhopper-v2-jni.cc")
    public WiFi wifi;

    /* compiled from: com.google.mlkit:barcode-scanning@@16.0.1 */
    @UsedByNative("barhopper-v2-jni.cc")
    /* loaded from: classes2.dex */
    public static class Address implements Parcelable {
        public static final Parcelable.Creator<Address> CREATOR = new a();
        @UsedByNative("barhopper-v2-jni.cc")
        public String[] addressLines;
        @UsedByNative("barhopper-v2-jni.cc")
        public int type;

        @UsedByNative("barhopper-v2-jni.cc")
        public Address() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.type);
            parcel.writeStringArray(this.addressLines);
        }

        private Address(Parcel parcel) {
            this.type = parcel.readInt();
            this.addressLines = parcel.createStringArray();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public /* synthetic */ Address(Parcel parcel, a aVar) {
            this(parcel);
        }
    }

    /* compiled from: com.google.mlkit:barcode-scanning@@16.0.1 */
    @UsedByNative("barhopper-v2-jni.cc")
    /* loaded from: classes2.dex */
    public static class BoardingPass implements Parcelable {
        public static final Parcelable.Creator<BoardingPass> CREATOR = new b();
        @UsedByNative("barhopper-v2-jni.cc")
        public FlightSegment[] flightSegment;
        @UsedByNative("barhopper-v2-jni.cc")
        public String passengerName;

        @UsedByNative("barhopper-v2-jni.cc")
        public BoardingPass() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.passengerName);
            parcel.writeTypedArray(this.flightSegment, 0);
        }

        private BoardingPass(Parcel parcel) {
            this.passengerName = parcel.readString();
            this.flightSegment = (FlightSegment[]) parcel.createTypedArray(FlightSegment.CREATOR);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public /* synthetic */ BoardingPass(Parcel parcel, a aVar) {
            this(parcel);
        }
    }

    /* compiled from: com.google.mlkit:barcode-scanning@@16.0.1 */
    @UsedByNative("barhopper-v2-jni.cc")
    /* loaded from: classes2.dex */
    public static class CalendarDateTime implements Parcelable {
        public static final Parcelable.Creator<CalendarDateTime> CREATOR = new c();
        @UsedByNative("barhopper-v2-jni.cc")
        public int day;
        @UsedByNative("barhopper-v2-jni.cc")
        public int hours;
        @UsedByNative("barhopper-v2-jni.cc")
        public boolean isUtc;
        @UsedByNative("barhopper-v2-jni.cc")
        public int minutes;
        @UsedByNative("barhopper-v2-jni.cc")
        public int month;
        @UsedByNative("barhopper-v2-jni.cc")
        public String rawValue;
        @UsedByNative("barhopper-v2-jni.cc")
        public int seconds;
        @UsedByNative("barhopper-v2-jni.cc")
        public int year;

        @UsedByNative("barhopper-v2-jni.cc")
        public CalendarDateTime() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.year);
            parcel.writeInt(this.month);
            parcel.writeInt(this.day);
            parcel.writeInt(this.hours);
            parcel.writeInt(this.minutes);
            parcel.writeInt(this.seconds);
            parcel.writeByte(this.isUtc ? (byte) 1 : (byte) 0);
            parcel.writeString(this.rawValue);
        }

        private CalendarDateTime(Parcel parcel) {
            this.year = parcel.readInt();
            this.month = parcel.readInt();
            this.day = parcel.readInt();
            this.hours = parcel.readInt();
            this.minutes = parcel.readInt();
            this.seconds = parcel.readInt();
            this.isUtc = parcel.readByte() != 0;
            this.rawValue = parcel.readString();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public /* synthetic */ CalendarDateTime(Parcel parcel, a aVar) {
            this(parcel);
        }
    }

    /* compiled from: com.google.mlkit:barcode-scanning@@16.0.1 */
    @UsedByNative("barhopper-v2-jni.cc")
    /* loaded from: classes2.dex */
    public static class CalendarEvent implements Parcelable {
        public static final Parcelable.Creator<CalendarEvent> CREATOR = new d();
        @UsedByNative("barhopper-v2-jni.cc")
        public String description;
        @UsedByNative("barhopper-v2-jni.cc")
        public CalendarDateTime end;
        @UsedByNative("barhopper-v2-jni.cc")
        public String location;
        @UsedByNative("barhopper-v2-jni.cc")
        public String organizer;
        @UsedByNative("barhopper-v2-jni.cc")
        public CalendarDateTime start;
        @UsedByNative("barhopper-v2-jni.cc")
        public String status;
        @UsedByNative("barhopper-v2-jni.cc")
        public String summary;

        @UsedByNative("barhopper-v2-jni.cc")
        public CalendarEvent() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.summary);
            parcel.writeString(this.description);
            parcel.writeString(this.location);
            parcel.writeString(this.organizer);
            parcel.writeString(this.status);
            parcel.writeParcelable(this.start, 0);
            parcel.writeParcelable(this.end, 0);
        }

        private CalendarEvent(Parcel parcel) {
            this.summary = parcel.readString();
            this.description = parcel.readString();
            this.location = parcel.readString();
            this.organizer = parcel.readString();
            this.status = parcel.readString();
            this.start = (CalendarDateTime) parcel.readParcelable(CalendarDateTime.class.getClassLoader());
            this.end = (CalendarDateTime) parcel.readParcelable(CalendarDateTime.class.getClassLoader());
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public /* synthetic */ CalendarEvent(Parcel parcel, a aVar) {
            this(parcel);
        }
    }

    /* compiled from: com.google.mlkit:barcode-scanning@@16.0.1 */
    @UsedByNative("barhopper-v2-jni.cc")
    /* loaded from: classes2.dex */
    public static class ContactInfo implements Parcelable {
        public static final Parcelable.Creator<ContactInfo> CREATOR = new e();
        @UsedByNative("barhopper-v2-jni.cc")
        public Address[] addresses;
        @UsedByNative("barhopper-v2-jni.cc")
        public Email[] emails;
        @UsedByNative("barhopper-v2-jni.cc")
        public PersonName name;
        @UsedByNative("barhopper-v2-jni.cc")
        public String note;
        @UsedByNative("barhopper-v2-jni.cc")
        public String organization;
        @UsedByNative("barhopper-v2-jni.cc")
        public Phone[] phones;
        @UsedByNative("barhopper-v2-jni.cc")
        public String title;
        @UsedByNative("barhopper-v2-jni.cc")
        public String[] urls;

        @UsedByNative("barhopper-v2-jni.cc")
        public ContactInfo() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeParcelable(this.name, 0);
            parcel.writeString(this.organization);
            parcel.writeString(this.title);
            parcel.writeTypedArray(this.phones, 0);
            parcel.writeTypedArray(this.emails, 0);
            parcel.writeStringArray(this.urls);
            parcel.writeTypedArray(this.addresses, 0);
            parcel.writeString(this.note);
        }

        private ContactInfo(Parcel parcel) {
            this.name = (PersonName) parcel.readParcelable(PersonName.class.getClassLoader());
            this.organization = parcel.readString();
            this.title = parcel.readString();
            this.phones = (Phone[]) parcel.createTypedArray(Phone.CREATOR);
            this.emails = (Email[]) parcel.createTypedArray(Email.CREATOR);
            this.urls = parcel.createStringArray();
            this.addresses = (Address[]) parcel.createTypedArray(Address.CREATOR);
            this.note = parcel.readString();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public /* synthetic */ ContactInfo(Parcel parcel, a aVar) {
            this(parcel);
        }
    }

    /* compiled from: com.google.mlkit:barcode-scanning@@16.0.1 */
    @UsedByNative("barhopper-v2-jni.cc")
    /* loaded from: classes2.dex */
    public static class DriverLicense implements Parcelable {
        public static final Parcelable.Creator<DriverLicense> CREATOR = new f();
        @UsedByNative("barhopper-v2-jni.cc")
        public String addressCity;
        @UsedByNative("barhopper-v2-jni.cc")
        public String addressState;
        @UsedByNative("barhopper-v2-jni.cc")
        public String addressStreet;
        @UsedByNative("barhopper-v2-jni.cc")
        public String addressZip;
        @UsedByNative("barhopper-v2-jni.cc")
        public String birthDate;
        @UsedByNative("barhopper-v2-jni.cc")
        public String documentType;
        @UsedByNative("barhopper-v2-jni.cc")
        public String expiryDate;
        @UsedByNative("barhopper-v2-jni.cc")
        public String firstName;
        @UsedByNative("barhopper-v2-jni.cc")
        public String gender;
        @UsedByNative("barhopper-v2-jni.cc")
        public String issueDate;
        @UsedByNative("barhopper-v2-jni.cc")
        public String issuingCountry;
        @UsedByNative("barhopper-v2-jni.cc")
        public String lastName;
        @UsedByNative("barhopper-v2-jni.cc")
        public String licenseNumber;
        @UsedByNative("barhopper-v2-jni.cc")
        public String middleName;

        @UsedByNative("barhopper-v2-jni.cc")
        public DriverLicense() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.documentType);
            parcel.writeString(this.firstName);
            parcel.writeString(this.middleName);
            parcel.writeString(this.lastName);
            parcel.writeString(this.gender);
            parcel.writeString(this.addressStreet);
            parcel.writeString(this.addressCity);
            parcel.writeString(this.addressState);
            parcel.writeString(this.addressZip);
            parcel.writeString(this.licenseNumber);
            parcel.writeString(this.issueDate);
            parcel.writeString(this.expiryDate);
            parcel.writeString(this.birthDate);
            parcel.writeString(this.issuingCountry);
        }

        private DriverLicense(Parcel parcel) {
            this.documentType = parcel.readString();
            this.firstName = parcel.readString();
            this.middleName = parcel.readString();
            this.lastName = parcel.readString();
            this.gender = parcel.readString();
            this.addressStreet = parcel.readString();
            this.addressCity = parcel.readString();
            this.addressState = parcel.readString();
            this.addressZip = parcel.readString();
            this.licenseNumber = parcel.readString();
            this.issueDate = parcel.readString();
            this.expiryDate = parcel.readString();
            this.birthDate = parcel.readString();
            this.issuingCountry = parcel.readString();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public /* synthetic */ DriverLicense(Parcel parcel, a aVar) {
            this(parcel);
        }
    }

    /* compiled from: com.google.mlkit:barcode-scanning@@16.0.1 */
    @UsedByNative("barhopper-v2-jni.cc")
    /* loaded from: classes2.dex */
    public static class Email implements Parcelable {
        public static final Parcelable.Creator<Email> CREATOR = new g();
        @UsedByNative("barhopper-v2-jni.cc")
        public String address;
        @UsedByNative("barhopper-v2-jni.cc")
        public String body;
        @UsedByNative("barhopper-v2-jni.cc")
        public String subject;
        @UsedByNative("barhopper-v2-jni.cc")
        public int type;

        @UsedByNative("barhopper-v2-jni.cc")
        public Email() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.type);
            parcel.writeString(this.address);
            parcel.writeString(this.subject);
            parcel.writeString(this.body);
        }

        private Email(Parcel parcel) {
            this.type = parcel.readInt();
            this.address = parcel.readString();
            this.subject = parcel.readString();
            this.body = parcel.readString();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public /* synthetic */ Email(Parcel parcel, a aVar) {
            this(parcel);
        }
    }

    /* compiled from: com.google.mlkit:barcode-scanning@@16.0.1 */
    @UsedByNative("barhopper-v2-jni.cc")
    /* loaded from: classes2.dex */
    public static class FlightSegment implements Parcelable {
        public static final Parcelable.Creator<FlightSegment> CREATOR = new h();
        @UsedByNative("barhopper-v2-jni.cc")
        public String carrier;
        @UsedByNative("barhopper-v2-jni.cc")
        public String compartmentCode;
        @UsedByNative("barhopper-v2-jni.cc")
        public String dateOfFlightJulian;
        @UsedByNative("barhopper-v2-jni.cc")
        public String destination;
        @UsedByNative("barhopper-v2-jni.cc")
        public String flightNumber;
        @UsedByNative("barhopper-v2-jni.cc")
        public String origin;
        @UsedByNative("barhopper-v2-jni.cc")
        public String pnrCode;
        @UsedByNative("barhopper-v2-jni.cc")
        public String seatNumber;
        @UsedByNative("barhopper-v2-jni.cc")
        public String selecteeIndicator;

        @UsedByNative("barhopper-v2-jni.cc")
        public FlightSegment() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.pnrCode);
            parcel.writeString(this.origin);
            parcel.writeString(this.destination);
            parcel.writeString(this.carrier);
            parcel.writeString(this.flightNumber);
            parcel.writeString(this.dateOfFlightJulian);
            parcel.writeString(this.compartmentCode);
            parcel.writeString(this.seatNumber);
            parcel.writeString(this.selecteeIndicator);
        }

        private FlightSegment(Parcel parcel) {
            this.pnrCode = parcel.readString();
            this.origin = parcel.readString();
            this.destination = parcel.readString();
            this.carrier = parcel.readString();
            this.flightNumber = parcel.readString();
            this.dateOfFlightJulian = parcel.readString();
            this.compartmentCode = parcel.readString();
            this.seatNumber = parcel.readString();
            this.selecteeIndicator = parcel.readString();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public /* synthetic */ FlightSegment(Parcel parcel, a aVar) {
            this(parcel);
        }
    }

    /* compiled from: com.google.mlkit:barcode-scanning@@16.0.1 */
    @UsedByNative("barhopper-v2-jni.cc")
    /* loaded from: classes2.dex */
    public static class GeoPoint implements Parcelable {
        public static final Parcelable.Creator<GeoPoint> CREATOR = new i();
        @UsedByNative("barhopper-v2-jni.cc")
        public double lat;
        @UsedByNative("barhopper-v2-jni.cc")
        public double lng;

        @UsedByNative("barhopper-v2-jni.cc")
        public GeoPoint() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeDouble(this.lat);
            parcel.writeDouble(this.lng);
        }

        private GeoPoint(Parcel parcel) {
            this.lat = parcel.readDouble();
            this.lng = parcel.readDouble();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public /* synthetic */ GeoPoint(Parcel parcel, a aVar) {
            this(parcel);
        }
    }

    /* compiled from: com.google.mlkit:barcode-scanning@@16.0.1 */
    @UsedByNative("barhopper-v2-jni.cc")
    /* loaded from: classes2.dex */
    public static class PersonName implements Parcelable {
        public static final Parcelable.Creator<PersonName> CREATOR = new j();
        @UsedByNative("barhopper-v2-jni.cc")
        public String first;
        @UsedByNative("barhopper-v2-jni.cc")
        public String formattedName;
        @UsedByNative("barhopper-v2-jni.cc")
        public String last;
        @UsedByNative("barhopper-v2-jni.cc")
        public String middle;
        @UsedByNative("barhopper-v2-jni.cc")
        public String prefix;
        @UsedByNative("barhopper-v2-jni.cc")
        public String pronunciation;
        @UsedByNative("barhopper-v2-jni.cc")
        public String suffix;

        @UsedByNative("barhopper-v2-jni.cc")
        public PersonName() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.formattedName);
            parcel.writeString(this.pronunciation);
            parcel.writeString(this.prefix);
            parcel.writeString(this.first);
            parcel.writeString(this.middle);
            parcel.writeString(this.last);
            parcel.writeString(this.suffix);
        }

        private PersonName(Parcel parcel) {
            this.formattedName = parcel.readString();
            this.pronunciation = parcel.readString();
            this.prefix = parcel.readString();
            this.first = parcel.readString();
            this.middle = parcel.readString();
            this.last = parcel.readString();
            this.suffix = parcel.readString();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public /* synthetic */ PersonName(Parcel parcel, a aVar) {
            this(parcel);
        }
    }

    /* compiled from: com.google.mlkit:barcode-scanning@@16.0.1 */
    @UsedByNative("barhopper-v2-jni.cc")
    /* loaded from: classes2.dex */
    public static class Phone implements Parcelable {
        public static final Parcelable.Creator<Phone> CREATOR = new k();
        @UsedByNative("barhopper-v2-jni.cc")
        public String number;
        @UsedByNative("barhopper-v2-jni.cc")
        public int type;

        @UsedByNative("barhopper-v2-jni.cc")
        public Phone() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.type);
            parcel.writeString(this.number);
        }

        private Phone(Parcel parcel) {
            this.type = parcel.readInt();
            this.number = parcel.readString();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public /* synthetic */ Phone(Parcel parcel, a aVar) {
            this(parcel);
        }
    }

    /* compiled from: com.google.mlkit:barcode-scanning@@16.0.1 */
    @UsedByNative("barhopper-v2-jni.cc")
    /* loaded from: classes2.dex */
    public static class Sms implements Parcelable {
        public static final Parcelable.Creator<Sms> CREATOR = new l();
        @UsedByNative("barhopper-v2-jni.cc")
        public String message;
        @UsedByNative("barhopper-v2-jni.cc")
        public String phoneNumber;

        @UsedByNative("barhopper-v2-jni.cc")
        public Sms() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.message);
            parcel.writeString(this.phoneNumber);
        }

        private Sms(Parcel parcel) {
            this.message = parcel.readString();
            this.phoneNumber = parcel.readString();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public /* synthetic */ Sms(Parcel parcel, a aVar) {
            this(parcel);
        }
    }

    /* compiled from: com.google.mlkit:barcode-scanning@@16.0.1 */
    @UsedByNative("barhopper-v2-jni.cc")
    /* loaded from: classes2.dex */
    public static class UrlBookmark implements Parcelable {
        public static final Parcelable.Creator<UrlBookmark> CREATOR = new m();
        @UsedByNative("barhopper-v2-jni.cc")
        public String title;
        @UsedByNative("barhopper-v2-jni.cc")
        public String url;

        @UsedByNative("barhopper-v2-jni.cc")
        public UrlBookmark() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.title);
            parcel.writeString(this.url);
        }

        private UrlBookmark(Parcel parcel) {
            this.title = parcel.readString();
            this.url = parcel.readString();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public /* synthetic */ UrlBookmark(Parcel parcel, a aVar) {
            this(parcel);
        }
    }

    /* compiled from: com.google.mlkit:barcode-scanning@@16.0.1 */
    @UsedByNative("barhopper-v2-jni.cc")
    /* loaded from: classes2.dex */
    public static class WiFi implements Parcelable {
        public static final Parcelable.Creator<WiFi> CREATOR = new n();
        @UsedByNative("barhopper-v2-jni.cc")
        public int encryptionType;
        @UsedByNative("barhopper-v2-jni.cc")
        public boolean isHidden;
        @UsedByNative("barhopper-v2-jni.cc")
        public String password;
        @UsedByNative("barhopper-v2-jni.cc")
        public String ssid;

        @UsedByNative("barhopper-v2-jni.cc")
        public WiFi() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.ssid);
            parcel.writeString(this.password);
            parcel.writeInt(this.encryptionType);
            parcel.writeByte(this.isHidden ? (byte) 1 : (byte) 0);
        }

        private WiFi(Parcel parcel) {
            this.ssid = parcel.readString();
            this.password = parcel.readString();
            this.encryptionType = parcel.readInt();
            this.isHidden = parcel.readByte() != 0;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public /* synthetic */ WiFi(Parcel parcel, a aVar) {
            this(parcel);
        }
    }

    /* compiled from: com.google.mlkit:barcode-scanning@@16.0.1 */
    /* loaded from: classes2.dex */
    class a implements Parcelable.Creator<Barcode> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        public /* synthetic */ Barcode createFromParcel(Parcel parcel) {
            return new Barcode(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        public /* synthetic */ Barcode[] newArray(int i) {
            return new Barcode[i];
        }
    }

    @UsedByNative("barhopper-v2-jni.cc")
    public Barcode() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.format);
        parcel.writeString(this.rawValue);
        parcel.writeString(this.displayValue);
        parcel.writeInt(this.valueFormat);
        parcel.writeTypedArray(this.cornerPoints, 0);
        parcel.writeParcelable(this.email, 0);
        parcel.writeParcelable(this.phone, 0);
        parcel.writeParcelable(this.sms, 0);
        parcel.writeParcelable(this.wifi, 0);
        parcel.writeParcelable(this.url, 0);
        parcel.writeParcelable(this.geoPoint, 0);
        parcel.writeParcelable(this.calendarEvent, 0);
        parcel.writeParcelable(this.contactInfo, 0);
        parcel.writeParcelable(this.driverLicense, 0);
        parcel.writeParcelable(this.boardingPass, 0);
    }

    private Barcode(Parcel parcel) {
        this.format = parcel.readInt();
        this.rawValue = parcel.readString();
        this.displayValue = parcel.readString();
        this.valueFormat = parcel.readInt();
        this.cornerPoints = (Point[]) parcel.createTypedArray(Point.CREATOR);
        this.email = (Email) parcel.readParcelable(Email.class.getClassLoader());
        this.phone = (Phone) parcel.readParcelable(Phone.class.getClassLoader());
        this.sms = (Sms) parcel.readParcelable(Sms.class.getClassLoader());
        this.wifi = (WiFi) parcel.readParcelable(WiFi.class.getClassLoader());
        this.url = (UrlBookmark) parcel.readParcelable(UrlBookmark.class.getClassLoader());
        this.geoPoint = (GeoPoint) parcel.readParcelable(GeoPoint.class.getClassLoader());
        this.calendarEvent = (CalendarEvent) parcel.readParcelable(CalendarEvent.class.getClassLoader());
        this.contactInfo = (ContactInfo) parcel.readParcelable(ContactInfo.class.getClassLoader());
        this.driverLicense = (DriverLicense) parcel.readParcelable(DriverLicense.class.getClassLoader());
        this.boardingPass = (BoardingPass) parcel.readParcelable(BoardingPass.class.getClassLoader());
    }

    /* synthetic */ Barcode(Parcel parcel, a aVar) {
        this(parcel);
    }
}
