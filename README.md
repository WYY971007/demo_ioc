Spring的源代码设计精妙，对Java设计模式的灵活运用，对Java术的高深造诣，无疑是Java技术的最佳实践范例;
但在学习spring的过程并不容易，所以想通过自己实现spring的心功能去更好的理解和学习spring的源码;

主要学习的内容为

1、IoC容器
 - 实现IoC配置bean实例的3种方式，读取xm1加载、注解加载、xml和注解混合
 - 使用监听器方式完成ioc的启动;
 - 实现 @Component, @ComponentScan, @Scope, @Autowired注解, BeanDefinition类, ApplicationContext类以及BeanPostProcessor类.
2、AOP的实现
 - 基于Jdk动态代理实现了AOP ，可使用@Aspect注解来配置切面，能实现对同一个方法的多次增强

使用到的设计模式
 - 工厂模式 使用工厂模式 + 配置文件的方式。
 - 单例模式 Spring IOC管理的bean对象都是单例的，此处的单例不是通过构造器进行单例的控制的，而是spring框架对每一个bean只创建了一个对象。
 - 代理模式 
