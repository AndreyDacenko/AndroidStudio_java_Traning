package com.example.olympclub.data;

import android.provider.BaseColumns;

public final class ClubOlympContract {

    private ClubOlympContract(){

    }

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "olympus";


    public static final class MemberEntry implements BaseColumns {
        public static final String TABLE_NAME = "members";

        public static final String ID = BaseColumns._ID;
        public static final String KEY_FIRST_NAME = "firstName";
        public static final String KEY_LAST_NAME = "lastName";
        public static final String KEY_GENDER = "gender";
        public static final String KEY_SPORT = "sport";

        public static final int GENDER_UNKNOWN = 0;
        public static final int GENDER_MALE = 1;
        public static final int GENDER_FEMALE = 2;

    }
}
