package com.shoplive.task;

import com.shoplive.task.entitiy.TestEntity;
import com.shoplive.task.repository.TestRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

@SpringBootTest
public class RedisTest {
    @Autowired
    private TestRepository testRepository;
    @Test
    public void redisTest() {
//        assertThrows(ArithmeticException.class, () -> {
//            TestEntity test = new TestEntity("test", "테스트");
//
//            TestEntity afterTest = testRepository.save(test);
//
//            Optional<TestEntity> testEntityOptional = testRepository.findById(afterTest.getId());
//
//            assertThat(testEntityOptional.isPresent());
//            assertThat(testEntityOptional.get().getTitle());
//        });

    }
}
