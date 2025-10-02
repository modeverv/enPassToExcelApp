package org.example;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.openxml4j.opc.PackageAccess;
import org.apache.poi.poifs.crypt.EncryptionInfo;
import org.apache.poi.poifs.crypt.EncryptionMode;
import org.apache.poi.poifs.crypt.Encryptor;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

public class Main {
    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.println("使い方: java ExcelPasswordProtector <input.xlsx> <output.xlsx> <password>");
            System.exit(1);
        }

        String inputFilePath = args[0];
        String outputFilePath = args[1];
        String password = args[2];

        try (POIFSFileSystem fs = new POIFSFileSystem()) {
            EncryptionInfo info = new EncryptionInfo(EncryptionMode.agile);
            Encryptor encryptor = info.getEncryptor();
            encryptor.confirmPassword(password);

            try (OPCPackage opc = OPCPackage.open(new File(inputFilePath), PackageAccess.READ_WRITE);
                 OutputStream os = encryptor.getDataStream(fs)) {
                opc.save(os);
            }

            try (FileOutputStream fos = new FileOutputStream(outputFilePath)) {
                fs.writeFilesystem(fos);
            }

            System.out.println("パスワード付きExcelを作成しました: " + outputFilePath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
