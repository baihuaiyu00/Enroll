package com.csxupt.cal.mapper;

import com.csxupt.cal.entity.Student;
import org.apache.ibatis.annotations.Select;

/**
 * Created by Admin on 2016/9/2.
 */

public interface StuInfoInsertMapper extends SqlMapper{

    void stuInsert(Student student);

    String checkStunum(String stunum);

}
