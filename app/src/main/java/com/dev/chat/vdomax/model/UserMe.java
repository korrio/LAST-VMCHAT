package com.dev.chat.vdomax.model;

/**
 * Created by Mac on 7/8/15.
 */
public class UserMe {


    /**
     * count : {"love":10,"following":77,"follower":27,"post":475,"group":0,"friend":8}
     * status : 1
     * user : {"birthday":"01/01/1990","email_verified":"1","about":"hdhdh","type":"user","password":"039a726ac0aeec3dde33e45387a7d4ac","avatar_id":"108899","online":false,"id":"6","timestamp":"2015-07-03 00:48:31","cover_position":"157","time":"1413297961","timezone":"Pacific/Midway","username":"korrio","cover":"photos/2015/01/64Ter_94385_35a4e28b82263cf441601c2cca9aa6cc_cover.jpg","verified":"0","name":"korr korr","gender":"male","email_verification_key":"48150dc85ae1fafb39a3f10be72c6728","avatar":"photos/2015/04/pr8af_108899_c04356ab5e9726bb6e650e5b9cc17cbc_100x100.jpg","live_url":"","last_logged":"1435884511","email":"idolkorrio@gmail.com","active":"1","is_live":false,"language":"thai","cover_id":"94385"}
     */
    private CountEntity count;
    private String status;
    private UserEntity user;

    public void setCount(CountEntity count) {
        this.count = count;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public CountEntity getCount() {
        return count;
    }

    public String getStatus() {
        return status;
    }

    public UserEntity getUser() {
        return user;
    }

    public class CountEntity {
        /**
         * love : 10
         * following : 77
         * follower : 27
         * post : 475
         * group : 0
         * friend : 8
         */
        private int love;
        private int following;
        private int follower;
        private int post;
        private int group;
        private int friend;

        public void setLove(int love) {
            this.love = love;
        }

        public void setFollowing(int following) {
            this.following = following;
        }

        public void setFollower(int follower) {
            this.follower = follower;
        }

        public void setPost(int post) {
            this.post = post;
        }

        public void setGroup(int group) {
            this.group = group;
        }

        public void setFriend(int friend) {
            this.friend = friend;
        }

        public int getLove() {
            return love;
        }

        public int getFollowing() {
            return following;
        }

        public int getFollower() {
            return follower;
        }

        public int getPost() {
            return post;
        }

        public int getGroup() {
            return group;
        }

        public int getFriend() {
            return friend;
        }
    }

    public class UserEntity {
        /**
         * birthday : 01/01/1990
         * email_verified : 1
         * about : hdhdh
         * type : user
         * password : 039a726ac0aeec3dde33e45387a7d4ac
         * avatar_id : 108899
         * online : false
         * id : 6
         * timestamp : 2015-07-03 00:48:31
         * cover_position : 157
         * time : 1413297961
         * timezone : Pacific/Midway
         * username : korrio
         * cover : photos/2015/01/64Ter_94385_35a4e28b82263cf441601c2cca9aa6cc_cover.jpg
         * verified : 0
         * name : korr korr
         * gender : male
         * email_verification_key : 48150dc85ae1fafb39a3f10be72c6728
         * avatar : photos/2015/04/pr8af_108899_c04356ab5e9726bb6e650e5b9cc17cbc_100x100.jpg
         * live_url :
         * last_logged : 1435884511
         * email : idolkorrio@gmail.com
         * active : 1
         * is_live : false
         * language : thai
         * cover_id : 94385
         */
        private String birthday;
        private String email_verified;
        private String about;
        private String type;
        private String password;
        private String avatar_id;
        private boolean online;
        private String id;
        private String timestamp;
        private String cover_position;
        private String time;
        private String timezone;
        private String username;
        private String cover;
        private String verified;
        private String name;
        private String gender;
        private String email_verification_key;
        private String avatar;
        private String live_url;
        private String last_logged;
        private String email;
        private String active;
        private boolean is_live;
        private String language;
        private String cover_id;

        public void setBirthday(String birthday) {
            this.birthday = birthday;
        }

        public void setEmail_verified(String email_verified) {
            this.email_verified = email_verified;
        }

        public void setAbout(String about) {
            this.about = about;
        }

        public void setType(String type) {
            this.type = type;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public void setAvatar_id(String avatar_id) {
            this.avatar_id = avatar_id;
        }

        public void setOnline(boolean online) {
            this.online = online;
        }

        public void setId(String id) {
            this.id = id;
        }

        public void setTimestamp(String timestamp) {
            this.timestamp = timestamp;
        }

        public void setCover_position(String cover_position) {
            this.cover_position = cover_position;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public void setTimezone(String timezone) {
            this.timezone = timezone;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public void setCover(String cover) {
            this.cover = cover;
        }

        public void setVerified(String verified) {
            this.verified = verified;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public void setEmail_verification_key(String email_verification_key) {
            this.email_verification_key = email_verification_key;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        public void setLive_url(String live_url) {
            this.live_url = live_url;
        }

        public void setLast_logged(String last_logged) {
            this.last_logged = last_logged;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public void setActive(String active) {
            this.active = active;
        }

        public void setIs_live(boolean is_live) {
            this.is_live = is_live;
        }

        public void setLanguage(String language) {
            this.language = language;
        }

        public void setCover_id(String cover_id) {
            this.cover_id = cover_id;
        }

        public String getBirthday() {
            return birthday;
        }

        public String getEmail_verified() {
            return email_verified;
        }

        public String getAbout() {
            return about;
        }

        public String getType() {
            return type;
        }

        public String getPassword() {
            return password;
        }

        public String getAvatar_id() {
            return avatar_id;
        }

        public boolean isOnline() {
            return online;
        }

        public String getId() {
            return id;
        }

        public String getTimestamp() {
            return timestamp;
        }

        public String getCover_position() {
            return cover_position;
        }

        public String getTime() {
            return time;
        }

        public String getTimezone() {
            return timezone;
        }

        public String getUsername() {
            return username;
        }

        public String getCover() {
            return cover;
        }

        public String getVerified() {
            return verified;
        }

        public String getName() {
            return name;
        }

        public String getGender() {
            return gender;
        }

        public String getEmail_verification_key() {
            return email_verification_key;
        }

        public String getAvatar() {
            return avatar;
        }

        public String getLive_url() {
            return live_url;
        }

        public String getLast_logged() {
            return last_logged;
        }

        public String getEmail() {
            return email;
        }

        public String getActive() {
            return active;
        }

        public boolean isIs_live() {
            return is_live;
        }

        public String getLanguage() {
            return language;
        }

        public String getCover_id() {
            return cover_id;
        }
    }
}
