package sortalgorithm.bean;

/**
 * @tag: leetcode
 * @author: mhp
 * @createDate: 2020/2/5
 * @description:
 */
public class Student implements Comparable<Student>{
    private String name;
    private int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    @Override
    public int compareTo(Student that){
        if(this.score < that.score){
            return -1;
        }else if(this.score > that.score){
            return 1;
        }else {
            return this.name.compareTo(that.name);
        }
    }

    @Override
    public String toString(){
        return "Student"+this.name+" "+Integer.toString(this.score);
    }
}
