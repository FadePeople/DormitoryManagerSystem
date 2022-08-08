package com.hyb.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hyb.entity.Dormitory;
import com.hyb.entity.Student;
import com.hyb.form.SearchForm;
import com.hyb.mapper.DormitoryMapper;
import com.hyb.mapper.StudentMapper;
import com.hyb.service.StudentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hyb.util.CommonUtil;
import com.hyb.vo.PageVO;
import com.hyb.vo.StudentVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Heyubo
 * @since 2022-07-27
 */
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements StudentService {

    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private DormitoryMapper dormitoryMapper;

    @Override
    public Boolean saveStudent(Student student) {
        //添加学生数据
        student.setCreateDate(CommonUtil.createData());
        student.setState("入住");
        int insert = studentMapper.insert(student);
        if(insert != 1) return false;
        //修改宿舍数据
        Dormitory dormitory = dormitoryMapper.selectById(student.getDormitoryId());
        if(dormitory.getAvailable()==0) return false;
        dormitory.setAvailable(dormitory.getAvailable()-1);
        int update = dormitoryMapper.updateById(dormitory);
        if(update!=1) return false;
        return true;
    }

    @Override
    public PageVO list(Integer page, Integer size) {
        Page<Student> objectPage = new Page<>(page, size);
        Page<Student> resultPage = studentMapper.selectPage(objectPage, null);
        //VO转换
        List<Student> studentList = resultPage.getRecords();
        ArrayList<StudentVO> arrayList = new ArrayList<>();
        for (Student student : studentList) {
            StudentVO studentVO = new StudentVO();
            BeanUtils.copyProperties(student,studentVO);
            Dormitory dormitory = dormitoryMapper.selectById(student.getDormitoryId());
            studentVO.setDormitoryName(dormitory.getName());
            arrayList.add(studentVO);
        }
        PageVO pageVO = new PageVO();
        pageVO.setData(arrayList);
        pageVO.setTotal(resultPage.getTotal());
        return pageVO;
    }

    @Override
    public PageVO search(SearchForm searchForm) {
        Page<Student> studentPage = new Page<>(searchForm.getPage(),searchForm.getSize());
        Page<Student> resultPage = null;
        if(searchForm.getValue().equals("")) {
            resultPage = studentMapper.selectPage(studentPage, null);
        }else{
            QueryWrapper<Student> studentQueryWrapper = new QueryWrapper<>();
            studentQueryWrapper.like(searchForm.getKey(),searchForm.getValue());
            resultPage =  studentMapper.selectPage(studentPage,studentQueryWrapper);
        }
        //VO转换
        List<Student> studentList = resultPage.getRecords();
        List<StudentVO> arrayList = new ArrayList<>();
        for (Student student : studentList) {
            StudentVO studentVO = new StudentVO();
            BeanUtils.copyProperties(student,studentVO);
            Dormitory dormitory = dormitoryMapper.selectById(student.getDormitoryId());
            studentVO.setDormitoryName(dormitory.getName());
            arrayList.add(studentVO);
        }
        PageVO pageVO = new PageVO();
        pageVO.setData(arrayList);
        pageVO.setTotal(studentPage.getTotal());
        return pageVO;
    }

    @Override
    public Boolean deleteById(Integer id) {

        //先根据学生查出来宿舍的id
        Student student = studentMapper.selectById(id);
        Integer dormitoryId = student.getDormitoryId();
        //然后再删除学生数据
        int deleteById = studentMapper.deleteById(id);
        if(deleteById!=1) return false;
        //修改宿舍数据
        Dormitory dormitory = dormitoryMapper.selectById(dormitoryId);
        dormitory.setAvailable(dormitory.getAvailable()+1);
        int update = dormitoryMapper.updateById(dormitory);
        if(update !=1) return false;
        return true;

    }
}
