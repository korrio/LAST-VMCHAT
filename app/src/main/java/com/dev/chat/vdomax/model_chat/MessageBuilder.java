package com.dev.chat.vdomax.model_chat;

public class MessageBuilder {

    public static final int TYPE_RIGHT = 0;
    public static final int TYPE_LEFT = 1;
    public static final int TYPE_LOG = 2;

    private int mMessageType;
    private String mData;
    private int mSideType;
    private String mMessage;
    private String mUsername;

    private MessageBuilder() {}

    public int getType() {
        return mSideType;
    };

    public String getData() {
        return mData;
    }

    public String getMessage() {
        return mMessage;
    };

    public String getUsername() {
        return mUsername;
    };

    public int getMessageType() {
        return mMessageType;
    }


    public static class Builder {
        private int mMessageType;
        private final int mSideType;
        private String mUsername;
        private String mMessage;
        private String mData;

        public Builder(int messageType,int sideType) {
            mSideType = sideType;
            mMessageType = messageType;
        }

        public Builder(int sideType) {
            mSideType = sideType;
        }

        public Builder data(String data) {
            mData = data;
            return this;
        }

        public Builder messageType(int messageType) {
            mMessageType = messageType;
            return this;
        }

        public Builder username(String username) {
            mUsername = username;
            return this;
        }

        public Builder message(String message) {
            mMessage = message;
            return this;
        }

        public MessageBuilder build() {
            MessageBuilder message = new MessageBuilder();
            message.mMessageType = mMessageType;
            message.mSideType = mSideType;
            message.mUsername = mUsername;
            message.mMessage = mMessage;
            message.mData = mData;
            return message;
        }
    }
}
