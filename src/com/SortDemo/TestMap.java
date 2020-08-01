package SortDemo;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:wanghuimin
 * Date:2020-05-13
 * Time:10:28
 * 一万年太久，只争朝夕，加油
 */
class Student{
    public String name;
    public int age;
    public String grade;
    public String school;

    public Student(String name, int age, String grade, String school) {
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.school = school;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", grade='" + grade + '\'' +
                ", school='" + school + '\'' +
                '}';
    }
}
public class TestMap {
    public static void main(String[] args) {
        Student s1=new Student("张三",15,"大三","陕科大");
        Student s2=new Student("李四",55,"大四","西工院");
        Student s3=new Student("王五",16,"大一","埃里巴巴");

        Map<String,Student> studentMap=new HashMap<>();
        studentMap.put(s1.name,s1);
        studentMap.put(s2.name,s2);
        studentMap.put(s2.name,s2);
        String name="张三2";
        //Student student=studentMap.get(name);
        Student student2=studentMap.getOrDefault(name,new Student("蔡徐坤",0,"默认年级","默认学校"));
        System.out.println(student2);
        //System.out.println(student);
        Map<Integer,Student> studentMap1=new HashMap<>();
        studentMap1.put(s1.age,s1);
        studentMap1.put(s2.age,s2);
        studentMap1.put(s3.age,s2);
        Student student1=studentMap1.get(15);

        System.out.println(student1);
        //遍历一个Map
        //Entry条目的意思   键值对
        for(Map.Entry<String,Student> entry:studentMap.entrySet()){
            System.out.println(entry.getKey()+":"+entry.getValue());

        }
        Iterator<Map.Entry<String,Student>> iterator=studentMap.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry<String,Student> entry=iterator.next();
            System.out.println(entry.getKey()+":"+entry.getValue());
        }



    }
}
