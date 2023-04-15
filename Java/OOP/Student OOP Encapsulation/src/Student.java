public class Student
{
    private String name;
    private int age;
    private String adress;

    public Student(String name, int age, String adress) // this functions needs to have the same name as the class, this functions set the value in the beginning
    {
        this.name = name;
        this.age = age;
        this.adress = adress;
    }

    public void setName(String name) //the name 'set__' can be changed but is the standard name
    {
        this.name = name;
    }
    public void  setAge(int age) //also these functions served as a modifier in the variable
    {
        this.age = age;
    }
    public  void setAdress(String adress)
    {
        this.adress = adress;
    }

    private String getName() //the name 'get__' can be changed but is the standard name
    {
        return name;
    }

    public  int getAge() //these functions returns the value of the variable
    {
        return age;
    }

    public String getAdress()
    {
        return adress;
    }

    public String toString()
    {
        return ("Name´s student is: " + this.getName() + ", the student´s age is: " + this.getAge() +
                ", the student´s adress is: " + this.getAdress());

    }


}
