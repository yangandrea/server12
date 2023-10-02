package com.example;

import java.io.*;
import java.net.*;
import java.util.*;

public class server {
    ServerSocket s = null;
    Socket c = null;
    String r = null;
    String m = null;
    BufferedReader inDalClient;
    DataOutputStream outVersoClient;
public Socket attendi(){
    try {
        System.out.println("server esecuzione" );
        s=new ServerSocket(6789);
        c=s.accept();
        s.close();
        inDalClient=new BufferedReader(new InputStreamReader(c.getInputStream()));
        outVersoClient= new DataOutputStream(c.getOutputStream());
    } catch (Exception e) {
        System.out.println(e.getMessage());
        System.out.println("errore");
        System.exit(1);
    }
    return c;
}
public void communica(){
try {
    System.out.println("benvuto nel client");
    r=inDalClient.readLine();
    System.out.println("ricevuta");
    m=r.toUpperCase();
    System.out.println(" invio della stringa");
    outVersoClient.writeBytes(m);
    System.out.println("fine");
    c.close();
} 
}
}
