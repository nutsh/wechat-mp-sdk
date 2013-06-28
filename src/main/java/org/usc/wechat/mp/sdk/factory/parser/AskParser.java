package org.usc.wechat.mp.sdk.factory.parser;

import org.usc.wechat.mp.sdk.vo.ask.Ask;
import org.usc.wechat.mp.sdk.vo.reply.Reply;

/**
 *
 * @author Shunli
 */
public interface AskParser {
    Reply parse(Ask push);
}
