package org.usc.wechat.mp.sdk.factory.parser;

import org.apache.commons.lang3.EnumUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;
import org.usc.wechat.mp.sdk.util.ReplyUtil;
import org.usc.wechat.mp.sdk.vo.EventAskType;
import org.usc.wechat.mp.sdk.vo.ask.Ask;
import org.usc.wechat.mp.sdk.vo.ask.EventAsk;
import org.usc.wechat.mp.sdk.vo.reply.Reply;

/**
 *
 * @author Shunli
 */
public class EventAskParser implements AskParser {
    @Override
    public Reply parse(Ask push) {
        if (!(push instanceof EventAsk)) {
            return null;
        }

        EventAsk eventPush = (EventAsk) push;
        String event = eventPush.getEvent();

        EventAskType eventAskType = EnumUtils.getEnum(EventAskType.class, StringUtils.upperCase(event));
        Validate.notNull(eventAskType, "don't-support-%s-event-push", event);

        // TODO please custom it.
        if (eventAskType == EventAskType.SUBSCRIBE) {
            Reply reply = ReplyUtil.parseReplyDetailWarpper(ReplyUtil.getDummyTextReplyDetailWarpper());
            return ReplyUtil.buildReply(reply, eventPush);
        }

        return null;
    }
}
