package com.csxupt.cal.service;

import com.csxupt.cal.entity.Student;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Admin on 2016/9/2.
 */
@Service
public interface StuShow {

    List<Student> show();

}
