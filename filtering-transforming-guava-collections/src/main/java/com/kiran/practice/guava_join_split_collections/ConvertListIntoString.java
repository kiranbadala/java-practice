package com.kiran.practice.guava_join_split_collections;

import java.util.List;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;

/**
 * Hello world!
 *
 */
public class ConvertListIntoString 
{
    public static void main( String[] args )
    {
    	List<String> strList = Lists.newArrayList("a", "b","c","d",null);
    	System.out.println(Joiner.on(',').skipNulls().join(strList));
    }
}
