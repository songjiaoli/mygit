class  Student  {
   static String schoolName;
}
public  class  J1{
    public static void main (String[] args)  {
          Student stu1=new Student();
          Student stu2=new Student();
          Student.schoolName="���ǲ���";
          System.out.println("�ҵ�ѧУ��"+stu1.schoolName);
          System.out.println("�ҵ�ѧУ��"+stu2.schoolName);
}
}