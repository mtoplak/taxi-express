package com.taxiexpress.ris.models;


public interface EmailService {

    boolean sendSimpleMail(String to, String subject, String text);

}
