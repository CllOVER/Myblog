package cn.cllover.myblog.test;

import org.apache.shiro.crypto.hash.Md5Hash;

public class HD5 {

    public static void main(String[] args) {
        String password="ceshi";
        Md5Hash hash1 = new Md5Hash(password,"ceshi",1024);
        System.out.println("passsword :" + hash1);
        //passsword :b64294c3936129eef8483ee7448d404f
    }

}
