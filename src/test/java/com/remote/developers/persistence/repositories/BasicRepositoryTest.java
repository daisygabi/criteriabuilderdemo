package com.remote.developers.persistence.repositories;

import com.remote.developers.CriteriaBuilderDemoApplication;
import org.flywaydb.test.FlywayTestExecutionListener;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import javax.transaction.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = CriteriaBuilderDemoApplication.class)
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class, FlywayTestExecutionListener.class})
@Transactional
@ActiveProfiles("test")
public abstract class BasicRepositoryTest extends AbstractTransactionalJUnit4SpringContextTests {
}
