package 第一章栈和队列.问题4猫狗队列;

import java.util.LinkedList;
import java.util.Queue;

/**
 * created by memory
 * on 2018/9/27 下午2:01
 */
/*用户可以调用add方法将cat类或者dog类的实例放入队列中
 *用户可以调用pollAll方法将队列中的实例按照进队列先后顺序弹出
 * 用户可以调用pollCat方法将队列中cat实例按照进队列先后顺序出队列
 */

public class DogCatQueue {
     private Queue<PetEnterQueue> dogQueue;
     private Queue<PetEnterQueue> catQueue;
     private long count;
     public DogCatQueue()
     {
         this.dogQueue=new LinkedList<PetEnterQueue>();
         this.catQueue=new LinkedList<PetEnterQueue>();
         this.count=0;
     }
     public void add(Pet pet)
     {
         String type=pet.getPetType();
         if (type=="cat")
             this.catQueue.add(new PetEnterQueue(pet,this.count++));
         else if (type=="dog")
             this.dogQueue.add(new PetEnterQueue(pet,this.count++));
         else
             throw new RuntimeException("err,not dog or cat");
     }
     public Pet pollAll()
     {
         if(!this.dogQueue.isEmpty()&&!this.catQueue.isEmpty())
         {
             if (this.dogQueue.peek().getCount()>this.catQueue.peek().getCount())
                 return this.catQueue.poll().getPet();
             else
                 return this.dogQueue.poll().getPet();
         }
         else if (!this.dogQueue.isEmpty())
             return this.dogQueue.poll().getPet();
         else if (!this.catQueue.isEmpty())
             return this.catQueue.poll().getPet();
         else
             throw new RuntimeException("err,queue is empty!");
     }
     public Dog pollDog()
     {
         if (this.dogQueue.isEmpty())
             throw new RuntimeException("Dog queue is empty!");
         else
             return (Dog)this.dogQueue.poll().getPet();
     }
     public Cat pollCat()
     {
         if (this.catQueue.isEmpty())
             throw new RuntimeException("Cat queue is empty!");
         else
             return (Cat)this.catQueue.poll().getPet();
     }
     public boolean isEmpty(){
         return this.catQueue.isEmpty()&&this.dogQueue.isEmpty();
     }
     public boolean isDogEmpty(){
         return this.dogQueue.isEmpty();
     }
     public boolean isCatEmpty(){
         return this.catQueue.isEmpty();
     }
     public int size()
     {
         return this.catSize()+this.dogSize();
     }
     public int dogSize()
     {
         return this.dogQueue.size();
     }
     public int catSize()
     {
         return this.catQueue.size();
     }
}
