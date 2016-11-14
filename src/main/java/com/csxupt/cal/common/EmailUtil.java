package com.csxupt.cal.common;

import com.csxupt.cal.entity.Student;

import javax.mail.Message;
        import javax.mail.Session;
        import javax.mail.internet.InternetAddress;
        import javax.mail.internet.MimeMessage;

/**
 * Created by Admin on 2016/9/2.
 */
public class EmailUtil {


    public static Message createEmail(Session session,Student student) throws Exception {

//        ContextLoaderListener
//        DispatcherServlet
        MimeMessage message = new MimeMessage(session);
        String form = "xuptcal@sina.com";
        message.setFrom(new InternetAddress(form));
        message.setRecipient(Message.RecipientType.TO, new InternetAddress(student.getEmail()));
        message.setSubject("用户注册邮件");

        String info = "报名成功！by CAL实验室";
        message.setContent(info, "text/html;charset=UTF-8");
        message.saveChanges();
        return message;
    }
}
