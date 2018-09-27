package 第一章栈和队列.问题4猫狗队列;

import 第一章栈和队列.问题4猫狗队列.Pet;

/**
 * created by memory
 * on 2018/9/27 下午1:43
 */
public class PetEnterQueue {
    private Pet pet;
    private long count;
    public PetEnterQueue(Pet pet,Long count)//pet是用户原有的实例，count是这个实例的时间戳
    {
        this.pet=pet;
        this.count=count;
    }
    public Pet getPet()
    {
        return  this.pet;
    }
    public long getCount()
    {
        return this.count;
    }
    public String getEnterPetType()
    {
        return this.pet.getPetType();
    }
}
