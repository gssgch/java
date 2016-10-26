package com.myjava.thread.zxx;

import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class CollectionModifyExceptionTest {
    public static void main(String[] args) {
        //        Collection users = new ArrayList();
        Collection users = new CopyOnWriteArrayList();

        //new ArrayList();
        users.add(new User("张三", 28));
        users.add(new User("李四", 25));
        users.add(new User("王五", 31));
        Iterator itrUsers = users.iterator();
        while (itrUsers.hasNext()) {
            System.out.println("aaaa");
            User user = (User) itrUsers.next();
            // 如果上面使用ArrayList，那么在迭代过程中有remove操作，
            // 就会导致版本号增加，然后next方法中的检查就会报错
            // 在迭代集合的过程中，不能对集合进行操作
            if ("张三".equals(user.getName())) {
                users.remove(user);
                //itrUsers.remove();
            } else {
                System.out.println(user);
            }
        }
    }
}
