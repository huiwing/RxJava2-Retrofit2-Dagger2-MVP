package com.lxcx.rxjava2demo.bean;

import java.util.List;

/**
 * TestBean
 * Created by ArmyAntAndroid on 2017/11/17.
 */

public class TestBean {
    private int resultCode;
    private List<Child> data;
    private String msg;

    public TestBean() {
    }

    public TestBean(int resultCode, List<Child> data, String msg) {
        this.resultCode = resultCode;
        this.data = data;
        this.msg = msg;
    }

    public int getResultCode() {
        return resultCode;
    }

    public void setResultCode(int resultCode) {
        this.resultCode = resultCode;
    }

    public List<Child> getData() {
        return data;
    }

    public void setData(List<Child> data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "TestBean{" +
                "resultCode=" + resultCode +
                ", data=" + data +
                ", msg='" + msg + '\'' +
                '}';
    }

    class Child{
        private int id;
        private String title;
        private String content;
        private String author;
        private int typeCode;
        private int likes;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public int getTypeCode() {
            return typeCode;
        }

        public void setTypeCode(int typeCode) {
            this.typeCode = typeCode;
        }

        public int getLikes() {
            return likes;
        }

        public void setLikes(int likes) {
            this.likes = likes;
        }

        @Override
        public String toString() {
            return "Child{" +
                    "id=" + id +
                    ", title='" + title + '\'' +
                    ", content='" + content + '\'' +
                    ", author='" + author + '\'' +
                    ", typeCode=" + typeCode +
                    ", likes=" + likes +
                    '}';
        }
    }
}
