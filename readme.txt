此项目采用springboot+springsecurity+springJPA+Mybaits等框架。
数据源选用阿里的druid 。
配置采用分包方法实现多个数据源
安全方面采用token.将token+签名，实现token的校验。
日志采用logback.xml 在拦截器方面对日志进行记录，采用自定义注解+AOP实现异常日志记录.
