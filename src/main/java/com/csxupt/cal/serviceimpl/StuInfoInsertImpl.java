package com.csxupt.cal.serviceimpl;

import com.csxupt.cal.common.EmailUtil;
import com.csxupt.cal.entity.Student;
import com.csxupt.cal.mapper.StuInfoInsertMapper;
import com.csxupt.cal.service.StuInfoInsert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import java.util.Properties;

/**
 * Created by Admin on 2016/9/1.
 */

@Service
public class StuInfoInsertImpl implements StuInfoInsert{

    @Autowired
    StuInfoInsertMapper stuInfoInsertMapper;

    @Override
    public String createStu(Student student) {


        String result = stuInfoInsertMapper.checkStunum(student.getStu_num());
        System.out.println("数据库查询结果为:"+result+"比对结果为:"+(result==null));
        if(result==null) {
            stuInfoInsertMapper.stuInsert(student);

//            try {
//                Properties prop = new Properties();
//                String host = "smtp.sina.com";
//                prop.setProperty("mail.host", host);
//                prop.setProperty("mail.transport.protocol", "smtp");
//                prop.setProperty("mail.smtp.auth", "true");
//                Session session = Session.getInstance(prop);
//                session.setDebug(true);
//                Transport ts = null;ts = session.getTransport();
//                String username1 = "xuptcal";
//                String password1 = "xuptb103";
//                ts.connect(username1, password1);
//                Message message = EmailUtil.createEmail(session, student);
//                ts.sendMessage(message, message.getAllRecipients());
//                ts.close();
//            } catch (Exception e) {
//                System.out.println("邮件发送发生错误"+e.getMessage());
//                return "2";
//            }

            return "1";
        }else{
            return "0";
        }
    }
}
