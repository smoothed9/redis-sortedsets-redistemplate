package com.sudeepnm.redis.sortedsets.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Sudeep
 *
 */

@RunWith(MockitoJUnitRunner.class)
public class ControllerTest {

    @Mock
    private StringRedisTemplate redisTemplate;

    @Mock
    private ZSetOperations zOps;
    
    @InjectMocks
    private RedisTemplateSortedSetsController controller;

    @Before
    public void setUp(){
        Mockito.when(redisTemplate.opsForZSet()).thenReturn(zOps);
    }

    /**
     * Test method for {@link com.sudeepnm.redis.sortedsets.service.RedisTemplateSortedSetsController#insertData()}.
     */
    @Test
    public void testInsertDataUpdate() {
        Mockito.when(zOps.add(Mockito.anyString(),
                Mockito.anyString(), Mockito.anyDouble())).thenReturn(true);
        String returnMsg = controller.insertData();
        Assert.assertEquals("Data did not get inserted/updated", "Data Inserted/Updated", returnMsg);
    }

    /**
     * Test method for {@link com.sudeepnm.redis.sortedsets.service.RedisTemplateSortedSetsController#insertData()}.
     */
    @Test
    public void testInsertDataFailure() {
        Mockito.when(zOps.add(Mockito.anyString(),
                Mockito.anyString(), Mockito.anyDouble())).thenReturn(false);
        String returnMsg = controller.insertData();
        Assert.assertEquals("Data did not get updated", "failure", returnMsg);
    }

    /**
     * Test method for {@link com.sudeepnm.redis.sortedsets.service.RedisTemplateSortedSetsController#getRate(java.lang.String, java.lang.String)}.
     */
    @Test
    public void testGetRate() {
        Set<String> dataSet = new HashSet<>();
        dataSet.add("3.00");
        Mockito.when(zOps.reverseRangeByScore(Mockito.anyString(), Mockito.anyDouble(),
                Mockito.anyDouble())).thenReturn(dataSet);

        String rate = controller.getRate("MD", "20170301");
        Assert.assertEquals("Unexpected Rate", "3.00", rate);
    }

}
