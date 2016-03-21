package com.mfra.dice.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "MyRequest", namespace="http://your.namespace.com")
public class MyRequest {
    
    @XmlElement(name = "name", required = true)
    protected String name;
    @XmlElement(name = "faces", required = true)
    protected int faces;
    @XmlElement(name = "repetitions", required = false)
    protected int repetitions;
    @XmlElement(name = "modifier", required = false)
    protected int modifier;
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getFaces() {
        return faces;
    }
    public void setFaces(int faces) {
        this.faces = faces;
    }
    public int getRepetitions() {
        return repetitions;
    }
    public void setRepetitions(int repetitions) {
        this.repetitions = repetitions;
    }
    public int getModifier() {
        return modifier;
    }
    public void setModifier(int modifier) {
        this.modifier = modifier;
    }
    
        
}
