package com.example.spring.framework.scope;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * Author: 王俊超
 * Date: 2017-07-10 22:38
 * All Rights Reserved !!!
 */
@Service
@Scope("prototype")
public class DemoPrototypeService {
}
