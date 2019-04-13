package com.example.xp_test;

import android.provider.SyncStateContract;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    ByteArrayOutputStream b = new ByteArrayOutputStream();

    public static final int[] abcde = new int[]{1732584193, -271733879, -1732584194, 271733878, -1009589776};
    public static int[] digestInt = new int[5];


    @Test
    public void addition_isCorrect() {




        writeChar(28);
        writeInt(1);
        writeInt(65536);
        writeChar(65280);
        writeInt(0);
        writeInt(2054);
        writeInt(294);
        writeInt(0);
        System.out.println( Arrays.toString(b.toByteArray()));

        String a = "[frame]" +"id=2054" +"pageList=8890" +"reqPage=8890" +"reqPageCount=1" +"[8890]" +"id=1001" +"ctrlcount=2" +"ctrlid_0=34338" +"ctrlvalue_0=15377323444" +"ctrlid_1=34339" +"ctrlvalue_1=123456" +"reqctrl=4304";
        System.out.print(Arrays.toString(a.getBytes()));
        System.out.print("\n");
        writeChars(a);
    }
    public final void writeChars(String str) {
        byte[] bArr = new byte[(str.length() * 2)];
        int i = 0;
        while (i < str.length()) {
            int i2 = i == 0 ? i : i * 2;
            bArr[i2] = (byte) str.charAt(i);
            bArr[i2 + 1] = (byte) (str.charAt(i) >> 7);
            i++;
        }
        System.out.print(Arrays.toString(bArr));
    }

    public final byte[] writeInt(int i){
        ByteArrayOutputStream b = new ByteArrayOutputStream();
        this.b.write(i);
        this.b.write(i >> 8);
        this.b.write(i >> 16);
        this.b.write(i >> 24);
        return b.toByteArray();
    }

    public final void writeChar(int i) {
        this.b.write(i);
        this.b.write(i >> 8);
    }
    @Test
    public void aes() throws UnsupportedEncodingException, NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        String password = "*j^k_)a+#s.<%(m@";
        String data = "{\"codeInput\":\"3cfz\",\"uuid\":\"3b46fea9-9831-4da8-b18a-b01e60f883df\",\"SMSParam\":\"register\",\"mobilePhone\":\"15377323444\",\"v_date\":\"1554700969003\"}";

        SecretKeySpec key = getKey(password);
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        byte[] byteContent = data.getBytes("utf-8");
        cipher.init(1, key);
        String resultString = parseByte2HexStr(cipher.doFinal(byteContent));
        System.out.print(resultString);

    }
    private static SecretKeySpec getKey(String password) throws UnsupportedEncodingException {
        byte[] keyBytes = new byte[16];
        Arrays.fill(keyBytes, (byte) 0);
        byte[] passwordBytes = password.getBytes("UTF-8");
        System.arraycopy(passwordBytes, 0, keyBytes, 0, passwordBytes.length < keyBytes.length ? passwordBytes.length : keyBytes.length);
        return new SecretKeySpec(keyBytes, "AES");
    }
    public static String parseByte2HexStr(byte[] buf) {
        StringBuffer sb = new StringBuffer();
        for (byte b : buf) {
            String hex = Integer.toHexString(b & 255);
            if (hex.length() == 1) {
                hex = '0' + hex;
            }
            sb.append(hex.toUpperCase());
        }
        return sb.toString();
    }



}