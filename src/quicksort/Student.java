package quicksort;

/**
 * Created by Wangpl
 * Time 2018/8/29 17:55
 */
public class Student implements Comparable<Student> {

    private int id;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public int compareTo(Student o) {
        if (this.id > o.getId())
            return 1;
        else if (this.id < o.getId())
            return -1;
        else return 0;
    }
}
