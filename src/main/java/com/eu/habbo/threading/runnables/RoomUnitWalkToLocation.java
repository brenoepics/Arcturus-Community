package com.eu.habbo.threading.runnables;

import com.eu.habbo.Emulator;
import com.eu.habbo.habbohotel.rooms.Room;
import com.eu.habbo.habbohotel.rooms.RoomTile;
import com.eu.habbo.habbohotel.rooms.RoomUnit;
import com.eu.habbo.habbohotel.wired.WiredHandler;
import com.eu.habbo.habbohotel.wired.WiredTriggerType;

import java.util.List;

public class RoomUnitWalkToLocation implements Runnable
{
    private RoomUnit walker;
    private RoomTile goalTile;
    private Room room;
    private List<Runnable> targetReached;
    private List<Runnable> failedReached;

    public RoomUnitWalkToLocation(RoomUnit walker, RoomTile goalTile, Room room, List<Runnable> targetReached, List<Runnable> failedReached)
    {
        this.walker = walker;
        this.goalTile = goalTile;
        this.room = room;
        this.targetReached = targetReached;
        this.failedReached = failedReached;
    }

    @Override
    public void run()  {
        if(this.goalTile == null || this.walker == null || this.room == null || this.walker.getRoom() == null || this.walker.getRoom().getId() != this.room.getId()) {
            onFail();
            return;
        }

        if(!this.walker.getGoal().equals(this.goalTile)) {
            onFail();
            return;
        }

        if(this.walker.getCurrentLocation().equals(this.goalTile))
        {
            onSuccess();
            return;
        }

        Emulator.getThreading().run(this, 500);
    }

    private void onSuccess() {
        for(Runnable r : this.targetReached)
            Emulator.getThreading().run(r);
    }

    private void onFail() {
        for(Runnable r : this.failedReached)
            Emulator.getThreading().run(r);
    }
}
