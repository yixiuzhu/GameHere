package com.laioffer.twitch.hello;

public record Person(
        String name,
        String company,
        Address homeAddress,
        Book favoriteBook
) {
}
