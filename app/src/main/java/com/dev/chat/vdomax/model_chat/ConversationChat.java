package com.dev.chat.vdomax.model_chat;

import java.util.List;

/**
 * Created by Mac on 6/30/15.
 */
public class ConversationChat {

    /**
     * content : [{"conversationMembers":[{"extension":"jpg","username":"MightyChan","userId":117,"avatar":"photos/2014/10/Wnamf_114_5fd0b37cd7dbbb00f97ba6ce92bf5add"},{"extension":"jpg","username":"kdmz","userId":3,"avatar":"photos/2014/11/UyNpq_8030_b4d22bb574aed5fdd900a274930252f6"}],"lastHistoryDatetime":"2015-06-20T06:02:29.000Z","createdBy":null,"conversationType":"PRIVATE","name":null,"data":"{}","conversationId":2049,"lastMessage":"555+\n","memberType":"INDIVIDUAL","messageType":0,"type":"","avatar":null},{"conversationMembers":[{"extension":"jpg","username":"kdmz","userId":3,"avatar":"photos/2014/11/UyNpq_8030_b4d22bb574aed5fdd900a274930252f6"},{"extension":"jpg","username":"fb_1762697865","userId":169,"avatar":"photos/2014/10/Uzl9o_349_0bb4aec1710521c12ee76289d9440817"}],"lastHistoryDatetime":"2015-06-12T09:19:23.000Z","createdBy":null,"conversationType":"PRIVATE","name":null,"data":"{}","conversationId":2047,"lastMessage":"โหลๆ\n","memberType":"INDIVIDUAL","messageType":0,"type":"","avatar":null},{"conversationMembers":[{"extension":"jpg","username":"fb_849431505103882","userId":16611,"avatar":"photos/2015/06/hgZ47_110619_1d32ed47052c5ada6d4c160c318b575e"},{"extension":"jpg","username":"kdmz","userId":3,"avatar":"photos/2014/11/UyNpq_8030_b4d22bb574aed5fdd900a274930252f6"}],"lastHistoryDatetime":"2015-06-15T13:54:03.000Z","createdBy":null,"conversationType":"PRIVATE","name":null,"data":"{}","conversationId":1799,"lastMessage":"555+\n","memberType":"INDIVIDUAL","messageType":0,"type":"","avatar":null},{"conversationMembers":[{"extension":"jpg","username":"kdmz","userId":3,"avatar":"photos/2014/11/UyNpq_8030_b4d22bb574aed5fdd900a274930252f6"},{"extension":"jpg","username":"korrio","userId":6,"avatar":"photos/2015/04/pr8af_108899_c04356ab5e9726bb6e650e5b9cc17cbc"}],"lastHistoryDatetime":"2015-06-25T15:07:13.000Z","createdBy":null,"conversationType":"PRIVATE","name":null,"data":"{\"message\":\"???????\"}","conversationId":1751,"lastMessage":"werewrwr\n","memberType":"INDIVIDUAL","messageType":0,"type":"","avatar":null},{"conversationMembers":[{"extension":"jpg","username":"kdmz","userId":3,"avatar":"photos/2014/11/UyNpq_8030_b4d22bb574aed5fdd900a274930252f6"},{"extension":"jpg","username":"koredevman","userId":1,"avatar":"photos/2014/10/1Dutm_1_c4ca4238a0b923820dcc509a6f75849b"}],"lastHistoryDatetime":"2015-06-20T06:31:36.000Z","createdBy":null,"conversationType":"PRIVATE","name":null,"data":"{}","conversationId":1817,"lastMessage":"5555555\n","memberType":"INDIVIDUAL","messageType":0,"type":"","avatar":null}]
     * page : {"numberOfElements":5,"page":1,"totalElements":5,"finalPage":true,"totalPages":1,"size":20}
     */
    private List<ContentEntity> content;
    private PageEntity page;

    public void setContent(List<ContentEntity> content) {
        this.content = content;
    }

    public void setPage(PageEntity page) {
        this.page = page;
    }

    public List<ContentEntity> getContent() {
        return content;
    }

    public PageEntity getPage() {
        return page;
    }

    public class ContentEntity {
        /**
         * conversationMembers : [{"extension":"jpg","username":"MightyChan","userId":117,"avatar":"photos/2014/10/Wnamf_114_5fd0b37cd7dbbb00f97ba6ce92bf5add"},{"extension":"jpg","username":"kdmz","userId":3,"avatar":"photos/2014/11/UyNpq_8030_b4d22bb574aed5fdd900a274930252f6"}]
         * lastHistoryDatetime : 2015-06-20T06:02:29.000Z
         * createdBy : null
         * conversationType : PRIVATE
         * name : null
         * data : {}
         * conversationId : 2049
         * lastMessage : 555+

         * memberType : INDIVIDUAL
         * messageType : 0
         * type :
         * avatar : null
         */
        private List<ConversationMembersEntity> conversationMembers;
        private String lastHistoryDatetime;
        private String createdBy;
        private String conversationType;
        private String name;
        private String data;
        private int conversationId;
        private String lastMessage;
        private String memberType;
        private int messageType;
        private String type;
        private String avatar;

        public void setConversationMembers(List<ConversationMembersEntity> conversationMembers) {
            this.conversationMembers = conversationMembers;
        }

        public void setLastHistoryDatetime(String lastHistoryDatetime) {
            this.lastHistoryDatetime = lastHistoryDatetime;
        }

        public void setCreatedBy(String createdBy) {
            this.createdBy = createdBy;
        }

        public void setConversationType(String conversationType) {
            this.conversationType = conversationType;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setData(String data) {
            this.data = data;
        }

        public void setConversationId(int conversationId) {
            this.conversationId = conversationId;
        }

        public void setLastMessage(String lastMessage) {
            this.lastMessage = lastMessage;
        }

        public void setMemberType(String memberType) {
            this.memberType = memberType;
        }

        public void setMessageType(int messageType) {
            this.messageType = messageType;
        }

        public void setType(String type) {
            this.type = type;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        public List<ConversationMembersEntity> getConversationMembers() {
            return conversationMembers;
        }

        public String getLastHistoryDatetime() {
            return lastHistoryDatetime;
        }

        public String getCreatedBy() {
            return createdBy;
        }

        public String getConversationType() {
            return conversationType;
        }

        public String getName() {
            return name;
        }

        public String getData() {
            return data;
        }

        public int getConversationId() {
            return conversationId;
        }

        public String getLastMessage() {
            return lastMessage;
        }

        public String getMemberType() {
            return memberType;
        }

        public int getMessageType() {
            return messageType;
        }

        public String getType() {
            return type;
        }

        public String getAvatar() {
            return avatar;
        }

        public class ConversationMembersEntity {
            /**
             * extension : jpg
             * username : MightyChan
             * userId : 117
             * avatar : photos/2014/10/Wnamf_114_5fd0b37cd7dbbb00f97ba6ce92bf5add
             */
            private String extension;
            private String username;
            private int userId;
            private String avatar;

            public void setExtension(String extension) {
                this.extension = extension;
            }

            public void setUsername(String username) {
                this.username = username;
            }

            public void setUserId(int userId) {
                this.userId = userId;
            }

            public void setAvatar(String avatar) {
                this.avatar = avatar;
            }

            public String getExtension() {
                return extension;
            }

            public String getUsername() {
                return username;
            }

            public int getUserId() {
                return userId;
            }

            public String getAvatar() {
                return avatar;
            }
        }
    }

    public class PageEntity {
        /**
         * numberOfElements : 5
         * page : 1
         * totalElements : 5
         * finalPage : true
         * totalPages : 1
         * size : 20
         */
        private int numberOfElements;
        private int page;
        private int totalElements;
        private boolean finalPage;
        private int totalPages;
        private int size;

        public void setNumberOfElements(int numberOfElements) {
            this.numberOfElements = numberOfElements;
        }

        public void setPage(int page) {
            this.page = page;
        }

        public void setTotalElements(int totalElements) {
            this.totalElements = totalElements;
        }

        public void setFinalPage(boolean finalPage) {
            this.finalPage = finalPage;
        }

        public void setTotalPages(int totalPages) {
            this.totalPages = totalPages;
        }

        public void setSize(int size) {
            this.size = size;
        }

        public int getNumberOfElements() {
            return numberOfElements;
        }

        public int getPage() {
            return page;
        }

        public int getTotalElements() {
            return totalElements;
        }

        public boolean isFinalPage() {
            return finalPage;
        }

        public int getTotalPages() {
            return totalPages;
        }

        public int getSize() {
            return size;
        }
    }
}
