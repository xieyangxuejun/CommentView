package com.foretree.commentview.comment;

import android.database.Cursor;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.CharArrayWriter;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class IOUtils {
    private static final int DEFAULT_BUFFER_SIZE = 4096;
    public static final char DIR_SEPARATOR = File.separatorChar;
    public static final char DIR_SEPARATOR_UNIX = '/';
    public static final char DIR_SEPARATOR_WINDOWS = '\\';
    public static final String LINE_SEPARATOR;
    public static final String LINE_SEPARATOR_UNIX = "\n";
    public static final String LINE_SEPARATOR_WINDOWS = "\r\n";

    static {
        Writer stringWriter = new StringWriter(4);
        new PrintWriter(stringWriter).println();
        LINE_SEPARATOR = stringWriter.toString();
    }

    public static void closeQuietly(Reader reader) {
        if (reader != null) {
            try {
                reader.close();
            } catch (IOException e) {
            }
        }
    }

    public static void closeQuietly(Cursor cursor) {
        if (cursor != null) {
            try {
                cursor.close();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static void closeQuietly(Writer writer) {
        if (writer != null) {
            try {
                writer.close();
            } catch (IOException e) {
            }
        }
    }

    public static void closeQuietly(InputStream inputStream) {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e) {
            }
        }
    }

    public static void closeQuietly(OutputStream outputStream) {
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (IOException e) {
            }
        }
    }

//    public static byte[] toByteArray(InputStream inputStream) throws IOException {
//        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
//        copy(inputStream, byteArrayOutputStream);
//        return byteArrayOutputStream.toByteArray();
//    }
//
//    public static byte[] toByteArray(Reader reader) throws IOException {
//        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
//        copy(reader, byteArrayOutputStream);
//        return byteArrayOutputStream.toByteArray();
//    }
//
//    public static byte[] toByteArray(Reader reader, String str) throws IOException {
//        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
//        copy(reader, byteArrayOutputStream, str);
//        return byteArrayOutputStream.toByteArray();
//    }

    public static byte[] toByteArray(String str) throws IOException {
        return str.getBytes();
    }

    public static char[] toCharArray(InputStream inputStream) throws IOException {
        Writer charArrayWriter = new CharArrayWriter();
        copy(inputStream, charArrayWriter);
        return charArrayWriter.toString().toCharArray();
    }

    public static char[] toCharArray(InputStream inputStream, String str) throws IOException {
        Writer charArrayWriter = new CharArrayWriter();
        copy(inputStream, charArrayWriter, str);
        return charArrayWriter.toString().toCharArray();
    }

    public static char[] toCharArray(Reader reader) throws IOException {
        Writer charArrayWriter = new CharArrayWriter();
        copy(reader, charArrayWriter);
        return charArrayWriter.toString().toCharArray();
    }

    public static String toString(InputStream inputStream) throws IOException {
        Writer stringWriter = new StringWriter();
        copy(inputStream, stringWriter);
        return stringWriter.toString();
    }

    public static String toString(InputStream inputStream, String str) throws IOException {
        Writer stringWriter = new StringWriter();
        copy(inputStream, stringWriter, str);
        return stringWriter.toString();
    }

    public static String toString(Reader reader) throws IOException {
        Writer stringWriter = new StringWriter();
        copy(reader, stringWriter);
        return stringWriter.toString();
    }

    public static String toString(byte[] bArr) throws IOException {
        return new String(bArr);
    }

    public static String toString(byte[] bArr, String str) throws IOException {
        if (str == null) {
            return new String(bArr);
        }
        return new String(bArr, str);
    }

    public static List readLines(InputStream inputStream) throws IOException {
        return readLines(new InputStreamReader(inputStream));
    }

    public static List readLines(InputStream inputStream, String str) throws IOException {
        if (str == null) {
            return readLines(inputStream);
        }
        return readLines(new InputStreamReader(inputStream, str));
    }

    public static List readLines(Reader reader) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(reader);
        List arrayList = new ArrayList();
        for (Object readLine = bufferedReader.readLine(); readLine != null; readLine = bufferedReader.readLine()) {
            arrayList.add(readLine);
        }
        return arrayList;
    }

    public static InputStream toInputStream(String str) {
        return new ByteArrayInputStream(str.getBytes());
    }

    public static InputStream toInputStream(String str, String str2) throws IOException {
        return new ByteArrayInputStream(str2 != null ? str.getBytes(str2) : str.getBytes());
    }

    public static void write(byte[] bArr, OutputStream outputStream) throws IOException {
        if (bArr != null) {
            outputStream.write(bArr);
        }
    }

    public static void write(byte[] bArr, Writer writer) throws IOException {
        if (bArr != null) {
            writer.write(new String(bArr));
        }
    }

    public static void write(byte[] bArr, Writer writer, String str) throws IOException {
        if (bArr == null) {
            return;
        }
        if (str == null) {
            write(bArr, writer);
        } else {
            writer.write(new String(bArr, str));
        }
    }

    public static void write(char[] cArr, Writer writer) throws IOException {
        if (cArr != null) {
            writer.write(cArr);
        }
    }

    public static void write(char[] cArr, OutputStream outputStream) throws IOException {
        if (cArr != null) {
            outputStream.write(new String(cArr).getBytes());
        }
    }

    public static void write(char[] cArr, OutputStream outputStream, String str) throws IOException {
        if (cArr == null) {
            return;
        }
        if (str == null) {
            write(cArr, outputStream);
        } else {
            outputStream.write(new String(cArr).getBytes(str));
        }
    }

    public static void write(String str, Writer writer) throws IOException {
        if (str != null) {
            writer.write(str);
        }
    }

    public static void write(String str, OutputStream outputStream) throws IOException {
        if (str != null) {
            outputStream.write(str.getBytes());
        }
    }

    public static void write(String str, OutputStream outputStream, String str2) throws IOException {
        if (str == null) {
            return;
        }
        if (str2 == null) {
            write(str, outputStream);
        } else {
            outputStream.write(str.getBytes(str2));
        }
    }

    public static void write(StringBuffer stringBuffer, Writer writer) throws IOException {
        if (stringBuffer != null) {
            writer.write(stringBuffer.toString());
        }
    }

    public static void write(StringBuffer stringBuffer, OutputStream outputStream) throws IOException {
        if (stringBuffer != null) {
            outputStream.write(stringBuffer.toString().getBytes());
        }
    }

    public static void write(StringBuffer stringBuffer, OutputStream outputStream, String str) throws IOException {
        if (stringBuffer == null) {
            return;
        }
        if (str == null) {
            write(stringBuffer, outputStream);
        } else {
            outputStream.write(stringBuffer.toString().getBytes(str));
        }
    }

    public static void writeLines(Collection collection, String str, OutputStream outputStream) throws IOException {
        if (collection != null) {
            if (str == null) {
                str = LINE_SEPARATOR;
            }
            for (Object next : collection) {
                if (next != null) {
                    outputStream.write(next.toString().getBytes());
                }
                outputStream.write(str.getBytes());
            }
        }
    }

    public static void writeLines(Collection collection, String str, OutputStream outputStream, String str2) throws IOException {
        if (str2 == null) {
            writeLines(collection, str, outputStream);
        } else if (collection != null) {
            if (str == null) {
                str = LINE_SEPARATOR;
            }
            for (Object next : collection) {
                if (next != null) {
                    outputStream.write(next.toString().getBytes(str2));
                }
                outputStream.write(str.getBytes(str2));
            }
        }
    }

    public static void writeLines(Collection collection, String str, Writer writer) throws IOException {
        if (collection != null) {
            if (str == null) {
                str = LINE_SEPARATOR;
            }
            for (Object next : collection) {
                if (next != null) {
                    writer.write(next.toString());
                }
                writer.write(str);
            }
        }
    }

    public static int copy(InputStream inputStream, OutputStream outputStream) throws IOException {
        long copyLarge = copyLarge(inputStream, outputStream);
        if (copyLarge > 2147483647L) {
            return -1;
        }
        return (int) copyLarge;
    }

    public static long copyLarge(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[4096];
        long j = 0;
        while (true) {
            int read = inputStream.read(bArr);
            if (-1 == read) {
                return j;
            }
            outputStream.write(bArr, 0, read);
            j += (long) read;
        }
    }

    public static void copy(InputStream inputStream, Writer writer) throws IOException {
        copy(new InputStreamReader(inputStream), writer);
    }

    public static void copy(InputStream inputStream, Writer writer, String str) throws IOException {
        if (str == null) {
            copy(inputStream, writer);
        } else {
            copy(new InputStreamReader(inputStream, str), writer);
        }
    }

    public static int copy(Reader reader, Writer writer) throws IOException {
        long copyLarge = copyLarge(reader, writer);
        if (copyLarge > 2147483647L) {
            return -1;
        }
        return (int) copyLarge;
    }

    public static long copyLarge(Reader reader, Writer writer) throws IOException {
        char[] cArr = new char[4096];
        long j = 0;
        while (true) {
            int read = reader.read(cArr);
            if (-1 == read) {
                return j;
            }
            writer.write(cArr, 0, read);
            j += (long) read;
        }
    }

    public static void copy(Reader reader, OutputStream outputStream) throws IOException {
        Writer outputStreamWriter = new OutputStreamWriter(outputStream);
        copy(reader, outputStreamWriter);
        outputStreamWriter.flush();
    }

    public static void copy(Reader reader, OutputStream outputStream, String str) throws IOException {
        if (str == null) {
            copy(reader, outputStream);
            return;
        }
        Writer outputStreamWriter = new OutputStreamWriter(outputStream, str);
        copy(reader, outputStreamWriter);
        outputStreamWriter.flush();
    }

    public static boolean contentEquals(InputStream inputStream, InputStream inputStream2) throws IOException {
        if (!(inputStream instanceof BufferedInputStream)) {
            inputStream = new BufferedInputStream(inputStream);
        }
        if (!(inputStream2 instanceof BufferedInputStream)) {
            inputStream2 = new BufferedInputStream(inputStream2);
        }
        for (int read = inputStream.read(); -1 != read; read = inputStream.read()) {
            if (read != inputStream2.read()) {
                return false;
            }
        }
        return inputStream2.read() == -1;
    }

    public static boolean contentEquals(Reader reader, Reader reader2) throws IOException {
        if (!(reader instanceof BufferedReader)) {
            reader = new BufferedReader(reader);
        }
        if (!(reader2 instanceof BufferedReader)) {
            reader2 = new BufferedReader(reader2);
        }
        for (int read = reader.read(); -1 != read; read = reader.read()) {
            if (read != reader2.read()) {
                return false;
            }
        }
        return reader2.read() == -1;
    }
}