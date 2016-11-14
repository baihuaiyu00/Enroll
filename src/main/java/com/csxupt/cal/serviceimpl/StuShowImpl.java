package com.csxupt.cal.serviceimpl;

import com.csxupt.cal.entity.Student;
import com.csxupt.cal.mapper.StuShowMapper;
import com.csxupt.cal.service.StuShow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 2016/9/2.
 */
@Service
public class StuShowImpl implements StuShow{

    @Autowired
    StuShowMapper stuShowMapper;

    @Override
    public List<Student> show() {
        List<Student> stu_list = new ArrayList<>();
        stu_list = stuShowMapper.showAllStu();
        return stu_list;
    }
}
