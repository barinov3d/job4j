package ru.job4j.map;

import java.util.Calendar;

public class User {
    private String name;
    private int children;
    private Calendar birthday;

    public User(String name, int children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public int getChildren() {
        return children;
    }

    public Calendar getBirthday() {
        return birthday;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * (result + name.length());
        result = prime * result + children;
        result = prime * result + birthday.get(Calendar.DAY_OF_YEAR);
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        User guest = (User) obj;
        return children == guest.children && (name == guest.name || (name != null && name.equals(guest.getName())))
                && (birthday == guest.birthday || (birthday != null && birthday.equals(guest.getBirthday())));
    }
}
