# Add project specific ProGuard rules here.
# By default, the flags in this file are appended to flags specified
# in /usr/local/Cellar/android-sdk/24.3.3/tools/proguard/proguard-android.txt
# You can edit the include path and order by changing the proguardFiles
# directive in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# Add any project specific keep options here:

# Keep your package classes

# Retrofit
-keepattributes Signature
-keepattributes *Annotation*
-keep class retrofit2.** { *; }
-keepclasseswithmembers class * {
    @retrofit2.http.* <methods>;
}
-keepclassmembers,allowshrinking,allowobfuscation interface * {
    @retrofit2.http.* <methods>;
}


# Retrofit Rules
-keep class retrofit2.** { *; }
-keepattributes Signature
-keepattributes Exceptions
-keepclasseswithmembers class * {
    @retrofit2.http.* <methods>;
}
-keepnames class retrofit2.** { *; }

# OkHttp Rules
-keepnames class okhttp3.** { *; }
-keepnames interface okhttp3.** { *; }
-dontwarn okhttp3.**
-dontwarn okio.**
-keep class okio.** { *; }
-keep interface okio.** { *; }

# Gson Rules
-keep class com.google.gson.** { *; }
-keepattributes *Annotation*
-dontwarn sun.misc.**
-keep class * implements com.google.gson.TypeAdapterFactory
-keep class * implements com.google.gson.JsonSerializer
-keep class * implements com.google.gson.JsonDeserializer
-keepclassmembers,allowobfuscation class * {
    @com.google.gson.annotations.SerializedName <fields>;
}

# RxJava Rules
-keep class rx.** { *; }
-keep interface rx.** { *; }
-dontwarn rx.**
-keepclassmembers class rx.internal.util.unsafe.*ArrayQueue*Field* {
    long producerIndex;
    long consumerIndex;
}

# Keep PaySwiff SDK
-keep class com.pnsol.sdk.** { *; }
-keep class ps.module.** { *; }
-keep class ps.sdk.** { *; }

-keepclassmembers class com.pnsol.sdk.** { *; }
-keepclassmembers class ps.module.** { *; }
-keepclassmembers class ps.sdk.** { *; }



# Keep all model classes used by Retrofit/Gson
-keep class ps.module.network.** { *; }
-keep class ps.sdk.mpay.** { *; }

# Jackson
-keep class org.codehaus.** { *; }
-keepnames class com.fasterxml.jackson.** { *; }
-keepnames interface com.fasterxml.jackson.** { *; }
-dontwarn org.codehaus.jackson.**
-keep class com.pnsol.** { *; }


# Jackson rules
-keep class org.codehaus.** { *; }
-keepclassmembers class * {
    @org.codehaus.jackson.annotate.* *;
}
-dontwarn org.codehaus.jackson.**
