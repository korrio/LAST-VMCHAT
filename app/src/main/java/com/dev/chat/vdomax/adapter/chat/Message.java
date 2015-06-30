package com.dev.chat.vdomax.adapter.chat;

public class Message {

    public static final int TYPE_RIGHT = 0;
    public static final int TYPE_LEFT = 1;
    public static final int TYPE_LOG = 2;

    private int mType;
    private String mMessage;
    private String mUsername;
    private String mImage;

    private Message() {}

    public int getType() {
        return mType;
    };

    public String getMessage() {
        return mMessage;
    };

    public String getUsername() {
        return mUsername;
    };

    public String getmImage() {
        return mImage;
    }

    public static class Builder {
        private final int mType;
        private String mUsername;
        private String mMessage;
        private String mImage;
        public Builder(int type) {
            mType = type;
        }

        public Builder username(String username) {
            mUsername = username;
            return this;
        }

        public Builder message(String message) {
            mMessage = message;
            return this;
        }
        public Builder mImage(String mImage) {
            mImage = mImage;
            return this;
        }
        public Message build() {
            Message message = new Message();
            message.mType = mType;
            message.mUsername = mUsername;
            message.mMessage = mMessage;
            message.mImage = mImage;
            return message;
        }
    }
}
