package com.ws.ami.persistence.model;

import java.io.Serializable;

/**
 * Created by hp on 2015/1/6.
 */
public class TestBean implements Serializable{
    private static final long serialVersionUID = -6654373981788109191L;

  /*  public TestBean(String id, String testText)
    {
        this.id =id;
        this.testText = testText;

    }*/

    public TestBean() {

    }


    public TestBean(String id, String testText) {
        this.id = id;
        this.testText = testText;
    }

    String id;
    String testText;

    public String getTestText() {
        return testText;
    }

    public void setTestText(String testText) {
        this.testText = testText;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
