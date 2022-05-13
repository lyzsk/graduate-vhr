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
- HR model design to implement org.springframework.security.core.userdetails.UserDetails
Because the bussiness logic don't need to do 1. lock user || 2. password timeout, we only need to
define if the account is diabled or not, hence, every ```isEnable``` I set as ```boolean=true```.

- The key of implementing UserDetails is to override the getAuthorities, we use this to get the `role` of the current user.
```java
    @Override
    @JsonIgnore
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> authorities = new ArrayList<>(roles.size());
        for (Role role : roles) {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        }
        return authorities;
    }
```
- 即直接从roles中获取当前用户所具有的角色，构造SimpleGrantedAuthority然后返回即可。

- Then in HrService we also need to implements UserDetailsService, and the key part is:
    - according to Username to find if user is exist or not, or throw UsernameNotFoundException
```java
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Hr hr = hrMapper.loadUserByUsername(username);
        if (hr == null) {
            throw new UsernameNotFoundException("用户名不存在!");
        }
        hr.setRoles(hrMapper.getHrRolesById(hr.getId()));
        return hr;
    }
```

- CustomFilterInvocationSecurityMetadataSource

    - 1.一开始注入了MenuService，MenuService的作用是用来查询数据库中url pattern和role的对应关系，查询结果是一个List集合，集合中是Menu类，Menu类有两个核心属性，一个是url pattern，即匹配规则(比如/admin/**)，还有一个是List,即这种规则的路径需要哪些角色才能访问。

    - 2.我们可以从getAttributes(Object o)方法的参数o中提取出当前的请求url，然后将这个请求url和数据库中查询出来的所有url pattern一一对照，看符合哪一个url pattern，然后就获取到该url pattern所对应的角色，当然这个角色可能有多个，所以遍历角色，最后利用SecurityConfig.createList方法来创建一个角色集合。

    - 3.第二步的操作中，涉及到一个优先级问题，比如我的地址是/employee/basic/hello,这个地址既能被/employee/**匹配，也能被/employee/basic/**匹配，这就要求我们从数据库查询的时候对数据进行排序，将/employee/basic/**类型的url pattern放在集合的前面去比较。

    - 4.如果getAttributes(Object o)方法返回null的话，意味着当前这个请求不需要任何角色就能访问，甚至不需要登录。但是在我的整个业务中，并不存在这样的请求，我这里的要求是，所有未匹配到的路径，都是认证(登录)后可访问，因此我在这里返回一个ROLE_LOGIN的角色，这种角色在我的角色数据库中并不存在，因此我将在下一步的角色比对过程中特殊处理这种角色。

    - 5.如果地址是/login_p，这个是登录页，不需要任何角色即可访问，直接返回null。

    - 6.getAttributes(Object o)方法返回的集合最终会来到CustomUrlDecisionManager类中
```java
@Component
public class CustomFilterInvocationSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {
    @Autowired
    MenuService menuService;
    AntPathMatcher antPathMatcher = new AntPathMatcher();

    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
        String requestUrl = ((FilterInvocation)object).getRequestUrl();
        List<Menu> menus = menuService.getAllMenusWithRole();
        for (Menu menu : menus) {
            if (antPathMatcher.match(menu.getUrl(), requestUrl)) {
                List<Role> roles = menu.getRoles();
                String[] str = new String[roles.size()];
                for (int i = 0; i < roles.size(); i++) {
                    str[i] = roles.get(i).getName();
                }
                return SecurityConfig.createList(str);
            }
        }
        return SecurityConfig.createList("ROLE_LOGIN");
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return true;
    }
}
```

- CustomUrlDecisionManager

    - 1.decide方法接收三个参数，其中第一个参数中保存了当前登录用户的角色信息，第三个参数则是CustomFilterInvocationSecurityMetadataSource中的getAttributes方法传来的，表示当前请求需要的角色(可能有多个)

    - 2.如果当前请求需要的权限为`ROLE_LOGIN`则表示登录即可访问，和角色没有关系，此时我需要判断authentication是不是AnonymousAuthenticationToken的一个实例，如果是，则表示当前用户没有登录，没有登录就抛一个BadCredentialsException异常，登录了就直接返回，则这个请求将被成功执行

    - 3.遍历collection，同时查看当前用户的角色列表中是否具备需要的权限，如果具备就直接返回，否则就抛异常

    - 4.这里涉及到一个all和any的问题：假设当前用户具备角色A、角色B，当前请求需要角色B、角色C，那么是要当前用户要包含所有请求角色才算授权成功还是只要包含一个就算授权成功？我这里采用了第二种方案，即只要包含一个即可。可根据自己的实际情况调整decide方法中的逻辑
```java
@Component
public class CustomUrlDecisionManager implements AccessDecisionManager {
    @Override
    public void decide(Authentication authentication, Object object, Collection<ConfigAttribute> configAttributes)
        throws AccessDeniedException, InsufficientAuthenticationException {
        for (ConfigAttribute configAttribute : configAttributes) {
            String needRole = configAttribute.getAttribute();
            if ("ROLE_LOGIN".equals(needRole)) {
                if (authentication instanceof AnonymousAuthenticationToken) {
                    throw new AccessDeniedException("尚未登录，请登录!");
                } else {
                    return;
                }
            }
            Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
            for (GrantedAuthority authority : authorities) {
                if (authority.getAuthority().equals(needRole)) {
                    return;
                }
            }
        }
        throw new AccessDeniedException("权限不足，请联系管理员!");
    }

    @Override
    public boolean supports(ConfigAttribute attribute) {
        return true;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return true;
    }
}
```

- 接下来就是配置 SecurityConfig

    - 1.在configure(HttpSecurity http)方法中，通过withObjectPostProcessor将刚刚创建的UrlFilterInvocationSecurityMetadataSource和UrlAccessDecisionManager注入进来。到时候，请求都会经过刚才的过滤器（除了configure(WebSecurity web)方法忽略的请求）

    - 2.successHandler中配置登录成功时返回的JSON，登录成功时返回当前用户的信息。

    - 3.failureHandler表示登录失败，登录失败的原因可能有多种，我们根据不同的异常输出不同的错误提示即可。

- Because front and backend are seperated, we need to return JSON to backend, so we can 
find error exception in server.
    - For example, if admin want to delete one `role`, and in this role, there are associated user
    or resources, then because `constraints on foreign keys` in the db, there will be exceptions.
    When delete failed , throws DataIntegrityViolationException, and in server we catch this and do things

```java
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(SQLException.class)
    public RespBean sqlException(SQLException e) {
        if (e instanceof SQLIntegrityConstraintViolationException) {
            return RespBean.error("该数据有关联数据，操作失败!");
        }
        return RespBean.error("数据库异常，操作失败!");
    }
}
```

- javaboy's orgin is to use WebMvcConfig to register the global exception as a Bean, here we register as a RespBean type. Using `RespBean` meaning it will be called when response send, we do not need to use another class including @Configuration @Bean to set @Component

- [(Back to top)](#JAVA-vhr)

# Installation
- [(Back to top)](#JAVA-vhr)

# Dev Enviorment
- Backend:
    - JDK 1.8
    - SpringBoot 2.4.0
    - druid 1.1.10
    - mybatis 1.4.1
    - fastdfs-client-java 1.27.0.0
    - mysql 8.0.28
    - redis
    - RabbitMQ
    - WebSocket
    - DBeaver
    - snipaste
    - screentogif

- Frontend:
    - node js 12.14.0
    - Vue
    - ElementUI
    - axios
    - vue-router
    - Vuex
    - WebSocket
    - vue-cli4
- [(Back to top)](#JAVA-vhr)

# How to use
- !施工中!
- [(Back to top)](#JAVA-vhr)