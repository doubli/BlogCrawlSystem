package edu.xiyou.BCS.model;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * Created by andrew on 15-12-8.
 */
public class BaseModel implements Serializable{
	
	private static final long serialVersionUID = -4596283941677556602L;

	@Override
    public String toString(){
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
