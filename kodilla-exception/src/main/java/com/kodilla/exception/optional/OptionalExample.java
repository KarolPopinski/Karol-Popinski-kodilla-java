package com.kodilla.exception.optional;

import com.kodilla.exception.nullpointer.User;

import java.util.Optional;

public class OptionalExample {

    //OPTIONAL z ifPresent - jeżeli optionalUser = null nic się nie dzieje a jeżeli inna niż null = wywoła metodę getName
    public static void main(String[] args) {
        User user = new User("user1");

        Optional<User> optionalUser = Optional.ofNullable(user);

        optionalUser.ifPresent(u -> System.out.println(u.getName()));
    }

    /* OPTIONAL opakowanie z opcją orELSE
    public static void main(String[] args) {
        User user = new User("user1");

        Optional<User> optionalUser = Optional.ofNullable(user);

        String username = optionalUser.orElse(new User("")).getName();

        System.out.println(username);
    }
    */

    /* OPTIONAL podstawowe opakowanie
    public static void main(String[] args) {
        User user = new User("user1");

        Optional<User> optionalUser = Optional.ofNullable(user);
    }
    */
}
