package other.集合.hashMap和hashTable;

public class Coder {
    private int id;
    private int age;
    public Coder(int id,int age )
    {
        this.id=id;
        this.age=age;
    }
    public int hashcode()
    {
        return id*100+age;
    }
    public boolean equals(Object other)
    {
        if (other==this)
            return true;
        if (!(other instanceof Coder))
            return false;
        if ((((Coder) other).age==this.age)&&((Coder) other).id==this.id)
            return true;
        return false;
    }
}
