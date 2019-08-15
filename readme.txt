此项目采用Springboot+Springsecurity+SpringJPA+Mybaits等框架。
数据源选用阿里的druid 。
配置采用分包方法实现多个数据源
安全方面采用Token.将token+签名，实现token的校验。
日志采用Logback.xml 在拦截器方面对日志进行记录，采用自定义注解+AOP实现异常日志记录.
后续将集成Swagger 框架展示API接口文档
