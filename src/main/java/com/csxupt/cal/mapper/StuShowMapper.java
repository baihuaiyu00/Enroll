package com.csxupt.cal.mapper;

import com.csxupt.cal.entity.Student;

import java.util.List;

/**
 * Created by Admin on 2016/9/2.
 */
public interface StuShowMapper extends SqlMapper {

    List<Student> showAllStu();

}
