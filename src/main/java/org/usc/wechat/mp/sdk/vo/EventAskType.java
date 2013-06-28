package org.usc.wechat.mp.sdk.vo;

/**
 *
 * @author Shunli
 */
public enum EventAskType {
    SUBSCRIBE("subscribe"), UNSUBSCRIBE("unsubscribe"), CLICK("CLICK");

    private String type;

    private EventAskType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

}
