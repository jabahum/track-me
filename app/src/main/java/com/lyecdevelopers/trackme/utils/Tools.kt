package com.lyecdevelopers.puregrow.utils/*
package com.lyecdevelopers.puregrow.utils

import android.app.Activity
import android.app.Dialog
import android.content.*
import android.content.pm.PackageInfo
import android.content.pm.PackageManager
import android.content.res.Resources
import android.graphics.Color
import android.graphics.PorterDuff
import android.graphics.drawable.Drawable
import android.net.Uri
import android.os.Build
import android.provider.Settings
import android.util.TypedValue
import android.view.Menu
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.webkit.URLUtil
import android.widget.ImageView
import android.widget.Toast
import androidx.annotation.ColorInt
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import androidx.core.widget.NestedScrollView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.google.android.gms.maps.GoogleMap
import com.google.android.material.bottomappbar.BottomAppBar
import com.lyecdevelopers.puregrow.R
import com.lyecdevelopers.trackme.data.remote.model.main.DeviceInfo
import timber.log.Timber
import java.net.URI
import java.net.URISyntaxException
import java.text.SimpleDateFormat
import java.util.*
import kotlin.math.roundToInt

object Tools {
    fun setSystemBarColor(act: Activity) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            val window: Window = act.window
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            window.statusBarColor = act.resources.getColor(R.color.colorPrimaryDark)
        }
    }

    fun setSystemBarColor(act: Activity, @ColorRes color: Int) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            val window: Window = act.window
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            window.statusBarColor = act.resources.getColor(color)
        }
    }

    fun setSystemBarColorInt(act: Activity, @ColorInt color: Int) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            val window: Window = act.window
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            window.statusBarColor = color
        }
    }

    fun setSystemBarColorDialog(act: Context, dialog: Dialog, @ColorRes color: Int) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            val window = dialog.window
            window!!.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            window.statusBarColor = act.resources.getColor(color)
        }
    }

    fun setSystemBarLight(act: Activity) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            val view: View = act.findViewById<View>(R.id.content)
            val flags = view.systemUiVisibility or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
            view.systemUiVisibility = flags
        }
    }

    fun setSystemBarDark(act: Activity) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            val view: View = act.findViewById<View>(R.id.content)
            val flags = view.systemUiVisibility and View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR.inv()
            view.systemUiVisibility = flags
        }
    }

    fun setSystemBarLightDialog(dialog: Dialog) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            val view = dialog.findViewById<View>(R.id.content)
            var flags = view.systemUiVisibility
            flags = flags or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
            view.systemUiVisibility = flags
        }
    }

    fun clearSystemBarLight(act: Activity) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            val window: Window = act.window
            window.statusBarColor = ContextCompat.getColor(act, R.color.colorPrimaryDark)
        }
    }

    */
/**
     * Making notification bar transparent
     *//*

    fun setSystemBarTransparent(act: Activity) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            val window: Window = act.window
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.statusBarColor = Color.TRANSPARENT
        }
    }

    fun displayImageOriginal(ctx: Context?, img: ImageView?, @DrawableRes drawable: Int) {
        try {
            if (ctx != null) {
                if (img != null) {
                    Glide.with(ctx).load(drawable)
                        .diskCacheStrategy(DiskCacheStrategy.NONE)
                        .into(img)
                }
            }
        } catch (e: Exception) {
        }
    }

    */
/*fun displayImageRound(ctx: Context, img: ImageView, @DrawableRes drawable: Int) {
        try {
            Glide.with(ctx).load(drawable).centerCrop()
                .into(object : BitmapImageViewTarget(img) {
                    protected override fun setResource(resource: Bitmap?) {
                        val circularBitmapDrawable: RoundedBitmapDrawable =
                            RoundedBitmapDrawableFactory.create(ctx.resources, resource)
                        circularBitmapDrawable.setCircular(true)
                        img.setImageDrawable(circularBitmapDrawable)
                    }
                })
        } catch (e: Exception) {
        }
    }*//*


    fun displayImageOriginal(ctx: Context?, img: ImageView?, url: String?) {
        try {
            if (ctx != null) {
                if (img != null) {
                    Glide.with(ctx).load(url)
                        .diskCacheStrategy(DiskCacheStrategy.NONE)
                        .into(img)
                }
            }
        } catch (e: Exception) {
        }
    }

    fun getFormattedDateShort(dateTime: Long?): String {
        val newFormat = SimpleDateFormat("MMM dd, yyyy")
        return newFormat.format(Date(dateTime!!))
    }

    fun getFormattedDateSimple(dateTime: Long?): String {
        val newFormat = SimpleDateFormat("MMMM dd, yyyy")
        return newFormat.format(Date(dateTime!!))
    }

    fun getFormattedDateEvent(dateTime: Long?): String {
        val newFormat = SimpleDateFormat("EEE, MMM dd yyyy")
        return newFormat.format(Date(dateTime!!))
    }

    fun getFormattedTimeEvent(time: Long?): String {
        val newFormat = SimpleDateFormat("h:mm a")
        return newFormat.format(Date(time!!))
    }

    fun getEmailFromName(name: String?): String? {
        return if (name != null && name != "") {
            name.replace(" ".toRegex(), ".").lowercase(Locale.getDefault()) + "@mail.com"
        } else name
    }

    fun dpToPx(c: Context, dp: Int): Int {
        val r = c.resources
        return TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP,
            dp.toFloat(),
            r.displayMetrics
        ).roundToInt().toInt()
    }

    fun configActivityMaps(googleMap: GoogleMap): GoogleMap {
        // set map type
        googleMap.mapType = GoogleMap.MAP_TYPE_NORMAL
        // Enable / Disable zooming controls
        googleMap.uiSettings.isZoomControlsEnabled = false

        // Enable / Disable Compass icon
        googleMap.uiSettings.isCompassEnabled = true
        // Enable / Disable Rotate gesture
        googleMap.uiSettings.isRotateGesturesEnabled = true
        // Enable / Disable zooming functionality
        googleMap.uiSettings.isZoomGesturesEnabled = true
        googleMap.uiSettings.isScrollGesturesEnabled = true
        googleMap.uiSettings.isMapToolbarEnabled = true
        return googleMap
    }

    fun copyToClipboard(context: Context, data: String?) {
        val clipboard = context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
        val clip: ClipData = ClipData.newPlainText("clipboard", data)
        clipboard.setPrimaryClip(clip)
        Toast.makeText(context, "Text copied to clipboard", Toast.LENGTH_SHORT).show()
    }

    fun nestedScrollTo(nested: NestedScrollView, targetView: View) {
        nested.post(Runnable { nested.scrollTo(500, targetView.bottom) })
    }

    fun dip2px(context: Context, dpValue: Float): Int {
        val scale = context.resources.displayMetrics.density
        return (dpValue * scale + 0.5f).toInt()
    }

    fun px2dip(context: Context, pxValue: Float): Int {
        val scale = context.resources.displayMetrics.density
        return (pxValue / scale + 0.5f).toInt()
    }

    fun toggleArrow(view: View): Boolean {
        return if (view.rotation == 0f) {
            view.animate().setDuration(200).rotation(180f)
            true
        } else {
            view.animate().setDuration(200).rotation(0f)
            false
        }
    }

    @JvmOverloads
    fun toggleArrow(show: Boolean, view: View, delay: Boolean = true): Boolean {
        return if (show) {
            view.animate().setDuration(if (delay) 200 else 0.toLong()).rotation(180f)
            true
        } else {
            view.animate().setDuration(if (delay) 200 else 0.toLong()).rotation(0f)
            false
        }
    }

    fun changeNavigateionIconColor(toolbar: Toolbar, @ColorInt color: Int) {
        val drawable = toolbar.navigationIcon
        drawable?.mutate()
        drawable?.setColorFilter(color, PorterDuff.Mode.SRC_ATOP)
    }

    fun changeMenuIconColor(menu: Menu, @ColorInt color: Int) {
        for (i in 0 until menu.size()) {
            val drawable = menu.getItem(i).icon ?: continue
            drawable.mutate()
            drawable.setColorFilter(color, PorterDuff.Mode.SRC_ATOP)
        }
    }

    fun changeOverflowMenuIconColor(toolbar: Toolbar, @ColorInt color: Int) {
        try {
            val drawable = toolbar.overflowIcon
            drawable?.mutate()
            drawable?.setColorFilter(color, PorterDuff.Mode.SRC_ATOP)
        } catch (e: Exception) {
        }
    }

    fun changeOverflowMenuIconColor(toolbar: BottomAppBar, @ColorInt color: Int) {
        try {
            val drawable: Drawable? = toolbar.overflowIcon
            drawable?.mutate()
            drawable?.setColorFilter(color, PorterDuff.Mode.SRC_ATOP)
        } catch (e: Exception) {
        }
    }

    val screenWidth: Int
        get() = Resources.getSystem().displayMetrics.widthPixels
    val screenHeight: Int
        get() = Resources.getSystem().displayMetrics.heightPixels

    */
/*fun toCamelCase(input: String): String {
        var input = input
        input = input.lowercase(Locale.getDefault())
        val titleCase = StringBuilder()
        var nextTitleCase = true
        for (c in input.toCharArray()) {
            if (Character.isSpaceChar(c)) {
                nextTitleCase = true
            } else if (nextTitleCase) {
                c = Character.toTitleCase(c)
                nextTitleCase = false
            }
            titleCase.append(c)
        }
        return titleCase.toString()
    }*//*


    fun insertPeriodically(text: String, insert: String, period: Int): String {
        val builder = StringBuilder(text.length + insert.length * (text.length / period) + 1)
        var index = 0
        var prefix = ""
        while (index < text.length) {
            builder.append(prefix)
            prefix = insert
            builder.append(text.substring(index, Math.min(index + period, text.length)))
            index += period
        }
        return builder.toString()
    }

    fun rateAction(activity: Activity) {
        val uri = Uri.parse("market://details?id=" + activity.packageName)
        val goToMarket = Intent(Intent.ACTION_VIEW, uri)
        try {
            activity.startActivity(goToMarket)
        } catch (e: ActivityNotFoundException) {
            activity.startActivity(
                Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("http://play.google.com/store/apps/details?id=" + activity.packageName)
                )
            )
        }
    }

    */
/**
     * For device info parameters
     *//*

    val deviceName: String
        get() {
            val manufacturer: String = Build.MANUFACTURER
            val model: String = Build.MODEL
            return if (model.startsWith(manufacturer)) {
                model
            } else {
                "$manufacturer $model"
            }
        }
    val androidVersion: String
        get() = Build.VERSION.RELEASE + ""

    fun getVersionCode(ctx: Context): Int {
        return try {
            val manager: PackageManager = ctx.packageManager
            val info: PackageInfo = manager.getPackageInfo(ctx.packageName, 0)
            info.versionCode
        } catch (e: PackageManager.NameNotFoundException) {
            -1
        }
    }

    fun getVersionName(ctx: Context): String {
        return try {
            val manager: PackageManager = ctx.packageManager
            val info: PackageInfo = manager.getPackageInfo(ctx.packageName, 0)
            ctx.getString(R.string.app_version) + " " + info.versionName
        } catch (e: PackageManager.NameNotFoundException) {
            ctx.getString(R.string.version_unknown)
        }
    }

    fun getVersionNamePlain(ctx: Context): String {
        return try {
            val manager: PackageManager = ctx.packageManager
            val info: PackageInfo = manager.getPackageInfo(ctx.packageName, 0)
            info.versionName
        } catch (e: PackageManager.NameNotFoundException) {
            ctx.getString(R.string.version_unknown)
        }
    }

    fun getDeviceInfo(context: Context): DeviceInfo {
        val deviceInfo = DeviceInfo()
        deviceInfo.device = deviceName
        deviceInfo.os_version = androidVersion
        deviceInfo.app_version =
            getVersionCode(context).toString() + " (" + getVersionNamePlain(context) + ")"
        deviceInfo.serial = getDeviceID(context)
        return deviceInfo
    }

    fun getDeviceID(context: Context): String {
        var deviceID: String = Build.SERIAL
        if (deviceID == null || deviceID.trim { it <= ' ' }.isEmpty() || deviceID == "unknown") {
            try {
                deviceID =
                    Settings.Secure.getString(context.contentResolver, Settings.Secure.ANDROID_ID)
            } catch (e: Exception) {
            }
        }
        return deviceID
    }

    fun getFormattedDateOnly(dateTime: Long?): String {
        val newFormat = SimpleDateFormat("dd MMM yy")
        return newFormat.format(Date(dateTime!!))
    }

    fun directLinkToBrowser(activity: Activity, url: String?) {
        try {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            activity.startActivity(intent)
        } catch (e: Exception) {
            Toast.makeText(activity, "Ops, Cannot open url", Toast.LENGTH_LONG).show()
        }
    }

    private fun appendQuery(uri: String, appendQuery: String): String {
        return try {
            val oldUri = URI(uri)
            var newQuery = oldUri.query
            if (newQuery == null) {
                newQuery = appendQuery
            } else {
                newQuery += "&$appendQuery"
            }
            val newUri = URI(
                oldUri.scheme,
                oldUri.authority,
                oldUri.path, newQuery, oldUri.fragment
            )
            newUri.toString()
        } catch (e: Exception) {
            e.printStackTrace()
            uri
        }
    }

    fun openInAppBrowser(activity: Activity?, url: String, from_notif: Boolean) {
        var url = url
        url = appendQuery(url, "t=" + System.currentTimeMillis())
        if (!URLUtil.isValidUrl(url)) {
            Toast.makeText(activity, "Ops, Cannot open url", Toast.LENGTH_LONG).show()
            return
        }
    }

    fun getHostName(url: String): String {
        return try {
            val uri = URI(url)
            var new_url = uri.host
            if (!new_url.startsWith("www.")) new_url = "www.$new_url"
            new_url
        } catch (e: URISyntaxException) {
            if (e.message != null) {
                Timber.e(e.message!!)
            }
            url
        }
    }
}*/
