package com.eu.habbo.plugin.events.users;

import com.eu.habbo.habbohotel.rooms.Room;
import com.eu.habbo.habbohotel.users.Habbo;

public class HabboAddedToRoomEvent extends UserEvent {

    public final Room room;


    public HabboAddedToRoomEvent(Habbo habbo, Room room) {
        super(habbo);

        this.room = room;
    }
}
