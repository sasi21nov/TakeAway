package com.example.takeaway;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Environment;

import java.io.File;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class CommonsUtils {
	private static final String TAG = "CommonsUtils";

	public static SharedPreferences getPreferences(Context context) {
		return context.getSharedPreferences("pref.sasi.takeaway",
				Context.MODE_PRIVATE);
	}

	public static String getPrefString(Context context, String key) {
		SharedPreferences prefs = getPreferences(context);
		String value = prefs.getString(key, null);
		return value;
	}

	public static Set<String> getPrefStringSet(Context context, String key) {
		SharedPreferences prefs = getPreferences(context);
		HashSet<String> value = (HashSet<String>) prefs.getStringSet(key, null);

		return value;
	}

	public static Boolean getPrefBoolean(Context context, String key) {
		SharedPreferences prefs = getPreferences(context);
		Boolean value = prefs.getBoolean(key, false);
		return value;
	}

	public static int getPrefInt(Context context, String key) {
		SharedPreferences prefs = getPreferences(context);
		int value = prefs.getInt(key, 0);
		return value;
	}
	
	public static float getPrefFloat(Context context, String key) {
		SharedPreferences prefs = getPreferences(context);
		float value = prefs.getFloat(key, (float)0);
		return value;
	}
	

	public static void putPrefInt(Context context, int element, String key) {
		SharedPreferences prefs = getPreferences(context);
		SharedPreferences.Editor editor = prefs.edit();

		editor.putInt(key, element);

		editor.commit();
	}
	
	public static void putPrefFloat(Context context, float element, String key) {
		SharedPreferences prefs = getPreferences(context);
		SharedPreferences.Editor editor = prefs.edit();

		editor.putFloat(key, element);

		editor.commit();
	}

	public static void putPrefStrings(Context context, Map<String, String> map) {
		SharedPreferences prefs = getPreferences(context);
		SharedPreferences.Editor editor = prefs.edit();
		Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
		while (iterator.hasNext()) {
			Map.Entry<String, String> pair = (Map.Entry<String, String>) iterator.next();
			editor.putString((String) pair.getKey(), (String) pair.getValue());
		}
		editor.commit();
	}
	public static void putPrefString(Context context, String text,String pairkey) {
		SharedPreferences prefs = getPreferences(context);
		SharedPreferences.Editor editor = prefs.edit();

		editor.putString((String) pairkey, text);

		editor.commit();
	}

	public static void putPrefStringset(Context context, HashSet<String> map,String pairkey) {
		SharedPreferences prefs = getPreferences(context);
		SharedPreferences.Editor editor = prefs.edit();

		editor.putStringSet((String) pairkey, map);

		editor.commit();
	}

	public static void putPrefBooleans(Context context, Boolean map, String key) {
		SharedPreferences prefs = getPreferences(context);
		SharedPreferences.Editor editor = prefs.edit();
		
			editor.putBoolean(key, map);
		
		editor.commit();
	}
	

	public static boolean isExternalStorageWritable() {
		String state = Environment.getExternalStorageState();
		if (Environment.MEDIA_MOUNTED.equals(state)) {
			return true;
		}
		return false;
	}

	public static boolean isExternalStorageReadable() {
		String state = Environment.getExternalStorageState();
		if (Environment.MEDIA_MOUNTED.equals(state)
				|| Environment.MEDIA_MOUNTED_READ_ONLY.equals(state)) {
			return true;
		}
		return false;
	}

	public static File getStorageDir(String dirName) {
		File file = new File(Environment.getExternalStorageDirectory(), dirName);
		if (!file.mkdirs()) {
		}
		return file;
	}

}
