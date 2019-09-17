class  Student  {
   static String schoolName;
}
public  class  J1{
    public static void main (String[] args)  {
          Student stu1=new Student();
          Student stu2=new Student();
          Student.schoolName="传智博客";
          System.out.println("我的学校是"+stu1.schoolName);
          System.out.println("我的学校是"+stu2.schoolName);
}
}