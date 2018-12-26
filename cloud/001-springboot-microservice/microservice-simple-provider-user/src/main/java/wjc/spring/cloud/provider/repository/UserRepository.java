package wjc.spring.cloud.provider.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import wjc.spring.cloud.provider.entity.User;

/**
 * @author: wangjunchao(王俊超)
 * @time: 2018-12-26 14:05
 **/
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}

