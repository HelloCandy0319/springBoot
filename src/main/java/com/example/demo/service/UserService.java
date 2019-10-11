package com.example.demo.service;

import com.example.demo.entity.cloudTest.*;
import com.example.demo.event.RegisterUserEvent;
import com.example.demo.repository.cloudTest.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;


@Service
public class UserService {
    private final static Logger logger = LoggerFactory.getLogger(UserService.class);
    @Autowired
    private UserRepository userRepository;

    @Autowired
    ApplicationContext applicationContext;

    @Autowired
    @Qualifier("cloudTestEntityManagerFactory")
    LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean;

    @Autowired
    @Qualifier("cloudEntityManager")
    EntityManager entityManager;

    public List<User> userList(){
        logger.info("获取用户信息");
        return userRepository.findAll();
    }

    public List<User> findUsersGrants(int age){
        logger.info("查找年龄大于"+age+"的人");
        return userRepository.findUsersGrants(age);
    }

    /**
     * 注册用户
     * @param user
     */
    public void register(User user){
        userRepository.save(user);
        applicationContext.publishEvent(new RegisterUserEvent(this,user));
    }

    public User findUser(Long userId){
        return userRepository.findOne(userId);
    }

    public List<User> findUserInfo(User user){
        Specification<User> specification =  new Specification<User>() {
            @Override
            public Predicate toPredicate(Root<User> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                // equal
                if (user.getUsername()!=null){

                    Predicate userNamePredicate = criteriaBuilder.equal(root.get("username"),user.getUsername());
                    predicates.add(userNamePredicate);
                }
                // like
                if (user.getPassword()!=null){
                    Predicate passwordPredicate = criteriaBuilder.like(root.get("password"),"%"+user.getPassword()+"%");
                    predicates.add(passwordPredicate);
                }
                //between
                if (user.getAge()!=null){
                    Predicate agePredicate = criteriaBuilder.between(root.get("age"),user.getAge(),30);
                    predicates.add(agePredicate);
                }
                //关联表
                if (user.getId()!=null){
//                    Join<User,RoleAndUser> roleAndUserJoin = root.join(User_.roleAndUser);
//                    Predicate predicate =  criteriaBuilder.equal(roleAndUserJoin.get(RoleAndUser_.id),1);
//                    predicates.add(predicate);
                    Join<User,RoleAndUser> userJoin = root.join(root.getModel().getSingularAttribute("user",RoleAndUser.class),JoinType.LEFT);
                    predicates.add(criteriaBuilder.equal(userJoin.get("userId").as(Long.class), 1L));
                }
                Predicate[] predicate = new Predicate[predicates.size()];
                return criteriaQuery.where(predicates.toArray(predicate)).getRestriction();
            }
        };
        return userRepository.findAll(specification);
    }
}
