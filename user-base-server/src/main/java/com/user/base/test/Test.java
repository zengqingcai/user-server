package com.user.base.test;

import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

public class Test {

    //todo 邮件的发送
    public static void main(String[] args) throws MessagingException {

        // 创建Properties 类用于记录邮箱的一些属性
        Properties props = new Properties();
        // 表示SMTP发送邮件，必须进行身份验证
        props.put("mail.smtp.auth", "true");
        //此处填写SMTP服务器
        props.put("mail.smtp.host", "smtp.qq.com");
        //端口号，QQ邮箱端口587
        props.put("mail.smtp.port", "587");
        // 此处填写，写信人的账号
        props.put("mail.user", "920555576@qq.com");
        // 此处填写16位STMP口令
        props.put("mail.password", "dnzjruwrozcmbbdf");

        // 构建授权信息，用于进行SMTP进行身份验证
        Authenticator authenticator = new Authenticator() {

            protected PasswordAuthentication getPasswordAuthentication() {
                // 用户名、密码
                String userName = props.getProperty("mail.user");
                String password = props.getProperty("mail.password");
                return new PasswordAuthentication(userName, password);
            }
        };
        // 使用环境属性和授权信息，创建邮件会话
        Session mailSession = Session.getInstance(props, authenticator);
        // 创建邮件消息
        MimeMessage message = new MimeMessage(mailSession);
        // 设置发件人
        InternetAddress form = new InternetAddress(props.getProperty("mail.user"));
        message.setFrom(form);

        // 设置收件人的邮箱
        InternetAddress to = new InternetAddress("13544361981@163.com");
        message.setRecipient(RecipientType.TO, to);

        // 设置邮件标题
        message.setSubject("test标题");

        // 设置邮件的内容体
        message.setContent("test内容", "text/html;charset=UTF-8");

        // 最后当然就是发送邮件啦
        Transport.send(message);

        //
        testApp(new AppleIml());


    }

    void getTime(){
        long start = new Date().getTime();

        //doSomeThing

        long end = new Date().getTime();
        System.out.println("该业务共用时："+(end-start)+"ms");
    }

    static void testApp(BaseInterFace baseInterFace){
        baseInterFace.colorSet();

    }


}