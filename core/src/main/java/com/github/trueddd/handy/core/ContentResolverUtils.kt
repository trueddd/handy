package com.github.trueddd.handy.core

import android.content.ContentUris
import android.content.Context
import android.database.Cursor
import android.net.Uri
import android.os.Environment
import android.provider.DocumentsContract
import android.provider.MediaStore
import java.io.File
import java.io.InputStream

fun Context.getFileInputStreamByUri(uri: Uri): InputStream? {
    return contentResolver?.openInputStream(uri)
}

/**
 * Returns temporary file with content of file with given [uri].
 * Be careful with this function on returning large files, because
 * this function returns NEW temporary file.
 */
fun Context.getFileByUri(uri: Uri): File? {
    val tempFile = File.createTempFile("temp_${this.hashCode()}_${uri.hashCode()}", null)
    return tempFile.also {
        getFileInputStreamByUri(uri)?.toFile(it)
    }
}

/**
 * Copies given [InputStream] to [target] file
 */
fun InputStream.toFile(target: File) {
    target.outputStream().use {
        this.copyTo(it)
    }
}

fun Context.getFileAbsolutePath(uri: Uri): String? {
    return getFileByUri(uri)?.absolutePath
}

@Deprecated(
        level = DeprecationLevel.WARNING,
        message = "This function may return null or empty file on some devices",
        replaceWith = ReplaceWith("getFileAbsolutePath(uri)", "com.github.trueddd.handy.core.getFileAbsolutePath")
        )
fun Context.getFileRealPath(uri: Uri): String? {
    if (DocumentsContract.isDocumentUri(this, uri)) {
        if (isExternalStorageDocument(uri)) {
            val docId = DocumentsContract.getDocumentId(uri)
            val split = docId.split(":".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
            val type = split[0]

            if ("primary".equals(type, ignoreCase = true)) {
                return getExternalFilesDir(null)?.toString()?.plus("/${split[1]}")
            }
        } else if (isDownloadsDocument(uri)) {
            val fileName = getFilePath(this, uri)
            if (fileName != null) {
                return Environment.getExternalStorageDirectory().toString() + "/Download/" + fileName
            }

            var id = DocumentsContract.getDocumentId(uri)
            if (id != null && id.startsWith("raw:")) {
                id = id.replaceFirst("raw:".toRegex(), "")
                if (File(id).exists()) return id
            }

            val contentUri = ContentUris.withAppendedId(
                Uri.parse("content://downloads/public_downloads"), java.lang.Long.valueOf(id)
            )

            return getDataColumn(this, contentUri, null, null)
        } else if (isMediaDocument(uri)) {
            val docId = DocumentsContract.getDocumentId(uri)
            val split = docId.split(":".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()

            val contentUri: Uri? = when (split[0]) {
                "image" -> MediaStore.Images.Media.EXTERNAL_CONTENT_URI
                "video" -> MediaStore.Video.Media.EXTERNAL_CONTENT_URI
                "audio" -> MediaStore.Audio.Media.EXTERNAL_CONTENT_URI
                else -> null
            }

            val selection = "_id=?"
            val selectionArgs = arrayOf(split[1])

            return getDataColumn(this, contentUri, selection, selectionArgs)
        }
    } else if ("content".equals(uri.scheme, ignoreCase = true)) {
        return if (isGooglePhotosUri(uri)) uri.lastPathSegment else getDataColumn(this, uri, null, null)
    } else if ("file".equals(uri.scheme, ignoreCase = true)) {
        return uri.path
    }
    return null
}

private fun getFilePath(context: Context, uri: Uri?): String? {
    var cursor: Cursor? = null
    val projection = arrayOf(MediaStore.MediaColumns.DISPLAY_NAME)
    try {
        cursor = context.contentResolver.query(uri!!, projection, null, null, null)
        if (cursor != null && cursor.moveToFirst()) {
            val index = cursor.getColumnIndexOrThrow(MediaStore.MediaColumns.DISPLAY_NAME)
            return cursor.getString(index)
        }
    } finally {
        cursor?.close()
    }
    return null
}

private fun getDataColumn(context: Context, uri: Uri?, selection: String?, selectionArgs: Array<String>?): String? {
    if (uri == null) {
        return null
    }
    var cursor: Cursor? = null
    val column = "_data"
    val projection = arrayOf(column)

    try {
        cursor = context.contentResolver.query(uri, projection, selection, selectionArgs, null)
        cursor?.let {
            if (it.moveToFirst()) {
                val index = it.getColumnIndexOrThrow(column)
                return it.getString(index)
            }
        }
    } catch (e: Exception) {
        return null
    }
    finally {
        cursor?.close()
    }
    return null
}

private fun isExternalStorageDocument(uri: Uri): Boolean {
    return "com.android.externalstorage.documents" == uri.authority
}

private fun isDownloadsDocument(uri: Uri): Boolean {
    return "com.android.providers.downloads.documents" == uri.authority
}

private fun isMediaDocument(uri: Uri): Boolean {
    return "com.android.providers.media.documents" == uri.authority
}

private fun isGooglePhotosUri(uri: Uri): Boolean {
    return "com.google.android.apps.photos.content" == uri.authority
}