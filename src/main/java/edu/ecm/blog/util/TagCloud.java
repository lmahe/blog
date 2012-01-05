package edu.ecm.blog.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections; 

public class TagCloud {
    private List<String> tags = new ArrayList<String>();

    
    public void add(String... strings) {
    	if (strings==null)
    	{
    		return;
    	}
    	for(String element : strings)
    	{
    		if ((tags.contains(element)==false) && (element!=null) && (element!="") )
    		{
    			tags.add(element);
    		}
    	}	
    }

    

    public int size() {
        return tags.size();
    }
    
    public boolean contains(String tag)
    {
    	return tags.contains(tag);
    }
    
    public void top(int size)
    {
    	if (size < 0)
    	{
    		this.tags.clear();
    	}
    	else if (size < tags.size())
    	{
    		this.tags.subList(size, tags.size()).clear();
    	}
    	
    }
    
    public void shuffle()
    {
    	Collections.shuffle(this.tags);
    }
}
