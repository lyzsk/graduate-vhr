# JAVA-vhr
- [JAVA vhr](#JAVA-vhr)
- [Screenshots](#Screenshots)
- [Intro](#Intro)
- [Key tech](#Key-tech)
- [Installation](#Installation)
- [Dev Enviorment](#Dev-Enviorment)
- [How to use](#how-to-use)

# Screenshoots
- ![Image text](https://github.com/lyzsk/graduate-vhr/blob/master/screenshot/1.gif)
- ![Image text](https://github.com/lyzsk/graduate-vhr/blob/master/screenshot/2.gif)
- ![Image text](https://github.com/lyzsk/graduate-vhr/blob/master/screenshot/3.gif)
- ![Image text](https://github.com/lyzsk/graduate-vhr/blob/master/screenshot/4.gif)
- ![Image text](https://github.com/lyzsk/graduate-vhr/blob/master/screenshot/5.gif)
- ![Image text](https://github.com/lyzsk/graduate-vhr/blob/master/screenshot/6.gif)
- ![Image text](https://github.com/lyzsk/graduate-vhr/blob/master/screenshot/7.gif)
- [(Back to top)](#JAVA-vhr)

# Intro
- 施工中
- image verification code for login
- add `employee`, `departemtn`, `position`, `admin`, etc with informations
- search `employee`, `departemtn`, `position`, `admin`, etc with informations
- define `salary` with model or by hand
- download csv file through website
- online chat with hr
- auto email when new employee added (still debugging)
    
- [(Back to top)](#JAVA-vhr)

# Key tech
- PASSWORD ADD SALT && ENCODER
    - user password use SpringSecurity.BCryptPasswordEncoder
    ```java
    public boolean updateHrPasswd(String oldpass, String pass, Integer hrid) {
        Hr hr = hrMapper.selectByPrimaryKey(hrid);
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        if (encoder.matches(oldpass, hr.getPassword())) {
            String encodePass = encoder.encode(pass);
            Integer result = hrMapper.updatePasswd(hrid, encodePass);
            if (result == 1) {
                return true;
            }
        }
        return false;
    }
    ```

    - when login, the password should do security encoding
    ```java
    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(hrService);
    }
    ```

- SpringMVC receive Date object from frontend, server need to convert this object

    - 1. Converter implemention
    ```java
    @Component
    public class DateConverter implements Converter<String, Date> {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        @Override
        public Date convert(String source) {
            try {
                return sdf.parse(source);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            return null;
        }
    }
    ```

    - 2. WebSocketConfig configuration
    ```java
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/ws/ep").setAllowedOrigins("http://localhost:8080").withSockJS();
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.enableSimpleBroker("/queue");
    }
    ```


- [(Back to top)](#JAVA-vhr)

# Installation
- [(Back to top)](#JAVA-vhr)

# Dev Enviorment
- JDK 1.8
- SpringBoot 2.4.0
- druid 1.1.10
- mybatis 1.4.1
- fastdfs-client-java 1.27.0.0
- mysql 8.0.28
- redis
- node js 12.14.0
- DBeaver
- snipaste
- screentogif
- [(Back to top)](#JAVA-vhr)

# How to use
- !施工中!
- [(Back to top)](#JAVA-vhr)