package com.github.trueddd.handy.core

import android.content.Context
import android.os.Environment
import android.os.StatFs
import java.io.File

/**
 * Calculates available space on external storage on given [dir].
 * If [dir] is not passed, calculates available space on root of external storage.
 * @param dir
 *        Directory to calculate available space in
 * @param measure
 *        Determines desired measurement of returning value, default is bytes ([MemoryMeasure])
 * @return available space on given [dir] or 0 if given [dir] is null, is not a directory or external storage is not mounted
 */
fun Context.getAvailableExternalSpace(dir: File? = getExternalFilesDir(null), measure: MemoryMeasure = MemoryMeasure.B): Long {
    return try {
        if (dir == null || !dir.isDirectory) {
            return 0L
        }
        val bytes = if (Environment.getExternalStorageState() == Environment.MEDIA_MOUNTED) {
            val stat = StatFs(dir.path)
            stat.availableBlocksLong * stat.blockSizeLong
        } else 0L
        return bytes / measure.times
    } catch (e: Exception) {
        e.printStackTrace()
        0L
    }
}

/**
 * Calculates total space on external storage on given [dir].
 * If [dir] is not passed, calculates total space on root of external storage.
 * @param dir
 *        Directory to calculate total space in
 * @param measure
 *        Determines desired measurement of returning value, default is bytes ([MemoryMeasure])
 * @return total space on given [dir] or 0 if given [dir] is null, is not a directory or external storage is not mounted
 */
fun Context.getTotalExternalSpace(dir: File? = getExternalFilesDir(null), measure: MemoryMeasure = MemoryMeasure.B): Long {
    return try {
        if (dir == null || !dir.isDirectory) {
            return 0L
        }
        val bytes = if (Environment.getExternalStorageState() == Environment.MEDIA_MOUNTED) {
            val stat = StatFs(dir.path)
            stat.blockCountLong * stat.blockSizeLong
        } else 0L
        return bytes / measure.times
    } catch (e: Exception) {
        e.printStackTrace()
        0L
    }
}

sealed class MemoryMeasure(val times: Long) {
    object B : MemoryMeasure(1L)
    object KB : MemoryMeasure(1024L)
    object MB : MemoryMeasure(1024L * 1024)
    object GB : MemoryMeasure(1024L * 1024 * 1024)
    object TB : MemoryMeasure(1024L * 1024 * 1024 * 1024)
}