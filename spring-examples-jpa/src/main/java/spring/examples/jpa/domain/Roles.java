package spring.examples.jpa.domain;

import java.io.Serializable;
import java.util.*;

public final class Roles implements Iterable<String>, Serializable {

    private final SortedSet<String> roleSet;

    public Roles(String... roles) {
        final SortedSet<String> set = new TreeSet<>();
        if (roles != null && roles.length != 0) {
            set.addAll(Arrays.asList(roles));
        }
        this.roleSet = Collections.unmodifiableSortedSet(set);
    }

    @Override
    public Iterator<String> iterator() {
        return roleSet.iterator();
    }

    public boolean isEmpty() {
        return roleSet.isEmpty();
    }

    public SortedSet<String> toSet() {
        return roleSet;
    }

}
