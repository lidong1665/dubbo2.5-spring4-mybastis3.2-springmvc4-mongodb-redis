package com.lidong.dubbo.core.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;

public  class BaseMongoTemplete{


    @Qualifier("mongoTemplate")
    @Autowired
    protected MongoTemplate mongoTemplate;


}