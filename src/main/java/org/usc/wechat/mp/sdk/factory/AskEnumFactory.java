package org.usc.wechat.mp.sdk.factory;

import org.usc.wechat.mp.sdk.factory.parser.EventAskParser;
import org.usc.wechat.mp.sdk.factory.parser.ImageAskParser;
import org.usc.wechat.mp.sdk.factory.parser.LinkAskParser;
import org.usc.wechat.mp.sdk.factory.parser.LocationAskParser;
import org.usc.wechat.mp.sdk.factory.parser.AskParser;
import org.usc.wechat.mp.sdk.factory.parser.TextAskParser;
import org.usc.wechat.mp.sdk.factory.parser.VideoAskParser;
import org.usc.wechat.mp.sdk.factory.parser.VoiceAskParser;
import org.usc.wechat.mp.sdk.util.XmlUtil;
import org.usc.wechat.mp.sdk.vo.ask.Ask;
import org.usc.wechat.mp.sdk.vo.ask.EventAsk;
import org.usc.wechat.mp.sdk.vo.ask.ImageAsk;
import org.usc.wechat.mp.sdk.vo.ask.LinkAsk;
import org.usc.wechat.mp.sdk.vo.ask.LocationAsk;
import org.usc.wechat.mp.sdk.vo.ask.TextAsk;
import org.usc.wechat.mp.sdk.vo.ask.VideoAsk;
import org.usc.wechat.mp.sdk.vo.ask.VoiceAsk;
import org.usc.wechat.mp.sdk.vo.reply.Reply;

/**
 *
 * @author Shunli
 */
public enum AskEnumFactory {
    TEXT {
        @Override
        protected Class<? extends Ask> getPushClass() {
            return TextAsk.class;
        }

        @Override
        protected AskParser getPushParser() {
            return new TextAskParser();
        }
    },
    EVENT {
        @Override
        protected Class<? extends Ask> getPushClass() {
            return EventAsk.class;
        }

        @Override
        protected AskParser getPushParser() {
            return new EventAskParser();
        }
    },
    IMAGE {
        @Override
        protected Class<? extends Ask> getPushClass() {
            return ImageAsk.class;
        }

        @Override
        protected AskParser getPushParser() {
            return new ImageAskParser();
        }
    },
    LINK {
        @Override
        protected Class<? extends Ask> getPushClass() {
            return LinkAsk.class;
        }

        @Override
        protected AskParser getPushParser() {
            return new LinkAskParser();
        }
    },
    LOCATION {
        @Override
        protected Class<? extends Ask> getPushClass() {
            return LocationAsk.class;
        }

        @Override
        protected AskParser getPushParser() {
            return new LocationAskParser();
        }
    },
    VOICE { // not open
        @Override
        protected Class<? extends Ask> getPushClass() {
            return VoiceAsk.class;
        }

        @Override
        protected AskParser getPushParser() {
            return new VoiceAskParser();
        }
    },
    VIDEO { // not open
        @Override
        protected Class<? extends Ask> getPushClass() {
            return VideoAsk.class;
        }

        @Override
        protected AskParser getPushParser() {
            return new VideoAskParser();
        }
    };

    protected abstract Class<? extends Ask> getPushClass();
    protected abstract AskParser getPushParser();

    public Ask convert(String message) {
        return XmlUtil.unmarshal(message, getPushClass());
    }

    public Reply parse(Ask push) {
        return getPushParser().parse(push);
    }
}
