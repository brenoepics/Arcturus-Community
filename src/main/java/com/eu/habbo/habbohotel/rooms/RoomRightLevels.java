package com.eu.habbo.habbohotel.rooms;

public enum RoomRightLevels {

    NONE(0),


    RIGHTS(1),


    GUILD_RIGHTS(2),


    GUILD_ADMIN(3),


    OWNER(4),


    MODERATOR(5),


    SIX(6),


    SEVEN(7),


    EIGHT(8),


    NINE(9);

    public final int level;

    RoomRightLevels(int level) {
        this.level = level;
    }
}
