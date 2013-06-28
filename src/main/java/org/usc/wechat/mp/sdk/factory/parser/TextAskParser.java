package org.usc.wechat.mp.sdk.factory.parser;

import org.usc.wechat.mp.sdk.util.ReplyUtil;
import org.usc.wechat.mp.sdk.vo.ask.Ask;
import org.usc.wechat.mp.sdk.vo.ask.TextAsk;
import org.usc.wechat.mp.sdk.vo.reply.Reply;

/**
 *
 * @author Shunli
 */
public class TextAskParser implements AskParser {
    @Override
    public Reply parse(Ask push) {
        if (!(push instanceof TextAsk)) {
            return null;
        }

        TextAsk textPush = (TextAsk) push;

        // TODO please custom it.
        Reply reply = ReplyUtil.parseReplyDetailWarpper(ReplyUtil.getDummyNewsReplyDetailWarpper());
        return ReplyUtil.buildReply(reply, textPush);
    }

}
