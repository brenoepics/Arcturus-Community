package com.eu.habbo.messages.outgoing.unknown;

import com.eu.habbo.messages.ServerMessage;
import com.eu.habbo.messages.outgoing.MessageComposer;

public class SnowWarsGameStartedErrorComposer extends MessageComposer {
    @Override
    public ServerMessage compose() {
        this.response.init(2860);
        this.response.appendInt(1);
        return this.response;
    }
}
