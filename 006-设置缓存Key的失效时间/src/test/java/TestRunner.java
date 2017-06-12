import com.example.spring.boot.redis.AppRunner;
import com.example.spring.boot.redis.TestData;
import com.example.spring.boot.redis.common.KryoRedisSerializer;
import com.example.spring.boot.redis.common.RedisClient;
import com.example.spring.boot.redis.entity.Country;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Author: 王俊超
 * Date: 2017-06-12 21:10
 * All Rights Reserved !!!
 */
@RunWith(SpringRunner.class)
@SpringBootTest( classes = AppRunner.class)
public class TestRunner {
    @Autowired
    RedisClient redisClient;

    @Autowired
    TestData testData;


    /**
     * 测试序列化，反序列化
     */
    @Test
    public void testSerialize() {
        Country c1 = testData.createCountry(TestData.TOWN);
        KryoRedisSerializer<Object> serializer = new KryoRedisSerializer<>();
        byte[] b1 = serializer.serialize(c1);
        Country c2 = (Country) serializer.deserialize(b1);
        Assert.assertNotNull(c2);
        Assert.assertEquals(c1.getId(), c2.getId());
        Assert.assertEquals(c1.getName(), c2.getName());
    }

    @Test
    public void testCachePut() {

        // 先清理缓存
        redisClient.del(TestData.LOCATION, TestData.COUNTRY.getId());
        Country c = redisClient.get(TestData.LOCATION, TestData.COUNTRY.getId());
        Assert.assertNull(c);


        // 创建一个国家
        Country c1 = testData.createCountry(TestData.TOWN);

        // 直接从缓存中取数据，说明数据已经入缓存
        Country c2 = redisClient.get(TestData.LOCATION, TestData.COUNTRY.getId());
        Assert.assertNotNull(c2);
        Assert.assertEquals(c1.getId(), c2.getId());
        Assert.assertEquals(c1.getName(), c2.getName());


    }

    @Test
    public void testCacheGet() {
        // 先清理缓存
        redisClient.del(TestData.LOCATION, TestData.COUNTRY.getId());
        Country c = redisClient.get(TestData.LOCATION, TestData.COUNTRY.getId());
        Assert.assertNull(c);

        // 取数据
        Country c1 = testData.getCountry(TestData.COUNTRY.getId());
        // 从缓存中取
        Country c2 = redisClient.get(TestData.LOCATION, TestData.COUNTRY.getId());

        Assert.assertNotNull(c2);
        Assert.assertEquals(c1.getId(), c2.getId());
        Assert.assertEquals(c1.getName(), c2.getName());
    }

    @Test
    public void testCacheEvict() {
        // 创建一个国家
        Country c = testData.createCountry(TestData.TOWN);
        redisClient.del(TestData.LOCATION, TestData.COUNTRY.getId());
        c = redisClient.get(TestData.LOCATION, TestData.COUNTRY.getId());
        Assert.assertNull(c);
    }
}
