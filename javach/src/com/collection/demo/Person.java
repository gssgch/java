package com.collection.demo;

public class Person extends Object implements Comparable {
    private String name;
    private int age;

    public Person() {
        super();
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the age
     */
    public int getAge() {
        return age;
    }

    /**
     * @param age the age to set
     */
    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return this.name + ":" + age;
    }

    @Override
    public int hashCode() {
        //        System.out.println(this + ".....hashCode"); // 先判断哈希值，如果不等就不判断equals方法
        return name.hashCode() + age;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Person)) {
            throw new ClassCastException("类型错误");
        }
        //        System.out.println(this + "...equals..." + obj);
        Person p = (Person) obj;
        return this.name.equals(p.name) && (this.age == p.age);
    }

    @Override
    public int compareTo(Object o) {
        // 按persion对象的年龄排序，从小到大
        Person p = (Person) o;
        //简化写法
        int temp = this.age - p.age;
        return temp == 0 ? this.name.compareTo(p.name) : temp;
        //        if (this.age > p.age) {
        //            return 1;
        //        }
        //        if (this.age < p.age) {
        //            return -1;
        //        }
        //        if (this.age == p.age) {
        //            return this.name.compareTo(p.name);
        //        }
        //        return 0;
    }
    // 使用 shift+alt +s 生成的hashCode和equals方法

    /*    @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + age;
            result = prime * result + ((name == null) ? 0 : name.hashCode());
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            Persion other = (Persion) obj;
            if (age != other.age)
                return false;
            if (name == null) {
                if (other.name != null)
                    return false;
            } else if (!name.equals(other.name))
                return false;
            return true;
        }*/

}
