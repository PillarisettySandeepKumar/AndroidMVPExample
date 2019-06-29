package com.example.mvploginexample.login.util;

import android.content.Context;
import android.content.SharedPreferences;

import com.amazonaws.mobileconnectors.cognitoidentityprovider.tokens.CognitoIdToken;
import com.google.gson.Gson;

import mobilesolution.example.tipp.network.AppController;

//This class is used to store data in shared preference
public class AppSettings {

    //Required to store objects in Shared Preference
    public static Gson gson = new Gson();

    public static final String PREFERENCE_USER = "tipp_passenger_pref";

    public static final String AUTHENTICATION = "AUTHENTICATION";
    public static final String APPLICATIONKEY = "APPLICATIONKEY";
    public static final String TCID = "Tcid";

    public static final String FNAME="Fname";

    public static final String LNAME="Lname";

    public static final String MOBILENO="MobileNo";

    public static final String EMAILID="Email";

    public static final String CP_RATING="CP_RATING";

    public static final String PROFILE_PIC="PROFILE_PIC";

    public static  final String DEVICE_ID="DeviceId";

    public static  final String ENDPOINT_ARN="endPointArn";

    public static  final String PICKLAT="Picklat";

    public static  final String PICKLNG="Picklng";

    public static  final String BOOKINGNUM="BookingNum";

    public static  final String PICKLOCATION="PickLocation";

    public static  final String DROPLOCATION="DropLocation";

    public static  final String CAB_TYPE="CabType";

    public static  final String PICKUPDATE="PickupDate";

    public static  final String TRIPID="TripId";

    public static  final String BOOKINGID="BookingID";

    public static final String DROPLAT="DropLat";

    public static final String DROPLON="DropLon";

    public static  final  String DRIVERNAME="DriverName";

    public static  final  String DRIVERMOBILE="DriverMobile";
    public static  final  String DRIVERIMG="DriverImg";

    public static  final  String ISBACKGROUND="isbackground";

    public static  final  String NOTIFICATIONTYPE="NotificationType";

    public static  final  String BOOKINGTYPE="BookingType";

    public static  final  String DRIVERCONFIRMDETAILS="DriverConfirmDetails";

    public static  final  String DRIVERFARE="DriverFare";
    public static  final  String TRIPSTATUS="TripStatus";
    public static  final  String RATINGSTATUS="RatingStatus";
    public static  final  String DRID="Drid";

    public static  final  String FIRSTLAUNCH="FirstLaunch";
    public static  final  String PAYMENTTYPE="PaymentType";
    public static  final  String PAYMENTDETAILS="PaymentDetails";

    public static  final String CARDNUMBER="CardNumber";
    public static  final String CARDMONTH="CardMonth";
    public static  final String CARDYEAR="CardYear";
    public static  final String CARDNAME="CardName";
    public static  final String CARDTOKEN="CardToken";
    public static  final String CARDTYPE="CardType";
    public static  final String INVITECODE="InviteCode";
    public static  final String INVITEPOINTS="InvitePoints";

    public static  final String IDTOKEN="IDToken";
    public static  final String ACCESSTOKEN="AccessToken";
    public static  final String REFRESHTOKEN="RefreshToken";
    public static  final String MOBILEUPDATE="MobileUpdate";
    public static  final String AUTHENTICATIONTYPE="AuthenticationType";

    private static SharedPreferences getPrefs(String type) {
        return AppController.getInstance().getSharedPreferences(type, Context.MODE_PRIVATE);
    }

    public static void saveInt(String prefType, String type, int value) {
        getPrefs(prefType).edit().putInt(type, value).commit();

    }

    public static void saveString(String prefType, String type, String value) {
        getPrefs(prefType).edit().putString(type, value).commit();
    }


    public static void saveBoolean(String prefType, String type, boolean value) {
        getPrefs(prefType).edit().putBoolean(type, value).commit();
    }

    public static int getInt(String prefType, String type) {
        return getPrefs(prefType).getInt(type, 0);
    }

    public static String getString(String prefType, String type) {
        return getPrefs(prefType).getString(type, "");
    }

    public static boolean getBoolean(String prefType, String type) {
        return getPrefs(prefType).getBoolean(type, false);
    }

    public static void clearData(String prefType) {
        getPrefs(prefType).edit().clear().commit();
    }

}
