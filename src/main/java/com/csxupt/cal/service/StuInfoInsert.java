package com.csxupt.cal.service;

import com.csxupt.cal.entity.Student;
import org.springframework.stereotype.Service;

/**
 * Created by Admin on 2016/9/1.
 */
@Service
public interface StuInfoInsert {

    String createStu(Student student);

}
